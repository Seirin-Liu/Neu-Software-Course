import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns
from scipy.stats import stats
from sklearn.ensemble import RandomForestClassifier
#读取数据
from sklearn.svm import SVR

'''
train_data,test_data,y_train分别为训练数据、测试数据与训练数据的y值
'''
train_data = pd.read_csv(r"train.csv")
test_data = pd.read_csv(r"test.csv")
y_train = train_data['SalePrice']
combine_data = pd.concat((train_data, test_data)).reset_index(drop=True)
combine_data.drop(['SalePrice', 'Id'], axis=1, inplace=True)
#对数据进行基本的分析
print("总数据的形状为:",combine_data.shape)
print("训练集的形状为:", train_data.shape)
print("字符型属性共有", combine_data.dtypes[combine_data.dtypes == 'object'].value_counts().sum(), "列\n")
print("数值型数据共有", combine_data.dtypes[combine_data.dtypes != 'object'].value_counts().sum(), "列\n")
print("当前数据缺失的列数为:", combine_data.isnull().sum()[combine_data.isnull().sum() > 0].shape[0])
#打印出各列属性缺失值的百分比
print(pd.DataFrame({"missing ratio": combine_data.isnull().sum()[combine_data.isnull().sum() > 0]
                   .sort_values(ascending=False) / combine_data.shape[0]}))
#下面对空值属性列进行填充
#一部分属性为NA的时候,表示房屋没有相应的物品,因此插值为字符串None,如下列代码
combine_data['PoolQC'].fillna("None", inplace=True)
combine_data['MiscFeature'].fillna("None", inplace=True)
combine_data['Alley'].fillna("None", inplace=True)
combine_data['Fence'].fillna("None", inplace=True)
combine_data['FireplaceQu'].fillna("None", inplace=True)
combine_data['LotFrontage'] = combine_data.groupby(['Neighborhood'])['LotFrontage'].transform(
    lambda x: x.fillna(x.median()))
combine_data['GarageQual'].fillna("None", inplace=True)
combine_data['GarageArea'].fillna("None", inplace=True)
combine_data['GarageCars'].fillna("None", inplace=True)
combine_data['GarageCond'].fillna("None", inplace=True)
combine_data['GarageFinish'].fillna("None", inplace=True)
combine_data['GarageType'].fillna("None", inplace=True)
combine_data['BsmtQual'].fillna("None", inplace=True)
combine_data['BsmtExposure'].fillna("None", inplace=True)
combine_data['BsmtCond'].fillna("None", inplace=True)
combine_data['BsmtFinType1'].fillna("None", inplace=True)
combine_data['BsmtFinType2'].fillna("None", inplace=True)
combine_data['MasVnrType'].fillna("None", inplace=True)
#一部分属性为数值类型,NA同样表示没有相应物品,因此填充值为0
combine_data['BsmtFinSF1'].fillna(0, inplace=True)
combine_data['GarageYrBlt'].fillna(0, inplace=True)
combine_data['BsmtFinSF2'].fillna(0, inplace=True)
combine_data['BsmtFullBath'].fillna(0, inplace=True)
combine_data['BsmtHalfBath'].fillna(0, inplace=True)
combine_data['BsmtUnfSF'].fillna(0, inplace=True)
combine_data['TotalBsmtSF'].fillna(0, inplace=True)
combine_data['MasVnrArea'].fillna(0, inplace=True)
# 一部分数据NA作为缺失值,但是该类属性显然不能够插值为0
#比如MSZoning表示确定该项销售的一般分区划分,我们可以使用最长用的类型来进行差值
combine_data['MSZoning'] = combine_data['MSZoning'].fillna(combine_data['MSZoning'].mode()[0])
combine_data['Functional'] = combine_data['Functional'].fillna(combine_data['Functional'].mode()[0])
combine_data['SaleType'] = combine_data['SaleType'].fillna(combine_data['SaleType'].mode()[0])
combine_data['KitchenQual'] = combine_data['KitchenQual'].fillna(combine_data['KitchenQual'].mode()[0])
combine_data['Exterior2nd'] = combine_data['Exterior2nd'].fillna(combine_data['Exterior2nd'].mode()[0])
combine_data['Exterior1st'] = combine_data['Exterior1st'].fillna(combine_data['Exterior1st'].mode()[0])
combine_data['Electrical'] = combine_data['Electrical'].fillna(combine_data['Electrical'].mode()[0])
#Utilities表示可获得的公共服务类型,但是较为特殊,除了一个值以外其余所有值都是相同的,因此对数据整体而言影响不大,为简化删掉即可
del combine_data['Utilities']
print("插值之后缺失的属性列数为:", combine_data.isnull().sum()[combine_data.isnull().sum() > 0].shape[0])

train_data = combine_data[:train_data.shape[0]]
test_data = combine_data[train_data.shape[0]:]
train_data = pd.concat((train_data, y_train), axis=1)
#本题为对某个值的预测,因此是regression类型,我们要用回归方式进行分析,
#回归模型在数据呈正态分布的时候较为适合,在这里查看数据的分布特点
#通过distplot()画出带有分布概论的直方图来分析
fig = plt.figure(figsize=(14, 8))
sns.distplot((train_data['SalePrice']))
plt.show()
#上图发现数据的分布显然有较大的偏差,并不均匀,此时常用有两种方法,一种是对数据做对数处理,另一种是
# 通过boxcox1p将其还原为正态分布,在这里我们使用了log方法
#下图是对数据取对数之后的直方图
sns.distplot(np.log((train_data['SalePrice'])))
plt.show()
#取对数之后显然数据开始符合正态分布
#需要知道那些属性之间有着强烈相互关联以及那些属性与SalePrice有着强关联,画出热力图来进行可视化分析
corrmat = abs(train_data.corr())
plt.subplots(figsize=(12, 9))
sns.heatmap(corrmat, vmax=0.9, square=True)
plt.show()
#找出了10个与SalePrice关系较大的属性绘制热力图
k  = 10 # 关系矩阵中将显示10个特征
cols = corrmat.nlargest(k, 'SalePrice')['SalePrice'].index
cm = np.corrcoef(train_data[cols].values.T)
sns.set(font_scale=1.25)
hm = sns.heatmap(cm, cbar=True, annot=True, \
                 square=True, fmt='.2f', annot_kws={'size': 10}, yticklabels=cols.values, xticklabels=cols.values)
plt.show()
#但是由于属性太多,热力图不能够直观地给出众多属性关系的大小,因此画出了一个条形图来直观地分析
fig = plt.figure(figsize=(14,8))
abs(train_data.corr()['SalePrice']).sort_values(ascending=False).plot.bar()
plt.xticks(fontsize=20)
plt.yticks(fontsize=20)
plt.show()
'''从上图中终于可以直观地看到各属性与SalePrice的关系,在这里我们针对关系系数>0.4的15个属性进行了一一分析
    通过每个属性删除一半离群值的方法来清洗数据
   删除一半的原因:并不确定测试集中是否有离群值,如果把所有离群值都删除掉,就不能够对测试机中的离群值做出预测
   我们会先绘制出散点图,然后判断出离群点进行删除
'''
# GrLivArea对Saleprice具体影响的分析,绘制散点图查看
fig, ax = plt.subplots()
ax.scatter(train_data['GrLivArea'], train_data['SalePrice'])
plt.ylabel('SalePrice', fontsize=13)
plt.xlabel('GrLivArea', fontsize=13)
plt.show()
# 发现在图的右下角有非常离群的两个点,面积大而价格低,在这里删除这两条数据
train_data = train_data.drop(train_data[(train_data['GrLivArea'] > 5000) & (train_data['SalePrice'] < 300000)].index)

# 再次查看数据散点图
fig, ax = plt.subplots()
ax.scatter(train_data['GrLivArea'], train_data['SalePrice'])
plt.ylabel('SalePrice', fontsize=13)
plt.xlabel('GrLivArea', fontsize=13)
plt.show()

# GarageArea对Saleprice具体影响的分析,绘制散点图查看
fig, ax = plt.subplots()
ax.scatter(train_data['GarageArea'], train_data['SalePrice'])
plt.ylabel('SalePrice', fontsize=13)
plt.xlabel('GarageArea', fontsize=13)
plt.show()

# 发现在图的右下角有非常离群的三个点，在这里删除这三条数据
train_data = train_data.drop(train_data[(train_data['GarageArea'] > 1300) & (train_data['SalePrice'] < 300000)].index)

# 再次查看数据散点图
fig, ax = plt.subplots()
ax.scatter(train_data['GarageArea'], train_data['SalePrice'])
plt.ylabel('SalePrice', fontsize=13)
plt.xlabel('GarageArea', fontsize=13)
plt.show()

# TotalBsmtSF对Saleprice具体影响的分析,绘制散点图查看
fig, ax = plt.subplots()
ax.scatter(train_data['TotalBsmtSF'], train_data['SalePrice'])
plt.ylabel('SalePrice', fontsize=13)
plt.xlabel('TotalBsmtSF', fontsize=13)
plt.show()

# 发现在图的右下角有非常离群的一个点,在这里删除这一条数据
train_data = train_data.drop(train_data[(train_data['TotalBsmtSF'] > 5000) & (train_data['SalePrice'] < 300000)].index)

# 再次查看数据散点图
fig, ax = plt.subplots()
ax.scatter(train_data['TotalBsmtSF'], train_data['SalePrice'])
plt.ylabel('SalePrice', fontsize=13)
plt.xlabel('TotalBsmtSF', fontsize=13)
plt.show()

# 1stFlrSF对Saleprice具体影响的分析,绘制散点图查看
fig, ax = plt.subplots()
ax.scatter(train_data['1stFlrSF'], train_data['SalePrice'])
plt.ylabel('SalePrice', fontsize=13)
plt.xlabel('1stFlrSF', fontsize=13)
plt.show()

# 发现在图的右下角有非常离群的一个点,在这里删除这一条数据
train_data = train_data.drop(train_data[(train_data['1stFlrSF'] > 4000) & (train_data['SalePrice'] < 300000)].index)

# 再次查看数据散点图
fig, ax = plt.subplots()
ax.scatter(train_data['1stFlrSF'], train_data['SalePrice'])
plt.ylabel('SalePrice', fontsize=13)
plt.xlabel('1stFlrSF', fontsize=13)
plt.show()

# YearBuilt对Saleprice具体影响的分析,绘制散点图查看
fig, ax = plt.subplots()
ax.scatter(train_data['YearBuilt'], train_data['SalePrice'])
plt.ylabel('SalePrice', fontsize=13)
plt.xlabel('YearBuilt', fontsize=13)
plt.show()
# 未发现异常值

# YearRemodAdd对Saleprice具体影响的分析,绘制散点图查看
fig, ax = plt.subplots()
ax.scatter(train_data['YearRemodAdd'], train_data['SalePrice'])
plt.ylabel('SalePrice', fontsize=13)
plt.xlabel('YearRemodAdd', fontsize=13)
plt.show()
# 未发现异常值

# GarageYrBlt对Saleprice具体影响的分析,绘制散点图查看
fig, ax = plt.subplots()
ax.scatter(train_data['GarageYrBlt'], train_data['SalePrice'])
plt.ylabel('SalePrice', fontsize=13)
plt.xlabel('GarageYrBlt', fontsize=13)
plt.show()
# 未发现异常值

# MasVnrArea对Saleprice具体影响的分析,绘制散点图查看
fig, ax = plt.subplots()
ax.scatter(train_data['MasVnrArea'], train_data['SalePrice'])
plt.ylabel('SalePrice', fontsize=13)
plt.xlabel('MasVnrArea', fontsize=13)
plt.show()

# 删去左上角和右下角的两个离群点
train_data = train_data.drop(train_data[(train_data['MasVnrArea'] > 1500) & (train_data['SalePrice'] < 300000)].index)
train_data = train_data.drop(train_data[(train_data['MasVnrArea'] < 400) & (train_data['SalePrice'] > 700000)].index)

# 再次查看数据散点图
fig, ax = plt.subplots()
ax.scatter(train_data['MasVnrArea'], train_data['SalePrice'])
plt.ylabel('SalePrice', fontsize=13)
plt.xlabel('MasVnrArea', fontsize=13)
plt.show()

# BsmtFinSF1对Saleprice具体影响的分析,绘制散点图查看
fig, ax = plt.subplots()
ax.scatter(train_data['BsmtFinSF1'], train_data['SalePrice'])
plt.ylabel('SalePrice', fontsize=13)
plt.xlabel('BsmtFinSF1', fontsize=13)
plt.show()

# 删去左上角和右下角的两个离群点
train_data = train_data.drop(train_data[(train_data['BsmtFinSF1'] > 5000) & (train_data['SalePrice'] < 300000)].index)

# 再次查看数据散点图
fig, ax = plt.subplots()
ax.scatter(train_data['BsmtFinSF1'], train_data['SalePrice'])
plt.ylabel('SalePrice', fontsize=13)
plt.xlabel('BsmtFinSF1', fontsize=13)
plt.show()
#此时对数据的离群点清除完毕,我们注意到数据中有40多列的字符串数据,
#这些数据显然不能够进行正常的数据分析回归处理,因此我们首先需要把它们
#转化为离散值,然后进行处理
from sklearn.preprocessing import LabelEncoder
train_shape = train_data.shape[0]
combine_data = pd.concat((train_data,test_data))
cols = combine_data.dtypes[combine_data.dtypes=='object'].index
for col in cols:
    lbl = LabelEncoder()
    lbl.fit(list(combine_data[col].values))
    combine_data[col] = lbl.transform(list(combine_data[col].values))
train_data = combine_data[:train_shape]
test_data = combine_data[train_shape:]

cols = list(cols)
cols.append("SalePrice")

#我们注意到有部分数据虽然是数值类型的,但实际上取值范围是一个离散值,表示的是分类,如MSSubClass属性
#通过20-190 之间16个不同的值表示了确定买卖中涉及的住宅类型,我们在这里将其转化为离散类型
combine_data['MSSubClass'].astype(str)
lbl = LabelEncoder()
lbl.fit(list(combine_data['MSSubClass'].values))
combine_data['MSSubClass'] = lbl.transform(combine_data['MSSubClass'].values)

#在这里,我们对离散类型变量做利用get_dummies做独热编码处理
for col in cols:
    if(col=='SalePrice'):continue
    combine_data[col]=combine_data[col].apply(str)
combine_data = pd.get_dummies(combine_data)

train_data_size = train_data.shape[0]
train_data = combine_data[:train_data_size]
test_data = combine_data[train_data_size:]
y_train = np.log(train_data['SalePrice'])
del test_data['SalePrice']
del train_data['SalePrice']


#建模回归、预测
from sklearn.linear_model import ElasticNet, Lasso, Ridge, BayesianRidge
from sklearn.ensemble import  GradientBoostingRegressor
from sklearn.kernel_ridge import KernelRidge
from sklearn.pipeline import make_pipeline
from sklearn.preprocessing import RobustScaler
from sklearn.base import BaseEstimator, TransformerMixin, RegressorMixin, clone
from sklearn.model_selection import KFold, cross_val_score
#K折交叉验证
'''
    1.交叉验证用于评估模型的预测性能，尤其是训练好的模型在新数据上的表现，可以在一定程度上减小过拟合。
    2.还可以从有限的数据中获取尽可能多的有效信息。
'''
n_folds = 5
def verify_model(model):
    kf = KFold(n_folds, shuffle=True, random_state=42).get_n_splits(train_data.values)
    outcome = np.sqrt(-cross_val_score(model, train_data.values, y_train.values, scoring="neg_mean_squared_error", cv=kf))
    return outcome


# 训练Lasso模型(一种压缩估计方法,它通过构造一个惩罚函数得到一个较为精炼的模型)
lasso = make_pipeline(RobustScaler(), Lasso(alpha=0.0005, random_state=1))
LassoScore = verify_model(lasso)
print("Lasso Score: ", LassoScore.mean())

# Elastic Net Regression（弹性网回归）
ENet = make_pipeline(RobustScaler(), ElasticNet(alpha=0.0005, l1_ratio=.9, random_state=3))
ENetScore = verify_model(ENet)
print("ENet Score: ", ENetScore.mean())
#Kernel Ridge Regression（核岭回归）
KRR = KernelRidge(alpha=0.6, kernel='polynomial', degree=2, coef0=2.5)
KRRScore = verify_model(KRR)
print("KRR Score: ",KRRScore.mean())

# Gradient Boosting Regression （梯度增强回归）：
GBoost = GradientBoostingRegressor(n_estimators=3000, learning_rate=0.05,
                                   max_depth=4, max_features='sqrt',
                                   min_samples_leaf=15, min_samples_split=10,
                                   loss='huber', random_state=5)
GBoostScore = verify_model(GBoost)
print("GBoost Score: ", GBoostScore.mean())

#
ridge = Ridge(alpha=60)
ridgeScore = verify_model(ridge)
print("ridge score", ridgeScore.mean())

#
svr = SVR(gamma= 0.0004,kernel='rbf',C=13,epsilon=0.009)
svrScore = verify_model(svr)
print("svr score", svrScore.mean())

#
ela = ElasticNet(alpha=0.005,l1_ratio=0.08,max_iter=10000)
elaScore = verify_model(ela)
print("ela Score", elaScore.mean())

#
bay = BayesianRidge()
bayScore = verify_model(bay)
print("bay score", bayScore.mean())


class AveragingModels(BaseEstimator, RegressorMixin):
    def __init__(self,mod,weight):
        self.mod = mod
        self.weight = weight

    def fit(self,X,y):
        self.models_ = [clone(x) for x in self.mod]
        for model in self.models_:
            model.fit(X,y)
        return self

    def predict(self,X):
        w = list()
        pred = np.array([model.predict(X) for model in self.models_])
        # for every data point, single model prediction times weight, then add them together
        for data in range(pred.shape[1]):
            single = [pred[model,data]*weight for model,weight in zip(range(pred.shape[0]),self.weight)]
            w.append(np.sum(single))
        return w


averaged_models = AveragingModels(mod = [ENet, GBoost,lasso],weight=[0.3,0.4,0.3])
averaged_models = AveragingModels(mod = [ GBoost,averaged_models ],weight=[0.4,0.6])

score = verify_model(averaged_models)
print("averaged_model Score: ",score.mean())


# #我们在平均基本模型上添加一个元模型，并使用这些基本模型的折叠预测来训练我们的元模型。
# class StackingAveragedModels(BaseEstimator, RegressorMixin, TransformerMixin):
#     def __init__(self, base_models, meta_model, n_folds=5):
#         self.base_models = base_models
#         self.meta_model = meta_model
#         self.n_folds = n_folds
#
#     # We again fit the data on clones of the original models
#     def fit(self, X, y):
#         self.base_models_ = [list() for x in self.base_models]
#         # print(self.base_models_)
#         self.meta_model_ = clone(self.meta_model)
#         kfold = KFold(n_splits=self.n_folds, shuffle=True, random_state=42)
#         # print(self.meta_model)
#         # Train cloned base models then create out-of-fold predictions
#         # that are needed to train the cloned meta-model
#         out_of_fold_predictions = np.zeros((X.shape[0], len(self.base_models)))
#
#         for i, model in enumerate(self.base_models):
#             for train_index, holdout_index in kfold.split(X, y):
#                 instance = clone(model)
#                 self.base_models_[i].append(instance)
#                 # print("before fit")
#                 # print(train_index)
#                 instance.fit(X[train_index], y[train_index])
#                 # print("after fit")
#                 y_pred = instance.predict(X[holdout_index])
#                 out_of_fold_predictions[holdout_index, i] = y_pred
#
#         # Now train the cloned  meta-model using the out-of-fold predictions as new feature
#         self.meta_model_.fit(out_of_fold_predictions, y)
#         return self
#
#     # Do the predictions of all base models on the test data and use the averaged predictions as
#     # meta-features for the final prediction which is done by the meta-model
#     def predict(self, X):
#         meta_features = np.column_stack([
#             np.column_stack([model.predict(X) for model in base_models]).mean(axis=1)
#             for base_models in self.base_models_])
#         return self.meta_model_.predict(meta_features)
#
# stacked_averaged_model = StackingAveragedModels(base_models = (lasso,ENet,GBoost),
#                                                  meta_model = lasso)
#
# #元模型评价
# score = verify_model(stacked_averaged_model)
# print("Stacking Averaged models score:",format(score.mean()))
'''
#使用元模型生成数据
stacked_averaged_model.fit(train_data.values,y_train)
model_pred= np.expm1(stacked_averaged_model.predict(test_data.values))
submitted_data = pd.DataFrame(data= {'Id' : test_data.index, 'SalePrice':model_pred})
submitted_data.to_csv(r'outcome.csv', index=False)
'''
#使用平均模型生成数据

averaged_models.fit(train_data.values,y_train)
model_pred= np.expm1(averaged_models.predict(test_data.values))
submitted_data = pd.DataFrame(data= {'Id' : test_data.index+1, 'SalePrice':model_pred})
submitted_data.to_csv('outcome.csv', index=False)

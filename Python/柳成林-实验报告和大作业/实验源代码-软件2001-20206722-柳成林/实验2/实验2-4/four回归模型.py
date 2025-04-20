# 实训4：构建基于 wine quality数据集的回归模型

##使用sklearn处理wine和wine_quality数据集

import pandas as pd

# 1、读取数据集

winequality = pd.read_csv('./winequality.csv', sep=';')

# 2、数据和标签拆分开

winequality_data = winequality.iloc[:, :-1]
winequality_target = winequality['quality']

# 3、划分训练集和测试集
from sklearn.model_selection import train_test_split

winequality_data_train, winequality_data_test, \
winequality_target_train, winequality_target_test = \
    train_test_split(winequality_data, winequality_target, \
                     test_size=0.2, random_state=6)

# 4、标准化数据集
from sklearn.preprocessing import StandardScaler  # 标准差标准化

stdScale = StandardScaler().fit(winequality_data_train)
winequality_trainScaler = stdScale.transform(winequality_data_train)
winequality_testScaler = stdScale.transform(winequality_data_test)

# 5.PCA降维
from sklearn.decomposition import PCA

pca_model = PCA(n_components=5).fit(winequality_trainScaler)  # 生成PCA规则
winequality_trainPca = pca_model.transform(winequality_trainScaler)  # 将规则应用到训练集
winequality_testPca = pca_model.transform(winequality_testScaler)  # 将规则应用到测试集

# 根据wine_quality数据集处理的结果,构建线性回归模型。
from sklearn.linear_model import LinearRegression

wine_LR = LinearRegression().fit(winequality_trainPca, winequality_target_train)
wine_line_pred = wine_LR.predict(winequality_testPca)
print('建立的winequality线性回归模型为：', wine_LR)
print('线性回归模型预测前10个结果为：', '\n', wine_line_pred[:10])

# 根据wine_quality数据集处理的结果,构建梯度提升回归模型。
from sklearn.ensemble import GradientBoostingRegressor

wine_GBR = GradientBoostingRegressor(). \
    fit(winequality_trainPca, winequality_target_train)
wine_boost_pred = wine_GBR.predict(winequality_testPca)
print('建立的winequality梯度提升回归模型为：', wine_GBR)
print('梯度提升回归模型预测前10个结果为：', '\n', wine_boost_pred[:10])
print('winequality真实标签前10个预测结果为：', '\n', list(winequality_target_test[:10]))

# 结合真实评分和预测评分,计算均方误差、中值绝对误差、可解释方差值。根据得分,判定模型的性能优劣
from sklearn.metrics import explained_variance_score, \
    mean_absolute_error, mean_squared_error, median_absolute_error, r2_score

print('线性回归模型评价结果：')
print('winequality数据线性回归模型的平均绝对误差为：',
      mean_absolute_error(winequality_target_test, wine_line_pred))
print('winequality数据线性回归模型的均方误差为：',
      mean_squared_error(winequality_target_test, wine_line_pred))
print('winequality数据线性回归模型的中值绝对误差为：',
      median_absolute_error(winequality_target_test, wine_line_pred))
print('winequality数据线性回归模型的可解释方差值为：',
      explained_variance_score(winequality_target_test, wine_line_pred))
print('winequality数据线性回归模型的R方值为：',
      r2_score(winequality_target_test, wine_line_pred))

print('梯度提升回归模型评价结果：')

print('winequality数据梯度提升回归树模型的平均绝对误差为：',
      mean_absolute_error(winequality_target_test, wine_boost_pred))
print('winequality数据梯度提升回归树模型的均方误差为：',
      mean_squared_error(winequality_target_test, wine_boost_pred))
print('winequality数据梯度提升回归树模型的中值绝对误差为：',
      median_absolute_error(winequality_target_test, wine_boost_pred))
print('winequality数据梯度提升回归树模型的可解释方差值为：',
      explained_variance_score(winequality_target_test, wine_boost_pred))
print('winequality数据梯度提升回归树模型的R方值为：',
      r2_score(winequality_target_test, wine_boost_pred))

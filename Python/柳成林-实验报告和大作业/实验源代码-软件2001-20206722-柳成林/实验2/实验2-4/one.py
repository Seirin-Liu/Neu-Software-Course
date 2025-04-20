##使用sklearn处理wine和wine_quality数据集
import numpy as np
import pandas as pd

# 1、读取数据集
wine = pd.read_csv('./wine.csv')
winequality = pd.read_csv('./winequality.csv', sep=';')

# 2、数据和标签拆分开
wine_data = wine.iloc[:, 1:]
wine_target = wine['Class']
winequality_data = winequality.iloc[:, :-1]
winequality_target = winequality['quality']

print("wine数据集数据的形状为：",wine_data.shape)
print("wine数据集标签的形状为：",wine_target.shape)
print("winequality数据集数据的形状为：",winequality_data.shape)
print("winequality数据集标签的形状为：",winequality_target.shape)


# 3、划分训练集和测试集
from sklearn.model_selection import train_test_split

wine_data_train, wine_data_test, \
wine_target_train, wine_target_test = \
    train_test_split(wine_data, wine_target, \
                     test_size=0.2, random_state=6)

winequality_data_train, winequality_data_test, \
winequality_target_train, winequality_target_test = \
    train_test_split(winequality_data, winequality_target, \
                     test_size=0.2, random_state=6)

print("wine训练集数据形状为：",wine_data_train.shape)
print("wine训练集标签形状为：",wine_target_train.shape)
print("wine测试集数据形状为：",wine_data_test.shape)
print("wine测试集标签形状为：",wine_target_test.shape)
print("winequality训练集数据形状为：",winequality_data_train.shape)
print("winequality训练集标签形状为：",winequality_target_train.shape)
print("winequality测试集数据形状为：",winequality_data_test.shape)
print("winequality测试集标签形状为：",winequality_target_test.shape)

# 4、标准化数据集
from sklearn.preprocessing import StandardScaler  # 标准差标准化

stdScale = StandardScaler().fit(wine_data_train)  # 生成规则（建模）
wine_trainScaler = stdScale.transform(wine_data_train)  # 对训练集进行标准化
wine_testScaler = stdScale.transform(wine_data_test)  # 用训练集训练的模型对测试集标准化

stdScale = StandardScaler().fit(winequality_data_train)
winequality_trainScaler = stdScale.transform(winequality_data_train)
winequality_testScaler = stdScale.transform(winequality_data_test)

print("标准差标准化前wine训练集数据的方差为\n",np.var(wine_data_train))
print("标准差标准化后wine训练集数据的方差为",np.var(wine_trainScaler))

print("标准差标准化前wine测试集数据的方差为\n",np.var(wine_data_test))
print("标准差标准化后wine测试集数据的方差为",np.var(wine_testScaler))

# 5.PCA降维
from sklearn.decomposition import PCA

pca_model = PCA(n_components=5).fit(wine_trainScaler)  # 生成PCA规则
wine_trainpca = pca_model.transform(wine_trainScaler)  # 将规则应用到训练集
wine_testpca = pca_model.transform(wine_testScaler)  # 将规则应用到测试集

pca_model = PCA(n_components=5).fit(winequality_trainScaler)  # 生成PCA规则
winequality_trainpca = pca_model.transform(winequality_trainScaler)  # 将规则应用到训练集
winequality_testpca = pca_model.transform(winequality_testScaler)  # 将规则应用到测试集

print("降维前wine训练集的形状为：",wine_trainScaler.shape)
print("降维后wine训练集的形状为：",wine_trainpca.shape)
print("降维前wine测试集的形状为：",wine_testScaler.shape)
print("降维后wine测试集的形状为：",wine_testpca.shape)
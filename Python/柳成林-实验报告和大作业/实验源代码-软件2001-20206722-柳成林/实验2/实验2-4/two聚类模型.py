# 构建基于wine数据集的K-Means聚类模型
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

# 4、标准化数据集
from sklearn.preprocessing import StandardScaler  # 标准差标准化

stdScale = StandardScaler().fit(wine_data_train)  # 生成规则（建模）
wine_trainScaler = stdScale.transform(wine_data_train)  # 对训练集进行标准化
wine_testScaler = stdScale.transform(wine_data_test)  # 用训练集训练的模型对测试集标准化

stdScale = StandardScaler().fit(winequality_data_train)
winequality_trainScaler = stdScale.transform(winequality_data_train)
winequality_testScaler = stdScale.transform(winequality_data_test)

# 1、根据实训1的wine数据集处理的结果,构建聚类数目为3的 K-Means模型
from sklearn.cluster import KMeans
import matplotlib.pyplot as plt

# 用标准化后的训练集建模
kmeans = KMeans(n_clusters=3, random_state=1).fit(wine_trainScaler)
# 用标准化后PCA降维后的训练集建模(采用降维后的数据聚类效果不好，故此处不采用)
print('构建的KMeans模型为：', kmeans)

from sklearn.manifold import TSNE

# tsne = TSNE(n_components=2, init='random', random_state=141).fit(wine_trainScaler)
# df = pd.DataFrame(tsne.embedding_)
# df['labels'] = kmeans.labels_
# df1 = df[df['labels'] == 0]
# df2 = df[df['labels'] == 1]
# df3 = df[df['labels'] == 2]
# fig=plt.figure(figsize=(9,6))
# plt.plot(df1[0],df1[1],'bo',df2[0],df2[1],'r*',df3[0],df3[1],'gD')
# plt.show()

# 2、对比真实标签和聚类标签求取FMI
from sklearn.metrics import fowlkes_mallows_score  # FMI评价法
score = fowlkes_mallows_score(wine_target_train, kmeans.labels_)
print("wine数据集的FMI:%f" % score)

# 3、使用FMI,在聚类数目为2~10类时,确定最优聚类数目
for i in range(2, 11):
    ##构建并训练模型
    kmeans = KMeans(n_clusters=i, random_state=123).fit(wine_trainScaler)
    score = fowlkes_mallows_score(wine_target_train, kmeans.labels_)
    print('wine数据聚%d类FMI评价分值为：%f' % (i, score))

# 4、求取模型的轮廓系数,绘制轮廓系数折线图,确定最优聚类数目
from sklearn.metrics import silhouette_score

silhouettteScore = []
for i in range(2, 11):
    ##构建并训练模型
    kmeans = KMeans(n_clusters=i, random_state=1).fit(wine_trainScaler)
    score = silhouette_score(wine_trainScaler, kmeans.labels_)
    silhouettteScore.append(score)
plt.figure(figsize=(10, 6))
plt.plot(range(2, 11), silhouettteScore, linewidth=1.5, linestyle="-")
plt.show()

# 5、求取 Calinski-Harabasz指数,确定最优聚类数
from sklearn.metrics import calinski_harabasz_score

for i in range(2, 11):
    ##构建并训练模型
    kmeans = KMeans(n_clusters=i, random_state=1).fit(wine_trainScaler)
    score = calinski_harabasz_score(wine_trainScaler, kmeans.labels_)
    print('wine数据聚%d类calinski_harabaz指数为：%f' % (i, score))

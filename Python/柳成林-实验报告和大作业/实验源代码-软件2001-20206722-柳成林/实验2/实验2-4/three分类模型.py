# 构建基于wine数据集的SVM分类模型
# 1.读取wine数据集,区分标签和数据
import pandas as pd

wine = pd.read_csv('./wine.csv')
wine_data = wine.iloc[:, 1:]
wine_target = wine['Class']

# 2.将wine数据集划分为训练集和测试集
from sklearn.model_selection import train_test_split

wine_data_train, wine_data_test, \
wine_target_train, wine_target_test = \
    train_test_split(wine_data, wine_target, \
                     test_size=0.3, random_state=6)

#3.使用离差标准化方法标准化wine数据集。
from sklearn.preprocessing import MinMaxScaler  # 离差标准化

stdScale = MinMaxScaler().fit(wine_data_train)  # 生成规则（建模）
wine_trainScaler = stdScale.transform(wine_data_train)  # 对训练集进行标准化
wine_testScaler = stdScale.transform(wine_data_test)  # 用训练集训练的模型对测试集标准化

# 4.构建SVM模型,并预测测试集结果。
from sklearn.svm import SVC
# 建立SVC模型
svm = SVC().fit(wine_trainScaler, wine_target_train)
print('建立的SVM模型为：\n', svm)
# 预测测试集结果
wine_target_pred = svm.predict(wine_testScaler)
print('预测前20个结果为：\n', wine_target_pred[:20])

# 5.打印出分类报告,评价分类模型性能
from sklearn.metrics import classification_report

print('使用SVM预测wine数据的分类报告为：', '\n',
      classification_report(wine_target_test,
                            wine_target_pred))

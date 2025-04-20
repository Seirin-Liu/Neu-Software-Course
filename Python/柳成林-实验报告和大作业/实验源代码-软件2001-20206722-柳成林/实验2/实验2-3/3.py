# 实训3 标准化建模专家样本数据
import pandas as pd

data = pd.read_csv("./model.csv", encoding="gbk")

def StandardScaler(data):
    data = (data - data.mean()) / data.std()
    return data


S = StandardScaler(data)
print("标准化后的数据为：", '\n', S.head())

'''
#离差标准化函数
def MinMaxScale(data):
    data=(data-data.min())/(data.max()-data.min())
    return data
M=MinMaxScale(model)
print("离差标准化后的数据为：",'\n',S.head())

#小数定标差标准化函数
def DecimalScaler(data): 
    data=data/10**np.ceil(np.log10(data.abs().max()))
    return data
D=DecimalScaler(model)
print("小数定标差标准化的数据为：",'\n',D.head())'''

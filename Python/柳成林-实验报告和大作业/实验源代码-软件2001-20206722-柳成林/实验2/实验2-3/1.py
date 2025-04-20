# 实训1  插补用户用电量数据缺失值
import pandas as pd
import numpy as np

arr = np.array([0, 1, 2])
missing_data = pd.read_csv("./missing_data.csv", names=arr)
# 查询缺失值所在位置
print("原数据缺失值所在的位置（False为缺失值所在位置）", '\n', missing_data.notnull())

print("原数据每列缺失值的个数")
for i in range(0, 3):
    print("第%d列缺失值的个数为:%d" % (i, missing_data.loc[:, i].isnull().sum()))


# 拉格朗日插值
# dropna().index用于记录非缺失值的下标
# dropna().values用于记录非缺失值的实际值
from scipy.interpolate import lagrange

for i in range(0, 3):

    la = lagrange(missing_data.loc[:, i].dropna().index, missing_data.loc[:, i].dropna().values)
    # lis用于记录当前列缺失值所在的行
    lis = list(missing_data.index[np.isnan(missing_data[i])])
    missing_data.loc[lis, i] = la(lis)

print("拉格朗日插值后（False为缺失值所在位置）", "\n", missing_data.notnull())

print("拉格朗日插值数据每列缺失值的个数")
for i in range(0, 3):
    print("第%d列缺失值的个数为:%d" % (i, missing_data.loc[:, i].isnull().sum()))


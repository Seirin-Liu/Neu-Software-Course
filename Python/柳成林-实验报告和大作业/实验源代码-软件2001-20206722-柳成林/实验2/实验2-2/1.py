import pandas as pd

# 读取文件信息，格式为DataFrame
Master = pd.read_csv("./Training_Master.csv", encoding="gbk")
Userupdate = pd.read_csv("./Training_Userupdate.csv", encoding="gbk")
LogInfo = pd.read_csv("./Training_LogInfo.csv", encoding="gbk")

# (1) 查看ndim维度、shape形状、memory_usage占用内存

print("主表的维度为：", Master.ndim)
print("主表的形状为：", Master.shape)
print("主表的占用内存为：\n", Master.memory_usage().head())

print("用户信息更新表的维度为：", Userupdate.ndim)
print("用户信息更新表的形状为：", Userupdate.shape)
print("用户信息更新表的占用内存为\n", Userupdate.memory_usage().head())

print("登录信息表的维度为：", LogInfo.ndim)
print("登录信息表的形状为：", LogInfo.shape)
print("登录信息表的占用内存为：\n", LogInfo.memory_usage().head())

# (2)使用describe方法进行描述性统计，并剔除相同或全为空的列

print("主表的描述性统计为：")
print(Master.describe())
print("用户信息更新表的描述性统计为：")
print(Userupdate.describe())
print("登录信息表的描述性统计为：")
print(LogInfo.describe())


def dropNullStd(data):
    print("删除前的的形状为：", data.shape)
    before = data.shape[1]
    NullCol = data.describe().loc["count"] == 0  # NullCol是为空的列 字典类型
    # print(NullCol)
    for i in range(0, len(NullCol)):
        if NullCol[i]:  # 如果该列为空
            data.drop(labels=NullCol.index[i], axis=1, inplace=True)  # axis为1时删除的是列 0删除行 inplace代表操作是否对原数据有效

    StdCol = data.describe().loc["std"] == 0  # 找出取值相同的某列
    for j in range(0, len(StdCol)):
        if StdCol[j]:
            data.drop(labels=StdCol.index[j], axis=1, inplace=True)
    after = data.shape[1]
    print("删除后的形状为：", data.shape)


print("主表的删除值相同或者全空的列后的情况：")
dropNullStd(Master)
print("用户信息更新表的删除值相同或者全空后的情况：")
dropNullStd(Userupdate)
print("登录信息表的删除值相同或者全空后的情况：")
dropNullStd(LogInfo)

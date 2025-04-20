import pandas as pd
import numpy as np

# Training_LogInfo.csv：借款人的登录信息
# ①　Idx：每一笔贷款的unique key
# ②　ListingInfo1：借款成交时间
# ③　LogInfo1：操作代码
# ④　LogInfo2：操作类别
# ⑤　LogInfo3：登录时间
# Training_Userupdate.csv：借款人修改信息
# ①　Idx：每一笔贷款的unique key
# ②　ListingInfo1：借款成交时间
# ③　UserupdateInfo1：修改内容
# ④　UserupdateInfo2：修改时间

# 读取文件信息，格式为DataFrame
Master = pd.read_csv("./Training_Master.csv", encoding="gbk")
Userupdate = pd.read_csv("./Training_Userupdate.csv", encoding="gbk")
LogInfo = pd.read_csv("./Training_LogInfo.csv", encoding="gbk")

Userupdate["UserupdateInfo2"] = pd.to_datetime(Userupdate["UserupdateInfo2"])  # 修改时间
LogInfo["LogInfo3"] = pd.to_datetime(LogInfo["LogInfo3"])  # 登录时间

# (1)使用groupby方法对用户信息更新表和登录信息表进行分组

UserupdateGroup = Userupdate[["Idx", "UserupdateInfo2"]].groupby(by="Idx")  # 按Inx进行分组

LogInfoGroup = LogInfo[["Idx", "LogInfo3"]].groupby(by="Idx")

print('分组后的用户信息更新表每组前5个数据为：\n', UserupdateGroup.head())
print('分组后的登录信息表每组前5个数据为：\n', LogInfoGroup.head())

# (2)使用agg方法求取分组后的最早和最晚更新及登录时间。
print("分组后最早更新时间前5组数据：\n", UserupdateGroup.agg(np.min).head())
print("分组后最晚更新时间前5组数据：\n", LogInfoGroup.agg(np.max).head())

# (3)使用size方法求取分组后的数据的信息更新次数与登录次数。
print("分组后信息更新次数前5组数据：\n", UserupdateGroup.size().head())
print("分组后登录次数前5组数据：\n", LogInfoGroup.size().head())

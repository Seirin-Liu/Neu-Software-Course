import pandas as pd

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

# (3)使用to_datetime函数转换用户信息更新表和登录信息表的时间字符串。
Userupdate["ListingInfo1"] = pd.to_datetime(Userupdate["ListingInfo1"])  # 借款成交时间
Userupdate["UserupdateInfo2"] = pd.to_datetime(Userupdate["UserupdateInfo2"])  # 修改时间
LogInfo["Listinginfo1"] = pd.to_datetime(LogInfo["Listinginfo1"])  # 借款成交时间
LogInfo["LogInfo3"] = pd.to_datetime(LogInfo["LogInfo3"])  # 登录时间

# (4)使用year、 month、week等方法提取用户信息更新表和登录信息表中的时间信息

# 借款成交时间

year = [i.year for i in Userupdate["ListingInfo1"].head()]
print("ListingInfo1中的年份信息前5个：", year[:5])


month = [i.month for i in Userupdate["ListingInfo1"].head()]
print("ListingInfo1中的月份信息前5个：", month[:5])
week = [i.week for i in Userupdate["ListingInfo1"].head()]
print("ListingInfo1中的星期信息前5个：", week[:5])
day = [i.day for i in Userupdate["ListingInfo1"].head()]
print("ListingInfo1中的日期信息前5个：", day[:5])

# 登录时间
year = [i.year for i in LogInfo["LogInfo3"].head()]
print("LogInfo3中的年份信息前5个：", year[:5])
month = [i.month for i in LogInfo["LogInfo3"].head()]
print("LogInfo3中的月份信息前5个：", month[:5])
week = [i.week for i in LogInfo["LogInfo3"].head()]
print("LogInfo3中的星期信息前5个：", week[:5])
day = [i.day for i in LogInfo["LogInfo3"].head()]
print("LogInfo3中的日期信息前5个：", day[:5])

# (5)计算用户信息更新表和登录信息表中两时间的差,分别以日、小时、分钟计算
timeDeltaUserupdate = Userupdate["ListingInfo1"] - Userupdate["UserupdateInfo2"]
print(timeDeltaUserupdate)
print("计算时间差以日期为单位：\n", timeDeltaUserupdate.head())


def TransformDayIntoHour(data):
    for i in range(0, len(data)):
        data[i] = data[i].total_seconds() / 3600
    return data

print("计算时间差以小时为单位：\n", TransformDayIntoHour(timeDeltaUserupdate).head())


def TransformDayIntoMinute(data):
    for i in range(0, len(data)):
        data[i] = data[i].total_seconds() / 60
    return data


timeDeltaUserupdate = Userupdate["ListingInfo1"] - Userupdate["UserupdateInfo2"]
print("计算时间差以分钟为单位：\n", TransformDayIntoMinute(timeDeltaUserupdate).head())

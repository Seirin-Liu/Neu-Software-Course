# 实训2 合并线损、用电量趋势与线路告警数据
import pandas as pd

ele_loss = pd.read_csv("./ele_loss.csv")
alarm = pd.read_csv("./alarm.csv", encoding='gbk')
# 查看两个表的形状
print("ele_loss表的形状为", ele_loss.shape)
print("ele_loss表的特征值为",ele_loss.keys())
print("alarm表的形状为", alarm.shape)
print("alarm表的特征值为",alarm.keys())


# 合并
print()
merge = pd.merge(ele_loss, alarm, on=["ID", "date"], how="inner")
print("合并后的表形状为：", merge.shape)
print("合并后的表为：", merge)

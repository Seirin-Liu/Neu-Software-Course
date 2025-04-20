import pandas as pd
import numpy as np

# 读取文件信息，格式为DataFrame
from matplotlib import pyplot as plt

Master = pd.read_csv("./Training_Master.csv", encoding="gbk")
Userupdate = pd.read_csv("./Training_Userupdate.csv", encoding="gbk")
# LogInfo = pd.read_csv("./Training_LogInfo.csv", encoding="gbk")

# 1.对缺失值的多维度处理：按列统计缺失值个数，得到各列的缺失比率；
# 按行统计每个样本的属性缺失值个数，将缺失值个数进行排序，将缺失值比率大的特征进行剔除，或者缺失值多的样本进行剔除。
columnlist = Master.isnull().sum().sort_values(ascending=False)[:10]
columnname = columnlist.index
print("主表的前十个缺失比例最高的列：")
print(columnlist / Master.shape[0] * 100)
print("删除缺失值最高的列之前的形状：")
print(Master.shape)
Master.drop(columnname[:5], axis=1, inplace=True)
print("删除缺失值最高的列之后的形状：")
print(Master.shape)

rowlist = Master.isnull().sum(axis=1).sort_values(ascending=False)
print("主表的个缺失个数最高的前10个行：")
print(rowlist[:10])
print("缺失值个数大于30的行的个数：", rowlist[rowlist.values > 30].shape[0])
print("缺失值个数大于25的行的个数：", rowlist[rowlist.values > 25].shape[0])
print("缺失值个数大于20的行的个数：", rowlist[rowlist.values > 20].shape[0])
print("缺失值个数大于10的行的个数：", rowlist[rowlist.values > 10].shape[0])
print("缺失值个数大于5 的行的个数：", rowlist[rowlist.values > 5].shape[0])
rowname = rowlist[rowlist.values > 25].index
print("删除缺失值个数较高的行之前的形状：")
print(Master.shape)
Master.drop(rowname, inplace=True)
print("删除缺失值个数较高的行之后的形状：")
print(Master.shape)

# 2.剔除无变化特征：原始数据中有190维数值型特征，通过计算标准差，剔除变化很小的特征
stdlist = Master.describe().loc['std'].sort_values()
print("主表的标准差较小的前10个列：")
print(stdlist[:10])
stdname = stdlist[:10].index
print("删除标准差较小的特征值之前形状为：", Master.shape)
Master.drop(stdname, axis=1, inplace=True)
print("删除标准差较小的特征值之后形状为：", Master.shape)

# 3.本文处理：
# Userupdate_Info表中的UserupdateInfo1字段，属性取值为英文字符，包含了大小写区分的相同取值，如“_QQ, _qQ”；
# Master表中UserInfo_9字段取值包含了空格字符，如“中国移动”和“中国移动 ”；
# UserInfo_8字段包含了“重庆”、“重庆市”等取值。

# 大小写处理
print("大小写处理之前UserupdateInfo1中不合格的字符串数量: ",
      Userupdate['UserupdateInfo1'].str.contains("^_+[a-z]+[a-zA-Z0-9]*$").sum())

Userupdate['UserupdateInfo1'] = \
    Userupdate['UserupdateInfo1'].replace('^_+[a-z]+[a-zA-Z0-9]*$',
                                          '^_+[A-Z]+[a-zA-Z0-9]*$', regex=True)
print("大小写处理之后UserupdateInfo1中不合格的字符串数量: ",
      Userupdate['UserupdateInfo1'].str.contains("^_+[a-z]+[a-zA-Z0-9]*$").sum())

# 去除主表UserInfo_9中的空格
print("去除空格之前UserInfo_9空格的个数：", (Master["UserInfo_9"].str.endswith(" ") == True).sum())
Master["UserInfo_9"] = Master["UserInfo_9"].replace(' ', '', regex=True)
print("去除空格之后UserInfo_9空格的个数：", (Master["UserInfo_9"].str.endswith(" ") == True).sum())

# UserInfo_8处理
print("处理地名前UserInfo_8不合格地名的个数", (Master["UserInfo_8"].str.endswith("市") == True).sum())
Master["UserInfo_8"] = Master["UserInfo_8"].replace('市', '', regex=True)
print("处理地名后UserInfo_8不合格地名的个数", (Master["UserInfo_8"].str.endswith("市") == True).sum())


# 特征工程 1. 省份地理信息处理
Master["UserInfo_7"] = Master["UserInfo_7"].replace(' ', '', regex=True)
Master["UserInfo_7"] = Master["UserInfo_7"].replace('市', '', regex=True)
grouped = Master['UserInfo_7'].groupby(Master['UserInfo_7']).value_counts()
grouped.sort_values(ascending=False,inplace=True)
print("违约率最高的前几个省份：")
print(grouped.head())

def province_encode(s):
    if s == u'不详':
        return '0'
    if s == u'广东':
        return '1'
    if s == u'山东':
        return '2'
    if s == u'江苏':
        return '3'
    if s == u'浙江':
        return '4'
    if s == u'四川':
        return '5'
    if s == u'福建':
        return '6'
    else:
        return '7'

Master['UserInfo_7'] = Master['UserInfo_7'].apply(lambda x: province_encode(x))
len(Master['UserInfo_7'].unique())

# 可视化展示
plt.rcParams['font.sans-serif'] = 'SimHei'  # 设置中文显示
plt.bar(range(7), grouped[1:8], width=0.5, color='#FF7F50')
plt.ylabel('次数')
plt.xticks(range(7), [1,2,3,4,5,6,7])
plt.title('省份违约情况\n1：广东 2：山东 3：江苏 4：浙江 5：四川 6：福建')
plt.show()


# 特征工程 2.划分n线城市
first_city = ['北京', '上海', '广州', '深圳']

second_city = ['成都', '杭州', '武汉', '重庆', '兰州'
               '南京', '天津', '苏州', '西安',  '台州',
               '青岛', '郑州', '大连', '东莞', '珠海',
               '宁波', '厦门', '福州', '无锡',  '沈阳',
               '合肥', '昆明', '哈尔滨', '佛上', '长春', '长沙',
               '温州', '石家庄', '南宁', '常州', '泉州', '南昌',
               '贵阳', '太原', '烟台', '嘉兴', '南通', '金华',
               '惠州', '徐州', '海口', '乌鲁木齐', '绍兴', '中山', ]

Master.reset_index(drop=True, inplace=True)
# 对文字进行除杂
Master["UserInfo_2"] = Master["UserInfo_8"].replace('市', '', regex=True)
Master["UserInfo_2"] = Master["UserInfo_2"].replace(' ', '', regex=True)

# for循环替换
for a in first_city:
    Master['UserInfo_2'] = Master['UserInfo_2'].replace({a: 1})

for a in second_city:
    Master['UserInfo_2'] = Master['UserInfo_2'].replace({a: 2})
# 其他的字符串格式变量都为3线
for a in Master['UserInfo_2']:
    if isinstance(a, str):
        Master['UserInfo_2'] = Master['UserInfo_2'].replace({a: 3})

# 可视化展示：
Master['UserInfo_2'] = Master['UserInfo_2'].map({1: "一线",2: "二线",3: "三线"})
plt.rcParams['font.sans-serif'] = 'SimHei'  # 设置中文显示
fig, ax = plt.subplots()
ax.scatter(Master['UserInfo_2'], Master['WeblogInfo_7'])
plt.ylabel('WeblogInfo_7', fontsize=13)
plt.xlabel('UserInfo_2', fontsize=13)
plt.show()

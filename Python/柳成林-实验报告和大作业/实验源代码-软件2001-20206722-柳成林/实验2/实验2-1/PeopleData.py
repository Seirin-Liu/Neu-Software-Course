import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

data = np.load('./populations.npz', allow_pickle=True)
values = data['data']
values = values[~pd.isna(values).any(axis=1), :]

plt.rcParams['font.sans-serif'] = 'SimHei'
label1 = ['2015', '2014', '2013', '2012', '2011', '2010', '2009', '2008', '2007', '2006', '2005', '2004', '2003',
          '2002', '2001', '2000', '1999', '1998', '1997', '1996']
label2 = ['城镇', '乡村']
label3 = ['男性', '女性']
ex = [0.0, 0.0]

p1 = plt.figure(figsize=(12, 12))
# 子图1
a1 = p1.add_subplot(2, 2, 1)
plt.bar(range(2), values[19, 2:4], width=0.5, color='#6495ED')
plt.ylabel('人口（万人）')
plt.ylim(0, 80000)
plt.xticks(range(2), label3)
plt.title('1996年男、女人口数直方图')

# 子图2
b1 = p1.add_subplot(2, 2, 2)
plt.bar(range(2), values[0, 2:4], width=0.5, color='#6495ED')
plt.ylabel('人口（万人）')
plt.ylim(0, 80000)
plt.xticks(range(2), label3)
plt.title('2015年男、女人口数直方图')

# 子图3
c1 = p1.add_subplot(2, 2, 3)
plt.bar(range(2), values[19, 4:6], width=0.5, color='#6495ED')
plt.xlabel('类别')
plt.ylabel('人口（万人）')
plt.ylim(0, 90000)
plt.xticks(range(2), label2)
plt.title('1996年城、乡人口数直方图')

# 子图4
d1 = p1.add_subplot(2, 2, 4)
plt.bar(range(2), values[0, 4:6], width=0.5, color='#6495ED')
plt.xlabel('类别')
plt.ylabel('人口（万人）')
plt.ylim(0, 90000)
plt.xticks(range(2), label2)
plt.title('2015年城、乡人口数直方图')

p2 = plt.figure(figsize=(8, 8))

h1 = p2.add_subplot(2, 2, 1)
plt.pie(values[19, 2:4], explode=ex, labels=['男性', '女性'], colors=['#00CED1', '#E9967A'], autopct='%1.1f%%')
plt.title('1996年男女比例')

c1 = p2.add_subplot(2, 2, 3)
plt.pie(values[19, 4:6], explode=ex, labels=label2, colors=['#DEB887', '#808080'], autopct='%1.1f%%')
plt.title('1996年城乡比例')

h2 = p2.add_subplot(2, 2, 2)
plt.pie(values[0, 2:4], explode=ex, labels=label3, colors=['#00CED1', '#E9967A'], autopct='%1.1f%%')
plt.title('2015年男女比例')

c2 = p2.add_subplot(2, 2, 4)
plt.pie(values[0, 4:6], explode=ex, labels=label2, colors=['#DEB887', '#808080'], autopct='%1.1f%%')
plt.title('2015年城乡比例')
# plt.savefig('D:/python实验数据/populationPicture/1996、2015年人口比例饼图.png')


# 3.箱线图
p3 = plt.figure(figsize=(8, 20))

x1 = p3.add_subplot(2, 1, 1)
plt.boxplot(values[0:20, 1:6], notch=True, labels=['年末总人口', '男性人口', '女性人口', '城镇人口', '乡村人口'], meanline=True)
plt.ylabel('人口（万人）')
plt.title('1996~2015年各特征人口箱线图')

# plt.savefig('D:/python实验数据/populationPicture/1996~2015年各特征人口箱线图.png')

x2 = p3.add_subplot(2, 1, 2)
values = values[::-1]  # 倒序
plt.plot(values[0:20, 1], color='r', linestyle='--', label="年末总人口")
plt.plot(values[0:20, 2], color='g', linestyle='-', label="男性人口")
plt.plot(values[0:20, 3], color='c', linestyle='-', label="女性人口")
plt.plot(values[0:20, 4], color='b', linestyle='--', label="城镇人口")
plt.plot(values[0:20, 5], color='k', linestyle='--', label="乡村人口")
plt.ylabel('人口（万人）')
plt.title('1996~2015年各特征人口折线图')
plt.xticks([i - 0.1 for i in range(20)], label1[::-1])
plt.legend()

# plt.savefig('D:/python实验数据/populationPicture/1996~2015年各特征人口折线图.png')

plt.show()

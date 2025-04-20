import numpy as np
import matplotlib.pyplot as plt

data = np.load('./populations.npz', allow_pickle=True)
print(data.files)
print('feature_names:')
print(data['feature_names'])
print("data:")
print(data['data'])  # 输出数据文件中的data数组
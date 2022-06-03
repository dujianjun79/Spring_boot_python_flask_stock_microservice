import pandas as pd
from alpha_vantage.timeseries import TimeSeries

ts = TimeSeries(key='LOOXXHYH23A9THD5',output_format='pandas')
data, meta_data = ts.get_intraday('QQQ')
print(data.iloc[0,3])
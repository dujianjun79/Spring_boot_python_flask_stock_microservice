from shutil import register_unpack_format
from flask import Flask, request
import py_eureka_client.eureka_client as eureka_client
import pandas as pd
from alpha_vantage.timeseries import TimeSeries

rest_port = 8050
eureka_client.init(eureka_server="http://localhost:8762/eureka",
                   app_name="data-service",
                   instance_port=rest_port)

app = Flask(__name__)

@app.route("/fetch/<stick>", methods=['GET'])
def hello(stick):
    ts = TimeSeries(key='LOOXXHYH23A9THD5',output_format='pandas')
    data, meta_data = ts.get_intraday(stick)
    return str(data.iloc[0,3])

@app.route("/fetch", methods=['GET'])
def fetch_page():
    ts = TimeSeries(key='LOOXXHYH23A9THD5',output_format='pandas')
    data, meta_data = ts.get_intraday('QQQ')
    return str(data.iloc[0,3])

if __name__ == "__main__":
    app.run(host='0.0.0.0', port = rest_port, debug=True)
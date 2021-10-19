#JSON的定义

```json
{
  "k1": "v1",
  "k2": [
    1,
    2,
    "3",
    {
      "k21": "v21"
    }
  ],
  "k3": "v3"
}
``` 

#json有两种存在形式
- JSON对象：JSON.parse():json字符串转换为JSON对象
- JSON字符串：JSON.stringify():把JSON对象转换为JSON字符串

#XMLHttpRequest 的三个重要的属性
- onreadystatechange：存储函数（或函数名），每当readystate改变时，就会调用该函数
- readyState
    - 0：请求未初始化
    - 1：服务器连接已建立
    - 2：请求已接收
    - 3：请求处理中
    - 4：请求已完成，且响应已就绪
- status：
    - 200："OK"
    - 404：未找到页面
    
#XMLHttpRequest接受响应内容
- XMLHttpRequest.responseText:字符串
- XMLHttpRequest.responseType:XML

#JQuery中的AJAX请求
- $.ajax方法
    - url:表示请求的地址
    - type：请求的类型
    - data ：格式有两种
        - name=value&name2=value2
        - {name:value,name2:value2}
    - success:请求成功，响应的回调函数
    - dataType：响应的数据类型
- $.get方法和$.post方法：URL，data,callback(成功的回调函数),type
- $.getJSON方法：url,data,callback
    - serialize():可以获得表单中所有表单项的内容，并以name=value&name2=value2的形式进行拼接
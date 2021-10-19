#保存Cookie
> response.addCookie(cookie);服务器通知客户端保存cookie（键值对），如果该键值对有就修改，没有就创建

#浏览器查看Cookie
- Application-Cookie

#Cookie的生命控制
> 如何管理Cookie什么时候被销毁
- setMaxAge():
    - 正数：指定秒数后删除
    - 负数：浏览器关闭后删除（默认-1）
    - 0：马上删除
    
#Cookie的path
> Cookie的path属性可以有效地过滤哪些Cookie可以发给客户端(默认是工程路径)

#创建和获取Session
> request.getSession(),第一次(请求）调用是创建，之后调用是获取前面调用好的
- getId() 得到 Session 的会话 id 值，唯一标签。

#Session的生命控制
- setMaxInactiveInterval:设置Session的超时时间，超过就会被销毁，负数就永不超时，默认30分钟
- invalidate():设置为马上超时
```xml
  <!--表示当前 web 工程。创建出来 的所有 Session 默认是 20 分钟 超时时长--> 
    <session-config> 
        <session-timeout>20</session-timeout> 
    </session-config>
```

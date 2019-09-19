此demo是基于Spring security整合Oauth2的password授权模式案例

准备环境：需准备red is服务器存储token
测试案例：
1.授权服务器获取access_token 请求方式：post
http://localhost:8080/oauth/token?username=javaboy&password=123&scope=all&client_secret=123&client_id=password&grant_type=password

2.获取资源 请求方式：get
http://localhost:8080/api/admin/hello?access_token=请求1成功返回的access_token

3.更新token
http://localhost:8080/oauth/token?refresh_token=请求1成功返回的refresh_token&client_secret=123&client_id=password&grant_type=refresh_token





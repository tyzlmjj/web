<%@ page import="java.io.IOException" %>
<%@ page import="okhttp3.*" %><%--
  Created by IntelliJ IDEA.
  User: MJJ
  Date: 2016/4/17
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HttpRequest</title>
</head>
<body>

<%!

    MediaType mediaType = MediaType.parse("application/json; charset=utf-8");

    String request(String url,String params)
    {

        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType , params);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = null;
        String resp;
        try {
            response = client.newCall(request).execute();
            resp = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            resp = "异常";
        }
        return resp;
    }
%>
<input type="text" name="url" id="Url">
<input  type="button" value="Post请求" onclick="">





</body>
</html>

<%@ page import="java.io.IOException" %>
<%@ page import="okhttp3.*" %>
<%@ page import="java.util.Set" %>
<%--
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
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="mdl/material.min.css">
    <script src="mdl/material.min.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <style type="text/css">
        .container{
            margin-right:auto;
            margin-left:auto;
            padding-left:15px;
            padding-right:15px
        }
        .container:before,.container:after{
            content:" ";
            display:table
        }
        .container:after{
            clear:both
        }
        .container:before,.container:after{
            content:" ";
            display:table
        }
        .container:after{
            clear:both
        }
        @media (min-width:768px){.container{width:750px}}
        @media (min-width:992px){.container{width:970px}}
        @media (min-width:1200px){.container{width:1170px}}
        .row{margin-left:-15px;margin-right:-15px}
        .row:before,.row:after{content:" ";display:table}
        .row:after{clear:both}
        .row:before, .row:after{content:" ";display:table}
    </style>
</head>

<body>

<div class="mdl-layout__content">


<%!
    MediaType mediaType = MediaType.parse("application/x-www-text; charset=utf-8");

    Response post_request(String url)
    {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
%>

<form action="" method="post">
    <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
        <input class="mdl-textfield__input" type="text" name="urlstr" id="urlstr">
        <label class="mdl-textfield__label" for="urlstr">URL</label>
    </div>
    <br>
    <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent" type="submit">
        Get请求
    </button>
</form>
<div id="content">
<%
    String urlstr = request.getParameter("urlstr");
    if(urlstr != null)
    {
        Response response1 = post_request(urlstr);
        if(response1 != null)
        {
            Headers headers = response1.headers();
            Set<String> set = headers.names();
            out.append("<h2>头信息</h2><hr>");
            out.append("<table  class=\"mdl-data-table mdl-js-data-table\">");
            out.append("<thead>\n" +
                    "    <tr>\n" +
                    "      <th class=\"mdl-data-table__cell--non-numeric\">属性名</th>\n" +
                    "      <th>属性值</th>\n" +
                    "    </tr>\n" +
                    "  </thead> " +
                    "<tbody>");
            for (String name:set)
            {
                out.append("<tr><td class=\"mdl-data-table__cell--non-numeric\">" + name + "</td><td>" + headers.get(name) + "</td></tr>");
            }
            out.append("</tbody>" +
                    "</table>");

            String s = response1.body().string();
            out.print("<h2>完整数据源</h2><hr>" + s);
        }
        else
        {
            out.print("错误");
        }
}
%>
</div>

<div class="mdl-textfield mdl-js-textfield">
    <textarea class="mdl-textfield__input" type="text" rows= "10" id="sample5" ></textarea>
    <label class="mdl-textfield__label" for="sample5">完整输出</label>
</div>

</div>
</body>
</html>

package me.majiajie.http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Enumeration;

@WebServlet("/HostInfo")
public class HostInfo extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setCharacterEncoding("UTF-8");
        Writer writer = resp.getWriter();
        writer.append("<h1>Get</h1><hr/>");

        writer.append("<h2>请求信息</h2>");

        writer.append("IP : "+req.getRemoteAddr()+"<br/>");
        writer.append("ContentType : "+req.getContentType()+"<br/>");
        writer.append("Protocol : "+req.getProtocol()+"<br/>");
        writer.append("Encoding : "+req.getCharacterEncoding()+"<br/>");

        writer.append("<h2>请求头</h2>");
        Enumeration headerNames =req.getHeaderNames();
        if(headerNames.hasMoreElements())
        {
            String name = (String) headerNames.nextElement();
            resp.getWriter().append(name+":"+req.getParameter(name)+"<br/>");
        }

        writer.append("<h2>提交参数</h2>");
        Enumeration parameterNames = req.getParameterNames();
        if(parameterNames.hasMoreElements())
        {
            String name = (String) parameterNames.nextElement();
            resp.getWriter().append(name+":"+req.getParameter(name)+"<br/>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setCharacterEncoding("UTF-8");
        Writer writer = resp.getWriter();
        writer.append("<h1>Post</h1><hr/>");

        writer.append("<h2>请求信息</h2>");

        writer.append("IP : "+req.getRemoteAddr()+"<br/>");
        writer.append("ContentType : "+req.getContentType()+"<br/>");
        writer.append("Protocol : "+req.getProtocol()+"<br/>");
        writer.append("Encoding : "+req.getCharacterEncoding()+"<br/>");

        writer.append("<h2>请求头</h2>");
        Enumeration headerNames =req.getHeaderNames();
        if(headerNames.hasMoreElements())
        {
            String name = (String) headerNames.nextElement();
            resp.getWriter().append(name+":"+req.getParameter(name)+"<br/>");
        }

        writer.append("<h2>提交参数</h2>");
        Enumeration parameterNames = req.getParameterNames();
        if(parameterNames.hasMoreElements())
        {
            String name = (String) parameterNames.nextElement();
            resp.getWriter().append(name+":"+req.getParameter(name)+"<br/>");
        }
    }
}

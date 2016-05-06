package me.majiajie.http;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PostTest")
public class PostTest extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init(req,resp);
    }

    void init(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {
        String name = req.getParameter("name");

        resp.setHeader("content","application/json;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().append("{\"id\":2,\"name\":\""+name+"\"}");
    }
}

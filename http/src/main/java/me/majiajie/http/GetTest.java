package me.majiajie.http;


import me.majiajie.http.utils.ServletUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

@WebServlet("/GetTest")
public class GetTest extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Test test = ServletUtil.toModel(req,Test.class);

        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().append("GetTest<br/>");
        resp.getWriter().append(test.getId()+"");
    }
}

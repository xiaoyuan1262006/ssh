package com.mavenpro.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author liuxiaoyuan
 * @Title: MyController
 * @ProjectName mavenproject
 * @Description: TODO
 * @date 2018/7/28下午1:46
 */
public class MyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // System.err.println("---");
        //解决乱码
        req.setCharacterEncoding("UTF-8");
        String name=req.getParameter("name");
        req.setAttribute("name",name);
        System.out.println(name);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }


}

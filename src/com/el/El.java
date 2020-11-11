package com.el;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author :wn
 * @program : EL表达式
 * @descript : EL表达式例子
 * @create :2020-11-02 14:21
 */
@WebServlet("/el")
public class El extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = new String(req.getParameter("username").getBytes("ISO-8859-1"), "UTF-8");
        String password = new String(req.getParameter("userpassword").getBytes("ISO-8859-1"), "UTF-8");
        HttpSession session = req.getSession();
        session.setAttribute("name", name);
        HttpSession session2 = req.getSession();
        session2.setAttribute("password", password);
        Cookie cookie = new Cookie("name", password);
        cookie.setMaxAge(2 * 60);
        resp.addCookie(cookie);
        req.getRequestDispatcher("elTest.jsp").forward(req, resp);
    }
}

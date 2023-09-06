package top.hyzhu;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zhuhuiyu
 */
@WebServlet("/demo")
public class DemoServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("DemoServlet init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.返回一个网页
//        resp.setContentType("text/html;charset = utf-8");
//        PrintWriter out = resp.getWriter();
//        out.println("<h2>123</h2>");
//        out.flush();
//        out.close();
    }

    @Override
    public void destroy() {
        System.out.println("DemoServlet destroy");
    }
}

package top.hyzhu;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
    private static final String REGIST_SUCCESS = "注册成功";
    private static final String REGIST_FAILURE = "注册失败";

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("HelloServlet init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String gender = req.getParameter("gender");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        String res;
        if ("admin".equalsIgnoreCase(username) && "123456".equals(password)) {
            if ("男士".equals(gender)) {
                res = "恭喜你" + username + gender + REGIST_SUCCESS + "!";
            } else if ("女士".equals(gender)) {
                res = "恭喜你" + username + gender + REGIST_SUCCESS + "!";
            } else {
                res = "恭喜你" + username + REGIST_SUCCESS + "!";
            }

        } else {
            res = REGIST_FAILURE;
        }
        out.println(res);
        out.flush();
        out.close();
    }

    @Override
    public void destroy() {
        System.out.println("HelloServlet destory");
    }
}

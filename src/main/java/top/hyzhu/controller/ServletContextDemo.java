package top.hyzhu.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @Description ServletContextDemo
 * @Author zhy
 * @Date 2023/9/26 23:22
 */
@WebServlet("/servletContextDemo")
@Slf4j
public class ServletContextDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.取得context上下文
//        通过request对象获取
        ServletContext context1 = req.getServletContext();
//        通过HttpServlet对象获取
        ServletContext context2 = this.getServletContext();
        System.out.println(context1 == context2);
//        log.info(String.valueOf(context1 == context2));
//        2.获取MIME
        String fileName = "1.doc";
        String mimeType = context1.getMimeType(fileName);
        System.out.println(mimeType);
//        log.info(mimeType);
//        3.获取域对象
        context1.setAttribute("msg", "hello world");
        resp.sendRedirect("/index.jsp");

//        常用域对象
//        request -> session -> application

//      获取文件在服务器的路径
        // webapp目录下资源访问
        String a = context1.getRealPath("/a.txt");
        log.info(a);

        //WEB-INF目录下的资源访问
        String b = context1.getRealPath("/WEB-INF/b.txt");
        log.info(b);

        // resources 目录下的资源访问
        String c = context1.getRealPath("/WEB-INF/classes/c.txt");
        log.info(c);


    }
}

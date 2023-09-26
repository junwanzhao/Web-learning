package top.hyzhu.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import top.hyzhu.utils.StringUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * @Description ResponseServletDemo
 * @Author zhy
 * @Date 2023/9/26 20:36
 */
@WebServlet("/response/*")
@Slf4j
public class ResponseServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String method = StringUtil.subUri(uri);
        switch (method) {
            case "demo1": {
                this.demo1(req, resp);
            }
            case "demo2": {
                this.demo2(req, resp);
            }
            case "demo3": {
                this.demo3(req, resp);
            }
            case "demo4": {
                this.demo4(req, resp);
            }
            case "demo5": {
                this.demo5(req, resp);
            }
            case "demo6": {
                this.demo6(req, resp);
            }
//            case "demo7": {
//                this.demo7(req, resp);
//            }
//            case "demo8": {
//                this.demo8(req, resp);
//            }
//            case "demo9": {
//                this.demo9(req, resp);
//            }

        }
    }

    private void demo1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("response demo1");
//        1.设置响应状态码为302
        resp.setStatus(302);
//        2.设置响应头 Location
        resp.setHeader("Location", "/response/demo1");
        req.setAttribute("msg", "response");
//        动态获取虚拟目录
        String contextPath = req.getContextPath();
//        简单的重定向方法
        resp.sendRedirect(contextPath + "/response/demo2");
//        重定向可以跨域
//        resp.sendRedirect("https://www.baidu.com");
    }

    private void demo2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("response demo2被访问");
        Object msg = req.getAttribute("msg");
        log.info((String) msg);
//        resp.sendRedirect("/login.html");
    }

    private void demo3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    转发
        req.getRequestDispatcher("/response/demo2").forward(req, resp);
    }

    private void demo4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("response demo4");
//      绝对路径
        resp.sendRedirect("/response/demo1");
//      "/"代表demo根目录
//        resp.sendRedirect("/regist.html");
    }

    //    输出字符数据
    private void demo5(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取流对象之前，设置流的默认编码：ISO-8859-1 设置为：GBK
        // response.setCharacterEncoding("utf-8");
        // 告诉浏览器，服务器发送的消息体数据的编码，建议浏览器使用该编码解码
        // response.setHeader("content-type","text/html;charset=utf-8");
        // 简单形式设置编码
        resp.setContentType("text/html;charset=utf-8");
        // 1.获取字符输出流
        PrintWriter pw = resp.getWriter();
        // 2.输出数据
        pw.write("<h1>hello response</h1>");
        pw.write("你好 response");
    }

    //输出字节数据
    private void demo6(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        //1.获取字节输出流
        ServletOutputStream sos = resp.getOutputStream();
        // 2.输出数据
        sos.write("你好".getBytes(StandardCharsets.UTF_8));
    }
}



package top.hyzhu.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @author: zhy
 * @Description: RequestServletDemo
 * @date: 2023/9/25
 */
@WebServlet("/request/*")
@Slf4j
public class RequestServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        int position = uri.lastIndexOf("/");
        String method = uri.substring(position + 1);
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
            case "demo7": {
                this.demo7(req, resp);
            }
            case "demo8": {
                this.demo8(req, resp);
            }
            case "demo9": {
                this.demo9(req, resp);
            }
        }

    }

    /**
     * 1.HttpServletRequest 获取请求行数据
     *
     * @param req  请求对象
     * @param resp 响应对象
     * @throws ServletException servlet异常
     * @throws IOException      io异常
     */
    private void demo1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1.获取请求的方式
        String method = req.getMethod();
        log.info(method);
//        2.获取Servlet路径
        String servletPath = req.getServletPath();
        log.info(servletPath);
//        3.获取虚拟目录
        String contextPath = req.getContextPath();
        log.info(contextPath);
//        4.获取get方式请求参数,记得给出参数
        String queryString = req.getQueryString();
        log.info(queryString);
        String[] s = queryString.split("&");
        log.info(s[0]);
        log.info(s[1]);
//        5.获取协议以及版本：HTTP/1.1
        String protocol = req.getProtocol();
        log.info(protocol);
//        6.获取客户机的IP地址
        String remoteAddr = req.getRemoteAddr();
        log.info(remoteAddr);
//        7.获取请求的URI
        String requestURI = req.getRequestURI();
        log.info(requestURI);
    }

    /**
     * 2.Request 对象获取所有请求头数据
     *
     * @param req  请求对象
     * @param resp 响应对象
     * @throws ServletException servlet异常
     * @throws IOException      io异常
     */
    private void demo2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    1.获取所有请求头名称
        Enumeration<String> headerNames = req.getHeaderNames();
//        2.遍历
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
//            根据名称获取请求头的值
            String value = req.getHeader(name);
            log.info(name + "---" + value);
        }
    }

    /**
     * 3. Request 对象获取指定请求头数据
     *
     * @param req  请求对象
     * @param resp 响应对象
     * @throws ServletException servlet异常
     * @throws IOException      io异常
     */
    private void demo3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取请求头数据：user-agent
        String agent = req.getHeader("user-agent");
//        判断 agent 的浏览器版本
        if (agent.contains("Chrome")) {
            log.info("谷歌浏览器...");
        } else if (agent.contains("Firefox")) {
            log.info("火狐浏览器...");
        }
    }

    /**
     * 4. Request 获取请求体数据
     *
     * @param req  请求对象
     * @param resp 响应对象
     * @throws ServletException servlet异常
     * @throws IOException      io异常
     */
    private void demo4(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//    获取请求消息体--请求参数
//        1.获取字符流
        BufferedReader br = req.getReader();
//        2.读取数据
        String line;
        while ((line = br.readLine()) != null) {
            log.info(line);
        }
    }

    /**
     * 5.  Request 获取请求参数通⽤⽅式
     *
     * @param req  请求对象
     * @param resp 响应对象
     * @throws ServletException servlet异常
     * @throws IOException      io异常
     */
    private void demo5(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      post 获取请求参数
//      根据参数名称获取参数值
        log.info("根据参数名称获取参数值");
        String username = req.getParameter("username");
        log.info(username);
//      根据参数名称获取参数值的数组
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            log.info(hobby);
        }

//        获取所有参数的请求名称
        log.info("*************************");
        log.info("获取所有参数的请求名称");
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            log.info(name);
            String value = req.getParameter(name);
            log.info(value);
            log.info("---------------------");
        }

//        获取所有参数的map集合
        log.info("********************");
        log.info("获取所有参数的map集合");
        Map<String, String[]> parameterMap = req.getParameterMap();
//        遍历
        Set<String> keySet = parameterMap.keySet();
        for (String name : keySet) {
//            获取键获取值
            String[] values = parameterMap.get(name);
            for (String value : values) {
                log.info(value);
            }
            log.info("-------------------");
        }
    }

    /**
     * 6. Request 获取请求参数中⽂乱码问题处理
     *
     * @param req  请求对象
     * @param resp 响应对象
     * @throws ServletException servlet异常
     * @throws IOException      io异常
     */
    private void demo6(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      1.设置请求的编码
        req.setCharacterEncoding("utf-8");
//      2.获取请求参数username
        String username = req.getParameter("username");
        log.info(username);
    }

    /**
     * 7. Request 请求转发
     *
     * @param req  请求对象
     * @param resp 响应对象
     * @throws ServletException servlet异常
     * @throws IOException      io异常
     */
    private void demo7(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("demo7被访问了");
//        存储数据到request中
        req.setAttribute("msg", "hello");
//        转发到requestDemo8资源中
        req.getRequestDispatcher("/request/demo8").forward(req, resp);
//        无法跨域转发
//        req.getRequestDispatcher("https://www.baidu.com").forward(req,resp);
    }

    /**
     * 8. Request 共享数据(域对象)
     *
     * @param req  请求对象
     * @param resp 响应对象
     * @throws ServletException servlet异常
     * @throws IOException      io异常
     */
    private void demo8(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        从 request 域中获取数据
        Object msg = req.getAttribute("msg");
        log.info((String) msg);
        log.info("demo8被访问了。。。");
//      void setAttribute(String name,Object obj) : 存储数据
//      Object getAttitude(String name) : 通过键获取值
//      void removeAttribute(String name) : 通过键移除键值对
    }

    /**
     * 9. Request 获取 ServletContext,全局存储信息空间
     *
     * @param req  请求对象
     * @param resp 响应对象
     * @throws ServletException servlet异常
     * @throws IOException      io异常
     */
    private void demo9(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();
        log.info(String.valueOf(servletContext));

    }
}

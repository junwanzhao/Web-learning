package top.hyzhu.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Description DownloadServlet
 * @Author zhy
 * @Date 2023/9/27 0:50
 */
@WebServlet("/download")
@Slf4j
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数，文件名称
        String filename = req.getParameter("filename");
        // 找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
//        log.info(realPath);
        // 用字节流关联
        FileInputStream fis = new FileInputStream(realPath);
        // 获取文件的 mime 类型
        String mimeType = servletContext.getMimeType(filename);
        // 设置响应头类型：content-type
        resp.setHeader("content-type", mimeType);
        // 设置响应头打开方式:content-disposition
        resp.setHeader("content-disposition", "attachment;filename=" + filename);
        // 将输入流的数据写出到输出流中
        ServletOutputStream sos = resp.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len;
        while ((len = fis.read(buff)) != -1) {
            sos.write(buff, 0, len);
        }
        fis.close();
    }
}


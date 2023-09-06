package top.hyzhu;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * @author zhuhuiyu
 */
@WebServlet("/demo")
public class DemoServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("DemoServlet init");
    }
   /** 验证码图片中文字的个数*/
    private static final int SIZE = 4;
    /** 验证码图片中的干扰线的数量*/
    private static final int LINES = 300;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("DemoServlet doGet");
//        1.返回一个网页
//        resp.setContentType("text/html;charset = utf-8");
//        PrintWriter out = resp.getWriter();
//        out.println("<h2>123</h2>");
//        out.flush();
//        out.close();

        //2. 返回一段json数据
//        resp.setContentType("application/json;charset = utf-8");
//        PrintWriter out = resp.getWriter();
//        String jsonString = """
//                   {
//                 "name":"hyzhu"
//                 "age":"19",
//                }
//                """;
//        out.print(jsonString);
//        out.flush();
//        out.close();
//        3.返回一个验证码
        int len = SIZE;
        int fontSize = 28;
        int width = len * fontSize + 10;
        int height = 50;
        String code = getCode();
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();
//        设置背景色
        g.setColor(Color.WHITE);
//        绘制填充矩形
        g.fillRect(0,0,width,height);
//        绘制干扰线
        for(int i = 0; i < LINES; i++){
            g.setColor(getRandomColor());
            int x1 = new Random().nextInt(width);
            int y1 = new Random().nextInt(height);
            int x2 = new Random().nextInt(width);
            int y2 = new Random().nextInt(height);
            g.drawLine(x1,y1,x2,y2);
//            int x = new Random().nextInt(width);
//            int y = new Random().nextInt(width);
//            g.drawOval(x,y,1,1);
        }

//          绘制验证码
        g.setColor(Color.pink);
        g.setFont(new Font("宋体",Font.BOLD,fontSize));
        for(int i =0;i < len; i++){
            char c = code.charAt(i);
            g.drawString(c + "",i * fontSize +5,fontSize);
        }
//        输出验证码
        ImageIO.write(bufferedImage,"jpg",resp.getOutputStream());
    }
    public String getCode() {
        Random random = new Random();
        String str="0123456789ABCDEFGHIGKMNPQSTUVWXYZabcdefghgklmnpqstuvwxyz";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            int r = random.nextInt(str.length());
            char letter = str.charAt(r);
            sb.append(letter);
        }
        return sb.toString();

    }
    // 产生随机颜色的方法
    private static Color getRandomColor() {

        Random ran = new Random();   // 随机函数
        // 产生随机的RGB颜色
        Color color = new Color(ran.nextInt(256), ran.nextInt(256), ran
                .nextInt(256));
        return color;
    }




    @Override
    public void destroy() {
        System.out.println("DemoServlet destroy");
    }
}

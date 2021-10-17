package com.example.jsptest; /**
 * @author dzx
 * @data 2021/10/9 -20:04
 */

import org.apache.commons.io.IOUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@WebServlet(name = "downloadServlet", value = "/downloadServlet")
public class downloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取要下载的文件名
        String downloadFileName = "2.JPEG";
//        2.读取文件,通过ServletContext对象读取
        ServletContext servletContext = getServletContext();
        InputStream inputStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
//        读取要下载的文件的类型
        String fileType = servletContext.getMimeType("/file/" + downloadFileName);
//        3.在回传前，通过响应头告诉客户端返回的数据类型
        response.setContentType(fileType);
//        4.告诉客户端收到的数据是用于下载使用的（还是使用响应头）,Content-Disposition:收到的数据怎么处理,attachment:附件,filename为中文时，进行URL编码
//        response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode("小鸟.jpeg","UTF-8"));
//        base64编码
        Base64.Encoder base = Base64.getEncoder();
        response.setHeader("Content-Disposition","attachment;filename==?UTF-8?B?"+ base.encodeToString("小鸟2.jpeg".getBytes(StandardCharsets.UTF_8)) +"?=");
//        获取相应的输出流
        OutputStream outputStream = response.getOutputStream();
//        将读取的输入流复制给输出流
        IOUtils.copy(inputStream, outputStream);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

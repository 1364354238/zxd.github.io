package com.example.jsptest;
/**
 * @author dzx
 * @date 2021/10/9 -18:40
 */

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "uploadServlet", value = "/uploadServlet")
public class uploadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("上传了");
        System.out.println(ServletFileUpload.isMultipartContent(request));
//        1.判断是否是多段数据
        if(ServletFileUpload.isMultipartContent(request)){
            System.out.println("创建工厂类");
//            2创建工厂实现类
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
//            3.创建用于解析上传数据的工具类ServletFileUpload
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            try {
//                解析请求
                List<FileItem> list = servletFileUpload.parseRequest(request);
                System.out.println(list.size());
                for (FileItem fileItem : list) {
                    if(fileItem.isFormField()){
//                        普通表单项
                        System.out.println("表单项的属性值："+fileItem.getFieldName());
//                        "UTF-8"解决乱码问题
                        System.out.println("表单项的值：" + fileItem.getString("UTF-8"));
                    }else{
//                        上传文件
                        System.out.println("表单项的属性值："+fileItem.getFieldName());
                        System.out.println("上传的文件名：" + fileItem.getName());
                        fileItem.write(new File("i:\\"+fileItem.getName()));

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}

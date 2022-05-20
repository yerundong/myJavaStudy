package controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import service.UserServiceImpl;

import java.util.List;

public class UploadServlet extends HttpServlet {
    private final UserServiceImpl userServiceImpl = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        if(ServletFileUpload.isMultipartContent((RequestContext) req)){
            ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
            try {
                List<FileItem> fileItems = servletFileUpload.parseRequest((RequestContext) req);
                for (FileItem fileItem : fileItems) {
                    if(fileItem.isFormField()){
                        // 普通表单项
                        System.out.println(fileItem.getFieldName());
                        System.out.println(fileItem.getString());
                    }else{
                        // 上传文件项
                        System.out.println(fileItem.getFieldName());
                        System.out.println(fileItem.getString());
                    }
                }
            } catch (FileUploadException e) {
                e.printStackTrace();
            }
        }
    }
}

package controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * @Description: //TODO
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/5/14 15:03
 */

@Controller
@RequestMapping("/user")
public class UserController {

    // 文件上传：传统文件上传方式
    @RequestMapping(value = "/fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("fileUpload1...");

        // 使用fileUpload组件完成文件上传
        // 指定上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断该路径是否储存在
        File file = new File(path);
        if (!file.exists()) { // 如果此文件夹不存在
            // 创建该文件夹
            file.mkdir();
            System.out.println(path);
        }
        // 解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 解析request
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items) {
            // 判断当前item是否是上传文件选项
            if (item.isFormField()) {
                // 说明是普通表单项
            } else {
                // 说明是上传文件项
                // 获取上传文件的名称
                String filename = item.getName();
                // 把文件名称设置为唯一值
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid+"_"+filename;
                // 完成文件上传
                item.write(new File(path, filename));
                // 删除临时文件(上传的文件如果大于10KB会产生临时文件)
                item.delete();
            }
        }

        return "success";
    }

    // 文件上传：SpringMVC文件上传方式
    @RequestMapping(value = "/fileUpload2")
    // MultipartFile的对象upload与表单（<input type="file" name="upload" /><br/>）的文件选项upload名字必须一样
    public String fileUpload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("fileUpload2...");

        // 使用fileUpload组件完成文件上传
        // 指定上传的位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // 判断该路径是否储存在
        File file = new File(path);
        if (!file.exists()) { // 如果此文件夹不存在
            // 创建该文件夹
            file.mkdir();
            System.out.println(path);
        }

        // 获取上传文件的名称
        String filename = upload.getOriginalFilename();
        // 把文件名称设置为唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;
        // 完成文件上传
        upload.transferTo(new File(path, filename));

        return "success";
    }

    // 文件上传：跨服务器文件上传
    @RequestMapping(value = "/fileUpload3")
    // MultipartFile的对象upload与表单（<input type="file" name="upload" /><br/>）的文件选项upload名字必须一样
    public String fileUpload3(MultipartFile upload) throws Exception {
        System.out.println("fileUpload3...");

        // 定义上传文件服务器路径
        String path = "http://localhost:9090/SpringMVC_03_fileUploadServer/uploads/";
        // 判断该路径是否储存在
        File file = new File(path);
        if (!file.exists()) { // 如果此文件夹不存在
            // 创建该文件夹
            file.mkdir();
            System.out.println(path);
        }

        // 获取上传文件的名称
        String filename = upload.getOriginalFilename();
        // 把文件名称设置为唯一值
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;

        // 创建客户端对象
        Client client = Client.create();
        // 和图片服务器连接
        WebResource webResource = client.resource(path + filename);
        // 上传文件
        webResource.put(upload.getBytes());

        return "success";
    }


}

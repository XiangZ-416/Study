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
 * @Date:Create�� 2020/5/14 15:03
 */

@Controller
@RequestMapping("/user")
public class UserController {

    // �ļ��ϴ�����ͳ�ļ��ϴ���ʽ
    @RequestMapping(value = "/fileUpload1")
    public String fileUpload1(HttpServletRequest request) throws Exception {
        System.out.println("fileUpload1...");

        // ʹ��fileUpload�������ļ��ϴ�
        // ָ���ϴ���λ��
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // �жϸ�·���Ƿ񴢴���
        File file = new File(path);
        if (!file.exists()) { // ������ļ��в�����
            // �������ļ���
            file.mkdir();
            System.out.println(path);
        }
        // ����request���󣬻�ȡ�ϴ��ļ���
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // ����request
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items) {
            // �жϵ�ǰitem�Ƿ����ϴ��ļ�ѡ��
            if (item.isFormField()) {
                // ˵������ͨ����
            } else {
                // ˵�����ϴ��ļ���
                // ��ȡ�ϴ��ļ�������
                String filename = item.getName();
                // ���ļ���������ΪΨһֵ
                String uuid = UUID.randomUUID().toString().replace("-", "");
                filename = uuid+"_"+filename;
                // ����ļ��ϴ�
                item.write(new File(path, filename));
                // ɾ����ʱ�ļ�(�ϴ����ļ��������10KB�������ʱ�ļ�)
                item.delete();
            }
        }

        return "success";
    }

    // �ļ��ϴ���SpringMVC�ļ��ϴ���ʽ
    @RequestMapping(value = "/fileUpload2")
    // MultipartFile�Ķ���upload�����<input type="file" name="upload" /><br/>�����ļ�ѡ��upload���ֱ���һ��
    public String fileUpload2(HttpServletRequest request, MultipartFile upload) throws Exception {
        System.out.println("fileUpload2...");

        // ʹ��fileUpload�������ļ��ϴ�
        // ָ���ϴ���λ��
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        // �жϸ�·���Ƿ񴢴���
        File file = new File(path);
        if (!file.exists()) { // ������ļ��в�����
            // �������ļ���
            file.mkdir();
            System.out.println(path);
        }

        // ��ȡ�ϴ��ļ�������
        String filename = upload.getOriginalFilename();
        // ���ļ���������ΪΨһֵ
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;
        // ����ļ��ϴ�
        upload.transferTo(new File(path, filename));

        return "success";
    }

    // �ļ��ϴ�����������ļ��ϴ�
    @RequestMapping(value = "/fileUpload3")
    // MultipartFile�Ķ���upload�����<input type="file" name="upload" /><br/>�����ļ�ѡ��upload���ֱ���һ��
    public String fileUpload3(MultipartFile upload) throws Exception {
        System.out.println("fileUpload3...");

        // �����ϴ��ļ�������·��
        String path = "http://localhost:9090/SpringMVC_03_fileUploadServer/uploads/";
        // �жϸ�·���Ƿ񴢴���
        File file = new File(path);
        if (!file.exists()) { // ������ļ��в�����
            // �������ļ���
            file.mkdir();
            System.out.println(path);
        }

        // ��ȡ�ϴ��ļ�������
        String filename = upload.getOriginalFilename();
        // ���ļ���������ΪΨһֵ
        String uuid = UUID.randomUUID().toString().replace("-", "");
        filename = uuid+"_"+filename;

        // �����ͻ��˶���
        Client client = Client.create();
        // ��ͼƬ����������
        WebResource webResource = client.resource(path + filename);
        // �ϴ��ļ�
        webResource.put(upload.getBytes());

        return "success";
    }


}

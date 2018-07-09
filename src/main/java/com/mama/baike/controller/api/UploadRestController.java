package com.mama.baike.controller.api;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mama.baike.annotation.AuthIgnore;
import com.mama.baike.common.ResultBody;
import com.mama.baike.service.UploadService;
import com.mongodb.gridfs.GridFSDBFile;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

@RestController
@RequestMapping("/api/upload")
public class UploadRestController {

    @Autowired
    private UploadService uploadService;
    /**
     * 上传图片
     * @return
     */
    @AuthIgnore
    @RequestMapping("/img")
    public ResultBody uploadImg(@RequestParam("file") MultipartFile multipartFile) throws FileUploadException, IOException
    {
        ResultBody resultBody = new ResultBody();
        String filename = multipartFile.getOriginalFilename();
        String fileTxt = filename.substring(filename.lastIndexOf(".")+1);
        byte[] filebuf = multipartFile.getBytes();
        if(filebuf == null || filebuf.length == 0 )
        {
            resultBody.setCode(500);
            resultBody.setMessage("文件为空");
            return resultBody;
        }

        File uploadFile = File.createTempFile(UUID.randomUUID().toString(),fileTxt);
        multipartFile.transferTo(uploadFile);
        uploadService.SaveFile("file",uploadFile,filename,filename);
        return resultBody;
    }

    @AuthIgnore
    @RequestMapping("/img/index")
    public ResultBody getImg(HttpServletRequest request , HttpServletResponse response) throws FileUploadException, IOException
    {
        String imgeName = request.getParameter("imgeName");
        ResultBody resultBody = new ResultBody();
        GridFSDBFile gridFSDBFile= uploadService.retrieveFileOne("file",imgeName);

        if (gridFSDBFile != null) {
            OutputStream sos = response.getOutputStream();
            response.setContentType("application/octet-stream");
            // 获取原文件名
            String name = (String) gridFSDBFile.get("filename");
            String fileName = new String(name.getBytes("GBK"), "ISO8859-1");
            // 设置下载文件名
            response.addHeader("Content-Disposition", "attachment; filename=\""	+ fileName + "\"");
            // 向客户端输出文件
            gridFSDBFile.writeTo(sos);
            sos.flush();
            sos.close();
        }

        return resultBody;
    }

}

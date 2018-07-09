package com.mama.baike.controller.api;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mama.baike.annotation.AuthIgnore;
import com.mama.baike.common.ResultBody;
import com.mama.baike.service.UploadService;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

}

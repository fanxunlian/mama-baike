package com.mama.baike.controller.api;

import com.mama.baike.annotation.AuthIgnore;
import com.mama.baike.common.ResultBody;
import com.mama.baike.service.MongoService;
import com.mama.baike.service.UploadService;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api/upload")
public class UploadRestController {

    @Autowired
    private UploadService uploadService;
    /**
     * 上传图片
     * @param file
     * @return
     */
    @AuthIgnore
    @RequestMapping("/img")
    public ResultBody uploadImg(@RequestParam("file") MultipartFile file) throws FileUploadException, IOException
    {
        ResultBody resultBody = new ResultBody();
        String filename = file.getOriginalFilename();
        String fileTxt = filename.substring(filename.lastIndexOf(".")+1);
        byte[] filebuf = file.getBytes();
        if(filebuf == null || filebuf.length == 0 )
        {
            resultBody.setCode(500);
            resultBody.setMessage("文件为空");
            return resultBody;
        }
        File uploadFile = null;

        uploadService.SaveFile("file",uploadFile,filename,filename);


        return resultBody;
    }

}

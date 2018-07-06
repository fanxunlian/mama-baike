package com.mama.baike.service.impl;

import com.mama.baike.service.UploadService;
import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.io.File;

@Service("uploadService")
public class UploadServiceImp implements UploadService {

    @Autowired
    private MongoTemplate mongoTemplate;
    /**
     * 存储文件
     * @param collectionName 集合名
     */
    public void SaveFile(String collectionName, File file, String fileId, String filename) {
        try {
            DB db = mongoTemplate.getDb();
            // 存储fs的根节点
            GridFS gridFS = new GridFS(db, collectionName);
            GridFSInputFile gfs = gridFS.createFile(file);
            gfs.put("filename", fileId);
            gfs.put("contentType", filename.substring(filename.lastIndexOf(".")));
            gfs.save();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("存储文件时发生错误！！！");
        }
    }

    // 取出文件
    public GridFSDBFile retrieveFileOne(String collectionName, String fileId) {
        try {
            DB db = mongoTemplate.getDb();
            // 获取fs的根节点
            GridFS gridFS = new GridFS(db, collectionName);
            GridFSDBFile dbfile = gridFS.findOne(fileId);
            if (dbfile != null) {
                return dbfile;
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }
}

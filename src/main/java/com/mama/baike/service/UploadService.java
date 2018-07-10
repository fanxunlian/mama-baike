package com.mama.baike.service;

import com.mongodb.gridfs.GridFSDBFile;

import java.io.File;

public interface UploadService {

    public void SaveFile(String collectionName, File file, String fileId, String filename);

    public GridFSDBFile retrieveFileOne(String collectionName, String fileId);
}

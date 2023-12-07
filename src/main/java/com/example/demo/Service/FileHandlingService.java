package com.example.demo.Service;

import org.springframework.core.io.Resource;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.UnknownHostException;
import java.nio.file.Path;
import java.util.List;

public interface FileHandlingService {
    Path saveFileToServer(byte[] file,String fileName, Long id,String fileType) throws Exception;
    byte[] getFileByFullPath(String fullpath) throws Exception;
}

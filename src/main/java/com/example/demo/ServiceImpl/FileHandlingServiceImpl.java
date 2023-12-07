package com.example.demo.ServiceImpl;

import com.example.demo.Core.FileType;
import com.example.demo.Entity.User;
import com.example.demo.Service.CourseService;
import com.example.demo.Service.FileHandlingService;
import org.apache.catalina.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FileHandlingServiceImpl implements FileHandlingService {

    private final Environment environment;
    private Path Location;
    @Autowired
    public FileHandlingServiceImpl(Environment environment){
        this.environment = environment;
    }

    private String HostAddress;

    private String PathHeader = "/Users/ahmadovmt/Documents/";

    @Override
    public Path saveFileToServer(byte[] file,String fileName,Long id,String fileType) throws Exception {
        File directory = new File(PathHeader);

        if(fileType == FileType.CoverPhoto.toString()||
            fileType == FileType.Certificate.toString()||
            fileType == FileType.Content.toString()||
            fileType == FileType.DemoVideo.toString())
        {
            directory = new File(PathHeader + "Courses/" +id.toString());
            if(!directory.exists()){
                directory.mkdir();
            }

            directory = new File(directory.getPath() +"/" + fileType);
            if(!directory.exists()){
                directory.mkdir();
            }

            Location = Paths.get(directory.getPath(),fileName);
            Files.write(Location,file);
        }
        else if(fileType == FileType.UserCertificate.toString()){
            directory = new File(PathHeader + "Users/" + id.toString());
            if(!directory.exists()){
                directory.mkdir();
            }
            directory = new File(PathHeader + "Users/" + id.toString() + "/Certificate");
            if(!directory.exists()){
                directory.mkdir();
            }
            Location = Paths.get(directory.getPath(),fileName);
            Files.write(Location,file);
        }
        return Location;
    }

    @Override
    public byte[] getFileByFullPath(String fullpath) throws Exception{
        if(fullpath == null){
            throw new Exception("fullpath is null");
        }
        Path path = Paths.get(fullpath);
        byte[] response = Files.readAllBytes(path);
        //File file = new File(resource.getURI())

        return response;
    }
}

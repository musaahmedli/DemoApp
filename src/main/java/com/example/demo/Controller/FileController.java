package com.example.demo.Controller;

import com.example.demo.Service.FileHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/Files")
public class FileController {
    private final FileHandlingService fileHandlingService;

    @Autowired
    public FileController(FileHandlingService fileHandlingService){
        this.fileHandlingService = fileHandlingService;
    }

    @PostMapping("/createFile")
    public ResponseEntity<String> saveFile(MultipartFile file,Long courseId){
        if(file == null){
            return new ResponseEntity<String>("file is null", HttpStatus.BAD_REQUEST);
        }
        try {

            //fileHandlingService.saveFileToServer(file, courseId);
            return new ResponseEntity<String>("file saved successfully",HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<String>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}

package com.am.jsa.endpoints;


import com.am.jsa.common.constants.UrlConstant;
import com.am.jsa.common.service.FileUploadService;
import com.am.jsa.logger.AmLogger;
import com.am.jsa.servicehandler.AmResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
@RequestMapping(UrlConstant.BASE_SERVICE_URL + UrlConstant.FILE_URL)
public class FileUploadRestfulService {

    @Autowired
    FileUploadService fileUploadService;


    @PostMapping("/upload")
    public ResponseEntity uploadFile(
            @RequestParam("name") MultipartFile file) {
        return AmResponse.successResponse(fileUploadService.uploadFile(file));

    }

    @PutMapping("delete-document/")
    public ResponseEntity deleteDocument(@RequestParam("fileName") String fileName) throws IOException{
        fileUploadService.deleteFile(fileName);
        return AmResponse.successResponse("File Deleted");
    }

    @GetMapping("/get-uploaded-file")
    public ResponseEntity getFile(@RequestParam("fileName") String fileName) throws Exception{
        File file = new File(UrlConstant.FILE_PATH + UrlConstant.UPLOAD_LOC + fileName);
        MediaType mediaType= MediaType.IMAGE_JPEG;
        String[] fileExt= fileName.split("\\.");
        if (fileExt[1].equalsIgnoreCase("pdf")){
              try{
                  mediaType = MediaType.APPLICATION_PDF;
              }catch(Exception e){
                 AmLogger.error(this.getClass(),e.getMessage());
              }
        }
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(mediaType)
                .body(resource);
    }
}

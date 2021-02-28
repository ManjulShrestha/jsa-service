package com.am.jsa.endpoints;


import com.am.jsa.common.constants.UrlConstant;
import com.am.jsa.common.service.FileUploadForm;
import com.am.jsa.common.service.FileUploadService;

import com.am.jsa.servicehandler.AmResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@RestController
@RequestMapping(UrlConstant.BASE_SERVICE_URL + UrlConstant.FILE_URL)
public class FileUploadRestfulService {

    @Autowired
    FileUploadService fileUploadService;


//    @PostMapping("/upload")
//    public ResponseEntity uploadFile(@MultipartForm FileUploadForm form,
//                                     @RequestParam("fileName") String filename) {
//        return AmResponse.successResponse(fileUploadService.uploadFile(form, filename));
//
//    }

    @PutMapping("delete-document/")
    public ResponseEntity deleteDocument(@RequestParam("fileName") String fileName) throws IOException{
        fileUploadService.deleteFile(fileName);
        return AmResponse.successResponse("File Deleted");
    }

//    @GetMapping("/get-uploaded-file")
//    public ResponseEntity getFile(@RequestParam("fileName") String fileName) {
//        File file = new File(UrlConstant.FILE_PATH + UrlConstant.UPLOAD_LOC + fileName);
//        String contentType = "image/jpeg";
//        String[] fileExt= fileName.split("\\.");
//        if (fileExt[1].equalsIgnoreCase("pdf")){
//              try{
//            contentType = Files.probeContentType(file.toPath());
//        }catch(Exception e){
//            AmLogger.error(this.getClass(),e.getMessage());
//        }
//        }
//
//        return Response.ok(file)
//                .header("Content-Type",contentType).build();
//    }
}

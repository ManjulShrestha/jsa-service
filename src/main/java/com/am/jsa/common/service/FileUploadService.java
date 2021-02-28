package com.am.jsa.common.service;

import com.am.jsa.common.SHAHash;
import com.am.jsa.common.constants.UrlConstant;
import com.am.jsa.common.nas.LocalNas;
import org.springframework.stereotype.Component;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class FileUploadService {




	public String uploadFile(FileUploadForm form,  String fileName) {

		String[] fileNameExt=fileName.split("\\.");
		String fileNameHash=getHashedUniqueName(fileName);
		try {
			writeFile(form.getData(), UrlConstant.FILE_PATH+UrlConstant.UPLOAD_LOC+fileNameHash+"."+fileNameExt[1]);
			if(!fileNameExt[1].equalsIgnoreCase("pdf")) {
				createThumbnail(fileNameHash, fileNameExt[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return fileNameHash+"."+fileNameExt[1];
	}

	public void writeFile(byte[] content, String filename) throws Exception {

		File file = new File(filename);

		if (!file.exists()) {
			file.createNewFile();
		}

		FileOutputStream fop = new FileOutputStream(file);

		fop.write(content);
		fop.flush();
		fop.close();
	}

	public void deleteFile(String fileName) throws IOException {
		LocalNas nas=new LocalNas();
		nas.removeFromFinal(fileName);
	}


	private static String getHashedUniqueName(String fileName) {
		// Get current date
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd H:m.s.S");
		String currentTime = LocalDateTime.now().format(formatter);

		// Get a unique string to hash: time, user, upload document type, uploaded filename & filesize
		String uniqueString = currentTime + "@"
				+ fileName;

		// Hash the unique string
		uniqueString = SHAHash.hash(uniqueString);

		// append extension to the hashed string
//		String extension = "pdf";
//		if (!extension.isEmpty()) {
//			uniqueString += "." + extension;
//		}

		return uniqueString;
	}

	public void createThumbnail(String fileName, String ext) throws IOException {
		String fileCompletePath=UrlConstant.FILE_PATH+UrlConstant.UPLOAD_LOC+fileName+"."+ext;
		BufferedImage img = ImageIO.read(new File(fileCompletePath));
		BufferedImage scaledImg =  new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		//img.createGraphics().drawImage(ImageIO.read(new File(fileCompletePath)).getScaledInstance(100, 100, Image.SCALE_SMOOTH),0,0,null);
		ImageIO.write(scaledImg, "jpg", new File(UrlConstant.FILE_PATH+UrlConstant.UPLOAD_LOC+"thumb_"+fileName+"."+ext));
	}
}

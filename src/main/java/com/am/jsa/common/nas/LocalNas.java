package com.am.jsa.common.nas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class LocalNas implements NasUtil {

	public static final String NFS_MOUNT_POINT = "/share/";
	public static final String UPLOAD_LOC_TMP = "uploads-tmp/";
	public static final String UPLOAD_LOC = "uploads/";
	public static final String ATTACHMENT_PATH="uploads-attachment/";

	// Move file from source path to destination path
	@Override
	public void moveFile(String sourceFilename, String destFilename) throws IOException {
		Path sourceFile = Paths.get(sourceFilename);
		Path destinationFile = Paths.get(destFilename);
		Files.move(sourceFile, destinationFile, StandardCopyOption.ATOMIC_MOVE);
	}

	// Remove a file if it exists, no error thrown if file is not found
	@Override
	public void removeFile(String filename) throws IOException {
		Path file = Paths.get(filename);
		Files.deleteIfExists(file);
	}

	// Move file from temporary location to permanent location
	public void moveFromTemp(String sourceFilename, String destFilename) throws IOException {
		Path sourceFile = Paths.get(NFS_MOUNT_POINT, UPLOAD_LOC_TMP, sourceFilename);
		Path destinationFile = Paths.get(NFS_MOUNT_POINT, UPLOAD_LOC, destFilename);
		Files.move(sourceFile, destinationFile, StandardCopyOption.ATOMIC_MOVE);
	}

	// Copy file from temporary location to permanent location
	public void copyFromTemp(String sourceFilename, String destFilename) throws IOException {
		Path sourceFile = Paths.get(NFS_MOUNT_POINT, UPLOAD_LOC_TMP, sourceFilename);
		Path destinationFile = Paths.get(NFS_MOUNT_POINT, UPLOAD_LOC, destFilename);
		Files.copy(sourceFile, destinationFile,StandardCopyOption.REPLACE_EXISTING);
	}

	// Remove file from temporary location
	public void removeFromTemp(String filename) throws IOException {
		Path file = Paths.get(NFS_MOUNT_POINT, UPLOAD_LOC_TMP, filename);
		Files.deleteIfExists(file);
	}

	// Remove file from final location
	public void removeFromFinal(String filename) throws IOException {
		Path file = Paths.get(NFS_MOUNT_POINT, UPLOAD_LOC, filename);
		Files.deleteIfExists(file);
	}
}

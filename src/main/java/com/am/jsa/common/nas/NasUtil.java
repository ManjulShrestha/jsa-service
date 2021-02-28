package com.am.jsa.common.nas;

import java.io.IOException;

public interface NasUtil {
	public void moveFile(String sourceFileName, String destinationFileName) throws IOException;
	public void moveFromTemp(String sourceFileName, String destinationFileName) throws IOException;
	void removeFile(String filename) throws IOException;
}

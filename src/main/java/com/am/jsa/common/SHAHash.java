package com.am.jsa.common;


import org.apache.tomcat.util.buf.HexUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class SHAHash {

	 private static final String SALT_1 = "zm7?Ir0C:<w$gzrTG|vOq<MoA8S!dnHSS3(+Ii,F'rk4zVNv!K"; // Random String 1
	    private static final String SALT_2 = "@,4.Ry,yIw6*@'rddFuk'(Mn:|&Xn76l,+8f@?*vJI(lH(mV1Z"; // Random String 2

	    public static String hash(String text) {
	        try {
	        
	        	MessageDigest digest=MessageDigest.getInstance("SHA-256");	           
	           
	            byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
	            return HexUtils.toHexString(hash);
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            return null;
	        }
	    }

	    public static String saltedHash(String text) {
	        return hash(SALT_1 + text + SALT_2);
	    }

	    public static String hashPassword(String plainPassword) {
	        return saltedHash(plainPassword);
	    }
	    
	    public static String fileHash(InputStream fis) throws IOException {
	        try {
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            byte[] buffer = new byte[8192];
	            int numOfBytesRead;
	            while( (numOfBytesRead = fis.read(buffer)) > 0){
	                md.update(buffer, 0, numOfBytesRead);
	            }
	            byte[] hash = md.digest();
				return HexUtils.toHexString(hash);
	        } catch (Exception ex) {
	            // this doesn't occur
	            System.out.println(ex);
	        }
	       return null;
	    }

}

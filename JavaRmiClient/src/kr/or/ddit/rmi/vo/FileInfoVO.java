package kr.or.ddit.rmi.vo;

import java.io.Serializable;

/**
 *  파일 전송용 VO클래스
 * @author pc13
 *
 */
public class FileInfoVO implements Serializable{
	private String fileName;	// 파일명 
	private byte[] fileData;		// 파일내용
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	
}

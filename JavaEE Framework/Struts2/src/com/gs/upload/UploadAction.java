package com.gs.upload;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.gs.common.Constants;
// import com.gs.common.FileUtil;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {

	private static final long serialVersionUID = 274037903798565700L;
	
	private String message;
	
	private File file; // �������������ļ��������file��name����һ��
	private String fileFileName; // ���������ļ����ƣ�����file��name+FileName
	
	public String getMessage() {
		return message;
	}
	
	public void setFile(File file) {
		this.file = file;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String execute() {
		message = "�ϴ��ɹ�";
		mkUpload();
		if (file != null) {
			long fileSize = file.length();
			// FileUtil.saveFile(file, Constants.UPLOAD_PATH + "/" + fileFileName);
			try {
				FileUtils.copyFile(file, new File(Constants.UPLOAD_PATH + "/" + fileFileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(fileFileName + ": " + fileSize);
		}
		return SUCCESS;
	}
	
	private void mkUpload() {
		File file = new File(Constants.UPLOAD_PATH);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

}

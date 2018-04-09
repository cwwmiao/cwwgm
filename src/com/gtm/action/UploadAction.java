package com.gtm.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

@Controller("uploadAction")
@Scope("prototype")
public class UploadAction extends ActionSupport{
	private int id;
	private File file;
	String url = ServletActionContext.getServletContext().getRealPath("/")
			.replace("\\", "/");
	
	public String uploadthesis(){	
		System.out.println(id);
		System.out.println(file);
		String filename=id+".doc";
		String url1 = url + "files/thesisfiles/" + filename;
		uploadpicture(url1, file);		
		return SUCCESS;
	}
	
	
	public void uploadpicture(String fileurl, File upload) {
		if (upload != null) {
			try {
				FileOutputStream fos = new FileOutputStream(fileurl);
				FileInputStream fis = new FileInputStream(upload);
				byte[] buffer = new byte[1024];
				int len = 0;
				while ((len = fis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fis.close();
				fos.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}

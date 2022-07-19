package com.lec.test.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Service
public class FileUploadService {
	public boolean fileUp(MultipartHttpServletRequest mRequest,
						  ModelAndView mav) {
		boolean isUpload = false;
		String uploadPath = mRequest.getRealPath("upload/");
		String backupPath = "D:/webPro_ryu/source/09_Spring/test/src/main/webapp/upload";
		String[] filenames = new String [3];
		int i = 0;
		Iterator<String> params = mRequest.getFileNames();// 오리지널 파일명
		
		while(params.hasNext()) {
			String param = params.next();
			System.out.println(i + "번째 파라미터 이름 : " + param);
			MultipartFile mFile = mRequest.getFile(param);
			filenames[i] = mFile.getOriginalFilename();//param으로 첨부파일의 오리지널 파일명
			if(filenames[i]!=null && !filenames[i].equals("")) {
				if(new File(uploadPath + filenames[i]).exists()) {
					filenames[i] = System.currentTimeMillis() + filenames[i];
				}
				try {
					mFile.transferTo(new File(uploadPath + filenames[i]));
					System.out.println("서버에 저장된 파일 : " + uploadPath + filenames[i]);
					System.out.println("백업된 복사 파일 : " + backupPath + filenames[i]);
					isUpload = filecopy(uploadPath + filenames[i], backupPath + filenames[i]);
				} catch (Exception e){
					System.out.println(e.getMessage());
				}
			}// if 첨부여부
			i++; // 속성값 중가
		}// while;
		mav.addObject("filenames", filenames);
		return isUpload;
	}
	

	private boolean filecopy(String serverFile, String backupFile) {
		boolean isCopy = false;
		InputStream is = null;
		OutputStream os = null;
		try {
			File file = new File(serverFile);
			is = new FileInputStream(file);
			os = new FileOutputStream(backupFile);
			byte[] buff = new byte[(int) file.length()];
			while(true) {
				int nReadByte = is.read(buff);
				if(nReadByte == -1) break;
				os.write(buff, 0, nReadByte);
			}
			isCopy = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(os!=null) os.close();
				if(is!=null) is.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return  isCopy;
	}

}

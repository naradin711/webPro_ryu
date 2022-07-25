package com.lec.ch19.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.lec.ch19.dao.BookDao;
import com.lec.ch19.dto.BookDto;
import com.lec.ch19.util.Paging;

@Repository
public class BookServiceImpl implements BookService {
	
	@Autowired
	public BookDao bookDao;
	
	String backupPath="D:/webPro_ryu/source/09_Spring/ch19_memberBookUp/src/main/webapp/bookImgFileUpload/";
	
	@Override
	public List<BookDto> mainList() {
		BookDto bookDto = new BookDto();
		return bookDao.mainList(bookDto);
	}

	@Override
	public List<BookDto> bookList(String pageNum) {
		Paging paging = new Paging(bookDao.totCntBook(), pageNum, 3, 3);
		BookDto bookDto = new BookDto();
		bookDto.setStartRow(paging.getStartRow());
		bookDto.setEndRow(paging.getEndRow());
		return bookDao.bookList(bookDto);
	}

	@Override
	public int totCntBook() { 
		return bookDao.totCntBook();
	}

	@Override
	public BookDto getDetailBook(int bnum) { 
		return bookDao.getDetailBook(bnum);
	}

//	@Override
//	public int registerBook(BookDto bookDto, MultipartHttpServletRequest mRequest) {
//		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
//		Iterator<String> params = mRequest.getFileNames(); // tempBimg1, temptBimg2
//		String[] bimg = new String[2];
//		int idx  = 0;
//		while (params.hasNext()) {
//			String param = params.next(); // 마라미터의 다음 객체
//			MultipartFile mFile = mRequest.getFile(param);// 파라미터에 첨부된 파일 객체
//			bimg[idx] = mFile.getOriginalFilename();
//			if(bimg[idx]!=null && !bimg[idx].equals("")) {
//				if(new File(uploadPath + bimg[idx]).exists()) {
//					bimg[idx] = System.currentTimeMillis() + "_" + bimg[idx];
//					
//				}// if
//				try {
//					mFile.transferTo(new File(uploadPath + bimg[idx]));
//					System.out.println("서버파일 : "+ uploadPath + bimg[idx]);
//					System.out.println("백업파일 : "+ backupPath + bimg[idx]);
//					Boolean result = fileCopy(uploadPath + bimg[idx], backupPath + bimg[idx] );
//					System.out.println(result ? idx+"번째 백업 성공": idx+"번째 백업 실패");
//				} catch (Exception e) {
//					System.out.println(e.getMessage()+"BookService register error");
//				}  
//			} else {
//				
//			}// if
//			idx++;
//		}//while - bimg 배열에 파일 이름 저장
//		bookDto.setBimg1(bimg[0]); // 첫번째 청구할 파일 이름
//		bookDto.setBimg2(bimg[1]); // 두번째 청구할 파일 이름
//		return bookDao.registerBook(bookDto); // DB INSERT
//	}
	@Override
	public int registerBook(BookDto bookDto, MultipartHttpServletRequest mRequest) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // tempBimg1, temptBimg2
		String[] bimg = new String[2];
		int idx  = 0;
		while (params.hasNext()) {
			String param = params.next(); // 마라미터의 다음 객체
			MultipartFile mFile = mRequest.getFile(param);// 파라미터에 첨부된 파일 객체
			bimg[idx] = mFile.getOriginalFilename();
			if(bimg[idx]!=null && !bimg[idx].equals("")) {
				if(new File(uploadPath + bimg[idx]).exists()) {
					bimg[idx] = System.currentTimeMillis() + "_" + bimg[idx];
					
				}// if
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx]));
					System.out.println("서버파일 : "+ uploadPath + bimg[idx]);
					System.out.println("백업파일 : "+ backupPath + bimg[idx]);
					Boolean result = fileCopy(uploadPath + bimg[idx], backupPath + bimg[idx] );
					System.out.println(result ? idx+"번째 백업 성공": idx+"번째 백업 실패");
				} catch (Exception e) {
					System.out.println(e.getMessage()+"BookService register error");
				}  
			} else {
				
			}// if
			idx++;
		}//while - bimg 배열에 파일 이름 저장
		bookDto = new BookDto();
		bookDto.setBnum(Integer.parseInt(mRequest.getParameter("bnum")));
		bookDto.setBtitle(mRequest.getParameter("btitle"));
		bookDto.setBwriter(mRequest.getParameter("bwriter"));
		bookDto.setBimg1(bimg[0]); // 첫번째 청구할 파일 이름
		bookDto.setBimg2(bimg[1]); // 두번째 청구할 파일 이름
		bookDto.setBinfo(mRequest.getParameter("binfo"));
		return bookDao.registerBook(bookDto); // DB INSERT
	}
	private boolean fileCopy(String serverFile, String backupFile) {
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
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		return isCopy;
	}
	@Override
	public int modifyBook(BookDto bookDto, MultipartHttpServletRequest mRequest) {
		String uploadPath = mRequest.getRealPath("bookImgFileUpload/");
		Iterator<String> params = mRequest.getFileNames(); // tempBimg1, temptBimg2
		String[] bimg = new String[2];
		int idx  = 0;
		while (params.hasNext()) {
			String param = params.next(); // 마라미터의 다음 객체
			MultipartFile mFile = mRequest.getFile(param);// 파라미터에 첨부된 파일 객체
			bimg[idx] = mFile.getOriginalFilename();
			if(bimg[idx]!=null && !bimg[idx].equals("")) {
				if(new File(uploadPath + bimg[idx]).exists()) {
					bimg[idx] = System.currentTimeMillis() + "_" + bimg[idx];
					
				}// if
				try {
					mFile.transferTo(new File(uploadPath + bimg[idx]));
					System.out.println("서버파일 : "+ uploadPath + bimg[idx]);
					System.out.println("백업파일 : "+ backupPath + bimg[idx]);
					Boolean result = fileCopy(uploadPath + bimg[idx], backupPath + bimg[idx] );
					System.out.println(result ? idx+"번째 백업 성공": idx+"번째 백업 실패");
				} catch (Exception e) {
					System.out.println(e.getMessage()+"BookService register error");
				}  
			} else {
				
			}// if
			idx++;
		}//while - bimg 배열에 파일 이름 저장
		bookDto.setBimg1(bimg[0]); // 첫번째 청구할 파일 이름
		bookDto.setBimg2(bimg[1]); // 두번째 청구할 파일 이름
		
		return bookDao.modifyBook(bookDto);
	}

}

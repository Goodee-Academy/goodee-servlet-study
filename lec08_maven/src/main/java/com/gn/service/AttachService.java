package com.gn.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;

import com.gn.dto.Attach;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class AttachService {
	// 1. 업로드할 디렉토리 반환
	public static File getUploadDirectory() {
		String dirPath = "D://upload/board";
		
		File uploadDir = new File(dirPath);
		if (!uploadDir.exists()) uploadDir.mkdirs();
		
		return uploadDir;
	}
	
	// 2. 정보 내 파일 추출
	public static Attach handleUploadFile(HttpServletRequest request, File uploadDir) {
		// form에서 파일 가져오기 -> name 속성 기준
		Attach result = null;
		
		try {
			Part filePart = request.getPart("boardFile");
			
			if (filePart.getSize() > 0) result = getFileMeta(filePart, uploadDir);
		} catch (IOException | ServletException e) { e.printStackTrace(); }
		
		return result;
	}
	
	// 3. 서버에 파일 원본 저장 + 파일의 메타데이터 추출
	public static Attach getFileMeta(Part filePart, File uploadDir) {
		// 원본 파일 이름
		String originFileName = filePart.getSubmittedFileName();
		
		// 확장자 분리
		String ext = FilenameUtils.getExtension(originFileName);
		
		// 순수 파일 이름 추출
		String fileName = originFileName.substring(0, originFileName.indexOf("."));
		
		// UUID 사용 -> 중복 방지
		String saveName = UUID.randomUUID().toString().replaceAll("-", "");
		
		// 중복 방지 파일명 + 확장자
		File file = new File(uploadDir, saveName + "." + ext);
		
		// 파일 서버에 저장
		try (
				InputStream inputStream = filePart.getInputStream();
				OutputStream outputStream = Files.newOutputStream(file.toPath())) {
			// output 경로에 input에 담긴 데이터 전송
			inputStream.transferTo(outputStream);
			
		} catch (Exception e) { e.printStackTrace(); }
		
		// 실행 결과 정보를 DTO에 담아서 반환
		Attach attach = new Attach();
		attach.setOriginName(originFileName);
		attach.setRenewName(saveName + "." + ext);
		
		return attach;
	}
}

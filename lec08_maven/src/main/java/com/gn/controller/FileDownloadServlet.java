package com.gn.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import com.gn.dto.Attach;
import com.gn.service.BoardService;

@WebServlet("/fileDownload")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService boardService = new BoardService();
       
  public FileDownloadServlet() {
    super();
  }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int attachNo = Integer.parseInt(request.getParameter("attachNo"));
		Attach attach = boardService.selectAttachByAttachNo(attachNo);
		
		// 유효성 검사
		// 1. 파일의 경로 지정
		String filePath = "D:/upload/board/" + attach.getRenewName();
			
		// 2. 파일 정보가 없는 경우 에러 발생
		if (filePath == null || filePath.trim().equals("")) {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST); // 400
			return;
		}
			
		// 3. 파일이 존재하는지 확인
		File file = new File(filePath);
		if (!file.exists()) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND); // 404
			return;
		}
		
		// 4. 다운로드용 응답 헤더 설정
		response.setContentType("application/octet-stream");
		response.setContentLength((int) file.length());
		
		// 5. 파일명 인코딩
		String encodedName = URLEncoder.encode(attach.getOriginName(), "UTF-8").replaceAll("\\+", "%20");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + encodedName + "\"");
		
		// 6. 파일 데이터 전송
		try (
				InputStream fis = new FileInputStream(file);
				OutputStream out = response.getOutputStream();
			) {
				byte[] buffer = new byte[1024];
				int byteRead;
				
				while ((byteRead = fis.read(buffer)) != -1) {
					out.write(buffer, 0, byteRead);
				}
			} catch (Exception e) { e.printStackTrace(); }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

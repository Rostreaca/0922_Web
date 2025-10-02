package com.kh.java.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.kh.java.board.model.service.BoardService;
import com.kh.java.board.model.vo.Attachment;
import com.kh.java.board.model.vo.Board;
import com.kh.java.common.MyRenamePolicy;
import com.kh.java.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/insert.image")
public class ImageInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImageInsertController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1) 인코딩
		request.setCharacterEncoding("UTF-8");
		
		// 2) 첨부파일 -> multi/form-data -> 조건문 -> 서버로 파일을 올려주자
		if(ServletFileUpload.isMultipartContent(request)){
			
			// 1) MultipartRequest 생성
			// 1_1. 용량 제한
			int maxSize = 100  * 1024 * 1024;
			
			// 1_2. 경로
			String savePath = request.getServletContext().getRealPath("/resources/image_upfiles");
			
			// 2) 객체 생성과 동시에 파일 업로드
			MultipartRequest multiRequest = 
					new MultipartRequest(request, savePath, maxSize, "UTF-8" 
							            ,new MyRenamePolicy());
			
			// 파일 업로드 끝!
			
			// 보드랑 attachment랑 insert
			
			// 3) multiRequest 참조해서 값 뽑기 => getParameter() 호출
			HttpSession session = request.getSession();
			Member member = (Member)session.getAttribute("userInfo");
			Long userNo = member.getUserNo();
			
			String boardTitle = multiRequest.getParameter("title");
			String boardContent = multiRequest.getParameter("content");
			String boardWriter = String.valueOf(userNo);

			
			// 4) 가공
			Board board = new Board();
			board.setBoardTitle(boardTitle);
			board.setBoardContent(boardContent);
			board.setBoardWriter(boardWriter);
			
			// Attachment
			// => 사진게시글 작성 양식 required
			// 게시글 당 최소 한 개의 첨부파일은 존재
			
			
			
			/*
			if(multiRequest.getOriginalFileName("file1") != null) {
				
			}
			*/
			
			List<Attachment> files = new ArrayList();
			
			for(int i=1; i<=4; i++) { // 반복 5회 이상 아닐 시 if가 성능적으로 더 좋음
				
				String key = "file" + i;
//				System.out.println(key);
				// 조건검사 name속성값을 이용해서 파일이 있는가? 없는가?
				if(multiRequest.getOriginalFileName(key) != null) {
					// 파일이 존재한다.
					Attachment at = new Attachment();
					at.setOriginName(multiRequest.getOriginalFileName(key));
					at.setChangeName(multiRequest.getFilesystemName(key));
					at.setFilePath("resources/image_upfiles");
					
					/*
					if("file1".equals(key)) {
						at.setFileLevel(1);
					} else {
						at.setFileLevel(2);
					}
					*/
					
					// 대표이미지 == file1
					at.setFileLevel(i == 1 ? 1 : 2);
					
					
					files.add(at);
				}
				
			}
			// 요청처리 -> 서비스단으로 전달
			new BoardService().insertImage(board, files);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

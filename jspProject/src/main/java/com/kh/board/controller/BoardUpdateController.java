package com.kh.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.board.model.service.BoardSerivce;
import com.kh.board.model.vo.Board;
import com.kh.common.MyFileRenamePolicy;
import com.kh.common.model.vo.Attachment;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class BoardUpdateController
 */
@WebServlet("/update.bo")
public class BoardUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			//1_1) 용량제한크기
			int maxSize = 10 * 1024 * 1024;
			
			//1_2) 물리적 저장경로
			String savePath = request.getSession().getServletContext().getRealPath("/resources/board_upfile/");
			
			//2. 전달된 파일명 수정작업 후 서버에 업로드
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			//3. sql문 실행에 필요한 값 추출해서 vo에 저장
			
			int boardNo = Integer.parseInt(multiRequest.getParameter("bno"));
			String category = multiRequest.getParameter("category");
			String boardTitle = multiRequest.getParameter("title");
			String boardContent = multiRequest.getParameter("content");
			
			Board b = new Board();
			b.setBoardNo(boardNo);
			b.setCategory(category);
			b.setBoardTitle(boardTitle);
			b.setBoardContent(boardContent);
			
			Attachment at = null; // 일단 null로 만들고 넘어온 첨부파일이 있다면 그떄 생성
			if (multiRequest.getOriginalFileName("upfile") != null) {
				//새로 넘어온 첨부파일이 있을 때
				at = new Attachment();
				at.setOriginName(multiRequest.getOriginalFileName("upfile"));
				at.setChangeName(multiRequest.getFilesystemName("upfile"));
				at.setFilePath("resources/board_upfile/");
				
				//기존 첨부파일이 있을 때 => update Attachment(기존첨부파일 번호)
				if (multiRequest.getParameter("originFileNo") != null) {
					at.setFileNo(  Integer.parseInt(  multiRequest.getParameter("originFileNo")  )  );
				} else { //첨부파일이 없을 때 => insert Attachment(현재 게시글 번호)
					at.setRefBoardNo(boardNo);
				}
			} // 새로 넘어온 첨부파일이 없다면 at는 null
			
			
			int result = new BoardSerivce().updateBoard(b, at);
			//새로운 첨부파일x								b, null          =>     board update
			//새로운 첨부파일o, 기존첨부파일o					b, fileNo담긴 at  =>     board update, attachment update
			//새로운 첨부파일o, 기존첨부파일x					b, refBoardNo가 담긴 at =>  board update, attachment insert
			
			if (result > 0) {
				// 성공 => /jsp/detail.bo?bno=해당게스글번호
				request.getSession().setAttribute("alertMsg", "성공적으로 수정하였습니다.");
				response.sendRedirect(request.getContextPath() + "/detail.bo?bno=" + boardNo);
				
			} else {
				request.setAttribute("errorMsg", "게시글 수정 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

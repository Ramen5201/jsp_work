package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;
import com.sun.net.httpserver.Authenticator.Result;

/**
 * Servlet implementation class updateFormController
 */
@WebServlet("/update.no")
public class updateFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateFormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int noticeNo = Integer.parseInt(request.getParameter("num"));
		String noticetitle = request.getParameter("title");
		String noticeContent = request.getParameter("content");
		
		Notice n = new Notice();
		n.noticeNo(noticeNo);
		n.setNoticeTitle(noticetitle);
		n.setNoticeContent(noticeContent);
		
		
		int result = new NoticeService().updateNotice(n);
		
		if (result > 0) { // 성공 => /jsp/detail.no?num=
			
			request.getSession().setAttribute("alertMsg", "성공적으로 공지사항이 변경되었습니다");
			response.sendRedirect(request.getContextPath() + "/detail.no?num=" + noticeNo);
			
		} else { // 실패 => 에러문구가 보여지는 에러페이지
			request.setAttribute("errorMsg", "공지사항 수정에 실패하였습니다.");
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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

package com.kh.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeDeleteController
 */
@WebServlet("/delete.no")
public class NoticeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int noticeNo = Integer.parseInt(request.getParameter("num"));
		
		int result = new NoticeService().deleteNotice(noticeNo);
		
		HttpSession session = request.getSession();
		
		if (result > 0) { // 성공 => /jsp/list.no => url재요청
			// request.getSession().setAttribute("alertMsg", "성공적로 공지사항이 삭제되었습니다");
			// request.sendRedirect(request.getContextPath() + "/list.no");
			session.setAttribute("alertMsg", "성공적으로 공지사항 삭제 되었습니다.");
			session.removeAttribute("noticeNo");
			response.sendRedirect(request.getContextPath() + "/list.no");
		} else {
			// request.setAttribute("errorMsg", "공지사항 삭제 실패");
			// request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			session.setAttribute("alertMsg", "공지사항 삭제 실패하셨습니다");
			response.sendRedirect(request.getContextPath() + "/myPage.me");
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

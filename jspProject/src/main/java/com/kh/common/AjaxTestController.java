package com.kh.common;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class AjaxTestController
 */
@WebServlet("/jqAjax.do")
public class AjaxTestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		System.out.println(name + " : " + age);
		
		// 여러개의 값을 응답하고 싶지만 할 수 없다.
		// response.setContentType("text/html; charset=UTF-8");
		// response.getWriter().print(name);
		// response.getWriter().print(age);
		
		/**
		 * JSON(자바스크립트 객체 표기법)
		 * ajax통신시 데이터 전송에 자주 사용되는 포멧형식 중 하나
		 * 
		 *  > [value, value, value] <= 자바스크립트에서 배열 => JSONArray
		 *  > {key:value, key:value, key:value} => 자바스크립트에서의 일반객체 => JSONObject 
		 */
		
//		JSONArray jArr = new JSONArray();
//		jArr.add(name);
//		jArr.add(age);
//		
//		response.setContentType("text/html; charset=UTF-8");
//		response.getWriter().print(jArr);
		
//		JSONObject jobject = new JSONObject(); // {}
//		jobject.put("name", name); // {name:김개똥}
//		jobject.put("age", age); // {name:김개똥, age:10}
//		
//		response.setContentType("text/html; charset=UTF-8");
//		response.getWriter().print(jobject);
		
		ArrayList<Member> list = new ArrayList<>();
		list.add(new Member(1, "김개똥", "01024758624"));
		list.add(new Member(2, "최개똥", "01022224444"));
		list.add(new Member(3, "이개똥", "01022354125"));
		
		// [{},{},{}]
		
//		JSONArray jArr = new JSONArray();
//		for(Member m : list) {
//			JSONObject jobj = new JSONObject();
//			jobj.put("userNo", m.getUserNo());
//			jobj.put("userName", m.getUserName());
//			jobj.put("phone", m.getPhone());
//			
//			jArr.add(jobj);
//		}
//		
//		response.setContentType("text/html; charset=UTF-8");
//		response.getWriter().print(jArr);
		
		response.setContentType("text/html; charset=UTF-8");
		new Gson().toJson(list, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

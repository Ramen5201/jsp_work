/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.93
 * Generated at: 2023-10-19 06:35:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.kh.member.model.vo.Member;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/views/common/menubar.jsp", Long.valueOf(1697685178287L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.kh.member.model.vo.Member");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	<!-- \r\n");
      out.write("	\r\n");
      out.write("		*회원서비스\r\n");
      out.write("	\r\n");
      out.write("		| C(insert) | R(Select) | U(Update) | D(Delete)\r\n");
      out.write("		\r\n");
      out.write("         로그인  (R)  / 회원가입 (C)\r\n");
      out.write("         마이페이지 (C) / 정보변경 (U) / 회원탈퇴(U)\r\n");
      out.write("         아이디 중복체크 (R)\r\n");
      out.write("       \r\n");
      out.write("       * 공지사항서비스\r\n");
      out.write("       	 공지사항 리스트 조회 (R) / 상세조회(R)\r\n");
      out.write("       	 공지사항 작성(C) / 공지사항 수정(U) / 공지사항 삭제(U)\r\n");
      out.write("       \r\n");
      out.write("       * 일반게시판 서비스\r\n");
      out.write("       	 게시판 리스트 조회(R) - 페이징처리 / 상세조회(R)\r\n");
      out.write("       	 게시판 작성(C) / 게시판 수정(U) / 게시판 삭제(U)\r\n");
      out.write("       	 댓글리스트 조회(R) / 댓글작성(C)\r\n");
      out.write("       	 \r\n");
      out.write("       * 사진게시판 서비스\r\n");
      out.write("       	 게시판 리스트 조회(R) - 썸네일 형식 / 상세조회(R)\r\n");
      out.write("       	 게시판 작성(C) - 첨부파일 업로드(C) \r\n");
      out.write("       	 \r\n");
      out.write("	 -->\r\n");
      out.write("	 \r\n");
      out.write("	 ");
 com.kh.common.JDBCTemplate.getConnection(); 
      out.write("\r\n");
      out.write("	 \r\n");
      out.write("	 ");
      out.write('\r');
      out.write('\n');

	String contextPath = request.getContextPath();
	
	Member loginUser = (Member)session.getAttribute("loginUser");   
	// 로그인 시도 전 menuber.jsp로딩시 해당객체 : null
	// 로그인 성공 후 menuber.jsp로딩시 해당객체 : 로그인 성공한 회원의 정보
	
	String alertMsg = (String)session.getAttribute("alertMsg"); 
	// 서비스 요청 전 menuber.jsp로딩시 : null
	// 서비스 요청 후 menuber.jsp로딩시 : alert로 띄워줄 메세지 문구

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("    .login-area > *{\r\n");
      out.write("        float: right;\r\n");
      out.write("    }\r\n");
      out.write("    .login-area a{\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("        color: black;\r\n");
      out.write("        font-size: 12px;\r\n");
      out.write("    }\r\n");
      out.write("    .nav-area{\r\n");
      out.write("        background: black;\r\n");
      out.write("    }\r\n");
      out.write("    .menu{\r\n");
      out.write("        display: table-cell;\r\n");
      out.write("        width: 150px;\r\n");
      out.write("        height: 50px;\r\n");
      out.write("    }\r\n");
      out.write("    .menu a{\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("        color: white;\r\n");
      out.write("        font-size: 20px;\r\n");
      out.write("        font-weight: bold;\r\n");
      out.write("        display: block;\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        height: 100%;\r\n");
      out.write("        line-height: 50px;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write(" 	<!-- bootstrap CSS -->\r\n");
      out.write("    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("    <!-- bootstrap JS -->\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <!-- jquery 3.7.1 -->\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.7.1.min.js\"\r\n");
      out.write("        integrity=\"sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h1 align=\"center\">Welcome JIWON World</h1>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"login-area\">\r\n");
      out.write("        ");
 if(loginUser == null) { 
      out.write("\r\n");
      out.write("            <!-- case1. 로그인 전 -->\r\n");
      out.write("            <form action=\"");
      out.print(contextPath );
      out.write("/login.me\" method=\"POST\">\r\n");
      out.write("                <table>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th>아이디</th>\r\n");
      out.write("                        <td><input type=\"text\" name=\"userId\" required></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th>비밀번호</th>\r\n");
      out.write("                        <td><input type=\"password\" name=\"userPwd\" required></td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        <th colspan=\"2\">\r\n");
      out.write("                            <button type=\"submit\">로그인</button>\r\n");
      out.write("                            <button type=\"button\" onclick=\"enrollPage();\">회원가입</button>\r\n");
      out.write("                        </th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </table>\r\n");
      out.write("                <script>\r\n");
      out.write("                	// 회원가입 페이지를 요청\r\n");
      out.write("                	function enrollPage(){\r\n");
      out.write("                		//location.href = \"");
      out.print(contextPath );
      out.write("/views/member/memberEnrollForm.jsp\";\r\n");
      out.write("                		// 웹 애플리케이션의 디렉토리 구조가 url에 노출되면 보안에 취약\r\n");
      out.write("                		\r\n");
      out.write("                		// 단순한 페이지 요청도 servlet호출해서 servlet거쳐갈 것(즉, url에는 서블릿 맵핑값만 나타나도록)\r\n");
      out.write("                		location.href = \"");
      out.print(contextPath);
      out.write("/enrollForm.me\";\r\n");
      out.write("                	}\r\n");
      out.write("                </script>\r\n");
      out.write("            </form>\r\n");
      out.write("        ");
 } else { 
      out.write("\r\n");
      out.write("            <!-- case2. 로그인 후 -->\r\n");
      out.write("            <div>\r\n");
      out.write("                <b>");
      out.print(loginUser.getUserName() );
      out.write("님</b>의 방문을 환영합니다. <br><br>\r\n");
      out.write("                <div align=\"center\">\r\n");
      out.write("                    <a href=\"");
      out.print(contextPath );
      out.write("/myPage.me\">마이페이지</a>\r\n");
      out.write("                    <a href=\"");
      out.print(contextPath );
      out.write("/logout.me\">로그아웃</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <br clear=\"both\">\r\n");
      out.write("    <br>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"nav-area\" align=\"center\">\r\n");
      out.write("        <div class=\"menu\"><a href=\"");
      out.print(contextPath);
      out.write("\">HOME</a></div>\r\n");
      out.write("        <div class=\"menu\"><a href=\"");
      out.print(contextPath);
      out.write("/list.no\">공지사항</a></div>\r\n");
      out.write("        <div class=\"menu\"><a href=\"");
      out.print(contextPath);
      out.write("/list.bo?cpage=1\">일반게시판</a></div>\r\n");
      out.write("        <div class=\"menu\"><a href=\"\">사진게시판</a></div>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

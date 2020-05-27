package com.mission.javabeans;

public class BoardBean {
	private String name;
	private String pass;
	private String email;
	private String title;
	private String content;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}

//입력정보 출력법
//scriptlet 사용하는 법
/*<% com.mission.javabeans.Boardbean board = new com.saeyan.javabeans.Boardbean();
 * pageContext.setAttribute("board",member);
 * %>
 * <%= board.getName()%>
 * <%= board.getPass()%>
 * <%= board.getEmail()%>
 * <%= board.getTitle()%>
 * <%= board.getContent()%>
 */
//scriptlet 사용하지 않는법
/*<jsp:useBean id="board" class="com.mission.javabeans.BoardBean"/>
 * 작성자 <jsp:getProperty name="board" property="name"/><br>
 * 비밀번호 <jsp:getProperty name="board" property="pass"/><br>
 * 이메일<jsp:getProperty name="board" property="email"/><br>
 * 글제목<jsp:getProperty name="board" property="title"/><br>
 * 글내용<jsp:getProperty name="board" property="content"/><br>*/

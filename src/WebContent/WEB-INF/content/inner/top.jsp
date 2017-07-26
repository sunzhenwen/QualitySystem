<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<%@ page import="com.tj.jst.login.model.Login" %>
<!DOCTYPE html!>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>建筑企业资质管理信息系统</title>

<script language="javascript">
//2013-07-02 获取父窗体，实现页面跳转
function re(){
	window.parent.location.href="login!reChange.action";
}
function closeSys()
{
	if(confirm("您确定要退出资质系统吗?")==true)
	{
		window.parent.location.href="<%=basepath %>/loginAction_exitSystem.action";
	}
	else
	{
		return;
	}
}

</script>
</head>	

<body>
 <div class="nw_top" >
 <%
 	Login login = (Login)session.getAttribute("login");
 %>
 
    <img src="<%=basepath %>/img/nwlogo.png" />
    <a href="<%=basepath %>/direction/innerDirectionForUse.docx"><span style="position:absolute;top:39px;left:900px;font-size:1.1em;color:fff;font-weight:bold">使用帮助</span></a>
    <span style="position:absolute;top:39px;left:1030px;font-size:1.1em;color:fff;font-weight:bold">当前用户：<%=login.getName() %></span>
    <a href="#" onclick="closeSys()"><span>安全退出</span></a>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<%@ page import="com.tj.jst.login.model.Login" %>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>

<script type="text/javascript">
	
	function query() {
		
		var corpName = document.getElementById("corpName").value;
		if(corpName == null) {
			alert("请输入企业名称");
		} else {
			document.form1.action="<%=basepath%>/nameSearchAction_queryCorpName.action";
			document.form1.submit();
		}
		
	}
	
	//操作提示信息

	function getMessage()
	{
		var message = document.getElementById("message").value;
		if(message != "")
		{
			alert(message);
		}
	}
	
	
</script>
</head>
<body onload="getMessage()" style="background:#6aa0cf url(<%=basepath %>/img/zhindexbg.jpg) no-repeat;background-size:cover;-webkit-background-size: cover;-moz-background-size: cover;
 -o-background-size: cover; min-width:1366px;">
 <form id="form1" name="form1" method="post" action="">
	 <%
 	Login login = (Login)session.getAttribute("login");
 %>
	<div class="index_wrapp">
    	<div class="index_top">
    	<input type="hidden" id="message" value="<s:property value="message" />" />
        	<img src="<%=basepath %>/img/zhindex_name.png" />
        	<span style="position:absolute;top:30px;left:800px;font-size:1.5em;color:fff;font-weight:bold">登录用户：<%=login.getName() %></span>
        </div>
        <div class="index_bottom">
            
			<div class="fr login-qy">
           	
      	        <ul>
                       <li style="padding:30px 30px; font-size:xx-large;  "  >企业模拟登录</li>
                       <li style="padding:20px 20px; font-size:x-large;  "  >企业名称</li>
                       <li style="padding:0px 0px; font-size:medium; color: red "  >*请输入企业完整名称，该功能不支持模糊查询</li>
                       
                       <li ><input id="corpName"  name="corpName" type="text" value="<s:property value="corpName"/>" size="39" maxlength="39" style="width:30%;padding:10px ;height:30px;" /></li>
                     	
                      <li style="padding:20px 20px;"><input type="image" src="<%=basepath %>/img/ry_look.png" onclick="query()" /></li>
                      
                      
              </ul>
            </div>
            
            
        </div>
        
        
    </div>
    </form>
</body>
</html>
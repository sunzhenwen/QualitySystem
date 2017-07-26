<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html!>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>建筑企业资质管理信息系统</title>
</head>	
    
    <frameset rows="106,*" frameborder="no" border="0" framespacing="0" >
	   
       
       <frame src="<%=basepath %>/frameAction_top.action" scrolling="no" name="top"  noresize="noresize">
         
       
        <frameset cols="260,*" frameborder="no" border="0"  id="mainframe">
            
            
            <frame src="<%=basepath %>/frameAction_left.action" class="lframestyle" name="leftshowframe" width="100%" height="100%" scrolling="yes">
            
           	
            
            <frame src="<%=basepath %>/frameAction_right.action"  noresize="noresize" name="rightshowframe" width="100%" height="100%">

       
         </frameset>
         
    </frameset>
    
    <noframes>
    </noframes>
</html>
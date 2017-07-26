<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>企业组织机构代码查询</title>
<script type="text/javascript">
	function queryForeignCorpCode()
	{
		var code = document.getElementById("code").value;
		if ( code != ""){
			document.form1.action="<%=basepath %>/foreignCorpAction_queryForeignCorpName.action";
			document.form1.submit();
		}else{
			alert("请输入企业组织机构代码!");
		}
		
		
	}
</script>
</head>
<body>
<form id="form1" name="form1" method="post" action="">
	<div class="qy_wrapp">
    	<div class="index_top">
        	<img src="<%=basepath %>/img/zhindex_name.png" />
        </div>
        <div class="qy_main">
        	<h2 class="f16 fb">企业组织机构代码查询 </h2>
            <div class="cx_look">
               <p><span class="f16">企业组织机构代码查询 ：</span><input id="code" class="cx_text" name="corpCode" type="text" />
               <input class="xc_bon" type="image" src="<%=basepath %>/img/xc_look.png" onclick="queryForeignCorpCode()" /></p>
            </div>
        </div>
        <%@include file="/WEB-INF/content/outside/footer.jsp"%> 
    </div>
</form>
</body>
</html>
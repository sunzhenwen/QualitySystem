<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业组织机构代码查询</title>
<script type="text/javascript">
	function queryCorpCode()
	{
		var code = document.getElementById("code").value;
		
		//判断所输入的内容是否含有全角字符
		var isSBCCase = false ;
		for(var i=0; i<code.length; i++){
			strCode = code.charCodeAt(i);
			if((strCode > 65248) || (strCode == 12288)){
				isSBCCase = true ;
			}
		}
		
		if(isSBCCase){
			alert("您所输入的组织机构代码含有全角字符");
			return ;
		}
		
		if(code != "")
		{
			document.form1.action="<%=basepath %>/corpAction_queryCorpName.action";
			document.form1.submit();
		}else
		{
			alert("请输入企业组织机构代码！");
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
<body onload="getMessage()">
<input type="hidden" id="message" value="<s:property value="message" />" />
<form id="form1" name="form1" method="post" action="">
	<div class="qy_wrapp">
    	<div class="index_top">
        	<img src="<%=basepath %>/img/zhindex_name.png" />
        </div>
        <div class="qy_main">
        	<h2 class="f16 fb">企业组织机构代码或统一社会信用代码查询 </h2>
            <div class="cx_look">
               <p><span class="f16">企业组织机构代码或统一社会信用代码查询 ：</span><input id="code"  maxlength='18'  class="cx_text" name="corpCode" type="text" />
               <input class="xc_bon" type="image" src="<%=basepath %>/img/xc_look.png" onclick="queryCorpCode()" /></p>
            </div>
        </div>
        <%@include file="/WEB-INF/content/outside/footer.jsp"%> 
    </div>
    
</form>
</body>
</html>
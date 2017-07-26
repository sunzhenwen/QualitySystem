<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>
<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>

<script type="text/javascript">
	
	//资质服务事项选择
	function goCertifiedService(check)
	{
		
		var addTypeNum = document.getElementById("addTypeNum").value;
		document.form1.action="<%=basepath %>/newQualificationAction_queryCertifiedService.action?check="+check+"&addTypeNum="+addTypeNum;
		document.form1.submit();
	}
	
	//返回业务办理页面
	function goBack()
	{
		document.form1.action="<%=basepath %>/titleAction_goBack.action";
		document.form1.submit();
	}

</script>
<body style="background:#6aa0cf url(<%=basepath %>/img/zhindexbg.jpg) no-repeat;background-size:cover;-webkit-background-size: cover;-moz-background-size: cover;
 -o-background-size: cover; min-width:1366px;">
 <form id="form1" name="form1" method="post" action="">
	<div class="index_wrapp">
    	<div class="index_top">
        	<img src="<%=basepath %>/img/zhindex_name.png" />
        </div>
        <div class="index_bottom">
        	
            <div class="ywbl">
            	<p>业务办理：企业资质申请</p>
            <input id="addTypeNum" type="hidden" value="<s:property value="addTypeNum"/>" />
				 <ul>

                    <a href="#" onclick="goCertifiedService(1)"><li>国务院住房城乡建设主管部门许可</li></a>
                    <a href="#" onclick="goCertifiedService(2)"><li>省住房城乡建设主管部门许可</li></a>
                    <a href="#" onclick="goCertifiedService(3)"><li>市（地）、省直管县、农垦、森工住房城乡建设主管部门许可</li></a>
               
                </ul>
               <div class="ywan">
               		<a href="#" onclick="goBack()"> <span style="color:#FFF" class="ywbl_returnt">返回</span></a>
               </div>
               
            </div>
        
        </div>
        
        
    </div>
    </form>
</body>
</html>
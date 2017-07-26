<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>资质信息选择</title>
<script type="text/javascript">

	//提交资质服务事项
	function submitCertifiedService()
	{
		document.form1.action="<%=basepath %>/queryCorpAction_submitCertifiedService.action";
		document.form1.submit();
	}
	
    //表单验证
    function check(){               
        var ids = document.getElementsByName("certIds");               
        var flag = false ;               
        for(var i=0;i<ids.length;i++){
            if(ids[i].checked){
                flag = true;
                break ;
            }else
            {
            	flag = false;
            }
        }
        return flag;
    }
    
    function goback(){
    	document.form1.action="<%=basepath %>/queryCorpAction_queryPage.action";
		document.form1.submit();
    }
    
</script>
</head>
<body>
<form id="form1" name="form1" method="post" action="">
<input type="hidden" name="condition.provinceNum" value='<s:property value="provinceNum"/>'/>
<input type="hidden" name="condition.cityNum" value="<s:property value="cityNum"/>"/>
				<div>
				<div align="center">
					<font size="4" color="blue" >省级建筑业资质</font>
				</div>
				<table class="yw_mtable left" style="margin:0 140px" cellpadding="0" cellspacing="0">
					<s:iterator status="i" value="certifieds2" > 
					<s:if test="#i.odd">
					<tr>
						<td><s:property value="certName"/></td>
						<td><input type="checkbox" name="certIds" value="<s:property value="certId"/>"></td>
					</tr>
					</s:if>
					</s:iterator>
				</table>
				<table class="yw_mtable left" cellpadding="0" cellspacing="0">
					<s:iterator status="i" value="certifieds2" > 
					<s:if test="#i.even">
					<tr>
						<td><s:property value="certName"/></td>
						<td><input type="checkbox" name="certIds" value="<s:property value="certId"/>"></td>
					</tr>
					</s:if>
					</s:iterator>
				</table>
				</div>
				<div style="float: left;margin-top: 20px;">
				<div align="center">
					<font size="4" color="blue" >市级建筑业资质</font>
				</div>
				<table class="yw_mtable left" cellpadding="0" cellspacing="0">
					<s:iterator status="i" value="certifieds3" > 
					<s:if test="#i.even">
					<tr>
						<td><s:property value="certName"/></td>
						<td><input type="checkbox" name="certIds" value="<s:property value="certId"/>"></td>
					</tr>
					</s:if>
					</s:iterator>
				</table>
				<table class="yw_mtable left" style="margin:0 140px" cellpadding="0" cellspacing="0">
					<s:iterator status="i" value="certifieds3" > 
					<s:if test="#i.odd">
					<tr>
						<td><s:property value="certName"/></td>
						<td><input type="checkbox" name="certIds" value="<s:property value="certId"/>"></td>
					</tr>
					</s:if>
					</s:iterator>
				</table>
				</div>
				<div style="float: left; margin-top: 20px;">
				<div align="center">
					<font size="4" color="blue" >国家级建筑业资质</font>
				</div>
				<table class="yw_mtable left" cellpadding="0" cellspacing="0">
					<s:iterator status="i" value="certifieds1" > 
					<s:if test="#i.even">
					<tr>
						<td><s:property value="certName"/></td>
						<td><input type="checkbox" name="certIds" value="<s:property value="certId"/>"></td>
					</tr>
					</s:if>
					</s:iterator>
				</table>
				<table class="yw_mtable left" style="margin:0 140px" cellpadding="0" cellspacing="0">
					<s:iterator status="i" value="certifieds1" > 
					<s:if test="#i.odd">
					<tr>
						<td><s:property value="certName"/></td>
						<td><input type="checkbox" name="certIds" value="<s:property value="certId"/>"></td>
					</tr>
					</s:if>
					</s:iterator>
				</table>
				</div>
				
				<div class="botn">
					<input type="image" src="<%=basepath%>/img/ry_look.png" onclick="submitCertifiedService()"/> 
					<input type="image" src="<%=basepath%>/img/fanhui_03.png" onclick="goback()" />
				</div>
			</form>

</body>
</html>
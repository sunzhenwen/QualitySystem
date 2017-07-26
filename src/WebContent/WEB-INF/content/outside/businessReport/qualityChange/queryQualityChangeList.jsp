<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>资质变更</title>
<script type="text/javascript">
function querySpecialtyType(){
    $(document).ready(function(){
        //获取部门下拉列表的值
        var cretSequenceId = $("#cretSequenceId").val();
        $.ajax({
            url: 'certifiedService_querySpecialtyTypes.action',
            type: 'post',
            dataType: 'json',
            data: 'cretSequenceId='+cretSequenceId,
            success: function(data){ 
                //将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
                var items = eval("("+data+")");
                //循环items,i为循环下标,(默认i从0开始取值)
                //移除列表中已存在的值，防止切换部门时，上次查询结果还在
                $("#specialtyTypeId").empty();
                $("#specialtyTypeId").append("<option value=''>请选择</option>");
                $.each(items,function(i){
                	var specialtyType='<s:property value="condition.specialtyType"/>';
                    if(items[i].code==specialtyType)
                    {
                        $("#specialtyTypeId").append("<option value='" + items[i].code+ "' selected>" + items[i].name + "</option>");
                    }else
                    {
                        $("#specialtyTypeId").append("<option value='" + items[i].code+ "'>" + items[i].name + "</option>");
                    }
                });  
            }
        });
    });
}
	
	//查询
	function query()
	{
		document.form1.action="<%=basepath %>/queryQualityChangeAction_showQualityChangeQueryInner.action";
		document.form1.submit();
	}
	
</script>
</head>
<body >
<div class="libiao">
<form id="form1" name="form1" method="post" action="">
<table width="100%"  border="0" cellpadding="0" height="15%">
     <tr>
	    <td >	
	      <fieldset>
		  <legend  class="chaxuntj" >资质变更</legend>	
          <p style="margin-bottom:10px; text-align:right;">
          <a href="#" onclick="query()"><span class="lbchx">查询</span></a> 
              <table width="100%" border="0" align="left" cellpadding="0" cellspacing="0" height="10%">
				<tr>
			    	<td colspan="4">日期选择：
						<input id="time1" value="<s:property value="condition.START_TIME" />" type="text" name="condition.START_TIME" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
						~
						<input id="time2" value="<s:property value="condition.END_TIME" />" type="text" name="condition.END_TIME" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" />
					</td>
  		        </tr>
		        <tr>
			        <td>企业名称：</td>
			  		<td>
			  			<input type="text" name="condition.CORPNAME" value="<s:property value="condition.CORPNAME"/>" />
			  		</td>

	  	        </tr>
		      </table>
	      </fieldset>
		</td>
   </tr>
</table>
</form>
<table width = "100%" border  = "0"  cellpadding = "0"  cellspacing="0"   onmouseover="changeto()"  onmouseout="changeback()" >
	<tr >
		<th>序号</th>
		<th>企业名称</th>
		<th>业务类型</th>
		<th>申请日期</th>
		<th>审批状态</th>
		<th>操作</th>
	</tr>
	

	<s:iterator status="i" value="currentPage.data" > 
		<tr>
			<td><s:property value="#i.count"/></td>
			<td><s:property value="CORPNAME" /></td>
			<td>资质变更</td>
			<td><s:property value="CREATE_TIME" /></td>
			<td><s:property value="LEVELNAME" /></td>
			<td align='center'> <a href="qualityChangeAction_showQueryQualityChangeDetailPage.action?qualityChangeId=<s:property value="QUALITY_CHANGE_ID"/>">详细</a> </td>
			
		</tr>
	</s:iterator>
	
</table>
</div>
 <%@include file="/WEB-INF/content/inc/page.jsp"%> 
</div>
</body>
</html>
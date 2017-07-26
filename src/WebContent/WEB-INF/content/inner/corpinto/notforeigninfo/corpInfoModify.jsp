<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html!>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>企业基本信息修改</title>
<script type="text/javascript">
	
	//保存
	$().ready(function() {
	 	$("#form1").validate({
	 		submitHandler:function(form){
	            form.submit();
	        }    
	 	});
	});
	
	function shuru(txt){
	    txt.value=txt.value.replace(/\D/g,"");
	  }
	
	
	//textare限制I长度
	function checkMaxInput(txt)
	{
	       if (txt.value.length > 500)
	       txt.value = txt.value.substring(0, 500);
	}
	
	//返回
	function goBack()
	{
		document.form1.action="<%=basepath %>/corpInfoAction_queryCorpInfo.action?type=2";
		document.form1.submit();
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
	
	
	//查询市
	function queryCity(){
	       $(document).ready(function(){
	           //获取部门下拉列表的值
	           var provinceId = $("#provinceId").val();
	           $.ajax({
	               url: 'corpAction_queryCity.action',
	               type: 'post',
	               dataType: 'json',
	               data: 'provinceId='+provinceId,
	               success: function(data){
	            	   //将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
	                   var items = eval("("+data+")");
	                   $("#cityId").empty();
	                   $("#areaId").empty();
	                   $("#cityId").append("<option value=''>请选择</option>");
	                   $("#areaId").append("<option value=''>请选择</option>");
	                   //循环items,i为循环下标,(默认i从0开始取值)
	                   $.each(items,function(i){
	                       $("#cityId").append("<option value='" + items[i].code+ "'>" + items[i].name + "</option>");
	                   });  
	               }
	           });
	       });
	   }
	
		//查询区
		function queryArea(){
		       $(document).ready(function(){
		           //获取部门下拉列表的值
		           var cityNum = $("#cityId").val();
		           $.ajax({
		               url: 'corpAction_queryArea.action',
		               type: 'post',
		               dataType: 'json',
		               data: 'cityNum='+cityNum,
		               success: function(data){
		            	   //将数据转换成json类型，可以把data用alert()输出出来看看到底是什么样的结构
		                   var items = eval("("+data+")");
		                   $("#areaId").empty();
		                   //循环items,i为循环下标,(默认i从0开始取值)
		                   $.each(items,function(i){
		                       $("#areaId").append("<option value='" + items[i].code+ "'>" + items[i].name + "</option>");
		                   });  
		               }
		           });
		       });
		   }
</script>
</head>
<body onload="getMessage()">
<div class="qy_wrapp">
<input type="hidden" id="message" value="<s:property value="message" />" />
		<div class="qy_main" style="width: 100%; background: #FFF; border: 0;">

			<h2 class="f16 fb" style="background: #80aced;">企业信息修改</h2>
			
				<form id="form1" name="form1" method="post" action="<%=basepath %>/corpInfoAction_modifyCorp.action">
            		<table class="qy_mtable p_left60" cellpadding="0" cellspacing="0">
               
              <tr>
                	<td>企业名称：</td>
                	<td><input type="text"  maxlength='200'  name="corpInfo.corpName" value="<s:property value="corpInfo.corpName"/>" class="required" /><strong><font color="#FF0000">*</font></strong>
                	<input type="hidden" name="corpInfo.corpId" value="<s:property value="corpInfo.corpId"/>"/>
                	</td>
                	<td>组织机构代码或统一社会信用代码：</td>
               		<td><input type="text"  maxlength='18'  name="corpInfo.corpCode" value="<s:property value="corpInfo.corpCode"/>" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                </tr>
               
                <tr>
                    <td>工商营业执照注册号：</td>
                    <td><input type="text"  maxlength='18'  name="corpInfo.licenseNum" value="<s:property value="corpInfo.licenseNum"/>" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                
                	<td>企业营业地址：</td>
                    <td><input type="text"  maxlength='200'  name="corpInfo.address" value="<s:property value="corpInfo.address"/>" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                </tr>
                
                <tr>
                    <td>注册所在省（自治区、直辖市）：</td>
                    <td><select id="provinceId" name="corpInfo.provinceNum" onchange="queryCity()" class="required">
                    <option value="">请选择</option>
                    <s:iterator value="provinces">
						<option value="<s:property value="code"/>" <s:if test='corpInfo.provinceNum==code'>selected</s:if>><s:property value="name"/></option>
					</s:iterator>
                </select><strong><font color="#FF0000">*</font></strong>
                    </td>
                    
                    <td>注册所在地（市、州、盟）：
                    </td>
                    <td><select id="cityId" name="corpInfo.cityNum" onchange="queryArea()" class="required" >
                    <option value="">请选择</option>
                    <s:iterator value="citys">
						<option value="<s:property value="code"/>" <s:if test='corpInfo.cityNum==code'>selected</s:if>><s:property value="name"/></option>
					</s:iterator>
                </select><strong><font color="#FF0000">*</font></strong>
                        </td>
                    
				</tr>
                
                <tr>
                    <td>注册所在县（区、市、旗）：</td>
                    <td><select id="areaId" name="corpInfo.countyNum" class="required" >
                	<option value="">请选择</option>
                	<s:iterator value="areas">
						<option value="<s:property value="code"/>" <s:if test='corpInfo.countyNum==code'>selected</s:if>><s:property value="name"/></option>
					</s:iterator>
                </select><strong><font color="#FF0000">*</font></strong>
                    </td>
                    
                    <td>企业营业地址邮政编码：</td>
                    <td><input type="text"  maxlength='6'  name="corpInfo.postalCode" value="<s:property value="corpInfo.postalCode"/>" class="required"/><strong><font color="#FF0000">*</font></strong></td>
                
                </tr>
               
                <tr>
                    <td>法定代表人姓名：</td>
                    <td><input type="text"  maxlength='50'  name="corpInfo.legalMan" class="required"  value="<s:property value="corpInfo.legalMan"/>" /><strong><font color="#FF0000">*</font></strong></td>
                	
                	<td>法定代表人证件类型：</td>
                    <td><select id="" name="corpInfo.idCardTypeNum" class="required" >
                    <option value="">请选择</option>
                    <s:iterator value="idCardType">
						<option value="<s:property value="code"/>" <s:if test='corpInfo.idCardTypeNum==code'>selected</s:if>><s:property value="name"/></option>
					</s:iterator>
                </select><strong><font color="#FF0000">*</font></strong></td>
                </tr>
               
                <tr>
                    <td>法定代表人证件号码：</td>
                    
                    <td><input type="text"  maxlength='30'  name="corpInfo.legalManIdCard" value="<s:property value="corpInfo.legalManIdCard"/>" class="{required:true,digits:true}" /><strong><font color="#FF0000">*</font></strong></td>
                	<td>法定代表职务：</td>
                    <td><input type="text"  maxlength='50'  name="corpInfo.legalManDuty" value="<s:property value="corpInfo.legalManDuty"/>" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                
                </tr>
                
                <tr>
                    <td>法定代表职称：</td>
                    <td><input type="text"  maxlength='50'  name="corpInfo.legaManProtitle" value="<s:property value="corpInfo.legaManProtitle"/>" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                    
                     <td>企业登记注册类型：</td>
                    <td><select id="" name="corpInfo.economicNum" class="required" >
                    <option value="">请选择</option>
                    <s:iterator value="economicNum">
						<option value="<s:property value="code"/>" <s:if test='corpInfo.economicNum==code'>selected</s:if>><s:property value="name"/></option>
					</s:iterator>
                </select><strong><font color="#FF0000">*</font></strong></td>
                </tr>
                
                <tr>
                    <td>注册资本（万元）：</td>
                    <td><input type="text"  maxlength='15' onkeyup="if(isNaN(value))execCommand('undo')"  onafterpaste="if(isNaN(value))execCommand('undo')" name="corpInfo.regPrin" value="<s:property value="corpInfo.regPrin"/>" class="{required:true,number:true}" /><strong><font color="#FF0000">*</font></strong></td>
                    
                    <td>实收资本（万元）：</td>
                    <td><input type="text"  maxlength='15' onkeyup="if(isNaN(value))execCommand('undo')"  onafterpaste="if(isNaN(value))execCommand('undo')" name="corpInfo.factRegPrin" value="<s:property value="corpInfo.factRegPrin"/>" class="{required:true,number:true}" /><strong><font color="#FF0000">*</font></strong></td>
                
                </tr>
                
                <tr>
                    <td>注册资本币种：</td>
                    <td><select id="" name="corpInfo.principalUnitNum" class="required" >
                    <option value="">请选择</option>
                    <s:iterator value="principalUnit">
						<option value="<s:property value="code"/>"<s:if test='corpInfo.principalUnitNum==code'>selected</s:if> ><s:property value="name"/></option>
					</s:iterator>
                </select><strong><font color="#FF0000">*</font></strong></td>
                		
                		<td>成立日期：</td><td><input id="time1" type="text" name="corpInfo.corpBirthDate" value="<s:date name="corpInfo.corpBirthDate" format="yyyy-MM-dd" />" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true,isShowClear:true,readOnly:true})" class="required" /><strong><font color="#FF0000">*</font></strong></td>
                	
                </tr>
                
                <tr>
                	<td>办公电话：</td>
                	<td>
                		<input type="text"  maxlength='30'  name="corpInfo.officePhone"  value="<s:property value="corpInfo.officePhone"/>" class="required" /><strong><font color="#FF0000">*</font></strong>
                	</td>
                	
                	<td>传真号码：</td>
                	<td>
                		<input type="text"  maxlength='30'  name="corpInfo.fax" value="<s:property value="corpInfo.fax"/>" class="required" /><strong><font color="#FF0000">*</font></strong>
                	</td>
                </tr>
                
                <tr>
                	<td>联系人姓名：</td>
                	<td>
                		<input type="text"  maxlength='50'  name="corpInfo.linkMan" value="<s:property value="corpInfo.linkMan"/>" class="required" /><strong><font color="#FF0000">*</font></strong>
                	</td>
                	
                	<td>联系人办公电话：</td>
                	<td>
                		<input type="text"  maxlength='30'  name="corpInfo.linkTel" value="<s:property value="corpInfo.linkTel"/>" class="required" /><strong><font color="#FF0000">*</font></strong>
                	</td>
                </tr>
                
                <tr>
                	<td>联系邮箱：</td>
                 		<td>
                 			<input type="text"  maxlength='50'  name="corpInfo.email" value="<s:property value="corpInfo.email"/>" class="email" />&nbsp;&nbsp;
                 		</td>
                	
                	<td>联系人手机号码：</td>
                	<td>
                		<input type="text"  maxlength='30'  name="corpInfo.linkPhone" value="<s:property value="corpInfo.linkPhone"/>" class="required" /><strong><font color="#FF0000">*</font></strong>
                	</td>
                </tr>
                
                 <tr>
                 	<td>企业网址：</td>
                 		<td>
                 			<input type="text"  maxlength='200'  name="corpInfo.url" value="<s:property value="corpInfo.url"/>" class="url" />&nbsp;&nbsp;
                 		</td>
                 		
                 	<td>备注：</td>
                		<td >
                			<textarea id="${msg.openId}" name="corpInfo.description" style="height:40px" cols="20" rows="5"  onKeyUp="checkMaxInput(this)" onKeyDown="checkMaxInput(this)"><s:property value="corpInfo.description" /></textarea>&nbsp;&nbsp;
                		</td>
                 		
                 </tr>
                 
                 <tr>
                 	<td>净资产(万元)：</td>
                 		<td>
                 			<input type="text"  maxlength='15' onkeyup="if(isNaN(value))execCommand('undo')"  onafterpaste="if(isNaN(value))execCommand('undo')" name="corpInfo.assets" value="<s:property value="corpInfo.assets"/>" /><strong><font color="#FF0000">*</font></strong>
                 		</td>
                 		
                 	<td>机械设备：</td>
                		<td >
                			<textarea id="${msg.openId}" name="corpInfo.machinery" style="height:40px" cols="20" rows="5"  onKeyUp="checkMaxInput(this)" onKeyDown="checkMaxInput(this)"><s:property value="corpInfo.machinery" /></textarea>&nbsp;&nbsp;
                		</td>
                 		
                 </tr>
             </table>
            <div class="nw_bton">
        	<input type="image" src="<%=basepath %>/img/qy_02.png" />
            <input type="image" src="<%=basepath %>/img/fanhui_03.png" onclick="goBack()" />
        	 </div>

			</table>
		  </form>
		</div>
	</div>

</body>
</html>
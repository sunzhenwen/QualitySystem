<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/content/inc/main.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>证书信息预览</title>
<script language="javascript" src="<%=basepath%>/js/Lodop/LodopFuncs.js"></script>
<object id="LODOP_OB" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
	<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0 pluginspage="install_lodop.exe"></embed>
</object>
</head>
<body>
	<div class="qy_wrapp">
    	
        <div class="sp_main" >
        
         <h2 class="f16 fb" style="background:#80aced;">证书信息预览</h2>
         <form style="margin:50px;" id="form1" name="form1" method="post" action="">
            <table class="sp_mtable" style="border-collapse:collapse;" cellpadding="0" cellspacing="0">
                
                 <tr>             
                	<td colspan="4">
                	    <p align="center">
                	    <s:if test="updateType==1">
	                		第<s:property value="updateType"/>次打印
	                	</s:if>
	                	<s:else>
	                		重新打印
	                	</s:else>	
                	    </p>
                	</td>
                </tr>
                
                <tr>
                	<td>企业名称：</td>
                	<td>
                	<s:property value="certificatePrint.corpName"/>
                	<input type="hidden" id="corpName" value="<s:property value="certificatePrint.corpName" />"  />
                	</td>
                    <td>&nbsp;</td>
               		<td></td>
                </tr>
               
                <tr>
                  <td>详细地址：</td>
                  <td><s:property value="certificatePrint.address"/>
                  <input type="hidden" id="address" value="<s:property value="certificatePrint.address" />"  />
                  </td>
                  <td>&nbsp;</td>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <td>营业执照注册号：</td>
                  <td><s:property value="certificatePrint.licenseNum"/>
                  		<input type="hidden" id="licenseNum" value="<s:property value="certificatePrint.licenseNum" />"  />
                  </td>
                  <td>法定代表人：</td>
                  <td><s:property value="certificatePrint.legalMan"/>
                  		<input type="hidden" id="legalMan" value="<s:property value="certificatePrint.legalMan" />"  />
                  </td>
                </tr>
                <tr>
                  <td>注册资本：</td>
                  <td><s:property value="certificatePrint.regPrin"/>万元
                  <input type="hidden" id="regPrin" value="<s:property value="certificatePrint.regPrin" />"  />           
                  </td>
                  <td>经济性质：</td>
                  <td><s:property value="certificatePrint.econmicName"/>
                  <input type="hidden" id="econmicName" value="<s:property value="certificatePrint.econmicName" />"  />
                  </td>
                </tr>
                <tr>
                    <td>证书编号：</td>
               		<td>
               		<s:property value="certificatePrint.certId"/>
               		<input type="hidden" id="certId" value="<s:property value="certificatePrint.certId" />"  />
               		</td>
                    <td>有效期：</td>
                    <td>
                    <s:date name="certificatePrint.organDate" format="yyyy-MM-dd" />&nbsp;&nbsp;<s:date name="certificatePrint.endDate" format="yyyy-MM-dd" />
                    <input type="hidden" id="endDate" value="<s:date name="certificatePrint.endDate" format="yyyy-MM-dd" />"  />                   
                    </td>
                </tr>
                 <tr>
                    <td>资质类别及等级：</td>
               		<td>
               		<s:iterator id="list" status="i" value="certificatePrint.certNames" >
                    	<s:property value="#list"/><br />
                    </s:iterator>
                    
                   <div id="certNames" style="display: none">
	                   <s:iterator id="list" status="i" value="certificatePrint.certNames" >
	                     <font size="4"><b><s:property value="#list"/></b></font><br/>
	                   </s:iterator>
                   </div>
                   
                   <div id="certNames2" style="display: none">
	                   <s:iterator id="list" status="i" value="certificatePrint.certNames" >
	                     <font size="3"><b><s:property value="#list"/></b></font><br/>
	                   </s:iterator>
                   </div>
                    
                      
               		</td>
                    <td>&nbsp;</td>
                    <td>
                    
                    </td>
                </tr>
                <tr>
                    <td>打证日期：</td>
               		<td>
               		<s:date name="certificatePrint.printDate" format="yyyy-MM-dd" />             		
               		<input type="hidden" id="printDate" value="<s:date name="certificatePrint.printDate" format="yyyy-MM-dd" />"  />
               		<input type="hidden" id="year" value="<s:property value="certificatePrint.year" />"  />
               		<input type="hidden" id="month" value="<s:property value="certificatePrint.month" />"  />
               		<input type="hidden" id="day" value="<s:property value="certificatePrint.day" />"  />
               		</td>
                    <td>&nbsp;</td>
                    <td>
                    &nbsp;
                    </td>
                </tr>
               <tr>
                    <td>正本流水号：</td>
               		<td>       		
						<s:property value="certificatePrint.PRINTNUMBER"/>
						<input type="hidden" id="QRCODE" value="<s:property value="certificatePrint.QRCODE" />"  />
               		</td>
                    <td>&nbsp;</td>
                    <td>
                    &nbsp;
                    </td>
               </tr>
               <tr>
                    <td>副本流水号：</td>
               		<td>       		
						<s:property value="certificatePrint.FBPRINTNUMBER"/>
						<input type="hidden" id="FBQRCODE" value="<s:property value="certificatePrint.FBQRCODE" />"  />
               		</td>
                    <td>&nbsp;</td>
                    <td>
                    &nbsp;
                    </td>
               </tr>
            </table>
             <div class="sp_bton"> 
               <!--  
             	<s:if test="certificatePrint.updateType.equals(\"0\") ">
        	    <a href="#"><span class="sp_last" onclick="prn1_preview()">正本</span></a>
       			<a href="#"><span class="sp_last" onclick="prn2_preview()">副本</span></a>
            	</s:if>
            	<s:else>
					<a href="#"><span class="sp_last" >证书信息未成功上传住建部暂不能打印</span></a>
				</s:else>
                -->
              
        	    <a href="#"><span class="sp_last" onclick="prn1_preview()">正本</span></a>
       			<a href="#"><span class="sp_last" onclick="prn2_preview()">副本</span></a>
			
            </div>
        </form>
    	</div>
  </div>
  <script language="javascript" type="text/javascript">   
    var LODOP; //声明为全局变量 
	function prn1_preview() 
    {	
		CreatePrintPageA3();	
		LODOP.SET_PRINT_PAGESIZE(1,0,0,"A3");
		LODOP.SET_PREVIEW_WINDOW(1,0,1,0,0,"");//打印前弹出选择打印机的对话框	
		LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW",1);//打印后自动关闭预览窗口
		LODOP.PREVIEW();	
	};
	
	function prn2_preview() 
	{	
		CreatePrintPageA4();	
		LODOP.SET_PRINT_PAGESIZE(1,0,0,"A4");
		LODOP.SET_PREVIEW_WINDOW(1,0,1,0,0,"");//打印前弹出选择打印机的对话框
		LODOP.SET_PRINT_MODE("AUTO_CLOSE_PREWINDOW",1);//打印后自动关闭预览窗口
		LODOP.PREVIEW();
	};
	
	function CreatePrintPage() 
	{
		LODOP=getLodop(document.getElementById('LODOP_OB'),document.getElementById('LODOP_EM'));  
		LODOP.PRINT_INIT("打印证书");
		LODOP.ADD_PRINT_TEXT(60,40,690,30,"企业名称："+document.getElementById("corpName").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
		LODOP.ADD_PRINT_TEXT(112,41,690,30,"详细地址："+document.getElementById("address").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
		LODOP.ADD_PRINT_TEXT(310,43,690,90,"资质类别及等级："+document.getElementById("certNames").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
		LODOP.ADD_PRINT_TEXT(161,44,320,30,"营业执照注册号："+document.getElementById("licenseNum").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
		LODOP.ADD_PRINT_TEXT(162,411,320,30,"法定代表人："+document.getElementById("legalMan").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
		LODOP.ADD_PRINT_TEXT(211,43,320,30,"注册资本："+document.getElementById("regPrin").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
		LODOP.ADD_PRINT_TEXT(211,413,320,30,"经济性质："+document.getElementById("econmicName").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
		LODOP.ADD_PRINT_TEXT(258,44,320,30,"证书编号："+document.getElementById("certId").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
		LODOP.ADD_PRINT_TEXT(259,411,320,30,"有效期："+document.getElementById("endDate").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
		LODOP.ADD_PRINT_TEXT(428,45,320,30,"打印日期："+document.getElementById("printDate").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",14);
	};
	
	function CreatePrintPageA3() 
	{
		LODOP=getLodop(); 
		LODOP.PRINT_INIT("正本A3打印");
		LODOP.ADD_PRINT_TEXT(474,330,690,30,document.getElementById("corpName").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",16);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		LODOP.ADD_PRINT_TEXT(520,330,690,30,document.getElementById("address").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",16);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		LODOP.ADD_PRINT_TEXT(565,330,228,35,document.getElementById("licenseNum").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		LODOP.ADD_PRINT_TEXT(614,330,199,35,document.getElementById("regPrin").value+"万");
		LODOP.SET_PRINT_STYLEA(0,"FontSize",16);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		LODOP.ADD_PRINT_TEXT(660,330,196,35,document.getElementById("certId").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",16);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		LODOP.ADD_PRINT_HTM(712,330,561,530,document.getElementById("certNames").innerHTML);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",16);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		LODOP.ADD_PRINT_TEXT(566,720,184,35,document.getElementById("legalMan").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",16);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		LODOP.ADD_PRINT_TEXT(614,720,300,35,document.getElementById("econmicName").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",16);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		LODOP.ADD_PRINT_TEXT(664,720,188,35,document.getElementById("endDate").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",16);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		//LODOP.ADD_PRINT_TEXT(1267,805,160,35,"黑龙江省住房和城乡建设厅");
		//LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
		LODOP.ADD_PRINT_TEXT(1337,700,70,35,document.getElementById("year").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",16);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		LODOP.ADD_PRINT_TEXT(1337,800,46,30,document.getElementById("month").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",16);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		LODOP.ADD_PRINT_TEXT(1337,885,38,30,document.getElementById("day").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",16);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		LODOP.ADD_PRINT_BARCODE(1310,127,168,146,"QRCode","http://www.mohurd.gov.cn/docmaap/CertQRCodeQuery.aspx?CertID="+document.getElementById("certId").value+"&Type=1&ID="+document.getElementById("QRCODE").value);
	};	
	
	
	function CreatePrintPageA4() 
	{
		LODOP=getLodop();  
		LODOP.PRINT_INIT("副本A4打印");
		LODOP.ADD_PRINT_TEXT(325,200,530,35,document.getElementById("corpName").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		LODOP.ADD_PRINT_TEXT(359,200,530,30,document.getElementById("address").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		LODOP.ADD_PRINT_TEXT(392,200,173,30,document.getElementById("licenseNum").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		LODOP.ADD_PRINT_TEXT(425,200,170,30,document.getElementById("regPrin").value+"万");
		LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		LODOP.ADD_PRINT_TEXT(457,200,173,35,document.getElementById("certId").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		LODOP.ADD_PRINT_HTM(490,200,443,391,document.getElementById("certNames2").innerHTML);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		LODOP.ADD_PRINT_TEXT(392,500,150,30,document.getElementById("legalMan").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		LODOP.ADD_PRINT_TEXT(425,500,230,30,document.getElementById("econmicName").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		LODOP.ADD_PRINT_TEXT(457,500,151,35,document.getElementById("endDate").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		//LODOP.ADD_PRINT_TEXT(943,500,169,30,"黑龙江省住房和城乡建设厅");
		//LODOP.SET_PRINT_STYLEA(0,"FontSize",10);
		LODOP.ADD_PRINT_TEXT(963,505,48,24,document.getElementById("year").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		LODOP.ADD_PRINT_TEXT(963,572,27,25,document.getElementById("month").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		LODOP.ADD_PRINT_TEXT(963,617,27,25,document.getElementById("day").value);
		LODOP.SET_PRINT_STYLEA(0,"FontSize",12);
		LODOP.SET_PRINT_STYLEA(0,"Bold",1);
		LODOP.ADD_PRINT_BARCODE(945,70,110,95,"QRCode","http://www.mohurd.gov.cn/docmaap/CertQRCodeQuery.aspx?CertID="+document.getElementById("certId").value+"&Type=2&ID="+document.getElementById("FBQRCODE").value);
	};
	
</script> 
</body>
</html>
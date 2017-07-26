package com.tj.jst.base.util.xmlOuter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.jdom.JDOMException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.outside.businessReport.qualitychange.model.TB_QUALITY_CHANGE;

public class GenerateXml {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public List<CorpCert> BuildXMLDoc(String certid) throws IOException, JDOMException { 
		 
		List<CorpCert> list = new ArrayList<CorpCert>();
		// TODO Auto-generated method stub
		String sql = "select * from v_corpcertinfo where certid=? and certtradestatusnum='001' order by updatetype desc";
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, certid);
			rs = pstmt.executeQuery();
			int i=0;
			while(rs.next())
			{
				CorpCert corpCert = new CorpCert();
				corpCert.setCertid(rs.getString("certid"));
				corpCert.setCerttypenum(rs.getString("certtypenum"));
				corpCert.setCretgrade(rs.getString("cretgrade"));
				corpCert.setCorpId(rs.getString("corpId"));
				corpCert.setCorpname(rs.getString("corpname"));
				corpCert.setCorpcode(rs.getString("corpcode"));
				corpCert.setLicensenum(rs.getString("licensenum"));
				corpCert.setProvincename(rs.getString("provincename"));
				corpCert.setCityname(rs.getString("cityname"));
				corpCert.setAdminareaname(rs.getString("adminareaname"));
				String econName = rs.getString("economicpropertyname");
				if("其他有限责任公司".equals(econName))
				{
					econName = "有限责任公司（其他）";
				}
				corpCert.setEconomicpropertyname(econName);
				corpCert.setOfficephone(rs.getString("officephone"));
				corpCert.setAddress(rs.getString("address"));
				corpCert.setRegprin(rs.getString("regprin"));
				corpCert.setPrincipalunitname(rs.getString("principalunitname"));
				corpCert.setLegalman(rs.getString("legalman"));
				corpCert.setOrgandate(rs.getDate("organdate"));
				corpCert.setOrganname(rs.getString("organname"));
				corpCert.setQrcode(rs.getString("qrcode"));
				corpCert.setFbqrcode(rs.getString("fbqrcode"));
				corpCert.setPrintnumber(rs.getString("printnumber"));
				corpCert.setFbprintnumber(rs.getString("fbprintnumber"));
				corpCert.setUpdateType(rs.getString("updateType").trim());
				if(corpCert.getOrganname().equals("黑龙江省住建厅"))
				{
					//省市发证
					corpCert.setDeptgrade("2");
				}else
				{
					//地市发证
					corpCert.setDeptgrade("3");
				}
				
				corpCert.setEnddate(rs.getDate("enddate"));
				String tradeTypeName = rs.getString("Tradetypename");
				if(tradeTypeName.equals("劳务分包"))
				{
					tradeTypeName = "施工劳务";
				}
				corpCert.setTradetypename(tradeTypeName);
				//资质行业名称转换
				String tradetypeboundname = this.getBoundName(rs.getString("tradetypeboundname"));
				corpCert.setTradetypeboundname(tradetypeboundname);

				corpCert.setNotedate(rs.getDate("notedate"));
				corpCert.setMark(rs.getString("descrpition"));
				if(corpCert.getMark()==null)
				{
					corpCert.setMark("");
				}
				if(tradetypeboundname.trim().equals("特种工程") && i==0)
				{
					corpCert.setGradename("不分等级");
					list.add(corpCert);
					i = i + 1;
				}if(tradetypeboundname.trim().equals("预拌混凝土") && i==0)
				{
					corpCert.setGradename("不分等级");
					list.add(corpCert);
					i = i + 1;
				}else if((!tradetypeboundname.equals("特种工程"))&&(!tradetypeboundname.equals("预拌混凝土")))
				{
					//等级大小写数字转换
					corpCert.setGradename(this.getGradename(rs.getString("gradename")));
					list.add(corpCert);
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	
	//查询变更信息
	public TB_QUALITY_CHANGE queryQualityChange(String corpId)
	{
		TB_QUALITY_CHANGE tqc = new TB_QUALITY_CHANGE();
		// TODO Auto-generated method stub
		String sql = "select CORPNAME, CORPID, CHANGE_CORPNAME, OLD_CORPCODE from ("
				+ "select * from TB_QUALITY_CHANGE "
				+ "where corpid = ? and (STATE='4' or STATE='7' or STATE='10') "
				+ "order by create_time desc) "
				+ "where rownum = 1";
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpId);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				tqc.setCORPID(rs.getString("CORPID"));
				tqc.setCORPNAME(rs.getString("CORPNAME"));
				tqc.setCHANGE_CORPNAME(rs.getString("CHANGE_CORPNAME"));
				tqc.setCorpCode(rs.getString("OLD_CORPCODE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return tqc;
	}
	
	/**
	 * 大写数字转换
	 * @param gradename
	 * @return
	 */
	public String getGradename(String gradename)
	{
		if(gradename.equals("一级"))
		{
			gradename = "壹级";
		}
		if(gradename.equals("二级"))
		{
			gradename = "贰级";
		}
		if(gradename.equals("三级"))
		{
			gradename = "叁级";
		}
		return gradename;
	}
	
	
	/**
	 * 资质行业名称转换
	 * @return
	 */
	public String getBoundName(String name)
	{
		if(name.equals("公路交通工程交通安全设施"))
		{
			name = "公路交通工程";
		}
		if(name.equals("房屋建筑工程"))
		{
			name = "建筑工程";
		}
		if(name.equals("冶炼工程"))
		{
			name = "冶金工程";
		}
		if(name.equals("化工石油工程"))
		{
			name = "石油化工工程";
		}
		if(name.equals("机电安装工程"))
		{
			name = "机电工程";
		}
		if(name.equals("预拌商品混凝土"))
		{
			name = "预拌混凝土";
		}
		if(name.equals("园林古建筑工程"))
		{
			name = "古建筑工程";
		}
		if(name.equals("高耸构筑物工程"))
		{
			name = "建筑工程";
		}
		if(name.equals("建筑防水工程"))
		{
			name = "防水防腐保温工程";
		}
		if(name.equals("防腐保温工程"))
		{
			name = "防水防腐保温工程";
		}
		if(name.equals("附着升降脚手架"))
		{
			name = "模板脚手架";
		}
		if(name.equals("机电设备安装工程"))
		{
			//name = "建筑机电安装工程专业承包资质";
			name = "建筑机电安装工程";
		}
		if(name.equals("建筑智能化工程"))
		{
			//name = "电子与智能化工程专业承包资质";
			name = "电子与智能化工程";
		}
		if(name.equals("电子工程"))
		{
			name = "电子与智能化工程";
		}
		if(name.equals("电信工程"))
		{
			name = "通信工程";
		}
		if(name.equals("机场空管工程及航站楼弱电系统工程"))
		{
			name = "民航空管工程及机场弱电系统工程";
		}
		if(name.equals("港口装卸设备安装工程"))
		{
			name = "港航设备安装及水上交管工程";
		}
		if(name.equals("通航设备安装工程"))
		{
			name = "港航设备安装及水上交管工程";
		}
		if(name.equals("水上交通管制工程"))
		{
			name = "港航设备安装及水上交管工程";
		}
		if(name.equals("水工建筑物基础处理工程"))
		{
			name = "水利水电工程";
		}
		if(name.equals("堤防工程"))
		{
			name = "河湖整治工程";
		}
		if(name.equals("水工大坝工程"))
		{
			name = "水利水电工程";
		}
		if(name.equals("水工隧洞工程"))
		{
			name = "水利水电工程";
		}
		if(name.equals("火电设备安装工程"))
		{
			name = "电力工程";
		}
		if(name.equals("送变电工程"))
		{
			name = "输变电工程";
		}
		if(name.equals("炉窑工程"))
		{
			name = "冶金工程";
		}
		if(name.equals("冶炼机电设备安装工程"))
		{
			name = "冶金工程";
		}
		if(name.equals("化工石油设备管道安装工程"))
		{
			name = "石油化工工程";
		}
		if(name.equals("城市轨道交通工程"))
		{
			name = "市政公用工程";
		}
		if(name.equals("特种专业工程"))
		{
			name = "特种工程";
		}
		if(name.equals("地基与基础工程"))
		{
			name = "地基基础工程";
		}
		if(name.equals("通航建筑工程"))
		{
			name = "通航建筑物工程";
		}
		if(name.equals("水利水电机电设备安装工程"))
		{
			name = "水利水电机电安装工程";
		}
		if(name.equals("施工劳务"))
		{
			name = "";
		}
		return name;
	}
	
	public void updateDate(String certid)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement("update tbcorpcertdetailinfo set updatetype=? where certid=?");
			pstmt.setString(1, "2");
			pstmt.setString(2, certid); //更改已经过打印状态
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	//上传成功日志
	public void successLog(String certid,String xml,String strErrMsg,String updateType,String uploadType,String corpName)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			String id = UUID.randomUUID().toString();
			String sql = "insert into SUCCESS_LOG(ID,CERTID,XML,STRERRMSG,updateType,"
					+ "UPLOADTYPE,createDate,CORPNAME) values(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, certid);
			pstmt.setString(3, xml);
			pstmt.setString(4, strErrMsg);
			pstmt.setString(5, updateType);
			pstmt.setString(6, uploadType);
			pstmt.setDate(7,new Date(new java.util.Date().getTime()));
			pstmt.setString(8, corpName);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	//上传错误日志
	public void recordLog(String certid,String xml,String strErrMsg,String updateType,String uploadType,String corpName)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			String id = UUID.randomUUID().toString();
			String sql = "insert into RECORD_LOG(ID,CERTID,XML,STRERRMSG,updateType,"
					+ "UPLOADTYPE,createDate,CORPNAME) values(?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, certid);
			pstmt.setString(3, xml);
			pstmt.setString(4, strErrMsg);
			pstmt.setString(5, updateType);
			pstmt.setString(6, uploadType);
			pstmt.setDate(7,new Date(new java.util.Date().getTime()));
			pstmt.setString(8, corpName);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	//记录资质证注销记录
	public void cancelLog(String certid,String strLogOutMark,String prinStaff)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			String id = UUID.randomUUID().toString();
			String sql = "insert into cancel_Log(ID,CERTID,strLogOutMark,prinStaff,"
					+ "createDate) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, certid);
			pstmt.setString(3, strLogOutMark);
			pstmt.setString(4, prinStaff);
			pstmt.setDate(5,new Date(new java.util.Date().getTime()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	public static void main(String[] args) {  
		try {  
//	    	   GenerateXml gx = new GenerateXml();  
//	           System.out.println("生成 mxl 文件...");  
//	           gx.BuildXMLDoc("D323002117"); 
	    } catch (Exception e) {  
	    	e.printStackTrace();  
	    }  
	}  
}

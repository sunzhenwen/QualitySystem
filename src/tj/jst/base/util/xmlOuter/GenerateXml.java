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
				if("�����������ι�˾".equals(econName))
				{
					econName = "�������ι�˾��������";
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
				if(corpCert.getOrganname().equals("������ʡס����"))
				{
					//ʡ�з�֤
					corpCert.setDeptgrade("2");
				}else
				{
					//���з�֤
					corpCert.setDeptgrade("3");
				}
				
				corpCert.setEnddate(rs.getDate("enddate"));
				String tradeTypeName = rs.getString("Tradetypename");
				if(tradeTypeName.equals("����ְ�"))
				{
					tradeTypeName = "ʩ������";
				}
				corpCert.setTradetypename(tradeTypeName);
				//������ҵ����ת��
				String tradetypeboundname = this.getBoundName(rs.getString("tradetypeboundname"));
				corpCert.setTradetypeboundname(tradetypeboundname);

				corpCert.setNotedate(rs.getDate("notedate"));
				corpCert.setMark(rs.getString("descrpition"));
				if(corpCert.getMark()==null)
				{
					corpCert.setMark("");
				}
				if(tradetypeboundname.trim().equals("���ֹ���") && i==0)
				{
					corpCert.setGradename("���ֵȼ�");
					list.add(corpCert);
					i = i + 1;
				}if(tradetypeboundname.trim().equals("Ԥ�������") && i==0)
				{
					corpCert.setGradename("���ֵȼ�");
					list.add(corpCert);
					i = i + 1;
				}else if((!tradetypeboundname.equals("���ֹ���"))&&(!tradetypeboundname.equals("Ԥ�������")))
				{
					//�ȼ���Сд����ת��
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
	
	//��ѯ�����Ϣ
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
	 * ��д����ת��
	 * @param gradename
	 * @return
	 */
	public String getGradename(String gradename)
	{
		if(gradename.equals("һ��"))
		{
			gradename = "Ҽ��";
		}
		if(gradename.equals("����"))
		{
			gradename = "����";
		}
		if(gradename.equals("����"))
		{
			gradename = "����";
		}
		return gradename;
	}
	
	
	/**
	 * ������ҵ����ת��
	 * @return
	 */
	public String getBoundName(String name)
	{
		if(name.equals("��·��ͨ���̽�ͨ��ȫ��ʩ"))
		{
			name = "��·��ͨ����";
		}
		if(name.equals("���ݽ�������"))
		{
			name = "��������";
		}
		if(name.equals("ұ������"))
		{
			name = "ұ�𹤳�";
		}
		if(name.equals("����ʯ�͹���"))
		{
			name = "ʯ�ͻ�������";
		}
		if(name.equals("���簲װ����"))
		{
			name = "���繤��";
		}
		if(name.equals("Ԥ����Ʒ������"))
		{
			name = "Ԥ�������";
		}
		if(name.equals("԰�ֹŽ�������"))
		{
			name = "�Ž�������";
		}
		if(name.equals("���ʹ����﹤��"))
		{
			name = "��������";
		}
		if(name.equals("������ˮ����"))
		{
			name = "��ˮ�������¹���";
		}
		if(name.equals("�������¹���"))
		{
			name = "��ˮ�������¹���";
		}
		if(name.equals("�����������ּ�"))
		{
			name = "ģ����ּ�";
		}
		if(name.equals("�����豸��װ����"))
		{
			//name = "�������簲װ����רҵ�а�����";
			name = "�������簲װ����";
		}
		if(name.equals("�������ܻ�����"))
		{
			//name = "���������ܻ�����רҵ�а�����";
			name = "���������ܻ�����";
		}
		if(name.equals("���ӹ���"))
		{
			name = "���������ܻ�����";
		}
		if(name.equals("���Ź���"))
		{
			name = "ͨ�Ź���";
		}
		if(name.equals("�����չܹ��̼���վ¥����ϵͳ����"))
		{
			name = "�񺽿չܹ��̼���������ϵͳ����";
		}
		if(name.equals("�ۿ�װж�豸��װ����"))
		{
			name = "�ۺ��豸��װ��ˮ�Ͻ��ܹ���";
		}
		if(name.equals("ͨ���豸��װ����"))
		{
			name = "�ۺ��豸��װ��ˮ�Ͻ��ܹ���";
		}
		if(name.equals("ˮ�Ͻ�ͨ���ƹ���"))
		{
			name = "�ۺ��豸��װ��ˮ�Ͻ��ܹ���";
		}
		if(name.equals("ˮ�����������������"))
		{
			name = "ˮ��ˮ�繤��";
		}
		if(name.equals("�̷�����"))
		{
			name = "�Ӻ����ι���";
		}
		if(name.equals("ˮ����ӹ���"))
		{
			name = "ˮ��ˮ�繤��";
		}
		if(name.equals("ˮ��������"))
		{
			name = "ˮ��ˮ�繤��";
		}
		if(name.equals("����豸��װ����"))
		{
			name = "��������";
		}
		if(name.equals("�ͱ�繤��"))
		{
			name = "���繤��";
		}
		if(name.equals("¯Ҥ����"))
		{
			name = "ұ�𹤳�";
		}
		if(name.equals("ұ�������豸��װ����"))
		{
			name = "ұ�𹤳�";
		}
		if(name.equals("����ʯ���豸�ܵ���װ����"))
		{
			name = "ʯ�ͻ�������";
		}
		if(name.equals("���й����ͨ����"))
		{
			name = "�������ù���";
		}
		if(name.equals("����רҵ����"))
		{
			name = "���ֹ���";
		}
		if(name.equals("�ػ����������"))
		{
			name = "�ػ���������";
		}
		if(name.equals("ͨ����������"))
		{
			name = "ͨ�������﹤��";
		}
		if(name.equals("ˮ��ˮ������豸��װ����"))
		{
			name = "ˮ��ˮ����簲װ����";
		}
		if(name.equals("ʩ������"))
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
			pstmt.setString(2, certid); //�����Ѿ�����ӡ״̬
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	//�ϴ��ɹ���־
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
	
	//�ϴ�������־
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
	
	//��¼����֤ע����¼
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
//	           System.out.println("���� mxl �ļ�...");  
//	           gx.BuildXMLDoc("D323002117"); 
	    } catch (Exception e) {  
	    	e.printStackTrace();  
	    }  
	}  
}

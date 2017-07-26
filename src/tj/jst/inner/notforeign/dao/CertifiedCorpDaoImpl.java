package com.tj.jst.inner.notforeign.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeign.model.CertifiedCorp;

public class CertifiedCorpDaoImpl implements ICertifiedCorpDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//֤������
	@Override
	public List<DictionaryClass> queryIdCardType() {
		String sql = "select code,papertype from TBIDCARDTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("papertype"));
				list.add(dictionaryClass);
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

	//�޸���ҵ
	@Override
	public String modifyCorp(CertifiedCorp corp) {
		String message = "";
		String sql = "update TBCorpBasicinfo set POSTALCODE=?,IDCARDTYPENUM=?,LEGALMANIDCARD=?,LEGALMANDUTY=?,"
				+ "LEGAMANPROTITLE=?,OFFICEPHONE=?,FAX=?,LINKMAN=?,LINKTEL=?,LINKPHONE=?,"
				+ "EMAIL=?,URL=?,DESCRIPTION=?,UPDATETIME=?,ASSETS = ?,MACHINERY = ?,CORPBIRTHDATE = ? where CORPID=? ";
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corp.getPostalCode());	//��ҵӪҵ��ַ��������
			pstmt.setString(2,corp.getIdCardTypeNum());	//����������֤������(�ֵ��TBIDCARDTYPEDIC)
			pstmt.setString(3,corp.getLegalManIdCard());//����������֤������
			pstmt.setString(4,corp.getLegalManDuty());	//����������ְ��
			pstmt.setString(5,corp.getLegaManProtitle());//����������ְ��
			pstmt.setString(6,corp.getOfficePhone());	//�칫�绰
			pstmt.setString(7,corp.getFax());			//�������
			pstmt.setString(8,corp.getLinkMan()); 		//��ϵ������
			pstmt.setString(9,corp.getLinkTel());		//��ϵ�˰칫�绰
			pstmt.setString(10,corp.getLinkPhone());	//��ϵ���ֻ�����
			pstmt.setString(11,corp.getEmail());		//��ϵ����
			pstmt.setString(12,corp.getUrl());			//��ҵ��ַ
			pstmt.setString(13,corp.getDescription());	//��ע
			pstmt.setDate(14,new Date(new java.util.Date().getTime()));	//�޸�ʱ��
			pstmt.setString(15,corp.getAssets());	//ϵͳ��Դ
			pstmt.setString(16,corp.getMachinery());	//ϵͳ��Դ
			pstmt.setDate(17,corp.getCorpBirthDate());	//��ҵ��������
			pstmt.setString(18,corp.getCorpId());	//����
			int check = pstmt.executeUpdate();
			if(check == 1)
			{
				message = "�޸ĳɹ���";
			}else
			{
				message = "�޸�ʧ�ܣ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		if(message.equals("�޸ĳɹ���"))
		{
			try {
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,corp.getPostalCode());	//��ҵӪҵ��ַ��������
				pstmt.setString(2,corp.getIdCardTypeNum());	//����������֤������(�ֵ��TBIDCARDTYPEDIC)
				pstmt.setString(3,corp.getLegalManIdCard());//����������֤������
				pstmt.setString(4,corp.getLegalManDuty());	//����������ְ��
				pstmt.setString(5,corp.getLegaManProtitle());//����������ְ��
				pstmt.setString(6,corp.getOfficePhone());	//�칫�绰
				pstmt.setString(7,corp.getFax());			//�������
				pstmt.setString(8,corp.getLinkMan()); 		//��ϵ������
				pstmt.setString(9,corp.getLinkTel());		//��ϵ�˰칫�绰
				pstmt.setString(10,corp.getLinkPhone());	//��ϵ���ֻ�����
				pstmt.setString(11,corp.getEmail());		//��ϵ����
				pstmt.setString(12,corp.getUrl());			//��ҵ��ַ
				pstmt.setString(13,corp.getDescription());	//��ע
				pstmt.setDate(14,new Date(new java.util.Date().getTime()));	//�޸�ʱ��
				pstmt.setString(15,corp.getAssets());	//ϵͳ��Դ
				pstmt.setString(16,corp.getMachinery());	//ϵͳ��Դ
				pstmt.setDate(17,corp.getCorpBirthDate());	//��ҵ��������
				pstmt.setString(18,corp.getCorpId());	//����
				int check = pstmt.executeUpdate();
				if(check == 1)
				{
					message = "�޸ĳɹ���";
				}else
				{
					message = "�޸ĳɹ���01";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally
			{
				ConnectionFactory.closeConn(conn, pstmt, null);
			}
		}
		return message;
	}

	//��ҵ��Ϣ��ѯ
	@Override
	public CertifiedCorp queryCorp(String corpId) {
		CertifiedCorp corp = new CertifiedCorp();
		String sql = "select c.*,(select p.name from TBXZQDMDIC p where c.provincenum=p.code) as provinceName,"
				+ "(select p.name from TBXZQDMDIC p where c.citynum=p.code) as cityName,"
				+ "(select p.name from TBXZQDMDIC p where c.countynum=p.code) as areaName,"
				+ "(select b.corpregtype from TBECONTYPEDIC b where c.economicNum=b.code) as economicName,"
				+ "(select h.currency from TBPRINCIPALUNITDIC h where c.principalunitnum=h.code) as principalUnitName "
				+ "from TBCORPBASICINFO c where c.corpId=?";
		
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpId);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				//����������ݿ���ڣ������޸�ҳ��
				corp.setCorpId(rs.getString("corpId"));		//����	
				corp.setCorpName(rs.getString("corpName"));	//��ҵ����
				corp.setCorpCode(rs.getString("corpCode")); 	//��֯��������
				corp.setLicenseNum(rs.getString("licenseNum"));//����Ӫҵִ��ע���
				corp.setProvinceName(rs.getString("provinceName"));//ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
				corp.setProvinceNum(rs.getString("provinceNum"));
				corp.setCityName(rs.getString("cityName"));		//ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
				corp.setCityNum(rs.getString("cityNum"));
				corp.setCountyName(rs.getString("areaName"));	//ע��������(�����С���)(�ֵ��TBXZQDMDIC)
				corp.setCountyNum(rs.getString("countynum"));
				corp.setAddress(rs.getString("address"));		//��ҵӪҵ��ַ
				corp.setPostalCode(rs.getString("postalCode"));//��ҵӪҵ��ַ��������
				corp.setLegalMan(rs.getString("legalMan"));	//��������������
				corp.setIdCardTypeNum(rs.getString("idCardTypeNum"));//����������֤������(�ֵ��TBIDCARDTYPEDIC)
				corp.setLegalManIdCard(rs.getString("legalManIdCard"));//����������֤������
				corp.setLegalManDuty(rs.getString("legalManDuty"));//����������ְ��
				corp.setLegaManProtitle(rs.getString("legaManProtitle"));//����������ְ��
				corp.setEconomicName(rs.getString("economicName"));	//��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
				corp.setEconomicNum(rs.getString("economicNum"));
				corp.setRegPrin(rs.getString("regPrin")); 		//ע���ʱ�(��Ԫ)
				corp.setFactRegPrin(rs.getString("factRegPrin"));	//ʵ���ʱ�(��Ԫ)
				corp.setPrincipalUnitName(rs.getString("principalUnitName"));//ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
				corp.setPrincipalUnitNum(rs.getString("principalUnitNum"));
				corp.setCorpBirthDate(rs.getDate("corpBirthDate"));//��������
				corp.setOfficePhone(rs.getString("officePhone"));//�칫�绰
				corp.setFax(rs.getString("fax"));				//�������
				corp.setLinkMan(rs.getString("linkMan")); 		//��ϵ������
				corp.setLinkTel(rs.getString("linkTel"));		//��ϵ�˰칫�绰
				corp.setLinkPhone(rs.getString("linkPhone"));	//��ϵ���ֻ�����
				corp.setEmail(rs.getString("email"));			//��ϵ����
				corp.setUrl(rs.getString("url"));				//��ҵ��ַ
				corp.setDescription(rs.getString("description"));	//��ע
				corp.setEconomicNum(rs.getString("economicNum"));
				corp.setSpare1(rs.getString("spare1"));
				corp.setAssets(rs.getString("ASSETS"));
				corp.setMachinery(rs.getString("MACHINERY"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corp;
	}

	/**
	 * ��ҵ�����Ƿ��λ�ж�
	 */
	@Override
	public String perchCheck(String corpName) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select * from TBQUALIFICATIONAPPLY where corpCode = ? and ( QUALIFTYPE = '9' or QUALIFTYPE = '5' or QUALIFTYPE = '1' or QUALIFTYPE = 'a')";
		try{
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpName);
			rs = pstmt.executeQuery();
			if(rs.next()){
				message = "�Ѿ�λ";
			}
			else{
				message = "δ��λ";
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return message;
	}

	/**
	 * δ��λ��ҵ��Ϣ�޸�
	 */
	@Override
	public String modifyCorpTwo(CertifiedCorp corp) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update TBCORPBASICINFO set CORPNAME = ? , "
				+ " LICENSENUM = ? , PROVINCENUM = ? , CITYNUM = ? , COUNTYNUM = ? , "
				+ "ADDRESS = ? , POSTALCODE = ? , LEGALMAN = ? , IDCARDTYPENUM = ? , "
				+ "LEGALMANIDCARD = ? , LEGALMANDUTY = ? , LEGAMANPROTITLE = ? , "
				+ "ECONOMICNUM = ? , REGPRIN = ? , FACTREGPRIN = ? , PRINCIPALUNITNUM = ? , "
				+ "CORPBIRTHDATE = ? , OFFICEPHONE= ? , FAX = ? , LINKMAN = ? , "
				+ "LINKTEL = ? , LINKPHONE = ? , EMAIL = ? , URL = ? , DESCRIPTION = ? , ASSETS = ? , MACHINERY = ? "
				+ "where corpId = ? ";
		try{
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corp.getCorpName());						//��ҵ����
			pstmt.setString(2,corp.getLicenseNum());					//����Ӫҵִ��
			pstmt.setString(3,corp.getProvinceNum());					//ע������ʡ
			pstmt.setString(4,corp.getCityNum());						//ע�����ڵ�
			pstmt.setString(5,corp.getCountyNum());						//ע��������
			pstmt.setString(6,corp.getAddress());						//��ҵӪҵ��ַ
			pstmt.setString(7,corp.getPostalCode());					//��������
			pstmt.setString(8,corp.getLegalMan());						//��������������
			pstmt.setString(9,corp.getIdCardTypeNum());				//����������֤������
			pstmt.setString(10,corp.getLegalManIdCard());				//����������֤������
			pstmt.setString(11,corp.getLegalManDuty());					//����������ְ��
			pstmt.setString(12,corp.getLegaManProtitle());				//����������ְ��
			pstmt.setString(13,corp.getEconomicNum());					//��ҵ�Ǽ�ע������
			pstmt.setString(14,corp.getRegPrin());						//ע���ʱ�����Ԫ��
			pstmt.setString(15,corp.getFactRegPrin());					//ʵ���ʱ�����Ԫ��
			pstmt.setString(16,corp.getPrincipalUnitNum());				//ע���ʱ�����
			pstmt.setDate(17,corp.getCorpBirthDate());					//��������
			pstmt.setString(18,corp.getOfficePhone());					//�칫�绰
			pstmt.setString(19,corp.getFax());							//�������
			pstmt.setString(20,corp.getLinkMan());						//��ϵ������
			pstmt.setString(21,corp.getLinkTel());						//��ϵ�˰칫�绰
			pstmt.setString(22,corp.getLinkPhone());					//��ϵ���ֻ�
			pstmt.setString(23,corp.getEmail());						//��ϵ����
			pstmt.setString(24,corp.getUrl());							//��ҵ��ַ
			pstmt.setString(25,corp.getDescription());					//��ע
			pstmt.setString(26,corp.getAssets());						//���ʲ�
			pstmt.setString(27,corp.getMachinery());					//��е�豸
			pstmt.setString(28,corp.getCorpId());						//��ҵId
			int check = pstmt.executeUpdate();			
			if(check == 1)
			{
				message = "�޸ĳɹ���";
			}else
			{
				message = "�޸�ʧ�ܣ�";
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		if(message.equals("�޸ĳɹ���")){
			try{
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,corp.getCorpName());						//��ҵ����
				pstmt.setString(2,corp.getLicenseNum());					//����Ӫҵִ��
				pstmt.setString(3,corp.getProvinceNum());					//ע������ʡ
				pstmt.setString(4,corp.getCityNum());						//ע�����ڵ�
				pstmt.setString(5,corp.getCountyNum());						//ע��������
				pstmt.setString(6,corp.getAddress());						//��ҵӪҵ��ַ
				pstmt.setString(7,corp.getPostalCode());					//��������
				pstmt.setString(8,corp.getLegalMan());						//��������������
				pstmt.setString(9,corp.getIdCardTypeNum());				//����������֤������
				pstmt.setString(10,corp.getLegalManIdCard());				//����������֤������
				pstmt.setString(11,corp.getLegalManDuty());					//����������ְ��
				pstmt.setString(12,corp.getLegaManProtitle());				//����������ְ��
				pstmt.setString(13,corp.getEconomicNum());					//��ҵ�Ǽ�ע������
				pstmt.setString(14,corp.getRegPrin());						//ע���ʱ�����Ԫ��
				pstmt.setString(15,corp.getFactRegPrin());					//ʵ���ʱ�����Ԫ��
				pstmt.setString(16,corp.getPrincipalUnitNum());				//ע���ʱ�����
				pstmt.setDate(17,corp.getCorpBirthDate());					//��������
				pstmt.setString(18,corp.getOfficePhone());					//�칫�绰
				pstmt.setString(19,corp.getFax());							//�������
				pstmt.setString(20,corp.getLinkMan());						//��ϵ������
				pstmt.setString(21,corp.getLinkTel());						//��ϵ�˰칫�绰
				pstmt.setString(22,corp.getLinkPhone());					//��ϵ���ֻ�
				pstmt.setString(23,corp.getEmail());						//��ϵ����
				pstmt.setString(24,corp.getUrl());							//��ҵ��ַ
				pstmt.setString(25,corp.getDescription());					//��ע
				pstmt.setString(26,corp.getAssets());						//���ʲ�
				pstmt.setString(27,corp.getMachinery());					//��е�豸
				pstmt.setString(28,corp.getCorpId());						//��ҵId
				int check = pstmt.executeUpdate();
				if(check == 1)
				{
					message = "�޸ĳɹ���";
				}else
				{
					message = "�޸ĳɹ�!01";
				}
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message = "�޸�ʧ�ܣ���ȷ������д����Ϣ�Ƿ����Ҫ��";
			}finally
			{
				ConnectionFactory.closeConn(conn, pstmt, null);
			}
		}
		return message;
	}

	/**
	 * ��������ͬ����֯��������֤
	 */
	@Override
	public String queryCorpCode(CertifiedCorp corp) {
		// TODO Auto-generated method stub
		String message = "";
		try{
			String sql = "select * from TBCorpBasicinfo where corpCode=? and corpId != ?";
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getCorpCode());
			pstmt.setString(2, corp.getCorpId());
			rs = pstmt.executeQuery();
			//����������ݿ���ڣ����ز�������ҵ�ٴ�ע��
			if(rs.next())
			{
				message = "������ӵ���ҵ��֯��������֤�Ѿ���¼�룬��ȷ������д����Ϣ��";
			}else{
				message = "��ҵ��Ϣ�޸ĳɹ�";
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return message;
	}

	@Override
	public List<DictionaryClass> queryProvince() {
		// TODO Auto-generated method stub
		String sql = "select * from TBXZQDMDIC where code like '%0000'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
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

	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		// TODO Auto-generated method stub
		String star = provinceId.substring(0, 2);
		String end = provinceId.substring(4, provinceId.length());
		String sql = "select * from TBXZQDMDIC where code like '"+star+"%"+end+"' and code != '"+provinceId+"'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
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

	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
		String star = cityId.substring(0, 4);
		String sql = "select * from TBXZQDMDIC where code like '"+star+"%' and code != '"+cityId+"'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
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

	@Override
	public List<DictionaryClass> queryEconomicNum() {
		// TODO Auto-generated method stub
		String sql = "select code,corpregtype from TBECONTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("corpregtype"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
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

	@Override
	public List<DictionaryClass> queryPrincipalUnit() {
		// TODO Auto-generated method stub
		String sql = "select code,currency from TBPRINCIPALUNITDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("currency"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
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
	
}

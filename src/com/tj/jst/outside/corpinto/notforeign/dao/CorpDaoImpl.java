package com.tj.jst.outside.corpinto.notforeign.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

public class CorpDaoImpl implements ICorpDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	Connection qconn = null;
	PreparedStatement qpstmt = null;
	ResultSet qrs = null;

	// ��֯��������֤��ѯ��ҵ
	@Override
	public Corp queryCorpName(String corpCode) {

		Corp corp = new Corp();
		try {

			String qsql = "select * from TBCorpBasicinfo where corpCode=? and SPARE1 is not null";
			// ��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			qconn = ConnectionFactory.getBasicConnection();
			qpstmt = qconn.prepareStatement(qsql);
			qpstmt.setString(1, corpCode);
			qrs = qpstmt.executeQuery();

			// ����������ݿ���ڣ����ز�������ҵ�ٴ�ע��
			if (qrs.next()) {
				corp.setCheckType(0);
				corp.setMessage("������ѯ����ҵ�Ѿ�ע�Ტ������ˣ���ʹ��UKey��½��");
			} else {
				// ����������ݿⲻ���ڣ���ѯ����ϵͳ���ݿ�
				String sql = "select * from TBCorpBasicinfo where corpCode=?";
				// ����������ݿ�ϵͳ�����ڣ����������ݿ��в�ѯ
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, corpCode);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					// ����������ݿ���ڣ������޸�ҳ��
					corp.setCorpId(rs.getString("corpId")); // ����
					corp.setCorpName(rs.getString("corpName")); // ��ҵ����
					corp.setCorpCode(rs.getString("corpCode")); // ��֯��������
					corp.setLicenseNum(rs.getString("licenseNum"));// ����Ӫҵִ��ע���
					corp.setProvinceNum(rs.getString("provinceNum"));// ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
					corp.setCityNum(rs.getString("cityNum")); // ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
					corp.setCountyNum(rs.getString("countyNum")); // ע��������(�����С���)(�ֵ��TBXZQDMDIC)
					corp.setAddress(rs.getString("address")); // ��ҵӪҵ��ַ
					corp.setPostalCode(rs.getString("postalCode"));// ��ҵӪҵ��ַ��������
					corp.setLegalMan(rs.getString("legalMan")); // ��������������
					corp.setIdCardTypeNum(rs.getString("idCardTypeNum"));// ����������֤������(�ֵ��TBIDCARDTYPEDIC)
					corp.setLegalManIdCard(rs.getString("legalManIdCard"));// ����������֤������
					corp.setLegalManDuty(rs.getString("legalManDuty"));// ����������ְ��
					corp.setLegaManProtitle(rs.getString("legaManProtitle"));// ����������ְ��
					corp.setEconomicNum(rs.getString("economicNum")); // ��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
					corp.setRegPrin(rs.getString("regPrin")); // ע���ʱ�(��Ԫ)
					corp.setFactRegPrin(rs.getString("factRegPrin")); // ʵ���ʱ�(��Ԫ)
					corp.setPrincipalUnitNum(rs.getString("principalUnitNum"));// ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
					corp.setCorpBirthDate(rs.getDate("corpBirthDate"));// ��������
					corp.setOfficePhone(rs.getString("officePhone"));// �칫�绰
					corp.setFax(rs.getString("fax")); // �������
					corp.setLinkMan(rs.getString("linkMan")); // ��ϵ������
					corp.setLinkTel(rs.getString("linkTel")); // ��ϵ�˰칫�绰
					corp.setLinkPhone(rs.getString("linkPhone")); // ��ϵ���ֻ�����
					corp.setEmail(rs.getString("email")); // ��ϵ����
					corp.setUrl(rs.getString("url")); // ��ҵ��ַ
					corp.setDescription(rs.getString("description")); // ��ע
					corp.setAssets(rs.getString("assets"));
					corp.setMachinery(rs.getString("machinery"));
					corp.setCheckType(1);
				} else {
					// ����������ݿⲻ���ڣ��������ע��ҳ��
					corp.setCorpCode(corpCode);
					corp.setCheckType(2);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(qconn, qpstmt, qrs);
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corp;
	}

	// ��ѯʡ
	@Override
	public List<DictionaryClass> queryProvince() {
		String sql = "select * from TBXZQDMDIC where code like '%0000'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	// ��ѯ��
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		String star = provinceId.substring(0, 2);
		String end = provinceId.substring(4, provinceId.length());
		String sql = "select * from TBXZQDMDIC where code like '" + star + "%"
				+ end + "' and code != '" + provinceId + "'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	// ֤������
	@Override
	public List<DictionaryClass> queryIdCardType() {
		String sql = "select code,papertype from TBIDCARDTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("papertype"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	// ��ҵ�Ǽ�ע������
	@Override
	public List<DictionaryClass> queryEconomicNum() {
		String sql = "select code,corpregtype from TBECONTYPEDIC where code not like '%00'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("corpregtype"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	// ע���ʱ�����
	@Override
	public List<DictionaryClass> queryPrincipalUnit() {
		String sql = "select code,currency from TBPRINCIPALUNITDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("currency"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	// �����ҵ
	@Override
	public String addCorp(Corp corp) {
		String message = "";
		int check = 0;
		String sql = "insert into TBCorpBasicinfo(CORPNAME,CORPCODE,LICENSENUM,PROVINCENUM,CITYNUM,"
				+ "COUNTYNUM,ADDRESS,POSTALCODE,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,"
				+ "LEGAMANPROTITLE,ECONOMICNUM,REGPRIN,FACTREGPRIN,PRINCIPALUNITNUM,CORPBIRTHDATE,OFFICEPHONE,"
				+ "FAX,LINKMAN,LINKTEL,LINKPHONE,EMAIL,URL,DESCRIPTION,CREATDATE,CORPID,OLDORNEW,ASSETS,MACHINERY,DATASOURCE) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String corpId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getCorpName()); // ��ҵ����
			pstmt.setString(2, corp.getCorpCode()); // ��֯��������
			pstmt.setString(3, corp.getLicenseNum());// ����Ӫҵִ��ע���
			pstmt.setString(4, corp.getProvinceNum());// ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
			pstmt.setString(5, corp.getCityNum()); // ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(6, corp.getCountyNum()); // ע��������(�����С���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(7, corp.getAddress()); // ��ҵӪҵ��ַ
			pstmt.setString(8, corp.getPostalCode());// ��ҵӪҵ��ַ��������
			pstmt.setString(9, corp.getLegalMan()); // ��������������
			pstmt.setString(10, corp.getIdCardTypeNum());// ����������֤������(�ֵ��TBIDCARDTYPEDIC)
			pstmt.setString(11, corp.getLegalManIdCard());// ����������֤������
			pstmt.setString(12, corp.getLegalManDuty());// ����������ְ��
			pstmt.setString(13, corp.getLegaManProtitle());// ����������ְ��
			pstmt.setInt(14, Integer.parseInt(corp.getEconomicNum())); // ��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
			pstmt.setDouble(15, Double.parseDouble(corp.getRegPrin())); // ע���ʱ�(��Ԫ)
			pstmt.setDouble(16, Double.parseDouble(corp.getFactRegPrin())); // ʵ���ʱ�(��Ԫ)
			pstmt.setString(17, corp.getPrincipalUnitNum());// ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
			pstmt.setDate(18, corp.getCorpBirthDate());// ��������
			pstmt.setString(19, corp.getOfficePhone());// �칫�绰
			pstmt.setString(20, corp.getFax()); // �������
			pstmt.setString(21, corp.getLinkMan()); // ��ϵ������
			pstmt.setString(22, corp.getLinkTel()); // ��ϵ�˰칫�绰
			pstmt.setString(23, corp.getLinkPhone()); // ��ϵ���ֻ�����
			pstmt.setString(24, corp.getEmail()); // ��ϵ����
			pstmt.setString(25, corp.getUrl()); // ��ҵ��ַ
			pstmt.setString(26, corp.getDescription()); // ��ע
			pstmt.setDate(27, new Date(new java.util.Date().getTime())); // ���ʱ��
			pstmt.setString(28, corpId); // ����
			pstmt.setString(29, "1"); // �������ݣ�0�����ݣ�1������
			pstmt.setString(30, corp.getAssets());
			pstmt.setString(31, corp.getMachinery());
			pstmt.setString(32, "01");
			check = pstmt.executeUpdate();
			if (check > 0) {
				message = "ע��ɹ�,�뵽���������ˣ�";
			} else {
				message = "ע��ʧ�ܣ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		if (check > 0) {
			try {
				String sql2 = "insert into TBCorpBasicinfo(CORPNAME,CORPCODE,LICENSENUM,PROVINCENUM,CITYNUM,"
						+ "COUNTYNUM,ADDRESS,POSTALCODE,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,"
						+ "LEGAMANPROTITLE,ECONOMICNUM,REGPRIN,FACTREGPRIN,PRINCIPALUNITNUM,CORPBIRTHDATE,OFFICEPHONE,"
						+ "FAX,LINKMAN,LINKTEL,LINKPHONE,EMAIL,URL,DESCRIPTION,CORPID,OLDORNEW,ASSETS,MACHINERY) "
						+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql2);
				pstmt.setString(1, corp.getCorpName()); // ��ҵ����
				pstmt.setString(2, corp.getCorpCode()); // ��֯��������
				pstmt.setString(3, corp.getLicenseNum());// ����Ӫҵִ��ע���
				pstmt.setString(4, corp.getProvinceNum());// ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
				pstmt.setString(5, corp.getCityNum()); // ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
				pstmt.setString(6, corp.getCountyNum()); // ע��������(�����С���)(�ֵ��TBXZQDMDIC)
				pstmt.setString(7, corp.getAddress()); // ��ҵӪҵ��ַ
				pstmt.setString(8, corp.getPostalCode());// ��ҵӪҵ��ַ��������
				pstmt.setString(9, corp.getLegalMan()); // ��������������
				pstmt.setString(10, corp.getIdCardTypeNum());// ����������֤������(�ֵ��TBIDCARDTYPEDIC)
				pstmt.setString(11, corp.getLegalManIdCard());// ����������֤������
				pstmt.setString(12, corp.getLegalManDuty());// ����������ְ��
				pstmt.setString(13, corp.getLegaManProtitle());// ����������ְ��
				pstmt.setInt(14, Integer.parseInt(corp.getEconomicNum())); // ��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
				pstmt.setDouble(15, Double.parseDouble(corp.getRegPrin())); // ע���ʱ�(��Ԫ)
				pstmt.setDouble(16, Double.parseDouble(corp.getFactRegPrin())); // ʵ���ʱ�(��Ԫ)
				pstmt.setString(17, corp.getPrincipalUnitNum());// ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
				pstmt.setDate(18, corp.getCorpBirthDate());// ��������
				pstmt.setString(19, corp.getOfficePhone());// �칫�绰
				pstmt.setString(20, corp.getFax()); // �������
				pstmt.setString(21, corp.getLinkMan()); // ��ϵ������
				pstmt.setString(22, corp.getLinkTel()); // ��ϵ�˰칫�绰
				pstmt.setString(23, corp.getLinkPhone()); // ��ϵ���ֻ�����
				pstmt.setString(24, corp.getEmail()); // ��ϵ����
				pstmt.setString(25, corp.getUrl()); // ��ҵ��ַ
				pstmt.setString(26, corp.getDescription()); // ��ע
				// pstmt.setDate(27,new Date(new java.util.Date().getTime()));
				// //���ʱ��
				pstmt.setString(27, corpId); // ����
				pstmt.setString(28, "1"); // �������ݣ�0�����ݣ�1������
				pstmt.setString(29, corp.getAssets());
				pstmt.setString(30, corp.getMachinery());
				int check1 = pstmt.executeUpdate();
				if (check1 == 1) {
					message = "ע��ɹ�,�뵽���������ˣ�";
				} else {
					message = "ע��ʧ�ܣ�";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectionFactory.closeConn(conn, pstmt, null);
			}
		}
		return message;
	}

	// �޸���ҵ
	@Override
	public String modifyCorp(Corp corp) {
		String message = "";
		int check = 0;
		String sql = "update TBCorpBasicinfo set CORPNAME=?,CORPCODE=?,LICENSENUM=?,PROVINCENUM=?,CITYNUM=?,"
				+ "COUNTYNUM=?,ADDRESS=?,POSTALCODE=?,LEGALMAN=?,IDCARDTYPENUM=?,LEGALMANIDCARD=?,LEGALMANDUTY=?,"
				+ "LEGAMANPROTITLE=?,ECONOMICNUM=?,REGPRIN=?,FACTREGPRIN=?,PRINCIPALUNITNUM=?,CORPBIRTHDATE=?,OFFICEPHONE=?,"
				+ "FAX=?,LINKMAN=?,LINKTEL=?,LINKPHONE=?,EMAIL=?,URL=?,DESCRIPTION=?,UPDATETIME=?,ASSETS=?,MACHINERY=? where CORPID=? ";
		String sql2 = "update TBCorpBasicinfo set CORPNAME=?,CORPCODE=?,LICENSENUM=?,PROVINCENUM=?,CITYNUM=?,"
				+ "COUNTYNUM=?,ADDRESS=?,POSTALCODE=?,LEGALMAN=?,IDCARDTYPENUM=?,LEGALMANIDCARD=?,LEGALMANDUTY=?,"
				+ "LEGAMANPROTITLE=?,ECONOMICNUM=?,REGPRIN=?,FACTREGPRIN=?,PRINCIPALUNITNUM=?,CORPBIRTHDATE=?,OFFICEPHONE=?,"
				+ "FAX=?,LINKMAN=?,LINKTEL=?,LINKPHONE=?,EMAIL=?,URL=?,DESCRIPTION=?,UPDATETIME=?,ASSETS=?,MACHINERY=? where CORPID=? ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql2);
			pstmt.setString(1, corp.getCorpName()); // ��ҵ����
			pstmt.setString(2, corp.getCorpCode()); // ��֯��������
			pstmt.setString(3, corp.getLicenseNum());// ����Ӫҵִ��ע���
			pstmt.setString(4, corp.getProvinceNum());// ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
			pstmt.setString(5, corp.getCityNum()); // ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(6, corp.getCountyNum()); // ע��������(�����С���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(7, corp.getAddress()); // ��ҵӪҵ��ַ
			pstmt.setString(8, corp.getPostalCode());// ��ҵӪҵ��ַ��������
			pstmt.setString(9, corp.getLegalMan()); // ��������������
			pstmt.setString(10, corp.getIdCardTypeNum());// ����������֤������(�ֵ��TBIDCARDTYPEDIC)
			pstmt.setString(11, corp.getLegalManIdCard());// ����������֤������
			pstmt.setString(12, corp.getLegalManDuty());// ����������ְ��
			pstmt.setString(13, corp.getLegaManProtitle());// ����������ְ��
			pstmt.setInt(14, Integer.parseInt(corp.getEconomicNum())); // ��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
			pstmt.setDouble(15, Double.parseDouble(corp.getRegPrin())); // ע���ʱ�(��Ԫ)
			pstmt.setDouble(16, Double.parseDouble(corp.getFactRegPrin())); // ʵ���ʱ�(��Ԫ)
			pstmt.setString(17, corp.getPrincipalUnitNum());// ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
			pstmt.setDate(18, corp.getCorpBirthDate());// ��������
			pstmt.setString(19, corp.getOfficePhone());// �칫�绰
			pstmt.setString(20, corp.getFax()); // �������
			pstmt.setString(21, corp.getLinkMan()); // ��ϵ������
			pstmt.setString(22, corp.getLinkTel()); // ��ϵ�˰칫�绰
			pstmt.setString(23, corp.getLinkPhone()); // ��ϵ���ֻ�����
			pstmt.setString(24, corp.getEmail()); // ��ϵ����
			pstmt.setString(25, corp.getUrl()); // ��ҵ��ַ
			pstmt.setString(26, corp.getDescription()); // ��ע
			pstmt.setDate(27, new Date(new java.util.Date().getTime())); // �޸�ʱ��
			pstmt.setString(28, corp.getAssets());
			pstmt.setString(29, corp.getMachinery());
			pstmt.setString(30, corp.getCorpId()); // ����
			check = pstmt.executeUpdate();
			if (check > 0) {
				message = "�޸ĳɹ���";
			} else {
				message = "�޸�ʧ�ܣ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}

		if (check > 0) {
			try {
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, corp.getCorpName()); // ��ҵ����
				pstmt.setString(2, corp.getCorpCode()); // ��֯��������
				pstmt.setString(3, corp.getLicenseNum());// ����Ӫҵִ��ע���
				pstmt.setString(4, corp.getProvinceNum());// ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
				pstmt.setString(5, corp.getCityNum()); // ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
				pstmt.setString(6, corp.getCountyNum()); // ע��������(�����С���)(�ֵ��TBXZQDMDIC)
				pstmt.setString(7, corp.getAddress()); // ��ҵӪҵ��ַ
				pstmt.setString(8, corp.getPostalCode());// ��ҵӪҵ��ַ��������
				pstmt.setString(9, corp.getLegalMan()); // ��������������
				pstmt.setString(10, corp.getIdCardTypeNum());// ����������֤������(�ֵ��TBIDCARDTYPEDIC)
				pstmt.setString(11, corp.getLegalManIdCard());// ����������֤������
				pstmt.setString(12, corp.getLegalManDuty());// ����������ְ��
				pstmt.setString(13, corp.getLegaManProtitle());// ����������ְ��
				pstmt.setInt(14, Integer.parseInt(corp.getEconomicNum())); // ��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
				pstmt.setDouble(15, Double.parseDouble(corp.getRegPrin())); // ע���ʱ�(��Ԫ)
				pstmt.setDouble(16,
						Double.parseDouble(corp.getFactRegPrin())); // ʵ���ʱ�(��Ԫ)
				pstmt.setString(17, corp.getPrincipalUnitNum());// ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
				pstmt.setDate(18, corp.getCorpBirthDate());// ��������
				pstmt.setString(19, corp.getOfficePhone());// �칫�绰
				pstmt.setString(20, corp.getFax()); // �������
				pstmt.setString(21, corp.getLinkMan()); // ��ϵ������
				pstmt.setString(22, corp.getLinkTel()); // ��ϵ�˰칫�绰
				pstmt.setString(23, corp.getLinkPhone()); // ��ϵ���ֻ�����
				pstmt.setString(24, corp.getEmail()); // ��ϵ����
				pstmt.setString(25, corp.getUrl()); // ��ҵ��ַ
				pstmt.setString(26, corp.getDescription()); // ��ע
				pstmt.setDate(27, new Date(new java.util.Date().getTime())); // �޸�ʱ��
				pstmt.setString(28, corp.getAssets());
				pstmt.setString(29, corp.getMachinery());
				pstmt.setString(30, corp.getCorpId()); // ����
				check = pstmt.executeUpdate();
				if (check > 0) {
					message = "�޸ĳɹ���";
				} else {
					message = "�޸ĳɹ���";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				ConnectionFactory.closeConn(conn, pstmt, null);
			}

		}
		
		return message;
	}

	// ��ѯ��
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		String star = cityId.substring(0, 4);
		String sql = "select * from TBXZQDMDIC where code like '" + star
				+ "%' and code != '" + cityId + "'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {

			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	//��ѯ������������ 
	@Override
	public List<DictionaryClass> queryHLJCitys() {
		String sql = "select * from TBXZQDMDIC where code like '23%00' and code != '230000'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

}

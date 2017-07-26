package com.tj.jst.inner.notforeigninfo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeigninfo.model.CorpInfo;

/**
 * ��ҵ��Ϣ����
 * 
 * @author DarkFlameMaster
 *
 */
public class CorpInfoDaoImpl extends BaseDao implements ICorpInfoDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ��ѯ��ҵ��֯��������֤�����������ظ�����ҵ����
	 */
	@Override
	public String queryCorpName(CorpInfo corp) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			String sql = "select * from TBCorpBasicinfo where corpCode=?";
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getCorpCode());
			rs = pstmt.executeQuery();
			// ����������ݿ���ڣ����ز�������ҵ�ٴ�ע��
			if (rs.next()) {
				corp.setCheckType(0);
				corp.setMessage("������ӵ���ҵ��֯��������֤�Ѿ���¼�룬��ȷ������д����Ϣ��");
				message = "������ӵ���ҵ��֯��������֤�Ѿ���¼�룬��ȷ������д����Ϣ��";
			} else {
				message = "�ɹ�";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return message;
	}

	/**
	 * ��ѯʡ
	 */
	@Override
	public List<DictionaryClass> queryProvince() {
		// TODO Auto-generated method stub
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

	/**
	 * ��ѯ��
	 */
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		// TODO Auto-generated method stub
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

	/**
	 * ��ѯ��
	 */
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
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

	/**
	 * �ֵ䣺֤����
	 */
	@Override
	public List<DictionaryClass> queryIdCardType() {
		// TODO Auto-generated method stub
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

	/**
	 * �ֵ䣺�Ǽ�ע������
	 */
	@Override
	public List<DictionaryClass> queryEconomicNum() {
		// TODO Auto-generated method stub
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

	/**
	 * �ֵ䣺ע�����
	 */
	@Override
	public List<DictionaryClass> queryPrincipalUnit() {
		// TODO Auto-generated method stub
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

	/**
	 * ������ҵ��Ϣ
	 */
	@Override
	public String addCorp(CorpInfo corp) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "insert into TBCorpBasicinfo(CORPNAME,CORPCODE,LICENSENUM,PROVINCENUM,CITYNUM,"
				+ "COUNTYNUM,ADDRESS,POSTALCODE,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,"
				+ "LEGAMANPROTITLE,ECONOMICNUM,REGPRIN,FACTREGPRIN,PRINCIPALUNITNUM,CORPBIRTHDATE,OFFICEPHONE,"
				+ "FAX,LINKMAN,LINKTEL,LINKPHONE,EMAIL,URL,DESCRIPTION,UPDATETIME,CORPID,OLDORNEW,ASSETS,MACHINERY) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String corpId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getCorpName()); // ��ҵ����
			pstmt.setString(2, corp.getCorpCode()); // ��֯��������
			pstmt.setString(3, corp.getLicenseNum()); // ����Ӫҵִ��ע���
			pstmt.setString(4, corp.getProvinceNum()); // ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
			pstmt.setString(5, corp.getCityNum()); // ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(6, corp.getCountyNum()); // ע��������(�����С���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(7, corp.getAddress()); // ��ҵӪҵ��ַ
			pstmt.setString(8, corp.getPostalCode()); // ��ҵӪҵ��ַ��������
			pstmt.setString(9, corp.getLegalMan()); // ��������������
			pstmt.setString(10, corp.getIdCardTypeNum()); // ����������֤������(�ֵ��TBIDCARDTYPEDIC)
			pstmt.setString(11, corp.getLegalManIdCard()); // ����������֤������
			pstmt.setString(12, corp.getLegalManDuty()); // ����������ְ��
			pstmt.setString(13, corp.getLegaManProtitle()); // ����������ְ��
			pstmt.setInt(14, Integer.parseInt(corp.getEconomicNum())); // ��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
			pstmt.setDouble(15, Double.parseDouble(corp.getRegPrin())); // ע���ʱ�(��Ԫ)
			pstmt.setDouble(16, Double.parseDouble(corp.getFactRegPrin())); // ʵ���ʱ�(��Ԫ)
			pstmt.setString(17, corp.getPrincipalUnitNum()); // ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
			pstmt.setDate(18, corp.getCorpBirthDate()); // ��������
			pstmt.setString(19, corp.getOfficePhone()); // �칫�绰
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
			pstmt.setString(30, corp.getAssets()); // ���ʲ�
			pstmt.setString(31, corp.getMachinery()); // ��е�豸
			int check = pstmt.executeUpdate();
			if (check == 1) {
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

		if (message.equals("ע��ɹ�,�뵽���������ˣ�")) {
			try {
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, corp.getCorpName()); // ��ҵ����
				pstmt.setString(2, corp.getCorpCode()); // ��֯��������
				pstmt.setString(3, corp.getLicenseNum()); // ����Ӫҵִ��ע���
				pstmt.setString(4, corp.getProvinceNum()); // ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
				pstmt.setString(5, corp.getCityNum()); // ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
				pstmt.setString(6, corp.getCountyNum()); // ע��������(�����С���)(�ֵ��TBXZQDMDIC)
				pstmt.setString(7, corp.getAddress()); // ��ҵӪҵ��ַ
				pstmt.setString(8, corp.getPostalCode()); // ��ҵӪҵ��ַ��������
				pstmt.setString(9, corp.getLegalMan()); // ��������������
				pstmt.setString(10, corp.getIdCardTypeNum()); // ����������֤������(�ֵ��TBIDCARDTYPEDIC)
				pstmt.setString(11, corp.getLegalManIdCard()); // ����������֤������
				pstmt.setString(12, corp.getLegalManDuty()); // ����������ְ��
				pstmt.setString(13, corp.getLegaManProtitle()); // ����������ְ��
				pstmt.setInt(14, Integer.parseInt(corp.getEconomicNum())); // ��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
				pstmt.setDouble(15, Double.parseDouble(corp.getRegPrin())); // ע���ʱ�(��Ԫ)
				pstmt.setDouble(16, Double.parseDouble(corp.getFactRegPrin())); // ʵ���ʱ�(��Ԫ)
				pstmt.setString(17, corp.getPrincipalUnitNum()); // ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
				pstmt.setDate(18, corp.getCorpBirthDate()); // ��������
				pstmt.setString(19, corp.getOfficePhone()); // �칫�绰
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
				pstmt.setString(30, corp.getAssets()); // ���ʲ�
				pstmt.setString(31, corp.getMachinery()); // ��е�豸
				int check = pstmt.executeUpdate();
				if (check == 1) {
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

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					CorpInfo corp = new CorpInfo();
					corp.setCorpId(rs.getString("corpId")); // ��ҵId
					corp.setCorpName(rs.getString("corpName")); // ��ҵ����
					corp.setCorpCode(rs.getString("corpCode")); // ��ҵ��֯��������֤
					corp.setLicenseNum(rs.getString("licenseNum")); // ����Ӫҵִ��ע���
					corp.setOfficePhone(rs.getString("officePhone")); // �칫�绰
					page.getData().add(corp);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(),
					page.getRs());
		}
		return page;
	}

	/**
	 * ͨ��corpId����ѯ��Ҫ�޸ĵ���ҵ
	 */
	@Override
	public CorpInfo queryById(String corpId) {
		// TODO Auto-generated method stub
		CorpInfo corp = new CorpInfo();
		String sql = "select * from TBCORPBASICINFO where corpId = ?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				corp.setCorpId(rs.getString("corpId")); // ��ҵId
				corp.setCorpName(rs.getString("corpName")); // ��ҵ����
				corp.setCorpCode(rs.getString("corpCode")); // ��֯��������֤
				corp.setLicenseNum(rs.getString("licenseNum")); // ����Ӫҵִ��ע���
				corp.setProvinceNum(rs.getString("provinceNum")); // ע������ʡ
				corp.setCityNum(rs.getString("cityNum")); // ע�����ڵ�
				corp.setCountyNum(rs.getString("countyNum")); // ע��������
				corp.setAddress(rs.getString("address")); // ��ҵӪҵ��ַ
				corp.setPostalCode(rs.getString("postalCode")); // ��������
				corp.setLegalMan(rs.getString("legalMan")); // ��������������
				corp.setIdCardTypeNum(rs.getString("idcardTypeNum")); // ����������֤������
				corp.setLegalManIdCard(rs.getString("legalManIdCard")); // ���д�����֤������
				corp.setLegalManDuty(rs.getString("legalManDuty")); // ����������ְ��
				corp.setLegaManProtitle(rs.getString("legaManProtitle")); // ����������ְ��
				corp.setEconomicNum(rs.getString("economicNum")); // ��ҵ�Ǽ�ע������
				corp.setRegPrin(rs.getString("regPrin")); // ע���ʱ�����Ԫ��
				corp.setFactRegPrin(rs.getString("factRegPrin")); // ʵ���ʱ�����Ԫ��
				corp.setPrincipalUnitNum(rs.getString("principalUnitNum")); // ע���ʱ�����
				corp.setCorpBirthDate(rs.getDate("corpBirthDate")); // ��������
				corp.setOfficePhone(rs.getString("officePhone")); // �칫�绰
				corp.setFax(rs.getString("fax")); // �������
				corp.setLinkMan(rs.getString("linkMan")); // ��ϵ������
				corp.setLinkTel(rs.getString("linkTel")); // ��ϵ�˰칫�绰
				corp.setLinkPhone(rs.getString("linkPhone")); // ��ϵ���ֻ�����
				corp.setEmail(rs.getString("email")); // ��ϵ����
				corp.setUrl(rs.getString("Url")); // ��ҵ��ַ
				corp.setDescription(rs.getString("description")); // ��ע
				corp.setAssets(rs.getString("assets")); // ���ʲ�
				corp.setMachinery(rs.getString("machinery")); // ��е�豸
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corp;
	}

	/**
	 * �޸���ҵ��Ϣ
	 */
	@Override
	public String modify(CorpInfo corp) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update TBCORPBASICINFO set CORPNAME = ? , CORPCODE = ? ,"
				+ " LICENSENUM = ? , PROVINCENUM = ? , CITYNUM = ? , COUNTYNUM = ? , "
				+ "ADDRESS = ? , POSTALCODE = ? , LEGALMAN = ? , IDCARDTYPENUM = ? , "
				+ "LEGALMANIDCARD = ? , LEGALMANDUTY = ? , LEGAMANPROTITLE = ? , "
				+ "ECONOMICNUM = ? , REGPRIN = ? , FACTREGPRIN = ? , PRINCIPALUNITNUM = ? , "
				+ "CORPBIRTHDATE = ? , OFFICEPHONE= ? , FAX = ? , LINKMAN = ? , "
				+ "LINKTEL = ? , LINKPHONE = ? , EMAIL = ? , URL = ? , DESCRIPTION = ? , ASSETS = ? ,"
				+ "MACHINERY= ?  where corpId = ? ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getCorpName()); // ��ҵ����
			pstmt.setString(2, corp.getCorpCode()); // ��֯��������֤
			pstmt.setString(3, corp.getLicenseNum()); // ����Ӫҵִ��
			pstmt.setString(4, corp.getProvinceNum()); // ע������ʡ
			pstmt.setString(5, corp.getCityNum()); // ע�����ڵ�
			pstmt.setString(6, corp.getCountyNum()); // ע��������
			pstmt.setString(7, corp.getAddress()); // ��ҵӪҵ��ַ
			pstmt.setString(8, corp.getPostalCode()); // ��������
			pstmt.setString(9, corp.getLegalMan()); // ��������������
			pstmt.setString(10, corp.getIdCardTypeNum()); // ����������֤������
			pstmt.setString(11, corp.getLegalManIdCard()); // ����������֤������
			pstmt.setString(12, corp.getLegalManDuty()); // ����������ְ��
			pstmt.setString(13, corp.getLegaManProtitle()); // ����������ְ��
			pstmt.setString(14, corp.getEconomicNum()); // ��ҵ�Ǽ�ע������
			pstmt.setString(15, corp.getRegPrin()); // ע���ʱ�����Ԫ��
			pstmt.setString(16, corp.getFactRegPrin()); // ʵ���ʱ�����Ԫ��
			pstmt.setString(17, corp.getPrincipalUnitNum()); // ע���ʱ�����
			pstmt.setDate(18, corp.getCorpBirthDate()); // ��������
			pstmt.setString(19, corp.getOfficePhone()); // �칫�绰
			pstmt.setString(20, corp.getFax()); // �������
			pstmt.setString(21, corp.getLinkMan()); // ��ϵ������
			pstmt.setString(22, corp.getLinkTel()); // ��ϵ�˰칫�绰
			pstmt.setString(23, corp.getLinkPhone()); // ��ϵ���ֻ�
			pstmt.setString(24, corp.getEmail()); // ��ϵ����
			pstmt.setString(25, corp.getUrl()); // ��ҵ��ַ
			pstmt.setString(26, corp.getDescription()); // ��ע
			pstmt.setString(27, corp.getAssets()); // ���ʲ�
			pstmt.setString(28, corp.getMachinery()); // ��е�豸
			pstmt.setString(29, corp.getCorpId()); // ��ҵId
			int check = pstmt.executeUpdate();
			if (check == 1) {
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
		if (message.equals("�޸ĳɹ���")) {
			try {
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, corp.getCorpName());
				pstmt.setString(2, corp.getCorpCode());
				pstmt.setString(3, corp.getLicenseNum());
				pstmt.setString(4, corp.getProvinceNum());
				pstmt.setString(5, corp.getCityNum());
				pstmt.setString(6, corp.getCountyNum());
				pstmt.setString(7, corp.getAddress());
				pstmt.setString(8, corp.getPostalCode());
				pstmt.setString(9, corp.getLegalMan());
				pstmt.setString(10, corp.getIdCardTypeNum());
				pstmt.setString(11, corp.getLegalManIdCard());
				pstmt.setString(12, corp.getLegalManDuty());
				pstmt.setString(13, corp.getLegaManProtitle());
				pstmt.setString(14, corp.getEconomicNum());
				pstmt.setString(15, corp.getRegPrin());
				pstmt.setString(16, corp.getFactRegPrin());
				pstmt.setString(17, corp.getPrincipalUnitNum());
				pstmt.setDate(18, corp.getCorpBirthDate());
				pstmt.setString(19, corp.getOfficePhone());
				pstmt.setString(20, corp.getFax());
				pstmt.setString(21, corp.getLinkMan());
				pstmt.setString(22, corp.getLinkTel());
				pstmt.setString(23, corp.getLinkPhone());
				pstmt.setString(24, corp.getEmail());
				pstmt.setString(25, corp.getUrl());
				pstmt.setString(26, corp.getDescription());
				pstmt.setString(27, corp.getAssets()); // ���ʲ�
				pstmt.setString(28, corp.getMachinery()); // ��е�豸
				pstmt.setString(29, corp.getCorpId()); // ��ҵId
				int check = pstmt.executeUpdate();
				if (check == 1) {
					message = "�޸ĳɹ���";
				} else {
					message = "�޸�ʧ�ܣ�";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message = "�޸�ʧ�ܣ���ȷ������д����Ϣ�Ƿ����Ҫ��";
			} finally {
				ConnectionFactory.closeConn(conn, pstmt, null);
			}
		}
		return message;
	}

	/**
	 * ͨ��corpId �� corpName �ж����޸ĵ���ҵ�����Ƿ��ظ�
	 */
	@Override
	public String queryCorpInfoUsed(String corpId, String corpName) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select * from TBCORPBASICINFO where corpName = ?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (corpId.equals(rs.getString("corpId"))) {
					message = "�ɹ�";
				} else {
					message = "ʧ��";
				}
			} else {
				message = "�ɹ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return message;
	}

	@Override
	public CorpInfo queryByCode(String corpCode) {
		// TODO Auto-generated method stub
		CorpInfo corp = new CorpInfo();
		String sql = "select * from TBCORPBASICINFO where corpCode = ?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				corp.setCorpId(rs.getString("corpId"));
				corp.setCorpName(rs.getString("corpName")); // ��ҵ����
				corp.setCorpCode(rs.getString("corpCode")); // ��֯��������֤
				corp.setLicenseNum(rs.getString("licenseNum")); // ����Ӫҵִ��ע���
				corp.setProvinceNum(rs.getString("provinceNum")); // ע������ʡ
				corp.setCityNum(rs.getString("cityNum")); // ע�����ڵ�
				corp.setCountyNum(rs.getString("countyNum")); // ע��������
				corp.setAddress(rs.getString("address")); // ��ҵӪҵ��ַ
				corp.setPostalCode(rs.getString("postalCode")); // ��������
				corp.setLegalMan(rs.getString("legalMan")); // ��������������
				corp.setIdCardTypeNum(rs.getString("idcardTypeNum")); // ����������֤������
				corp.setLegalManIdCard(rs.getString("legalManIdCard")); // ���д�����֤������
				corp.setLegalManDuty(rs.getString("legalManDuty")); // ����������ְ��
				corp.setLegaManProtitle(rs.getString("legaManProtitle")); // ����������ְ��
				corp.setEconomicNum(rs.getString("economicNum")); // ��ҵ�Ǽ�ע������
				corp.setRegPrin(rs.getString("regPrin")); // ע���ʱ�����Ԫ��
				corp.setFactRegPrin(rs.getString("factRegPrin")); // ʵ���ʱ�����Ԫ��
				corp.setPrincipalUnitNum(rs.getString("principalUnitNum")); // ע���ʱ�����
				corp.setCorpBirthDate(rs.getDate("corpBirthDate")); // ��������
				corp.setOfficePhone(rs.getString("officePhone")); // �칫�绰
				corp.setFax(rs.getString("fax")); // �������
				corp.setLinkMan(rs.getString("linkMan")); // ��ϵ������
				corp.setLinkTel(rs.getString("linkTel")); // ��ϵ�˰칫�绰
				corp.setLinkPhone(rs.getString("linkPhone")); // ��ϵ���ֻ�����
				corp.setEmail(rs.getString("email")); // ��ϵ����
				corp.setUrl(rs.getString("Url")); // ��ҵ��ַ
				corp.setDescription(rs.getString("description")); // ��ע
				corp.setAssets(rs.getString("assets")); // ���ʲ�
				corp.setMachinery(rs.getString("machinery")); // ��е�豸
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corp;
	}

}

package com.tj.jst.outside.businessReport.corpchangearea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeign.model.CertifiedCorp;
import com.tj.jst.inner.qualificationProductivity.changearea.model.ChangeArea;

public class CorpChangeAreaDaoImpl extends BaseDao implements
		ICorpChangeAreaDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ��ѯ��ҵ��Ϣ
	 */
	@Override
	public CertifiedCorp queryPage(String corpName) {
		// TODO Auto-generated method stub
		CertifiedCorp corp = new CertifiedCorp();
		String sql = "select c.*,(select p.name from TBXZQDMDIC p where c.provincenum=p.code) as provinceName,"
				+ "(select p.name from TBXZQDMDIC p where c.citynum=p.code) as cityName,"
				+ "(select p.name from TBXZQDMDIC p where c.countynum=p.code) as areaName,"
				+ "(select b.corpregtype from TBECONTYPEDIC b where c.economicNum=b.code) as economicName,"
				+ "(select h.currency from TBPRINCIPALUNITDIC h where c.principalunitnum=h.code) as principalUnitName "
				+ "from TBCORPBASICINFO c where c.corpName=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				// ����������ݿ���ڣ������޸�ҳ��
				corp.setCorpId(rs.getString("corpId")); // ����
				corp.setCorpName(rs.getString("corpName")); // ��ҵ����
				corp.setCorpCode(rs.getString("corpCode")); // ��֯��������
				corp.setLicenseNum(rs.getString("licenseNum"));// ����Ӫҵִ��ע���
				corp.setProvinceName(rs.getString("provinceName"));// ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
				corp.setProvinceNum(rs.getString("provinceNum"));
				corp.setCityName(rs.getString("cityName")); // ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
				corp.setCityNum(rs.getString("cityNum"));
				corp.setCountyName(rs.getString("areaName")); // ע��������(�����С���)(�ֵ��TBXZQDMDIC)
				corp.setCountyNum(rs.getString("countynum"));
				corp.setAddress(rs.getString("address")); // ��ҵӪҵ��ַ
				corp.setPostalCode(rs.getString("postalCode"));// ��ҵӪҵ��ַ��������
				corp.setLegalMan(rs.getString("legalMan")); // ��������������
				corp.setIdCardTypeNum(rs.getString("idCardTypeNum"));// ����������֤������(�ֵ��TBIDCARDTYPEDIC)
				corp.setLegalManIdCard(rs.getString("legalManIdCard"));// ����������֤������
				corp.setLegalManDuty(rs.getString("legalManDuty"));// ����������ְ��
				corp.setLegaManProtitle(rs.getString("legaManProtitle"));// ����������ְ��
				corp.setEconomicName(rs.getString("economicName")); // ��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
				corp.setEconomicNum(rs.getString("economicNum"));
				corp.setRegPrin(rs.getString("regPrin")); // ע���ʱ�(��Ԫ)
				corp.setFactRegPrin(rs.getString("factRegPrin")); // ʵ���ʱ�(��Ԫ)
				corp.setPrincipalUnitName(rs.getString("principalUnitName"));// ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
				corp.setPrincipalUnitNum(rs.getString("principalUnitNum"));
				corp.setCorpBirthDate(rs.getDate("corpBirthDate"));// ��������
				corp.setOfficePhone(rs.getString("officePhone"));// �칫�绰
				corp.setFax(rs.getString("fax")); // �������
				corp.setLinkMan(rs.getString("linkMan")); // ��ϵ������
				corp.setLinkTel(rs.getString("linkTel")); // ��ϵ�˰칫�绰
				corp.setLinkPhone(rs.getString("linkPhone")); // ��ϵ���ֻ�����
				corp.setEmail(rs.getString("email")); // ��ϵ����
				corp.setUrl(rs.getString("url")); // ��ҵ��ַ
				corp.setDescription(rs.getString("description")); // ��ע
				corp.setEconomicNum(rs.getString("economicNum"));
				corp.setSpare1(rs.getString("spare1"));// ��ҵ������
				corp.setAssets(rs.getString("ASSETS"));
				corp.setMachinery(rs.getString("MACHINERY"));
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
	 * �ύ�������
	 */
	@Override
	public String approvalUpdate(ChangeArea change , int mark) {
		// TODO Auto-generated method stub
		String sql = "insert into TB_CHANGEAREA(CHANGEID,CORPNAME,BEFOREAREA,AFTERPROVINCEAREA,AFTERCITYAREA,STATUS,PROCESS,MARK) values (?,?,?,?,?,?,?,?)";
		int check = 0;
		String message = "";
		String changeId = UUID.randomUUID().toString();
		String cityNum = "";
		if (change.getStatus().equals("2")) {
			cityNum = change.getAfterProvinceCityArea();
		}
		if (change.getStatus().equals("1")) {
			cityNum = change.getAfterCityArea();
			change.setAfterProvinceArea("");
		}
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, changeId); // ����
			pstmt.setString(2, change.getCorpName());// ��ҵ����
			pstmt.setString(3, change.getBeforeArea());// ԭ������
			pstmt.setString(4, change.getAfterProvinceArea());// ��Ҫ����Ĺ���������ʡ
			pstmt.setString(5, cityNum);// ��Ҫ����Ĺ�����������
			pstmt.setString(6, change.getStatus());// ��ȡ�������Ƿ�Ϊ��ʡ
			pstmt.setString(7, "1");// �����������Ϊ��ҵ�ύ.
			pstmt.setString(8, Integer.toString(mark));// �����Ƿ���Ҫʡ������.
			check = pstmt.executeUpdate();
			if (check == 1) {
				message = "�ύ�ɹ�,�뵽���������ˣ�";
			} else {
				message = "�ύʧ�ܣ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * ��ѯʡ
	 */
	@Override
	public List<DictionaryClass> queryProvince() {
		// TODO Auto-generated method stub
		String sql = "select * from TBXZQDMDIC where code like '%0000' and code !='230000'";
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
	 * ��ѯ�Ƿ���Ҫ��������
	 */
	@Override
	public String queryMark(String corpName) {
		// TODO Auto-generated method stub
		String message = "";
		int count = 0;
		String sql = "select * from TBCORPCERTDETAILINFO where corpName = '"
				+ corpName + "' ";
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count++;
				if (rs.getString("APPROVALDEPT").length() == 2) {
					message = "ʡ������";
				}
			}
			if (count != 0) {
				if (message.equals("ʡ������")) {
					message = "ʡ��";
				}
			}else if(count == 0){
				message = "������";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return message;
	}

}

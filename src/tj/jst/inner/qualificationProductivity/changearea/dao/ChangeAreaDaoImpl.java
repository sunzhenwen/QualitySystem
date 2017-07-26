package com.tj.jst.inner.qualificationProductivity.changearea.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.qualificationProductivity.changearea.model.ChangeArea;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * �������������ر��Dao��
 * 
 * @author DarkFlameMaster
 *
 */
public class ChangeAreaDaoImpl extends BaseDao implements IChangeAreaDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					ChangeArea change = new ChangeArea();
					change.setAfterCityArea(rs.getString("afterCityArea"));
					change.setChangeId(rs.getString("changeId"));
					change.setCorpName(rs.getString("corpName"));
					change.setBeforeArea(rs.getString("beforeArea"));
					change.setAfterProvinceArea(rs
							.getString("afterProvinceArea"));
					change.setBeforeOp(rs.getString("beforeOp"));
					change.setAfterOp(rs.getString("afterOp"));
					change.setLastOp(rs.getString("lastOp"));
					change.setStatus(rs.getString("status"));
					change.setProcess(rs.getString("process"));
					change.setMark(rs.getString("mark"));
					change.setBeforeDate(rs.getDate("beforeDate"));
					change.setAfterDate(rs.getDate("afterDate"));
					change.setLastDate(rs.getDate("lastDate"));
					page.getData().add(change);
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
	 * ����ͨ��
	 */
	@Override
	public String approvalSuccess(ChangeArea change) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "";
		String opinion = "";
		Date date = new Date(new java.util.Date().getTime());
		if (change.getBeforeOp() != null) {
			sql = "update TB_CHANGEAREA set PROCESS = 2 , BEFOREOP = ? , BEFOREDATE = ? where CHANGEID = ?";
			opinion = change.getBeforeOp();
		}
		if (change.getAfterOp() != null) {
			if (change.getMark().equals("0")) {
				sql = "update TB_CHANGEAREA set PROCESS = 6 , AFTEROP = ? , LASTOP='ͨ����' , LASTDATE = ?  where CHANGEID = ?";
			} else {
				sql = "update TB_CHANGEAREA set PROCESS = 4 , AFTEROP = ? , AFTERDATE = ?  where CHANGEID = ?";
			}
			opinion = change.getAfterOp();
		}
		if (change.getLastOp() != null) {
			sql = "update TB_CHANGEAREA set PROCESS = 6 , LASTOP = ? , LASTDATE = ?  where CHANGEID = ?";
			opinion = change.getLastOp();
		}
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, opinion);
			pstmt.setDate(2, date);
			pstmt.setString(3, change.getChangeId());
			int check = pstmt.executeUpdate();
			if (check == 1) {
				message = "�����ɹ���";
			} else {
				message = "����ʧ�ܣ�";
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
	 * ������ͨ��
	 */
	@Override
	public String approvalFailed(ChangeArea change) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "";
		String opinion = "";
		Date date = new Date(new java.util.Date().getTime());
		if (change.getBeforeOp() != null) {
			sql = "update TB_CHANGEAREA set PROCESS = 3 , BEFOREOP = ? , BEFOREDATE = ? where CHANGEID = ?";
			opinion = change.getBeforeOp();
		}
		if (change.getAfterOp() != null) {
			if (change.getMark().equals("0")) {
				sql = "update TB_CHANGEAREA set PROCESS = 7 , AFTEROP = ? , LASTOP = '��ͨ����' , LASTDATE = ? where CHANGEID = ?";
			} else {
				sql = "update TB_CHANGEAREA set PROCESS = 5 , AFTEROP = ? , AFTERDATE = ? where CHANGEID = ?";
			}
			opinion = change.getAfterOp();
		}
		if (change.getLastOp() != null) {
			sql = "update TB_CHANGEAREA set PROCESS = 7 , LASTOP = ? , LASTDATE = ? where CHANGEID = ?";
			opinion = change.getLastOp();
		}
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, opinion);
			pstmt.setDate(2, date);
			pstmt.setString(3, change.getChangeId());
			int check = pstmt.executeUpdate();
			if (check == 1) {
				message = "�����ɹ���";
			} else {
				message = "����ʧ�ܣ�";
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
	 * ��ѯ��ʡ�����������
	 */
	@Override
	public String queryCityName(String cityNum) {
		// TODO Auto-generated method stub
		String result = "";
		String sql = "select * from TBXZQDMDIC where code = '" + cityNum + "'";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return result;
	}

	/**
	 * ����ͨ������֤����
	 */
	@Override
	public String changeCertificateCode(ChangeArea change) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ��ת����ҳ��
	 */
	@Override
	public ChangeArea queryById(String changeId) {
		// TODO Auto-generated method stub
		ChangeArea change = new ChangeArea();
		String sql = "select * from TB_CHANGEAREA where changeId = '"
				+ changeId + "'";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				change.setAfterCityArea(rs.getString("afterCityArea"));
				change.setChangeId(rs.getString("changeId"));
				change.setCorpName(rs.getString("corpName"));
				change.setBeforeArea(rs.getString("beforeArea"));
				change.setAfterProvinceArea(rs.getString("afterProvinceArea"));
				change.setBeforeOp(rs.getString("beforeOp"));
				change.setAfterOp(rs.getString("afterOp"));
				change.setLastOp(rs.getString("lastOp"));
				change.setStatus(rs.getString("status"));
				change.setProcess(rs.getString("process"));
				change.setMark(rs.getString("mark"));
				change.setBeforeDate(rs.getDate("beforeDate"));
				change.setAfterDate(rs.getDate("afterDate"));
				change.setLastDate(rs.getDate("lastDate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return change;
	}

	/**
	 * ������ҵ ������
	 */
	@Override
	public Corp queryCorp(String corpName) {
		// TODO Auto-generated method stub
		Corp corp = new Corp();
		String sql = "select * from TBCORPBASICINFO where corpName = ?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpName);
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

	@Override
	public String changeCorpArea(Corp corp, String cityNum) {
		// TODO Auto-generated method stub
		String message = "";
		String corpId = corp.getCorpId().trim();
		String city = cityNum.trim();
		String sql = "update TBCORPBASICINFO set SPARE1 = '" + city
				+ "' where corpId = '" + corpId + "'";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			int check = pstmt.executeUpdate();
			if (check == 1) {
				message = "���ĳɹ���";
			} else {
				message = "����ʧ�ܣ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		if (message.equals("���ĳɹ���")) {
			try {
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				int check = pstmt.executeUpdate();
				if (check == 1) {
					message = "���ĳɹ���";
				} else {
					message = "����ʧ�ܣ�";
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
}

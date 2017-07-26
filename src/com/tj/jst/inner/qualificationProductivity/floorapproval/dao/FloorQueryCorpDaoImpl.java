package com.tj.jst.inner.qualificationProductivity.floorapproval.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.notforeigninfo.model.CorpInfo;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * ������ѯ��ҵ��Ϣ���ݿ���
 * 
 * @author Administrator
 *
 */
public class FloorQueryCorpDaoImpl extends BaseDao implements
		IFloorQueryCorpDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ��ҳ��
	 */
	@Override
	public Page queryPage(Condition condition) {
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
	 * ��ѯ��ϸ
	 */
	@Override
	public Corp queryInfo(String corpCode) {
		// TODO Auto-generated method stub
		String sql = "select * from V_CORPBASICINFO where corpCode = '"
				+ corpCode + "'";
		Corp corp = new Corp();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				corp.setCorpName(rs.getString("corpName"));// ��ҵ����
				corp.setCorpCode(rs.getString("corpCode"));// ��ҵ��֯��������֤
				corp.setCityNum(rs.getString("cityName"));// ��ҵ������
				corp.setCountyNum(rs.getString("countyName"));// ��ҵ������
				corp.setAddress(rs.getString("address"));// ��ϸ��ַ
				corp.setEconomicNum(rs.getString("economicName"));// ��������
				corp.setRegPrin(rs.getString("regPrin"));// ע���ʱ���
				corp.setLicenseNum(rs.getString("licenseNum"));// Ӫҵִ��ע���
				corp.setCorpBirthDate(rs.getDate("corpBirthDate"));// ��˾��������
				corp.setLegalMan(rs.getString("legalMan"));// ����������
				corp.setOfficePhone(rs.getString("officephone"));// ���������˵绰
				corp.setLinkMan(rs.getString("linkMan"));// ��ϵ��
				corp.setLinkPhone(rs.getString("linkPhone"));// ��ϵ�˵绰
				corp.setPostalCode(rs.getString("postalCode"));//�ʱ�
				corp.setLinkTel(rs.getString("linkTel"));//��ϵ�˵绰
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

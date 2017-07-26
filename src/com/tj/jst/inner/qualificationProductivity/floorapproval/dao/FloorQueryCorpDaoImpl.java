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
 * 大厅查询企业信息数据库类
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
	 * 分页类
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
					corp.setCorpId(rs.getString("corpId")); // 企业Id
					corp.setCorpName(rs.getString("corpName")); // 企业名称
					corp.setCorpCode(rs.getString("corpCode")); // 企业组织机构代码证
					corp.setLicenseNum(rs.getString("licenseNum")); // 工商营业执照注册号
					corp.setOfficePhone(rs.getString("officePhone")); // 办公电话
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
	 * 查询详细
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
				corp.setCorpName(rs.getString("corpName"));// 企业名称
				corp.setCorpCode(rs.getString("corpCode"));// 企业组织机构代码证
				corp.setCityNum(rs.getString("cityName"));// 企业所在市
				corp.setCountyNum(rs.getString("countyName"));// 企业所在区
				corp.setAddress(rs.getString("address"));// 详细地址
				corp.setEconomicNum(rs.getString("economicName"));// 经济性质
				corp.setRegPrin(rs.getString("regPrin"));// 注册资本金
				corp.setLicenseNum(rs.getString("licenseNum"));// 营业执照注册号
				corp.setCorpBirthDate(rs.getDate("corpBirthDate"));// 公司成立日期
				corp.setLegalMan(rs.getString("legalMan"));// 法定代表人
				corp.setOfficePhone(rs.getString("officephone"));// 法定代表人电话
				corp.setLinkMan(rs.getString("linkMan"));// 联系人
				corp.setLinkPhone(rs.getString("linkPhone"));// 联系人电话
				corp.setPostalCode(rs.getString("postalCode"));//邮编
				corp.setLinkTel(rs.getString("linkTel"));//联系人电话
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

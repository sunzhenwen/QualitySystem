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
 * 内网审批归属地变更Dao类
 * 
 * @author DarkFlameMaster
 *
 */
public class ChangeAreaDaoImpl extends BaseDao implements IChangeAreaDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 分页查询
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
	 * 审批通过
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
				sql = "update TB_CHANGEAREA set PROCESS = 6 , AFTEROP = ? , LASTOP='通过！' , LASTDATE = ?  where CHANGEID = ?";
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
				message = "审批成功！";
			} else {
				message = "审批失败！";
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
	 * 审批不通过
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
				sql = "update TB_CHANGEAREA set PROCESS = 7 , AFTEROP = ? , LASTOP = '不通过！' , LASTDATE = ? where CHANGEID = ?";
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
				message = "审批成功！";
			} else {
				message = "审批失败！";
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
	 * 查询跨省变更所在名称
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
	 * 审批通过更改证书编号
	 */
	@Override
	public String changeCertificateCode(ChangeArea change) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 跳转审批页面
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
	 * 更改企业 归属地
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
				corp.setCorpId(rs.getString("corpId")); // 企业Id
				corp.setCorpName(rs.getString("corpName")); // 企业名称
				corp.setCorpCode(rs.getString("corpCode")); // 组织机构代码证
				corp.setLicenseNum(rs.getString("licenseNum")); // 工商营业执照注册号
				corp.setProvinceNum(rs.getString("provinceNum")); // 注册所在省
				corp.setCityNum(rs.getString("cityNum")); // 注册所在地
				corp.setCountyNum(rs.getString("countyNum")); // 注册所在市
				corp.setAddress(rs.getString("address")); // 企业营业地址
				corp.setPostalCode(rs.getString("postalCode")); // 邮政编码
				corp.setLegalMan(rs.getString("legalMan")); // 法定代表人姓名
				corp.setIdCardTypeNum(rs.getString("idcardTypeNum")); // 法定代表人证件类型
				corp.setLegalManIdCard(rs.getString("legalManIdCard")); // 发行代表人证件号码
				corp.setLegalManDuty(rs.getString("legalManDuty")); // 法定代表人职务
				corp.setLegaManProtitle(rs.getString("legaManProtitle")); // 法定代表人职称
				corp.setEconomicNum(rs.getString("economicNum")); // 企业登记注册类型
				corp.setRegPrin(rs.getString("regPrin")); // 注册资本（万元）
				corp.setFactRegPrin(rs.getString("factRegPrin")); // 实收资本（万元）
				corp.setPrincipalUnitNum(rs.getString("principalUnitNum")); // 注册资本币种
				corp.setCorpBirthDate(rs.getDate("corpBirthDate")); // 成立日期
				corp.setOfficePhone(rs.getString("officePhone")); // 办公电话
				corp.setFax(rs.getString("fax")); // 传真号码
				corp.setLinkMan(rs.getString("linkMan")); // 联系人姓名
				corp.setLinkTel(rs.getString("linkTel")); // 联系人办公电话
				corp.setLinkPhone(rs.getString("linkPhone")); // 联系人手机号码
				corp.setEmail(rs.getString("email")); // 联系邮箱
				corp.setUrl(rs.getString("Url")); // 企业网址
				corp.setDescription(rs.getString("description")); // 备注
				corp.setAssets(rs.getString("assets")); // 净资产
				corp.setMachinery(rs.getString("machinery")); // 机械设备
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
				message = "更改成功！";
			} else {
				message = "更改失败！";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		if (message.equals("更改成功！")) {
			try {
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				int check = pstmt.executeUpdate();
				if (check == 1) {
					message = "更改成功！";
				} else {
					message = "更改失败！";
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

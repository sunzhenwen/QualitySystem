package com.tj.jst.inner.qualificationProductivity.queryCorp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * 查询企业所申报的资质信息数据库类
 * 
 * @author Administrator
 *
 */
public class QueryCorpApplyDaoImpl extends BaseDao implements
		IQueryCorpApplyDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 分页方法
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.qualityPagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					NewQualification certifiedService = new NewQualification();
					// 主键
					certifiedService.setNewQualId(rs.getString("newQualId"));
					// 企业主键
					certifiedService.setCorpId(rs.getString("corpId"));
					// 企业名称
					certifiedService.setCorpName(rs.getString("corpName"));
					// 企业住址机构代码证
					certifiedService.setCorpCode(rs.getString("corpCode"));
					// 企业所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
					certifiedService
							.setProvinceNum(rs.getString("provinceNum"));
					// 企业所在省名称
					certifiedService.setProvinceName(rs
							.getString("provinceName"));
					// 企业所在地(市、州、盟)(字典表：TBXZQDMDIC)
					certifiedService.setCityNum(rs.getString("cityNum"));
					// 企业所在市名称
					certifiedService.setCityName(rs.getString("cityName"));
					// 企业所在区(区、市、旗)(字典表：TBXZQDMDIC)
					certifiedService.setCountyNum(rs.getString("countyNum"));
					// 企业所在区名称
					certifiedService.setCountyName(rs.getString("countyName"));
					// 申请状态(1：已申请)
					certifiedService.setQualifType(rs.getString("qualifType"));
					// 服务事项主键
					certifiedService.setCertId(rs.getString("certId"));
					// 服务事项名称
					certifiedService.setCertName(rs.getString("certName"));
					// 资质级别
					certifiedService.setCretGrade(rs.getString("cretGrade"));
					// 资质级别名称
					certifiedService.setCretGradeName(rs
							.getString("cretGradeName"));
					// 资质等级
					certifiedService.setCretLevel(rs.getInt("cretLevel"));
					// 资质等级名称
					certifiedService.setCretLevelName(rs
							.getString("cretLevelName"));
					// 资质序列
					certifiedService.setCretSequence(rs.getInt("cretSequence"));
					// 资质序列名称
					certifiedService.setCretSequenceName(rs
							.getString("cretSequenceName"));
					// 资质类型
					certifiedService.setCretType(rs.getInt("cretType"));
					// 资质类型名称
					certifiedService.setCretTypeName(rs
							.getString("cretTypeName"));
					// 资质专业类别
					certifiedService.setSpecialtyType(rs
							.getInt("specialtyType"));
					// 资质专业类别名称
					certifiedService.setSpecialtyTypeName(rs
							.getString("specialtyTypeName"));
					// 审批部门
					certifiedService.setApprovalDept(rs
							.getString("approvalDept"));
					// 审批部门名称
					certifiedService.setApprovalDeptName(rs
							.getString("approvalDeptName"));
					// 二级审批初审部门
					certifiedService.setTwoApprovalDept(rs
							.getString("twoApprovalDept"));
					// 二级审批初审部门名称
					certifiedService.setTwoApprovalDeptName(rs
							.getString("twoApprovalDeptName"));
					// 申请日期
					certifiedService.setCreatDate(rs.getDate("CREATDATE"));
					// 资质取得方式方式
					certifiedService.setAddTypeNum(rs.getString("addTypeNum"));
					// 资质取得方式名称
					certifiedService
							.setAddTypeName(rs.getString("addTypeName"));
					certifiedService.setAssets(rs.getString("assets"));
					certifiedService.setMachinery(rs.getString("machinery"));
					page.getData().add(certifiedService);
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

}

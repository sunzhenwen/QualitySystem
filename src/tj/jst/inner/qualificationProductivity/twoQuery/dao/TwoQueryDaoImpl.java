package com.tj.jst.inner.qualificationProductivity.twoQuery.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * 初审审批历史记录查询
 * @author DarkFlameMaster
 *
 */
public class TwoQueryDaoImpl extends BaseDao implements ITwoQueryDao{

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**
	 * 分页查询
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.qualityPagedQuery(condition);
		ResultSet rs = page.getRs();
		try{
			if(rs!=null){
				while(rs.next()){
					NewQualification certifiedService = new NewQualification();
					//主键
					certifiedService.setNewQualId(rs.getString("newQualId"));
					//企业主键
					certifiedService.setCorpId(rs.getString("corpId"));
					//企业名称
					certifiedService.setCorpName(rs.getString("corpName"));
					//企业住址机构代码证
					certifiedService.setCorpCode(rs.getString("corpCode"));
					//企业所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
					certifiedService.setProvinceNum(rs.getString("provinceNum"));
					//企业所在省名称
					certifiedService.setProvinceName(rs.getString("provinceName"));
					//企业所在地(市、州、盟)(字典表：TBXZQDMDIC)
					certifiedService.setCityNum(rs.getString("cityNum"));
					//企业所在市名称
					certifiedService.setCityName(rs.getString("cityName"));
					//企业所在区(区、市、旗)(字典表：TBXZQDMDIC)
					certifiedService.setCountyNum(rs.getString("countyNum"));
					//企业所在区名称
					certifiedService.setCountyName(rs.getString("countyName"));
					//申请状态(1：已申请)
					certifiedService.setQualifType(rs.getString("qualifType"));
					//服务事项主键
					certifiedService.setCertId(rs.getString("certId"));
					//服务事项名称
					certifiedService.setCertName(rs.getString("certName"));
					//资质级别
					certifiedService.setCretGrade(rs.getString("cretGrade"));
					//资质级别名称
					certifiedService.setCretGradeName(rs.getString("cretGradeName"));
					//资质等级
					certifiedService.setCretLevel(rs.getInt("cretLevel"));
					//资质等级名称
					certifiedService.setCretLevelName(rs.getString("cretLevelName"));
					//资质序列
					certifiedService.setCretSequence(rs.getInt("cretSequence"));
					//资质序列名称
					certifiedService.setCretSequenceName(rs.getString("cretSequenceName"));
					//资质类型
					certifiedService.setCretType(rs.getInt("cretType"));
					//资质类型名称
					certifiedService.setCretTypeName(rs.getString("cretTypeName"));
					//资质专业类别
					certifiedService.setSpecialtyType(rs.getInt("specialtyType"));
					//资质专业类别名称
					certifiedService.setSpecialtyTypeName(rs.getString("specialtyTypeName"));
					//审批部门
					certifiedService.setApprovalDept(rs.getString("approvalDept"));
					//审批部门名称
					certifiedService.setApprovalDeptName(rs.getString("approvalDeptName"));
					//二级审批初审部门
					certifiedService.setTwoApprovalDept(rs.getString("twoApprovalDept"));
					//二级审批初审部门名称
					certifiedService.setTwoApprovalDeptName(rs.getString("twoApprovalDeptName"));
					//申请日期
					certifiedService.setCreatDate(rs.getDate("CREATDATE"));
					//资质取得方式方式
					certifiedService.setAddTypeNum(rs.getString("addTypeNum"));
					//资质取得方式名称
					certifiedService.setAddTypeName(rs.getString("addTypeName"));
					//终审审批结果	5:通过 6:不通过
					if(rs.getString("ULTIMATERESULTS") != null){
						if(rs.getString("ULTIMATERESULTS").equals("5")){
							certifiedService.setUltimateResults("终审通过");
						}else if(rs.getString("ULTIMATERESULTS").equals("6")){
							certifiedService.setUltimateResults("终审未通过");
						}
					}
					//初审审批结果	3:通过 4:不通过
					if(rs.getString("ONERESULTS") != null){
						if(rs.getString("ONERESULTS").equals("3")){
							certifiedService.setOneResults("初审通过");
						}else if(rs.getString("ONERESULTS").equals("4")){
							certifiedService.setOneResults("初审未通过");
						}
					}
					page.getData().add(certifiedService);
				}
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}

	/**
	 * 审批记录详细页面
	 */
	@Override
	public NewQualification queryapproval(String newQualId) {
		// TODO Auto-generated method stub
		NewQualification certifiedService = new NewQualification();
		try {
			String sql = "select * from V_QUALIFICATIONAPPLY where newQualId='"+newQualId+"'";
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				//主键
				certifiedService.setNewQualId(rs.getString("newQualId").trim());
				//企业主键
				certifiedService.setCorpId(rs.getString("corpId").trim());
				//企业名称
				certifiedService.setCorpName(rs.getString("corpName").trim());
				//企业住址机构代码证
				certifiedService.setCorpCode(rs.getString("corpCode").trim());
				//企业所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
				certifiedService.setProvinceNum(rs.getString("provinceNum").trim());
				//企业所在省名称
				certifiedService.setProvinceName(rs.getString("provinceName").trim());
				//企业所在地(市、州、盟)(字典表：TBXZQDMDIC)
				certifiedService.setCityNum(rs.getString("cityNum").trim());
				//企业所在市名称
				certifiedService.setCityName(rs.getString("cityName").trim());
				//企业所在区(区、市、旗)(字典表：TBXZQDMDIC)
				certifiedService.setCountyNum(rs.getString("countyNum").trim());
				//企业所在区名称
				certifiedService.setCountyName(rs.getString("countyName").trim());
				//申请状态(1：已申请)
				certifiedService.setQualifType(rs.getString("qualifType").trim());
				//服务事项主键
				certifiedService.setCertId(rs.getString("certId").trim());
				//服务事项名称
				certifiedService.setCertName(rs.getString("certName").trim());
				//资质级别
				certifiedService.setCretGrade(rs.getString("cretGrade").trim());
				//资质级别名称
				certifiedService.setCretGradeName(rs.getString("cretGradeName").trim());
				//资质等级
				certifiedService.setCretLevel(rs.getInt("cretLevel"));
				//资质等级名称
				certifiedService.setCretLevelName(rs.getString("cretLevelName").trim());
				//资质序列
				certifiedService.setCretSequence(rs.getInt("cretSequence"));
				//资质序列名称
				certifiedService.setCretSequenceName(rs.getString("cretSequenceName").trim());
				//资质类型
				certifiedService.setCretType(rs.getInt("cretType"));
				//资质类型名称
				certifiedService.setCretTypeName(rs.getString("cretTypeName").trim());
				//资质专业类别
				certifiedService.setSpecialtyType(rs.getInt("specialtyType"));
				//资质专业类别名称
				certifiedService.setSpecialtyTypeName(rs.getString("specialtyTypeName").trim());
				//申请日期
				certifiedService.setCreatDate(rs.getDate("CREATDATE"));
				//资质资格取得方式
				certifiedService.setAddTypeNum(rs.getString("addTypeNum").trim());
				//资质资格取得方式名称
				certifiedService.setAddTypeName(rs.getString("addTypeName").trim());
				//审批部门
				certifiedService.setApprovalDept(rs.getString("approvalDept").trim());
				//审批部门名称
				certifiedService.setApprovalDeptName(rs.getString("approvalDeptName").trim());
				//二级审批初审部门
				certifiedService.setTwoApprovalDept(rs.getString("twoApprovalDept").trim());
				//二级审批初审部门名称
				certifiedService.setTwoApprovalDeptName(rs.getString("twoApprovalDeptName").trim());
				//初审审批意见
				certifiedService.setOneUltimateOpinion(rs.getString("ONEULTIMATEOPINION"));
				//初审审批时间
				certifiedService.setOneAppDate(rs.getDate("oneAppDate"));
				//初审审批人员
				certifiedService.setTwoApprovalStaff(rs.getString("twoApprovalStaff"));
				//终审审批人员
				certifiedService.setApprovalStaff(rs.getString("approvalStaff"));
				//终审审批意见
				certifiedService.setUltimateOpinion(rs.getString("UltimateOpinion"));
				//终审审批结果	5:通过 6:不通过
				if(rs.getString("ULTIMATERESULTS") != null){
					if(rs.getString("ULTIMATERESULTS").equals("5")){
						certifiedService.setUltimateResults("终审通过");
						
					}else if(rs.getString("ULTIMATERESULTS").equals("6")){
						certifiedService.setUltimateResults("终审未通过");
					}
				}
				//初审审批结果	3:通过 4:不通过
				if(rs.getString("ONERESULTS") != null){
					if(rs.getString("ONERESULTS").equals("3")){
						certifiedService.setOneResults("初审通过");
					}else if(rs.getString("ONERESULTS").equals("4")){
						certifiedService.setOneResults("初审未通过");
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return certifiedService;
	}

	/**
	 * 资质等级字典表
	 */
	@Override
	public List<DictionaryClass> queryCretLevels() {
		// TODO Auto-generated method stub
		String sql = "select * from TBCERTTITLELEVELDIC where QUALIFICATIONSTYPE='建筑业'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("RATING").trim());
				dictionaryClass.setCode(rs.getString("code").trim());
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

	/**
	 * 申请类型字典表
	 */
	@Override
	public List<DictionaryClass> queryAddTypeNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBADDTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("GETMETHODNAME").trim());
				dictionaryClass.setCode(rs.getString("code").trim());
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

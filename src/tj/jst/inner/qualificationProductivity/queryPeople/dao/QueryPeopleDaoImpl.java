package com.tj.jst.inner.qualificationProductivity.queryPeople.dao;

import java.sql.Connection;
import java.sql.Date;
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
import com.tj.jst.inner.qualificationProductivity.floorapproval.model.FloorApproval;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;
import com.tj.jst.outside.staffmanage.positions.model.Positions;
import com.tj.jst.outside.staffmanage.skilledworker.model.Skilledworker;
import com.tj.jst.outside.staffmanage.title.model.Title;

/**
 * 大厅审批数据库类
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryPeopleDaoImpl extends BaseDao implements IQueryPeopleDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public Constructor queryConstructor(String idCard) {
		// TODO Auto-generated method stub
		String sql = "select t.*,"
				+ "(select a.papertype from TBIDCARDTYPEDIC a where a.code=t.idcardtypenum) as idCardTypeName,"
				+ "(select b.typelevel from TBSPECIALTYTYPEDIC b where b.code=t.specialtytypnum) as sepecialtyTypName,"
				+ "(select c.type from TBCALLINGTYPEDIC c where c.code=t.callingtypenum) as callingTypeName,"
				+ "(select d.discipline from TBREGTRADETYPEDIC d where d.code=t.regtradetypenum) as regTradeTypeName,"
				+ "(select e.status from TBQSTATEDIC e where e.code=t.qstate) as qStateName "
				+ "from TBREGPERSONREGINFO t where t.idCard18=? ";
		Constructor constructor = new Constructor();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idCard);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				constructor.setPersonId(rs.getString("personId"));
				constructor.setPersonName(rs.getString("personName"));
				constructor.setIdCardTypeName(rs.getString("idCardTypeName"));
				constructor.setIdCard(rs.getString("idCard18"));
				constructor.setSepecialtyTypName(rs
						.getString("sepecialtyTypName"));
				constructor.setCertNum(rs.getString("certNum"));
				constructor.setAwardDate(rs.getDate("awardDate"));
				constructor.setAwardDepart(rs.getString("awardDepart"));
				constructor.setStampNum(rs.getString("stampNum"));
				constructor.setEffectDate(rs.getDate("effectDate"));
				constructor.setCallingTypeName(rs.getString("callingTypeName"));
				constructor.setCorpName(rs.getString("corpName"));
				constructor.setCorpCode(rs.getString("corpCode"));
				constructor.setCertId(rs.getString("certId"));
				constructor.setRegTradeTypeName(rs
						.getString("regTradeTypeName"));
				constructor.setTradeTypeAwardDate(rs
						.getDate("tradeTypeAwardDate"));
				constructor.setTradeTypeEffectDate(rs
						.getDate("tradeTypeEffectDate"));
				constructor.setStateName(rs.getString("qStateName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return constructor;
	}
	@Override
	public Positions queryPositions(String idCard) {
		// TODO Auto-generated method stub
		String sql = "select row_number() over(order by FRegDate desc) as rownumber,fPersonID, FName, FCardID, FSex, FEntName, FDuty , FCertNumber FROM Position_Certificate" +
				" where FIsDeleted = 0 and fduty  in ('施工员','质量员','安全员','标准员','材料员','机械员','劳务员','资料员') and fcardID = ? " ;
		Positions constructor = new Positions();
		try {
			conn = ConnectionFactory.getStaffPositionsConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idCard);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				constructor.setPersonId(rs.getString("fPersonID"));
				constructor.setName(rs.getString("fName"));//姓名
				constructor.setCardId(rs.getString("fCardId"));//身份证
				constructor.setSex(rs.getString("fSex"));//性别
				constructor.setEntName(rs.getString("fEntName"));//公司名称
				constructor.setDuty(rs.getString("fDuty"));//岗位名称
				constructor.setFCertNumber(rs.getString("fCertNumber"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return constructor;
	}
	@Override
	public Skilledworker querySkilledworker(String idCard) {
		// TODO Auto-generated method stub
		String sql = "select * from V_SKILLEDWORKER where identitycard = ?" ;
		Skilledworker skilledworder = new Skilledworker();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idCard);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				skilledworder.setPersonId(rs.getString("personId")); // 主键
				skilledworder.setPersonName(rs.getString("personName")); // 人名
				skilledworder.setSexName(rs.getString("sexName")); // 性别(字典表：TBSEXDIC)
				skilledworder.setIdentityCard(rs.getString("identityCard")); // 身份证（必须18位）
				skilledworder.setIdCardTypeName(rs.getString("idCardTypeName"));
				skilledworder.setSkilledType(rs.getString("typeName")); // 技术人员种类（字典表：TBSKILLEDWORkERTYPE）
				skilledworder.setSkilledLevel(rs.getString("levelName")); // 技术人员级别（字典表：TBSKILLEDWORKERLEVEL）
				skilledworder.setMobile(rs.getString("mobile")); // 手机号
				skilledworder.setNationAlityName(rs.getString("papertypename"));
				skilledworder.setEduLevelName(rs.getString("edulevelname"));
				skilledworder.setDegreeName(rs.getString("degreename"));
				skilledworder.setBirthday(rs.getDate("birthday"));
				skilledworder.setCorpName(rs.getString("corpname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return skilledworder;
	}
	@Override
	public Title queryTitle(String idCard) {
		// TODO Auto-generated method stub
		String sql = "select * from v_persontitleinfo where idcard = ?" ;
		Title title = new Title();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idCard);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				title.setPersonId(rs.getString("personid")); // 主键
				title.setPersonName(rs.getString("personName")); // 人名
				title.setSexName(rs.getString("sexName")); // 性别(字典表：TBSEXDIC)
				title.setIdCardTypeName(rs.getString("idCardTypeName")); // 证件类型(字典表：TBIDCARDTYPEDIC)
				title.setIdCard(rs.getString("idCard")); // 身份证号(必须为18位)
				title.setMobile(rs.getString("mobile")); // 手机号码
				title.setTitleName(rs.getString("titleName")); // 职称
				title.setTitleMajor(rs.getString("titleMajor")); // 职称专业
				title.setTitleLevel(rs.getString("titleLevel")); // 职称等级
				title.setGraduatedSchool(rs.getString("graduatedSchool")); // 毕业学校
				title.setGraduatedDate(rs.getDate("graduatedDate")); // 毕业时间
				title.setStudyMajor(rs.getString("studyMajor")); // 所学专业
				title.setCorpName(rs.getString("corpname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return title;
	}

	
}

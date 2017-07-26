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
 * �����������ݿ���
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
				" where FIsDeleted = 0 and fduty  in ('ʩ��Ա','����Ա','��ȫԱ','��׼Ա','����Ա','��еԱ','����Ա','����Ա') and fcardID = ? " ;
		Positions constructor = new Positions();
		try {
			conn = ConnectionFactory.getStaffPositionsConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idCard);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				constructor.setPersonId(rs.getString("fPersonID"));
				constructor.setName(rs.getString("fName"));//����
				constructor.setCardId(rs.getString("fCardId"));//���֤
				constructor.setSex(rs.getString("fSex"));//�Ա�
				constructor.setEntName(rs.getString("fEntName"));//��˾����
				constructor.setDuty(rs.getString("fDuty"));//��λ����
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
				skilledworder.setPersonId(rs.getString("personId")); // ����
				skilledworder.setPersonName(rs.getString("personName")); // ����
				skilledworder.setSexName(rs.getString("sexName")); // �Ա�(�ֵ��TBSEXDIC)
				skilledworder.setIdentityCard(rs.getString("identityCard")); // ���֤������18λ��
				skilledworder.setIdCardTypeName(rs.getString("idCardTypeName"));
				skilledworder.setSkilledType(rs.getString("typeName")); // ������Ա���ࣨ�ֵ��TBSKILLEDWORkERTYPE��
				skilledworder.setSkilledLevel(rs.getString("levelName")); // ������Ա�����ֵ��TBSKILLEDWORKERLEVEL��
				skilledworder.setMobile(rs.getString("mobile")); // �ֻ���
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
				title.setPersonId(rs.getString("personid")); // ����
				title.setPersonName(rs.getString("personName")); // ����
				title.setSexName(rs.getString("sexName")); // �Ա�(�ֵ��TBSEXDIC)
				title.setIdCardTypeName(rs.getString("idCardTypeName")); // ֤������(�ֵ��TBIDCARDTYPEDIC)
				title.setIdCard(rs.getString("idCard")); // ���֤��(����Ϊ18λ)
				title.setMobile(rs.getString("mobile")); // �ֻ�����
				title.setTitleName(rs.getString("titleName")); // ְ��
				title.setTitleMajor(rs.getString("titleMajor")); // ְ��רҵ
				title.setTitleLevel(rs.getString("titleLevel")); // ְ�Ƶȼ�
				title.setGraduatedSchool(rs.getString("graduatedSchool")); // ��ҵѧУ
				title.setGraduatedDate(rs.getDate("graduatedDate")); // ��ҵʱ��
				title.setStudyMajor(rs.getString("studyMajor")); // ��ѧרҵ
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

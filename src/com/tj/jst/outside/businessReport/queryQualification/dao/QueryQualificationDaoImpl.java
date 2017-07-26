package com.tj.jst.outside.businessReport.queryQualification.dao;

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
import com.tj.jst.outside.businessReport.queryQualification.model.Qualification;

/**
 * 企业拥有资质查询
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryQualificationDaoImpl extends BaseDao implements
		IQueryQualificationDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 资质服务事项查询
	 * 
	 * @return
	 * @throws Exception
	 */
	@Override
	public Page queryCertifiedService(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.qualityPagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Qualification queryQualification = new Qualification();
					queryQualification.setCorpId(rs.getString("CORPID")); // 企业代码证ID
					queryQualification.setCorpCode(rs.getString("CorpCode")); // 企业代码证
					queryQualification.setCorpName(rs.getString("CorpName")); // 企业名称
					queryQualification.setCertDetailId(rs
							.getString("CertDetailId")); // 主键
					queryQualification.setCertTypeName(rs
							.getString("CertTypeName")); // 资质名称
					queryQualification.setTitleLevelName(rs
							.getString("TitleLevel")); // 资质等级
					queryQualification.setAddTypeName(rs
							.getString("AddTypeName")); // 资质取得方式
					queryQualification.setTradeBoundName(rs
							.getString("TradeBoundName")); // 专业类别
					queryQualification.setCertId(rs.getString("CertId")); // 证书编号
					queryQualification.setCertTradeStatusName(rs.getString("CertTradeStatusName"));
					page.getData().add(queryQualification);
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
	 * 资质资格类型查询
	 */
	@Override
	public List<DictionaryClass> CertTypeNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBAPTITUDEKINDDIC ";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("QUALIFICATIONSTYPE"));
				dictionaryClass.setCode(rs.getString("CODE"));
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
	 * 资质资格等级查询
	 */
	@Override
	public List<DictionaryClass> TitleLevelNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBCERTTITLELEVELDIC where QUALIFICATIONSTYPE='建筑业'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("RATING"));
				dictionaryClass.setCode(rs.getString("CODE"));
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
	 * 资质资格获取方式查询
	 */
	@Override
	public List<DictionaryClass> AddTypeNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBADDTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("GETMETHODNAME"));
				dictionaryClass.setCode(rs.getString("CODE"));
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
	 * 专业类别查询
	 */
	@Override
	public List<DictionaryClass> TradeBoundNums() {
		// TODO Auto-generated method stub
		String sql = "select * from TBTRADETYPEBOUNDDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("SPECIALTYTYPE"));
				dictionaryClass.setCode(rs.getString("CODE"));
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
	 * 通过Id来选择企业的详细信息
	 */
	@Override
	public Qualification queryById(String CertDetailId) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select t.*,(select s.QUALIFICATIONSTYPE from TBAPTITUDEKINDDIC s where t.CERTTYPENUM=s.code) as certTypeName,"
				+ "(select d.CODENAME from TBTRADETYPEDIC d where t.TRADETYPENUM=d.code) as tradeTypeName,"
				+ "(select n.SPECIALTYTYPE from TBTRADETYPEBOUNDDIC n where t.TRADEBOUNDNUM=n.code) as TRADEBOUNDNAME,"
				+ "(select l.RATING from TBCERTTITLELEVELDIC l where t.TITLELEVELNUM=l.code and rownum=1) as TITLELEVEl,"
				+ "(select b.GETMETHODNAME from TBADDTYPEDIC b where t.ADDTYPENUM=b.code) as ADDTYPENAME,"
				+ "(select e.QUALIFSTATUS from TBCERTTRADESTATUSDIC e where t.CertTradeStatusNum=e.code) as CertTradeStatusName"
				+ " from TBCorpCertdetailinfo t where t.CertDetailId=?";
		Qualification qualification = new Qualification();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, CertDetailId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				qualification.setCertDetailId(rs.getString("CertDetailId")); // 主键
				qualification.setCorpName(rs.getString("CorpName")); // 企业名称
				qualification.setCertTypeName(rs.getString("CertTypeName")); // 资质资格类型
				qualification.setCertTypeNum(rs.getString("CertTypeNum")); // 资质资格类型
				qualification.setCertId(rs.getString("CertId")); // 证书编号
				qualification.setTradeTypeName(rs.getString("TradeTypeName")); // 资质资格序列
				qualification.setTradeTypeNum(rs.getString("TradeTypeNum")); // 资质资格序列
				qualification.setTradeBoundName(rs.getString("TradeBoundName")); // 专业类别
				qualification.setTradeBoundNum(rs.getString("TradeBoundNum")); // 专业类别
				qualification.setTitleLevelLevel(rs.getString("TitleLevel")); // 资质资格等级
				qualification.setTitleLevelNum(rs.getString("TitleLevelNum")); // 资质资格等级
				qualification.setNoteNumber(rs.getString("NoteNumber")); // 首次批准资质资格文号
				qualification.setNoteDate(rs.getDate("NoteDate")); // 首次批准资质资格日期
				qualification.setAddTypeName(rs.getString("AddTypeName")); // 资质资格取得方式
				qualification.setAddTypeNum(rs.getString("AddTypeNum")); // 资质资格取得方式
				qualification.setCertTradeStatusName(rs
						.getString("CertTradeStatusName")); // 资质资格状态
				qualification.setCertTradeStatusNum(rs
						.getString("CertTradeStatusNum")); // 资质资格状态
				qualification.setCorpCode(rs.getString("CorpCode")); // 企业组织机构代码证
				qualification.setCorpId(rs.getString("CorpId")); // 企业组织机构代码证ID

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return qualification;
	}

}

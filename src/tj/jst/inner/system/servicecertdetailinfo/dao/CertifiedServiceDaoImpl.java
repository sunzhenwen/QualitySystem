package com.tj.jst.inner.system.servicecertdetailinfo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.inner.system.servicecertdetailinfo.model.Department;

/**
 * ���ʷ�������ά��
 * @author Administrator
 *
 */
public class CertifiedServiceDaoImpl extends BaseDao implements ICertifiedServiceDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public Page pagedQuery(Condition condition) {
		
		Page page = super.qualityPagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					CertifiedService certifiedService = new CertifiedService();
					//����
					certifiedService.setCertId(rs.getString("certId"));
					//������������
					certifiedService.setCertName(rs.getString("certName"));
					//���ʼ���
					certifiedService.setCretGrade(rs.getString("cretGrade"));
					//���ʼ�������
					certifiedService.setCretGradeName(rs.getString("cretGradeName"));
					//���ʵȼ�
					certifiedService.setCretLevel(rs.getInt("cretLevel"));
					//���ʵȼ�����
					certifiedService.setCretLevelName(rs.getString("cretLevelName"));
					//��������
					certifiedService.setCretSequence(rs.getInt("cretSequence"));
					//������������
					certifiedService.setCretSequenceName(rs.getString("cretSequenceName"));
					//��������
					certifiedService.setCretType(rs.getInt("cretType"));
					//������������
					certifiedService.setCretTypeName(rs.getString("cretTypeName"));
					//����רҵ���
					certifiedService.setSpecialtyType(rs.getInt("specialtyType"));
					//����רҵ�������
					certifiedService.setSpecialtyTypeName(rs.getString("specialtyTypeName"));
					//��������
					certifiedService.setApprovalDept(rs.getString("approvalDept"));
					//������������
					certifiedService.setApprovalDeptName(rs.getString("approvaldeptname"));
					//��������������
					certifiedService.setTwoApprovalDept(rs.getString("TWOAPPROVALDEPT"));
					//��������������
					certifiedService.setTwoApprovalDeptName(rs.getString("TWOAPPROVALDEPTNAME"));
					//�Ƿ�����͵ȼ�
					certifiedService.setLowestType(rs.getString("lowestType"));
					//�Ƿ������
					certifiedService.setIsUpgrade(rs.getString("isUpgrade"));
					page.getData().add(certifiedService);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}
	
	/**
	 * ���
	 * @param certifiedService
	 */
	public void addCertifiedService(CertifiedService certifiedService)
	{
		String sql = "insert into TBCERTIFIEDSERVICE(CERTNAME,CRETTYPE,CRETLEVEL,CRETSEQUENCE,SPECIALTYTYPE,"
				+ "CRETGRADE,APPROVALDEPT,createDate,CERTID,type,LOWESTTYPE,twoApprovalDept,approvalCondition,"
				+ "approvalProcess,APPROVALDEPTNAME,TWOAPPROVALDEPTNAME,ISUPGRADE,ISMAX) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String certId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,certifiedService.getCertName().trim());	
			pstmt.setInt(2,certifiedService.getCretType()); 	
			pstmt.setInt(3,certifiedService.getCretLevel());
			pstmt.setInt(4,certifiedService.getCretSequence());
			pstmt.setInt(5,certifiedService.getSpecialtyType());		
			pstmt.setString(6,certifiedService.getCretGrade().trim());	
			pstmt.setString(7,certifiedService.getApprovalDept().trim());
			pstmt.setDate(8,new Date(new java.util.Date().getTime()));
			pstmt.setString(9,certId);
			pstmt.setString(10,"0");
			pstmt.setString(11,certifiedService.getLowestType().trim());
			pstmt.setString(12,certifiedService.getTwoApprovalDept().trim());
			pstmt.setString(13,certifiedService.getApprovalCondition().trim());
			pstmt.setString(14,certifiedService.getApprovalProcess().trim());
			pstmt.setString(15,certifiedService.getApprovalDeptName().trim());
			pstmt.setString(16,certifiedService.getTwoApprovalDeptName().trim());
			pstmt.setString(17,certifiedService.getIsUpgrade().trim());
			pstmt.setString(18,certifiedService.getIsMax().trim());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	/**
	 * ��ѯ����
	 * @param certifiedService
	 */
	public CertifiedService queryById(String certId)
	{
		String sql = "select * from TBCERTIFIEDSERVICE where certId=?";
		CertifiedService certifiedService = new CertifiedService();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,certId);	
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				certifiedService.setCertId(rs.getString("certId"));
				certifiedService.setCertName(rs.getString("certName"));
				certifiedService.setCretGrade(rs.getString("cretGrade"));
				certifiedService.setCretLevel(rs.getInt("cretLevel"));
				certifiedService.setCretSequence(rs.getInt("cretSequence"));
				certifiedService.setCretType(rs.getInt("cretType"));
				certifiedService.setSpecialtyType(rs.getInt("specialtyType"));
				certifiedService.setApprovalDept(rs.getString("approvalDept").trim());
				certifiedService.setLowestType(rs.getString("lowestType"));
				certifiedService.setTwoApprovalDept(rs.getString("twoApprovalDept").trim());
				certifiedService.setApprovalCondition(rs.getString("approvalCondition"));
				certifiedService.setApprovalProcess(rs.getString("approvalProcess"));
				certifiedService.setApprovalDeptName(rs.getString("approvalDeptName").trim());
				certifiedService.setTwoApprovalDeptName(rs.getString("twoApprovalDeptName").trim());
				certifiedService.setIsUpgrade(rs.getString("isUpgrade"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return certifiedService;
	}

	/**
	 * �޸�
	 * @param certifiedService
	 */
	public void modifyCertifiedService(CertifiedService certifiedService)
	{
		String sql = "update TBCERTIFIEDSERVICE set CERTNAME=?,CRETTYPE=?,CRETLEVEL=?,CRETSEQUENCE=?,SPECIALTYTYPE=?,"
				+ "CRETGRADE=?,APPROVALDEPT=?,MODIFYDATE=?,lowestType=?,twoApprovalDept=?,approvalCondition=?,approvalProcess=?,"
				+ "approvalDeptName=?,twoApprovalDeptName=?,ISUPGRADE=? "
				+ "where CERTID=?";
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,certifiedService.getCertName());	
			pstmt.setInt(2,certifiedService.getCretType()); 	
			pstmt.setInt(3,certifiedService.getCretLevel());
			pstmt.setInt(4,certifiedService.getCretSequence());
			pstmt.setInt(5,certifiedService.getSpecialtyType());		
			pstmt.setString(6,certifiedService.getCretGrade());	
			pstmt.setString(7,certifiedService.getApprovalDept());
			pstmt.setDate(8,new Date(new java.util.Date().getTime()));
			pstmt.setString(9,certifiedService.getLowestType());
			pstmt.setString(10,certifiedService.getTwoApprovalDept());
			pstmt.setString(11,certifiedService.getApprovalCondition());
			pstmt.setString(12,certifiedService.getApprovalProcess());
			pstmt.setString(13,certifiedService.getApprovalDeptName());
			pstmt.setString(14,certifiedService.getTwoApprovalDeptName());
			pstmt.setString(15,certifiedService.getIsUpgrade());
			pstmt.setString(16,certifiedService.getCertId());
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("update TBQUALIFICATIONAPPLY set certName=?" +
					" where certName=? ");
			pstmt.setString(1, certifiedService.getCertName());
			pstmt.setString(2, certifiedService.getOldCertName());
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("update TBCORPCERTINFO set certName=?" +
					" where certName=? ");
			pstmt.setString(1, certifiedService.getCertName());
			pstmt.setString(2, certifiedService.getOldCertName());
			pstmt.executeUpdate();
			
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement("update TBCORPCERTINFO set certName=?" +
					" where certName=? ");
			pstmt.setString(1, certifiedService.getCertName());
			pstmt.setString(2, certifiedService.getOldCertName());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	/**
	 * ɾ��
	 */
	public void delectCertifiedService(String[] certIds)
	{
		String sql = "update TBCERTIFIEDSERVICE set type=? where certId=?";
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			// ȡ���Զ��ύ
            conn.setAutoCommit(false);
            for(int i=0;i<certIds.length;i++)
            {
            	pstmt.setString(1,"1");	
            	pstmt.setString(2,certIds[i]);	
    			pstmt.addBatch();
            }
			
            pstmt.executeBatch();
            // ���û�д������ʾ��������ִ�� �ֹ��ύ
            conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	//��������(�ֵ��TBAPTITUDEKINDDIC)
	@Override
	public List<DictionaryClass> queryCretTypes() {
		// TODO Auto-generated method stub
		String sql = "select * from TBAPTITUDEKINDDIC where QUALIFICATIONSTYPE='����ҵ'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("QUALIFICATIONSTYPE").trim());
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

	//���ʵȼ�(�ֵ��TBCERTTITLELEVELDIC)
	@Override
	public List<DictionaryClass> queryCretLevels() {
		// TODO Auto-generated method stub
		String sql = "select * from TBCERTTITLELEVELDIC where QUALIFICATIONSTYPE='����ҵ'";
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

	//��������(�ֵ��TBTRADETYPEDIC)
	@Override
	public List<DictionaryClass> queryCretSequences() {
		// TODO Auto-generated method stub
		String sql = "select * from TBTRADETYPEDIC where code like '104%'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("codeName").trim());
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

	//����רҵ���(�ֵ��TBTRADETYPEBOUNDDIC)
	@Override
	public List<DictionaryClass> querySpecialtyTypes(String cretSequenceId) {
		// TODO Auto-generated method stub
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		if(!cretSequenceId.equals(""))
		{
			String sql = "select * from TBTRADETYPEBOUNDDIC where code like '"+cretSequenceId+"%'";
			try {
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					DictionaryClass dictionaryClass = new DictionaryClass();
					dictionaryClass.setName(rs.getString("SPECIALTYTYPE").trim());
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
		}
		return list;
	}
	//���ʼ���(�ֵ��TBCRETGRADEDIC)
	public List<DictionaryClass> queryCretGrades()
	{
		// TODO Auto-generated method stub
		String sql = "select * from TBCRETGRADEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name").trim());
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
	
	public List<Department> getDepartment()
	{
		Connection connection = null;
		ResultSet rs = null;
		String sql = "select id,name from systembasic_department  where show =1 and property = 0 ";
		List<Department> list = new ArrayList<Department>();
		//String[][] dw =new String[100][2];
		try{			
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Department dept = new Department();
				dept.setId(rs.getString("id"));
				dept.setName(rs.getString("name"));
				list.add(dept);
			}
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
//				if(connection != null && !connection.isClosed())
//				{
//					connection.close();
//				}
				ConnectionFactory.closeConn(conn, pstmt, rs);
			}catch(Exception e){
				System.out.println(e.toString());
			}
		}
		return list;
	}
}

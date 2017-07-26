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
 * ����������ʷ��¼��ѯ
 * @author DarkFlameMaster
 *
 */
public class TwoQueryDaoImpl extends BaseDao implements ITwoQueryDao{

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**
	 * ��ҳ��ѯ
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
					//����
					certifiedService.setNewQualId(rs.getString("newQualId"));
					//��ҵ����
					certifiedService.setCorpId(rs.getString("corpId"));
					//��ҵ����
					certifiedService.setCorpName(rs.getString("corpName"));
					//��ҵסַ��������֤
					certifiedService.setCorpCode(rs.getString("corpCode"));
					//��ҵ����ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
					certifiedService.setProvinceNum(rs.getString("provinceNum"));
					//��ҵ����ʡ����
					certifiedService.setProvinceName(rs.getString("provinceName"));
					//��ҵ���ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
					certifiedService.setCityNum(rs.getString("cityNum"));
					//��ҵ����������
					certifiedService.setCityName(rs.getString("cityName"));
					//��ҵ������(�����С���)(�ֵ��TBXZQDMDIC)
					certifiedService.setCountyNum(rs.getString("countyNum"));
					//��ҵ����������
					certifiedService.setCountyName(rs.getString("countyName"));
					//����״̬(1��������)
					certifiedService.setQualifType(rs.getString("qualifType"));
					//������������
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
					certifiedService.setApprovalDeptName(rs.getString("approvalDeptName"));
					//��������������
					certifiedService.setTwoApprovalDept(rs.getString("twoApprovalDept"));
					//������������������
					certifiedService.setTwoApprovalDeptName(rs.getString("twoApprovalDeptName"));
					//��������
					certifiedService.setCreatDate(rs.getDate("CREATDATE"));
					//����ȡ�÷�ʽ��ʽ
					certifiedService.setAddTypeNum(rs.getString("addTypeNum"));
					//����ȡ�÷�ʽ����
					certifiedService.setAddTypeName(rs.getString("addTypeName"));
					//�����������	5:ͨ�� 6:��ͨ��
					if(rs.getString("ULTIMATERESULTS") != null){
						if(rs.getString("ULTIMATERESULTS").equals("5")){
							certifiedService.setUltimateResults("����ͨ��");
						}else if(rs.getString("ULTIMATERESULTS").equals("6")){
							certifiedService.setUltimateResults("����δͨ��");
						}
					}
					//�����������	3:ͨ�� 4:��ͨ��
					if(rs.getString("ONERESULTS") != null){
						if(rs.getString("ONERESULTS").equals("3")){
							certifiedService.setOneResults("����ͨ��");
						}else if(rs.getString("ONERESULTS").equals("4")){
							certifiedService.setOneResults("����δͨ��");
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
	 * ������¼��ϸҳ��
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
				//����
				certifiedService.setNewQualId(rs.getString("newQualId").trim());
				//��ҵ����
				certifiedService.setCorpId(rs.getString("corpId").trim());
				//��ҵ����
				certifiedService.setCorpName(rs.getString("corpName").trim());
				//��ҵסַ��������֤
				certifiedService.setCorpCode(rs.getString("corpCode").trim());
				//��ҵ����ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
				certifiedService.setProvinceNum(rs.getString("provinceNum").trim());
				//��ҵ����ʡ����
				certifiedService.setProvinceName(rs.getString("provinceName").trim());
				//��ҵ���ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
				certifiedService.setCityNum(rs.getString("cityNum").trim());
				//��ҵ����������
				certifiedService.setCityName(rs.getString("cityName").trim());
				//��ҵ������(�����С���)(�ֵ��TBXZQDMDIC)
				certifiedService.setCountyNum(rs.getString("countyNum").trim());
				//��ҵ����������
				certifiedService.setCountyName(rs.getString("countyName").trim());
				//����״̬(1��������)
				certifiedService.setQualifType(rs.getString("qualifType").trim());
				//������������
				certifiedService.setCertId(rs.getString("certId").trim());
				//������������
				certifiedService.setCertName(rs.getString("certName").trim());
				//���ʼ���
				certifiedService.setCretGrade(rs.getString("cretGrade").trim());
				//���ʼ�������
				certifiedService.setCretGradeName(rs.getString("cretGradeName").trim());
				//���ʵȼ�
				certifiedService.setCretLevel(rs.getInt("cretLevel"));
				//���ʵȼ�����
				certifiedService.setCretLevelName(rs.getString("cretLevelName").trim());
				//��������
				certifiedService.setCretSequence(rs.getInt("cretSequence"));
				//������������
				certifiedService.setCretSequenceName(rs.getString("cretSequenceName").trim());
				//��������
				certifiedService.setCretType(rs.getInt("cretType"));
				//������������
				certifiedService.setCretTypeName(rs.getString("cretTypeName").trim());
				//����רҵ���
				certifiedService.setSpecialtyType(rs.getInt("specialtyType"));
				//����רҵ�������
				certifiedService.setSpecialtyTypeName(rs.getString("specialtyTypeName").trim());
				//��������
				certifiedService.setCreatDate(rs.getDate("CREATDATE"));
				//�����ʸ�ȡ�÷�ʽ
				certifiedService.setAddTypeNum(rs.getString("addTypeNum").trim());
				//�����ʸ�ȡ�÷�ʽ����
				certifiedService.setAddTypeName(rs.getString("addTypeName").trim());
				//��������
				certifiedService.setApprovalDept(rs.getString("approvalDept").trim());
				//������������
				certifiedService.setApprovalDeptName(rs.getString("approvalDeptName").trim());
				//��������������
				certifiedService.setTwoApprovalDept(rs.getString("twoApprovalDept").trim());
				//������������������
				certifiedService.setTwoApprovalDeptName(rs.getString("twoApprovalDeptName").trim());
				//�����������
				certifiedService.setOneUltimateOpinion(rs.getString("ONEULTIMATEOPINION"));
				//��������ʱ��
				certifiedService.setOneAppDate(rs.getDate("oneAppDate"));
				//����������Ա
				certifiedService.setTwoApprovalStaff(rs.getString("twoApprovalStaff"));
				//����������Ա
				certifiedService.setApprovalStaff(rs.getString("approvalStaff"));
				//�����������
				certifiedService.setUltimateOpinion(rs.getString("UltimateOpinion"));
				//�����������	5:ͨ�� 6:��ͨ��
				if(rs.getString("ULTIMATERESULTS") != null){
					if(rs.getString("ULTIMATERESULTS").equals("5")){
						certifiedService.setUltimateResults("����ͨ��");
						
					}else if(rs.getString("ULTIMATERESULTS").equals("6")){
						certifiedService.setUltimateResults("����δͨ��");
					}
				}
				//�����������	3:ͨ�� 4:��ͨ��
				if(rs.getString("ONERESULTS") != null){
					if(rs.getString("ONERESULTS").equals("3")){
						certifiedService.setOneResults("����ͨ��");
					}else if(rs.getString("ONERESULTS").equals("4")){
						certifiedService.setOneResults("����δͨ��");
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
	 * ���ʵȼ��ֵ��
	 */
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

	/**
	 * ���������ֵ��
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

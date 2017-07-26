package com.tj.jst.inner.qualificationProductivity.countryApproval.dao;

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
import com.tj.jst.base.util.judgedate.JudgeDateAction;
import com.tj.jst.outside.businessReport.newQualification.model.NewQualification;

/**
 * ������������
 * @author Administrator
 *
 */
public class CountryApprovalDaoImpl extends BaseDao implements ICountryApprovalDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection baseConn = null;
	PreparedStatement basePstmt = null;
	
	public Page pagedQuery(Condition condition) {
		
		Page page = super.qualityPagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					NewQualification certifiedService = new NewQualification();
					
					//����
					certifiedService.setNewQualId(rs.getString("newQualId"));
					certifiedService.setFloorDate(rs.getDate("floorDate"));
					//��ҵ����
					certifiedService.setCorpId(rs.getString("corpId"));
					//��ҵ����
					certifiedService.setCorpName(rs.getString("corpName"));
					//��ҵסַ��������֤
					certifiedService.setCorpCode(rs.getString("corpCode"));
					//��ҵ����ʡ(��������ֱϽ��)(�ֵ����TBXZQDMDIC)
					certifiedService.setProvinceNum(rs.getString("provinceNum"));
					//��ҵ����ʡ����
					certifiedService.setProvinceName(rs.getString("provinceName"));
					//��ҵ���ڵ�(�С��ݡ���)(�ֵ����TBXZQDMDIC)
					certifiedService.setCityNum(rs.getString("cityNum"));
					//��ҵ����������
					certifiedService.setCityName(rs.getString("cityName"));
					//��ҵ������(�����С���)(�ֵ����TBXZQDMDIC)
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
					certifiedService.setAssets(rs.getString("assets"));
					certifiedService.setMachinery(rs.getString("machinery"));
					certifiedService.setFloorDate(rs.getDate("floorDate"));
					if (rs.getDate("floorDate") != null) {
						// ��ֹ����
						certifiedService.setDeadDate(JudgeDateAction
								.getDeadDate(rs.getDate("floorDate")));
						// �ж��Ƿ���
						int days = JudgeDateAction
								.getDifferDate(JudgeDateAction.getDeadDate(rs
										.getDate("floorDate")));
						if (days > 5) {
							certifiedService.setDateMark("0");
						} else if (days >= 0 && days <= 5) {
							certifiedService.setDateMark("1");
						} else if (days < 0) {
							certifiedService.setDateMark("2");
						}
						certifiedService.setDifferDay(Integer.toString(days));
					}
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
	 * ��ת����ҳ���ѯ  (�����������)
	 */
	public NewQualification queryApproval(String newQualId)
	{
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
				//��ҵ����ʡ(��������ֱϽ��)(�ֵ����TBXZQDMDIC)
				certifiedService.setProvinceNum(rs.getString("provinceNum").trim());
				//��ҵ����ʡ����
				certifiedService.setProvinceName(rs.getString("provinceName").trim());
				//��ҵ���ڵ�(�С��ݡ���)(�ֵ����TBXZQDMDIC)
				certifiedService.setCityNum(rs.getString("cityNum").trim());
				//��ҵ����������
				certifiedService.setCityName(rs.getString("cityName").trim());
				//��ҵ������(�����С���)(�ֵ����TBXZQDMDIC)
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
				//��������Id
				certifiedService.setApprovalDept(rs.getString("approvalDept").trim());
				//������������
				certifiedService.setApprovalDeptName(rs.getString("approvalDeptName").trim());
				//��ҵ�Ǽ�ע������
				certifiedService.setEconomicNum(rs.getInt("economicNum"));
				//������������
				certifiedService.setTwoApprovalDept(rs.getString("twoApprovalDept").trim());
				//����������������
				certifiedService.setTwoApprovalDeptName(rs.getString("twoApprovalDeptName").trim());
				//������Ա
				certifiedService.setTwoApprovalStaff(rs.getString("twoApprovalStaff"));
				//������ԱId
				certifiedService.setTwoApprovalStaffId(rs.getString("twoApprovalStaffId"));
				//����ʱ��
				certifiedService.setOneAppDate(rs.getDate("oneAppDate"));
				//����״̬
				certifiedService.setOneResults(rs.getString("oneResults"));
				//������
				certifiedService.setOneUltimateOpinion(rs.getString("oneUltimateOpinion"));
				//��ҵ�Ǽ�ע������
				certifiedService.setEconomicNum(rs.getInt("economicNum"));
				//����Ӫҵִ��ע���
				certifiedService.setLicenseNum(rs.getString("licenseNum"));
				//��������������
				certifiedService.setLegalMan(rs.getString("legalMan"));
				//����������֤������
				certifiedService.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				//����������֤������
				certifiedService.setLegalManIdCard(rs.getString("legalManIdCard"));
				//����������ְ��
				certifiedService.setLegaLManDuty(rs.getString("legaLManDuty"));
				//����������ְ��
				certifiedService.setLegaManProtitle(rs.getString("legaManProtitle"));
				//��ҵӪҵ��ַ
				certifiedService.setAddress(rs.getString("address"));
				//ע���ʱ�
				certifiedService.setRegPrin(rs.getString("REGPRIN"));
				certifiedService.setAssets(rs.getString("assets"));
				certifiedService.setMachinery(rs.getString("machinery"));
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
	 * ����ͨ�� (�����������)
	 * @return
	 */
	public void applyThrough(NewQualification newQualification,String certifiedCode)
	{
		
		//�ж��Ƿ���������������������轫�����ʵĵͼ��ȼ�ע����
		if( "002".equals(newQualification.getAddTypeNum()) ){
			this.cancalQualification(newQualification.getCorpId(),newQualification.getSpecialtyType(),newQualification.getCretLevel());
		}
		
		try {
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement("update TBQUALIFICATIONAPPLY set qualifType=?,ULTIMATEOPINION=?,"
					+ "APPROVALSTAFF=?,APPROVALSTAFFID=?,ULTIMATEDATE=?,ULTIMATERESULTS=? where NEWQUALID=?");
			pstmt.setString(1,"7");	
			pstmt.setString(2,newQualification.getUltimateOpinion()); //�������
			pstmt.setString(3,newQualification.getApprovalStaff()); //������Ա����
			pstmt.setString(4,newQualification.getApprovalStaffId()); //������ԱId
			pstmt.setDate(5,new Date(new java.util.Date().getTime())); //����ʱ��
			pstmt.setString(6,"7"); //�������
			pstmt.setString(7,newQualification.getNewQualId()); 
			pstmt.executeUpdate();

			pstmt = conn.prepareStatement("insert into tbcorpcertdetailinfo(CORPNAME,CORPCODE,CERTTYPENUM,CERTID,"
					+ "TRADETYPENUM,TRADEBOUNDNUM,TITLELEVELNUM,NOTEDATE,ADDTYPENUM,CORPID,OLDORNEW,DATASOURCE,"
					+ "qualifType,approvalDept,approvalStaff,ultimateOpinion,APPROVALSTAFFID,APPROVALDEPTNAME,"
					+ "ULTIMATEDATE,ULTIMATERESULTS,economicNum,licenseNum,legalMan,idCardTypeNum,"
					+ "legalManIdCard,legaLManDuty,legaManProtitle,address,RELATIONID,CERTDETAILID) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERTDTAI_SEQ.NEXTVAL)");
			
			//��ҵ����
			pstmt.setString(1, newQualification.getCorpName());
			//��֯��������
			pstmt.setString(2, newQualification.getCorpCode());
			//��ҵ����
			pstmt.setInt(3, newQualification.getCretType());
			//֤����
			pstmt.setString(4, certifiedCode);
			//�����ʸ�����
			pstmt.setInt(5, newQualification.getCretSequence());
			//רҵ���
			pstmt.setInt(6, newQualification.getSpecialtyType());
			//�����ʸ�ȼ�
			pstmt.setInt(7, newQualification.getCretLevel());
			//�״���׼�����ʸ�����
			pstmt.setDate(8, new Date(new java.util.Date().getTime()));
			//�����ʸ�ȡ�÷�ʽ
			pstmt.setString(9, newQualification.getAddTypeNum());
			//��ҵid
			pstmt.setString(10, newQualification.getCorpId());
			//��������
			pstmt.setString(11, "1");
			//ϵͳ��Դ
			pstmt.setString(12, "01");
			//����״̬
			pstmt.setString(13, "7");
			//��������
			pstmt.setString(14, newQualification.getApprovalDept());
			//������
			pstmt.setString(15, newQualification.getApprovalStaff());
			//�������
			pstmt.setString(16, newQualification.getUltimateOpinion());
			//������Id
			pstmt.setString(17, newQualification.getApprovalStaffId());
			//������������
			pstmt.setString(18, newQualification.getApprovalDeptName());
			//����ʱ��
			pstmt.setDate(19, new Date(new java.util.Date().getTime()));
			//�������
			pstmt.setString(20, "7");
			
			//��ҵ�Ǽ�ע������
			pstmt.setInt(21, newQualification.getEconomicNum());
			//����Ӫҵִ��ע���
			pstmt.setString(22, newQualification.getLicenseNum());
			//��������������
			pstmt.setString(23, newQualification.getLegalMan());
			//����������֤������
			pstmt.setString(24, newQualification.getIdCardTypeNum());
			//����������֤������
			pstmt.setString(25, newQualification.getLegalManIdCard());
			//����������ְ��
			pstmt.setString(26, newQualification.getLegaLManDuty());
			//����������ְ��
			pstmt.setString(27, newQualification.getLegaManProtitle());
			//��ҵӪҵ��ַ
			pstmt.setString(28, newQualification.getAddress());
			pstmt.setString(29, newQualification.getNewQualId());
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("insert into tbcorpcertinfo(CORPNAME,CORPCODE,CERTTYPENUM,CERTID,"
					+ "TITLELEVELNUM,ORGANNAME,CERTNAME,APPROVALDEPT,APPROVALSTAFF,APPROVALSTAFFID,ULTIMATEDATE,"
					+ "CRETGRADE,ADDTYPENUM,LICENSENUM,APPROVALDEPTNAME,PROVINCENUM,CITYNUM,COUNTYNUM,ADDRESS,"
					+ "LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,LEGAMANPROTITLE,ECONOMICNUM,REGPRIN,"
					+ "ISVALID,corpId,relationId,WRITEOFFTYPE,CORPCERTID) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERTDTAI_SEQ.NEXTVAL)");

			//��ҵ����
			pstmt.setString(1, newQualification.getCorpName());
			//��֯��������
			pstmt.setString(2, newQualification.getCorpCode());
			//�����ʸ�����
			pstmt.setInt(3, newQualification.getCretType());
			//֤����
			pstmt.setString(4, certifiedCode);
			//�����ʸ���ߵȼ�
			pstmt.setInt(5, newQualification.getCretLevel());
			//��֤����
//			if(newQualification.getCretGrade().equals("1"))
//			{
//				pstmt.setString(6, "�л����񹲺͹�ס���ͳ��罨�貿");
//			}else if(newQualification.getCretGrade().equals("2"))
//			{
//				pstmt.setString(6, "������ʡס����");
//			}else
//			{
//				pstmt.setString(6, newQualification.getCityName()+"�����");
//			}
			pstmt.setString(6, "�л����񹲺͹�ס���ͳ��罨�貿");
			//������𼰵ȼ�
			pstmt.setString(7, newQualification.getCertName());
			//��������
			pstmt.setString(8, newQualification.getApprovalDept());
			//������
			pstmt.setString(9, newQualification.getApprovalStaff());
			//������Id
			pstmt.setString(10, newQualification.getApprovalStaffId());
			//����ʱ��
			pstmt.setDate(11, new Date(new java.util.Date().getTime()));
			//���ʼ���
			pstmt.setString(12, newQualification.getCretGrade());
			//�����ʸ�ȡ�÷�ʽ
			pstmt.setString(13, newQualification.getAddTypeNum());
			//����Ӫҵִ��ע���
			pstmt.setString(14, newQualification.getLicenseNum());
			//������������
			pstmt.setString(15, newQualification.getApprovalDeptName());
			pstmt.setString(16, newQualification.getProvinceNum());//ע������ʡ(��������ֱϽ��)(�ֵ����TBXZQDMDIC)
			pstmt.setString(17, newQualification.getCityNum());//ע�����ڵ�(�С��ݡ���)(�ֵ����TBXZQDMDIC)
			pstmt.setString(18, newQualification.getCountyNum());//ע��������(�����С���)(�ֵ����TBXZQDMDIC)
			pstmt.setString(19, newQualification.getAddress());//��ҵӪҵ��ַ
			pstmt.setString(20, newQualification.getLegalMan());//��������������
			pstmt.setString(21, newQualification.getIdCardTypeNum());//����������֤������(�ֵ����TBIDCARDTYPEDIC)
			pstmt.setString(22, newQualification.getLegalManIdCard());//����������֤������
			pstmt.setString(23, newQualification.getLegaLManDuty());//����������ְ��
			pstmt.setString(24, newQualification.getLegaManProtitle());//����������ְ��
			pstmt.setInt(25, newQualification.getEconomicNum());//��ҵ�Ǽ�ע������(�ֵ����TBECONTYPEDIC)
			pstmt.setString(26, newQualification.getRegPrin());//ע���ʱ�
//			pstmt.setDate(27, new Date(new java.util.Date().getTime()));//��֤����
//			pstmt.setDate(28, UtilDate.getStringChangeDate());//֤����Ч��ֹ����
			pstmt.setInt(27, 1);//֤��״̬
			pstmt.setString(28, newQualification.getCorpId());
			pstmt.setString(29, newQualification.getNewQualId());
			pstmt.setString(30, "0");
			pstmt.executeUpdate();
			
			conn.commit();
			this.applyThroughBase(newQualification,certifiedCode);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	/**
	 * �������������ʵĵ͵ȼ�����ע��
	 * @param corpId
	 * @param specialtyType
	 * @param cretLevel
	 */
	private void cancalQualification(String corpId, int specialtyType,
			int cretLevel) {
		// TODO Auto-generated method stub
		try {
			String sql = "select * from TBCORPCERTDETAILINFO " +
					"where CORPID=? and TRADEBOUNDNUM=? and TITLELEVELNUM=? and CERTTRADESTATUSNUM=?" ;
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpId);
			pstmt.setInt(2, specialtyType);
			pstmt.setInt(3, cretLevel-1);
			pstmt.setString(4, "001");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pstmt = conn.prepareStatement("update TBCORPCERTDETAILINFO set CERTTRADESTATUSNUM=? " +
						"where CORPID=? and TRADEBOUNDNUM=? and TITLELEVELNUM=?");
				pstmt.setString(1, "002");
				pstmt.setString(2, corpId);
				pstmt.setInt(3, specialtyType);
				pstmt.setInt(4, cretLevel-1);
				pstmt.executeUpdate();
				
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement("update TBCORPCERTDETAILINFO set certtradestatusnum=? " +
						"where corpId=? and tradeboundnum=? and titlelevelnum=?");
				pstmt.setString(1, "002");
				pstmt.setString(2, corpId);
				pstmt.setInt(3, specialtyType);
				pstmt.setInt(4, cretLevel-1);
				pstmt.executeUpdate(); 
				//this.cancalQualification(corpId, specialtyType, cretLevel-1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				ConnectionFactory.closeConn(conn, pstmt, null);
			}
		}
	}

	/**
	 * �������ݿ����������Ϣ (�����������)
	 * @return
	 */
	public void applyThroughBase(NewQualification newQualification,String certifiedCode)
	{
		
		try {
			baseConn = ConnectionFactory.getBasicConnection();
			baseConn.setAutoCommit(false);
			basePstmt = baseConn.prepareStatement("insert into tbcorpcertdetailinfo(CORPNAME,CORPCODE,CERTTYPENUM,"
					+ "CERTID,"
					+ "TRADETYPENUM,TRADEBOUNDNUM,TITLELEVELNUM,NOTEDATE,ADDTYPENUM,CORPID,OLDORNEW,DATASOURCE,"
					+ "qualifType,approvalDept,approvalStaff,ultimateOpinion,APPROVALSTAFFID,APPROVALDEPTNAME,"
					+ "ULTIMATEDATE,ULTIMATERESULTS,economicNum,licenseNum,legalMan,idCardTypeNum,"
					+ "legalManIdCard,legaLManDuty,legaManProtitle,address,relationId,CERTDETAILID) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERTDTAI_SEQ.NEXTVAL)");
			//��ҵ����
			basePstmt.setString(1, newQualification.getCorpName());
			//��֯��������
			basePstmt.setString(2, newQualification.getCorpCode());
			//��ҵ����
			basePstmt.setInt(3, newQualification.getCretType());
			//֤����
			basePstmt.setString(4, certifiedCode);
			//�����ʸ�����
			basePstmt.setInt(5, newQualification.getCretSequence());
			//רҵ���
			basePstmt.setInt(6, newQualification.getSpecialtyType());
			//�����ʸ�ȼ�
			basePstmt.setInt(7, newQualification.getCretLevel());
			//�״���׼�����ʸ�����
			basePstmt.setDate(8, new Date(new java.util.Date().getTime()));
			//�����ʸ�ȡ�÷�ʽ
			basePstmt.setString(9, newQualification.getAddTypeNum());
			//��ҵid
			basePstmt.setString(10, newQualification.getCorpId());
			//��������
			basePstmt.setString(11, "1");
			//ϵͳ��Դ
			basePstmt.setString(12, "01");
			//����״̬
			basePstmt.setString(13, "7");
			//��������
			basePstmt.setString(14, newQualification.getApprovalDept());
			//������
			basePstmt.setString(15, newQualification.getApprovalStaff());
			//�������
			basePstmt.setString(16, newQualification.getUltimateOpinion());
			//������Id
			basePstmt.setString(17, newQualification.getApprovalStaffId());
			//������������
			basePstmt.setString(18, newQualification.getApprovalDeptName());
			//����ʱ��
			basePstmt.setDate(19, new Date(new java.util.Date().getTime()));
			//�������
			basePstmt.setString(20, "7");
			
			//��ҵ�Ǽ�ע������
			basePstmt.setInt(21, newQualification.getEconomicNum());
			//����Ӫҵִ��ע���
			basePstmt.setString(22, newQualification.getLicenseNum());
			//��������������
			basePstmt.setString(23, newQualification.getLegalMan());
			//����������֤������
			basePstmt.setString(24, newQualification.getIdCardTypeNum());
			//����������֤������
			basePstmt.setString(25, newQualification.getLegalManIdCard());
			//����������ְ��
			basePstmt.setString(26, newQualification.getLegaLManDuty());
			//����������ְ��
			basePstmt.setString(27, newQualification.getLegaManProtitle());
			//��ҵӪҵ��ַ
			basePstmt.setString(28, newQualification.getAddress());
			basePstmt.setString(29, newQualification.getNewQualId());
			basePstmt.executeUpdate();
			
			basePstmt = baseConn.prepareStatement("insert into tbcorpcertinfo(CORPNAME,CORPCODE,CERTTYPENUM,CERTID,"
					+ "TITLELEVELNUM,ORGANNAME,CERTNAME,APPROVALDEPT,APPROVALSTAFF,APPROVALSTAFFID,ULTIMATEDATE,"
					+ "CRETGRADE,ADDTYPENUM,LICENSENUM,APPROVALDEPTNAME,PROVINCENUM,CITYNUM,COUNTYNUM,ADDRESS,"
					+ "LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,LEGAMANPROTITLE,ECONOMICNUM,OLDORNEW,"
					+ "DATASOURCE,REGPRIN,ISVALID,corpId,relationId,WRITEOFFTYPE,CORPCERTID) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERTDTAI_SEQ.NEXTVAL)");

			//��ҵ����
			basePstmt.setString(1, newQualification.getCorpName());
			//��֯��������
			basePstmt.setString(2, newQualification.getCorpCode());
			//�����ʸ�����
			basePstmt.setInt(3, newQualification.getCretType());
			//֤����
			basePstmt.setString(4, certifiedCode);
			//�����ʸ���ߵȼ�
			basePstmt.setInt(5, newQualification.getCretLevel());
			//��֤����
//			if(newQualification.getCretGrade().equals("1"))
//			{
//				basePstmt.setString(6, "�л����񹲺͹�ס���ͳ��罨�貿");
//			}else if(newQualification.getCretGrade().equals("2"))
//			{
//				basePstmt.setString(6, "������ʡס����");
//			}else
//			{
//				basePstmt.setString(6, newQualification.getCityName()+"�����");
//			}
			basePstmt.setString(6, "�л����񹲺͹�ס���ͳ��罨�貿");
			//������𼰵ȼ�
			basePstmt.setString(7, newQualification.getCertName());
			//��������
			basePstmt.setString(8, newQualification.getApprovalDept());
			//������
			basePstmt.setString(9, newQualification.getApprovalStaff());
			//������Id
			basePstmt.setString(10, newQualification.getApprovalStaffId());
			//����ʱ��
			basePstmt.setDate(11, new Date(new java.util.Date().getTime()));
			//���ʼ���
			basePstmt.setString(12, newQualification.getCretGrade());
			//�����ʸ�ȡ�÷�ʽ
			basePstmt.setString(13, newQualification.getAddTypeNum());
			//����Ӫҵִ��ע���
			basePstmt.setString(14, newQualification.getLicenseNum());
			//������������
			basePstmt.setString(15, newQualification.getApprovalDeptName());
			basePstmt.setString(16, newQualification.getProvinceNum());//ע������ʡ(��������ֱϽ��)(�ֵ����TBXZQDMDIC)
			basePstmt.setString(17, newQualification.getCityNum());//ע�����ڵ�(�С��ݡ���)(�ֵ����TBXZQDMDIC)
			basePstmt.setString(18, newQualification.getCountyNum());//ע��������(�����С���)(�ֵ����TBXZQDMDIC)
			basePstmt.setString(19, newQualification.getAddress());//��ҵӪҵ��ַ
			basePstmt.setString(20, newQualification.getLegalMan());//��������������
			basePstmt.setString(21, newQualification.getIdCardTypeNum());//����������֤������(�ֵ����TBIDCARDTYPEDIC)
			basePstmt.setString(22, newQualification.getLegalManIdCard());//����������֤������
			basePstmt.setString(23, newQualification.getLegaLManDuty());//����������ְ��
			basePstmt.setString(24, newQualification.getLegaManProtitle());//����������ְ��
			basePstmt.setInt(25, newQualification.getEconomicNum());//��ҵ�Ǽ�ע������(�ֵ����TBECONTYPEDIC)
			basePstmt.setString(26, "1");//0�������� 1��������
			basePstmt.setString(27, "01");//������Դϵͳ
			basePstmt.setString(28, newQualification.getRegPrin());//ע���ʱ�
//			basePstmt.setDate(29, new Date(new java.util.Date().getTime()));//��֤����
//			basePstmt.setDate(30, UtilDate.getStringChangeDate());//֤����Ч��ֹ����
			basePstmt.setInt(29, 1);//֤��״̬
			basePstmt.setString(30, newQualification.getCorpId());
			basePstmt.setString(31, newQualification.getNewQualId());
			basePstmt.setString(32, "0");
			basePstmt.executeUpdate();
			
//			//��λɾ��������
//			if(newQualification.getAddTypeNum().equals("007"))
//			{
//				basePstmt = baseConn.prepareStatement("delete from tbcorpcertdetailinfo where CORPID=? and TITLELEVELNUM=? "
//						+ "and TRADEBOUNDNUM=? and OLDORNEW=?");
//				basePstmt.setString(1, newQualification.getCorpId());//��ҵId
//				basePstmt.setInt(2, newQualification.getCretLevel());//���ʵȼ�
//				basePstmt.setInt(3, newQualification.getSpecialtyType());//�������
//				basePstmt.setString(4, "0");//��������
//				basePstmt.executeUpdate();
//			}
			
			baseConn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				baseConn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(baseConn, basePstmt, null);
		}
	}
	/**
	 * �����˻�(�����������)
	 * @return
	 */
	public void applyThroughBack(NewQualification newQualification)
	{
		try {
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement("update TBQUALIFICATIONAPPLY set qualifType=?,ULTIMATEOPINION=?,"
					+ "APPROVALSTAFF=?,APPROVALSTAFFID=?,ULTIMATEDATE=?,ULTIMATERESULTS=? where NEWQUALID=?");
			pstmt.setString(1,"8");	
			pstmt.setString(2,newQualification.getUltimateOpinion()); //�������
			pstmt.setString(3,newQualification.getApprovalStaff()); //������Ա����
			pstmt.setString(4,newQualification.getApprovalStaffId()); //������ԱId
			pstmt.setDate(5,newQualification.getUltimateDate()); //����ʱ��
			pstmt.setString(6,"8"); //�������
			pstmt.setString(7,newQualification.getNewQualId()); 
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into tbcorpcertdetailinfo(CORPNAME,CORPCODE,CERTTYPENUM,CERTID,"
					+ "TRADETYPENUM,TRADEBOUNDNUM,TITLELEVELNUM,NOTEDATE,ADDTYPENUM,CORPID,OLDORNEW,DATASOURCE,"
					+ "qualifType,approvalDept,approvalStaff,ultimateOpinion,APPROVALSTAFFID,APPROVALDEPTNAME,"
					+ "ULTIMATEDATE,ULTIMATERESULTS,economicNum,licenseNum,legalMan,idCardTypeNum,"
					+ "legalManIdCard,legaLManDuty,legaManProtitle,address,CERTDETAILID) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERTDTAI_SEQ.NEXTVAL)");
			
			//��ҵ����
			pstmt.setString(1, newQualification.getCorpName());
			//��֯��������
			pstmt.setString(2, newQualification.getCorpCode());
			//��ҵ����
			pstmt.setInt(3, newQualification.getCretType());
			//֤����
			pstmt.setString(4, "");
			//�����ʸ�����
			pstmt.setInt(5, newQualification.getCretSequence());
			//רҵ���
			pstmt.setInt(6, newQualification.getSpecialtyType());
			//�����ʸ�ȼ�
			pstmt.setInt(7, newQualification.getCretLevel());
			//�״���׼�����ʸ�����
			pstmt.setDate(8, new Date(new java.util.Date().getTime()));
			//�����ʸ�ȡ�÷�ʽ
			pstmt.setString(9, newQualification.getAddTypeNum());
			//��ҵid
			pstmt.setString(10, newQualification.getCorpId());
			//��������
			pstmt.setString(11, "1");
			//ϵͳ��Դ
			pstmt.setString(12, "01");
			//����״̬
			pstmt.setString(13, "8");
			//��������
			pstmt.setString(14, newQualification.getApprovalDept());
			//������
			pstmt.setString(15, newQualification.getApprovalStaff());
			//�������
			pstmt.setString(16, newQualification.getUltimateOpinion());
			//������Id
			pstmt.setString(17, newQualification.getApprovalStaffId());
			//������������
			pstmt.setString(18, newQualification.getApprovalDeptName());
			//����ʱ��
			pstmt.setDate(19, new Date(new java.util.Date().getTime()));
			//�������
			pstmt.setString(20, "8");
			
			
			//��ҵ�Ǽ�ע������
			pstmt.setInt(21, newQualification.getEconomicNum());
			//����Ӫҵִ��ע���
			pstmt.setString(22, newQualification.getLicenseNum());
			//��������������
			pstmt.setString(23, newQualification.getLegalMan());
			//����������֤������
			pstmt.setString(24, newQualification.getIdCardTypeNum());
			//����������֤������
			pstmt.setString(25, newQualification.getLegalManIdCard());
			//����������ְ��
			pstmt.setString(26, newQualification.getLegaLManDuty());
			//����������ְ��
			pstmt.setString(27, newQualification.getLegaManProtitle());
			//��ҵӪҵ��ַ
			pstmt.setString(28, newQualification.getAddress());
			
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	/**
	 * ����ͨ��(��������������������)
	 * @return
	 */
	public void applyUltimateThrough(NewQualification newQualification,String certifiedCode)
	{
		//�ж��Ƿ���������������������轫�����ʵĵͼ��ȼ�ע����
		if( "002".equals(newQualification.getAddTypeNum()) ){
			this.cancalQualification(newQualification.getCorpId(),newQualification.getSpecialtyType(),newQualification.getCretLevel());
		}
		
		try {
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement("update TBQUALIFICATIONAPPLY set qualifType=?,ULTIMATEOPINION=?,"
					+ "APPROVALSTAFF=?,APPROVALSTAFFID=?,ULTIMATEDATE=?,ULTIMATERESULTS=? where NEWQUALID=?");
			pstmt.setString(1,"7");	
			pstmt.setString(2,newQualification.getUltimateOpinion()); //�������
			pstmt.setString(3,newQualification.getApprovalStaff()); //������Ա����
			pstmt.setString(4,newQualification.getApprovalStaffId()); //������ԱId
			pstmt.setDate(5, new Date(new java.util.Date().getTime())); //����ʱ��
			pstmt.setString(6,"7"); //�������
			pstmt.setString(7,newQualification.getNewQualId()); 
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("insert into tbcorpcertdetailinfo(CORPNAME,CORPCODE,CERTTYPENUM,CERTID,"
					+ "TRADETYPENUM,TRADEBOUNDNUM,TITLELEVELNUM,NOTEDATE,ADDTYPENUM,CORPID,OLDORNEW,DATASOURCE,qualifType,"
					+ "approvalDept,approvalStaff,ultimateOpinion,APPROVALSTAFFID,APPROVALDEPTNAME,ULTIMATEDATE,"
					+ "ULTIMATERESULTS,TWOAPPROVALDEPTNAME,TWOAPPROVALDEPT,TWOAPPROVALSTAFF,TWOAPPROVALSTAFFID,"
					+ "ONEULTIMATEOPINION,ONEAPPDATE,ONERESULTS,economicNum,licenseNum,legalMan,idCardTypeNum,"
					+ "legalManIdCard,legaLManDuty,legaManProtitle,address,relationId,CERTDETAILID) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERTDTAI_SEQ.NEXTVAL)");
			
			//��ҵ����
			pstmt.setString(1, newQualification.getCorpName());
			//��֯��������
			pstmt.setString(2, newQualification.getCorpCode());
			//��ҵ����
			pstmt.setInt(3, newQualification.getCretType());
			//֤����
			pstmt.setString(4, certifiedCode);
			//�����ʸ�����
			pstmt.setInt(5, newQualification.getCretSequence());
			//רҵ���
			pstmt.setInt(6, newQualification.getSpecialtyType());
			//�����ʸ�ȼ�
			pstmt.setInt(7, newQualification.getCretLevel());
			//�״���׼�����ʸ�����
			pstmt.setDate(8, new Date(new java.util.Date().getTime()));
			//�����ʸ�ȡ�÷�ʽ
			pstmt.setString(9, newQualification.getAddTypeNum());
			//��ҵid
			pstmt.setString(10, newQualification.getCorpId());
			//��������
			pstmt.setString(11, "1");
			//ϵͳ��Դ
			pstmt.setString(12, "01");
			//����״̬
			pstmt.setString(13, "7");
			//��������
			pstmt.setString(14, newQualification.getApprovalDept());
			//������
			pstmt.setString(15, newQualification.getApprovalStaff());
			//�������
			pstmt.setString(16, newQualification.getUltimateOpinion());
			//������Id
			pstmt.setString(17, newQualification.getApprovalStaffId());
			//������������
			pstmt.setString(18, newQualification.getApprovalDeptName());
			//����ʱ��
			pstmt.setDate(19, new Date(new java.util.Date().getTime()));
			//�������
			pstmt.setString(20, "7");
			//������
			pstmt.setString(21, newQualification.getTwoApprovalDeptName());
			//������Id
			pstmt.setString(22, newQualification.getTwoApprovalDept());
			//������Ա
			pstmt.setString(23, newQualification.getTwoApprovalStaff());
			//������ԱId
			pstmt.setString(24, newQualification.getTwoApprovalStaffId());
			//�������
			pstmt.setString(25, newQualification.getOneUltimateOpinion());
			//����ʱ��
			pstmt.setDate(26, newQualification.getOneAppDate());
			//������
			pstmt.setString(27, newQualification.getOneResults());
			
			//��ҵ�Ǽ�ע������
			pstmt.setInt(28, newQualification.getEconomicNum());
			//����Ӫҵִ��ע���
			pstmt.setString(29, newQualification.getLicenseNum());
			//��������������
			pstmt.setString(30, newQualification.getLegalMan());
			//����������֤������
			pstmt.setString(31, newQualification.getIdCardTypeNum());
			//����������֤������
			pstmt.setString(32, newQualification.getLegalManIdCard());
			//����������ְ��
			pstmt.setString(33, newQualification.getLegaLManDuty());
			//����������ְ��
			pstmt.setString(34, newQualification.getLegaManProtitle());
			//��ҵӪҵ��ַ
			pstmt.setString(35, newQualification.getAddress());
			pstmt.setString(36, newQualification.getNewQualId());
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("insert into TBCORPCERTINFO(CORPNAME,CORPCODE,CERTTYPENUM,CERTID,"
					+ "TITLELEVELNUM,ORGANNAME,CERTNAME,APPROVALDEPT,APPROVALSTAFF,APPROVALSTAFFID,ULTIMATEDATE,"
					+ "CRETGRADE,ADDTYPENUM,LICENSENUM,APPROVALDEPTNAME,PROVINCENUM,CITYNUM,COUNTYNUM,ADDRESS,"
					+ "LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,LEGAMANPROTITLE,ECONOMICNUM,REGPRIN,"
					+ "ISVALID,corpId,relationId,WRITEOFFTYPE,CORPCERTID) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERTDTAI_SEQ.NEXTVAL)");

			//��ҵ����
			pstmt.setString(1, newQualification.getCorpName());
			//��֯��������
			pstmt.setString(2, newQualification.getCorpCode());
			//�����ʸ�����
			pstmt.setInt(3, newQualification.getCretType());
			//֤����
			pstmt.setString(4, certifiedCode);
			//�����ʸ���ߵȼ�
			pstmt.setInt(5, newQualification.getCretLevel());
			//��֤����
//			if(newQualification.getCretGrade().equals("1"))
//			{
//				pstmt.setString(6, "�л����񹲺͹�ס���ͳ��罨�貿");
//			}else if(newQualification.getCretGrade().equals("2"))
//			{
//				pstmt.setString(6, "������ʡס����");
//			}else
//			{
//				pstmt.setString(6, newQualification.getCityName()+"�����");
//			}
			pstmt.setString(6, "�л����񹲺͹�ס���ͳ��罨�貿");
			//������𼰵ȼ�
			pstmt.setString(7, newQualification.getCertName());
			//��������
			pstmt.setString(8, newQualification.getApprovalDept());
			//������
			pstmt.setString(9, newQualification.getApprovalStaff());
			//������Id
			pstmt.setString(10, newQualification.getApprovalStaffId());
			//����ʱ��
			pstmt.setDate(11, new Date(new java.util.Date().getTime()));
			//���ʼ���
			pstmt.setString(12, newQualification.getCretGrade());
			//�����ʸ�ȡ�÷�ʽ
			pstmt.setString(13, newQualification.getAddTypeNum());
			//����Ӫҵִ��ע���
			pstmt.setString(14, newQualification.getLicenseNum());
			//������������
			pstmt.setString(15, newQualification.getApprovalDeptName());
			pstmt.setString(16, newQualification.getProvinceNum());//ע������ʡ(��������ֱϽ��)(�ֵ����TBXZQDMDIC)
			pstmt.setString(17, newQualification.getCityNum());//ע�����ڵ�(�С��ݡ���)(�ֵ����TBXZQDMDIC)
			pstmt.setString(18, newQualification.getCountyNum());//ע��������(�����С���)(�ֵ����TBXZQDMDIC)
			pstmt.setString(19, newQualification.getAddress());//��ҵӪҵ��ַ
			pstmt.setString(20, newQualification.getLegalMan());//��������������
			pstmt.setString(21, newQualification.getIdCardTypeNum());//����������֤������(�ֵ����TBIDCARDTYPEDIC)
			pstmt.setString(22, newQualification.getLegalManIdCard());//����������֤������
			pstmt.setString(23, newQualification.getLegaLManDuty());//����������ְ��
			pstmt.setString(24, newQualification.getLegaManProtitle());//����������ְ��
			pstmt.setInt(25, newQualification.getEconomicNum());//��ҵ�Ǽ�ע������(�ֵ����TBECONTYPEDIC)
			pstmt.setString(26, newQualification.getRegPrin());//ע���ʱ�
//			pstmt.setDate(27, new Date(new java.util.Date().getTime()));//��֤����
//			pstmt.setDate(28, UtilDate.getStringChangeDate());//֤����Ч��ֹ����
			pstmt.setInt(27, 1);//֤��״̬
			pstmt.setString(28, newQualification.getCorpId());
			pstmt.setString(29, newQualification.getNewQualId());
			pstmt.setString(30, "0");
			pstmt.executeUpdate();
			conn.commit();
			this.applyUltimateThroughBase(newQualification,certifiedCode);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	/**
	 * �������ݿ����������Ϣ (��������������������)
	 * @return
	 */
	public void applyUltimateThroughBase(NewQualification newQualification,String certifiedCode)
	{
		
		try {
			baseConn = ConnectionFactory.getBasicConnection();
			baseConn.setAutoCommit(false);
			basePstmt = baseConn.prepareStatement("insert into tbcorpcertdetailinfo(CORPNAME,CORPCODE,CERTTYPENUM,"
					+ "CERTID,"
					+ "TRADETYPENUM,TRADEBOUNDNUM,TITLELEVELNUM,NOTEDATE,ADDTYPENUM,CORPID,OLDORNEW,DATASOURCE,qualifType,"
					+ "approvalDept,approvalStaff,ultimateOpinion,APPROVALSTAFFID,APPROVALDEPTNAME,ULTIMATEDATE,"
					+ "ULTIMATERESULTS,TWOAPPROVALDEPTNAME,TWOAPPROVALDEPT,TWOAPPROVALSTAFF,TWOAPPROVALSTAFFID,"
					+ "ONEULTIMATEOPINION,ONEAPPDATE,ONERESULTS,economicNum,licenseNum,legalMan,idCardTypeNum,"
					+ "legalManIdCard,legaLManDuty,legaManProtitle,address,RELATIONID,CERTDETAILID) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERTDTAI_SEQ.NEXTVAL)");
			//��ҵ����
			basePstmt.setString(1, newQualification.getCorpName());
			//��֯��������
			basePstmt.setString(2, newQualification.getCorpCode());
			//��ҵ����
			basePstmt.setInt(3, newQualification.getCretType());
			//֤����
			basePstmt.setString(4, certifiedCode);
			//�����ʸ�����
			basePstmt.setInt(5, newQualification.getCretSequence());
			//רҵ���
			basePstmt.setInt(6, newQualification.getSpecialtyType());
			//�����ʸ�ȼ�
			basePstmt.setInt(7, newQualification.getCretLevel());
			//�״���׼�����ʸ�����
			basePstmt.setDate(8, new Date(new java.util.Date().getTime()));
			//�����ʸ�ȡ�÷�ʽ
			basePstmt.setString(9, newQualification.getAddTypeNum());
			//��ҵid
			basePstmt.setString(10, newQualification.getCorpId());
			//��������
			basePstmt.setString(11, "1");
			//ϵͳ��Դ
			basePstmt.setString(12, "01");
			//����״̬
			basePstmt.setString(13, "7");
			//��������
			basePstmt.setString(14, newQualification.getApprovalDept());
			//������
			basePstmt.setString(15, newQualification.getApprovalStaff());
			//�������
			basePstmt.setString(16, newQualification.getUltimateOpinion());
			//������Id
			basePstmt.setString(17, newQualification.getApprovalStaffId());
			//������������
			basePstmt.setString(18, newQualification.getApprovalDeptName());
			//����ʱ��
			basePstmt.setDate(19, new Date(new java.util.Date().getTime()));
			//�������
			basePstmt.setString(20, "7");
			//������
			basePstmt.setString(21, newQualification.getTwoApprovalDeptName());
			//������Id
			basePstmt.setString(22, newQualification.getTwoApprovalDept());
			//������Ա
			basePstmt.setString(23, newQualification.getTwoApprovalStaff());
			//������ԱId
			basePstmt.setString(24, newQualification.getTwoApprovalStaffId());
			//�������
			basePstmt.setString(25, newQualification.getOneUltimateOpinion());
			//����ʱ��
			basePstmt.setDate(26, newQualification.getOneAppDate());
			//������
			basePstmt.setString(27, newQualification.getOneResults());
			//��ҵ�Ǽ�ע������
			basePstmt.setInt(28, newQualification.getEconomicNum());
			//����Ӫҵִ��ע���
			basePstmt.setString(29, newQualification.getLicenseNum());
			//��������������
			basePstmt.setString(30, newQualification.getLegalMan());
			//����������֤������
			basePstmt.setString(31, newQualification.getIdCardTypeNum());
			//����������֤������
			basePstmt.setString(32, newQualification.getLegalManIdCard());
			//����������ְ��
			basePstmt.setString(33, newQualification.getLegaLManDuty());
			//����������ְ��
			basePstmt.setString(34, newQualification.getLegaManProtitle());
			//��ҵӪҵ��ַ
			basePstmt.setString(35, newQualification.getAddress());
			basePstmt.setString(36, newQualification.getNewQualId());
			basePstmt.executeUpdate();
			
			basePstmt = baseConn.prepareStatement("insert into TBCORPCERTINFO(CORPNAME,CORPCODE,CERTTYPENUM,CERTID,"
					+ "TITLELEVELNUM,ORGANNAME,CERTNAME,APPROVALDEPT,APPROVALSTAFF,APPROVALSTAFFID,ULTIMATEDATE,"
					+ "CRETGRADE,ADDTYPENUM,LICENSENUM,APPROVALDEPTNAME,PROVINCENUM,CITYNUM,COUNTYNUM,ADDRESS,"
					+ "LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,LEGAMANPROTITLE,ECONOMICNUM,REGPRIN,"
					+ "OLDORNEW,DATASOURCE,ISVALID,corpId,RELATIONID,WRITEOFFTYPE,CORPCERTID) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERTDTAI_SEQ.NEXTVAL)");

			//��ҵ����
			basePstmt.setString(1, newQualification.getCorpName());
			//��֯��������
			basePstmt.setString(2, newQualification.getCorpCode());
			//�����ʸ�����
			basePstmt.setInt(3, newQualification.getCretType());
			//֤����
			basePstmt.setString(4, certifiedCode);
			//�����ʸ���ߵȼ�
			basePstmt.setInt(5, newQualification.getCretLevel());
			//��֤����
//			if(newQualification.getCretGrade().equals("1"))
//			{
//				basePstmt.setString(6, "�л����񹲺͹�ס���ͳ��罨�貿");
//			}else if(newQualification.getCretGrade().equals("2"))
//			{
//				basePstmt.setString(6, "������ʡ������");
//			}else
//			{
//				basePstmt.setString(6, newQualification.getCityName()+"�����");
//			}
			basePstmt.setString(6, "�л����񹲺͹�ס���ͳ��罨�貿");
			//������𼰵ȼ�
			basePstmt.setString(7, newQualification.getCertName());
			//��������
			basePstmt.setString(8, newQualification.getApprovalDept());
			//������
			basePstmt.setString(9, newQualification.getApprovalStaff());
			//������Id
			basePstmt.setString(10, newQualification.getApprovalStaffId());
			//����ʱ��
			basePstmt.setDate(11, new Date(new java.util.Date().getTime()));
			//���ʼ���
			basePstmt.setString(12, newQualification.getCretGrade());
			//�����ʸ�ȡ�÷�ʽ
			basePstmt.setString(13, newQualification.getAddTypeNum());
			//����Ӫҵִ��ע���
			basePstmt.setString(14, newQualification.getLicenseNum());
			//������������
			basePstmt.setString(15, newQualification.getApprovalDeptName());
			basePstmt.setString(16, newQualification.getProvinceNum());//ע������ʡ(��������ֱϽ��)(�ֵ����TBXZQDMDIC)
			basePstmt.setString(17, newQualification.getCityNum());//ע�����ڵ�(�С��ݡ���)(�ֵ����TBXZQDMDIC)
			basePstmt.setString(18, newQualification.getCountyNum());//ע��������(�����С���)(�ֵ����TBXZQDMDIC)
			basePstmt.setString(19, newQualification.getAddress());//��ҵӪҵ��ַ
			basePstmt.setString(20, newQualification.getLegalMan());//��������������
			basePstmt.setString(21, newQualification.getIdCardTypeNum());//����������֤������(�ֵ����TBIDCARDTYPEDIC)
			basePstmt.setString(22, newQualification.getLegalManIdCard());//����������֤������
			basePstmt.setString(23, newQualification.getLegaLManDuty());//����������ְ��
			basePstmt.setString(24, newQualification.getLegaManProtitle());//����������ְ��
			basePstmt.setInt(25, newQualification.getEconomicNum());//��ҵ�Ǽ�ע������(�ֵ����TBECONTYPEDIC)
			basePstmt.setString(26, newQualification.getRegPrin());//ע���ʱ�
//			basePstmt.setDate(27, new Date(new java.util.Date().getTime()));//��֤����
//			basePstmt.setDate(28, UtilDate.getStringChangeDate());//֤����Ч��ֹ����
			basePstmt.setString(27, "1");//0�������� 1��������
			basePstmt.setString(28, "01");//������Դϵͳ
			basePstmt.setInt(29, 1);//֤��״̬
			basePstmt.setString(30, newQualification.getCorpId());
			basePstmt.setString(31, newQualification.getNewQualId());
			basePstmt.setString(32, "0");
			basePstmt.executeUpdate();
			
//			//��λɾ��������
//			if(newQualification.getAddTypeNum().equals("007"))
//			{
//				basePstmt = baseConn.prepareStatement("delete from tbcorpcertdetailinfo where CORPID=? and TITLELEVELNUM=? "
//						+ "and TRADEBOUNDNUM=? and OLDORNEW=?");
//				basePstmt.setString(1, newQualification.getCorpId());//��ҵId
//				basePstmt.setInt(2, newQualification.getCretLevel());//���ʵȼ�
//				basePstmt.setInt(3, newQualification.getSpecialtyType());//�������
//				basePstmt.setString(4, "0");//��������
//				basePstmt.executeUpdate();
//			}
			
			baseConn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				baseConn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(baseConn, basePstmt, null);
		}
	}
	/**
	 * �����˻�(�������������˻�)
	 * @return
	 */
	public void applyUltimateThroughBack(NewQualification newQualification)
	{
		try {
			
			conn = ConnectionFactory.getQualityConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement("update TBQUALIFICATIONAPPLY set qualifType=?,ULTIMATEOPINION=?,"
					+ "APPROVALSTAFF=?,APPROVALSTAFFID=?,ULTIMATEDATE=?,ULTIMATERESULTS=? where NEWQUALID=?");
			pstmt.setString(1,"8");	
			pstmt.setString(2,newQualification.getUltimateOpinion()); //�������
			pstmt.setString(3,newQualification.getApprovalStaff()); //������Ա����
			pstmt.setString(4,newQualification.getApprovalStaffId()); //������ԱId
			pstmt.setDate(5, new Date(new java.util.Date().getTime())); //����ʱ��
			pstmt.setString(6,"8"); //�������
			pstmt.setString(7,newQualification.getNewQualId()); 
			pstmt.executeUpdate();
			pstmt = conn.prepareStatement("insert into tbcorpcertdetailinfo(CORPNAME,CORPCODE,CERTTYPENUM,CERTID,"
					+ "TRADETYPENUM,TRADEBOUNDNUM,TITLELEVELNUM,NOTEDATE,ADDTYPENUM,CORPID,OLDORNEW,DATASOURCE,qualifType,"
					+ "approvalDept,approvalStaff,ultimateOpinion,APPROVALSTAFFID,APPROVALDEPTNAME,ULTIMATEDATE,"
					+ "ULTIMATERESULTS,TWOAPPROVALDEPTNAME,TWOAPPROVALDEPT,TWOAPPROVALSTAFF,TWOAPPROVALSTAFFID,"
					+ "ONEULTIMATEOPINION,ONEAPPDATE,ONERESULTS,economicNum,licenseNum,legalMan,idCardTypeNum,"
					+ "legalManIdCard,legaLManDuty,legaManProtitle,address,CERTDETAILID) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERTDTAI_SEQ.NEXTVAL)");
							
			//��ҵ����
			pstmt.setString(1, newQualification.getCorpName());
			//��֯��������
			pstmt.setString(2, newQualification.getCorpCode());
			//��ҵ����
			pstmt.setInt(3, newQualification.getCretType());
			//֤����
			pstmt.setString(4, "");
			//�����ʸ�����
			pstmt.setInt(5, newQualification.getCretSequence());
			//רҵ���
			pstmt.setInt(6, newQualification.getSpecialtyType());
			//�����ʸ�ȼ�
			pstmt.setInt(7, newQualification.getCretLevel());
			//�״���׼�����ʸ�����
			pstmt.setDate(8, new Date(new java.util.Date().getTime()));
			//�����ʸ�ȡ�÷�ʽ
			pstmt.setString(9, newQualification.getAddTypeNum());
			//��ҵid
			pstmt.setString(10, newQualification.getCorpId());
			//��������
			pstmt.setString(11, "1");
			//ϵͳ��Դ
			pstmt.setString(12, "01");
			//����״̬
			pstmt.setString(13, "8");
			//��������
			pstmt.setString(14, newQualification.getApprovalDept());
			//������
			pstmt.setString(15, newQualification.getApprovalStaff());
			//�������
			pstmt.setString(16, newQualification.getUltimateOpinion());
			//������Id
			pstmt.setString(17, newQualification.getApprovalStaffId());
			//������������
			pstmt.setString(18, newQualification.getApprovalDeptName());
			//����ʱ��
			pstmt.setDate(19, new Date(new java.util.Date().getTime()));
			//�������
			pstmt.setString(20, "8");
			//������
			pstmt.setString(21, newQualification.getTwoApprovalDeptName());
			//������Id
			pstmt.setString(22, newQualification.getTwoApprovalDept());
			//������Ա
			pstmt.setString(23, newQualification.getTwoApprovalStaff());
			//������ԱId
			pstmt.setString(24, newQualification.getTwoApprovalStaffId());
			//�������
			pstmt.setString(25, newQualification.getOneUltimateOpinion());
			//����ʱ��
			pstmt.setDate(26, newQualification.getOneAppDate());
			//������
			pstmt.setString(27, newQualification.getOneResults());
			
			//��ҵ�Ǽ�ע������
			pstmt.setInt(28, newQualification.getEconomicNum());
			//����Ӫҵִ��ע���
			pstmt.setString(29, newQualification.getLicenseNum());
			//��������������
			pstmt.setString(30, newQualification.getLegalMan());
			//����������֤������
			pstmt.setString(31, newQualification.getIdCardTypeNum());
			//����������֤������
			pstmt.setString(32, newQualification.getLegalManIdCard());
			//����������ְ��
			pstmt.setString(33, newQualification.getLegaLManDuty());
			//����������ְ��
			pstmt.setString(34, newQualification.getLegaManProtitle());
			//��ҵӪҵ��ַ
			pstmt.setString(35, newQualification.getAddress());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	
	
	/**
	 * ��������
	 * @return
	 */
	public void pushApply(NewQualification newQualification)
	{
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement("update TBQUALIFICATIONAPPLY set qualifType=? where NEWQUALID=?");
			pstmt.setString(1,"2");	
			pstmt.setString(2,newQualification.getNewQualId()); 
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	//��ѯְ����Ա
	public int queryCountTitle(String userId)
	{
		int countTitle = 0;
		try {
			String sql = "select count(*) from v_persontitleinfo where corpId='"+userId+"'";
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				countTitle = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return countTitle;
	}
	
	//��ѯע�Ὠ��ʦ
	public int queryCountConstructor(String userId)
	{
		int countConstructor = 0;
		try {
			String sql = "select count(*) from V_CONSTRUCTOR where corpName='"+userId+"'";
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				countConstructor = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return countConstructor;
	}
	//��ѯ��λ��Ա
	public int queryCountPositions(String corpName)
	{
		int countConstructor = 0;
		try {
			String sql = "select count(*) from Position_Certificate where FEntName='"+corpName.trim()+"'";
			conn = ConnectionFactory.getStaffPositionsConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				countConstructor = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return countConstructor;
	}
	//��ѯ������������
	public int queryCountSkilledworker(String userId)
	{
		int countSkilledworker = 0;
		try {
			String sql = "select count(*) from V_SKILLEDWORKER where corpId='"+userId+"'";
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				countSkilledworker = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return countSkilledworker;
	}
	//��������(�ֵ����TBAPTITUDEKINDDIC)
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

	//���ʵȼ�(�ֵ����TBCERTTITLELEVELDIC)
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

	//��������(�ֵ����TBTRADETYPEDIC)
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

	//����רҵ���(�ֵ����TBTRADETYPEBOUNDDIC)
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
	//���ʼ���(�ֵ����TBCRETGRADEDIC)
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
	//��������(�ֵ����TBADDTYPEDIC)
	public List<DictionaryClass> queryAddTypeNums()
	{
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

	//��ѯ����ǰ,ԭ������Ϣ
	public NewQualification queryOldCretLevel(NewQualification newQualification)
	{
		// TODO Auto-generated method stub
//		String sql = "select corpId,corpName,cretLevel,cretLevelName,cretGrade,cretGradeName,specialtyType,"
//				+ "specialtyTypeName,CREATDATE,ULTIMATEDATE from V_QUALIFICATIONAPPLY "
//				+ "where qualifType=? and corpId=? and cretLevel=? and specialtyType=? ";
		int cretLevel = 0;
		if(newQualification.getCretLevel()==76)
		{
			cretLevel = 75;
		}
		if(newQualification.getCretLevel()==77)
		{
			cretLevel=76;
		}
		if(newQualification.getCretLevel()==78)
		{
			cretLevel=77;
		}
		
		String sql = "select corpId,corpName,cretLevel,cretLevelName,cretGrade,cretGradeName,specialtyType,"
				+ "specialtyTypeName,CREATDATE,ULTIMATEDATE from V_QUALIFICATIONAPPLY "
				+ "where corpId='"+newQualification.getCorpId()+"' "
				+ "and cretLevel='"+cretLevel+"' "
				+ "and specialtyType='"+newQualification.getSpecialtyType()+"' "
				+ "and ( qualifType=5 or qualifType=9 )";
		
		System.out.println("sql ="+sql);
		try {
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, "5");
//			pstmt.setString(2, newQualification.getCorpId());
//			if(newQualification.getCretLevel()==76)
//			{
//				pstmt.setInt(3, 75);
//			}
//			if(newQualification.getCretLevel()==77)
//			{
//				pstmt.setInt(3, 76);
//			}
//			if(newQualification.getCretLevel()==78)
//			{
//				pstmt.setInt(3, 77);
//			}
//			pstmt.setInt(4, newQualification.getSpecialtyType());
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				newQualification.setCorpId(rs.getString("corpId"));
				newQualification.setCorpName(rs.getString("corpName"));
				newQualification.setOldCretLevel(rs.getInt("cretLevel"));
				newQualification.setOldCretLevelName(rs.getString("cretLevelName"));
				newQualification.setOldCretGrade(rs.getString("cretGrade"));
				newQualification.setOldCretGradeName(rs.getString("cretGradeName"));
				newQualification.setOldSpecialtyType(rs.getInt("specialtyType"));
				newQualification.setOldSpecialtyTypeName(rs.getString("specialtyTypeName"));
				newQualification.setOldCreatDate(rs.getDate("CREATDATE"));
				newQualification.setOldUltimateDate(rs.getDate("ULTIMATEDATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return newQualification;
	}
	
	//����ids�������ύ�����ʷ�������
	public List<NewQualification> queryQualification(String[] ids)
	{
		List<NewQualification> list = new ArrayList<NewQualification>();
		try {
			for(int i=0;i<ids.length;i++)
			{
				String sql = "select * from V_QUALIFICATIONAPPLY where newQualId='"+ids[i]+"'";
				conn = ConnectionFactory.getQualityConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					NewQualification certifiedService = new NewQualification();
					//����
					certifiedService.setNewQualId(rs.getString("newQualId").trim());
					//��ҵ����
					certifiedService.setCorpId(rs.getString("corpId").trim());
					//��ҵ����
					certifiedService.setCorpName(rs.getString("corpName").trim());
					//��ҵסַ��������֤
					certifiedService.setCorpCode(rs.getString("corpCode").trim());
					//��ҵ����ʡ(��������ֱϽ��)(�ֵ����TBXZQDMDIC)
					certifiedService.setProvinceNum(rs.getString("provinceNum").trim());
					//��ҵ����ʡ����
					certifiedService.setProvinceName(rs.getString("provinceName").trim());
					//��ҵ���ڵ�(�С��ݡ���)(�ֵ����TBXZQDMDIC)
					certifiedService.setCityNum(rs.getString("cityNum").trim());
					//��ҵ����������
					certifiedService.setCityName(rs.getString("cityName").trim());
					//��ҵ������(�����С���)(�ֵ����TBXZQDMDIC)
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
					//��������Id
					certifiedService.setApprovalDept(rs.getString("approvalDept").trim());
					//������������
					certifiedService.setApprovalDeptName(rs.getString("approvalDeptName").trim());
					//��ҵ�Ǽ�ע������
					certifiedService.setEconomicNum(rs.getInt("economicNum"));
					//������������
					certifiedService.setTwoApprovalDept(rs.getString("twoApprovalDept").trim());
					//����������������
					certifiedService.setTwoApprovalDeptName(rs.getString("twoApprovalDeptName").trim());
					//������Ա
					certifiedService.setTwoApprovalStaff(rs.getString("twoApprovalStaff"));
					//������ԱId
					certifiedService.setTwoApprovalStaffId(rs.getString("twoApprovalStaffId"));
					//����ʱ��
					certifiedService.setOneAppDate(rs.getDate("oneAppDate"));
					//����״̬
					certifiedService.setOneResults(rs.getString("oneResults"));
					//������
					certifiedService.setOneUltimateOpinion(rs.getString("oneUltimateOpinion"));
					//��ҵ�Ǽ�ע������
					certifiedService.setEconomicNum(rs.getInt("economicNum"));
					//����Ӫҵִ��ע���
					certifiedService.setLicenseNum(rs.getString("licenseNum"));
					//��������������
					certifiedService.setLegalMan(rs.getString("legalMan"));
					//����������֤������
					certifiedService.setIdCardTypeNum(rs.getString("idCardTypeNum"));
					//����������֤������
					certifiedService.setLegalManIdCard(rs.getString("legalManIdCard"));
					//����������ְ��
					certifiedService.setLegaLManDuty(rs.getString("legaLManDuty"));
					//����������ְ��
					certifiedService.setLegaManProtitle(rs.getString("legaManProtitle"));
					//��ҵӪҵ��ַ
					certifiedService.setAddress(rs.getString("address"));
					//ע���ʱ�
					certifiedService.setRegPrin(rs.getString("REGPRIN"));
					list.add(certifiedService);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	/**
	 * ��ѯ֤�����Ƿ��Ѵ���
	 */
	@Override
	public String queryCertId(NewQualification newQualification) {
		String certId = "";
		try {
			String sql = "select CERTID from tbcorpcertinfo where cretgrade=1 and ISVALID=1 "
					+ "and corpId=? and endDate>=?";
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newQualification.getCorpId());
			pstmt.setDate(2, new Date(new java.util.Date().getTime()));
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				certId = rs.getString("CERTID");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return certId;
	}
}
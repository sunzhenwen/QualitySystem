package com.tj.jst.outside.businessReport.qualitychange.action;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.notforeign.model.CertifiedCorp;
import com.tj.jst.inner.notforeign.service.CertifiedCorpServiceImpl;
import com.tj.jst.inner.notforeign.service.ICertifiedCorpService;
import com.tj.jst.inner.system.servicecertdetailinfo.model.CertifiedService;
import com.tj.jst.login.model.Login;
import com.tj.jst.outside.businessReport.newQualification.service.INewQualificationService;
import com.tj.jst.outside.businessReport.newQualification.service.NewQualificationServiceImpl;
import com.tj.jst.outside.businessReport.qualitychange.condition.QualityChangeCorpCondition;
import com.tj.jst.outside.businessReport.qualitychange.model.TB_QUALITY_CHANGE;
import com.tj.jst.outside.businessReport.qualitychange.service.QualityChangeService;
import com.tj.jst.outside.businessReport.qualitychange.service.QualityChangeServiceImpl;
import com.tj.jst.outside.businessReport.qualitychange.util.Tools;
import com.tj.jst.outside.corpinto.notforeign.service.CorpServiceImpl;
import com.tj.jst.outside.corpinto.notforeign.service.ICorpService;

/**
 * ��ҵ���ʱ��
 * @author Libs
 *
 */
@SuppressWarnings("serial")
public class QualityChangeAction extends BaseAction {
	
	private String corpName;//��ҵ����
	private String[] certIds;//��������ids
	private List<CertifiedService> certifieds;//��������list
	private String message;//��ʾ��Ϣ
	private String qualityChangeId;//��ʾ��Ϣ
	private CertifiedCorp corp;
	private String approvalSuggest;
	private TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
	private Login login = new Login();
	private List<TB_QUALITY_CHANGE> qualityChangeList;
	private String state;
	//����������֤������
	private List<DictionaryClass> idCardType;
	//��ҵ�Ǽ�ע������
	private List<DictionaryClass> economicNum;
	
	
	private QualityChangeCorpCondition condition = new QualityChangeCorpCondition();

	public void setCondition(QualityChangeCorpCondition condition) {
		this.condition = condition;
	}

	public QualityChangeCorpCondition getCondition() {
		QualityChangeCorpCondition sessionCondition = (QualityChangeCorpCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}
	
	
//	private QualityChangeQueryCondition queryCondition = new QualityChangeQueryCondition();


//	public void setQueryCondition(QualityChangeQueryCondition queryCondition) 
//	{
//		this.queryCondition = queryCondition;
//	}
//
//	public QualityChangeQueryCondition getQueryCondition() 
//	{
//		QualityChangeQueryCondition sessionCondition = (QualityChangeQueryCondition) get(getActionName());
//		if (sessionCondition != null) 
//		{
//			queryCondition = sessionCondition;
//		}
//		return queryCondition;
//	}
	
	
	
	public String queryCorpQualityChange(){
		QualityChangeService qualityChangeService=new QualityChangeServiceImpl(); 
		String corpId = (String)this.get("corpId");
		this.getCondition().setCorpId(corpId);
		currentPage = qualityChangeService.corpQualityChangeQuery(this.getCondition());
		this.set(getActionName(), condition);
		return "corpQualityChangeListPage";
    }
	
	/**
	 * ��ת�����б�ҳ
	 * @return
	 * @throws Exception
	 */
	public String showQualityList(){
		QualityChangeService qualityChangeService=new QualityChangeServiceImpl(); 
		corpName = ((Login)this.get("login")).getUserName();
		String corpid = ((Login)this.get("login")).getUserId();
		
		certifieds=qualityChangeService.queryQualityList(corpid);
		
//		for (int i=0;i<certifieds.size();i++){
//			System.out.println("certifieds.getCertId----------"+certifieds.get(i).getCertId());
//			System.out.println("certifieds.getCertName----------"+certifieds.get(i).getCertName());
//			System.out.println("certifieds.getCretGrade----------"+certifieds.get(i).getCretGrade());
//		}
			
		return "showQualityListPage";
    }
	/**
	 * ��ת���ʱ��ҳ
	 * @return
	 * @throws Exception
	 */
	public String showQualityChangePage()
	{
		ICertifiedCorpService corpService = new CertifiedCorpServiceImpl();
		QualityChangeService qualityChangeService=new QualityChangeServiceImpl();
		ICorpService corpService1 = new CorpServiceImpl();
		//֤������
		idCardType = corpService.queryIdCardType();
		login = (Login)this.get("login");
		corp = corpService.queryCorp(login.getUserId());
		//��ҵ�Ǽ�ע������
		economicNum = corpService1.queryEconomicNum();
		certifieds=qualityChangeService.queryQualityList(login.getUserId());
		//	System.out.println("certIds.length----------"+certIds.length);
		if(certifieds.size()>0)
		{
			return "showQualityChangePage";
		}
		else 
		{
			return showQualityList();
		}
		
		
    }
	
	/**
	 * �������ʱ������
	 * @return
	 * @throws Exception
	 */
	public String addQualityChange(){
		//TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
		ICertifiedCorpService corpService = new CertifiedCorpServiceImpl();
		QualityChangeService qualityChangeService=new QualityChangeServiceImpl(); 
		login = (Login)this.get("login");		
		corp = corpService.queryCorp(login.getUserId());
		String corpid = ((Login)this.get("login")).getUserId();
		
		List<CertifiedService> certifiedServiceList=qualityChangeService.queryQualityList(corpid);
		
//		for(CertifiedService tmp:certifieds)
//		{
//			cretGradeList.add(tmp.getCretGrade());
//		}
		List<String> cretGradeList=new ArrayList<String>();
		for(int i=0;i<certifiedServiceList.size();i++)
		{
			cretGradeList.add(certifiedServiceList.get(i).getCretGrade());
		}
		//�ȼ�listȥ��ת����String		
		Tools.removeDuplicate(cretGradeList);
		String cretGradeString=listToString(cretGradeList);
		//System.out.println("cretGradeString:"+cretGradeString);//aaa,bbb,ccc
		//System.out.print("qualityChange"+qualityChange.getCHANGE_ECONOMICNUM());
		qualityChange.setQUALITY_CHANGE_ID(UUID.randomUUID().toString());
		qualityChange.setCORPID(corp.getCorpId());
		//ԭ��֯��������
		qualityChange.setOLD_CORPCODE(corp.getCorpCode());
		qualityChange.setCORPNAME(corp.getCorpName());
		qualityChange.setADDRESS(corp.getAddress());
		qualityChange.setECONOMICNUM(corp.getEconomicNum());
		qualityChange.setECONOMICNAME(corp.getEconomicName());
		qualityChange.setLICENSENUM(corp.getLicenseNum());
		qualityChange.setLEGALMAN(corp.getLegalMan());
		qualityChange.setREGPRIN(corp.getRegPrin());
		qualityChange.setSPARE1(corp.getSpare1());
		qualityChange.setSPARENAME(login.getSpareName());
		qualityChange.setCHANGE_SPARENAME(getSpareName(qualityChange.getCHANGE_SPARE1()));
		
		DictionaryClass economic= qualityChangeService.queryEconomicName(qualityChange.getCHANGE_ECONOMICNUM());
		qualityChange.setCHANGE_ECONOMICNAME(economic.getName());//����󾭼�������
		
		//��ʼ��״̬
		qualityChange.setLEVELSET(cretGradeString);;//״̬Ĭ�� 1 ����
		if(isContain(cretGradeString,",1,")){
			qualityChange.setBZ("2");
		}
		if(isContain(cretGradeString,",2,")&&!isContain(cretGradeString,",1,")){
			qualityChange.setBZ("5");
		}
		if(isContain(cretGradeString,",3,")&&!isContain(cretGradeString,",1,")&&!isContain(cretGradeString,",2,")){
			qualityChange.setBZ("8");
		}
		qualityChange.setSTATE("1");//״̬Ĭ�� 1 ����

		if(qualityChange.getIS_CODE_MERGE()!=null&&qualityChange.getIS_CODE_MERGE().length()!=0)
		{
			//System.out.println("�Ƿ������һ:"+qualityChange.getIS_CODE_MERGE());//
			//����֯��������
			qualityChange.setNEW_CORPCODE(qualityChange.getCHANGE_LICENSENUM());
		}
		else
		{	
			qualityChange.setIS_CODE_MERGE("0");
		}
		message = qualityChangeService.addQualityChange(qualityChange);
		return "goBusiness";

    }
	
	
	public String getSpareName(String spare1){
		String spareName="";
		if(spare1.equals("230100"))
		{
			spareName="������";
			return "������";
		}
		if(spare1.equals("230200"))
		{
			spareName="�������";
			return "�������";
		}
		if(spare1.equals("231000"))
		{
			spareName="ĵ����";
			return "ĵ����";
		}
		if(spare1.equals("230600"))
		{
			spareName="����";
			return "����";
		}
		if(spare1.equals("230700"))
		{
			spareName="����";
			return "����";
		}
		if(spare1.equals("230400"))
		{
			spareName="�׸�";
			return "�׸�";
		}
		if(spare1.equals("230800"))
		{
			spareName="��ľ˹";
			return "��ľ˹";
		}
		if(spare1.equals("231100"))
		{
			spareName="�ں�";
			return "�ں�";
		}
		if(spare1.equals("232700"))
		{
			spareName="���˰������";
			return "���˰������";
		}
		if(spare1.equals("400021"))
		{
			spareName="ɭ��";
			return "ɭ��";
		}
		if(spare1.equals("400022"))
		{
			spareName="��Һ�";
			return "��Һ�";
		}
		if(spare1.equals("400023"))
		{
			spareName="��Զ";
			return "��Զ";
		}
		if(spare1.equals("230300"))
		{
			spareName="����";
			return "����";
		}
		if(spare1.equals("400020"))
		{
			spareName="ũ��";
			return "ũ��";
		}
		if(spare1.equals("230900"))
		{
			spareName="��̨��";
			return "��̨��";
		}
		if(spare1.equals("230500"))
		{
			spareName="˫Ѽɽ";
			return "˫Ѽɽ";
		}
		if(spare1.equals("231200"))
		{
			spareName="�绯";
			return "�绯";
		}	
		return spareName;
	}
	
	
	
	//��ѯ����
	public String showQualityChangeInner(){
		QualityChangeService qualityChangeService=new QualityChangeServiceImpl(); 
		
		Login login = (Login)this.get("login");
		String popedomid=login.getPopedomid();
		String city=login.getDepartmentID();
		
		if(isContain(popedomid,",1,")&&!isContain(popedomid,",2,")&&!isContain(popedomid,",3,")){
			qualityChangeList=qualityChangeService.queryQualityChange("1", city);
		}
		if(isContain(popedomid,",2,")&&!isContain(popedomid,",1,")&&!isContain(popedomid,",3,")){
			qualityChangeList=qualityChangeService.queryQualityChange("2", city);
		}	
		if(isContain(popedomid,",3,")&&!isContain(popedomid,",1,")&&!isContain(popedomid,",2,")){
			qualityChangeList=qualityChangeService.queryQualityChange("3", city);
		}
		//���й�������ʡ������Ȩ
		if(isContain(popedomid,",1,")&&isContain(popedomid,",2,")){
			qualityChangeList=qualityChangeService.queryQualityChange("4", city);
		}
		
		
		return "showQualityChangeInner";
    }
	
//	//���ʱ����ѯ
//	public String showQualityChangeQueryInner(){
//		QualityChangeService qualityChangeService=new QualityChangeServiceImpl(); 
//		Login login = (Login)this.get("login");
//		qualityChangeList=qualityChangeService.selectQualityChange(login.getName());
//		return "showQualityChangeQueryInner";
//    }
	
//	//���ʱ����ѯ
//	public String showQualityChangeQueryInner(){
//		QualityChangeService qualityChangeService=new QualityChangeServiceImpl(); 
//
//		currentPage = qualityChangeService.selectQualityChange(this.getQueryCondition());
//		this.set(getActionName(), queryCondition);
//			
//		//qualityChangeList=qualityChangeService.selectQualityChange(login.getName());
//		return "showQualityChangeQueryInner";
//    }
	
	
	
	public String showQueryQualityChangeDetailPage(){
		QualityChangeService qualityChangeService=new QualityChangeServiceImpl(); 
		//qualityChangeList=qualityChangeService.queryQualityChange(qualityChangeId, "3");
		qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);
		return "showQueryQualityChangeQueryInner";
    }
	
	
	public String queryCorpQualityChangeDetail(){
		QualityChangeService qualityChangeService=new QualityChangeServiceImpl(); 
		//qualityChangeList=qualityChangeService.queryQualityChange(qualityChangeId, "3");
		qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);
		return "showCorpQualityChangeDetail";
    }
	
	public String deleteCorpQualityChangeDetail(){
		QualityChangeService qualityChangeService=new QualityChangeServiceImpl(); 
		//qualityChangeList=qualityChangeService.queryQualityChange(qualityChangeId, "3");
		//qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);
		qualityChangeService.deleteQualityChangeById(qualityChangeId);
		
		return queryCorpQualityChange();
    }
	
	
	public String updateQuality(){
		QualityChangeService qualityChangeService=new QualityChangeServiceImpl(); 
		Login login = (Login)this.get("login");
		//qualityChange
		//System.out.println("����QUALITY_CHANGE_ID()"+qualityChangeId+"---state"+state+"Ա����:"+login.getName());
		TB_QUALITY_CHANGE qualityChangeBean=new TB_QUALITY_CHANGE();
		qualityChangeBean=qualityChangeService.queryQualityChangeById(qualityChangeId);
		
		if(state.equals("1"))
		{
			//(,1,)
			if(isContain(qualityChangeBean.getLEVELSET(),",1,")
			&&!isContain(qualityChangeBean.getLEVELSET(),",2,")
			&&!isContain(qualityChangeBean.getLEVELSET(),",3,"))
			{
				TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
				qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
				qualityChange.setSTATE("4");
				qualityChange.setSTAFF_COUNTRY(login.getName());
				qualityChange.setAPPROVALTIME_COUNTRY(Tools.getCurrentDate());
				qualityChange.setAPPROVAL_COUNTRY(approvalSuggest);
				qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
				qualityChangeService.updateQualityChange(qualityChange);
				qualityChangeService.updateQualityCertificate(qualityChange);
			}
			//(,2,)
			if(isContain(qualityChangeBean.getLEVELSET(),",2,")
			&&!isContain(qualityChangeBean.getLEVELSET(),",1,")
			&&!isContain(qualityChangeBean.getLEVELSET(),",3,"))
			{
				TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
				qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
				qualityChange.setSTATE("7");
				qualityChange.setSTAFF_PROVINCE(login.getName());
				qualityChange.setAPPROVALTIME_PROVINCE(Tools.getCurrentDate());
				qualityChange.setAPPROVAL_PROVINCE(approvalSuggest);
				qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
				qualityChangeService.updateQualityChange(qualityChange);
				qualityChangeService.updateQualityCertificate(qualityChange);
			}
			//(,3,)
			if(isContain(qualityChangeBean.getLEVELSET(),",3,")
			&&!isContain(qualityChangeBean.getLEVELSET(),",1,")
			&&!isContain(qualityChangeBean.getLEVELSET(),",2,"))
			{
				TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
				qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
				qualityChange.setSTATE("10");
				qualityChange.setSTAFF_CITY(login.getName());
				qualityChange.setAPPROVALTIME_CITY(Tools.getCurrentDate());
				qualityChange.setAPPROVAL_CITY(approvalSuggest);
				qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
				qualityChangeService.updateQualityChange(qualityChange);				
				qualityChangeService.updateQualityCertificate(qualityChange);
				qualityChangeService.updateCorpBasicInfoSpare(qualityChange);
				//�����޸�ԭspare1��
				qualityChangeService.changeCorpCretInfoSpare(qualityChange);
			}
			//(,1,2,3,)
			if(isContain(qualityChangeBean.getLEVELSET(),",1,")
			&&isContain(qualityChangeBean.getLEVELSET(),",2,")
			&&isContain(qualityChangeBean.getLEVELSET(),",3,"))
			{
				if(qualityChangeBean.getBZ().equals("2"))
				{
					TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
					qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
					qualityChange.setSTATE("4");
					qualityChange.setBZ("5");
					qualityChange.setAPPROVALTIME_COUNTRY(Tools.getCurrentDate());
					qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
					qualityChange.setSTAFF_COUNTRY(login.getName());
					qualityChange.setAPPROVAL_COUNTRY(approvalSuggest);
					qualityChangeService.updateQualityChange(qualityChange);
					qualityChangeService.updateQualityCertificate(qualityChange);
				}
				if(qualityChangeBean.getBZ().equals("5"))
				{
					TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
					qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
					qualityChange.setSTATE("7");
					qualityChange.setBZ("8");
					qualityChange.setSTAFF_PROVINCE(login.getName());
					qualityChange.setAPPROVALTIME_PROVINCE(Tools.getCurrentDate());
					qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
					qualityChange.setAPPROVAL_PROVINCE(approvalSuggest);
					qualityChangeService.updateQualityChange(qualityChange);
					qualityChangeService.updateQualityCertificate(qualityChange);
				}
				if(qualityChangeBean.getBZ().equals("8"))
				{
					TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
					qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
					qualityChange.setSTATE("10");
					qualityChange.setSTAFF_CITY(login.getName());
					qualityChange.setAPPROVALTIME_CITY(Tools.getCurrentDate());
					qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
					qualityChange.setAPPROVAL_CITY(approvalSuggest);
					qualityChangeService.updateQualityChange(qualityChange);
					qualityChangeService.updateQualityCertificate(qualityChange);
					qualityChangeService.updateCorpBasicInfoSpare(qualityChange);
					//�ı乫˾ԭspare1�ķ���
					qualityChangeService.changeCorpCretInfoSpare(qualityChange);
				}
			}
			//(,1,2,)
			if(isContain(qualityChangeBean.getLEVELSET(),",1,")
			&&isContain(qualityChangeBean.getLEVELSET(),",2,")
			&&!isContain(qualityChangeBean.getLEVELSET(),",3,"))
			{
				if(qualityChangeBean.getBZ().equals("2"))
				{
					TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
					qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
					qualityChange.setSTATE("4");
					qualityChange.setBZ("5");
					qualityChange.setSTAFF_COUNTRY(login.getName());
					qualityChange.setAPPROVALTIME_COUNTRY(Tools.getCurrentDate());
					qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
					qualityChange.setAPPROVAL_COUNTRY(approvalSuggest);
					qualityChangeService.updateQualityChange(qualityChange);
					qualityChangeService.updateQualityCertificate(qualityChange);
				}
				if(qualityChangeBean.getBZ().equals("5"))
				{
					TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
					qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
					qualityChange.setSTATE("7");
					qualityChange.setSTAFF_PROVINCE(login.getName());
					qualityChange.setAPPROVALTIME_PROVINCE(Tools.getCurrentDate());
					qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
					qualityChange.setAPPROVAL_PROVINCE(approvalSuggest);
					qualityChangeService.updateQualityChange(qualityChange);
					qualityChangeService.updateQualityCertificate(qualityChange);
				}
			}
			//(,1,3,)
			if(isContain(qualityChangeBean.getLEVELSET(),",1,")
			&&isContain(qualityChangeBean.getLEVELSET(),",3,")
			&&!isContain(qualityChangeBean.getLEVELSET(),",2,"))
			{
				if(qualityChangeBean.getBZ().equals("2"))
				{
					TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
					qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
					qualityChange.setSTATE("4");
					qualityChange.setBZ("8");
					qualityChange.setSTAFF_COUNTRY(login.getName());
					qualityChange.setAPPROVALTIME_COUNTRY(Tools.getCurrentDate());
					qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
					qualityChange.setAPPROVAL_COUNTRY(approvalSuggest);
					qualityChangeService.updateQualityChange(qualityChange);
					qualityChangeService.updateQualityCertificate(qualityChange);
				}
				if(qualityChangeBean.getBZ().equals("8"))
				{
					TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
					qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
					qualityChange.setSTATE("10");
					qualityChange.setSTAFF_CITY(login.getName());
					qualityChange.setAPPROVALTIME_CITY(Tools.getCurrentDate());
					qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
					qualityChange.setAPPROVAL_CITY(approvalSuggest);
					qualityChangeService.updateQualityChange(qualityChange);
					qualityChangeService.updateQualityCertificate(qualityChange);
					qualityChangeService.updateCorpBasicInfoSpare(qualityChange);
					//����ԭspare1�������޸ġ�
					qualityChangeService.changeCorpCretInfoSpare(qualityChange);
				}
			}
			//(,2,3,)
			if(isContain(qualityChangeBean.getLEVELSET(),",2,")
			&&isContain(qualityChangeBean.getLEVELSET(),",3,")
			&&!isContain(qualityChangeBean.getLEVELSET(),",1,"))
			{
				if(qualityChangeBean.getBZ().equals("5"))
				{
					TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
					qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
					qualityChange.setSTATE("7");
					qualityChange.setBZ("8");
					qualityChange.setSTAFF_PROVINCE(login.getName());
					qualityChange.setAPPROVALTIME_PROVINCE(Tools.getCurrentDate());
					qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
					qualityChange.setAPPROVAL_PROVINCE(approvalSuggest);
					qualityChangeService.updateQualityChange(qualityChange);
					qualityChangeService.updateQualityCertificate(qualityChange);
				}
				if(qualityChangeBean.getBZ().equals("8"))
				{
					TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
					qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
					qualityChange.setSTATE("10");
					qualityChange.setSTAFF_CITY(login.getName());
					qualityChange.setAPPROVALTIME_CITY(Tools.getCurrentDate());
					qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
					qualityChange.setAPPROVAL_CITY(approvalSuggest);
					qualityChangeService.updateQualityChange(qualityChange);
					qualityChangeService.updateQualityCertificate(qualityChange);
					qualityChangeService.updateCorpBasicInfoSpare(qualityChange);
					//����ԭspare1�������޸ġ�
					qualityChangeService.changeCorpCretInfoSpare(qualityChange);
				}
			}
		}
		
		if(state.equals("2"))
		{
			//(,1,)
			if(isContain(qualityChangeBean.getLEVELSET(),",1,")
			&&!isContain(qualityChangeBean.getLEVELSET(),",2,")
			&&!isContain(qualityChangeBean.getLEVELSET(),",3,"))
			{
				TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
				qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
				qualityChange.setSTATE("3");
				qualityChange.setSTAFF_COUNTRY(login.getName());
				qualityChange.setAPPROVALTIME_COUNTRY(Tools.getCurrentDate());
				qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
				qualityChangeService.updateQualityChange(qualityChange);
			}
			//(,2,)
			if(isContain(qualityChangeBean.getLEVELSET(),",2,")
			&&!isContain(qualityChangeBean.getLEVELSET(),",1,")
			&&!isContain(qualityChangeBean.getLEVELSET(),",3,"))
			{
				TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
				qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
				qualityChange.setSTATE("6");
				qualityChange.setSTAFF_PROVINCE(login.getName());
				qualityChange.setAPPROVALTIME_PROVINCE(Tools.getCurrentDate());
				qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
				qualityChangeService.updateQualityChange(qualityChange);
			}
			//(,3,)
			if(isContain(qualityChangeBean.getLEVELSET(),",3,")
			&&!isContain(qualityChangeBean.getLEVELSET(),",1,")
			&&!isContain(qualityChangeBean.getLEVELSET(),",2,"))
			{
				TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
				qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
				qualityChange.setSTATE("9");
				qualityChange.setSTAFF_CITY(login.getName());
				qualityChange.setAPPROVALTIME_CITY(Tools.getCurrentDate());
				qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
				qualityChangeService.updateQualityChange(qualityChange);
			}
			//(,1,2,3,)
			if(isContain(qualityChangeBean.getLEVELSET(),",3,")
			&&isContain(qualityChangeBean.getLEVELSET(),",1,")
			&&isContain(qualityChangeBean.getLEVELSET(),",2,"))
			{
				if(qualityChangeBean.getBZ().equals("2"))
				{
					TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
					qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
					qualityChange.setSTATE("3");
					//qualityChange.setBZ("5");
					qualityChange.setSTAFF_COUNTRY(login.getName());
					qualityChange.setAPPROVALTIME_COUNTRY(Tools.getCurrentDate());
					qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
					qualityChangeService.updateQualityChange(qualityChange);
				}
				if(qualityChangeBean.getBZ().equals("5"))
				{
					TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
					qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
					qualityChange.setSTATE("6");
					//qualityChange.setBZ("9");
					qualityChange.setSTAFF_PROVINCE(login.getName());
					qualityChange.setAPPROVALTIME_PROVINCE(Tools.getCurrentDate());
					qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
					qualityChangeService.updateQualityChange(qualityChange);
				}
				if(qualityChangeBean.getBZ().equals("8"))
				{
					TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
					qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
					qualityChange.setSTATE("9");
					qualityChange.setSTAFF_CITY(login.getName());
					qualityChange.setAPPROVALTIME_CITY(Tools.getCurrentDate());
					qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
					qualityChangeService.updateQualityChange(qualityChange);
				}
			}
			//(,1,2,)
			if(isContain(qualityChangeBean.getLEVELSET(),",1,")
			&&isContain(qualityChangeBean.getLEVELSET(),",2,")
			&&!isContain(qualityChangeBean.getLEVELSET(),",3,"))
			{
				if(qualityChangeBean.getBZ().equals("2"))
				{
					TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
					qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
					qualityChange.setSTATE("3");
					//qualityChange.setBZ("5");
					qualityChange.setSTAFF_COUNTRY(login.getName());
					qualityChange.setAPPROVALTIME_COUNTRY(Tools.getCurrentDate());
					qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
					qualityChangeService.updateQualityChange(qualityChange);
				}
				if(qualityChangeBean.getBZ().equals("5"))
				{
					TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
					qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
					qualityChange.setSTATE("6");
					qualityChange.setSTAFF_PROVINCE(login.getName());
					qualityChange.setAPPROVALTIME_PROVINCE(Tools.getCurrentDate());
					qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
					qualityChangeService.updateQualityChange(qualityChange);
				}
			}
			//(,1,3,)
			if(isContain(qualityChangeBean.getLEVELSET(),",1,")
			&&isContain(qualityChangeBean.getLEVELSET(),",3,")
			&&!isContain(qualityChangeBean.getLEVELSET(),",2,"))
			{
				if(qualityChangeBean.getBZ().equals("2"))
				{
					TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
					qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
					qualityChange.setSTATE("3");
					//qualityChange.setBZ("8");
					qualityChange.setSTAFF_COUNTRY(login.getName());
					qualityChange.setAPPROVALTIME_COUNTRY(Tools.getCurrentDate());
					qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
					qualityChangeService.updateQualityChange(qualityChange);
				}
				if(qualityChangeBean.getBZ().equals("8"))
				{
					TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
					qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
					qualityChange.setSTATE("9");
					qualityChange.setSTAFF_CITY(login.getName());
					qualityChange.setAPPROVALTIME_CITY(Tools.getCurrentDate());
					qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
					qualityChangeService.updateQualityChange(qualityChange);
				}
			}
			//(,2,3,)
			if(isContain(qualityChangeBean.getLEVELSET(),",2,")
			&&isContain(qualityChangeBean.getLEVELSET(),",3,")
			&&!isContain(qualityChangeBean.getLEVELSET(),",1,"))
			{
				if(qualityChangeBean.getBZ().equals("5"))
				{
					TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
					qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
					qualityChange.setSTATE("6");
					//qualityChange.setBZ("8");
					qualityChange.setSTAFF_PROVINCE(login.getName());
					qualityChange.setAPPROVALTIME_PROVINCE(Tools.getCurrentDate());
					qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
					qualityChangeService.updateQualityChange(qualityChange);
				}
				if(qualityChangeBean.getBZ().equals("8"))
				{
					TB_QUALITY_CHANGE qualityChange=new TB_QUALITY_CHANGE();
					qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);;
					qualityChange.setSTATE("9");
					qualityChange.setSTAFF_CITY(login.getName());
					qualityChange.setAPPROVALTIME_CITY(Tools.getCurrentDate());
					qualityChange.setUPDATE_TIME(Tools.getCurrentDate());
					qualityChangeService.updateQualityChange(qualityChange);
				}
			}
		}
		
		return "update_success";
    }
	
	public String showQualityChangeDetailPage(){
		QualityChangeService qualityChangeService=new QualityChangeServiceImpl(); 
		
		qualityChange=qualityChangeService.queryQualityChangeById(qualityChangeId);
	
		//System.out.println("----------qualityChangeList:"+qualityChangeList.size());
		return "showQualityChangeDetailInner";
    }
	
    //�Ƿ����
    public boolean isContain(String s1,String s2) 
    {
    	return s1.contains(s2);
    }
       
    //���ŷָ�
    public String listToString(List<String> stringList){
        if (stringList==null) {
            return null;
        }
        StringBuilder result=new StringBuilder();
        result.append(",");
        boolean flag=false;
        for (String string : stringList) {
            if (flag) {
                result.append(",");
            }else {
                flag=true;
            }
            result.append(string);
        }
        result.append(",");
        return result.toString();
    }
	
	
	/**
	 * ��������������ʷ��������ѯҳ��
	 * 
	 * @return
	 * @throws Exception
	 */
	public String queryCertifiedService()throws Exception{
		INewQualificationService newQualificationService = new NewQualificationServiceImpl();
				
		corpName = ((Login)this.get("login")).getUserName();
		
			String corpid = ((Login)this.get("login")).getUserId();
		    //certifieds = newQualificationService.queryCertifiedService(check, corpid, addTypeNum);			
	
		return "certifiedServicePage";
    }

	/**
	 * ���ʷ��������ύ
	 * @return
	 * @throws Exception
	 */
//	public String submitCertifiedService()throws Exception{
//		INewQualificationService newQualificationService = new NewQualificationServiceImpl();
//		Login login = (Login)this.get("login");
//		message = newQualificationService.submitCertifiedService(login,certIds,addTypeNum);
//		return "goBusiness";
//    }
//	
	public List<CertifiedService> getCertifieds() {
		return certifieds;
	}

	public void setCertifieds(List<CertifiedService> certifieds) {
		this.certifieds = certifieds;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String[] getCertIds() {
		return certIds;
	}

	public void setCertIds(String[] certIds) {
		this.certIds = certIds;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	public CertifiedCorp getCorp() {
		return corp;
	}
	public void setCorp(CertifiedCorp corp) {
		this.corp = corp;
	}
	public List<DictionaryClass> getIdCardType() {
		return idCardType;
	}
	public void setIdCardType(List<DictionaryClass> idCardType) {
		this.idCardType = idCardType;
	}
	public List<DictionaryClass> getEconomicNum() {
		return economicNum;
	}
	public void setEconomicNum(List<DictionaryClass> economicNum) {
		this.economicNum = economicNum;
	}
	public TB_QUALITY_CHANGE getQualityChange() {
		return qualityChange;
	}
	public void setQualityChange(TB_QUALITY_CHANGE qualityChange) {
		this.qualityChange = qualityChange;
	}
//	public String getCHANGE_CORPNAME() {
//		return CHANGE_CORPNAME;
//	}
//	public void setCHANGE_CORPNAME(String cHANGE_CORPNAME) {
//		CHANGE_CORPNAME = cHANGE_CORPNAME;
//	}
//	public String getCHANGE_LICENSENUM() {
//		return CHANGE_LICENSENUM;
//	}
//	public void setCHANGE_LICENSENUM(String cHANGE_LICENSENUM) {
//		CHANGE_LICENSENUM = cHANGE_LICENSENUM;
//	}
//	public String getCHANGE_ADDRESS() {
//		return CHANGE_ADDRESS;
//	}
//	public void setCHANGE_ADDRESS(String cHANGE_ADDRESS) {
//		CHANGE_ADDRESS = cHANGE_ADDRESS;
//	}
//	public String getCHANGE_REGPRIN() {
//		return CHANGE_REGPRIN;
//	}
//	public void setCHANGE_REGPRIN(String cHANGE_REGPRIN) {
//		CHANGE_REGPRIN = cHANGE_REGPRIN;
//	}
//	public String getCHANGE_ECONOMICNUM() {
//		return CHANGE_ECONOMICNUM;
//	}
//	public void setCHANGE_ECONOMICNUM(String cHANGE_ECONOMICNUM) {
//		CHANGE_ECONOMICNUM = cHANGE_ECONOMICNUM;
//	}
//	public String getCHANGE_LEGALMAN() {
//		return CHANGE_LEGALMAN;
//	}
//	public void setCHANGE_LEGALMAN(String cHANGE_LEGALMAN) {
//		CHANGE_LEGALMAN = cHANGE_LEGALMAN;
//	}
	public List<TB_QUALITY_CHANGE> getQualityChangeList() {
		return qualityChangeList;
	}
	public void setQualityChangeList(List<TB_QUALITY_CHANGE> qualityChangeList) {
		this.qualityChangeList = qualityChangeList;
	}
	public String getQualityChangeId() {
		return qualityChangeId;
	}
	public void setQualityChangeId(String qualityChangeId) {
		this.qualityChangeId = qualityChangeId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getApprovalSuggest() {
		return approvalSuggest;
	}

	public void setApprovalSuggest(String approvalSuggest) {
		this.approvalSuggest = approvalSuggest;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}





}

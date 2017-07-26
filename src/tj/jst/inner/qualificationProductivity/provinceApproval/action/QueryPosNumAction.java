package com.tj.jst.inner.qualificationProductivity.provinceApproval.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.condition.QuerySkillworkerNumCondition;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.condition.QueryTitleNumCondition;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.IProvinceApprovalService;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.ProvinceApprovalServiceImpl;

/**
 * ��ѯְ����Ա���ж����ظ��ļ�����Ա�͸�λ��Ա
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryPosNumAction extends BaseAction {

	private String corpName;// ��������
	private String idcards;

	/**
	 * ��ѯ�ظ�����Ա��Ϣ
	 * 
	 * @return
	 */
	public String getTitleNum() {
		IProvinceApprovalService service = new ProvinceApprovalServiceImpl();
		try {
			corpName = URLDecoder.decode(corpName,"utf8");
	    } catch (UnsupportedEncodingException e) {
	        throw new RuntimeException("����ת����������ϵ����Ա");
	    } 
		idcards = service.queryPosNum(corpName);
		QueryTitleNumCondition condition = new QueryTitleNumCondition(idcards);
		currentPage = service.titleNum(condition);
		return "queryTitleNumPage";
	}

	/**
	 * ��ѯ�ж��ټ����������ظ���Ϣ
	 * 
	 * @return
	 */
	public String getSkillworkerNum() {
		IProvinceApprovalService service = new ProvinceApprovalServiceImpl();
		try {
			if (corpName != null) {
				corpName = URLDecoder.decode(corpName, "utf8");
			}
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("����ת����������ϵ����Ա");
		}
		idcards = service.queryPosNum(corpName);
		QuerySkillworkerNumCondition condition = new QuerySkillworkerNumCondition(
				idcards);
		currentPage = service.skillworkerNum(condition);
		return "querySkillworkerNumPage";

	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getIdcards() {
		return idcards;
	}

	public void setIdcards(String idcards) {
		this.idcards = idcards;
	}

}

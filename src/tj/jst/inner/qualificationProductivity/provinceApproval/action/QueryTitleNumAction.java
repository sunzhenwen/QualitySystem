package com.tj.jst.inner.qualificationProductivity.provinceApproval.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.condition.QueryPosNumCondition;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.condition.QuerySkillworkerNumCondition;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.IProvinceApprovalService;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.ProvinceApprovalServiceImpl;

/**
 * ��λ��Աҳ���ѯ�ж����ظ��ļ�����Ա��ְ����Ա
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryTitleNumAction extends BaseAction {

	private String corpName;// ��������
	private String idcards;

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
		idcards = service.queryTitleNum(corpName);
		QuerySkillworkerNumCondition condition = new QuerySkillworkerNumCondition(
				idcards);
		currentPage = service.skillworkerNum(condition);
		return "querySkillworkerNumPage";

	}

	/**
	 * ��ѯ�ظ���λ��Ա��Ϣ
	 * 
	 * @return
	 */
	public String getPosNum() {
		IProvinceApprovalService service = new ProvinceApprovalServiceImpl();
		try {
			if (corpName != null) {
				corpName = URLDecoder.decode(corpName, "utf8");
			}
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("����ת����������ϵ����Ա");
		}
		idcards = service.queryTitleNum(corpName);
		QueryPosNumCondition condition = new QueryPosNumCondition(idcards);
		currentPage = service.posNum(condition);
		return "queryPosNumPage";
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

package com.tj.jst.inner.qualificationProductivity.provinceApproval.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.condition.QueryPosNumCondition;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.condition.QueryTitleNumCondition;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.IProvinceApprovalService;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.ProvinceApprovalServiceImpl;

/**
 * �ڼ�����Աҳ���ѯ�ж����ظ��ĸ�λ��Ա��ְ����Ա
 * 
 * @author DarkFlameMaster
 *
 */
public class QuerySkillworkerNumAction extends BaseAction {

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
			if (corpName != null) {
				corpName = URLDecoder.decode(corpName, "utf8");
			}
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("����ת����������ϵ����Ա");
		}
		idcards = service.querySkillworkerNum(corpName);
		QueryTitleNumCondition condition = new QueryTitleNumCondition(idcards);
		currentPage = service.titleNum(condition);
		return "queryTitleNumPage";
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
		idcards = service.querySkillworkerNum(corpName);
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

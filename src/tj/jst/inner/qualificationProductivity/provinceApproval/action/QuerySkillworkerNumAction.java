package com.tj.jst.inner.qualificationProductivity.provinceApproval.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.condition.QueryPosNumCondition;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.condition.QueryTitleNumCondition;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.IProvinceApprovalService;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.ProvinceApprovalServiceImpl;

/**
 * 在技术人员页面查询有多少重复的岗位人员和职称人员
 * 
 * @author DarkFlameMaster
 *
 */
public class QuerySkillworkerNumAction extends BaseAction {

	private String corpName;// 搜索条件
	private String idcards;

	/**
	 * 查询重复的人员信息
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
			throw new RuntimeException("编码转换错误，请联系管理员");
		}
		idcards = service.querySkillworkerNum(corpName);
		QueryTitleNumCondition condition = new QueryTitleNumCondition(idcards);
		currentPage = service.titleNum(condition);
		return "queryTitleNumPage";
	}

	/**
	 * 查询重复岗位人员信息
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
			throw new RuntimeException("编码转换错误，请联系管理员");
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

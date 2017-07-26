package com.tj.jst.inner.qualificationProductivity.provinceApproval.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.condition.QueryPosNumCondition;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.condition.QuerySkillworkerNumCondition;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.IProvinceApprovalService;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.ProvinceApprovalServiceImpl;

/**
 * 岗位人员页面查询有多少重复的技术人员和职称人员
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryTitleNumAction extends BaseAction {

	private String corpName;// 搜索条件
	private String idcards;

	/**
	 * 查询有多少技术工人是重复信息
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
			throw new RuntimeException("编码转换错误，请联系管理员");
		}
		idcards = service.queryTitleNum(corpName);
		QuerySkillworkerNumCondition condition = new QuerySkillworkerNumCondition(
				idcards);
		currentPage = service.skillworkerNum(condition);
		return "querySkillworkerNumPage";

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

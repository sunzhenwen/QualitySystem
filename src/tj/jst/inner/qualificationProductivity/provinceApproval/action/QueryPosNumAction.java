package com.tj.jst.inner.qualificationProductivity.provinceApproval.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.condition.QuerySkillworkerNumCondition;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.condition.QueryTitleNumCondition;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.IProvinceApprovalService;
import com.tj.jst.inner.qualificationProductivity.provinceApproval.service.ProvinceApprovalServiceImpl;

/**
 * 查询职称人员中有多少重复的技术人员和岗位人员
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryPosNumAction extends BaseAction {

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
			corpName = URLDecoder.decode(corpName,"utf8");
	    } catch (UnsupportedEncodingException e) {
	        throw new RuntimeException("编码转换错误，请联系管理员");
	    } 
		idcards = service.queryPosNum(corpName);
		QueryTitleNumCondition condition = new QueryTitleNumCondition(idcards);
		currentPage = service.titleNum(condition);
		return "queryTitleNumPage";
	}

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

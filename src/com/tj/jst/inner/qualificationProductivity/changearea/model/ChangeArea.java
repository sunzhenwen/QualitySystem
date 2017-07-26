package com.tj.jst.inner.qualificationProductivity.changearea.model;

import java.sql.Date;

/**
 * 企业归属地变更Model类
 * 
 * @author DarkFlameMaster
 *
 */
public class ChangeArea {

	private String changeId;// 主键
	private String corpName;// 企业名称
	private String beforeArea;// 变更之前归属地
	private String afterProvinceArea;// 变更之后归属地所在省
	private String afterProvinceCityArea;// 变更之后归属地所在省的地市
	private String afterCityArea;// 变更之后所属地所在市
	private String beforeOp;// 释放部门意见。
	private String afterOp;// 接收部门意见。
	private String lastOp;// 省局意见。
	private String status;// 状态；1：本省企业。2：外省企业。
	private String process;// 审批流程。1：企业刚提交。2：地市审批通过。3：地市审批不通过。4：省厅审批通过。5：省厅审批不通过。
	private String mark;// 不需省厅审批。 0:不需要；1：需要
	private Date beforeDate;// 释放部门审批时间
	private Date afterDate;// 接收部门审批时间
	private Date lastDate;// 省厅审批时间

	public String getChangeId() {
		return changeId;
	}

	public void setChangeId(String changeId) {
		this.changeId = changeId;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getBeforeArea() {
		return beforeArea;
	}

	public void setBeforeArea(String beforeArea) {
		this.beforeArea = beforeArea;
	}

	public String getBeforeOp() {
		return beforeOp;
	}

	public void setBeforeOp(String beforeOp) {
		this.beforeOp = beforeOp;
	}

	public String getAfterOp() {
		return afterOp;
	}

	public void setAfterOp(String afterOp) {
		this.afterOp = afterOp;
	}

	public String getLastOp() {
		return lastOp;
	}

	public void setLastOp(String lastOp) {
		this.lastOp = lastOp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAfterProvinceArea() {
		return afterProvinceArea;
	}

	public void setAfterProvinceArea(String afterProvinceArea) {
		this.afterProvinceArea = afterProvinceArea;
	}

	public String getAfterCityArea() {
		return afterCityArea;
	}

	public void setAfterCityArea(String afterCityArea) {
		this.afterCityArea = afterCityArea;
	}

	public String getProcess() {
		return process;
	}

	public void setProcess(String process) {
		this.process = process;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public Date getBeforeDate() {
		return beforeDate;
	}

	public void setBeforeDate(Date beforeDate) {
		this.beforeDate = beforeDate;
	}

	public Date getAfterDate() {
		return afterDate;
	}

	public void setAfterDate(Date afterDate) {
		this.afterDate = afterDate;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public String getAfterProvinceCityArea() {
		return afterProvinceCityArea;
	}

	public void setAfterProvinceCityArea(String afterProvinceCityArea) {
		this.afterProvinceCityArea = afterProvinceCityArea;
	}

}

package com.tj.jst.inner.qualificationProductivity.innerchangearea.model;

import java.sql.Date;

/**
 * Model¿‡
 * 
 * @author DarkFlameMaster
 *
 */
public class InnerChangeArea {

	private String corpName;
	private String corpCode;
	private String beforeArea;
	private String afterArea;
	private String staffId;
	private String staffName;
	private Date changeDate;

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getCorpCode() {
		return corpCode;
	}

	public void setCorpCode(String corpCode) {
		this.corpCode = corpCode;
	}

	public String getBeforeArea() {
		return beforeArea;
	}

	public void setBeforeArea(String beforeArea) {
		this.beforeArea = beforeArea;
	}

	public String getAfterArea() {
		return afterArea;
	}

	public void setAfterArea(String afterArea) {
		this.afterArea = afterArea;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

}

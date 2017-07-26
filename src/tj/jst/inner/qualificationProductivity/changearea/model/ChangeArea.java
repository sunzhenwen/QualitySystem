package com.tj.jst.inner.qualificationProductivity.changearea.model;

import java.sql.Date;

/**
 * ��ҵ�����ر��Model��
 * 
 * @author DarkFlameMaster
 *
 */
public class ChangeArea {

	private String changeId;// ����
	private String corpName;// ��ҵ����
	private String beforeArea;// ���֮ǰ������
	private String afterProvinceArea;// ���֮�����������ʡ
	private String afterProvinceCityArea;// ���֮�����������ʡ�ĵ���
	private String afterCityArea;// ���֮��������������
	private String beforeOp;// �ͷŲ��������
	private String afterOp;// ���ղ��������
	private String lastOp;// ʡ�������
	private String status;// ״̬��1����ʡ��ҵ��2����ʡ��ҵ��
	private String process;// �������̡�1����ҵ���ύ��2����������ͨ����3������������ͨ����4��ʡ������ͨ����5��ʡ��������ͨ����
	private String mark;// ����ʡ�������� 0:����Ҫ��1����Ҫ
	private Date beforeDate;// �ͷŲ�������ʱ��
	private Date afterDate;// ���ղ�������ʱ��
	private Date lastDate;// ʡ������ʱ��

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

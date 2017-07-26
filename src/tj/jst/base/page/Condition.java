package com.tj.jst.base.page;

import java.io.Serializable;

/**
 * ������ҳ������
 * @author Administrator
 *
 */
public abstract class Condition implements Serializable, Cloneable {

	private static final long serialVersionUID = -7448688547460880575L;

	private String orderByItem = "";  //����
	private String groupByItem = "";  //����
	
	private int pageSize = Page.DEFAULT_PAGE_SIZE;  //ÿҳ�����ļ�¼��
	private int pageNo = 1;  //Ĭ�ϵ�ǰҳ
	
	//��ѯ�������
	public abstract String getInitialSql();
	//��ѯ�������
	public abstract String getCountSql();
	
	public String getCompleteSql() {
		//��ȡ���ݲ�ѯ���
		String completeSql = getInitialSql();
		if (!orderByItem.equals(""))
		{
			//ƴ������
			completeSql += " order by " + orderByItem;
		}
			
		if (!groupByItem.equals(""))
		{
			//ƴ�ӷ���
			completeSql += " group by " + groupByItem;
		}
		return completeSql;
	}
	
	public String getCompleteCountSql() {
		//��ȡ������ѯ���
		String completeCountSql = getCountSql();
		if (!orderByItem.equals(""))
		{
			//ƴ������
			completeCountSql += " order by " + orderByItem;
		}
			
		if (!groupByItem.equals(""))
		{
			//ƴ�ӷ���
			completeCountSql += " group by " + groupByItem;
		}
		return completeCountSql;
	}
	
	public String getGroupByItem() {
		return groupByItem;
	}

	public void setGroupByItem(String groupByItem) {
		this.groupByItem = groupByItem;
	}

	public String getOrderByItem() {
		return orderByItem;
	}

	public void setOrderByItem(String orderByItem) {
		this.orderByItem = orderByItem;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}

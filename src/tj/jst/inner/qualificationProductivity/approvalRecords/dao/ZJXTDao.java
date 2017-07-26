package com.tj.jst.inner.qualificationProductivity.approvalRecords.dao;

import com.tj.jst.inner.qualificationProductivity.approvalRecords.model.ZJT_ZJXT_INS;

public interface ZJXTDao {
	public String insertZjxt_Ins(ZJT_ZJXT_INS zJT_ZJXT_INS);
	
	public String insertZjxt_Ins_Oracle(ZJT_ZJXT_INS zjt_zjxt_ins) ;
	
	public String queryCreateDate(String id);
	
	
	public String updateInsState(String insId,String InsState);
	
	
	public String updateCompleteTime(String insid,String CompleteTime);
	
	
	public String updateRejectReason(String insid,String rejectReason);
	
}

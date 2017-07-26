package com.tj.jst.inner.foreign.dao;

import com.tj.jst.inner.foreign.model.CertifiedForeignCorp;

public interface ICertifiedForeignCorpDao {
	
	//修改外商企业
	public String modifyCorp(CertifiedForeignCorp corp);
	
	//外商企业查询
	public CertifiedForeignCorp queryCorp(String corpId);

}

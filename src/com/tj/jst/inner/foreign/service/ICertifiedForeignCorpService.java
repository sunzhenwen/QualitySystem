package com.tj.jst.inner.foreign.service;

import com.tj.jst.inner.foreign.model.CertifiedForeignCorp;

public interface ICertifiedForeignCorpService {
	
	//外商企业查询
	public CertifiedForeignCorp queryCorp(String corpId);
	//外商企业信息修改
	public String modifyCorp(CertifiedForeignCorp corp);

}

package com.tj.jst.inner.foreign.dao;

import com.tj.jst.inner.foreign.model.CertifiedForeignCorp;

public interface ICertifiedForeignCorpDao {
	
	//�޸�������ҵ
	public String modifyCorp(CertifiedForeignCorp corp);
	
	//������ҵ��ѯ
	public CertifiedForeignCorp queryCorp(String corpId);

}

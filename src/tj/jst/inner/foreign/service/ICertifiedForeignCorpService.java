package com.tj.jst.inner.foreign.service;

import com.tj.jst.inner.foreign.model.CertifiedForeignCorp;

public interface ICertifiedForeignCorpService {
	
	//������ҵ��ѯ
	public CertifiedForeignCorp queryCorp(String corpId);
	//������ҵ��Ϣ�޸�
	public String modifyCorp(CertifiedForeignCorp corp);

}

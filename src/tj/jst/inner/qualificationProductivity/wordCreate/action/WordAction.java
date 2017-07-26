package com.tj.jst.inner.qualificationProductivity.wordCreate.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.tj.jst.inner.qualificationProductivity.floorapproval.model.FloorApproval;
import com.tj.jst.inner.qualificationProductivity.queryfloorapproval.service.IQueryFloorApprovalService;
import com.tj.jst.inner.qualificationProductivity.queryfloorapproval.service.QueryFloorApprovalServiceImpl;
import com.tj.jst.inner.qualificationProductivity.wordCreate.util.WordUtil;
/**
 * @Desc������word
 * @Author���ɽ
 * @Date��2014-1-22����04:52:03
 */

@SuppressWarnings("serial")
public class WordAction  extends ActionSupport{
 private String filePath; //�ļ�·��
 private String fileName; //�ļ�����
 private String fileOnlyName; //�ļ�Ψһ����
 private String newQualId;// ��Ŀ����
 
 /**
  * @Desc������word�ĵ�
  * @Author���ɽ
  * @Date��2014-1-22����07:29:58
  * @return
  */
    public String createWord() {
        /** ������װwordҳ����Ҫ������ */
    	
		IQueryFloorApprovalService service = new QueryFloorApprovalServiceImpl();
		System.out.println("newQualId:"+newQualId);
        FloorApproval floor = service.queryInfo(newQualId);
    	
        Map<String, Object> dataMap = new HashMap<String, Object>();       
        /** ��װ���� */
        dataMap.put("mes1",floor.getMes1());
        dataMap.put("mes2",floor.getMes2());
        dataMap.put("mes3",floor.getMes3());
        dataMap.put("mes4",floor.getMes4());
        dataMap.put("mes5",floor.getMes5());
        dataMap.put("mes6",floor.getMes6());
        dataMap.put("mes7",floor.getMes7());
        dataMap.put("mes8",floor.getMes8());
        dataMap.put("mes9",floor.getMes9());
        dataMap.put("mes10",floor.getMes10());
        dataMap.put("mes11",floor.getMes11());
        dataMap.put("mes12",floor.getMes12());
        dataMap.put("mes13",floor.getMes13());
		if (floor.getType().equals("0")) 
		{
			dataMap.put("mes14",floor.getMes14());
		} 
        
        
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy��MM��dd��");
//        dataMap.put("currDate",sdf.format(new Date()));       
//        dataMap.put("content","������������������������������������������������������������������������������������������������������������������������������������������������������������");       
//        List<Map<String, Object>> newsList=new ArrayList<Map<String,Object>>();
//        for(int i=1;i<=10;i++){
//         Map<String, Object> map=new HashMap<String, Object>();
//         map.put("title", "����"+i);
//         map.put("content", "����"+(i*2));
//         map.put("author", "����"+(i*3));
//         newsList.add(map);
//        }
//        dataMap.put("newsList",newsList);        
        /** �ļ����ƣ�Ψһ�ַ��� */
          Random r=new Random();
//        SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
          StringBuffer sb=new StringBuffer();
//        sb.append(sdf1.format(new Date()));
//          sb.append("_");
          sb.append(r.nextInt(100));   
		
	      SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
//	      StringBuffer sb=new StringBuffer();
//	      sb.append(sdf1.format(new Date()));
//	      sb.append("_");
		
        //�ļ�·��
        filePath=ServletActionContext.getServletContext().getRealPath("/");   
        String ftlTemplate;       
		if (floor.getType().equals("0")) 
		{
	        //�ļ�Ψһ����
	        fileOnlyName="�����������֪ͨ��_"+floor.getCorpName()+"_"+sdf1.format(new Date()).toString()+"_"+sb+".doc";    
	        //�ļ�����
	        fileName="�����������֪ͨ��_"+floor.getCorpName()+"_"+sdf1.format(new Date()).toString()+".doc";        
	        ftlTemplate="AcceptanceNotice.ftl";
		} else 
		{
	        //�ļ�Ψһ����
			fileOnlyName="�������������֪ͨ��_"+floor.getCorpName()+"_"+sdf1.format(new Date()).toString()+"_"+sb+".doc";
	        //�ļ�����
	        fileName="�������������֪ͨ��_"+floor.getCorpName()+"_"+sdf1.format(new Date()).toString()+".doc";
	        ftlTemplate="noAcceptanceNotice.ftl";
		}       
        /** ����word */
        WordUtil.createWord(dataMap, ftlTemplate, filePath, fileOnlyName);     
        return "createWordSuccess";
    }
    
    
 /**
  * @Desc���������ɵ�word�ĵ�����ڣ�������ת��struts XML����
  * @Author���ɽ
  * @Date��2014-1-22����07:36:29
  * @return
  */
    public String dowloadWord() {
        /** ���ж��ļ��Ƿ�������  */
        try {
         //�����������
         filePath = URLDecoder.decode(filePath, "UTF-8");
         fileOnlyName = URLDecoder.decode(fileOnlyName, "UTF-8");
         fileName = URLDecoder.decode(fileName, "UTF-8");
         
         //����ļ������ڣ���������쳣��Ȼ����Խ����쳣����
            new FileInputStream(filePath + File.separator +  fileOnlyName);
        } catch (Exception e) {
         e.printStackTrace();
         return "error";
        }
        return "dowloadWord";
    }
    
    /**
     * @Desc���������ɵ�word�ĵ�
     * �÷�����struts.xml�ļ��еģ� <param name="inputName">wordFile</param> ���Զ���Ӧ��get�������÷����Զ�����
     * @Author���ɽ
     * @Date��2014-1-22����07:36:29
     * @return �����������ɵ�word�ĵ� �ļ���
     */
    public InputStream getWordFile(){
        try {
         //�����������
         fileName = URLDecoder.decode(fileName, "UTF-8");
         
            /** �����������ɵ�word�ļ���  */
            return new FileInputStream(filePath + File.separator + fileOnlyName);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

 public String getFilePath() {
  return filePath;
 }

 public void setFilePath(String filePath) {
  this.filePath = filePath;
 }

 public String getFileName() {
  return fileName;
 }

 public void setFileName(String fileName) {
  this.fileName = fileName;
 }

 public String getFileOnlyName() {
  return fileOnlyName;
 }

 public void setFileOnlyName(String fileOnlyName) {
  this.fileOnlyName = fileOnlyName;
 }


public String getNewQualId() {
	return newQualId;
}


public void setNewQualId(String newQualId) {
	this.newQualId = newQualId;
}

}

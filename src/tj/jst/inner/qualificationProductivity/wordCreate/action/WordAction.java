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
 * @Desc：生成word
 * @Author：李宝山
 * @Date：2014-1-22下午04:52:03
 */

@SuppressWarnings("serial")
public class WordAction  extends ActionSupport{
 private String filePath; //文件路径
 private String fileName; //文件名称
 private String fileOnlyName; //文件唯一名称
 private String newQualId;// 项目主键
 
 /**
  * @Desc：生成word文档
  * @Author：李宝山
  * @Date：2014-1-22下午07:29:58
  * @return
  */
    public String createWord() {
        /** 用于组装word页面需要的数据 */
    	
		IQueryFloorApprovalService service = new QueryFloorApprovalServiceImpl();
		System.out.println("newQualId:"+newQualId);
        FloorApproval floor = service.queryInfo(newQualId);
    	
        Map<String, Object> dataMap = new HashMap<String, Object>();       
        /** 组装数据 */
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
        
        
//        SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");
//        dataMap.put("currDate",sdf.format(new Date()));       
//        dataMap.put("content","这是其它内容这是其它内容这是其它内容这是其它内容这是其它内容这是其它内容这是其它内容这是其它内容这是其它内容这是其它内容这是其它内容这是其它内容这是其它内容");       
//        List<Map<String, Object>> newsList=new ArrayList<Map<String,Object>>();
//        for(int i=1;i<=10;i++){
//         Map<String, Object> map=new HashMap<String, Object>();
//         map.put("title", "标题"+i);
//         map.put("content", "内容"+(i*2));
//         map.put("author", "作者"+(i*3));
//         newsList.add(map);
//        }
//        dataMap.put("newsList",newsList);        
        /** 文件名称，唯一字符串 */
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
		
        //文件路径
        filePath=ServletActionContext.getServletContext().getRealPath("/");   
        String ftlTemplate;       
		if (floor.getType().equals("0")) 
		{
	        //文件唯一名称
	        fileOnlyName="受理行政许可通知书_"+floor.getCorpName()+"_"+sdf1.format(new Date()).toString()+"_"+sb+".doc";    
	        //文件名称
	        fileName="受理行政许可通知书_"+floor.getCorpName()+"_"+sdf1.format(new Date()).toString()+".doc";        
	        ftlTemplate="AcceptanceNotice.ftl";
		} else 
		{
	        //文件唯一名称
			fileOnlyName="不受理行政许可通知书_"+floor.getCorpName()+"_"+sdf1.format(new Date()).toString()+"_"+sb+".doc";
	        //文件名称
	        fileName="不受理行政许可通知书_"+floor.getCorpName()+"_"+sdf1.format(new Date()).toString()+".doc";
	        ftlTemplate="noAcceptanceNotice.ftl";
		}       
        /** 生成word */
        WordUtil.createWord(dataMap, ftlTemplate, filePath, fileOnlyName);     
        return "createWordSuccess";
    }
    
    
 /**
  * @Desc：下载生成的word文档，入口，用来跳转至struts XML配置
  * @Author：李宝山
  * @Date：2014-1-22下午07:36:29
  * @return
  */
    public String dowloadWord() {
        /** 先判断文件是否已生成  */
        try {
         //解决中文乱码
         filePath = URLDecoder.decode(filePath, "UTF-8");
         fileOnlyName = URLDecoder.decode(fileOnlyName, "UTF-8");
         fileName = URLDecoder.decode(fileName, "UTF-8");
         
         //如果文件不存在，则会跳入异常，然后可以进行异常处理
            new FileInputStream(filePath + File.separator +  fileOnlyName);
        } catch (Exception e) {
         e.printStackTrace();
         return "error";
        }
        return "dowloadWord";
    }
    
    /**
     * @Desc：下载生成的word文档
     * 该方法是struts.xml文件中的： <param name="inputName">wordFile</param> 中自动对应的get方法，该方法自动调用
     * @Author：李宝山
     * @Date：2014-1-22下午07:36:29
     * @return 返回最终生成的word文档 文件流
     */
    public InputStream getWordFile(){
        try {
         //解决中文乱码
         fileName = URLDecoder.decode(fileName, "UTF-8");
         
            /** 返回最终生成的word文件流  */
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

package com.tj.jst.inner.qualificationProductivity.wordCreate.util;

import java.util.Map;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import freemarker.template.Configuration;
import freemarker.template.Template;

public class WordUtil {
	/**
	* @Desc������word�ļ�
	* @Author���ɽ
	* @Date��2014-1-22����05:33:42
	* @param dataMap word����Ҫչʾ�Ķ�̬���ݣ���map����������
	* @param templateName wordģ�����ƣ����磺test.ftl
	* @param filePath �ļ����ɵ�Ŀ��·�������磺D:/wordFile/
	* @param fileName ���ɵ��ļ����ƣ����磺test.doc
	*/	  
	public static void createWord(Map dataMap,String templateName,String filePath,String fileName){
	        try {
	        //��������ʵ�� 
	        Configuration configuration = new Configuration();        
	        //���ñ���
	            configuration.setDefaultEncoding("UTF-8");            
	            //ftlģ���ļ�ͳһ���� com.lun.template ������
	            
	            configuration.setClassForTemplateLoading(WordUtil.class,"/com/tj/jst/inner/qualificationProductivity/wordCreate/template/");           
	            //��ȡģ�� 
	            Template template = configuration.getTemplate(templateName);        
	            //����ļ�
	            File outFile = new File(filePath+File.separator+fileName);            
	            //������Ŀ���ļ��в����ڣ��򴴽�
	            if (!outFile.getParentFile().exists()){
	                outFile.getParentFile().mkdirs();
	            }           
	            //��ģ�������ģ�ͺϲ������ļ� 
	            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile),"UTF-8"));
	            //�����ļ�
	            template.process(dataMap, out);           
	            //�ر���
	            out.flush();
	            out.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}

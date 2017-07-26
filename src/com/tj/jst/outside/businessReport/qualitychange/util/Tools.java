package com.tj.jst.outside.businessReport.qualitychange.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class Tools {
    //�Ƿ����
    public static boolean isContain(String s1,String s2) 
    {
    	return s1.contains(s2);
    }
    
    
	public static Date getDayEndTime()
	{
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String dayTime=df.format(date)+" 23:59:59";	
		Date dayEndTime=null;
		try {
			dayEndTime = formatter.parse(dayTime.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dayEndTime;
	}
	
	//��ȡ��ǰ����
	public static String getCurrentDate()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String dayTime=formatter.format(date);	
	
		return dayTime;
	}
	
	//�ַ���תdate
	public static Date getDate(String StringTime){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dayEndTime=null;
		try {
			dayEndTime = formatter.parse(StringTime.toString());
		} catch (ParseException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return dayEndTime;
	}
	
	
    
    //ȥ�ظ�
	public static List<String> toRepeatList(List<String> list){
		for (int i = 0; i < list.size(); i++)  //��ѭ����ѭ���Ĵ���                                
        {                                                                            
            for (int j = list.size()-1;j> i;j--)  //��ѭ���� ��ѭ��һ�αȽϵĴ���
            {                                                                        
                                                                                     
                if (list.get(i) == list.get(j))                                                
                {                                                                    
                	list.remove(j);                                                 
                }                                                                    
                                                                                     
            }                                                                        
        }
		return list;
    }
    
    //���ŷָ�
    public static String listToString(List<String> stringList){
        if (stringList==null) {
            return null;
        }
        StringBuilder result=new StringBuilder();
        result.append(",");
        boolean flag=false;
        for (String string : stringList) {
            if (flag) {
                result.append(",");
            }else {
                flag=true;
            }
            result.append(string);
        }
        result.append(",");
        return result.toString();
    }
    
    public   static   List  removeDuplicate(List list) 
    { 
        for( int i=0;i<list.size()-1;i++)
        { 
            for(int j=list.size()-1 ;j>i;j--)
            { 
                 if(list.get(j).equals(list.get(i)))  
                 { 
                    list.remove(j); 
                 } 
             } 
        } 
          return list; 
      }
    public static  List removeDuplicateHashSet(List list)  
    {   
	    HashSet h  =   new  HashSet(list);   
	    list.clear();   
	    list.addAll(h);   
	    return list;   
	} 
    
}

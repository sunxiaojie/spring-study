package com.sxj.conmon.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * @author SXJ
 * @Date 2017年8月23日
 */
public class StringUtil extends StringUtils{
	
    
    /**   
     *******************************************************************************
     * @function : 将对象转化为String类型
     * @param obj
     * @return String
     *******************************************************************************
     * @creator ：majun   
     * @date ：2013-12-13      
     * @memo ：如果对象为空，则返回null
     *******************************************************************************
     */
    public static String valueOf(Object obj){
    	return obj==null?null:String.valueOf(obj);
    }
    
    public static String valueOf(Object obj,String defaultValue){
    	return obj==null?defaultValue:String.valueOf(obj);
    }
    
    /**   
     *******************************************************************************
     * @function : 将String转化为Long类型
     * @param String
     * @return Long
     *******************************************************************************
     * @creator ：zkk 
     * @date ：2013-12-13      
     * @memo ：如果对象为空，则返回null
     *******************************************************************************
     */
    public static Long toLong(String str){
    	return str==null ? null:Long.valueOf(str);
    }
    
    public static Long toLongAsNull(String str){
    	return str==null ? null: (str.length() == 0 ? null :Long.valueOf(str));
    }
    
    /**   
     *******************************************************************************
     * @function : 将String转化为Integer类型
     * @param String
     * @return Integer
     *******************************************************************************
     * @creator ：zkk 
     * @date ：2013-12-13      
     * @memo ：如果对象为空，则返回null
     *******************************************************************************
     */
    public static Integer toInteger(String str){
    	return str==null ? null: (str.length() == 0 ? 0 :Integer.valueOf(str));
    }
    
    public static Integer toIntegerAsNull(String str){
    	return str==null ? null: (str.length() == 0 ? null :Integer.valueOf(str));
    }
    
    /**   
     *******************************************************************************
     * @function : 将String转化为Integer类型
     * @param String
     * @return Integer
     *******************************************************************************
     * @creator ：zkk 
     * @date ：2013-12-13      
     * @memo ：如果对象为空，则返回null
     *******************************************************************************
     */
    public static Byte toByte(String str){
    	return str==null ?null:Byte.valueOf(str);
    }
    
    /**
     * 
     * 将字符串使用","进行拼接
     * @param 
     * @return
     *******************************************************************************
     * @creator ：liuting  
     * @date ：2013-12-27     
     * @memo ：   
     **
     */
    public static String toAppend(List<String> list){
        StringBuffer sb = new StringBuffer();
        if(null != list)
        {
            for(String obj : list){
                if(null != obj && !"".equals(obj)){
                    sb.append(obj).append(",");
                }
            }
            return sb.deleteCharAt(sb.length()-1).toString();
        }
        return null;
    }
    
    /**
     * 
     * 将String串转化成List
     * @param 
     * @return
     *******************************************************************************
     * @creator ：liuting  
     * @date ：2013-12-27     
     * @memo ：   
     **
     */
    public static List<String> toAddList(String obj) {
        if (null != obj && !"".equals(obj)) {
            List<String> list = new ArrayList<String>();
            String[] ob = obj.split(",");
            for (String o : ob) {
                list.add(o);
            }
            return list;
        }
        return null;
    }
    
    /**   
     *******************************************************************************
     * @function : 判断字符串是否为空
     * @param str
     * @return
     *******************************************************************************
     * @creator ：majun   
     * @date ：2014-2-7      
     * @memo ：字符串为null或者为空字符串都返回true
     *******************************************************************************
     */
    public static boolean positionModel(String str){
    	if(str != null && !"".equals(str.trim())){
    		return false;
    	}
    	return true;
    }
    
    /**   
     *******************************************************************************
     * @function : 替换字符串中内容
     * @param str
     * @return
     *******************************************************************************
     * @memo ：字符串为null或者为空字符串都返回null
     *******************************************************************************
     */
    public static String replace(String str, String oldStr, String newStr){
    	if(str != null && !"".equals(str.trim())){
        	return str.replace(oldStr, newStr);
    	}
		return null;
    }
    
    /**   
     *******************************************************************************
     * @function : 字符串转换为BigDecimal
     * @param str
     * @return
     *******************************************************************************
     * @memo ：字符串为null或者为空字符串都返回null
     *******************************************************************************
     */
    public static BigDecimal toBigDecimal(String str){
    	if(str != null && !"".equals(str.trim())){
    		return new BigDecimal(str);
    	}
    	return null;
    }
    public static BigDecimal toBigDecimalAsZero(String str){
    	return str==null ? null: (str.length() == 0 ? BigDecimal.ZERO : new BigDecimal(str));
    }
    
    /**   
     *******************************************************************************
     * @function : 字符串拆分
     * @param str
     * @return
     *******************************************************************************
     * @memo ：字符串为null或者为空字符串都返回null
     *******************************************************************************
     */
    public static String[] splitToArray(String str, String mark){
    	if(str != null && !"".equals(str.trim())){
    		return str.split(mark);
    	}
    	return null;
    }

	public static String removeBackquote(String simpleName) {
		return simpleName.trim();
	}
    
	
	
}


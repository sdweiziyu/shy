package com.shy.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DecimalFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class StringUtil {
	public static boolean isNullStr(String s) {
        if (s == null || s.trim().length() <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 将Object对象转变为String类型对象，对于null值返回空字符串.
     *
     * @param inObj 待处理的对象.
     */
    public static String killNull(Object inObj) {
        if (inObj == null) {
            return "";
        }
        return inObj.toString().trim();
    }
    /**
     * 字节长度判断，编码
     * @param s
     * @param i
     * @return
     * @throws UnsupportedEncodingException 
     */
    public static boolean isByteOutRange(String s,int i,String charset) throws UnsupportedEncodingException{
    	if(!isNullStr(s)){
    		if(s.getBytes(charset).length<=i){
    			return false;
    		}
    		return true;
    	}else{
    		return true;
    	}
    }
    
    public static String randomString(int length){
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		SecureRandom sr=null;
		StringBuffer sb = new StringBuffer();
		try {
			 sr =  SecureRandom.getInstance("SHA1PRNG");
			for (int i = 0; i < length; i++) {
				int number = sr.nextInt(base.length());
				sb.append(base.charAt(number));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	public static String randomStringMills(int length){
		return randomString(length)+System.currentTimeMillis();
	}
	
	public static String getExcelValue(XSSFCell cell){
		if(cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){  
		      return String.valueOf( cell.getBooleanCellValue());  
		    }else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){  
		    	DecimalFormat df = new DecimalFormat("#");
		      return df.format(cell.getNumericCellValue());  
		    }else if (cell.getCellType() ==Cell.CELL_TYPE_STRING){
		    	return String.valueOf(cell.getStringCellValue());
		    }else{  
		      return String.valueOf( cell.getStringCellValue());  
		    }  
	}  
}

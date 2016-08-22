package com.shy.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtil {
	
	private  static HttpURLConnection httpURLConnection = null;
	private static final String CHARSET = "UTF-8";
	public static InputStream getInputStream(String path, String content,String method) throws Exception{
		InputStream in = null;
		OutputStream out =null;
		try{
			URL url = new URL(path);
			httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setRequestProperty("Content-Type", "text/xml");
			httpURLConnection.setRequestProperty("Cache-Control", "no-cache");			
			httpURLConnection.setRequestMethod(method);
			httpURLConnection.setConnectTimeout(120*1000);
			httpURLConnection.setReadTimeout(120*1000);			
			httpURLConnection.setDoOutput(true);// 打开写入属性
			httpURLConnection.setDoInput(true);// 打开读取属性
			if(!StringUtil.isNullStr(content)){
				out = httpURLConnection.getOutputStream();
				out.write(content.getBytes(CHARSET));	
			}
			in = (InputStream) httpURLConnection.getContent();
		} catch(Exception e){
			throw e;
		}finally{
			if(out!=null){
				out.close();
			}
		}
		return in;
	}
	
	public static String getResponseStream(InputStream in) throws Exception {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(in, CHARSET));
			StringBuffer buf = new StringBuffer();
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				buf.append(tempString);
				buf.append("\n");
			}
			return buf.toString();
		} catch (Exception e) {
			throw e;
		}finally {
			if(reader != null){
				try{reader.close();}catch(Exception e){}
			}
		}
	}
	
	public static void close(){
		if(httpURLConnection != null)
			httpURLConnection.disconnect();
	}
}

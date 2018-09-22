package com.example.my.myfirstgitproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author caiqiao.li on 2018/9/21.
 * @Tel 13535537486
 */
public class HttpURLConnectUtils {
    private static HttpURLConnectUtils instance=null;
    public static synchronized  HttpURLConnectUtils getInstance(){
        if(instance==null){
            instance=new HttpURLConnectUtils();
        }
        return instance;
    }
    private HttpURLConnectUtils(){}
    //post
    public String dohttppost(String mUrl)throws IOException{
        URL url=new URL(mUrl);
        HttpURLConnection httpURLConnection=(HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(5000);//推荐设置网络延时
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.connect();
        //String msg=httpURLConnection.getResponseMessage();
        InputStreamReader inputStreamReader=new InputStreamReader(httpURLConnection.getInputStream());
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        StringBuilder builder=new StringBuilder();
        for(String s=bufferedReader.readLine();s!=null;s=bufferedReader.readLine()){
            builder.append(s);
        }
        return  builder.toString();
    }
}

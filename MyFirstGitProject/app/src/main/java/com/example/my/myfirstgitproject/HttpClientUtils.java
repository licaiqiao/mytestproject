package com.example.my.myfirstgitproject;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author caiqiao.li on 2018/9/21.
 * @Tel 13535537486
 */
public class HttpClientUtils {
    private static HttpClient httpClient;
    private static HttpClientUtils instance=null;
    public static synchronized HttpClientUtils getInstance(){
        if(instance==null){
            instance=new HttpClientUtils();
        }
        return instance;
    }
    private   HttpClientUtils(){
        //学习volley请求队列，httpClient使用单例模式
        if(httpClient==null){
            httpClient=new DefaultHttpClient();
        }
    }
    /**
     * 以get方式发送请求，访问接口
     * @param  uri 链接地址
     * @return 响应数据
     */
    private  static String doHttpGet(String uri){
        BufferedReader reader=null;
        StringBuffer sb=null;
        String result="";
        HttpGet request=new HttpGet(uri);
        try{
            //发送请求，得到响应
            HttpResponse response=httpClient.execute(request);
            //请求成功，statuscode返回200
            if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
                reader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                sb=new StringBuffer();
                String line="";
                while ((line=reader.readLine())!=null){
                    sb.append(line);
                }
            }


        }catch (ClientProtocolException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                //关闭流
                if(null!=reader){
                    reader.close();
                    reader=null;
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if(null!=sb){
            result =sb.toString();

        }
        return result;
    }
}

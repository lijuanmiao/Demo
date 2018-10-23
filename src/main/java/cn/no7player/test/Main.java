package cn.no7player.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lijm on 2017-10-24.
 */
public class Main {

     static  String sendGet(String url){

        String result = "";//定义字符串用来访问即将抓取的链接内容
        BufferedReader in= null;
        try{

            URL realUrl = new URL(url);//将String转成url对象

            URLConnection connection = realUrl.openConnection();
            connection.connect();//开始实际链接

            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = in.readLine())!=null){
                // 遍历抓取到的每一行并将其存储到result里面
                result += line + "\n";
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                if(in!=null){
                    in.close();
                }
            }catch (Exception ex1){
                ex1.printStackTrace();
            }

        }
        return result;
    }

    static String RegexString(String targetStr,String patternStr){

         //定义一个样式模板，此中石油正则表达式，括号中是需要抓取的内容
        Pattern pattern = Pattern.compile(patternStr);
        //定义一个matcher 用老做匹配
        Matcher matcher = pattern.matcher(targetStr);
        if(matcher.find()){
            return matcher.group(1);
        }
         return "Nothing";
    }

    /*public  static void main(String[] args){

        *//*String url="http://www.baidu.com";//即将访问的链接地址
        String result = sendGet(url);
        //使用正则匹配图片的src内容
        String imgSrc = RegexString(result, "src=\"(.+?)\""); //
        //打印结果
        System.out.println(imgSrc);*//*

    }*/
}

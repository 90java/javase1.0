package com.nojava._01_IO;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * IO流和文件操作示例
 * java.io
 */
public class IOStreamAndFile {


    @Test
    public void demo01() throws IOException {
        File file = new File("D:\\a");
        searchUtil(file);
    }

    public void searchUtil(File file){
        try {
            if(file!=null){
                if(file.isDirectory()){
                    File[] files = file.listFiles();
                    System.out.println(files.length);
                    //当读到没有权限的文件夹时会返回空，所以需要判断一下。空文件夹会返回为0
                    if(files!=null){
                        for(File f:files){
                            searchUtil(f);
                        }
                    }
                }else{
                    System.out.println(file.getPath());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 功能：匹配d盘下.jar结尾文件
     */
    @Test
    public void demo02(){
        File file = new File("C:\\Users\\86176\\.m2\\repository\\antlr\\antlr\\2.7.2");
        //正则 . 表示任意一个字符
        // *  表示该*前面一个（字符（注意不是前面一个词组）或者表达式 ）0到多次
        String regex = ".*\\.jar";
        String[] lists = file.list(new DirFilter(regex));
        Arrays.sort(lists,String.CASE_INSENSITIVE_ORDER);
        for(String dirItem:lists){
            System.out.println(dirItem);
        }
    }

    @Test
    public void demo03(){
        File file = new File("C:\\Users\\86176\\.m2\\repository\\antlr\\antlr\\2.7.2");
        //正则 . 表示任意一个字符
        // *  表示该*前面一个（字符（注意不是前面一个词组）或者表达式 ）0到多次
        String regex = ".*\\.jar";
        String[] lists = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                Pattern pattern = Pattern.compile(regex);
                return pattern.matcher(name).matches();
            }
        });
        Arrays.sort(lists,String.CASE_INSENSITIVE_ORDER);
        for(String dirItem:lists){
            System.out.println(dirItem);
        }
    }

}

package com.nojava._01_IO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * IO流和文件操作示例
 * java.io
 */
public class IOStreamAndFile {


    @Test
    public void demo01() throws IOException {
        File file = new File("D://");
        searchUtil(file);
    }

    public void searchUtil(File file){
        try {
            if(file!=null){
                if(file.isDirectory()){
                    File[] files = file.listFiles();
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

    @Test
    public void demo02(){

    }

}

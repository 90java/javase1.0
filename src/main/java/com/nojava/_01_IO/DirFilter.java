package com.nojava._01_IO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * FilenameFilter:实现此接口的类实例可用于过滤器文件名。
 */
public class DirFilter implements FilenameFilter {

    //正则表达式的编译表示形式。
    private Pattern pattern;

    public DirFilter(String regex) {
        //1.初始化Pattern实例  通过静态方法compile将正则表达式编译为Pattern的实例
        pattern = Pattern.compile(regex);
    }

    /**
     *
     * @param dir 被找到的文件所在的目录。
     * @param name 文件的名称。
     * @return
     */
    @Override
    public boolean accept(File dir, String name) {
        //2.将得到Pattern实例通过matcher方法创建Matcher对象。
        //pattern 是一个具有匹配正则模式。可以与任意字符串序列匹配，matcher方法为执行涉及的状态都在匹配器中（Matcher）。
        // 所以一个pattern可以根据匹配字符串生成多个匹配器。
        Matcher matcher = pattern.matcher(name);
        //3.matches() 匹配则返回true
        return matcher.matches();
    }

}

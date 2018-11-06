package com.ren.daliytest.test;

import java.io.*;
import java.util.Arrays;

/**
 * Created by dongao on 2018/10/10.
 * 编写一个程序，将 a.txt 文件中的单词与 b.txt 文件中的单词交替合并到 c.txt 文件中，a.txt 文件中的单词用回车符分隔， b.txt 文件中用回车或空格进行分隔
 */
public class FileTest {
    public static void main(String [] args) throws Exception{
        FileWriter ra = new FileWriter("a.txt");//字符流
        ra.write("adsf\nasgdg\ndasg\nqewr\ntrt\n");
        ra.close();

        FileWriter rb = new FileWriter("b.txt");
        rb.write("adsf asgdg dasg\nqewr trt\n");
        rb.close();

        FileManager a = new FileManager("a.txt", new char[]{'\n'});
        FileManager b = new FileManager("b.txt", new char[]{'\n',' '});
        FileWriter c = new FileWriter("c.txt");
        String aWord = null;
        String bWord = null;
        //交替写入
        while((aWord=a.nextWord())!=null){
            c.write(aWord+"\n");
            bWord = b.nextWord();
            if(bWord!=null){
                c.write(bWord+"\n");
            }
        }
        //如果b还有
        while((bWord=b.nextWord())!=null){
            c.write(bWord+"\n");
        }
        c.close();

    }


}

class FileManager {
    String[] words = null;//
    int pos = 0;//words的索引

    /**
     * 读入文件信息，根据分隔符，存入字符串数组words中
     *
     * @param filename
     * @param seperators
     * @throws Exception
     */
    public FileManager(String filename, char[] seperators) throws Exception {
        File f = new File(filename);
        FileReader reader = new FileReader(filename);//文件字符流
        char[] buf = new char[(int) f.length()];//f和文件字符流一样大
        int len = reader.read(buf);//读取的长度---小文件，一次性读取
        String results = new String(buf, 0, len);
        String regex = null;//正则表达式
        if (seperators.length > 1) {
            regex = "" + seperators[0] + "|" + seperators[1];
        } else {
            regex = "" + seperators[0];
        }
        words = results.split(regex);
        reader.close();
    }
    /**
     * 返回当前pos位置的words[pos]，然后后移pos，即pos++
     * @return
     */
    public String nextWord(){
        if(pos==words.length){
            return null;
        }
        return words[pos++];

    }

}

/**
 * 已知a.txt文件中有这样的一个字符串：“hcexfgijkamdnoqrzstuvwybpl”
   请编写程序读取数据内容，把数据排序后写入b.txt中。
          分析：
          A：把s.txt这个文件给做出来
          B：读取该文件的内容，存储到一个字符串中
          c:把字符串转换成字符数组
          D:对字符进行排序
          E:把排序后的字符数组转换为字符串
          F:把字符串再次写入s.txt中
 */
class StringDemo{
    public static void main(String[] args) throws IOException {

        FileWriter fileWriter = new FileWriter("s.txt");
        fileWriter.write("hcexfgijkamdnoqrzstuvwybpl0");
        fileWriter.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("s.txt"));
        String buf = bufferedReader.readLine();
        bufferedReader.close();

        char[] bufs = buf.toCharArray();
        Arrays.sort(bufs);
        //String result = new String(bufs);
        FileWriter fileWriter1 = new FileWriter("s.txt");
        fileWriter1.write(bufs);
        fileWriter1.flush();
        fileWriter1.close();

    }
}

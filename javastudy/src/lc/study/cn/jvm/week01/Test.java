package lc.study.cn.jvm.week01;

import java.io.*;
import java.util.Base64;

public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\lc\\Desktop\\周作业\\week01\\作业相关\\Hello.xlass");
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fop = new FileOutputStream("C:\\Users\\lc\\Desktop\\周作业\\week01\\作业相关\\HelloTest.class");
        byte[] buffer = new byte[fis.available()];
       byte[] outBuffer = new byte[fis.available()];
        fis.read(buffer);
        System.err.println(Base64.getEncoder().encodeToString(buffer));
        for(int i = 0;i < buffer.length ;i++ ){
            outBuffer[i] = (byte) (255 - buffer[i]);
        }
        fop.write(outBuffer);
    }
}

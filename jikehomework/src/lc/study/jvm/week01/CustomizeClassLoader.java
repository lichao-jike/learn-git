package lc.study.jvm.week01;
import java.lang.reflect.Method;
import java.util.Base64;

/**
 *
 *
 * 自定义一个 Classloader，加载一个 Hello.xlass 文件，执行 hello 方法，
 * 此文件内容是一个 Hello.class 文件所有字节（x=255-x）处理后的文件
 *
 *
 * @author lc
 *
 */
public class CustomizeClassLoader extends ClassLoader {


    public static void main(String[] args) throws Exception {
        String helloXlcassBase64 = "NQFFQf///8v/4/X/+f/x9v/w/+/3/+71/+3/7Pj/6/j/6v7/+cOWkZaLwf7//NfWqf7/+7yQm5r+//CzlpGa" +
                "sYqSnZqNq56dk5r+//qXmpOTkP7/9ayQio2cmrmWk5r+//W3mpOTkNGVnome8//4//f4/+nz/+j/5/7/7Leak5OQ09+ck56MjLOQnpua" +
                "jd74/+bz/+X/5P7/+reak5OQ/v/vlZ6JntCTnpGY0LCdlZqci/7/75WeiZ7Qk56RmNCshoyLmpL+//yQiov+/+qzlZ6JntCWkNCvjZaR" +
                "i6yLjZqeksT+/+yVnome0JaQ0K+NlpGLrIuNmp6S/v/4j42WkYuTkf7/6tezlZ6JntCTnpGY0KyLjZaRmMTWqf/e//r/+f///////f/+//" +
                "j/9//+//b////i//7//v////rVSP/+Tv////7/9f////n//v////7//v/0//f//v/2////2v/9//7////2Tf/97fxJ//tO/////v/1//" +
                "//9f/9////+//3//r//v/z/////f/y";
        //获取解密后字节数组
        byte[] decodeFileBytes =  fileDecode(helloXlcassBase64);
        //通过自定义类加载
        Class clazz = new CustomizeClassLoader().defineClass(decodeFileBytes,0,decodeFileBytes.length);
        Object obj = clazz.newInstance();
        Method method = clazz.getMethod("hello");
        method.invoke(obj);




    }

    /**
     * 获取 Hello.xlass 解密后的字节数组
     * 解密方式 （x=255-x）
     *
     * @param fileBase64 由于提交作业，可能导致错误文件获取失败，故转换成base64
     *
     * @return byte[]
     */

    public static byte[] fileDecode(String fileBase64) {
        if(fileBase64 == null || "".equals(fileBase64.trim())){
            throw new RuntimeException("初始化文件异常！");
        }else{
            byte[]  bytes = Base64.getDecoder().decode(fileBase64);
            byte[] result = new byte[bytes.length];
            for(int i = 0;i < bytes.length ;i++ ){
                result[i] = (byte) (255 - bytes[i]);
            }
            return result;
        }
    }




}

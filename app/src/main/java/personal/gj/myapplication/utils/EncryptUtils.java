package personal.gj.myapplication.utils;



import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2016/08/02
 *     desc  : utils about encrypt
 * </pre>
 */
public final class EncryptUtils {






    /**
     * 生成32位MD5摘要
     * @param string
     * @return
     */
    public static String md5(String string) {
        if(string == null){
            return null;
        }
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F'};

        try{
            byte[] btInput = string.getBytes("utf-8");
            /** 获得MD5摘要算法的 MessageDigest 对象 */
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            /** 使用指定的字节更新摘要 */
            mdInst.update(btInput);
            /** 获得密文 */
            byte[] md = mdInst.digest();
            /** 把密文转换成十六进制的字符串形式 */
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        }catch(NoSuchAlgorithmException | UnsupportedEncodingException e){
            return null;
        }
    }






//    // 首先初始化一个字符数组，用来存放每个16进制字符
//    private static final char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
//            'e', 'f' };
//
//    /**
//     * 获得一个字符串的MD5值
//     *
//     * @param input 输入的字符串
//     * @return 输入字符串的MD5值
//     *
//     */
//    public static String md5(String input) {
//        if (input == null)
//            return null;
//
//        try {
//            // 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）
//            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
//            // 输入的字符串转换成字节数组
//            byte[] inputByteArray = input.getBytes("utf-8");
//            // inputByteArray是输入字符串转换得到的字节数组
//            messageDigest.update(inputByteArray);
//            // 转换并返回结果，也是字节数组，包含16个元素
//            byte[] resultByteArray = messageDigest.digest();
//            // 字符数组转换成字符串返回
//            return byteArrayToHex(resultByteArray);
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    /**
//     * 获取文件的MD5值
//     *
//     * @param file
//     * @return
//     */
//    public static String md5(File file) {
//        try {
//            if (!file.isFile()) {
//                System.err.println("文件" + file.getAbsolutePath() + "不存在或者不是文件");
//                return null;
//            }
//
//            FileInputStream in = new FileInputStream(file);
//
//            String result = md5(in);
//
//            in.close();
//
//            return result;
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    public static String md5(InputStream in) {
//
//        try {
//            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
//
//            byte[] buffer = new byte[1024];
//            int read = 0;
//            while ((read = in.read(buffer)) != -1) {
//                messagedigest.update(buffer, 0, read);
//            }
//
//            in.close();
//
//            String result = byteArrayToHex(messagedigest.digest());
//
//            return result;
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }
//
//    private static String byteArrayToHex(byte[] byteArray) {
//        // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
//        char[] resultCharArray = new char[byteArray.length * 2];
//        // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
//        int index = 0;
//        for (byte b : byteArray) {
//            resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
//            resultCharArray[index++] = hexDigits[b & 0xf];
//        }
//
//        // 字符数组组合成字符串返回
//        return new String(resultCharArray);
//
//    }
}

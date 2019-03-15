package commons.codec;


import cn.hutool.core.util.StrUtil;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;

/**
 * Created with IDEA
 * author:Zhangyibo
 * Date:2018/12/3
 * Time:14:40
 */
public class  codecTest {

    public static void main(String[] args) throws UnsupportedEncodingException, DecoderException {
        //        base64
        Base64 base64 = new Base64();
        String str = "AAaaa我";
        String result = base64.encodeToString(str.getBytes("UTF-8"));//编码
        System.out.println(StrUtil.format("base64加密：{}",result));
        byte[] decode = base64.decode(result.getBytes());//解码
        System.out.println(StrUtil.format("base64解密：{}",new String(decode)));

        //        Hex编码和解码

        String hexstr = "test";
        /**编码*/
        char[] encodeHex = Hex.encodeHex(hexstr.getBytes(), true);//先转换成char数组，第二个参数意思是是否全部转换成小写
        System.out.println(StrUtil.format("Hex编码：{}",new String(encodeHex)));
        /**解码*/
        byte[] decodeHex = Hex.decodeHex(encodeHex);//char数组型的
        System.out.println(StrUtil.format("Hex解码：{}",new String(decodeHex)));
        /**编码*/
        String hexString = Hex.encodeHexString(hexstr.getBytes("UTF-8"));//直接一步到位
        System.out.println(hexString);
        /**解码*/
        byte[] decodeHex2 = Hex.decodeHex(hexString.toCharArray());//字符串类型的，该方法要求传入的是char[]
        System.out.println(new String(decodeHex2));
        //       md5

        String md5Str = "test";
        String md5 = DigestUtils.md5Hex(md5Str.getBytes("UTF-8"));
        System.out.println(StrUtil.format("md5编码：{}",md5));

        //        SHA加密
        String shalHexStr = "test中国";
        String sha1Hex = DigestUtils.sha1Hex(shalHexStr.getBytes("UTF-8"));
        System.out.println(StrUtil.format("SHA加密：{}",sha1Hex));
    }
}

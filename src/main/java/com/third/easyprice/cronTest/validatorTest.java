package com.third.easyprice.cronTest;

import cn.hutool.core.lang.Validator;

/**
 * Created with IDEA
 * author:Zhangyibo
 * Date:2018/11/30
 * Time:15:27
 */
public class validatorTest {
   public boolean test(){
       String parameter = "+8610000000000";
       int min = 5;
       int max = 8;

//验证是否是身份证
       boolean isCitizenId = Validator.isCitizenId(parameter);
//验证是否是Email
       boolean isEmail = Validator.isEmail(parameter);
//验证是否是汉字
       boolean isChinese = Validator.isChinese(parameter);
//验证是否是生日
       boolean isBirthday = Validator.isBirthday(parameter);
//验证是否是Ipv4地址
       boolean isIpv4 = Validator.isIpv4(parameter);
//验证是否是mac地址
       boolean isMac = Validator.isMac(parameter);
//验证是否是中国的手机号
       boolean isMobile = Validator.isMobile(parameter);
//验证是否是中国的车牌号
       boolean isPlateNumber = Validator.isPlateNumber(parameter);
//验证是否是满足长度的仅含英文、数字、下划线的字符串
       boolean isGeneral = Validator.isGeneral(parameter, min, max);
       return isGeneral;

   }

}

package commons.beanutils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IDEA
 * author:Zhangyibo
 * Date:2018/12/4
 * Time:15:26
 */
public class test1 {
    /**
     * BeanUtils
     */
    @Test
    public void beanUtils() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "tuantuan");
        map.put("age", 3);
        map.put("color", "black");
        map.put("sex", "female");

        // 将map数据拷贝到javabean中
        Animal a1 = new Animal();
        BeanUtils.populate(a1, map);
        System.out.println(a1); // Animal [name=tuantuan, age=3, color=black, sex=female]

        // 对象的拷贝
        Animal a2 = new Animal();
        BeanUtils.copyProperties(a2, a1);
        System.out.println(a2);// Animal [name=tuantuan, age=3, color=black, sex=female]

        // 拷贝指定的属性
        Animal a3 = new Animal();
        BeanUtils.copyProperty(a3, "name", "yuanyuan");
        System.out.println(a3); // Animal [name=yuanyuan, age=0, color=null, sex=null]

        // 设置指定的属性
        BeanUtils.setProperty(a3, "sex", "male");
        System.out.println(a3); // Animal [name=yuanyuan, age=0, color=null, sex=male]

        // 克隆对象
        Object object = BeanUtils.cloneBean(a3);
        System.out.println(object); // Animal [name=yuanyuan, age=0, color=null, sex=male]
    }

    /**
     * 这个工具类的职能是在字符串和指定类型的实例之间进行转换。
     * 实际上，BeanUtils是依赖ConvertUtils来完成类型转换，
     * 但是有时候我们可能需要自定义转换器来完成特殊需求的类型转换
     */
    public void convertUtils() {
        // 将整型转换成字符串
        Object object = ConvertUtils.convert(123, String.class);
        String typeName = object.getClass().getTypeName();
        System.out.println(typeName);

        // 将日期转换成字符串
        Object object2 = ConvertUtils.convert(new Date(), String.class);
        String typeName2 = object2.getClass().getTypeName();
        System.out.println(typeName2);

        // 将字符串转换成Double
        Object object3 = ConvertUtils.convert("123", Double.class);
        String typeName3 = object3.getClass().getTypeName();
        System.out.println(typeName3);

    }

    public void myConvert() throws InvocationTargetException, IllegalAccessException {
        // BeanUtils设置属性时，自动进行类型转换
        MyConverter converter = new MyConverter("yyyy-MM-dd HH:mm:ss");
        // 注册该转换器
        ConvertUtils.register(converter, Date.class);
        Animal a5 = new Animal();
        BeanUtils.copyProperty(a5, "birth", "2017-11-29 14:04:00");
        System.out.println(a5);// Animal [name=null, age=0, color=null, sex=null, birth=Wed Nov 29 14:04:00 CST 2017]


        MyConverter converter1 = new MyConverter("yyyy-MM-dd HH:mm:ss");
        // 注册该转换器
        ConvertUtils.register(converter1, Date.class);
        Object object3 = ConvertUtils.convert("2017-11-29 14:04:00", Date.class);
        System.out.println(object3.getClass().getTypeName());
        System.out.println(object3);

    }

    /**
     *    PropertyUtils
     *
     *     BeanUtils与PropertyUtils这两个类几乎有一摸一样的功能，唯一的区别是：BeanUtils在对Bean赋值是会进行类型转化。
     *     举例来说也就是在copyProperty时只要属性名相同，就算类型不同，BeanUtils也可以进行copy；而PropertyBean则可能会报错！！
     *     当然2个Bean之间的同名属性的类型必须是可以转化的，否则用BeanUtils一样会报错。
     *     若实现了org.apache.commons.beanutils.Converter接口则可以自定义类型之间的转化。
     *     由于不做类型转化，用PropertyUtils在速度上会有很大提高！
     *
     *     java中如果不知道bean的类型或者不知道bean中的方法或属性时，无法给其赋值。
     *     但是java中有一个类可以在不知道bean的情况下也可以给其bean进行赋值和取值。
     *     那就是PropertyUtils类。该类可以对bean的属性（bean中要有属性的get和set方法）进行设值和取值。
     *   设值通过：PropertyUtils.setProperty(Object bean,String shuxing,String value)
     *    取值通过：PropertyUtils.getProperty(Object bean,String shuxing)
     *
     *
     */


}

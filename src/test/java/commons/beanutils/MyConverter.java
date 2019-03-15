package commons.beanutils;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created with IDEA
 * author:Zhangyibo
 * Date:2018/12/4
 * Time:15:42
 */
/**自定义转换器，实现Converter接口，重写convert方法*/
class MyConverter implements Converter {
    private static SimpleDateFormat format;

    public MyConverter(String pattern) {
        format = new SimpleDateFormat(pattern);
    }

    @Override
    public Object convert(Class type, Object value) {
        if (value == null) {
            return null;
        }

        if (value instanceof String) {
            String tmp = (String) value;
            if (tmp.trim().length() == 0) {
                return null;
            } else {
                try {
                    return format.parse(tmp);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        } else {
            throw new ConversionException("not String");
        }
        return value;
    }
}

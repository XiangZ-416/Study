package utils;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: //TODO 自定义类型转换器：把字符串转成日期
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create： 2020/5/12 23:09
 */
public class StringToDateConverter implements Converter<String, Date> {

    /**
     * @Param [source]：传入的字符串
     * @return java.util.Date：转后的日期
     **/
    @Override
    public Date convert(String source) {
        // 判断
        if (source == null) {
            throw new RuntimeException("请您传入数据");
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 把字符串转成日期
            return df.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("数据类型转换出现错误");
        }
    }

}

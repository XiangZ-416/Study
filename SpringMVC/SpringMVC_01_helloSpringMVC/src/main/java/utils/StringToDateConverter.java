package utils;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: //TODO �Զ�������ת���������ַ���ת������
 * @Author: ZX   Email:zx04161313@163.com
 * @Date:Create�� 2020/5/12 23:09
 */
public class StringToDateConverter implements Converter<String, Date> {

    /**
     * @Param [source]��������ַ���
     * @return java.util.Date��ת�������
     **/
    @Override
    public Date convert(String source) {
        // �ж�
        if (source == null) {
            throw new RuntimeException("������������");
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // ���ַ���ת������
            return df.parse(source);
        } catch (ParseException e) {
            throw new RuntimeException("��������ת�����ִ���");
        }
    }

}

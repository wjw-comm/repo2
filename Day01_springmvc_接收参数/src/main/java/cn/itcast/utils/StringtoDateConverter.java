package cn.itcast.utils;


import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//把字符串转换为日期
public class StringtoDateConverter implements Converter<String,Date> {
    private Date date;
    @Override
    public Date convert(String source) { //source:具体要被转换的对象
        if(source==null){
            throw new RuntimeException("请您输入数据");
        }
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd"); //定义转换模板
        try {
             date = df.parse(source);
        } catch (ParseException e) {
           throw new RuntimeException("数据转换出现异常");
        }
        return date;
    }
}

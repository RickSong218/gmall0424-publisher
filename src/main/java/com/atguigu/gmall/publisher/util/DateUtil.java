package com.atguigu.gmall.publisher.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;


public class DateUtil {
    //获取当天日期的整数形式
    public static Integer now(){
        String yyyyMMdd = DateFormatUtils.format(new Date(), "yyyyMMdd");
        return Integer.valueOf(yyyyMMdd);
    }
}

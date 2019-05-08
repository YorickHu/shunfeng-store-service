package com.gurume.api.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName DataFormat
 * @Description TODO
 * @Author huyue
 * @Date 2019/5/2 9:16 AM
 * @Version 1.0
 **/
public class DataFormat {


    /**
     * 人民币分转换成元
     * @param amount
     * @return
     */
    public static String fenToYuan(String amount){
        DecimalFormat df = new DecimalFormat("######0.00");
        Double d = Double.parseDouble(amount)/100;
        return df.format(d).toString();
    }

    /**
     * 人民币元转换成分
     * @param amount
     * @return
     */
    public static String yuanToFen(String amount){
        DecimalFormat df = new DecimalFormat("######0");
        Double d = Double.parseDouble(amount)*100;
        return df.format(d).toString();
    }

    /**
     * 折扣转百分比
     * @param discount
     * @return
     */
    public static String percentToDiscount(String discount){
        DecimalFormat df = new DecimalFormat("######0.0");
        Double d = Double.parseDouble(discount)/10;
        return df.format(d).toString();
    }

    /**
     * 百分比转折扣
     * @param amount
     * @return
     */
    public static String discountToPercent(String amount){
        DecimalFormat df = new DecimalFormat("######0");
        Double d = Double.parseDouble(amount)*10;
        return df.format(d).toString();
    }

    public static String dateToString(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}

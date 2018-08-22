package test;

import java.math.BigDecimal;

/**
 * double小数问题
 * 解决方案：
 * 1.四舍五入
 * 2.保留两位
 */
public class DoubleTest {
    public static void main(String[] args) {
        double price1 = 100.35;
        System.out.println(price1);
        System.out.println(price1*=6);

        Double price = 100.35;
        System.out.println(price);
        System.out.println(price*=6);
//        100.35
//        602.0999999999999
//        100.35
//        602.0999999999999


//        java保留两位小数问题：
//        方式一：
//        四舍五入
//
//        double   f   =   111231.5585;
//        BigDecimal   b   =   new   BigDecimal(f);
//        double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();

        BigDecimal bigDecimal = new BigDecimal(price);

        double price2 = bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(price2);

//        保留两位小数
//        方式二：
//
//        java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");
//        df.format(你要格式化的数字);
//        例：
//
//        new java.text.DecimalFormat("#.00").format(3.1415926)
//#.00 表示两位小数 #.0000四位小数 以此类推...

    }
}

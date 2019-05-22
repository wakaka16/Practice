package reponsibility;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 责任链测试
 */
public class Test {

  /**
   * 字符串转换成Color对象	 * @param colorStr 16进制颜色字符串	 * @return Color对象	 *
   */
  public static Color toColorFromString(String colorStr) {
    Color color = new Color(
        Integer.parseInt(colorStr, 16));    //java.awt.Color[r=0,g=0,b=255]
     return color;
    }

    public static void main (String[]args){
//      String path = "zookeeper/node";
//      path = String.format("%s%s", "/", path);
//
//      String s = String.format("Hello %2$s%3$s%1$s", "li-", "heng-", "jie");//%2$s%3$s%1$s带下标的占位符
//      String s2 = String.format("Hello %s%s%s", "jerry-", "li", ",welcome!");//无下标占位符
//
////      System.out.println(toColorFromString("FFFFFF"));
//      System.out.println(s2);

      String str ="/Group/Group_id/nodeServerId";
      System.out.println(str.substring(str.indexOf("/"),str.lastIndexOf("/")));

      Object o = new Object();


    }

  }

package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wxl
 * @Date 2018/12/25
 **/
public class Test {

  /**
   * 读取Excel文件
   */
  public static void readExcel(File file) throws FileNotFoundException {
  }

  public static void main(String[] args) {
//    String str= "1545741716541,";
//    System.out.println(str.substring(0,str.length()-1));
    List<String> list = new ArrayList<>();


    int i = 20;
    if(i>6){
      System.out.println(1);
    }else if(i>18){
      System.out.println(2);
    }else{
      System.out.println(3);
    }
  }

}

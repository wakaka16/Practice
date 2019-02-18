package file;

import java.io.File;

public class FileTest {

  public static void delete(File file) {
    if (file.isDirectory()) {
      File[] files = file.listFiles();
      for (int i = 0; i < files.length; i++) {
        File f = files[i];
        delete(f);
      }
      file.delete();//如要保留文件夹，只删除文件，请注释这行
    } else if (file.exists()) {
      file.delete();
    }
  }

  public static void create(File file){
    if(!file.exists()){
      file.mkdirs();
    }
  }

  public static void main(String[] args) {
//    File file = new File("/");//D:\  当前项目所在的根目录
//    System.out.println(file.getAbsolutePath());
    File file = new File("/aaa/ccc");
//    create(file);
     delete(file);

  }

}

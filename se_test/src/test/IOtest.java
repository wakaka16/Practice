package test;

import java.io.*;

/**
 * IO练习
 */
public class IOtest {
    /**
     * 读取该目录下的所有文件
     * @param srcFolder 源目录
     */
    public static void copy(File srcFolder,File copyFolder) {
        if(!copyFolder.exists()){
            copyFolder.mkdir();
        }
        int count =1;
        String[] fileNameArray = srcFolder.list();//file.list用于过去子目录内容
        for (String fileName : fileNameArray) {
            File file = new File(srcFolder.toString()+"/"+fileName);
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            BufferedOutputStream bos = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                File newFile = new  File(copyFolder.toString()+"/"+count+suffix(fileName));
                FileOutputStream fos = new FileOutputStream(newFile);
                bos = new BufferedOutputStream(fos);
                int len = 0;
                byte[] buff = new byte[2048];
                while ((len=bis.read(buff))!=-1){
                    bos.write(buff, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                    try {
                        if(null!=bis) bis.close();
                        if(null!=bos) bos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            }
            count++;
        }

    }

    /**
     * 截取文件后缀
     * @param fileName
     * @return
     */
    public static String suffix(String fileName){
        String suffix = fileName.substring(fileName.indexOf(".") );
        return suffix;
    }

    public static void main(String[] args) {
        File srcFolder = new File("C:\\Users\\58274\\Desktop\\bg");
        File copyFolder = new File("C:\\Users\\58274\\Desktop\\copy");
        copy(srcFolder,copyFolder);

//        System.out.println(suffix("C:\\Users\\58274\\Desktop\\bg\\0716ede69c9ee992dfaac6b0d12a2a45.jpg"));

    }


}

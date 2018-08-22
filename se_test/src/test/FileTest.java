package test;

import java.io.File;

/**
 * 文件测试
 */
public class FileTest {

    public static void main(String[] args) {
//        获取应用的绝对路径（用于下载）
//        String str = getRequest().getSession().getServletContext().getRealPath("/");//D:\work\zhifei\Operator-magazine\PC\Backstage\target\scdaily-admin\

        String realPath = "D:/work/zhifei/Operator-magazine/PC/Backstage/target/scdaily-admin/jflyfox/bbs/article_file/20180730_174223_355431.png";

        File file = new File(realPath);
        System.out.println(file.exists());




    }

}

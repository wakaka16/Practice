package spring.nonannotion;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * @author wangxiaolong
 * @date 2019/5/16 14:15 spring bean 工程
 * 非注解版spring ioc
 */
public class BeanFactory {

  /**
   * bean容器
   * 创建时间必须要早于容器初始化
   */
  private static Map<String, Object> beanMap = new ConcurrentHashMap<>(16);

  /**
   * 程序运行就到指定的目录下加载springbean.xml文件
   */
  static{

    initBeanMap("D:/practice/se_test/src/spring/nonannotion/spring.xml");
  }



  /**
   * 初始化bean容器
   *
   * @param path xml文件路径
   */
  public static void initBeanMap(String path) {
    //1、dom4j解析Xml文件
    SAXReader reader = new SAXReader();
    File file = new File(path);
    Document document = null;
    try {
      document = reader.read(file);
    } catch (DocumentException e) {
      throw new IllegalArgumentException("FileNotFoundException");
    }
    Element root = document.getRootElement();
    List<Element> beanList = root.elements();
    for (Element bean : beanList) {
      String id = bean.attributeValue("id");
      String aClass = bean.attributeValue("class");
      if (beanMap.containsKey(id)){
        throw new IllegalArgumentException("id has existed");
      }
      //2、反射创建bean对象
      Class<?> clazz = null;
      try {
        clazz = Class.forName(aClass);
      } catch (ClassNotFoundException e) {
        throw new IllegalArgumentException("ClassNotFoundException");
      }

      Object o = null;
      try {
        o = clazz.newInstance();
      } catch (InstantiationException e) {
        throw new IllegalArgumentException("InstantiationException");
      } catch (IllegalAccessException e) {
        throw new IllegalArgumentException("IllegalArgumentException");
      }
      //放入bean
      beanMap.put(id, o);
    }
  }

  /**
   * 通过id获取bean
   * @param id bean id
   * @return
   */
  public static Object getBean(String id){
   return beanMap.get(id);
  }


  public static void main(String[] args) {
    String classFilePath = BeanFactory.class.getResource("/").getPath();
    System.out.println(classFilePath);
//    /D:/practice/se_test/out/production/se_test/

  }
}

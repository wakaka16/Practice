package spring.iocdi.annotion;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wangxiaolong
 * @date 2019/5/16 14:15
 * spring bean 工程 注解版spring ioc
 */
public class BeanFactory {

  /**
   * bean容器 创建时间必须要早于容器初始化
   */
  private static Map<String, Object> beanMap = new ConcurrentHashMap<>(16);

  /**
   * 程序运行就到指定的目录下加载springbean.xml文件
   */
  static {

    try {
      //加载完bean
      loadBean("spring.annotion.iocdi");
      //再加载属性
      autoWired("spring.annotion.iocdi");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    }
  }


  /**
   * 加载bean，将bean放入beanFactory（IOC）
   * @param packageName 包路径
   */
  private static void loadBean(String packageName)
      throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    // 获取指定包下的文件
    String packageDirName = packageName.replace('.', '/');
    String classFilePath = BeanFactory.class.getResource("/").getPath();
    String localPath = classFilePath + "/" + packageDirName;
    File localFile = new File(localPath);
    File[] files = localFile.listFiles();
    for (File file : files) {
      //获取class文件
      if (file.getName().endsWith(".class")) {
        String className = file.getName().replace(".class", "");
        Class<?> aClass = Class.forName(packageName + "." + className);
        Component componet = aClass.getAnnotation(Component.class);
        aClass.getAnnotation(Component.class);
        //获取有componet注解的文件
        if (null != componet) {
          Object o = aClass.newInstance();
          //
          Field[] fields = aClass.getDeclaredFields();
          for (Field filed : fields) {
            Autowired autowired = filed.getAnnotation(Autowired.class);
            if (null != autowired) {

            }
          }

          //判断重复注入
          if (beanMap.containsKey(className.toLowerCase())) {
            throw new IllegalArgumentException("id has existed");
          }
          beanMap.put(className.toLowerCase(), o);
        }
      }
    }


  }

  /**
   * 将beanFactory中的属性注入（DI）
   * @param packageName 包路径
   * @throws ClassNotFoundException
   * @throws IllegalAccessException
   * @throws InstantiationException
   */
  private static void autoWired(String packageName)
      throws ClassNotFoundException, IllegalAccessException, InstantiationException {
    // 获取指定包下的文件
    String packageDirName = packageName.replace('.', '/');
    String classFilePath = BeanFactory.class.getResource("/").getPath();
    String localPath = classFilePath + "/" + packageDirName;
    File localFile = new File(localPath);
    File[] files = localFile.listFiles();
    for (File file : files) {
      //获取class文件
      if (file.getName().endsWith(".class")) {
        String className = file.getName().replace(".class", "");
        Class<?> aClass = Class.forName(packageName + "." + className);
        Component componet = aClass.getAnnotation(Component.class);
        aClass.getAnnotation(Component.class);
        //获取有componet注解的文件
        if (null != componet) {
          Object o = aClass.newInstance();
          //
          Field[] fields = aClass.getDeclaredFields();
          for (Field filed : fields) {
            Autowired autowired = filed.getAnnotation(Autowired.class);
            if (null != autowired) {
              //Test中user属性
              String name = filed.getName();
              //获取注入对象
              Object user = beanMap.get(name);
              //获取被注入对象
              Object test = beanMap.get(className.toLowerCase());
              setFieldValueByFieldName(filed.getName(),test,user);

            }
          }
        }
      }
    }


  }


  /**
   * 根据属性名设置属性值
   */
  private static void setFieldValueByFieldName(String fieldName, Object object, Object value) {
    try {
// 获取obj类的字节文件对象
      Class c = object.getClass();
// 获取该类的成员变量
      Field f = c.getDeclaredField(fieldName);
// 取消语言访问检查
      f.setAccessible(true);
// 给变量赋值
      f.set(object, value);
    } catch (Exception e) {
    }
  }


  /**
   * 通过id获取bean
   *
   * @param id bean id
   */
  public static Object getBean(String id) {
    return beanMap.get(id);
  }
}
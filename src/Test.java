import java.math.RoundingMode;
import java.sql.DriverManager;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import sun.misc.Launcher;

/**
 * 测试构造器调用，作用避免相同的代码写两次，方便维护
 */
public class Test {

  static String num = "hello";

  int age;

  //加入volatile之后，对i进行操作，会使各线程对i可见，就不会引发混乱
  public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
//    Test test = new Test();
//    int i = 6;
//    test.age=i;
//    System.out.println(test.age);
//    System.out.println(Test.num==Test2.num);
//    String str = "T1167676374673";
//    System.out.println(str.substring(str.length()-6));
//    String mm = new SimpleDateFormat("MM").format(new Date());
//    System.out.println(mm);
//    int i = Integer.parseInt(mm);
//    System.out.println(i);
//    String year = "2019";
//    int quarter = 4;
//    Date[] quarterDate = getQuarterDate(year, quarter);
//    for(int i =0;i<quarterDate.length;i++){
//      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//      String format = sdf.format(quarterDate[i]);
//      System.out.println(format);
//    }

//    int a = 1000;
//    int b=1415;
//    int c = 2;
//    String accuracy = accuracy(a, b, c);
//    System.out.println(accuracy);
//    Launcher
//    Class.forName("com.mysql.jdbc.Driver");
//    DriverManager.getConnection()
//    ClassLoader.getSystemClassLoader().loadClass("");

//    System.out.println("boot:" + System.getProperty("sun.boot.class.path"));
//    System.out.println("ext:" + System.getProperty("java.ext.dirs"));
//    System.out.println("app:" + System.getProperty("java.class.path"));
//    System.out.println("system:" + System.getProperty("java.system.class.loader"));
//    System.out.println("system:" + ClassLoader.getSystemClassLoader());
//
//    String[] properties = new String[]{"roles",
//        "modifier.modifier", "modifier.creator", "modifier.roles", "modifier.tags",
//        "modifier.depart",
//        "creator.modifier", "creator.creator", "creator.roles", "creator.tags", "creator.depart",
//        "depart.parent", "depart.children",
//        "depart.creator", "depart.modifier", "depart.parent", "depart.children",
//        "tags.parent", "tags.children", "tags.creator", "tags.modifier", "tags.parent",
//        "tags.children"};
//    Arrays.sort(properties);
//    for (String str: properties) {
//      System.out.println(str);
//    }
    Test test = new Test();
    Class<? extends Test> aClass = test.getClass();
    ClassLoader classLoader = aClass.getClassLoader();
    System.out.println(classLoader);
  }


  public static Date[] getQuarterDate(String year, int quarter) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
    Calendar c = Calendar.getInstance();
    Date[] dates = new Date[2];
    Date start = null;
    Date end = null;
    try {
      Date date = sdf.parse(year);
      c.setTime(date);
    } catch (ParseException e) {
      throw new IllegalArgumentException("年份转换错误！");
    }
    switch (quarter) {
      case 1:
        c.set(Calendar.MONTH, 0);
        start = c.getTime();
        c.set(Calendar.MONTH, 3);
        c.set(Calendar.DAY_OF_MONTH, 0);
        end = c.getTime();
        break;
      case 2:
        c.set(Calendar.MONTH, 3);
        start = c.getTime();
        c.set(Calendar.MONTH, 6);
        c.set(Calendar.DAY_OF_MONTH, 0);
        end = c.getTime();
        break;
      case 3:
        c.set(Calendar.MONTH, 6);
        start = c.getTime();
        c.set(Calendar.MONTH, 9);
        c.set(Calendar.DAY_OF_MONTH, 0);
        end = c.getTime();
        break;
      case 4:
        c.set(Calendar.MONTH, 9);
        start = c.getTime();
        c.set(Calendar.MONTH, 12);
        c.set(Calendar.DAY_OF_MONTH, 0);
        end = c.getTime();

        break;
      default:
        throw new IllegalArgumentException("季度错误！");
    }
    dates[0] = start;
    dates[1] = end;
    return dates;
  }


  public static String accuracy(double num, double total, int scale) {
    DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
    //可以设置精确几位小数
    df.setMaximumFractionDigits(scale);
    //模式 例如四舍五入
    df.setRoundingMode(RoundingMode.HALF_UP);
    double accuracy_num = num / total * 100;
    return df.format(accuracy_num) + "%";
  }
}

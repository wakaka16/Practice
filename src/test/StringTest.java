package test;



/**
 * 字符串含""测试 结论：含有
 */
public class StringTest {

  public static void addTest() {
    int j = 10;
    long f = j;
    System.out.println(f);
    System.out.println('a' + 7 + "hell0");
  }


  public static void equalsTest() {
    String a = "Programming";
    String b = new String("Programming");
    String c = "Program" + "ming";
    System.out.println(a == b);
    System.out.println(a == c);
    System.out.println(a.equals(b));
    System.out.println(a.equals(c));
    System.out.println(a.intern() == b.intern());
  }

  public static void blankTest() {
    String str = "";
    String[] t = str.split("\\|");
    System.out.println(t.length);
    for (int i = 0; i < t.length; i++) {
      System.out.println(t[i]);
    }

  }

  public static Double strToDouble(String str) {
    StringBuilder sb = new StringBuilder();
    char[] chars = str.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] >= '0' && chars[i] <= '9') {
        sb.append(chars[i]);
      }
    }
    return Double.valueOf(sb.toString());
  }

  /**
   *
   * @param price
   * @return
   */
  private static Double[] changePrice(String price) {
    Double[] prices = {0.0, 0.0};
    if (null == price || price.equals("")) {
      return prices;
    }
    if (price.indexOf("以内") != -1) {
      prices[0] = strToDouble(price);
    } else if (price.indexOf("以上") != -1) {
      prices[1] = strToDouble(price);
    } else {
      String[] strs = price.split("-");
      prices[0] = strToDouble(strs[0]);
      prices[1] = strToDouble(strs[1]);
    }
    return prices;
  }


  public static void main(String[] args) {
//        equalsTest();
//        String s = "5";
//        ConstCache constCache = new ConstCache();
//        System.out.println(constCache.s==s);
//        String price = "50万以";
//        System.out.println(price.indexOf("以内"));//3
//        System.out.println(price.substring(0,2));
//        System.out.println(price.matches("[0-9]"));
//            String[] strs = "50万-100万".split("-");
//        for (Double str:changePrice("50万以内")) {
//            System.out.println(str);
//        }

  }


}

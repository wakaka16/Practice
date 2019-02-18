package base64;

public class ImageTest {

  public static void main(String[] args) {
    String str = "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAoAAAAHgCAYAAAA10dz";

    String imgStr = str.substring(str.indexOf(",") + 1);
    System.out.println(imgStr);

    Integer[] faceTypes2 = {1};
    System.out.println(faceTypes2.length);

  }

}

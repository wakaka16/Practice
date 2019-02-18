package integer;

public class Test {

  public static byte[] intToByteBuf(int i) {
    byte[] result = new byte[4];
    result[0] = (byte) ((i >> 24) & 0xFF);
    result[1] = (byte) ((i >> 16) & 0xFF);
    result[2] = (byte) ((i >> 8) & 0xFF);
    result[3] = (byte) (i & 0xFF);
    return result;
  }

  public static void main(String[] args) {
    String s = Integer.toBinaryString(5);
    System.out.println(s);
    byte[] bytes = intToByteBuf(129);
    for (byte b:bytes) {
      System.out.print(b+",");
    }
  }

}

package reponsibility;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * 文字水印、自定义文字的处理器
 */
public class MarkStringImageHandler extends ImageHandler {

  private String markValue;//文字形式的水印
  private int fontSize = 20;//字体大小（默认为20）
  private int transparency = 255;//透明度(默认255)
  private int x = 0;//横向
  private int y = 0;//纵向

  /**
   * 构造函数
   *
   * @param nextHandler 可能存在的下一个处理器
   * @param markValue 水印的文字信息
   */
  public MarkStringImageHandler(ImageHandler nextHandler, String markValue, int fontSize,
      int transparency, int x, int y) {
    super(nextHandler);
    this.markValue = markValue;
    this.fontSize = fontSize;
    this.transparency = transparency;
    this.x = x;
    this.y = y;
  }

  @Override
  public BufferedImage handImage(BufferedImage srcImage) {
    // 这是画笔，由于不需要进行图片大小、宽高的改变。这里直接在原来的BufferedImage上绘画就行了
    Graphics graphics = srcImage.getGraphics();
    // 从2017-08-09 开始，水印在左上方，并且支持多行文本（通过#标记进行换行）
    String[] markValueLines = this.markValue.split("#");//参数中#代表换行
    // 2017-11-28，注意文字底部要有一个灰度蒙层，保证字迹的可见性
    int mongoliaImageWidth = srcImage.getWidth();
    int mongoliaImageHeight = markValueLines.length * (this.fontSize + 2);
    BufferedImage mongoliaImage = new BufferedImage(mongoliaImageWidth, mongoliaImageHeight,
        BufferedImage.TYPE_INT_ARGB);
    for (int withIndex = 0; withIndex < mongoliaImageWidth; withIndex++) {
      for (int heightIndex = 0; heightIndex < mongoliaImageHeight; heightIndex++) {
        mongoliaImage.getAlphaRaster().setPixel(withIndex, heightIndex, new int[]{100, 20, 20, 20});
      }
    }
    // 得到画笔，准备在原图片上添加水印
    Graphics mongoliaGraphics = mongoliaImage.createGraphics();
    // 处理得相对简单一些，正常生产环境下，还可以设置透明图，位置等等
    mongoliaGraphics.setFont(new Font("宋体", Font.BOLD, this.fontSize));
    mongoliaGraphics.setColor(new Color(255, 255, 255, this.transparency));
    int index = 0;
    for (; index < markValueLines.length; index++) {
      mongoliaGraphics.drawString(" " + markValueLines[index], 0, this.fontSize * (index + 1));
    }
    graphics.drawImage(mongoliaImage, this.x, this.y, null);
    // 开始处理
    graphics.dispose();
    // 继续进行下一个处理
    BufferedImage nextResults = this.doNextHandler(srcImage);
    if (nextResults == null) {
      return srcImage;
    }
    return nextResults;
  }
}
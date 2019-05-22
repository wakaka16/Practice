package reponsibility;

import java.awt.image.BufferedImage;

/**
 * 图片比例处理
 */
public class ZoomImageHandler extends ImageHandler {

  ZoomImageHandler(ImageHandler nextImageHandler) {
    super(nextImageHandler);
  }

  @Override
  public BufferedImage handImage(BufferedImage bufferedImage) {
    System.out.println("图片比例处理...");
    BufferedImage nextResults = doNextHandler(bufferedImage);
    return nextResults;
  }
}

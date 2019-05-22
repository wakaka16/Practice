package reponsibility;

import java.awt.image.BufferedImage;

/**
 * 图片处理器
 */
public abstract class ImageHandler {

  /**
   * 处理链: 通过传入下一个处理器，来处理下一个处理任务
   */
  private ImageHandler nextImageHandler;

  //1、有些要子类实现：有些不让子类实现===抽象类
  //2、要给本类的传递参数：
  // 由于1，不能创建对象；
  // 使用静态方法，由于参数nextImageHandler不能是静态的，false
  //3、采用构造方法传参,由于为抽象，子类构造传参
  ImageHandler(ImageHandler nextImageHandler) {
    this.nextImageHandler = nextImageHandler;
  }

  protected BufferedImage doNextHandler(BufferedImage bufferedImage) {
    if (this.nextImageHandler != null) {
      return this.nextImageHandler.handImage(bufferedImage);
    }
    return null;
  }

  /**
   * 处理图片
   */
  protected abstract BufferedImage handImage(BufferedImage bufferedImage);

}

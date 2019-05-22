package reponsibility;

import java.util.ArrayList;
import java.util.List;

/**
 * 图片处理器创建者
 */

public final class ImageHandlerBuilder {

  public ImageHandlerBuilder(){}


  /**
   * 图片处理器创建者
   */
  private static class Builder{
    //创建处理器的模板(关于具体处理器的描述)
    private List<ImageHandlersDescribe> imageHandlersTemplates = new ArrayList<>();

    /**
     * 设字符形式的图片水印处理器模板
     * @param markValue 水印字符串
     */
    public Builder markStringImageHandlerTemplate(String markValue , Integer fontSize) {
      ImageHandlersDescribe describe = new ImageHandlersDescribe();
      describe.setMarkValue(markValue);
      describe.setFontSize(fontSize);
      describe.setImageHandlerClass("yinwenjie.sample.image.service.MarkStringImageHandler");
      imageHandlersTemplates.add(describe);
      return this;
    }

    /**
     * 图片缩放处理器模板(按比例)
     * 设定一个需要创建的图片缩放处理器，按照设定的比例进行缩放
     * @param ratio 缩放比例是一个0-1的浮点数，数值大于0小于1
     */
    public Builder zoomImageHandlerTemplate(float ratio) {
      ImageHandlersDescribe describe = new ImageHandlersDescribe();
      describe.setRatio(ratio);
      describe.setImageHandlerClass("yinwenjie.sample.image.service.ZoomImageHandler");
      imageHandlersTemplates.add(describe);
      return this;
    }

    /**
     * 图片缩放处理器模板(按宽高)
     * @param width 指定缩放的宽度
     * @param height 指定缩放的高度
     */
    public Builder zoomImageHandlerTemplate(int width, int height) {
      ImageHandlersDescribe describe = new ImageHandlersDescribe();
      describe.setWidth(width);
      describe.setHeight(height);
      describe.setImageHandlerClass("yinwenjie.sample.image.service.ZoomImageHandler");
      imageHandlersTemplates.add(describe);
      return this;
    }


    /**
     * 递归创建处理器,从处理器模板库中获取处理器模板,创建为处理器对象
     * @param index 当前正在创建的处理器在imageHandlersTemplates中的位置
     */
    private ImageHandler nextImageHandler(int index) {
      if (index + 1 > imageHandlersTemplates.size()) {
        return null;
      }
      ImageHandlersDescribe imageHandlersDescribe = imageHandlersTemplates.get(index);
      //各种条件比较,然后创建
//      if(imageHandlersDescribe.equals("yinwenjie.sample.image.service.ZoomImageHandler")){
//        return new ZoomImageHandler(this.nextImageHandler(++index));
//      }
//      if(imageHandlersDescribe.equals("yinwenjie.sample.image.service.MarkStringImageHandler")){
//        return new MarkStringImageHandler(this.nextImageHandler(++index));
//      }
      return null;
    }

    /**
     * 图片处理器创建者开始创建...
     * 作用:迭代创建处理器参数初始化
     * @return
     */
    public ImageHandler build() {
      return this.nextImageHandler(0);
    }
  }

  /**
   * 所有图片处理器的描述
   * 参数、Class
   */
//  @Data
  private static class ImageHandlersDescribe{
    private Float ratio;//处理的比例描述
    private Integer width;//处理的宽度描述
    private Integer height;//处理的高度描述
    private String markValue;//可能的水印信息
    private Integer fontSize = 20;//可能的水印字体大小，默认为20
    private int transparency = 255;//透明度(默认255)
    private int x = 0;//横向（水印/文字位置）
    private int y = 0;//纵向（水印/文字位置）
    private String imageHandlerClass;//需要实例化的具体图片处理器

    public Float getRatio() {
      return ratio;
    }

    public void setRatio(Float ratio) {
      this.ratio = ratio;
    }

    public Integer getWidth() {
      return width;
    }

    public void setWidth(Integer width) {
      this.width = width;
    }

    public Integer getHeight() {
      return height;
    }

    public void setHeight(Integer height) {
      this.height = height;
    }

    public String getMarkValue() {
      return markValue;
    }

    public void setMarkValue(String markValue) {
      this.markValue = markValue;
    }

    public Integer getFontSize() {
      return fontSize;
    }

    public void setFontSize(Integer fontSize) {
      this.fontSize = fontSize;
    }

    public String getImageHandlerClass() {
      return imageHandlerClass;
    }

    public void setImageHandlerClass(String imageHandlerClass) {
      this.imageHandlerClass = imageHandlerClass;
    }
  }



}

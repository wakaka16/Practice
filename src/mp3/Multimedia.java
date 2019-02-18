package mp3;

public interface Multimedia {
	/**
	 * 音频
	 */
	public final static int TYPE_AUDIO = 1;
	/**
	 * 视频
	 */
	public final static int TYPE_VEDIO = 2;

	/**
	 * 媒体格式转换
	 * 
	 * @param sourceFile
	 *            导入媒体文件
	 * @param targetFile
	 *            导出媒体文件
	 * @return
	 */
	public boolean convert(String sourceFile, String targetFile);
}

package mp3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import test.StringUtils;

public class VedioSh2 {

	public boolean convert(String sourceFile, String targetFile) {
		boolean flag = true;
		try {
			// 执行命令
			String cmd = "d:/convert.bat " + sourceFile + " " + targetFile;
			System.out.println(cmd);
			Process proc = Runtime.getRuntime().exec(cmd);
			InputStream stderr = proc.getErrorStream();
			InputStreamReader isr = new InputStreamReader(stderr);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null)
				System.out.println(line);
			int exitVal = proc.waitFor();
			flag = (exitVal == 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}


}

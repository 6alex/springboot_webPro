/**
 * 
 */
package com.wen.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

import org.mockito.internal.stubbing.answers.ThrowsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wen.wechatCrawler.WxAccountCrawler;

/**
 * @author wencun
 * @date 2018年10月26日 下午5:00:05
 * @version 1.0
 * @since JDK 1.8
 */
public class fileUtil {
	public static final Logger LOG = LoggerFactory.getLogger(fileUtil.class);
	/**
	 * 纯文本读取成String
	 * @author wencun
	 * @date: 2018年10月26日 下午5:58:49
	 * @param fileName
	 * @return
	 */
	public static String readTxtFile(String fileName) {
		StringBuffer result = new StringBuffer();
		try {
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String rd = null;
			while ((rd = reader.readLine()) != null) {
				result.append(System.lineSeparator() + rd);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();

	}

	/**
	 * inFile内容添加到outFile
	 * @author wencun
	 * @date: 2018年10月26日 下午5:58:13
	 * @param inFile
	 * @param outFile
	 */
	public static void copyFile(String inFile,String outFile) {
		File infile = new File(inFile);
		File outfile = new File(outFile);
		try {
			if (!infile.exists()) {
				LOG.info("文件不存在!");
			     return; 
			}
			BufferedInputStream in=new BufferedInputStream(new FileInputStream(infile));
			BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(outfile,true));//  true可往后添加；
			byte[] arr=new byte[1024*8];// 定义小数组如果是8192个字节大小和Buffered比较的话定义小数组会略胜一筹,因为读和写操作的是同一个数组而Buffered操作的是两个数组
			int r;
			while ((r=in.read(arr))!=-1) {
				out.write(arr,0,r);
			}
			in.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		String readFile = readTxtFile("src/main/resources/application.yml");
		copyFile("src/main/resources/application.yml", "工作日志.txt");
		System.err.println(readFile);
	}
}

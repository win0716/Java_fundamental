package java_20190801;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamDemo2 {
	//중요
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream("c:\\dev\\test\\jdk.exe");
			fos = new FileOutputStream("c:\\dev\\test\\2019\\8\\1\\jdk.exe");
			int readByteCount = 0;
			byte[] b = new byte[1024*30];
			//fis.read(b) ==> File InputStream에 1024바이트를 읽어서
			//b에 저장하고 읽은 바이트수를 반환한다.
			long start = System.currentTimeMillis();
			while((readByteCount = fis.read(b)) != -1) {
				fos.write(b,0,readByteCount);
				
			}
			long end = System.currentTimeMillis();
			System.out.println("경과시간 : " + (end - start));
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis != null) fis.close();
				if(fos != null) fos.close();
					
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}

package java_20190808.file.client;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;



public class FileClient {
	private String ip;
	private int port;

	public FileClient(String ip, int port) {
		this.ip = ip;
		this.port = port;
	}

	public void run() {
		Socket socket = null;
		OutputStream out = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		InputStream in = null;
		FileOutputStream fos = null;

		try {

			socket = new Socket(ip, port);

			out = socket.getOutputStream();

			osw = new OutputStreamWriter(out);
			bw = new BufferedWriter(osw);
			bw.write("homework_20190905.docx");
			bw.newLine();
			bw.flush();

			in = socket.getInputStream();
			File f = new File("C:\\dev\\test");
			f.mkdirs();
			f = new File(f, "homework_20190905.docx");
			fos = new FileOutputStream(f);
			byte[] readBytes = new byte[1024 * 8];
			int readByteCount = 0;
			while ((readByteCount = in.read(readBytes)) != -1) {
				fos.write(readBytes, 0, readByteCount);
			}

		} catch (UnknownHostException e) {
			System.out.println("서버주소가 잘못!");

		} catch (IOException e) {
			System.out.println("서버가 죽었오!");
		} finally {
			try {
				if (out != null)
					out.close();
				if (osw != null)
					osw.close();
				if (bw != null)
					bw.close();
				if (in != null)
					in.close();
				if (socket != null)
					socket.close();
				if (fos != null)
					fos.close();
			} catch (IOException e2) {

			}
		}

	}

	public static void main(String[] args) {
		new FileClient("192.168.0.52", 4000).run();
	}

}



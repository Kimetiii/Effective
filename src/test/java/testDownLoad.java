import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author songsenior
 * @date 2020/2/15 08:54
 * @Description:
 */
public class testDownLoad {

	public static void main(String[] args) {
		String model = "samamxx";
		String url = "";
		String temId = "35";
		String name = "网袜";
		int temInt = 50;
		File file = new File("d:/Picture/download/" + name);
		if (!file.exists()) {
			file.mkdir();
		}
		for (int i = 8; i <= temInt; i++) {
			if (i < 10) {
				url = "http://img.itmtu.com/mm/s/" + model + "/NO.0" + temId + "/000" + i + ".jpg";
			} else {
				url = "http://img.itmtu.com/mm/s/" + model + "/NO.0" + temId + "/00" + i + ".jpg";
			}
			String path = "d:/Picture/download/" + name + "/" + name + "" + i + ".jpg";
			downloadPicture(url, path);
			System.out.println(name + temId + "success download {" + i + "} picture" + temInt);
		}
	}

	@Test
	public void test() {}

	private static void downloadPicture(String urlList, String path) {
		URL url = null;
		try {
			url = new URL(urlList);
			DataInputStream dataInputStream = new DataInputStream(url.openStream());
			File file = new File(path);
			FileOutputStream fileOutputStream = new FileOutputStream(file);
			ByteArrayOutputStream output = new ByteArrayOutputStream();

			byte[] buffer = new byte[1024];
			int length;

			while ((length = dataInputStream.read(buffer)) > 0) {
				output.write(buffer, 0, length);
			}
			fileOutputStream.write(output.toByteArray());
			dataInputStream.close();
			fileOutputStream.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}




	class TestThread implements Runnable {
		@Override
		public void run() {
			System.out.println(Thread.currentThread().getName());
		}
	}

	public static class DeadLockDemo {
		private static Object resource1 = new Object();//资源 1
		private static Object resource2 = new Object();//资源 2

	}
}

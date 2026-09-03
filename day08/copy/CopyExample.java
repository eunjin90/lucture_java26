package copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {
	
	public static void main(String[] args) {
		System.out.println("파일 복사를 시작합니다.");
//		copyImgeFileByteArr();
		copyTextFile();
		System.out.println("파일 복사를 완료하였습니다.");
	}
	
	public static void copyImgeFileByte() {
		String sourceFilename = "Curi_01.jpg";
		String targetFilename = "Curi_01_copied.jpg";
		
		try {
			InputStream fis = new FileInputStream(sourceFilename);
			OutputStream fos = new FileOutputStream(targetFilename);
			
			while (true) {
				int bytedata = fis.read();
				if (bytedata == -1) break;
				fos.write(bytedata);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void copyImgeFileByteArr() {
//		String sourceFilename = "Curi_01.jpg";
//		String targetFilename = "Curi_01_copied.jpg";
		String sourceFilename = "AtMyOwnPace.txt";
		String targetFilename = "AtMyOwnPace_copied.txt";
		
		try {
			InputStream fis = new FileInputStream(sourceFilename);
			OutputStream fos = new FileOutputStream(targetFilename);
			
			while (true) {
				byte[] byteArr = new byte[100];
				int numbytes = fis.read(byteArr);
				if (numbytes == -1) break;
				fos.write(byteArr);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void copyTextFile() {
		String sourceFilename = "AtMyOwnPace.txt";
		String targetFilename = "AtMyOwnPace_copied.txt";
		
		try (FileReader fr = new FileReader(sourceFilename);
				FileWriter fw = new FileWriter(targetFilename)){
			while (true) {
				int chardata = fr.read();
				if (chardata == -1) break;
				System.out.println(chardata);
//				fw.write(chardata);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}

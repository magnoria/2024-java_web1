package day09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Example2 {
	public static void main(String[] args) {
		
		//[2] 파일의 자료를 자바로 가져오기 (입력)
		// - FileInputStream in = new FileInputStream("파일경로");
		// - Example1 클래스에서 저장한 파일로 작성
		// - 예외처리
		try {
			//(1) 파일입력스트림 객체 생성
			FileInputStream in = new FileInputStream("c:/java/test1.txt");
			//(2) 바이트  배열 선언 , 임의의크기 10 (영문10글자 = 영/특수문자 1글자당 1바이트, 한글 1글자당 3바이트)
			byte[] bytes = new byte[10];
			//(3) 파일내 자료를 바이트열로 읽어오기 , read(바이트배열변수명)
			in.read(bytes);
			//(4) 바이트배열을 문자열로 변환, new String(바이트배열변수명)
			String str = new String(bytes);
			System.out.println(str);
			System.out.println("파일 불러오기 성공");
		}catch (FileNotFoundException e) {System.out.println(e);}
		catch (IOException e) {System.out.println(e);}
		
		
	}//main end
}

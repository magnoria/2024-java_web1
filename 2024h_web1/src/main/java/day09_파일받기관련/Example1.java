package day09_파일받기관련;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

//서블릿 x
public class Example1 {
	public static void main(String[] args) {
		
		// [1] 실행중인 자바 자료를 (윈도우)파일에 출력(쓰기)하기
			// - FileOutputStream out = new FileOutputStream("파일경로");
			// - c드라이브에 'java' 폴더를 하나 생성하기
			// - 예외처리
		try {
			// (1) 파일출력스트림 객체를 생성한다. -1. 파일경로 2.예외처리 필수
		FileOutputStream out = new FileOutputStream("c:/java/test1.txt");
		//(2) 출력할 문자열
			String str = "Hello JAVA";
			//(3) 출력할 문자열을 바이트열로 변환. - "".getBuytes() : String --> byte[] 반환함수.
			byte[] outStr = str.getBytes();
			// (4) 출력스트림 객체내 출력 함수로 바이트열 내보내기 .write(출력할바이트), -예외처리 필수
			out.write(outStr);// 일반오류 가 기본적으로 뜸
		}catch (FileNotFoundException e) {System.out.println(e);}
		catch (IOException e) {
			System.out.println(e);
		}
		
		
		// [2] 키보드로부터 입력받은 자료를 파일에 출력하기.
		try {
		FileOutputStream out = new FileOutputStream("c:/java/test2.txt");
		Scanner scan = new Scanner(System.in);
		System.out.println("[2] 메모장에 작성할 내용입력 :");
		String str = scan.nextLine(); //띄어쓰기 입력도 가능
		byte[] outStr = str.getBytes();
		out.write(outStr);
		System.out.println("파일저장성공2");
		}catch (IOException e) {
			System.out.println(e);
		}
		
		
		//[3] 파일 클래스
			//(1) 지정한 경로의 파일을 자바 객체와 연결하기.
		File file = new File("c:/java/test1.txt");
			//(2) 파일 존재 여부 확인 메소드
		System.out.println(file.isFile());
			//(3) 파일 이름 반환 메소드
		System.out.println(file.getName());
			//(4) 파일 존재 여부 반환 메소드
		System.out.println(file.exists());
			//(5) 파일 용량(바이트) 반환 메소드
		System.out.println(file.length());
			//(6) 파일 삭제 함수.
		System.out.println(file.delete()); 
			//(7) 파일 경로 찾기
		System.out.println(file.getPath());
			//(8)
		File file2 = new File("c:/jvava");
		if (!file2.exists()) {// 만일 java2 폴더가 존재하지 않으면
			file2.mkdir();// 지정한 경로의 폴더 생성 함수
		}
	}// main end
}// class end

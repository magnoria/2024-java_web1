package day07_배열과세션;

import java.util.ArrayList;

//서블릿x
public class Example {
	public static void main(String[] args) { // 실행 : Javaj Application
		//[1] Box1 인스턴스 생성 , new Box1();
		Box1 box1 = new Box1();
		box1.content = "안녕하세요";		// 인스턴스 내 멤버변수의 값 대입
		String content1 = box1.content; // 인스턴스 내 멤버변수의 값 호출/반환
		
		//[2] Box2 인스턴스 생성 , new Box2();
		Box2 box2 = new Box2();
		box2.content = 100;
		int content2 = box2.content;
		
		
		//[3] 특정 인스턴스의 하나의 멤버변수가 여러 타입을 가질 수 있는지?
		// 방법1] 다형성 : 다양한 타입으로 변환이 가능한 성질 , 최상위 클래스 = Object	, 타입변환
		
		Box3 box3 = new Box3();
		box3.content = "안녕하세요"; 					//자동타입변환 , 자식(String) --> 부모(OBject) , 업캐스팅
		String content3 =(String) box3.content; 	//강제타입변환 , 부모(Object) --> 자식(String) , 다운캐스팅
		box3.content = 100;							//오브젝트가 상위클래스라서 하위클래스를 다 포함하고 있어서
		int content4 = (Integer)box3.content;		// 타입변환필요
		//방법2] 제네릭타입 : 클래스 내 멤버변수 타입을 인스턴스를 생성할때 정하기.
		Box4<String> box4 = new Box4<String>();
		box4.content = "안녕하세요";
		String content5 = box4.content;
		Box4<Integer> box5 = new Box4<>();
		int content6 = box5.content;
		
	
	// [4] 제네릭 대표적인 사용처
		// -> 1. String 타입 인스턴스들을 여러개 저장하는 ArrayList 인스턴스
	ArrayList<String> sList = new ArrayList<String>();
		// -> 2. Dto 타입 인스턴스들을 여러개 저장하는 ArrayList 인스턴스
	ArrayList<Dto> dtoList = new ArrayList<Dto>();
		// * 게시물 1개 조회 : Dto , *게시물 여러개 조회 :ArrayList<Dto>
	
	// [5] 제네릭타입 여러개
	Point <String , Integer> point = new Point<>();
	point.value1 = "안녕하세요"; //제네릭타입에 String 타입을 대입했으므로 가능.
	point.value2 = 100;
	
	Point<Double ,Dto> point2 = new Point<>();
	point2.value1 = 100.0;
	point2.value2 = new Dto();
	
	}// main end
	
	
}//class end


class Box1{String content;}
class Box2{int content;}
class Box3{Object content;}
class Box4< T >{
	// 클래스명< 제네릭타입>{}
	T content;
}
class Dto{}
class Point<T,V>{
	T value1;
	V value2;
}
package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter@ToString //룸복을 이용한 getter and setter/ ToString 메소드 자동 생성
@NoArgsConstructor@AllArgsConstructor // 기본생성자 and 전체 매개변수 생성자를 자동생성
public class BoardDto {
	 private int bno;            // 게시물번호  
	    private String btitle;                // 게시물제목 
	    private String bcontent;        // 게시물내용
	    private int bview;                        // 게시물조회수 
	    private String bdate;                // 게시물작성일
	    private int mno;                         // 작성자의 회원번호 
	    private int cno;                        // 카테고리의 번호 
	    // + HTML에 출력할때 작성자의 회원번호가 아닌 작성자 ID 출력 
	    private String mid;
	    // + HTML에 출력할때 카테고리의 번호가 아닌 카테고리명을 출력 
	    private String cname;

}//class end

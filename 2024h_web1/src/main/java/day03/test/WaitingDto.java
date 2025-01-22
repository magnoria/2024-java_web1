package day03.test;

public class WaitingDto {
	
	private int num;
	private String people;
	private String ponnumber;
	
	
	public WaitingDto() {}


	public WaitingDto(int num, String people, String ponnumber) {
		super();
		this.num = num;
		this.people = people;
		this.ponnumber = ponnumber;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getPeople() {
		return people;
	}


	public void setPeople(String people) {
		this.people = people;
	}


	public String getPonnumber() {
		return ponnumber;
	}


	public void setPonnumber(String string) {
		this.ponnumber = string;
	}


	@Override
	public String toString() {
		return "WaitingDto [num=" + num + ", people=" + people + ", ponnumber=" + ponnumber + "]";
	}


	
	
	
}//class end

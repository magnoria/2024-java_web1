package day03.task4;

public class WaitingDto {
	
	private int num;
	private String people;
	private int ponnumber;
	
	
	public WaitingDto() {}


	public WaitingDto(int num, String people, int ponnumber) {
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


	public int getPonnumber() {
		return ponnumber;
	}


	public void setPonnumber(int ponnumber) {
		this.ponnumber = ponnumber;
	}


	@Override
	public String toString() {
		return "WaitingDto [num=" + num + ", people=" + people + ", ponnumber=" + ponnumber + "]";
	}


	
	
	
}//class end

package day03.task2;

public class WaitingDto {
	private String people;
	private String ponnumber;
	
	
	
	
	public WaitingDto() {}
	
	public WaitingDto(String people, String ponnumber) {
		super();
		this.people = people;
		this.ponnumber = ponnumber;
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

	public void setPonnumber(String ponnumber) {
		this.ponnumber = ponnumber;
	}
	
	
	
}//class end

package day03.task1;

public class VisitDto {
	private String contnet;
	private int age;
	
	public VisitDto() {}

	public VisitDto(String contnet, int age) {
		super();
		this.contnet = contnet;
		this.age = age;
	}

	public String getContnet() {
		return contnet;
	}

	public void setContnet(String contnet) {
		this.contnet = contnet;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "VisitDto [contnet=" + contnet + ", age=" + age + "]";
	}

	
}

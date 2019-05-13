package ss.week1;

public class Student {

	private String name;
	private int stdnum;
	private double score;
	
	public Student(String name, int stdnum, double score) {
		super();
		this.name = name;
		this.stdnum = stdnum;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStdnum() {
		return stdnum;
	}

	public void setStdnum(int stdnum) {
		this.stdnum = stdnum;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	public boolean passed() {
		return (this.getScore() >= 70); 
	
		
	}
	
}



public class UndergraduateMathematics {
	private int level;
	private double average;
	
	public UndergraduateMathematics(int level, double average)
	{
		this.level = level;
		this.average = average;
	}
	
	/**
	 * @return the level
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	/**
	 * @return the average
	 */
	public double getAverage() {
		return average;
	}
	/**
	 * @param avarage the average to set
	 */
	public void setAverage(double avarage) {
		this.average = avarage;
	}
}

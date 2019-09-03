/**
 * Class UndergraduateMathematics models the undergraduate mathematics details of an applicant.
 * @author FYTTAN001, LXXWEN005, MCKROB018
 */
public class UndergraduateMathematics {
	private int level;
	private double average;
	
	/**
	 * Standard constructor, creates an UndergraduateMathematics object from the specified fields.
	 * @param level
	 * @param average
	 */
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

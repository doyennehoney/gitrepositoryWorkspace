import model.Events;

public class Data extends Events{
	int size;
	//not sure how it works yet but I'll fu=igure it out
	//int grid[][];
	double susceptible, infected, recovered;
	public Data(int size, double susceptible,  double infected, double recovered) {
		// TODO Auto-generated constructor stub
		this.size = size;
		this.susceptible = susceptible;
		this.infected = infected;
		this.recovered = recovered;				
	}
//	public Data(int [][] grid) {
//		// TODO Auto-generated constructor stub
//		this.grid = grid;
//	}
	public Data(double susceptible,  double infected, double recovered) {
		// TODO Auto-generated constructor stub
		this.susceptible = susceptible;
		this.infected = infected;
		this.recovered = recovered;		
	}
	public void setSize(int size) {
		this.size = size;
	}
	public void setSusceptible(double susceptible) {
		this.susceptible = susceptible;
	}
	public void setInfected(double infected) {
		this.infected = infected;
	}
	public void setRecovered(double recovered) {
		this.recovered = recovered;
	}
	public int getSize() {
		return size;
	}
	public double getSusceptible() {
		return susceptible;
	}
	public double getInfected() {
		return infected;
	}
	public double getRecovered() {
		return recovered;
	}
	@Override
	public String toString() {
		return "Data [getSize()=" + getSize() + ", getSusceptible()=" + getSusceptible() + ", getInfected()="
				+ getInfected() + ", getRecovered()=" + getRecovered()  + "]";
	}

}

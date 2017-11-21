import model.Events;

public class Data extends Events{
	private double size, susceptible, infected, recovered;
	public Data(double size, double susceptible,  double infected, double recovered) {
		this.size = size;
		this.susceptible = susceptible;
		this.infected = infected;
		this.recovered = recovered;				
	}

	public void setSize(double size) {
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
	public double getSize() {
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
		return  "       "+getSize()+ ",   " + getSusceptible() + ",    " + getInfected() + ",        " + getRecovered()  ;
	}
	
	public String toStringCopy() {
		return "Data [ getSize()="+ getSize()+ ", getSusceptible()=" + getSusceptible() + ", getInfected()="
				+ getInfected() + ", getRecovered()=" + getRecovered()  + "]";
	}

}

import java.util.Random;

import model.AtomicModel;
import model.Port;

public class Epidemiology extends AtomicModel {

	Port gridIn, gridOut;
	Random rand;
	Data dataGrid[][];
	int popGrid[][];
	
	double susceptible;
	double infectious;
	double recovery;
	double sigma;
	
	public Epidemiology(String name, String desc, int x, int y) {
		// TODO Auto-generated constructor stub
		super();
		
		gridIn = new Port();
		gridOut = new Port();
		
		addInputPort(gridIn, "Input");
		addOutputPort(gridOut, "Out_port");
		
		rand = new Random();
		
		popGrid = new int[x][y];
		dataGrid= new Data[x][y];
		for(int i = 0; i<dataGrid.length; i++) {
			for(int j = 0; j<dataGrid[i].length; j++) {
				dataGrid[i][j] = new Data(9.0,1.0,0.0);
			}
		}
		
		

	}

	@Override
	public void deltaConf() {
		// TODO Auto-generated method stub
		deltaInt();deltaExt(1);
		
	}

	@Override
	public void deltaExt(double arg0) {
		// TODO Auto-generated method stub
		System.out.println("			Epidemiology Grid DeltaExt:Before ");
		for(int p = 0; p<gridIn.getEvents().size(); p++) {	
			popGrid = ((Grid)gridIn.getEvents().get(p)).getPopGrid();
		}
		
		System.out.println("			Epidemiology Grid DeltaExt: After");
	}

	@Override
	public void deltaInt() {
		// TODO Auto-generated method stub
		int old_pop; 
		double beta = 0.00001, gamma = 0.3;
		for(int i=0; i<dataGrid.length; i++) {
			 for(int j=0; j<dataGrid[i].length; j++) {
				old_pop = popGrid[i][j];
				System.out.println("			Epidemiology Grid DeltaInt: old_pop "+ old_pop);
				System.out.println("			Epidemiology Grid DeltaInt: Inside"  + dataGrid[i][j].toString()); 
		/** Using SIR model
		 * Beta = 0.45, Gamma = 0.3
		 * **/ if (old_pop == 0){ break;}
//				susceptible = (int)Math.round( susceptible*(1-(beta*infectious)/old_pop));
//				infectious = (int) Math.round(infectious*(1+(susceptible/old_pop) -infectious));
		 		
				susceptible = Math.round(-(beta*dataGrid[i][j].getSusceptible()*dataGrid[i][j].getInfected())/old_pop);
				infectious = Math.round((beta*dataGrid[i][j].getSusceptible()*dataGrid[i][j].getInfected())/old_pop - (gamma*dataGrid[i][j].getInfected()));
				recovery = old_pop-susceptible-infectious;
		 		//recovery  = ((1/gamma)*infectious);
				double total = susceptible+infectious+recovery;
		System.out.println("Susceptible : "+susceptible+" infectiuos : "+ infectious + " recovery : "+recovery+" total :"+total);
		dataGrid[i][j].setSusceptible(susceptible);dataGrid[i][j].setInfected(infectious);dataGrid[i][j].setRecovered(recovery);
			}
		}
		
	}

	@Override
	public void lambda() {
		// TODO Auto-generated method stub
		//gridOut.addEvent(new Grid(grid));
		gridOut.addEvent(new Grid(dataGrid));
		System.out.println("			Epidemiology Grid : ");
		
	}

	@Override
	public double ta() {
		// TODO Auto-generated method stub
		return 1;
	}

}

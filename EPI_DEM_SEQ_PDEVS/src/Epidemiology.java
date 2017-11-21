import model.AtomicModel;
import model.Port;

public class Epidemiology extends AtomicModel {

	Port gridIn, gridOut;
	Data dataGrid[][];
	
	double susceptible;
	double infectious;
	double recovery;
	double sigma;
	
	public Epidemiology(String name, String desc, int x, int y) {
		super();
		
		gridIn = new Port();
		gridOut = new Port();
		
		addInputPort(gridIn, "Input");
		addOutputPort(gridOut, "Out_port");
		
		dataGrid= new Data[x][y];		
	}

	@Override
	public void deltaConf() {
		deltaInt();deltaExt(1);		
	}

	@Override
	public void deltaExt(double arg0) {
		for(int p = 0; p<gridIn.getEvents().size(); p++) {	
			dataGrid = ((Grid)gridIn.getEvents().get(p)).getDataGrid();
		}		
	}

	@Override
	public void deltaInt() {
		// TODO Auto-generated method stub
		double old_pop; 
		
		if(dataGrid[0][0] != null){
			for(int i=0; i<dataGrid.length; i++) {
				 for(int j=0; j<dataGrid[i].length; j++) {
					old_pop = dataGrid[i][j].getSize();
					if (old_pop == 0){ break;}
			 		calcRate (dataGrid[i][j].getSusceptible(), dataGrid[i][j].getInfected(), dataGrid[i][j].getRecovered(),old_pop);
					dataGrid[i][j].setSusceptible(susceptible);
					dataGrid[i][j].setInfected(infectious);
					dataGrid[i][j].setRecovered(recovery);
				 }
			}
		}
	}

	@Override
	public void lambda() {
		gridOut.addEvent(new Grid(dataGrid));		
	}

	@Override
	public double ta() {
		return 1;
	}
	
	public void calcRate(double sus, double infect, double rec, double old_pop) {
		double beta = 0.333333333, gamma = 0.041666667;
		//double beta = 0.999, gamma = 0.001;
		susceptible = -(beta*sus*infect)/old_pop;
		infectious = (beta*sus*infect)/old_pop - (gamma*infect);
		recovery = gamma*infect;
		
		susceptible = sus+susceptible;
		infectious = infect+infectious;
		recovery = rec+recovery;
	}

}

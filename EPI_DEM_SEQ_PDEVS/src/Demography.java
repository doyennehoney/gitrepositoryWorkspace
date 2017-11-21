import model.AtomicModel;
import model.Port;

public class Demography extends AtomicModel {
	Port gridIn, gridOut, outView;
	Data dataGrid[][];
	int Min = 100, Max = 1000;int time;
	
	public Demography(String name, String desc, int x, int y) {
		super();
		
		gridIn = new Port();
		gridOut = new Port();
		outView = new Port();
		
		addInputPort(gridIn, "Inputs");
		addOutputPort(gridOut, "Out_port");
		addOutputPort(outView, "Out_view");
		
		double popSize;
		dataGrid= new Data[x][y];
		for(int i = 0; i<dataGrid.length; i++) {
			for(int j = 0; j<dataGrid[i].length; j++) {
				popSize =  Math.pow(Min + (Math.random() * ((Max - Min) + 1)), 2);
				dataGrid[i][j] = new Data (popSize, 0.999*popSize, 0.001*popSize, 0 );
			}
		}				
		
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
			time++;
			for(int i=0; i<dataGrid.length; i++) {
				 for(int j=0; j<dataGrid[i].length; j++) {
					old_pop = dataGrid[i][j].getSize();
			/**Using Open population with no population density
			* 
			* Birth rate = 0.0009 death rate = 0.00001, immigration = 0.02, emigration =0.01 
					grid[i][j] = (int) (old_pop + (0.02*old_pop)-(0.01*old_pop)+(0.02*old_pop)-(0.01*old_pop)); **/
			/** Using Closed population with no population density
			 * K(Growth rate for Nigeria between 2016 and 2017) = 0.25928853 for a year
			 * K(Growth rate for Nigeria per day) = 0.25928853/365
			 * **/
					System.out.println("Time : "+ time);
					dataGrid[i][j].setSize(old_pop*Math.exp(time * 0.25928853/365));
			/** Using Closed population with population density
			 *  k = carrying capacity
			 * 
					int k = 1000000;
					grid[i][j] = (int) (((0.02*old_pop)-(0.01*old_pop))*(1 - (old_pop / k)));**/
					
				}
			}
		}
		
		
	}

	@Override
	public void lambda() {
		gridOut.addEvent(new Grid(dataGrid));
		outView.addEvent(new Grid(dataGrid));
		System.out.println("TN is :"+this.getSimulator().getTN());
		
	}

	@Override
	public double ta() {
		return 1;
	}

}

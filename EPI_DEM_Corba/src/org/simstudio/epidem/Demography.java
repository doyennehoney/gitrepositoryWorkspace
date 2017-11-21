package org.simstudio.epidem;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.simstudio.model.AtomicModel;
import org.simstudio.model.Port;
import org.simstudio.proxy.ContractPackage.Events;

public class Demography extends AtomicModel {
	Port gridIn, gridOut;
	//Data[][] dataGrid;
	int Min = 100, Max = 1000;int time, t;
	double[] dataList;
	//Grid grid;
	
	PrintStream trajectory;
	
	public Demography(String name, String desc, int x, int y) {
		super(name);
		
		gridIn = new Port();
		gridOut = new Port();
		
		addInputPort(gridIn, "Input");
		addOutputPort(gridOut, "Out_port");
			
		
		double popSize;
		//dataGrid= new Data[x][y];
		dataList = new double[x*y];
		for(int i = 0; i<dataList.length; i++) {
			popSize =  Math.pow(Min + (Math.random() * ((Max - Min) + 1)), 2);
			dataList[i] = popSize;
		}			
		
		
//		grid = new Grid();
//		for(int i = 0; i<x; i++) {	
//			data = new DataArray();
//			for(int j = 0; j<y; j++) {
//				popSize =  Math.pow(Min + (Math.random() * ((Max - Min) + 1)), 2);
//				data.getItem().add(new Data (popSize, 0.999*popSize, 0.001*popSize, 0 ));
//				//data.getItem().add(new Data (100000, 0, 0, 0 ));
//			}
//			grid.getDataGrid().add(data);
//			
//		}
		
		try {
			trajectory = new PrintStream("Eftest.csv");
			trajectory.println("Time,Location,Population,Susceptible,Infectious,Recovered");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void deltaConf() {
		// TODO Auto-generated method stub
		deltaExt(1);deltaInt();
		
	}

	@Override
	public void deltaExt(double arg0) {
		// TODO Auto-generated method stub
		/*for(int p = 0; p<gridIn.getEvents().size(); p++) {				
			//dataGrid = ((Grid)gridIn.getEvents().get(p)).getDataGrid2();	
			grid = ((Grid)gridIn.getEvents().get(p));
		}*/
		
		/*for(int p = 0; p<((Grid)gridIn.getEvents().get(0)).getDataGrid().size(); p++) {				
			for (int j = 0; j<((Grid)gridIn.getEvents().get(0)).getDataGrid().get(p).getItem().size(); j++) {
				grid.getDataGrid().get(p).getItem().get(j).setInfected(((Grid)gridIn.getEvents().get(0)).getDataGrid().get(p).getItem().get(j).getInfected());
				grid.getDataGrid().get(p).getItem().get(j).setSusceptible(((Grid)gridIn.getEvents().get(0)).getDataGrid().get(p).getItem().get(j).getSusceptible());
				grid.getDataGrid().get(p).getItem().get(j).setRecovered(((Grid)gridIn.getEvents().get(0)).getDataGrid().get(p).getItem().get(j).getRecovered());
				
			}
		}*/
		
//		for (int i = 0; i < grid.getDataGrid().size(); ++i) {
//			for (int j = 0; j<grid.getDataGrid().get(i).getItem().size(); j++) {
//				System.out.println("in deltEXXT is "+grid.getDataGrid().get(i).getItem().get(j));
//			}
//        }  
	}
	
	@Override
	public void deltaInt() {
		// TODO Auto-generated method stub
		double old_pop;
		if(!dataList.equals(null)){
			time++;
			for(int i = 0; i<dataList.length; i++) {
				old_pop = dataList[i];
				//System.out.println("Time : "+ time);
				dataList[i]= old_pop*Math.exp(time * 0.25928853/365);			
			}
		}	
		
		
		/*if(!dataGrid.equals(null)){
			time++;
			for(int i = 0; i<dataGrid.length; i++) {
				for(int j = 0; j<dataGrid[i].length; j++) {
					old_pop = dataGrid[i][j].getSize();
			
					System.out.println("Time : "+ time);
					dataGrid[i][j].setSize(old_pop*Math.exp(time * 0.25928853/365));
			
				}
			}
		}	*/			
	}

	/*@Override
	public void deltaInt() {
		// TODO Auto-generated method stub
		double old_pop;
		if(dataGrid[0][0] != null){
			time++;
			for(int i=0; i<dataGrid.length; i++) {
				 for(int j=0; j<dataGrid[i].length; j++) {
					old_pop = dataGrid[i][j].getSize();
			*//**Using Open population with no population density
			* 
			* Birth rate = 0.0009 death rate = 0.00001, immigration = 0.02, emigration =0.01 
					grid[i][j] = (int) (old_pop + (0.02*old_pop)-(0.01*old_pop)+(0.02*old_pop)-(0.01*old_pop)); **//*
			*//** Using Closed population with no population density
			 * K(Growth rate for Nigeria between 2016 and 2017) = 0.25928853 for a year
			 * K(Growth rate for Nigeria per day) = 0.25928853/365
			 * **//*
					//dataGrid[i][j].setSize( old_pop+(0.0009*old_pop)-(0.00001*old_pop));
					System.out.println("Time : "+ time);
					dataGrid[i][j].setSize(old_pop*Math.exp(time * 0.25928853/365));
			*//** Using Closed population with population density
			 *  k = carrying capacity
			 * 
					int k = 1000000;
					grid[i][j] = (int) (((0.02*old_pop)-(0.01*old_pop))*(1 - (old_pop / k)));**//*
					
				}
			}
		}				
	}*/

	@Override
	public void lambda() {
		// TODO Auto-generated method stub
		
		//gridOut.addEvent(new Grid(dataList));
		//gridOut.addEvent(grid);
		gridOut.addEvent(new Events(dataList));
		
		//System.out.println("TN is:"+this.getSimulator().getTN());
		for(int i = 0; i<dataList.length; i++) {
			System.out.println(i+ " : "+ dataList[i]);						
		}

	}

	@Override
	public double ta() {
		// TODO Auto-generated method stub
		return 1;
	}

}

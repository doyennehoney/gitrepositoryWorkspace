package org.simstudio.epidem;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.simstudio.model.AtomicModel;
import org.simstudio.model.Events;
import org.simstudio.model.Grid;
import org.simstudio.model.Port;

public class Demography extends AtomicModel {
	Port gridIn, gridOut;
	//Events[][] dataGrid;
	//double[][] data;
	List<Double> data;
	Events ev;
	int Min = 100, Max = 1000;int time, t;

	PrintStream trajectory;
	
	public Demography(String name, String desc, int x, int y) {
		super(name);
		
		gridIn = new Port();
		gridOut = new Port();
		
		addInputPort(gridIn, "Input");
		addOutputPort(gridOut, "Out_port");
				
		double popSize;
		this.data = new ArrayList<Double>();
		//ev = new Events();
		//data = new double[x][y];
		//dataGrid= new Events[x][y];
//		for(int i = 0; i<dataGrid.length; i++) {
//			for(int j = 0; j<dataGrid[i].length; j++) {
//				popSize =  Math.pow(Min + (Math.random() * ((Max - Min) + 1)), 2);
//				//ev.setSize(popSize);ev.setSusceptible(0.999*popSize);ev.setInfected(0.001*popSize);ev.setRecovered(0);
//				//dataGrid[i][j] = new Events (popSize, 0.999*popSize, 0.001*popSize, 0 );
//			}
//		}	

//		for(int i = 0; i<data.length; i++) {
//			for(int j = 0; j<data[i].length; j++) {
//				popSize =  Math.pow(Min + (Math.random() * ((Max - Min) + 1)), 2);
//				//ev.setSize(popSize);ev.setSusceptible(0.999*popSize);ev.setInfected(0.001*popSize);ev.setRecovered(0);
//				//dataGrid[i][j] = new Events (popSize, 0.999*popSize, 0.001*popSize, 0 );
//				data[i][j] = popSize;
//			}
//		}
		
		for(int i = 0; i < x*y; i++){
			popSize =  Math.pow(Min + (Math.random() * ((Max - Min) + 1)), 2);
			data.add(popSize);
		}
		
		System.out.println("initial values for Data : "+data);		
		
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
		System.out.println(" valuesssss "+ gridIn.getEvents());
		/*for(int p = 0; p<gridIn.getEvents().size(); p++) {				
			//dataGrid = gridIn.getEvents().get(p);	
			//dataGrid = ((Grid)gridIn.getEvents().get(p)).dataGrid;
			//System.out.println(" valuesssssAAA "+ dataGrid.length);
			//System.out.println(" valuesssss "+ gridIn.getEvents().get(p));
		}*/
		
//		for(int i = 0; i<dataGrid.length; i++) {
//			for(int j = 0; j<dataGrid[i].length; j++) {
//				System.out.println("Nations "+dataGrid[i][j].getSize());
//				for(int p = 0; p<gridIn.getEvents().size(); p++) {	
//					System.out.println("GridIn"+gridIn.getEvents().get(p).getSize());
//					dataGrid[i][j] = new Events (gridIn.getEvents().get(p).getSize(), 
//							gridIn.getEvents().get(p).getSusceptible(), 
//							gridIn.getEvents().get(p).getInfected(),
//							gridIn.getEvents().get(p).getRecovered());
//					System.out.println(" valuesssss "+ dataGrid[i][j]);
//				}
//			}
//		}	
		
		  
	}
	
	@Override
	public void deltaInt() {
		// TODO Auto-generated method stub
		double old_pop;
		
		if(!data.equals(null)){
			time++;
			for(int i = 0; i<data.size(); i++) {
				old_pop = data.get(i);
			
					System.out.println("Time : "+ time);
					data.set(i, old_pop*Math.exp(time * 0.25928853/365));
			
				}
			}
		}		
		
//		if(!data.equals(null)){
//			time++;
//			for(int i = 0; i<data.length; i++) {
//				for(int j = 0; j<data[i].length; j++) {
//					old_pop = data[i][j];
//			
//					System.out.println("Time : "+ time);
//					data[i][j]= old_pop*Math.exp(time * 0.25928853/365);
//			
//				}
//			}
//		}				
	

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
		
		gridOut.addEvent(new Grid(data));
		//gridOut.addEvent(new Grid(dataGrid));
		
		System.out.println("TN is:"+this.getSimulator().getTN());
		
			//trajectory.println("Time = "+t); 
			for(int i = 0; i<data.size(); i++) {
					System.out.println(t+ "      "+i + ",  "  + data.get(i));  
					//trajectory.println(t+ ","+i + ""+j+","  + data[i][j]); 
				}		
		
	}

	@Override
	public double ta() {
		// TODO Auto-generated method stub
		return 2;
	}

}

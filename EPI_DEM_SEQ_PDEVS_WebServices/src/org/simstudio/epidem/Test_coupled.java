package org.simstudio.epidem;
import org.simstudio.model.CoupledModel;
import org.simstudio.model.Port;


public class Test_coupled extends CoupledModel {

	public Test_coupled(String name, String desc, int x, int y) {
		super(name);
		// TODO Auto-generated constructor stub
		Port inA,outA;
		
		inA = new Port();
		outA = new Port();
		
		addInputPort(inA, "A_in");
		addOutputPort(outA, "A_out");
		
		Demography pop = new Demography("A_Demography", "The Demographer", x, y);
		//Epidemiology spread = new Epidemiology("Manager Boss", "The Epidemist", x, y);
		Viewer view = new Viewer(x,y, "Viewer");
		
		addSubModel(pop);
		//addSubModel(spread);
		addSubModel(view);
		
		//GENERATORS
		//addIC(pop.getOutputPort("Out_port"), spread.getInputPort("Input"));
		//addIC(spread.getOutputPort("Out_port"), pop.getInputPort("Inputs"));
		//addIC(spread.getOutputPort("Out_view"), view.getInputPort("hola"));
		//addIC(pop.getOutputPort("Out_view"), view.getInputPort("hola"));
		
		//Test
		//addIC(pop.getOutputPort("Out_port"), view.getInputPort("hola"));
		//addIC(spread.getOutputPort("Out_port"), view.getInputPort("hola"));
		
		addEIC(this.getInputPort("A_in"), pop.getInputPort("Input"));
		addEOC(pop.getOutputPort("Out_port"), this.getOutputPort("A_out"));
	}

	

}

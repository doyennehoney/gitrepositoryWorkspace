import model.CoupledModel;

public class Test_coupled extends CoupledModel {

	public Test_coupled(String name, String desc, int x, int y) {
		super();
		// TODO Auto-generated constructor stub
		
		Demography pop = new Demography("NURSE Carol", "The Matron", x, y);
		Epidemiology spread = new Epidemiology("Manager Boss", "The BIG BOSS", x, y);
		Viewer view = new Viewer();
		
		addSubModel(pop);
		addSubModel(spread);
		addSubModel(view);
		
		//GENERATORS
		addIC(pop.getOutputPort("Out_port"), spread.getInputPort("Input"));
		addIC(spread.getOutputPort("Out_port"), pop.getInputPort("Inputs"));
		
		//Test
		//addIC(pop.getOutputPort("Out_port"), view.getInputPort("hola"));
		//addIC(spread.getOutputPort("Out_port"), view.getInputPort("hola"));
	}

	

}

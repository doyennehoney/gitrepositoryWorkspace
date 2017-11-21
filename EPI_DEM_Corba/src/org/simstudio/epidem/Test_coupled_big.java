package org.simstudio.epidem;
import org.simstudio.model.CoupledModel;

public class Test_coupled_big extends CoupledModel {

	public Test_coupled_big(String name, int x, int y) {
		super(name);
		
		Test_coupled coupled = new Test_coupled("A", "Child", x, y);
		
		addSubModel(coupled);
	}

}

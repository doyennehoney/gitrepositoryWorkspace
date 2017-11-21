package org.simstudio.epidem;

public class Test_simulation3 {

	public Test_simulation3() {
		// TODO Auto-generated constructor stub
		
	}
	
	public static void main(String[] args ) {
		//Test_coupled_big flat = new Test_coupled_big("EPIDEM", 2, 2);
		
		Test_coupled coupled = new Test_coupled("A", "Child", 2, 2); 
		/*Using the flattening process 
		 * Coupled models EPIDEM and A have been reduced into using Coupled model A
		 *  
		 */
		
        Test_frame test_frame = new Test_frame(coupled, "Process1");
        test_frame.setInitialTime(0);
        test_frame.getCurrentSimulationTime();
        test_frame.runExperiment(); 
	}

}

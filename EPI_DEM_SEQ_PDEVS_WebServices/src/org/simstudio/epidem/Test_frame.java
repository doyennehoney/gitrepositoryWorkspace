package org.simstudio.epidem;
import org.simstudio.frame.Process;
import org.simstudio.model.AbstractModel;

public class Test_frame extends Process {
	
	String id;
	public Test_frame(AbstractModel m, String id) {
		super(m, id);
		this.id=id;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean endingCondition() {
		// TODO Auto-generated method stub
		if (getCurrentSimulationTime() >= 10) {
            return true;
        }
		return false;
	}

}

import frame.AbstractFrame;
import model.AbstractModel;

public class Test_frame extends AbstractFrame {

	public Test_frame(AbstractModel m) {
		super(m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean endingCondition() {
		// TODO Auto-generated method stub
		if (getCurrentSimulationTime() >= 6) {
            return true;
        }
		return false;
	}

}

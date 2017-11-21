import frame.AbstractFrame;
import model.AbstractModel;

public class Test_frame extends AbstractFrame {

	public Test_frame(AbstractModel m) {
		super(m);
	}

	@Override
	public boolean endingCondition() {
		if (getCurrentSimulationTime() >= 500) {
            return true;
        }
		return false;
	}

}


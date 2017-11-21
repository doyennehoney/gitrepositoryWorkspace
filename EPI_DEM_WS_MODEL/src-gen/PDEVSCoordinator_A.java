import java.util.List;

	public class PDEVSCoordinator_A{
	
		List<BasicNode> children;
		CoupledModel m;

		public PDEVSCoordinator(CoupledModel m)
		{
			this.model = m ;
			this.children = new ArrayList<BasicNode>();
		}
		
		public void addChild(BasicNode child) { 
			children.add(child);
		}

		public void receiveIMsg() {
		}

		public void receiveStarMsg() {
		}

		public void receiveXMsg() {
		}

		public void receiveYMsg() {
		}	
	
	}

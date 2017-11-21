import java.util.List;

	public class VM{

		List<Processor> proc;
		String name;	
		String protocol;

		public VM () {
			name = "twoprocessors";
			protocol = "Web Service";
			proc = new ArrayList<Processor>();		
		}

		public void addProcessor(Processor processor) { 
			proc.add(processor);
		}		
	}

import java.util.List;

	public class VM{

		List<Processor> proc;
		String name;	
		String protocol;

		public VM () {
			name = "uniprocessor";
			protocol = "none";
			proc = new ArrayList<Processor>();		
		}

		public void addProcessor(Processor processor) { 
			proc.add(processor);
		}		
	}

import java.util.List;

	public class WebService{

		VM vm;
		List<Process> proc;

		public WebService () {
			vm = new VM();
			proc = new ArrayList<Processor>();
		}

		public void addProcess(Process process) { 
			proc.add(process);
		}

		public void bind() { }
		public void establish() { }
		public void send() { }
			
	
	}

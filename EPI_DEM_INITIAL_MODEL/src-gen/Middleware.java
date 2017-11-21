import java.util.List;

	public class Middleware{

		VM vm;
		List<Process> proc;

		public Middleware () {
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

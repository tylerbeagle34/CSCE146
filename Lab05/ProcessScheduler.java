/*
 * Written by Warren Beagle
 * Lab05: Process Schedule Simulator
 */
public class ProcessScheduler {
	LinkedListQueue<Process> processes = new LinkedListQueue<Process>(); //Creates a new instance of the queue
	Process currentProcess = new Process(); //Creates a new instance of the process
	public Process getCurrentProcess() //Returns the current process
	{
		return currentProcess;
	}
	public void addProcess(Process aProcess) //Adds a process
	{
		if(currentProcess == null) //Checks to see if the current process is null
		{
			currentProcess = aProcess;
		}
		else
		{
			processes.enqueue(aProcess);
		}
	}
	public void runNextProcess() //Runs the next process 
	{
		currentProcess = processes.dequeue();
	}
	public void cancelCurrentProcess() //Cancels the current process
	{
		currentProcess = processes.dequeue();
	}
	public void printProcessQueue() //Prints the process queue
	{
		processes.print();
	}
}

import java.util.*;
import java.io.*;
public class main{
	public static void main(String args[]){
		String[] letters = new String[26];
		for(int a = 0;a<letters.length;a++){
			letters[a] = String.valueOf((char)(97+a));
		}
		cracking[] crackers = new cracking[letters.length];
		for(int a = 0;a<crackers.length;a++){	
			crackers[a] = new cracking(a,a,letters);
//			System.out.println("running");
		}
		for(cracking a:crackers){
			a.run();
//			System.out.println("actually");
		}
		boolean run = true;
		String output = "";
		while(run){
//			System.out.println("infinite loop");
			//error while checking for the threads stop boolean. find better way to check whether threads have
			//found solutions!!!
			for(cracking a:crackers){
				String apple = a.getPass();
				System.out.println(a.getPass());
				if(!a.isRunning()){
					run = false;
					output = a.getPass();
					for(cracking b:crackers){
						b.stopIt();
					}
					break;
				}

			}
		}
		System.out.println("password was"+ output);
	}
}

class cracking extends Thread{
	private password temp;
	private String passwordLol;
	private boolean stop = false;
	private boolean done = false;
	public cracking(int start, int end,String[] letters){
		temp = new password(start,end,letters);
		passwordLol = temp.getPass();
	}
	public void run(){
		try{
			while(!stop){
				ProcessBuilder[] processbuilders = {
					new ProcessBuilder(new String[]{"echo",temp.getPass()}),
					new ProcessBuilder(new String[]{"java","Password3"})
				};
				List<Process> processes = ProcessBuilder.startPipeline(Arrays.asList(processbuilders));
				BufferedReader outcome = new BufferedReader(new InputStreamReader(processes.get(processes.size()-1).getInputStream()));
				String apple = "";
				while((apple = outcome.readLine())!=null){
					if(apple.indexOf(" correct") == -1 && apple.indexOf(" Correct") == -1){
						done = true;
						break;
					}
				}
				if(done){
					break;
				}
				temp.up();
				passwordLol = temp.getPass();
			}
		}
		catch(Exception e){}
	}
	public void stopIt(){
		stop = true;
	}
	public boolean isRunning(){
		return !done || !stop;
	}
	public String getPass(){
		return temp.getPass();
	}
}

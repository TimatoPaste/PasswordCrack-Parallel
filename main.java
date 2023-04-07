import java.util.*;
import java.io.*;
//stopping mechanism is flawed
public class main {
	public static void main(String args[]) {
		String[] letters = new String[26];
		for (int a = 0; a < letters.length; a++) {
			letters[a] = String.valueOf((char) (97 + a));
		}
		cracking[] cracker = new cracking[letters.length];
		for(int a = 0;a<cracker.length;a++){
			cracker[a] = new cracking(a,a,letters);
		}
		for(cracking a:cracker){
			a.start();
		}
		crackRun check = new crackRun(cracker);
		check.start();
	}
}
class crackRun extends Thread{
	private cracking[] crackers;
	public crackRun(cracking[] crackersIn){
		crackers = crackersIn;
	}
	@Override
	public void run(){
		int stopIndex = 0;
		boolean running = true;
		while(running){
			for(int a = 0;a<crackers.length;a++){
				if(!crackers[a].isAlive()){
					stopIndex = a;
					running = false;
					break;
				}
			}
		}
		for(cracking a:crackers){
			a.stopIt();
		}
		try {
			Thread.sleep(1000);
		}
		catch(Exception e){}
		System.out.println(crackers[stopIndex].getPass());
	}
}
class cracking extends Thread{
	private passwordGuess guess;
	private boolean found = false;
	public cracking(int start,int end,String[] letters){
		guess = new passwordGuess(new password(start,end,letters),"java","Password3");
	}
	@Override
	public void run() {
		while(!found){
			String feedback = guess.guess();
			System.out.println(feedback+" "+guess.getPass());
			if(feedback.toLowerCase().contains(" correct")){
				found = true;
			}
			else{
				guess.up();
			}
		}
	}
	public String getPass(){ return guess.getPass();}
	public void stopIt(){ found = true; }
	public boolean isRunning(){ return !found; }
}
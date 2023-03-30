public class main{
	public static void main(String args[]){
		String[] letters = new String[26];
		for(int a = 0;a<letters.length;a++){
			letters[a] = String.valueOf((char)(97+a));
		}
		password apple = new password(0,letters.length-1,letters);
		for(int a = 0;a<100;a++){
			System.out.println(apple.getPass());
			apple.up();
		}
		
		
	}
}

import java.util.ArrayList;
public class password{
	private ArrayList<Integer> indices = new ArrayList<Integer>();
	private String[] letters;
	private int start;
	private int end;
	//will find all passwords between the ones that start with letters[start] and letters[end], inclusive
	public password(int startIn,int endIn,String[] lettersIn){
		start = startIn;
		end = endIn;
		letters = lettersIn;
		indices.add(start);
	}
	public void up(){
		indices.set(0,indices.get(0)+1);
		for(int a = 0;a<indices.size();a++){
			if(indices.get(a)>end){
				indices.set(a,start);
				if(a+1==indices.size()){
					indices.add(start);
					for(int b = 0;b<indices.size();b++){
						indices.set(b,start);
					}
				}
				else{
					indices.set(a+1,indices.get(a+1)+1);
				}
			}
		}
	}
	public String getPass(){
		String output = "";
		for(int a = 0;a<indices.size();a++){
			output += letters[indices.get(a)];
		}
		return output;
	}
	public ArrayList<Integer> getIndices(){
		return indices;
	}
}

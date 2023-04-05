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
		for(int indicesIndex = 0;indicesIndex<indices.size();indicesIndex++){
			if(indicesIndex == 0){
				if(indices.get(indicesIndex)>end){
					indices.set(indicesIndex,start);
					if(indicesIndex+1==indices.size()){
						indices.add(0);
					}
					else{
						indices.set(indicesIndex+1,indices.get(indicesIndex+1)+1);
					}
				}
			}
			else{
				if(indices.get(indicesIndex)==letters.length){
					indices.set(indicesIndex,0);
					if(indicesIndex+1==indices.size()){
						indices.add(0);
					}
					else{
						indices.set(indicesIndex+1,indices.get(indicesIndex+1)+1);
					}
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

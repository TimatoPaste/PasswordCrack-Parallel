import java.util.*;
import java.io.*;
public class passwordGuess {
    private password pass;
    private String command;
    private String fileName;
    public passwordGuess(password passIn,String commandIn,String fileNameIn){
        pass = passIn;
        command = commandIn;
        fileName = fileNameIn;
    }
    public String guess(){
        String result = "";
        try {

            ProcessBuilder[] processbuilders = {
                    //don't forget to remove the cmd c for the lyron server
                    new ProcessBuilder(new String[]{/*"cmd","/c","echo",*/ pass.getPass()}),
                    new ProcessBuilder(new String[]{/*"cmd","/c",*/command, fileName})
            };
            for (ProcessBuilder a : processbuilders) {
                a.directory(new File(System.getProperty("user.dir")));
            }
            List<Process> processes = ProcessBuilder.startPipeline(Arrays.asList(processbuilders));
            BufferedReader outcome = new BufferedReader(new InputStreamReader(processes.get(processes.size() - 1).getInputStream()));

            String temp;
            while((temp = outcome.readLine())!=null){
                result+=temp;
            }
        }
        catch(Exception e) {}
        finally{
            return result;
        }
    }
    public String getPass(){
        return pass.getPass();
    }
    public void up(){
        pass.up();
    }
}

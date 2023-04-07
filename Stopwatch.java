
public class Stopwatch {
    private long start;
    private long stop;
    public Stopwatch() {
    }
    public void start(){
        start = System.currentTimeMillis();
    }
    public void stop(){
        stop = System.currentTimeMillis();
    }
    public double getTime(){
        return (double)(stop-start);
    }
}

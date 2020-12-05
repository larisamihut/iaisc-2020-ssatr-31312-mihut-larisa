package simulation;

public class Port2 extends EndPort{
public MS_B ms;
    
    public void handle1(){
        System.out.println("MASINA B ON");
    }
    
    public void handle2() {
        System.out.println("MASINA B OFF");

    } 
    
    public void connect(MS_B msb) {
        msb.start();
    }
}

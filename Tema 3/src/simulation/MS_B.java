package simulation;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MS_B extends Thread{
public Port2 p2;
    
    public void run() {
        
        System.out.println("MACHINE B STARTED");
        
        int semnal = 0;
        
        while (semnal<=10)
        {
        System.out.println("Semnal: " + semnal);
            
        
        try {
                Thread.sleep(500);
                    
                } catch (InterruptedException ex) {
                Logger.getLogger(MS_B.class.getName()).log(Level.SEVERE, null, ex);
            } 
            p2 = new Port2();
             if(semnal == 10) {
                
                connect(p2);
            } 
             semnal=semnal+1;
             
        } 
        
    } 
    
        
    public  void connect(Port2 p) {
        p.handle2();
    }
}

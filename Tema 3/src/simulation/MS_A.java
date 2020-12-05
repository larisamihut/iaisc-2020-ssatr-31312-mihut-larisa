package simulation;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MS_A extends Thread{
	public Port1 p1;
    
    public void run() {
             System.out.println("MACHINE A STARTED");

        int semnal = 0;    
      
        
        while(semnal<=10)
           
        {
            
            System.out.println("Semnal: " + semnal);
             
            p1=new Port1();
            
            if(p1.signal1() == semnal) {
                
                connect(p1);
            } // end if
            
            try {
                Thread.sleep(500);
             
        }   catch (InterruptedException ex) {
                Logger.getLogger(MS_A.class.getName()).log(Level.SEVERE, null, ex);
            } 
         semnal++;
        }
         System.out.println("MACHINE A DONE");
  
        }

    
    public void connect(Port1 p) {
        p.connect(new Port2());
        
    }
}

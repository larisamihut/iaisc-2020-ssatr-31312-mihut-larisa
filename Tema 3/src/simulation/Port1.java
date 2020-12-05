package simulation;

public class Port1 extends EndPort{
	public int signal1(){ 
	      return 5;    
	  } 
	  
	  public int signal2(){  
	      return 10;
	  } 
	  
	  public void connect(Port2 p) {
	      p.handle1();
	      
	  }
}

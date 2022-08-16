package BuildH2O;
 
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;


public class BuildingH2O {
	public static  int count = 0;
	
	public int hydrogen;
	
    public int oxygen;
    
    CyclicBarrier barrier;

    /**
     * Hydrogen atoms queue on this semaphore
     */
    Semaphore hydrogenQueue;
    /**
     * Oxygen atoms queue on this semaphore
     */
    Semaphore oxygenQueue;
    
    public BuildingH2O() {
    	barrier = new CyclicBarrier(3);
        
        hydrogenQueue = new Semaphore(2);
        oxygenQueue = new Semaphore(1);
        hydrogen = 0;
        oxygen = 0;   
    }
  
    
    void producedWater() {
    	count++;
        System.out.println("WATER MOLECULE PRODUCED!"+"\n");   
    }

}

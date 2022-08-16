package BuildH2O;

import java.util.concurrent.BrokenBarrierException;

public class Oxygen implements Runnable {
    /**
     * Shared variable of class BuildingH2O
     */
    private BuildingH2O buildingH2O;
    /**
     * Count indicating the total number of hydrogen atoms
     */
    public static int count = 0;

    /**
     * Constructor
     * @param buildingH2O shared variable
     */
    public Oxygen(BuildingH2O buildingH2O) {
        this.buildingH2O = buildingH2O;
        count++;
    }
      
    
    
    void Bond() {
    	buildingH2O.hydrogen-=2;
        buildingH2O.hydrogenQueue.release();
        buildingH2O.hydrogenQueue.release();
        buildingH2O.oxygen -- ;
        buildingH2O.oxygenQueue.release();
        buildingH2O.producedWater();
    }
    
    

    @Override
    public void run() {

        try {
            
        	buildingH2O.oxygen++;
            System.out.println("Oxygen atom !\n");
            
        	buildingH2O.oxygenQueue.acquire();	
        	
            // Wait upon the barrier
            buildingH2O.barrier.await();
            
            Bond();
    
            
        } catch (InterruptedException ignored) {} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}

package BuildH2O;

import java.util.concurrent.BrokenBarrierException;

public class Hydrogen implements Runnable {
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
    public Hydrogen(BuildingH2O buildingH2O) {
        this.buildingH2O = buildingH2O;
        count++;
    }
    

    @Override
    public void run() {

        try {
        	
        	buildingH2O.hydrogen++;
        	
        	System.out.println("Hydrogen atom !\n");    
        		
            buildingH2O.hydrogenQueue.acquire();
            // Wait upon the barrier

            buildingH2O.barrier.await();

              	            
        } catch (InterruptedException ignored) {} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

}

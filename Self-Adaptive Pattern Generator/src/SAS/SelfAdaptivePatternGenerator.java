/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//direction value corresponding to each axes x+,x-,y+ and y- are considered 0,1,2 and 3 respectively.
package SAS;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;

/**
 *
 * @author Mehran
 */
public class SelfAdaptivePatternGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for(int k=1; k<=100; k++)//round number
        {
        System.out.println("Starting execution round"+k+"\n");
        int dim=2;//dimension
        int num=24;//size of the walk
        String result="";
    	        result+=("x"+"\t"+"y"+"\t"+"Change Value"+"\n");
	        RandomWalk r=new RandomWalk();
	        Object[] obj=new Object[2];
	        obj=r.SARW(dim, num);
	        int g[][]=(int[][]) obj[0];
	        int step[]=(int[]) obj[1];
	        Random rand=new Random();
                float change_value=0;
	        
	        try {
	        	
                    
                   for (int i=0; i<g.length; i++) {
                        
                       // result += ("\t" + g1[0] + "\t" + g1[1] + "\n\n");
                       //result += ("\t" + g1[0] + "\t" + g1[1] + "\n\n");
                       if(step[i]==2) //if the walker moves to +y direction
                           change_value=(float) ((rand.nextInt(100))*0.002);
                       else if(step[i]==3) //if the walker moves to -ydirection
                           change_value=(float) ((rand.nextInt(100))*(-0.002));
                       else
                           change_value=0;
                       result += (g[i][0] + "\t" + g[i][1] + "\t" + change_value + "\n");
                    }
	
	        	} catch (IndexOutOfBoundsException e) {
					
				System.err.print("Ran out off indexes !");
				// handled exception ** JavaHer
                        }
    			
    			//System.out.println(result);
                        
                        
                        File output=new File("Save/output"+k+".txt");

        	try{
        		
            	output.getParentFile().mkdirs(); 
            	output.createNewFile();
            	
        		
            try (PrintStream save = new PrintStream(output)) {
                save.print(result);
            }
                        } catch (IOException e) {
    			
    			System.err.print("Error in output !");
    		}
       
               
                }
    }
    
}

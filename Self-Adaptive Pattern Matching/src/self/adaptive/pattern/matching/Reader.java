/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package self.adaptive.pattern.matching;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Mehran Alidoost Nia
 */
public class Reader {
    private Scanner input;






    public void OpenFile(String name)
    {
     try{
            File f2=new File("Save/"+name);
            input=new Scanner(f2);
        }
        catch(FileNotFoundException fileNotFoundException){
          System.err.println("Error opening file !");
          System.exit(1);
        }
    }



    public Object [] ReadFile(int n)
    {
       String s;
       String[] split;
       split = new String [78];
       int a[][]=new int[25][2];
       float value[]=new float[25];
       int i=0;
      try{
               while(input.hasNext()&i!=n){
               s=input.nextLine();
               split=s.split("\t");
              //System.out.println(split[0]+split[1]+split[2]);
                                 
              if(i>=1 & i<n)
              {
                  //System.out.println(i);
                  
                  a[i-1][0]=Integer.valueOf(split[0]);
                  a[i-1][1]=Integer.valueOf(split[1]);
                  value[i-1]=Float.valueOf(split[2]);
                          
                // System.out.println(a[i-1][0]);
               // System.out.println(a[i-1][1]);
              // System.out.println(value[i-1]);
              }
              
               i++;
              
               
               
           }
        }catch(NoSuchElementException elementException){
         System.err.println("file is peroperly forms");
         input.close();
         System.exit(1);
        }
      return new Object[]{a,value};
      }





    public void CloseFile()
    {

    }

}

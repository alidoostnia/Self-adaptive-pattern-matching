/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package self.adaptive.pattern.matching;

/**
 *
 * @author Mehran Alidoost Nia
 */
public class SelfAdaptivePatternMatching {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] a;//walk from history
        float[] val;//value change from history
        int[][] b=new int[25][2];//behaviour of the current run
        float[] cur=new float[25];//value change for the current run
        Reader read=new Reader();
        Object[] obj=new Object[2];
        read.OpenFile("Current.txt");
        obj=read.ReadFile(26);
        b=(int[][]) obj[0];
        int unknown=1;//current unknown change from the environment
        int max=3;//maximum length of sub-patterns for matching
        float change= -1;
        
        /*for(int k=0;k<25;k++)
        System.out.println(b[k][0]+"\t"+b[k][1]);*/
        
        /*Read History Files and Match to the Current*/
        for(int i=1; i<=100; i++)
        {
            read.OpenFile("output"+i+".txt");
            obj=read.ReadFile(26);
            a=(int[][]) obj[0];
            val=(float[]) obj[1];
            
            for(int j=0;j<=unknown;j++)
            {
                if(a[j][0]==b[j][0]&&a[j][1]==b[j][1])
                {
                    if(j==unknown)
                    {
                        change=val[j];
                        break;
                    }
                                                           
                }
                else 
                    break;
            }
            if(change != -1)
                break;
        }
        System.out.println(change);
        
        /****if we do not find a complete match, we should search for some similar patterns***/
        int m;
        if(change== -1)
            for(int i=1; i<=100; i++)
            {
                m=0;
            read.OpenFile("output"+i+".txt");
            obj=read.ReadFile(26);
            a=(int[][]) obj[0];
            val=(float[]) obj[1];
            
            for(int j=0;j<=unknown;j++)
            {
                for(int jj=0;jj<=24;jj++)
                {  
                if(a[jj][0]==b[j][0]&&a[jj][1]==b[j][1])
                {
                    m++;
                    //System.out.println("output"+i+" "+"index"+jj+" "+a[jj][0]+" "+a[jj][1]+"\t index"+j+" "+b[j][0]+" "+b[j][1]);
                                                                           
                }
                if(j==unknown & m>max)
                    {
                        change=val[j];
                        break;
                    }
                
                }
                
            }
            
            if(change != -1)
                break;
            }
                System.out.println(change);

        
        
    }
    
}

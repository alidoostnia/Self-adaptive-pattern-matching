/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SAS;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Mehran Alidoost Nia
 */
public class RandomWalk {
    
    public Object[] SRW(int dim, int num){
        int rw[]=new int[num]; //random walk
        int total=0;
        int i=0; //number of steps
        int select=0;
        int point[][]=new int[num][4];
        
        
        Random rand=new Random();
        
        while(total<num){
            select=rand.nextInt(2*dim); //select random index of pack
            rw[i]=select; //save current position
            
            if(i>0){
            if(select==0){
                point [i][0]=point[i-1][0]+1;
                point [i][1]=point[i-1][1];
                point [i][2]=point[i-1][2];
                point [i][3]=point[i-1][3];
            }
            else if(select==1){
                point [i][0]=point[i-1][0]-1;
                point [i][1]=point[i-1][1];
                point [i][2]=point[i-1][2];
                point [i][3]=point[i-1][3];
            }
            else if(select==2){
                point [i][1]=point[i-1][1]+1;
                point [i][0]=point[i-1][0];
                point [i][2]=point[i-1][2];
                point [i][3]=point[i-1][3];
            }
            else if(select==3){
                point [i][1]=point[i-1][1]-1;
                point [i][0]=point[i-1][0];
                point [i][2]=point[i-1][2];
                point [i][3]=point[i-1][3];
            }
                
            else if(select==4){
                point [i][2]=point[i-1][2]+1;
                point [i][0]=point[i-1][0];
                point [i][1]=point[i-1][1];
                point [i][3]=point[i-1][3];
            }
            else if(select==5){
                point [i][2]=point[i-1][2]-1;
                point [i][0]=point[i-1][0];
                point [i][1]=point[i-1][1];
                point [i][3]=point[i-1][3];
            }
            else if(select==6){
                point [i][3]=point[i-1][3]+1;
                point [i][0]=point[i-1][0];
                point [i][1]=point[i-1][1];
                point [i][2]=point[i-1][2];
            }
            else if(select==7){
                point [i][3]=point[i-1][3]-1;
                point [i][0]=point[i-1][0];
                point [i][1]=point[i-1][1];
                point [i][2]=point[i-1][2];
            }
            else 
                System.out.println("error with select value in round:\t"+i);
            }
            
            
            total++; //20B for TCP header
            i++;
                       
        }
        
        return new Object[]{point,rw};
    }
    
    public Object[] SARW(int dim, int num){
        int rw[]=new int[num+1]; //random walk
        int total=0;
        int i=0; //number of steps
        int select=0;
        int point[][]=new int[num+1][4];
        
        
        while(total<num){
            if(i!=0)
                select=Move(i, point, dim); //select random index of pack
            rw[i]=select; //save current position
            
            //add new point here
            if(i>0){
            if(select==0){
                point [i][0]=point[i-1][0]+1;
                point [i][1]=point[i-1][1];
                point [i][2]=point[i-1][2];
                point [i][3]=point[i-1][3];
            }
            else if(select==1){
                point [i][0]=point[i-1][0]-1;
                point [i][1]=point[i-1][1];
                point [i][2]=point[i-1][2];
                point [i][3]=point[i-1][3];
            }
            else if(select==2){
                point [i][1]=point[i-1][1]+1;
                point [i][0]=point[i-1][0];
                point [i][2]=point[i-1][2];
                point [i][3]=point[i-1][3];
            }
            else if(select==3){
                point [i][1]=point[i-1][1]-1;
                point [i][0]=point[i-1][0];
                point [i][2]=point[i-1][2];
                point [i][3]=point[i-1][3];
            }
                
            else if(select==4){
                point [i][2]=point[i-1][2]+1;
                point [i][0]=point[i-1][0];
                point [i][1]=point[i-1][1];
                point [i][3]=point[i-1][3];
            }
            else if(select==5){
                point [i][2]=point[i-1][2]-1;
                point [i][0]=point[i-1][0];
                point [i][1]=point[i-1][1];
                point [i][3]=point[i-1][3];
            }
            else if(select==6){
                point [i][3]=point[i-1][3]+1;
                point [i][0]=point[i-1][0];
                point [i][1]=point[i-1][1];
                point [i][2]=point[i-1][2];
            }
            else if(select==7){
                point [i][3]=point[i-1][3]-1;
                point [i][0]=point[i-1][0];
                point [i][1]=point[i-1][1];
                point [i][2]=point[i-1][2];
            }
            else 
                System.out.println("error with select value in round:\t"+i);
            }
            
            total++; //20B for TCP header
            //System.out.println(rw[i]+"\t"+pack[select]); test
            i++;
                       
        }
        
        
        
        return new Object[]{point,rw};
        
    }

    public int Move(int current, int point [][], int dim) {

        Random rand=new Random();
        int visited=0;
        boolean avl=true;
        int vcount=0;//visit count of next2 point
        int select=0;
        int next[]= new int[4];
        int next2[]= new int[4];
        int tmp[]={0,0,0,0};
        int sel=0;
        int ii=current;
        List<Integer> tmplist = new ArrayList<>(); //no fixed size mentioned
        
        
        
           
        /*if(current==1)
        {
            select=rand.nextInt(2*dim);
        }
        else{*/
        for(int m=0;m<2*dim;m++)
        {
            vcount=0;
            avl=true;
            visited=0;
            //System.out.println("curent\t"+current);

            //System.out.println("point in before\t"+point[current-1][0]+"\t"+point[current-1][1]+"\t"+point[current-1][2]+"\t"+point[current-1][3]+"\t");
            next=nextp(point,m,current);//next point
            //System.out.println("current is\t"+current+"\t direction is\t"+m);
            
            
            
            /*if(current==5)
            for(int l=0;l<100;l++)
            System.out.println(point[l][0]+"\t"+point[l][1]+"\t"+point[l][2]+"\t"+point[l][3]+"\t");
        */ // test for printing point
            
            
            
            
            
            //System.out.println("point in before\t"+point[current][0]+"\t"+point[current][1]+"\t"+point[current][2]+"\t"+point[current][3]+"\t");
            //System.out.println("next in before\t"+next[0]+"\t"+next[1]+"\t"+next[2]+"\t"+next[3]+"\t");

            for(int j=0;j<=current;j++)//check for previously visited
            {
                
                if(next[0]==point[j][0] & next[1]==point[j][1] &next[2]==point[j][2] &next[3]==point[j][3] )
                {
                   
                   visited=1;
                   //System.out.println("visited detected  "+visited); 
                   
                }
                
                if(visited==1){
                                    //System.out.println("VISIT"); 
                                    j=current+1;

                }
                
                               
            }
            
           if(visited==0)//if not visited, check for avalability in neighborhood 
            {
                //add next point
                point[current+1][0]=next[0];
                point[current+1][1]=next[1];
                point[current+1][2]=next[2];
                point[current+1][3]=next[3];
                
                //check for np's direction
                
                
                for(int k=0;k<2*dim;k++)
                {
                    next2=nextp(point,k,current+1);
                    for(int j=0;j<current;j++)//check for previously visited
                    {
                        
                
                        if(next2[0]==point[j][0] & next2[1]==point[j][1] &next2[2]==point[j][2] &next2[3]==point[j][3] )
                        {
                            vcount++;
                            j=current;
                        }
                               
                    }
                }
            }
            if(visited==0 )//if not previously visited and avalable add to the list
            {
               if(dim==2 && vcount<3)//atleast two avalable path in two direction
                   tmplist.add(m);
               else if(dim==3 && vcount<5) 
                   tmplist.add(m);
               else if(dim==4 && vcount<7) 
                   tmplist.add(m);
               else
                 System.out.println("error with dimension value in round:\t"+current);  
                   
            }
                
            
            
        }
        
       // for(int l=0;l<20;l++)
         //   System.out.println(point[l][0]+"\t"+point[l][1]+"\t"+point[l][2]+"\t"+point[l][3]+"\t");
        if(tmplist.size()>0)
        {sel=rand.nextInt(tmplist.size());
        select=tmplist.get(sel);}
        else
        {
            System.out.println("dead lock in round:\t"+current);
            //sel=rand.nextInt(2*dim);
            
            
            for(int m=0;m<2*dim;m++)
            {
            vcount=0;
            avl=true;
            visited=0;
            next=nextp(point,m,current);//next point
            
            for(int j=0;j<=current;j++)//check for previously visited
            {
                
                if(next[0]==point[j][0] & next[1]==point[j][1] &next[2]==point[j][2] &next[3]==point[j][3] )
                {
                   
                   visited=1;
                   
                }
                
                if(visited==1){
                   j=current+1;

                }
                
                               
            }
            
           
            if(visited==0 )//if not previously visited and avalable add to the list
            tmplist.add(m);
            else
            System.out.println("error with dimension value in round:\t"+current);
            
          }
         if(tmplist.size()>0){   
         sel=rand.nextInt(tmplist.size());
         select=tmplist.get(sel); 
         }
         else
             select=rand.nextInt(2*dim);
           
            
            
        }
        //next=nextp(point,select,current);
        //System.out.println("point in after\t"+next[0]+"\t"+next[1]+"\t"+next[2]+"\t"+next[3]+"\t");
        //}
        //for(int h=0;h<tmplist.size();h++)
        //    System.out.println(tmplist.toString()+"\t"+current);
        //System.out.println("random selection is\t"+sel);

        return select;
    }
    
    
    public int[] nextp(int point[][], int dir, int current){
        
        int next[]=new int[4];
        
        if(dir==0){
                next [0]=point[current-1][0]+1;
                next [1]=point[current-1][1];
                next [2]=point[current-1][2];
                next [3]=point[current-1][3];
            }
            else if(dir==1){
                next [0]=point[current-1][0]-1;
                next [1]=point[current-1][1];
                next [2]=point[current-1][2];
                next [3]=point[current-1][3];
            }
            else if(dir==2){
                next [1]=point[current-1][1]+1;
                next [0]=point[current-1][0];
                next [2]=point[current-1][2];
                next [3]=point[current-1][3];
            }
            else if(dir==3){
                next [1]=point[current-1][1]-1;
                next [0]=point[current-1][0];
                next [2]=point[current-1][2];
                next [3]=point[current-1][3];
            }
                
            else if(dir==4){
                next [2]=point[current-1][2]+1;
                next [0]=point[current-1][0];
                next [1]=point[current-1][1];
                next [3]=point[current-1][3];
            }
            else if(dir==5){
                next [2]=point[current-1][2]-1;
                next [0]=point[current-1][0];
                next [1]=point[current-1][1];
                next [3]=point[current-1][3];
            }
            else if(dir==6){
                next [3]=point[current-1][3]+1;
                next [0]=point[current-1][0];
                next [1]=point[current-1][1];
                next [2]=point[current-1][2];
            }
            else if(dir==7){
                next [3]=point[current-1][3]-1;
                next [0]=point[current-1][0];
                next [1]=point[current-1][1];
                next [2]=point[current-1][2];
            }
            else 
                System.out.println("error with select value in round:\t"+current);
        
        
        return next;
        
    }
    
}

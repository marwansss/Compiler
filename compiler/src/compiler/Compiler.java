/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;

/**
 *
 * @author PC
 */import java.io.File;
   import java.io.IOException;
   import java.util.Scanner;
public class Compiler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        int x;
        int l=0;
        int g=0;
        String A = "NO";
    String[] keyword={"P","V","S","INT","IF"};
    String[] Operators={"=","+","-","*"};
    String[] delimiter={";"};
    
    String[][] data =new String[1000][2];
    File myfile=new File("C:\\Users\\PC\\Desktop\\xxx.txt");
 try{
      
      Scanner input=new Scanner(myfile);
      
      while(input.hasNext())
    {
        data[l][0]=input.next();
       l++;
    }
     
  }
catch(IOException e) {
System.out.println("Error  can not find file");
return;}
 String[] identifier =new String[l];
 
 for (int i =0;i<l;i++)
     if(data[i][0].equals("="))
        if (ccc.isNumeric(data[i+1][0]))
         data[i+1][1]="number";
//else
  //          data[i+1][1]="identifier";

  
  for (int i =0;i<l;i++)
    if(data[i][0].equals("INT"))
     {
       
         data[i+1][1]="identifier";
        identifier[g] = data[i+1][0];
        g++;
     }
  for (int i =0;i<l;i++)
    if(data[i][0].equals("P"))
     {
       
         data[i+1][1]="program name";
        
     }
  
  for (int i =0;i<l;i++)
 {
    for(int j=0;j<4;j++)
     if(data[i][0].equals(keyword[j]))
     {
         data[i][1]="keyword";
     }
    for(int j=0;j<3;j++)
    if(data[i][0].equals(Operators[j]))
     {
     data[i][1]="Operators";
     }
     for(int j=0;j<1;j++)
     if(data[i][0].equals(delimiter[j]))
     {
     data[i][1]="delimiter";
     }  
     for(int j=0;j<g;j++)
     if(data[i][0].equals(identifier[j]))
     {
     data[i][1]="identifier";
     }    
 }
  int h=0;
  try
  {
      for ( h =0;h<l;h++)
    if(data[h][1].equals("null"))
     {
       
         data[h][0]="error";
        
     }
  }
  catch(NullPointerException e) {
     data[h][1]="error";
   
}
 
  
 
     for(int i=0;i<l;i++)
       {
           System.out.println(data[i][0]+"\t"+data[i][1]);
       }
    
     
     
     
     
     
     
     String[][] assembly=new String[l][3]; 
     for(int i=0;i<l;i++)
       {
           
           assembly[i][0]="";
           assembly[i][1]="";
           assembly[i][2]="";
       }
for (int i =0;i<l;i++)
    if(data[i][0].equals("P"))
     {
       assembly[0][0]=data[i+1][0];
       assembly[0][1]="START";
     }








int k=1;
    for (int i =0;i<l;i++)
    if(data[i][0].equals("S"))
    {
        for (int n =i;n<l;n++)
        {
            if(data[n][0].equals("="))
            {
                if(data[n+1][0].equals(A))
                {
                      assembly[k][1]="STA";
                      assembly[k][2]=data[n-1][0];
                      k++;
                }
                else
                {
                    assembly[k][1]="LDA";
                      assembly[k][2]=data[n+1][0];
                     k++;
                      assembly[k][1]="STA";
                      assembly[k][2]=data[n-1][0];
                     k++;
                     A=data[n+1][0];
                }
                if(data[n][0].equals("+"))
            {
                if(data[n+1][0].equals(A))
                {
                      assembly[k][1]="ADD";
                      assembly[k][2]=data[n-1][0];
                      k++;
                }
                else if(data[n-1][0].equals(A))
                {
                      assembly[k][1]="ADD";
                      assembly[k][2]=data[n+1][0];
                      k++;
                }
                else
                {
                    assembly[k][1]="LDA";
                      assembly[k][2]=data[n-1][0];
                     k++;
                      assembly[k][1]="ADD";
                      assembly[k][2]=data[n+1][0];
                     k++;
                     A=data[n-1][0];
                }
            }
                
        }
     }
    }
     System.out.println("                       ");
      System.out.println("                       ");
       System.out.println("                       ");
    for(int i=0;i<l;i++)
       {
           
           System.out.println(assembly[i][0]+"\t"+assembly[i][1]+"\t"+assembly[i][2]);
       }
    
    }
}

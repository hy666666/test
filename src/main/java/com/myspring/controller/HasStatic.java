package com.myspring.controller;

public class HasStatic{
    private static int x=100;
    public static void main1(String args[]){
          HasStatic hs1=new HasStatic();
          hs1.x++;
          HasStatic  hs2=new HasStatic();
          hs2.x++;
          hs1=new HasStatic();
          hs1.x++;
        HasStatic.x--;
        System.out.println("x="+x);
     }
    
    public static int aMethod(int i)throws Exception
    {
        try{
            return i / 10;
        }
        catch (Exception ex)
        {
            throw new Exception("exception in a Method");
        } finally{
            System.out.printf("finally");
        }
    }
 
    public static void main(String [] args)
    {
        try
        {
        	System.out.println(aMethod(0));
        }
        catch (Exception ex)
        {
            System.out.printf("exception in main");
        }
        System.out.printf("finished");
    }
} 
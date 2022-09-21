package com.mycompany.studentmanagementapp.controller;

public class Pattern2 {
    public void pattern(){
        for(int i=0;i<=5;i++){
            char typeConversion=(char)('A'+i-1);
            for(int j=1;j<=i;j++){
                System.out.print(" "+typeConversion);
            }
            System.out.println(" ");
        }
    }
    public static void main(String[] arg){
        Pattern2 obj=new Pattern2();
        obj.pattern();
    }
}



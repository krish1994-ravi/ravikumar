package com.nt.xyz;

public class Calculation {
	
	public  int findMax(int arr[]){  
        int max=arr[0];  
        for(int i=1;i<arr.length;i++){  
            if(max<arr[i])  
                max=arr[i];  
        }  
        return max;  
    } 
	
	public  int add(int x,int y) {
		return x+y;
	}
	
	public boolean findVal(int a) {
		if(a>100)
			return true;
		else 
			return false;
	}

}

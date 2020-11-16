package assignment2;

/*
 * Implementing a Pair class to depict key-value pair to use in the  MapReduce operations
 */
public class Pair {
     double key;
     int value;
     
     public Pair(double key, int value)
     {
    	 this.key=key;
    	 this.value=value;
     }
     
    // standard getters 
     public double getKey()
     {
    	 return key;
     }
     
     public int getValue()
     {
    	 return value;
     }
     
}
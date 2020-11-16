package assignment2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class caller {
    
	public static void main(String args[])
	{
         //creating Measurement class objects
		 Measurement a = new Measurement(1, 22.0);
	     Measurement b = new Measurement(13, 8.1);
	     Measurement c = new Measurement(24, 12.5);
	     Measurement d = new Measurement(3, 23.6);
	     Measurement e = new Measurement(11, 13.8);
	     Measurement f = new Measurement(23, 14.5);
	     Measurement g = new Measurement(16,18);
	     
	     //creating list of measurements to pass to WeatherStation objects 
	     List<Measurement> measurements1 = Arrays.asList(a,b,c,d);
	     List<Measurement> measurements2 = Arrays.asList(e,f,g);
	    
         //creating WeatherStation class objects
	     WeatherStation s1 = new WeatherStation("Galway", measurements1);
	     WeatherStation s2 = new WeatherStation("Cork", measurements2);
	     
	     //Adding weather stations to the static list of stations
	     s1.addStation(s1);
	     s2.addStation(s2);
	     
	     //Measuring the maximum temperatures in different stations
	     Measurement max1=s1.maxTemperature(1, 24);
	     System.out.println("The Highest temperature observed in "+s1.getCity()+" city is "+max1.getTemperature()+
	        		"°C at "+max1.getTime()+" IST( Irish Standard Time )");
	     
	     Measurement max2=s2.maxTemperature(1, 24);
	     System.out.println("The Highest temperature observed in "+s2.getCity()+" city is "+max2.getTemperature()+
	        		"°C at "+max2.getTime()+" IST( Irish Standard Time )");
 
	     double temp1=19.0;
	     double temp2=15;
	     double r=3.0;
	     
	   //Collecting the returned result and displaying it
	     Map<Double, Integer> result=WeatherStation.countTemperature(temp1,temp2,r);
	     
	     System.out.println();
			for(Entry<Double, Integer> entry : result.entrySet()) {
				System.out.print("["+entry.getKey()+", "+entry.getValue()+"]");
			}
	}
}



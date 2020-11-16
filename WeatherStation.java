package assignment2;
import java.util.*;
import java.lang.Math;
import java.util.stream.Collectors;


public class WeatherStation {
	String city;
	List<Measurement> measurements;
	public static List<WeatherStation> stations= new ArrayList<>();
	
	//Constructor of WeatherStation class for initializing variables for the objects of class
	public WeatherStation(String city, List<Measurement> measurements){
        this.city = city;
        this.measurements = measurements;
    }
	
	//Method to add a new station to the static list of stations
	public void addStation(WeatherStation w) {
	      stations.add(w);
	   }
	
	//Standard Getters
	public List<Measurement> getMeasurements(){
	      return measurements;
	  }
	
	public String getCity(){
	      return city;        
	  }
	
	
 
	public Measurement maxTemperature(int startTime, int endTime){

        /*References: https://www.baeldung.com/java-collection-min-max
         *            https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html*/
		
        //A list of the Measurement object in the selected time range
        List<Measurement> tempMeasurements = this.getMeasurements().stream().filter(a -> a.getTime()>=startTime)
                .filter(a -> a.getTime()<=endTime).collect(Collectors.toList());

        //Finding the Measurement with the highest temperature in the filtered list
        Measurement max= tempMeasurements.stream().max(Comparator.comparing(Measurement::getTemperature))
                  .orElseThrow(NoSuchElementException::new); 
        
        //Returning the maximum temperature observed in the station
        return max;
    }


	public static  Map<Double, Integer> countTemperature(double temp1, double temp2, double r) {
		
		/*References: https://shekhargulati.com/2015/09/19/word-count-example-in-java-8/ 
		 *            https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html */
		
		List<Pair> list = new ArrayList<>();
		
		//Firstly, flatmap is used to flatten nested streams and get all the measurements in parallel streams
		
		stations.stream()
		.flatMap(station -> station.getMeasurements().parallelStream()) //streaming each station
				.forEach(a -> {
					double temp = a.getTemperature();
					//checking if the temperatures are present based on the interval and adding an entry to the list if it's present
					if(Math.abs(temp-temp1)<=r) {
						list.add(new Pair(temp1,1));
					}
					if(Math.abs(temp-temp2)<=r) {
						list.add(new Pair(temp2,1));
					}				
				});

		
		//The below code chunk performs the shuffle step using the Collectors.groupingBy and 
		//then then reduce opeartion by the Collectors.summingInt() method in parallelStreams
		Map<Double, Integer> map = new HashMap<>();		
		map = list.parallelStream().collect(Collectors.groupingBy(Pair::getKey, Collectors.summingInt(Pair::getValue)));

		//returning the result
		return map;
	}
}







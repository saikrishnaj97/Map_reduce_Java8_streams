package assignment2;


public class Measurement {
	
	int time;
	double temperature;
	
	//Constructor of Measurement class for initializing variables for the objects of class
	public Measurement(int time,double temperature)
	{
		this.time=time;
		this.temperature=temperature;
	}

	//Standard getters
    public int getTime(){
        return time;        
    }

    public double getTemperature(){
        return temperature;
    }

}

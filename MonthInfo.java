/****************************
ZId     : Z1817929
Name    : Swathi Prakasha
Course  : CSCI 680-E1
Assign  : 2
****************************/
   public class MonthInfo {

	//Month info class variables

	 int monthNum;
	 String monthName; 
	 int daysOfMonth; 

        //No argument constructor

	public MonthInfo()
	{
		this.monthNum = 0;
		this.monthName = "Null";
		this.daysOfMonth = 0;
	}

       //Argument Constructor
	
	public MonthInfo(int monthNum, String month, int numOfDays)
	{
		this.monthNum = monthNum;
		this.monthName = month;
		this.daysOfMonth = numOfDays;
	
	}
	

}

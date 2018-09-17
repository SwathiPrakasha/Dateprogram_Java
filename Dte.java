/****************************
ZId     : Z1817929
Name    : Swathi Prakasha
Course  : CSCI 680-E1
Assign  : 2
****************************/

public class Dte {

	// Class variables
	private int month;
	private int day;
	private int year;

	// no argument constructor
	public Dte() {
		this.month = 1;
		this.day = 1;
		this.year = 1801;
	}

	// three argu constructor
	public Dte(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}

	// Dte class constructor
	public Dte(Dte a) {
		this.month = a.month;
		this.day = a.day;
		this.year = a.year;
	}

	// getters 
	public int getYear() 
	{
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	// setters
	public void setYear(int year) 
	{
		this.year = year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public static MonthInfo[] monthData = { new MonthInfo(1, "Jan", 31), new MonthInfo(2, "Feb", 28),
			new MonthInfo(3, "Mar", 31), new MonthInfo(4, "Apr", 30), new MonthInfo(5, "May", 31),
			new MonthInfo(6, "June", 30), new MonthInfo(7, "July", 31), new MonthInfo(8, "Aug", 31),
			new MonthInfo(9, "Sep", 30), new MonthInfo(10, "Oct", 31), new MonthInfo(11, "Nov", 30),
			new MonthInfo(12, "Dec", 31) };

	// Member function for addDays, this function calls the non-member addDays
	// function
	public void addDays(int daysToAdd) {

		Dte add = new Dte(this.month, this.day, this.year);
		// calling non-member function addDays
		Dte.addDays(add, daysToAdd); 
		setMonth(add.month);
		setDay(add.day);
		setYear(add.year);

	}

	// Member function for subDays, this function calls the non-member addDays
	// function
	public void subDays(int daysToAdd) {
        // creating new Dte object and intializing the current class date to it
		Dte sub = new Dte(this.month, this.day, this.year);
		// calling non-member function subDays
		Dte.subDays(sub, daysToAdd); 
		setMonth(sub.month);
		setDay(sub.day);
		setYear(sub.year);
	}

	// Non-member function for addDays
	public static Dte addDays(Dte d, int daysToAdd) {
		d.day += daysToAdd;
		while (d.day > monthData[d.month - 1].daysOfMonth) {

			// Checking on leap year when month is Feb
			if (d.month == 2 && (leapYearChk(d.year) == true)) {
				if (d.day > (monthData[d.month - 1].daysOfMonth + 1))
					d.day--;

				else
					break;
			}

			d.day -= monthData[d.month - 1].daysOfMonth;
			d.month++;

			// resetting the month to 1, when it passes 12
			if (d.month == 13) {
				d.month = 1;
				d.year++;
			}

		}

		return d;
	}

	// Non - member function for subtract function
	public static Dte subDays(Dte d, int daysToSub) {

		d.day -= daysToSub;

		while (d.day <= 0) {
			d.month--;

			if (d.month == 0) {
				d.month = 12;
				d.year--;
			}

			// Checking on leap year when month is Feb
			if (d.month == 2 && (leapYearChk(d.year) == true)) {
				if (d.day <= 0)
					d.day++;
				else
					break;
			}

			d.day += monthData[d.month - 1].daysOfMonth;

		}

		return d;

	}

	// Static function to verify a year is a leap year or not
	public static boolean leapYearChk(int year) {
		if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
			return true;

		else
			return false;

	}

	// overriding the toString function 
	@Override
	public String toString() {
		return String.format(month + "/" + day + "/" + year);
	}
}

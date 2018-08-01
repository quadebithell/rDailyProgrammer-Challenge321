
/*The following project was built to solve r/dailyprogramer Challenge #321 
 * https://www.reddit.com/r/dailyprogrammer/comments/6jr76h/20170627_challenge_321_easy_talking_clock/
 * 
 * Data is submitted in 24-hour time  format
 * ex: 5:30pm = 17:30
 * 
 * The programs returns the time in words
 * ex: 5:30pm = It's five thirty PM.
 * ex: 12:01am = It's twelve oh one AM.  
 * 
 * Author Quade Bithell
 * Version:1.0
 * 7/31/18--to--8/1/18
 */
import java.util.Scanner;

public class clock {

	static boolean isAM;
	public static String[] Tens = { "twenty", "thirty", "forty", "fifty" };
	public static String[] OneToTeens = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
			"ten", "eleven", "tweleve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" };

	public static void main(String[] args) {

		System.out.println("Please enter the current time in XX:YY format");
		Scanner input = new Scanner(System.in);
		String timeIN = input.nextLine();

		if (!timeIN.contains(":") || timeIN.length() > 5 || timeIN.length() < 0|| Integer.parseInt((String) timeIN.subSequence(0, 2)) >= 24) {
			do {
				System.out.println("Incorrect entry please remember to insert time as 24-hour time format XX:YY ");
				timeIN = input.nextLine();
				System.out.println(Integer.parseInt((String) timeIN.subSequence(0, 2)));
			} while (!timeIN.contains(":") || timeIN.length() > 5 || timeIN.length() < 0|| Integer.parseInt((String) timeIN.subSequence(0, 2)) >= 24);

		} else

			input.close();
		timeinwords(timeIN);

	}

	public static void timeinwords(String timeIN) {

		String time = timeIN;
		String hour;
		String mins = null;
		String[] times = time.split(":");
		int hours = Integer.parseInt(times[0]);
		int minutes = Integer.parseInt(times[1]);

		//This returns the hours from 24-hour format to 12 hour format so it can access the arrays
		if (hours >= 12) {
			hours = hours - 12;
			isAM = false;
		}
		hour = OneToTeens[hours];

		if (minutes <= 20) {
			if (minutes < 10 && minutes!=0) {
				//checks if the tens value of minutes is empty or not in order to add the "oh" prefix
				mins = "oh " + OneToTeens[minutes];

			} else
				mins = OneToTeens[minutes];

		} else if (minutes >= 20) {
			mins = Tens[(minutes / 10) - 2] + " " + OneToTeens[minutes % 10];
		}
		
		
		if (isAM == true) {
			System.out.println("The time is: " + hour + " " + mins + "AM");
		} else {
			System.out.println("The time is: " + hour + " " + mins + " PM");

		}

	}
}

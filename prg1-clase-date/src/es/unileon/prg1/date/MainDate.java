package es.unileon.prg1.date;

public class MainDate {

	public static void main(String[] args) {
		Date today;
		
		try {
			today = new Date(25,1,2023);
			// System.out.println(today);
			// System.out.println(today.getDatesUntilEndOfMonth());
			// System.out.println(today.getNumberOfDaysSinceStartOfYear());
			// System.out.println("Attempts: " + today.countAttemptsGenerateRandomDate());
			System.out.println(today.getDayOfWeek(6));
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}
	}

}

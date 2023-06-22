package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date (int day, int month, int year) throws DateException {
		//this.month = month;
		this.setMonth(month);
		//this.day = day;
		this.setDay(day);
		//this.year = year;
		this.setYear(year);
	}

	public Date (Date date) throws DateException {
		this.setMonth(date.getMonth());
		this.setDay(date.getDay());
		this.setYear(date.getYear());
	}

	public Date () {
		this.day = 1;
		this.month = 1;
		this.year = 2017;
	}

	public Date tomorrow() {
		Date tomorrow = new Date();
		if (this.daysOfMonth() == this.getDay() && this.getMonth() == 12) {
			try {
				tomorrow = new Date(1, 1, this.getYear() + 1);
			} catch (DateException e) {
				System.out.println(e.getMessage());
			}
		} else if (this.daysOfMonth() == this.getDay()) {
			try {
				tomorrow = new Date(1, this.getMonth() + 1, this.getYear());
			} catch (DateException e) {
				System.out.println(e.getMessage());
			}
		} else {
			try {
				tomorrow = new Date(this.getDay() + 1, this.getMonth(), this.getYear());
			} catch (DateException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return tomorrow;
	}
	
	public void setDay(int day) throws DateException {
		if (day < 1 || day > this.daysOfMonth() ) {
			throw new DateException("Date error: Day " + day + " of month " + this.month + " not valid");			
		}
		this.day = day;
	}
	
	public void setMonth (int month) throws DateException {
		if (month < 1 || month > 12) {
			throw new DateException("Date error: Month " + month + " not valid");
		} else if (this.day > this.daysOfMonth(month)) {
			throw new DateException("Date error: Month " + month + " not valid for current day.");
		}
		this.month = month;
	}
	
	public void setYear (int year) throws DateException {
		if (year < 1) {
			throw new DateException("Date error: Year " + year + " not valid");
		}
		this.year = year;
	}

	public int getDay() {
		return this.day;
	}

	public int getMonth() {
		return this.month;
	}

	public int getYear() {
		return this.year;
	}
	
	private int daysOfMonth(int monthNumber) {
		int numDays;
		
		numDays = 0;
		switch (monthNumber) {
		case 1: //next
		case 3: //next
		case 5: //next
		case 7: //next
		case 8: //next
		case 10: //next
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			numDays = 28;
			break;			
		}
		
		return numDays;
	}

	public int daysOfMonth() {
		return this.daysOfMonth(this.month);
	}

	public boolean isSameYear(Date date) {
		// boolean same = false;
		// if (date.getYear() == this.year) {
		// 	same = true;
		// }

		// return same;

		return (date.getYear() == this.year);
	}

	public boolean isSameMonth(Date date) {
		// boolean same = false;
		// if (date.getMonth() == this.month) {
		// 	same = true;
		// }

		// return same;
		return (date.getMonth() == this.month);
	}

	public boolean isSameDay(Date date) {
		// boolean same = false;
		// if (date.getDay() == this.day) {
		// 	same = true;
		// }

		// return same;
		return (date.getDay() == this.day);
	}

	public boolean isSame(Date date) {
		// boolean same = false;
		// if (isSameDay(date) && isSameMonth(date) && isSameYear(date)) {
		// 	same = true;
		// }

		// return same;
		return (isSameDay(date) && isSameMonth(date) && isSameYear(date));
	}

	public String getMonthName() {
		String monthName = "";
		switch (this.month) {
			case 1:
				monthName = "January";
				break;
			case 2:
				monthName = "February";
				break;
			case 3:
				monthName = "March";
				break;
			case 4:
				monthName = "April";
				break;
			case 5:
				monthName = "May";
				break;
			case 6:
				monthName = "June";
				break;
			case 7:
				monthName = "July";
				break;
			case 8:
				monthName = "August";
				break;
			case 9:
				monthName = "September";
				break;
			case 10:
				monthName = "October";
				break;
			case 11:
				monthName = "November";
				break;
			case 12:
				monthName = "December";
				break;
			default:
				break;
		}

		return monthName;
	}

	public String getMonthName(int month) {
		String monthName = "";
		switch (month) {
			case 1:
				monthName = "January";
				break;
			case 2:
				monthName = "February";
				break;
			case 3:
				monthName = "March";
				break;
			case 4:
				monthName = "April";
				break;
			case 5:
				monthName = "May";
				break;
			case 6:
				monthName = "June";
				break;
			case 7:
				monthName = "July";
				break;
			case 8:
				monthName = "August";
				break;
			case 9:
				monthName = "September";
				break;
			case 10:
				monthName = "October";
				break;
			case 11:
				monthName = "November";
				break;
			case 12:
				monthName = "December";
				break;
			default:
				break;
		}

		return monthName;
	}

	public String getSeasonName() {
		String monthSeason = "";
		switch (this.month) {
			case 1:
			case 2:
			case 12:
				monthSeason = "Winter";
				break;
			case 3:
			case 4:
			case 5:
				monthSeason = "Spring";
				break;
			case 6:
			case 7:
			case 8:
				monthSeason = "Summer";
				break;
			case 9:
			case 10:
			case 11:
				monthSeason = "Autumn";
				break;
			default:
				break;
		}

		return monthSeason;
	}

	public String getMonthsLeft() {
		int monthOfDate = this.getMonth();
		StringBuffer monthsLeft = new StringBuffer();

		for (int i = monthOfDate + 1; i <= 12; i++) {
			monthsLeft.append(getMonthName(i) + " ");
		}

		return monthsLeft.toString();
	}

	public String getDaysLeftOfMonth() {
		StringBuffer datesUntilEndOfMonth = new StringBuffer();
		int dayOfDate = this.getDay();
		int daysOfMonth = this.daysOfMonth();
		Date date = new Date();

		for (int i = dayOfDate + 1; i <= daysOfMonth; i++) {
			try {
				date.setDay(i);
				date.setMonth(this.getMonth());
				date.setYear(this.getYear());
			} catch (DateException e) {
				System.out.println(e.getMessage());
			}
			datesUntilEndOfMonth.append(date.toString() + " ");
		}
		return datesUntilEndOfMonth.toString();
	}

	public String getMonthsSameDays() {
		int daysOfMonthDate = this.daysOfMonth();
		String months = "";
		switch (daysOfMonthDate) {
			case 28:
				months = "February ";
				break;
			case 30:
				months = "April June September November ";
				break;
			case 31:
				months = "January March May July August October December ";
			default:
				break;
		}
		return months;
	}

	public int daysPast() {
		int daysSinceStart = this.getDay() - 1;
		for (int i = 1; i < this.getMonth(); i++) {
			daysSinceStart += daysOfMonth(i);
		}
		return daysSinceStart;
	}

	public int numRandomTriesEqualDate() {
		Date generatedDate = new Date();
		try {
			generatedDate.setYear(this.getYear());
		} catch (DateException e) {
			System.out.println(e.getMessage());
		}
		int attempts = 1;

		while (!(this.isSame(generatedDate))) {
			int randomMonth = (int) ((Math.random() * 12) + 1);
			int randomDay = (int) ((Math.random() * daysOfMonth(randomMonth)) + 1);
			
			try {
				generatedDate.setDay(randomDay);
				generatedDate.setMonth(randomMonth);
			} catch (DateException e) {
				System.out.println(e.getMessage());
			}
			attempts += 1;
		}

		// do {
		// 	int randomMonth = (int) ((Math.random() * 12) + 1);
		// 	int randomDay = (int) ((Math.random() * daysOfMonth(randomMonth)) + 1);
			
		// 	try {
		// 		generatedDate.setDay(randomDay);
		// 		generatedDate.setMonth(randomMonth);
		// 	} catch (DateException e) {
		// 		System.out.println(e.getMessage());
		// 	}
		// 	attempts += 1;
		// } while (!(this.isSame(generatedDate)));

		return attempts;
	}

	public String getDayName(int dayNumber) {
		String dayName = "";
		switch (dayNumber) {
			case 0:
				dayName = "Monday";
				break;
			case 1:
				dayName = "Tuesday";
				break;
			case 2:
				dayName = "Wednesday";
				break;
			case 3:
				dayName = "Thursday";
				break;
			case 4:
				dayName = "Friday";
				break;
			case 5:
				dayName = "Saturday";
				break;
			case 6:
				dayName = "Sunday";
				break;
		
			default:
				break;
		}

		return dayName;
	}

	public String dayOfWeek(int nameOfFirstDay) {
		if (nameOfFirstDay >= 5) {
			nameOfFirstDay = -1;
		}
		int shift = nameOfFirstDay - 1;
		int daysSinceStartOfYear = this.daysPast();
		return getDayName(daysSinceStartOfYear % 7 + shift);
	}
	
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}


}

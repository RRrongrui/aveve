package ab.util.model;

import java.io.Serializable;

public class ChoiceDate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5623348075236566987L;
	private String year;
	private String month;
	private String day;
	private String hour;
	private String minute;

	public ChoiceDate(String year, String month, String day, String hour,
			String minute) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
		this.hour = hour;
		this.minute = minute;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	@Override
	public String toString() {
		return "ChoiceDate [year=" + year + ", month=" + month + ", day=" + day
				+ ", hour=" + hour + ", minute=" + minute + "]";
	}

}

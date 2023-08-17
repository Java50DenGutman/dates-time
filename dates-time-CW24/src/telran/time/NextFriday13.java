package telran.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.UnsupportedTemporalTypeException;

public class NextFriday13 implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {
		// TODO Auto-generated method stub
		if (!(temporal instanceof LocalDate)) {
			throw new UnsupportedTemporalTypeException("Only LocalDate supported");
		}

		LocalDate date = (LocalDate) temporal;

		if (date.getDayOfMonth() >= 13) {
			date = date.plusMonths(1).withDayOfMonth(13);
		} else {
			date = date.withDayOfMonth(13);
		}

		while (date.getDayOfWeek() != DayOfWeek.FRIDAY) {
			date = date.plusMonths(1).withDayOfMonth(13);
		}

		return date;
	}

}

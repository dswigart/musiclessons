import java.time.LocalDate;

public class Season {
	
	static LocalDate mBeginFall = LocalDate.parse("2015-09-01");
	static LocalDate mEndFall = LocalDate.parse("2015-12-15");
	
	static LocalDate mBeginWinterSpring = LocalDate.parse("2016-01-12");
	static LocalDate mEndWinterSpring = LocalDate.parse("2016-05-20");
	
	static LocalDate mBeginSummer = LocalDate.parse("2016-06-01");
	static LocalDate mEndSummer = LocalDate.parse("2016-08-20");
	
	static LocalDate returnEndOfSeason(LocalDate y) {
		
		while (true) {
		if (y.isAfter(mBeginFall) && y.isBefore(mEndFall)) {
			return mEndFall;
		}
		if (y.isAfter(mBeginWinterSpring) && y.isBefore(mEndWinterSpring)) {
			return mEndWinterSpring;
		}
		if (y.isAfter(mBeginFall) && y.isBefore(mEndFall)) {
			return mEndSummer;
		}
		
		y = y.plusMonths(1);
		}
	}
}

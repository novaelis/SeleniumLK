package testing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertIntoProperDate {
	public static void main(String[] args) throws ParseException {
		Date d = new Date();
		SimpleDateFormat originalFormat = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat formattedDate = new SimpleDateFormat("MMM dd, yyyy");
		d = originalFormat.parse("12/15/2020");

		System.out.println(formattedDate.format(d));
	}
}

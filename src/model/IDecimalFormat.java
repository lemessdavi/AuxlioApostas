package model;
import java.text.DecimalFormat;
import java.util.Locale;

public interface IDecimalFormat {
	public DecimalFormat df = new DecimalFormat("'R$'0.00");
	
	
	public default String setDecimal(double decimal) {
		return df.format(decimal);
	}
}




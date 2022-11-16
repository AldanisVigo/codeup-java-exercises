package MessingAround;

import java.text.NumberFormat;
import java.util.Locale;

public class TestingNumberFormat {
    public static void main(String[] args){

        //Formatting numbers with commas.
        NumberFormat formatter = NumberFormat.getInstance();
        long myNumber = 8_000_000_000L;
        String myNumberFormatted = formatter.format(myNumber);
        System.out.println(myNumberFormatted);

        //Currency Formatted Number with default Locale
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        String myCurrencyFormattedNumber = currencyFormatter.format(myNumber);
        System.out.println(myCurrencyFormattedNumber);

        //Currency Formatted Number with a Locale
        NumberFormat usaCurrencyFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        String myUsCurrencyFormattedNumber = usaCurrencyFormatter.format(usaCurrencyFormatter);
        System.out.println(myUsCurrencyFormattedNumber);
    }
}

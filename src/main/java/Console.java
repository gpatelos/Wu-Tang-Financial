import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.math.BigDecimal;
import java.util.Scanner;

public class Console {

    public static void splash(){

        System.out.println("Hello and welcome to WuTang Financial, where it is still all so simple.\n\n");
    }

    public static void startTheThing() {

            Console console = new Console();
            CurrencyHandler currencyHandler = new CurrencyHandler();

            System.out.println("What currency you have brought to exchange? (options follow)");
            console.printCurrencies();
            Currency sourceCurrency = console.getCurrencyType();

            System.out.println("and what are you converting to?");
            Currency targetCurrency = console.getCurrencyType();

            System.out.println("and how much cash do you have in "+ currencyHandler.getCurrencySymbol(sourceCurrency) + " that you would like to convert today?");
            double amountToConvert = console.getDoubleInput();


            double convertedAmount = sourceCurrency.convertTo(targetCurrency, amountToConvert);
            BigDecimal convertedAmountBigDecimal = currencyHandler.formatDecimal(convertedAmount);

            System.out.println("Excellent, at the current exchange rate we can give you " + convertedAmountBigDecimal.toString()
                    + " " + currencyHandler.getCurrencySymbol(targetCurrency) + "\n\n");

            console.startTheThing();

    }

    public double getDoubleInput() {
        Scanner scan = new Scanner(System.in);
        double dblInput;
        String stringInput = scan.nextLine();

        dblInput = Double.valueOf(stringInput);

        return dblInput;
    }

    public Currency getCurrencyType() {
        Scanner scan = new Scanner(System.in);


        do {
            String stringInput = scan.nextLine();
            for (Currency currency : Currency.values()) {
                if (currency.toString().equalsIgnoreCase(stringInput)) {
                    return currency;
                }
            }
            System.out.println("Please enter a valid currency.");
        } while (true);
    }

    public void printCurrencies(){

        for(Currency currency: Currency.values()){
            System.out.println(currency.toString());
        }

    }

}

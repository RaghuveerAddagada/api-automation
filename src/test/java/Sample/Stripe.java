package Sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class Stripe {

    final String STRIPE_URL = "https://stripe.com/docs/testing?testing-method=card-numbers";
    final String COUNTRY = "India (IN)";
    Elements elements = new Elements();

    @BeforeClass(alwaysRun = true)
    public void getPageDoc() throws IOException {
        final Document doc = Jsoup.connect(STRIPE_URL).get();
        elements = doc.select(String.format("td:contains(%s)", COUNTRY));
    }

    @Test()
    public void testA() {
        try {
            final Elements countryElements = elements.select(String.format("td")).parents();
            final String FULL_CARD_NUMBER = String.format("Dummy Credit card number from Stripe for %s is : %s", COUNTRY, countryElements.get(0).text());
            System.out.println(FULL_CARD_NUMBER);
        } catch (IndexOutOfBoundsException iob) {
            final String FAILURE_MESSAGE = String.format("No Dummy Credit Card Found for give Country : %s", COUNTRY);
            System.out.println(FAILURE_MESSAGE);
        }
    }
}

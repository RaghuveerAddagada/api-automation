package sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Stripe {

    private static final Logger log = LogManager.getLogger(Stripe.class);
    final String STRIPE_URL = "https://stripe.com/docs/testing?testing-method=card-numbers";
    final String IND = "India (IN)";

    final String SINGAPORE = "Singapore (SG)";

    final String UK_GB = "United Kingdom (GB)";

    Elements elements = new Elements();

    @BeforeClass(alwaysRun = true)
    public void getPageDoc() throws IOException {
        final Document doc = Jsoup.connect(STRIPE_URL).get();
        elements = doc.select(String.format("td:contains(%s)", UK_GB));
    }

    @Test()
    public void testA() {
        try {
            final Elements countryElements = elements.select(String.format("td")).parents();
            final String FULL_CARD_NUMBER = String.format("Dummy Credit card number from Stripe is : %s", countryElements.get(0).text());
            log.info(FULL_CARD_NUMBER);
        } catch (IndexOutOfBoundsException iob) {
            final String FAILURE_MESSAGE = String.format("No Dummy Credit Card Found for give Country : %s", UK_GB);
            log.error(FAILURE_MESSAGE);
        }
    }
}

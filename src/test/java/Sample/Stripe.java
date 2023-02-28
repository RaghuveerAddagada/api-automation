package Sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class Stripe {

    final String STRIPE_URL = "https://stripe.com/docs/testing?testing-method=card-numbers";
    final String COUNTRY = "India (IN)";

    @Test()
    public void testA() throws IOException {
        final Document doc = Jsoup.connect(STRIPE_URL).get();
        final Elements elements = doc.select(String.format("td:contains(%s)", COUNTRY));

        try {
            final Element countryElements = elements.get(0).parent().child(1);
            final Element copyToClipboard = countryElements.child(0);
            final Element CardNumber = copyToClipboard.child(0);
            final Elements spanElements = CardNumber.select("span");
            if (spanElements.size() > 0) {
                final String FULL_CARD_NUMBER = String.format("Dummy Credit card number from Stripe for %s : %s", COUNTRY, spanElements.get(0).text());
                System.out.println(FULL_CARD_NUMBER);
            }
        } catch (IndexOutOfBoundsException iob) {
            final String FAILURE_MESSAGE = String.format("NO Dummy Credit Card Found for give Country : %s", COUNTRY);
            System.out.println(FAILURE_MESSAGE);
        }
    }
    //<tr>
    // <td>India (IN)</td>
    // <td><button title="Copy to clipboard" class="UnstyledLink InlineLink Text-color--blue CardNumber-Clipboard" type="button"><span class="CardNumber"><span>4000</span><span>0035</span><span>6000</span><span>0008</span></span>
    //   <div aria-hidden="true" title="Copy to clipboard" class="SVGInline SVGInline--cleaned SVG Icon Icon--clipboard CardNumber-CopyIcon Icon-color Icon-color--gray300 Box-root Flex-flex" style="position:relative;top:+1px">
    //    <svg aria-hidden="true" class="SVGInline-svg SVGInline--cleaned-svg SVG-svg Icon-svg Icon--clipboard-svg CardNumber-CopyIcon-svg Icon-color-svg Icon-color--gray300-svg" height="14" width="14" viewbox="0 0 16 16" xmlns="http://www.w3.org/2000/svg">
    //     <path d="M7 5h2a3 3 0 0 0 3-3 2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2 3 3 0 0 0 3 3zM6 2a2 2 0 1 1 4 0 1 1 0 0 1-1 1H7a1 1 0 0 1-1-1z" fill-rule="evenodd"></path>
    //    </svg>
    //   </div></button></td>
    // <td>Visa</td>
    //</tr>
}

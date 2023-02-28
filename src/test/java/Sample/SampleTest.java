package Sample;

import com.backend.apis.DataUSA;
import com.backend.apis.GenderAPIs;
import com.backend.helpers.common.StatusCode;
import com.backend.pojo.DataUSAResponse;
import com.backend.pojo.GenderApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SampleTest extends GenderAPIs {

    @Test
    public void testNameForGender() {
        final String nameForTest = "ram";

        GenderApiResponse response = getGenderByName(nameForTest, StatusCode.OK);

        Reporter.log("Name in Response : " + response.getName(),true);
        Reporter.log("Gender in Response : " + response.getGender(),true);
        Reporter.log("Probability in Response : " + response.getProbability(),true);
        Reporter.log("Count in Response : " + response.getCount(),true);

        Assert.assertEquals(nameForTest, response.getName(), "Name mismatch in response");
    }


    @Test
    public void testData() {

        DataUSA dataUSA = new DataUSA();
        DataUSAResponse response = dataUSA.getDataOfUSA("Nation","Population",StatusCode.OK);

        Reporter.log("Name in Source  Response : " + response.getSource().get(0).getName(),true);
        Reporter.log("Subtopic in Source  Response : " + response.getSource().get(0).getAnnotations().getSubtopic(),true);
        Reporter.log("Topic in Source  Response : " + response.getSource().get(0).getAnnotations().getTopic(),true);

    }

    @Test
    public void abcdf() {
        final String getMaskedCardNumber = "XXXX-XXXX-XXXX-1223";
        final String[] cardNumberAfterSplit = getMaskedCardNumber.split("-");

        Assert.assertEquals(StringUtils.countMatches(cardNumberAfterSplit[0], "XXXX"), 1, "First part of card number is un-masked");
        Assert.assertEquals(StringUtils.countMatches(cardNumberAfterSplit[1], "XXXX"), 1, "Second part of card number is un-masked");
        Assert.assertEquals(StringUtils.countMatches(cardNumberAfterSplit[2], "XXXX"), 1, "Third part of card number is un-masked");

        if (cardNumberAfterSplit[3].startsWith("XX")) {
            Assert.assertTrue(StringUtils.isNumeric(cardNumberAfterSplit[3].replace("XX","")), "Fourth part of card number is masked");
        } else {
            Assert.assertTrue(StringUtils.isNumeric(cardNumberAfterSplit[3]), "Fourth part of card number is masked");
        }
    }
}

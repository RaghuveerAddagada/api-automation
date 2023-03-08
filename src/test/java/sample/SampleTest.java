package sample;

import com.backend.apis.DataUSA;
import com.backend.apis.GenderAPIs;
import com.backend.helpers.common.StatusCode;
import com.backend.pojo.DataUSAResponse;
import com.backend.pojo.GenderApiResponse;
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
}

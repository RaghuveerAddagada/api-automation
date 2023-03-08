package sample;

import com.backend.apis.DataUSA;
import com.backend.apis.GenderAPIs;
import com.backend.helpers.common.StatusCode;
import com.backend.pojo.DataUSAResponse;
import com.backend.pojo.GenderApiResponse;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SampleTest extends GenderAPIs {

    final Logger log = Logger.getLogger(SampleTest.class);

    @Test
    public void testNameForGender() {
        final String nameForTest = "ram";

        final GenderApiResponse response = getGenderByName(nameForTest, StatusCode.OK);
        Assert.assertEquals(nameForTest, response.getName(), "Name mismatch in response");

        log.info("Name in Response : " + response.getName());
        log.debug("Gender in Response : " + response.getGender());
        log.warn("Probability in Response : " + response.getProbability());
        log.error("Count in Response : " + response.getCount());
    }


    @Test
    public void testData() {

        final DataUSA dataUSA = new DataUSA();
        final DataUSAResponse response = dataUSA.getDataOfUSA("Nation","Population",StatusCode.OK);

        log.info("Name in Source  Response : " + response.getSource().get(0).getName());
        log.info("Subtopic in Source  Response : " + response.getSource().get(0).getAnnotations().getSubtopic());
        log.info("Topic in Source  Response : " + response.getSource().get(0).getAnnotations().getTopic());
    }
}

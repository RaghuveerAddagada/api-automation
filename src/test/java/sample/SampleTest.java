package sample;

import com.backend.apis.DataUSA;
import com.backend.apis.GenderAPIs;
import com.backend.helpers.common.StatusCode;
import com.backend.pojo.DataUSAResponse;
import com.backend.pojo.GenderApiResponse;
import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

@Log4j2
public class SampleTest extends GenderAPIs {

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

    @Test
    public void testRandomness() {
        final boolean random = new Random().nextBoolean();
        log.info("Given Value is : " + random);
        Assert.assertTrue(random, "Test Failed due to mismatch");
    }
}

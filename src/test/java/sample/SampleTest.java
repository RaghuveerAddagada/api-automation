package sample;

import com.backend.apis.GenderAPIs;
import com.backend.helpers.common.StatusCode;
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
        Assert.assertEquals(response.getName(), nameForTest, "Name mismatch in response");

        log.info("Name in Response : {}", response.getName());
        log.debug("Gender in Response : {}", response.getGender());
        log.warn("Probability in Response : {}", response.getProbability());
        log.error("Count in Response : {}", response.getCount());
    }

    @Test(enabled = false, invocationCount = 10)
    public void testRandomness() {
        final boolean random = new Random().nextBoolean();
        log.info("Given Value is : {}", random);
        Assert.assertTrue(random, "Test Failed due to mismatch");
    }
}

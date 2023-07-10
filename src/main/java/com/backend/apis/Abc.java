package com.backend.apis;

import net.jodah.failsafe.Failsafe;
import net.jodah.failsafe.RetryPolicy;
import org.awaitility.Awaitility;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.*;
import static org.awaitility.Awaitility.with;
import static org.awaitility.Duration.FIVE_SECONDS;
import static org.awaitility.Duration.ONE_MINUTE;

public class Abc {


    @Test
    public void getPrimeNumber() {
        final int number = checkPrime();
        System.out.println(number);
    }

    @Test
    public void getPrimeWithAwait(){
        with().pollInterval(FIVE_SECONDS)
                .await()
                .atMost(ONE_MINUTE)
                .untilAsserted(() -> System.out.println("prime number for you is :" + checkPrime()));
    }

    @Test
    public void tstDec() {
        final DecimalFormat df = new DecimalFormat("0.0");
        final BigDecimal a = new BigDecimal(13000.0);
        final BigDecimal b = new BigDecimal(13000);

        System.out.println("a" + a);
        System.out.println("b" + df.format(b));


        Assert.assertEquals(df.format(a), df.format(b));

    }


    @Test
    public void getPrimeNumberWithRetry() {
        RetryPolicy<Object> retryPolicy = new RetryPolicy<Object>()
                .handle(AssertionError.class)
                .onRetry(r -> System.out.println("Retrying......"))
                .withDelay(ofSeconds(3))
                .withMaxRetries(5);

        final Integer result = Failsafe.with(retryPolicy).get(() -> checkPrime());
        System.out.println("prime number for you is :" + result);
    }

    private int checkPrime() {

        boolean isPrime = true;
        final Random random = new Random();
        final int randomNumber = random.nextInt(100) + 1;

        System.out.println("Number under test :" + randomNumber);

        if (randomNumber <= 1) {
            isPrime =  false;
        }
        for (int i = 2; i <= Math.sqrt(randomNumber); i++) {
            if (randomNumber % i == 0) {
                isPrime =  false;
            }
        }
        Assert.assertTrue(isPrime);
        return randomNumber;
    }




    @Test
    public void methodO(){
        Random random = new Random();

        Callable<Integer> generateRandomNumber = () -> random.nextInt(100) + 1;


        Matcher<Integer> isPrime = new Matcher<Integer>() {
            @Override
            public void describeTo(org.hamcrest.Description description) {
                description.appendText("a prime number");
            }

            @Override
            public boolean matches(Object item) {

                System.out.println("Generated random number :" + (Integer) item);

                Integer n = (Integer) item;
                if (n <= 1) {
                    return false;
                }

                for (int i = 2; i <= Math.sqrt(n); i++) {
                    if (n % i == 0) {
                        return false;
                    }
                }

                return true;
            }

            @Override
            public void describeMismatch(Object item, Description mismatchDescription) {

            }

            @Override
            public void _dont_implement_Matcher___instead_extend_BaseMatcher_() {

            }
        };

        Integer obj = Awaitility.await()
                .atMost(1, TimeUnit.MINUTES)
                .pollInterval(3, TimeUnit.SECONDS)
                .until(generateRandomNumber, isPrime);

        System.out.println(obj);
    }

}

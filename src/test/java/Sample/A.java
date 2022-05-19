package Sample;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

public class A {

    @BeforeSuite
    public void checkAppleConnectStatus() {
        if(!isSiteUp("https://heartbeat.stg.dreamplug.net/")) {
            throw new RuntimeException(" Check your Apple Connect VPN.");
        }
    }

    @Test()
    public void testBalance() {

        String input = "{{{{{{}";
        int sizeOfInput = input.length();
        for (int i = 0; i < sizeOfInput / 2; i++) {
            input = input.replace("{}", "");
        }
        System.out.println("Number of pairs:" + (sizeOfInput - input.length()) / 2);

    }


    public static boolean isSiteUp(String url) {
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.getContent();
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return true;
            }
            return false;
        } catch (SocketTimeoutException tout) {
            return false;
        } catch (IOException ioex) {
            // You may decide on more specific behaviour...
            return false;
        }
    }
}

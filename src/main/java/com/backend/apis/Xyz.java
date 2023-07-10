package com.backend.apis;

import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Xyz {

    @Test
    public void testXyz() {
        String date = "2023-05-24T18:29:00Z";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);

        String month = dateTime.getMonth().name();

        System.out.println(month);
    }
}

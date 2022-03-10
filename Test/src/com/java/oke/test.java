package com.java.oke;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class test {
	public static void main(String[] args) {
		// Get the LocalDateTime instance
        LocalDateTime ldt
            = LocalDateTime
                  .parse("2022-02-23T21:30:00");
 
        // Get the String representation of this LocalDateTime
//        System.out.println("Original LocalDateTime: "
//                           + ldt.toString());
// 
//        // subtract 200 DAYS to LocalDateTime
        LocalDateTime value
            = ldt.minus(200, ChronoUnit.DAYS);
// 
//        // print result
//        System.out.println("LocalDateTime after subtracting DAYS: "
//                           + value);
        System.out.println(Duration.between(ldt, LocalDateTime.now()).toMinutes());
    }
}

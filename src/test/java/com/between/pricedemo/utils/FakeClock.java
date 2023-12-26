package com.between.pricedemo.utils;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;

public class FakeClock {

	public static LocalDateTime seed = LocalDateTime.now();
	private static LocalDate localDateNow;

	private static LocalDateTime getLocalDateTime() {
		return LocalDateTime.of(
			seed.getYear(),
			seed.getMonthValue(),
			seed.getDayOfMonth(),
			seed.getHour(),
			seed.getMinute(),
			seed.getSecond()
		);
	}

	public static LocalDateTime now() {
		return getLocalDateTime();
	}

	public static LocalDateTime future() {
		return getLocalDateTime().plusMonths(2);
	}

	public static LocalDateTime pastDateTime() {
		return getLocalDateTime().minusSeconds(Math.min(10, new Random().nextInt(86400)));
	}

	public static Clock nowClock() {
		return Clock.fixed(now().toInstant(ZoneOffset.UTC), ZoneOffset.UTC);
	}

	public static LocalDate localDateNow() {
		return getLocalDateTime().toLocalDate();
	}

}
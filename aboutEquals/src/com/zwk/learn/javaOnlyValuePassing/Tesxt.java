package com.zwk.learn.javaOnlyValuePassing;

import java.time.DayOfWeek;
import java.time.LocalDate;
import org.junit.Test;

public class Tesxt {
	@Test
	public void tes() {
		LocalDate date = LocalDate.now();
		int month = date.getMonthValue();
		int today = date.getDayOfMonth();
		date = date.minusDays(today - 1);
		DayOfWeek weekDay = date.getDayOfWeek();
		int value = weekDay.getValue();
		System.out.println("Mon Tue Wed Thu Fri Sat Sun");
		for (int i = 0; i < value; i++) {
			System.out.println("   ");
			while (date.getMonthValue() == month) {
				System.out.printf("%3d", date.getDayOfMonth());
				if (date.getDayOfMonth() == today)
					System.out.print("⭐");
				else
					System.out.print(" ");
				date = date.plusDays(1);
				if (date.getDayOfWeek().getValue() == 1) System.out.println();
			}
			if (date.getDayOfWeek().getValue() != 1) System.out.println();
		}
	}
}

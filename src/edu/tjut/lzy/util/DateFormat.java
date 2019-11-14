package edu.tjut.lzy.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
	public static String formatDay(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}
	public static String formatSec(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}
}

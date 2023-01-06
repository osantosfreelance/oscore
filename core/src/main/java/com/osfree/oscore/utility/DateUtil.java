package com.osfree.oscore.utility;

import lombok.extern.log4j.Log4j2;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author OlieSantos
 */
@Log4j2
public class DateUtil {

	private static final String DEFAULT_FORMAT = "dd MMMM yyyy";
	private static final String DEFAULT_DATE_TIME_FORMAT = "dd MMMM yyyy h:mm a";
	private static final String DEFAULT_TIME_FORMAT = "h:mm a";
	private static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat(DEFAULT_FORMAT);
	private static final DateTimeFormatter DEFAULT_LOCAL_DATE_FORMAT = DateTimeFormatter.ofPattern(DEFAULT_FORMAT);
	private static final DateTimeFormatter DEFAULT_LOCAL_DATE_TIME_FORMAT = DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT);
	private static final DateTimeFormatter DEFAULT_LOCAL_TIME_FORMAT = DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT);

	public static String getDefaultDateFormat(final Date date) {
		return DEFAULT_DATE_FORMAT.format(date);
	}

	public static String getDefaultDateFormat(final LocalDate date) {
		return date.format(DEFAULT_LOCAL_DATE_FORMAT);
	}

	public static String getDefaultDateFormat(final LocalDateTime date) {
		return date.format(DEFAULT_LOCAL_DATE_TIME_FORMAT);
	}

	public static String getDefaultTimeFormat(final LocalTime time) {
		return DEFAULT_LOCAL_TIME_FORMAT.format(time);
	}


}

package com.blogs.star.common.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author 一只菜鸡
 * @Date 2020-2-6 13:37
 */
public class DateUtil {

		/**
		 * 获取当前时间?分钟前的时间或者?小时前的时间或者多少个月前
		 *
		 * @param minute
		 * @return
		 */
		public static Long getTimeByMinute(Calendar calendar, int minute, int hour, int month) {

				calendar.add(Calendar.MINUTE, minute);
				calendar.add(Calendar.HOUR, hour);
				calendar.add(Calendar.MONTH, month);
				return calendar.getTime().getTime();

		}

		/**
		 * 获取当天时间指定时间的时间戳
		 *
		 * @param hour
		 * @param minute
		 * @param second
		 * @return
		 */
		public static Long initDateByDay(Integer hour, Integer minute, Integer second) {
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(new Date());
				calendar.set(Calendar.HOUR, hour);
				calendar.set(Calendar.MINUTE, minute);
				calendar.set(Calendar.SECOND, second);
				return calendar.getTime().getTime();
		}
}

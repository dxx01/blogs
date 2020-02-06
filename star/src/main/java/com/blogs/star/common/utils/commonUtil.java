package com.blogs.star.common.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author 一只菜鸡
 * @Date 2020-2-6 13:39
 */
public class commonUtil {
		/**
		 * 获取ip地址
		 *
		 * @param request
		 * @return
		 */
		public static String getIpAddress(HttpServletRequest request) {
				String ip = request.getHeader("x-forwarded-for");
				if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
						ip = request.getHeader("Proxy-Client-IP");
				}
				if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
						ip = request.getHeader("WL-Proxy-Client-IP");
				}
				if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
						ip = request.getRemoteAddr();
				}
				if (ip.contains(",")) {
						return ip.split(",")[0];
				} else {
						return ip;
				}
		}

		/**
		 * 获取验证码
		 *
		 * @return
		 */
		public static String getEmailCode() {
				//创建一个ArrayList集合，存放生成的代码
				List<Object> list = new ArrayList();
				//for循环生成6位验证码
				for (int i = 0; i < 6; i++) {
						//if语句交替判断生成数字或者字母
						if (i % 2 == 0) {
								int b = (int) (Math.random() * 10);//生成0~9的数字
								list.add(b);
						} else {
								boolean flag = false;
								do {
										int a = (int) (Math.random() * 58 + 65);//生成大小写字母的ASCII码
										//if排斥多余的中间其他字符
										if (!(a >= 91 && a <= 95)) {
												String s = (char) a + "";//数字转字母
												list.add(s);
												flag = true;
										}
								} while (!flag);
						}
				}
				Collections.shuffle(list);//shuffle随机排序
				StringBuilder out = new StringBuilder();
				for (Object s : list) {
						out.append(s);
				}
				return out.toString();
		}
}

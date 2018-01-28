package com.take4.themoment.util;

/**
 * Created by jaehyunpark on 2018. 1. 21..
 */

public class StringUtils {
	public static boolean isEmpty(CharSequence charSequence) {
		return charSequence == null || charSequence.length() == 0;
	}
}
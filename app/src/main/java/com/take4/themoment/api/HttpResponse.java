package com.take4.themoment.api;

import lombok.Getter;

/**
 * Created by jaehyunpark on 2018. 1. 14..
 */

public class HttpResponse {

	private static int SUCCESS_CODE = 200;

	@Getter
	public int code;

	public boolean isSuccess() {
		return code == SUCCESS_CODE;
	}
}

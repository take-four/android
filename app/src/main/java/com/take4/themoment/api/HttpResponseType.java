package com.take4.themoment.api;

/**
 * Created by jaehyunpark on 2018. 1. 14..
 */

public enum HttpResponseType {
	SUCCESS,
	SUCCESS_BUT_AUTHENTICATION_FAIL,
	FAIL_HTTP_UNAUTHORIZED,
	FAIL_HTTP_ERROR;
}

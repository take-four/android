package com.take4.themoment.auth;

import lombok.Getter;

/**
 * Created by jaehyunpark on 2018. 1. 6..
 */

public enum AuthRequestCode {
	EXTERNAL_ACCOUNT_GOOGLE(100),
	EXTERNAL_ACCOUNT_FACEBOOK(0xface);

	@Getter
	private int code;

	AuthRequestCode(int code) {
		this.code = code;
	}
}

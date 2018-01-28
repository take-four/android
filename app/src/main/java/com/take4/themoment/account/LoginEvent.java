package com.take4.themoment.account;

import lombok.Value;

/**
 * Created by jaehyunpark on 2018. 1. 27..
 */

public interface LoginEvent {
	@Value
	class LogInSucceed {
		String userIdToken;
	}

	@Value
	class LoginInFailed {
		String exception;
	}
}

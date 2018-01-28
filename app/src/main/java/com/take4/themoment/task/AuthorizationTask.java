package com.take4.themoment.task;

import com.take4.themoment.api.HttpApiLibrary;
import com.take4.themoment.api.HttpCallback;
import com.take4.themoment.model.User;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jaehyunpark on 2018. 1. 14..
 */

@Slf4j
public class AuthorizationTask extends BaseHttpTask<User> {
	private HttpApiLibrary api;

	AuthorizationTask(HttpApiLibrary api, HttpCallback callback) {
		super(callback);
		this.api = api;
	}

	@Override
	User execute() throws Exception {
		return api.getUser();
	}
}

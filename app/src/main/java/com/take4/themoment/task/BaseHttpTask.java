package com.take4.themoment.task;

import com.take4.themoment.api.HttpCallback;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jaehyunpark on 2018. 1. 14..
 */

@Slf4j
public abstract class BaseHttpTask<Result> implements Runnable {

	@Getter
	public Result result;

	private HttpCallback callback;

	public BaseHttpTask(HttpCallback callback) {
		this.callback = callback;
	}

	abstract Result execute() throws Exception;

	@Override
	public void run() {
		try {
			result = execute();

			onSuccess();
		} catch (Exception e) {
			e.printStackTrace();

			onFailed(e);
		}
	}

	void onSuccess() {
		if (callback != null) {
			callback.onSuccess(this);
		}
	}

	void onFailed(Exception e) {
		if (callback != null) {
			callback.onFail(this, e);
		}
	}
}

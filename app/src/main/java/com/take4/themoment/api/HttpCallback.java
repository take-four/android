package com.take4.themoment.api;

import com.take4.themoment.task.BaseHttpTask;

/**
 * Created by jaehyunpark on 2018. 1. 14..
 */

public interface HttpCallback {

	void onSuccess(BaseHttpTask baseHttpTask);

	void onFail(BaseHttpTask baseHttpTask, Exception e);
}

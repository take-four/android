package com.take4.themoment.task;

import java.io.IOException;

import android.util.Log;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by jaehyunpark on 2018. 1. 15..
 */

public class SyncExecutor<T> {

	public Response<T> execute(Call<T> call) throws Exception {
		Response<T> response;

		try {
			response = call.execute();
			Log.d("SyncExecutor ", "SyncExecutor");
		} catch (IOException e) {
			if (call.isCanceled()) {
				Log.d("call canceled", "" + e);
			} else {
				// network error 처리
			}
			throw e;
		}
		return response;
	}
}

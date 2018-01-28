package com.take4.themoment.support.dagger.module;

import javax.inject.Singleton;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.take4.themoment.api.HttpApi;
import com.take4.themoment.api.HttpApiClient;
import com.take4.themoment.api.HttpInterceptor;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jaehyunpark on 2018. 1. 11..
 */

@Module
public class NetworkModule {

	@Singleton
	@Provides
	HttpApiClient provideHttpApiClient(HttpApi api) {
		return new HttpApiClient(api);
	}

	@Singleton
	@Provides
	HttpApi provideHttpApi(OkHttpClient okHttpClient) {
		return new Retrofit.Builder()
			.client(okHttpClient)
			.baseUrl("http://13.124.248.212:8080/apis/")
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create(HttpApi.class);
	}

	@Singleton
	@Provides
	OkHttpClient provideOkHttpClient() {
		return new OkHttpClient.Builder()
			.addInterceptor(new HttpInterceptor())
			.addNetworkInterceptor(new StethoInterceptor())
			.build();
	}
}

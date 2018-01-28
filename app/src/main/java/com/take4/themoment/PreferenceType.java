package com.take4.themoment;

import lombok.Getter;

/**
 * Created by jaehyunpark on 2018. 1. 5..
 */

public enum PreferenceType {
	ACCOUNT_PREFERENCE("account_preference");

	@Getter
	private String name;

	PreferenceType(String name) {
		this.name = name;
	}
}

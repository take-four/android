package com.take4.themoment.moment.feed;

import lombok.Getter;

/**
 * Created by jaehyunpark on 2018. 1. 31..
 */

public enum MomentFeedType {
	ALL_FEED("all_feed"),
	MY_ALL_FEED("my_all_feed"),
	MY_LIKED_FEED("my_liked_feed");

	@Getter
	private String name;

	MomentFeedType(String name) {
		this.name = name;
	}
}

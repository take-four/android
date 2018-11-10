package com.take4.themoment.moment.feed;

import android.util.SparseArray;
import com.take4.themoment.R;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jaehyunpark on 2018. 1. 31..
 */

@Slf4j
public enum MomentFeedType {
	ALL_FEED("all_feed", R.menu.menu_feed_all);

	private static final SparseArray<MomentFeedType> LOOKUP;

	static {
		LOOKUP = new SparseArray<>();

		for (MomentFeedType each : values()) {
			log.debug("NavigationItem : {}", each);
			LOOKUP.put(each.ordinal(), each);
		}
	}

	@Getter
	private String name;

	@Getter
	private int menuId;

	MomentFeedType(String name, int menuId) {
		this.name = name;
		this.menuId = menuId;
	}

	public static MomentFeedType find(String typeName) {
		if (typeName == null) {
			return null;
		}

		for (MomentFeedType item : values()) {
			if (item.getName().equals(typeName)) {
				return item;
			}
		}
		return null;
	}
}

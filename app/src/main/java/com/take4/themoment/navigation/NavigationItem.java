package com.take4.themoment.navigation;

import android.support.v4.app.Fragment;
import android.util.SparseArray;
import com.take4.themoment.R;
import com.take4.themoment.moment.feed.MomentFeedFragment;
import com.take4.themoment.moment.feed.MomentFeedType;
import com.take4.themoment.moment.map.MomentMapFragment;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jaehyunpark on 2018. 1. 30..
 */
@Slf4j
public enum NavigationItem {
	ALL_MOMENTS(0, "all_moments", R.drawable.ico_feed) {
		@Override
		public Fragment createFragment() {
			return MomentFeedFragment.newInstance(MomentFeedType.ALL_FEED);
		}
	},

	MY_ALL_MOMENTS(1, "my_all_moments", R.drawable.ico_placeholder) {
		@Override
		public Fragment createFragment() {
			return MomentFeedFragment.newInstance(MomentFeedType.MY_ALL_FEED);
		}
	},

	MY_LIKED_MOMENTS(2, "my_liked_moments", R.drawable.ico_like) {
		@Override
		public Fragment createFragment() {
			return MomentFeedFragment.newInstance(MomentFeedType.MY_LIKED_FEED);
		}
	},

	MY_MOMENTS_MAP(3, "my_moments_map", R.drawable.ico_map) {
		@Override
		public Fragment createFragment() {
			return MomentMapFragment.newInstance();
		}
	};

	private static final SparseArray<NavigationItem> LOOKUP;

	static {
		LOOKUP = new SparseArray<>();

		for (NavigationItem each : values()) {
			log.debug("NavigationItem : {}", each);
			LOOKUP.put(each.getCode(), each);
		}
	}

	@Getter
	private final int code;

	@Getter
	private final String id;

	@Getter
	private final int iconResId;

	NavigationItem(int code, String id, int iconResId) {
		this.code = code;
		this.id = id;
		this.iconResId = iconResId;
	}

	public abstract Fragment createFragment();

	public static Fragment create(int code) {
		NavigationItem item = NavigationItem.find(code);
		return item.createFragment();
	}

	public static NavigationItem find(int code) {
		return LOOKUP.get(code);
	}

	public static NavigationItem find(String id) {
		if (id == null) {
			return null;
		}

		for (NavigationItem item : values()) {
			if (item.getId().equals(id)) {
				return item;
			}
		}
		return null;
	}
}

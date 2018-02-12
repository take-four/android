package com.take4.themoment.navigation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.take4.themoment.AppPreference;
import com.take4.themoment.R;
import com.take4.themoment.base.BaseActivity;
import com.take4.themoment.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jaehyunpark on 2018. 1. 30..
 */

@Slf4j
public class NavigationController {
	private static int PAGE_TOTAL_COUNT = 4;
	private static int DEFAULT_ACTIVE_ITEM_CODE = 0;

	@BindView(R.id.main_view_pager)
	ViewPager viewPager;

	@BindView(R.id.main_tab_bar_layout)
	View tabBarLayout;

	@BindView(android.R.id.tabhost)
	TabHost tabHost;

	@BindView(android.R.id.tabs)
	TabWidget tabWidget;

	private PagerAdapter pagerAdapter;
	private NavigationItem activeItem;

	private BaseActivity activity;

	public NavigationController(BaseActivity activity) {
		this.activity = activity;
		ButterKnife.bind(this, activity);

		initActiveItem();
		initTabBar();
		initViewPager();
	}

	private void initActiveItem() {
		AppPreference preference = new AppPreference(activity);
		String itemId = preference.getActiveNavigationItemId();
		if (StringUtils.isEmpty(itemId)) {
			activeItem = NavigationItem.find(DEFAULT_ACTIVE_ITEM_CODE);
		} else {
			activeItem = NavigationItem.find(itemId);
		}
	}

	private void initTabBar() {
		tabHost.setup();
		createTabWidget();
	}

	private void createTabWidget() {
		tabWidget.removeAllViews();

		for (int pageCode = 0; pageCode < PAGE_TOTAL_COUNT; pageCode++) {
			NavigationItem item = NavigationItem.find(pageCode);
			View tabItemView = View.inflate(tabWidget.getContext(), R.layout.main_tab_bar_item, null);
			ImageView tabItemIcon = tabItemView.findViewById(R.id.tab_bar_item_icon);
			tabItemIcon.setImageResource(item.getIconResId());
			tabItemView.setTag(item.getId());
			tabWidget.addView(tabItemView);

			tabItemView.setOnClickListener(view -> changePageItem(findNavigationItem(view)));
		}
	}

	private void initViewPager() {
		pagerAdapter = new PagerAdapter(getSupportFragmentManager());
		viewPager.setAdapter(pagerAdapter);
		viewPager.setCurrentItem(activeItem.getCode());
		pagerAdapter.notifyDataSetChanged();
	}

	private void changePageItem(NavigationItem item) {
		// tabWidget.setCurrentTab(item.getCode());
		log.debug("selected navigation item : {}", item);
		viewPager.setCurrentItem(item.getCode());
		pagerAdapter.notifyDataSetChanged();
	}

	private NavigationItem findNavigationItem(View view) {
		Object viewTag = view.getTag();

		if (viewTag == null) {
			return null;
		}

		if (!(viewTag instanceof String)) {
			return null;
		}

		return NavigationItem.find((String)viewTag);
	}

	public void showTabBar() {
		tabBarLayout.setVisibility(View.VISIBLE);
	}

	public void hideTabBar() {
		tabBarLayout.setVisibility(View.GONE);
	}

	private FragmentManager getSupportFragmentManager() {
		return activity.getSupportFragmentManager();
	}

	private class PagerAdapter extends FragmentStatePagerAdapter {

		PagerAdapter(FragmentManager fragmentManager) {
			super(fragmentManager);
		}

		@Override
		public Fragment getItem(int position) {
			return NavigationItem.create(position);
		}

		@Override
		public int getCount() {
			return PAGE_TOTAL_COUNT;
		}
	}
}

package com.take4.themoment.base;

import javax.annotation.Nullable;
import javax.inject.Inject;

import android.support.design.widget.FloatingActionButton;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.take4.themoment.R;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jaehyunpark on 2018. 2. 26..
 */

@Slf4j
public class FloatingLayerController {

	@Nullable
	@BindView(R.id.floating_action_button)
	FloatingActionButton floatingActionButton;

	@Inject
	public FloatingLayerController() {
	}

	public static boolean hasFloatingLayer(View view) {
		return view.findViewById(R.id.floating_layer) != null;
	}

	public void bindView(View containerView) {
		ButterKnife.bind(this, containerView);

		if(floatingActionButton != null) {
			setFloatingActionButton();
		}
	}

	private void setFloatingActionButton() {
		log.debug("FloatingLayerController # setFloatingActionButton");
	}
}

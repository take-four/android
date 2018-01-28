package com.take4.themoment.support.bus;

import android.os.Handler;
import android.os.Looper;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;
import com.take4.themoment.AppComponentContainer;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by jaehyunpark on 2018. 1. 26..
 */

@Slf4j
public class EventBusProvider {
	public static EventBus getInstance() {
		return AppComponentContainer.get().getEventBus();
	}

	private EventBusProvider() {
	}

	public static void registerSafely(Object object) {
		getInstance().registerSafely(object);
	}

	public static void unregisterSafely(Object object) {
		getInstance().unregisterSafely(object);
	}

	public static class EventBus extends Bus {
		public EventBus() {
			super(ThreadEnforcer.ANY);
		}

		private void registerSafely(Object object) {
			register(object);
		}

		private void unregisterSafely(Object object) {
			unregister(object);
		}

		@Override
		public void register(Object object) {
			try {
				super.register(object);
			} catch (IllegalArgumentException e) {
				log.error("unable to register subscriber {}", object);
			}
		}

		@Override
		public void unregister(Object object) {
			try {
				super.unregister(object);
			} catch (IllegalArgumentException e) {
				log.error("unable to register subscriber {}", object);
			}
		}

		@Override
		public void post(Object event) {
			if (Looper.myLooper() == Looper.getMainLooper()) {
				super.post(event);
			} else {
				new Handler(Looper.getMainLooper()).post(() -> EventBus.super.post(event));
			}
		}
	}
}

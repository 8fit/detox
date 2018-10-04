package com.wix.detox;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.test.rule.ActivityTestRule;

public class DetoxActivityTestRule<T> extends ActivityTestRule {
    public DetoxActivityTestRule(Class<T> activityClass, boolean initialTouchMode, boolean launchActivity) {
        super(activityClass, initialTouchMode, launchActivity);
    }

    public DetoxActivityTestRule(Class<T> activityClass) {
        super(activityClass, false, false);
    }

    private void superLaunchActivity(Intent startIntent) {
        super.launchActivity(startIntent);
    }

    public Activity launchActivityWithURL(@Nullable final Intent startIntent) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                superLaunchActivity(startIntent);
            }
        }).start();
        return null;
    }
}

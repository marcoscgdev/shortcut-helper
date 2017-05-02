package com.marcoscg.shortcuthelper;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @MarcosCGdev on 02/05/2017.
 */

@TargetApi(25)
public class ShortcutHelper {

    private static Activity mActivity;
    private ShortcutManager mShortcutManager;
    private static List<ShortcutInfo> mShortcutInfos = new ArrayList<ShortcutInfo>();

    public static ShortcutHelper with(Activity activity) {
        mActivity = activity;
        return new ShortcutHelper();
    }

    public static ShortcutHelper with(Fragment fragment) {
        mActivity = fragment.getActivity();
        return new ShortcutHelper();
    }

    public ShortcutHelper createShortcut(@NonNull CharSequence shortLabel, @NonNull CharSequence longLabel, @NonNull int iconResource, @NonNull Intent intent) {
        String shortcutId = shortLabel.toString().replaceAll("\\s+","").toLowerCase() + "_shortcut";
        ShortcutInfo shortcut = new ShortcutInfo.Builder(mActivity, shortcutId)
                .setShortLabel(shortLabel)
                .setLongLabel(longLabel)
                .setIcon(Icon.createWithResource(mActivity, iconResource))
                .setIntent(intent)
                .build();
        mShortcutInfos.add(shortcut);
        return this;
    }

    public ShortcutHelper createShortcut(@NonNull CharSequence shortLabel, @NonNull CharSequence longLabel, @NonNull int iconResource, @NonNull Intent[] intents) {
        String shortcutId = shortLabel.toString().replaceAll("\\s+","").toLowerCase() + "_shortcut";
        ShortcutInfo shortcut = new ShortcutInfo.Builder(mActivity, shortcutId)
                .setShortLabel(shortLabel)
                .setLongLabel(longLabel)
                .setIcon(Icon.createWithResource(mActivity, iconResource))
                .setIntents(intents)
                .build();
        mShortcutInfos.add(shortcut);
        return this;
    }

    public void go() {
        mShortcutManager = mActivity.getSystemService(ShortcutManager.class);
        mShortcutManager.setDynamicShortcuts(mShortcutInfos);
    }

}

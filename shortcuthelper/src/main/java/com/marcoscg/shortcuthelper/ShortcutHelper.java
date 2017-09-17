package com.marcoscg.shortcuthelper;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @MarcosCGdev on 02/05/2017.
 */

public class ShortcutHelper {

    private static Activity mActivity;
    private static ShortcutManager mShortcutManager = null;
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
        if (Build.VERSION.SDK_INT < 25) {
            return this;
        }
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
        if (Build.VERSION.SDK_INT < 25) {
            return this;
        }
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

    public ShortcutHelper createShortcutList(@NonNull List<Shortcut> shortcuts) {
        if (Build.VERSION.SDK_INT < 25) {
            return this;
        }
        mShortcutManager = mActivity.getSystemService(ShortcutManager.class);
        for (int i=0; i<shortcuts.size(); i++) {
            if (i < mShortcutManager.getMaxShortcutCountPerActivity()) {
                String shortcutId = shortcuts.get(i).getShortLabel().replaceAll("\\s+","").toLowerCase() + "_shortcut";
                ShortcutInfo shortcut = new ShortcutInfo.Builder(mActivity, shortcutId)
                        .setShortLabel(shortcuts.get(i).getShortLabel())
                        .setLongLabel(shortcuts.get(i).getLongLabel())
                        .setIcon(Icon.createWithResource(mActivity, shortcuts.get(i).getIconResource()))
                        .setIntent(shortcuts.get(i).getIntent())
                        .build();
                mShortcutInfos.add(shortcut);
            }
        }
        return this;
    }

    public void go() {
        if (Build.VERSION.SDK_INT < 25) {
            return;
        }
        if (mShortcutManager==null)
            mShortcutManager = mActivity.getSystemService(ShortcutManager.class);
        try {
            if (mShortcutInfos!=null && mShortcutInfos.size()>0)
                mShortcutManager.setDynamicShortcuts(mShortcutInfos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
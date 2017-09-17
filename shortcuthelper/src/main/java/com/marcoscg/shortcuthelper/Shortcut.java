package com.marcoscg.shortcuthelper;

import android.content.Intent;

/**
 * Created by @MarcosCGdev on 02/05/2017.
 */

public class Shortcut {
    private String shortLabel, longLabel;
    private int iconResource;
    private Intent intent;
    public Shortcut (String shortLabel, String longLabel, int iconResource, Intent intent) {
        super();
        this.shortLabel = shortLabel;
        this.longLabel = longLabel;
        this.iconResource = iconResource;
        this.intent = intent;
    }
    public void setShortLabel (String shortLabel) {
        this.shortLabel = shortLabel;
    }
    public String getShortLabel() {
        return shortLabel;
    }
    public void setLongLabel (String longLabel) {
        this.longLabel = longLabel;
    }
    public String getLongLabel() {
        return longLabel;
    }
    public void setIconResource (int iconResource) {
        this.iconResource = iconResource;
    }
    public int getIconResource() {
        return iconResource;
    }
    public void setIntent(Intent intent) {
        this.intent = intent;
    }
    public Intent getIntent() {
        return intent;
    }
}
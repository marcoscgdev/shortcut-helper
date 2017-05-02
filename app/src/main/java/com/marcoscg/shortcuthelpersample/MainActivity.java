package com.marcoscg.shortcuthelpersample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.marcoscg.shortcuthelper.ShortcutHelper;

/**
 * Created by @MarcosCGdev on 02/05/2017.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/marcoscgdev/ShortcutHelper"));
        Intent activityIntent = new Intent(Intent.ACTION_MAIN, Uri.EMPTY, this, ShortcutActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        ShortcutHelper.with(this)
                .createShortcut(
                        "Short Label",
                        "Long Label",
                        R.drawable.ic_shortcut_android,
                        webIntent)
                .createShortcut(
                        "Short Label 2",
                        "Long Label 2",
                        R.drawable.ic_shortcut_android,
                        activityIntent)
                .go();

    }
}
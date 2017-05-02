# Shortcut Helper  [![API](https://img.shields.io/badge/API-9%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=9)  [![](https://jitpack.io/v/marcoscgdev/shortcut-helper.svg)](https://jitpack.io/#marcoscgdev/shortcut-helper)
An android library to create the new Android 7.0 shortcuts easily.

---

## Releases:

#### Current release: 1.0.1.

You can see all the library releases [here](https://github.com/marcoscgdev/shortcut-helper/releases).

---

## Screenshots

<img src="https://raw.githubusercontent.com/marcoscgdev/shortcut-helper/master/screenshots/IMG_20170502_122417.jpg" width="350">

---

## Usage:

### Adding the depencency

Add this to your root *build.gradle* file:

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Now add the dependency to your app build.gradle file:

```
compile 'com.github.marcoscgdev:shortcut-helper:1.0.1'
```

### Creating the shortcuts

You can follow this snippet:

```
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
```

---
>See the *sample project* to clarify any queries you may have.

---

## License

```
Copyright 2017 Marcos Calvo García

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

[![AndroidWeekly 555](https://androidweekly.net/issues/issue-555/badge)](https://androidweekly.net/issues/issue-555)
# Splash screen app for Fire TV  

This project is an Android TV app showcasing how to develop a splash screen for Amazon Fire TV apps. Follow the guide and check this repository to develop your custom splash screen.

> **Note:** Fire OS is based on the [Android Open Source project version 11](https://source.android.com/docs/setup/about/android-11-release) so do **not** use [Android 12's SplashScreen APIs](https://developer.android.com/develop/ui/views/launch/splash-screen). Read our docs for an [overview of Fire OS versions here](https://developer.amazon.com/docs/fire-tv/fire-os-overview.html).


## 💻 Building the splash screen for TV apps

1. Clone the demo app repository:
`git clone git@github.com:AmazonAppDev/splash-screen-fire-tv-demo.git`
2. Connect your Fire TV device following these [instructions](https://developer.amazon.com/docs/fire-tv/connecting-adb-to-device.html).
3. Run the demo app [following these docs](https://developer.amazon.com/docs/fire-tv/installing-and-running-your-app.html).

## How to develop a custom splash screen for your Fire TV Apps

**Step 1:** Create your custom splash screen

Create a file named `splashscreen.xml` in the drawable directory. This file will contain all the graphic elements and layers of your splash screen, such as the background color and the main graphic. This file should have the following markup:

```xml
<?xml version="1.0" encoding="utf-8"?>
<layer-list xmlns:android="http://schemas.android.com/apk/res/android" android:opacity="opaque">
    <item>
        <shape android:shape="rectangle">
            <solid android:color="@android:color/white"/>
        </shape>
    </item>

    <item android:drawable="@drawable/splashscreen_logo" android:gravity="center"/>

</layer-list>
```

*Note:* The SVG (Scalable Vector Graphics) image format load faster compared to other image formats when testing on FireTV devices.

**Step 2:** Create the splash screen theme

Define a new style in the file styles.xml of your project then add an android:windowBackground item set as the @drawable/splashscreen splash screen you created in the prior step:

 ```xml
    <style name="SplashScreenTheme" parent="Theme.SplashScreenTV.NoActionBar">
        <item name="android:windowBackground">@drawable/splashscreen</item>
    </style>
```

**Step 3:** Create the splash screen activity

Create a new activity responsible for displaying the splash screen, launch the main activity, then terminate:

```kotlin
class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
```
**Step 4:** Apply the splash screen theme to the splash screen activity

In `AndroidManifest.xml`, set the theme attribute of the `SplashScreenActivity` to the theme you setup in step 2. The `SplashScreenActivity` will be the first activity called by the launcher, so remember to move the intent filter with the action `android.intent.action.MAIN` and category `android.intent.category.LEANBACK_LAUNCHER` from the Main Activity to the `SplashScreenActivity`:

```xml
<activity
    android:name=".SplashScreenActivity"
    android:exported="true"
    android:label="@string/title_activity_splash_screen"
    android:theme="@style/SplashScreenTheme">
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />

        <category android:name="android.intent.category.LEANBACK_LAUNCHER" />
    </intent-filter>
</activity>
```

## Success: Your custom splash screen is now complete!

You have now implemented a custom splash screen and optimized the starting time of your Fire TV app displaying your branding image. To test this for yourself, use the Android Debug Bridge and follow [our docs on installing your app on Fire TV](https://developer.amazon.com/docs/fire-tv/installing-and-running-your-app.html).

## Get support

If you found a bug or want to suggest a new [feature/use case/sample], please [file an issue](../../issues).

If you have questions, comments, or need help with code, we're here to help:
- [Ask questions](https://community.amazondeveloper.com/c/amazon-appstore/appstore-questions/20) in the Amazon developer community space
- Ask questions on Stack Overflow using the [amazon-appstore](https://stackoverflow.com/questions/tagged/amazon-appstore) tag


### Stay updated
Get the most up to date Amazon Appstore developer news, product releases, tutorials, and more:

* 📣 Follow [@AmazonAppDev](https://twitter.com/AmazonAppDev) and [our team](https://twitter.com/i/lists/1580293569897984000) on [Twitter](https://twitter.com/AmazonAppDev)
* 📺 Subscribe to our [Youtube channel](https://www.youtube.com/amazonappstoredevelopers)
* 📧 Sign up for the [Developer Newsletter](https://m.amazonappservices.com/devto-newsletter-subscribe)



## Authors

- [@giolaq](https://twitter.com/giolaq)
- [@chris_trag](https://twitter.com/chris_trag)

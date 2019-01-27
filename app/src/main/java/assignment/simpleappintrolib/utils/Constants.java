package assignment.simpleappintrolib.utils;

import android.content.Context;
import android.content.SharedPreferences;

import assignment.simpleappintrolib.activities.BaseActivity;

public class Constants {

    public static final String SHARED_PREFERENCE_INFO = "prefDetails";
    public static final String IS_APP_LAUNCHED_BEFORE = "isAppLaunchedBefore";

    public static boolean isHomepageRunningFirstTime(BaseActivity baseActivity){

        SharedPreferences sharedPreferences = baseActivity.getSharedPreferences(Constants.SHARED_PREFERENCE_INFO, Context.MODE_PRIVATE);
        boolean isRanBefore = sharedPreferences.getBoolean(Constants.IS_APP_LAUNCHED_BEFORE, false);

        if(!isRanBefore){

            sharedPreferences.edit().putBoolean(IS_APP_LAUNCHED_BEFORE, true).apply();

        }

        return !isRanBefore;
    }
}

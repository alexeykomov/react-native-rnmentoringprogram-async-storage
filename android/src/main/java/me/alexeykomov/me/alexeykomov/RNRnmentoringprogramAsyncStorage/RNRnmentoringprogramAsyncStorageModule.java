
package me.alexeykomov.me.alexeykomov.RNRnmentoringprogramAsyncStorage;

import android.content.Context;
import android.content.SharedPreferences;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

import java.util.ArrayList;
import java.util.List;

import me.alexeykomov.RNRnmentoringprogramAsyncStorage.R;

public class RNRnmentoringprogramAsyncStorageModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;

    private final static String PREFERENCE_FILE_KEY =
            "me.alexeykomov.RNRnmentoringprogramAsyncStorageModule.PREFERENCE_FILE";

    public RNRnmentoringprogramAsyncStorageModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNRnmentoringprogramAsyncStorage";
    }


    public void getItem(String key, Promise result) {
        SharedPreferences sharedPreferences = reactContext.getSharedPreferences(
                PREFERENCE_FILE_KEY,
                Context.MODE_PRIVATE);
        try {
            if (sharedPreferences.contains(key)) {
                result.resolve(sharedPreferences.getString(key, ""));
                return;
            }

            result.resolve(null);
        } catch (Exception e) {
            result.reject(e);
        }
    }

    public void setItem(String key, String value, Promise result) {
        SharedPreferences sharedPreferences = reactContext.getSharedPreferences(
                PREFERENCE_FILE_KEY,
                Context.MODE_PRIVATE);
        try {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(key, value);
            editor.apply();
            result.resolve(true);
        } catch (Exception e) {
            result.reject(e);
        }
    }

    public void getMultipleItems(List<String> keys, Promise result) {
        SharedPreferences sharedPreferences = reactContext.getSharedPreferences(
                PREFERENCE_FILE_KEY,
                Context.MODE_PRIVATE);
        final List<String> values = new ArrayList<String>();
        try {
            for (String key : keys) {
                if (sharedPreferences.contains(key)) {
                    values.add(sharedPreferences.getString(key, ""));
                }

            }
            result.resolve(values);
        } catch (Exception e) {
            result.reject(e);
        }
    }

    public void setMultipleItems(List<String []> keyValuePairs, Promise result) {
        SharedPreferences 
    }

}
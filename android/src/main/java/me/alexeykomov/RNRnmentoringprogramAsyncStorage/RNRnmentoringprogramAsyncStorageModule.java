
package me.alexeykomov.RNRnmentoringprogramAsyncStorage;

import android.content.Context;
import android.content.SharedPreferences;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeArray;

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

    @ReactMethod
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

    @ReactMethod
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

    @ReactMethod
    public void getMultipleItems(ReadableArray keys, Promise result) {
        SharedPreferences sharedPreferences = reactContext.getSharedPreferences(
                PREFERENCE_FILE_KEY,
                Context.MODE_PRIVATE);
        final WritableArray values = new WritableNativeArray();
        try {
            for (int counter = 0; counter < keys.size(); counter++) {
                String key = keys.getString(counter);
                if (sharedPreferences.contains(key)) {
                    values.pushString(sharedPreferences.getString(key, ""));
                }
            }
            result.resolve(values);
        } catch (Exception e) {
            result.reject(e);
        }
    }

    @ReactMethod
    public void setMultipleItems(ReadableArray keyValuePairs, Promise result) {
        SharedPreferences sharedPreferences = reactContext.getSharedPreferences(
                PREFERENCE_FILE_KEY,
                Context.MODE_PRIVATE
        );
        try {
            for (int counter = 0; counter < keyValuePairs.size(); counter++) {
                ReadableArray keyValuePair = keyValuePairs.getArray(counter);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(keyValuePair.getString(0), keyValuePair.getString(1));
                editor.apply();
            }
            result.resolve(true);
        } catch (Exception e) {
            result.reject(e);
        }
    }
}

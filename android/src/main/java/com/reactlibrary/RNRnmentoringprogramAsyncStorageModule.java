
package com.reactlibrary;

import android.content.Context;
import android.content.SharedPreferences;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;

public class RNRnmentoringprogramAsyncStorageModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNRnmentoringprogramAsyncStorageModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNRnmentoringprogramAsyncStorage";
  }


  public void getItem(String key, Promise result){
    Context context = getActivity();
    SharedPreferences sharedPref = context.getSharedPreferences(
        getString(R.string.preference_file_key), Context.MODE_PRIVATE);

    result.resolve(UserDefaults.standard.string(forKey: key))
  }

  public void setItem(_ key: String, value: String,
                     resolve: @escaping RCTPromiseResolveBlock,
                     reject: @escaping RCTPromiseRejectBlock) {
    performInBackground({
        UserDefaults.standard.set(value, forKey: key)
    resolve(true)
        })
  }

  public void setMultipleItems(_ keyValuePairs: [[String]],
                              resolve: @escaping RCTPromiseResolveBlock,
                              reject: @escaping RCTPromiseRejectBlock) {
    performInBackground({
        keyValuePairs.forEach({ keyValuePair in
            UserDefaults.standard.set(keyValuePair[1], forKey: keyValuePair[0])
            })
    resolve(true)
        })
  }

  public void getMultipleItems(_ keys: [String],
                              resolve: @escaping RCTPromiseResolveBlock,
                              reject: @escaping RCTPromiseResolveBlock) {
    performInBackground({
        resolve(keys.map({ key in
            UserDefaults.standard.string(forKey: key)
            }))
        })
  }

}
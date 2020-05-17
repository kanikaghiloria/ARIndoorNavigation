package arnavigation;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class Storage {

    /**
     * Shared Preferences allows us to save and retrieve data in the form of key,value pair.
     */

    private SharedPreferences preferences;

    public Storage(Context appContext) {
        preferences = PreferenceManager.getDefaultSharedPreferences(appContext);
    }

    /**
     * Add ArrayList of String into SharedPreferences with 'key' and save
     *
     * @param key        SharedPreferences key
     * @param stringList ArrayList of String to be added
     */
    public void addListString(String key, ArrayList<String> stringList) {
        if (key == null) {
            throw new NullPointerException();
        } else {
            String[] myStringList = stringList.toArray(new String[stringList.size()]);
            preferences.edit().putString(key, TextUtils.join("‚‗‚", myStringList)).apply();
        }
    }

    /**
     * Get parsed ArrayList of String from SharedPreferences at 'key'
     *
     * @param key SharedPreferences key
     * @return ArrayList of String
     */
    public ArrayList<String> getListString(String key) {
        return new ArrayList<String>(Arrays.asList(TextUtils.split(preferences.getString(key, ""), "‚‗‚")));
    }


}
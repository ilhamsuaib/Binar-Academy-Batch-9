package id.ilhamsuaib.constraintlayout.data

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by @ilhamsuaib on 16/10/18.
 * github.com/ilhamsuaib
 */

class PreferenceHelper(private val context: Context) {

    private val preference: SharedPreferences by lazy {
        context.applicationContext
                .getSharedPreferences("binar-batch-9", Context.MODE_PRIVATE)
    }

    fun putString(key: String, value: String?) {
        val editor = preference.edit()
        editor.putString(key, value).apply()
    }

    fun putBoolean(key: String, value: Boolean) {
        val editor = preference.edit()
        editor.putBoolean(key, value).apply()
    }

    fun getString(key: String): String? = preference.getString(key, null)

    fun getBoolean(key: String): Boolean = preference.getBoolean(key, false)

    fun logOut() {
        val editor = preference.edit()
        editor.clear().apply()
    }
}
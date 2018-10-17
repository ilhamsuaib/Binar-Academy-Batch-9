package id.ilhamsuaib.constraintlayout

import android.content.Context
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by @ilhamsuaib on 16/10/18.
 * github.com/ilhamsuaib
 */

fun <T> Call<T>.request(onError: (t: Throwable) -> Unit = {},
                        onResponse: (response: T?) -> Unit) {
    this.enqueue(object : Callback<T> {
        override fun onFailure(call: Call<T>, t: Throwable) = onError(t)

        override fun onResponse(call: Call<T>, response: Response<T>) = onResponse(response.body())
    })
}

fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
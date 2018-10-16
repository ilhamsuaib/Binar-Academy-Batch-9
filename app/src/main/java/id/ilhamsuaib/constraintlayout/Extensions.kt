package id.ilhamsuaib.constraintlayout

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by @ilhamsuaib on 16/10/18.
 * github.com/ilhamsuaib
 */

fun <T> Call<T>.execute(onError: (t: Throwable) -> Unit, onResponse: (response: T?) -> Unit) {
    this.enqueue(object : Callback<T> {
        override fun onFailure(call: Call<T>, t: Throwable) {
            onError(t)
        }

        override fun onResponse(call: Call<T>, response: Response<T>) {
            onResponse(response.body())
        }
    })
}
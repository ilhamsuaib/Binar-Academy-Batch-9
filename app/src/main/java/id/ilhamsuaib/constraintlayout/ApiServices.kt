package id.ilhamsuaib.constraintlayout

import id.ilhamsuaib.constraintlayout.model.BaseResponse
import id.ilhamsuaib.constraintlayout.model.Student
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by @ilhamsuaib on 16/10/18.
 * github.com/ilhamsuaib
 */

interface ApiServices {

    @GET("api/v1/student/all")
    fun getAllStudents(): Call<BaseResponse<List<Student>>>
}
package id.ilhamsuaib.constraintlayout

import id.ilhamsuaib.constraintlayout.model.BaseResponse
import id.ilhamsuaib.constraintlayout.model.Student
import retrofit2.Call
import retrofit2.http.*

/**
 * Created by @ilhamsuaib on 16/10/18.
 * github.com/ilhamsuaib
 */

interface ApiServices {

    @GET("api/v1/student/all")
    fun getAllStudents(): Call<BaseResponse<List<Student>>>

    @Headers("Content-Type: application/json")
    @POST("api/v1/student/")
    fun saveStudent(@Body map: Map<String, String>): Call<BaseResponse<Student>>

    @GET("api/v1/student/{id}")
    fun getSpecificStudent(@Path("id") studentId: String?): Call<BaseResponse<Student>>

    @DELETE("api/v1/student/{id}")
    fun deleteStudent(@Path("id") id: String?): Call<BaseResponse<Student>>
}
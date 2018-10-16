package id.ilhamsuaib.constraintlayout.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import id.ilhamsuaib.constraintlayout.R

/**
 * Created by @ilhamsuaib on 12/10/18.
 * github.com/ilhamsuaib
 */

@Parcelize
data class Student(
        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("name")
        val name: String? = null,

        @field:SerializedName("email")
        val email: String? = null,

        val imgAvatar: Int? = R.drawable.isyana
) : Parcelable
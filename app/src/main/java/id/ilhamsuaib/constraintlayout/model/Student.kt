package id.ilhamsuaib.constraintlayout.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by @ilhamsuaib on 12/10/18.
 * github.com/ilhamsuaib
 */

@Parcelize
data class Student(
        var id: String? = null,
        var name: String? = null,
        var email: String? = null,
        var imgAvatar: Int? = null
) : Parcelable
package id.ilhamsuaib.constraintlayout.model

import com.google.gson.annotations.SerializedName

/**
 * Created by @ilhamsuaib on 16/10/18.
 * github.com/ilhamsuaib
 */

/*T singkatan dari Type*/

data class BaseResponse<T>(
        @field:SerializedName("status")
        val status: String? = null,

        @field:SerializedName("data")
        val data: T? = null,

        @field:SerializedName("error")
        val error: String? = null
)
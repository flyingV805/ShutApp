package kz.flyingv.shutapp.common.matrix

import android.net.Uri
import org.matrix.android.sdk.api.auth.data.HomeServerConnectionConfig

class HomeServerUtil {

    private var homeServerConnectionConfig: HomeServerConnectionConfig? = null

    fun homeServerConnection(homeServer: String): Boolean {
        return try {
            homeServerConnectionConfig = HomeServerConnectionConfig
                .Builder()
                .withHomeServerUri(Uri.parse(homeServer))
                .build()
            true
        }catch (e: Exception){
            e.printStackTrace()
            false
        }
    }

    val homeServerConnection: HomeServerConnectionConfig? = homeServerConnectionConfig

}
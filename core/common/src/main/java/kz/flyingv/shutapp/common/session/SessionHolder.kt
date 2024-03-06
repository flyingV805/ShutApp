package kz.flyingv.shutapp.common.session

import org.matrix.android.sdk.api.Matrix
import org.matrix.android.sdk.api.session.Session

class SessionHolder(matrix: Matrix) {

    private var currentSession: Session? = null
    val session: Session get() = currentSession!!

    init {
        currentSession = matrix.authenticationService().getLastAuthenticatedSession()
        currentSession?.let { session ->
            session.open()
            session.syncService().startSync(true)
        }
    }

    fun isSessionAvailable(): Boolean {
        return currentSession != null
    }

}
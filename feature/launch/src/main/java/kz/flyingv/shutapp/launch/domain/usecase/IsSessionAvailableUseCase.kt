package kz.flyingv.shutapp.launch.domain.usecase

import kz.flyingv.shutapp.common.session.SessionHolder
import kz.flyingv.shutapp.launch.domain.entity.SessionState
import javax.inject.Inject

class IsSessionAvailableUseCase @Inject constructor(
    private val sessionHolder: SessionHolder
) {

    operator fun invoke(): SessionState {
        return if(sessionHolder.isSessionAvailable())
            SessionState.ActiveSession
        else
            SessionState.NoSession
    }

}
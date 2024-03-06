package kz.flyingv.shutapp.launch.domain.entity

sealed class SessionState {

    data object ActiveSession: SessionState()
    data object NoSession: SessionState()

}
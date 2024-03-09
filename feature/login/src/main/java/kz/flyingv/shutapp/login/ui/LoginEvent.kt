package kz.flyingv.shutapp.login.ui

import kz.flyingv.cleanmvi.UIEvent

sealed class LoginEvent: UIEvent {

    data object AuthorizeOnServer: LoginEvent()

}
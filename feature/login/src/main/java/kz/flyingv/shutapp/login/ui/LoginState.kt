package kz.flyingv.shutapp.login.ui

import kz.flyingv.cleanmvi.UIState

data class LoginState(
    val useMatrixOrg: Boolean = true,
    val useCustomServer: Boolean = false,
    val customServer: String = "matrix."
): UIState
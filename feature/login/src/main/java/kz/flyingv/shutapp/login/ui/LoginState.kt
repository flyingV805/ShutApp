package kz.flyingv.shutapp.login.ui

import kz.flyingv.cleanmvi.UIState
import kz.flyingv.shutapp.login.ui.model.LoginStage

data class LoginState(
    val setupState: LoginStage = LoginStage.Welcome,
    val useMatrixOrg: Boolean = true,
    val useCustomServer: Boolean = false,
    val customServer: String = "matrix.",
    val validating: Boolean = false,
): UIState
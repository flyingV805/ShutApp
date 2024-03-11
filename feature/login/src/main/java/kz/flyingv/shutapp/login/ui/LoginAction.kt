package kz.flyingv.shutapp.login.ui

import kz.flyingv.cleanmvi.UIAction

sealed class LoginAction: UIAction {

    data object WelcomeDone: LoginAction()
    data object ChooseMatrixOrg: LoginAction()
    data object ChooseCustomServer: LoginAction()
    data class UpdateCustomServer(val value: String): LoginAction()
    data object ServerPicked: LoginAction()

}
package kz.flyingv.shutapp.login.ui

import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kz.flyingv.cleanmvi.UIViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): UIViewModel<LoginState, LoginAction, LoginEvent>(LoginState()) {

    init {
        viewModelScope.launch {  }
    }

    override fun reduce(action: LoginAction) {
        super.reduce(action)
        Log.d("reduce", action.toString())
        when(action){
            LoginAction.ChooseCustomServer -> {
                pushState(currentState().copy(useCustomServer = true, useMatrixOrg = false))
            }
            LoginAction.ChooseMatrixOrg -> {
                pushState(currentState().copy(useCustomServer = false, useMatrixOrg = true))
            }
            is LoginAction.UpdateCustomServer -> {
                pushState(currentState().copy(customServer = action.value))
            }
            LoginAction.ServerPicked -> {
                viewModelScope.launch { pushEvent(LoginEvent.AuthorizeOnServer) }
            }
        }
    }

}
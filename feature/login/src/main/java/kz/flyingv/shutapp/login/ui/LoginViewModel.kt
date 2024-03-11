package kz.flyingv.shutapp.login.ui

import android.net.Uri
import android.util.Log
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kz.flyingv.cleanmvi.UIViewModel
import kz.flyingv.shutapp.login.domain.usecase.GetServerUseCase
import kz.flyingv.shutapp.login.ui.model.LoginStage
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val serverUseCase: GetServerUseCase
): UIViewModel<LoginState, LoginAction, LoginEvent>(LoginState()) {

    init {
        viewModelScope.launch {  }
    }

    override fun reduce(action: LoginAction) {
        super.reduce(action)
        Log.d("reduce", action.toString())
        when(action){
            LoginAction.WelcomeDone -> {
                pushState(currentState().copy(setupState = LoginStage.Server))
            }
            LoginAction.ChooseCustomServer -> {
                if(currentState().validating){ return }
                pushState(currentState().copy(useCustomServer = true, useMatrixOrg = false))
            }
            LoginAction.ChooseMatrixOrg -> {
                if(currentState().validating){ return }
                pushState(currentState().copy(useCustomServer = false, useMatrixOrg = true))
            }
            is LoginAction.UpdateCustomServer -> {
                if(currentState().validating){ return }
                pushState(currentState().copy(customServer = action.value))
            }
            LoginAction.ServerPicked -> {
                viewModelScope.launch(Dispatchers.IO){
                    pushState(currentState().copy(validating = true))
                    val homeServerUrl = getServerUri()
                    if(serverUseCase(homeServerUrl)){
                        pushState(currentState().copy(validating = false, setupState = LoginStage.Authorization))
                    }else{
                        pushState(currentState().copy(validating = false))
                        pushEvent(LoginEvent.InvalidServer)
                    }
                    //pushEvent(LoginEvent.AuthorizeOnServer)
                }
            }
        }
    }

    private fun getServerUri(): String {
        val currentState = currentState()
        return when{
            currentState.useMatrixOrg -> "https://matrix.org"
            else -> "https://${currentState.customServer}"
        }
    }

}
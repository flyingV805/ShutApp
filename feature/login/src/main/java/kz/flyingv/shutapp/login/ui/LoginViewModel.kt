package kz.flyingv.shutapp.login.ui

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

}
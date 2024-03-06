package kz.flyingv.shutapp.launch.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kz.flyingv.navigatorapi.Navigator
import kz.flyingv.shutapp.launch.domain.entity.SessionState
import kz.flyingv.shutapp.launch.domain.usecase.IsSessionAvailableUseCase
import javax.inject.Inject

@HiltViewModel
class LaunchViewModel @Inject constructor(
    private val sessionUseCase: IsSessionAvailableUseCase,
    private val navigator: Navigator
): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            val sessionState = sessionUseCase()
            launch(Dispatchers.Main){
                when(sessionState){
                    SessionState.ActiveSession -> navigator.toHome()
                    SessionState.NoSession -> navigator.toLogin()
                }
            }

        }
    }

}
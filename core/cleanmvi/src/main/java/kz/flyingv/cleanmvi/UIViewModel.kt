package kz.flyingv.cleanmvi

import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kz.flyingv.cleanmvi.tools.timemachine.TimeMachine

abstract class UIViewModel<S : UIState, in A : UIAction, E: UIEvent>(
    initialState: S,
    private val timeMachine: TimeMachine<S, A>? = null
): ViewModel() {

    private val _uiState = MutableStateFlow(initialState)
    private val _uiEvent = MutableSharedFlow<E>()

    fun provideState(): StateFlow<S> = _uiState.asStateFlow()
    fun provideEvents(): SharedFlow<E> = _uiEvent.asSharedFlow()

    protected fun currentState(): S = _uiState.value

    protected fun pushState(newState: S){
        timeMachine?.stateEmitted(newState)
        _uiState.update { newState }
        //_uiState.tryEmit(newState)
    }

    protected fun pushEvent(event: E){
        _uiEvent.tryEmit(event)
    }

    @CallSuper
    open fun reduce(action: A){
        timeMachine?.actionMade(action)
    }

}
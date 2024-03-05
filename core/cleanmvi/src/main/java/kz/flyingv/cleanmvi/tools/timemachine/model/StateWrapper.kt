package kz.flyingv.cleanmvi.tools.timemachine.model

import kz.flyingv.cleanmvi.UIState

data class StateWrapper<S : UIState>(
    val timestamp: Long,
    val state: S
)
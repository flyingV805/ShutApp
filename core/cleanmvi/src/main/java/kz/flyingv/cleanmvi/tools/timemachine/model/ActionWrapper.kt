package kz.flyingv.cleanmvi.tools.timemachine.model

import kz.flyingv.cleanmvi.UIAction

data class ActionWrapper<A : UIAction>(
    val timestamp: Long,
    val action: A
)
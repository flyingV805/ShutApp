package kz.flyingv.cleanmvi.tools.timemachine

import kz.flyingv.cleanmvi.UIAction
import kz.flyingv.cleanmvi.UIState
import kz.flyingv.cleanmvi.tools.timemachine.machines.DefaultTimeMachine

class TimeMachineProvider<S : UIState, in A : UIAction> {

    fun default(): TimeMachine<S, A> {
        return DefaultTimeMachine()
    }

}
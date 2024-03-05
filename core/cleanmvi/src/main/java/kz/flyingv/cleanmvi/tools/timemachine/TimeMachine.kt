package kz.flyingv.cleanmvi.tools.timemachine

import kz.flyingv.cleanmvi.UIAction
import kz.flyingv.cleanmvi.UIState

interface TimeMachine<S : UIState, in A : UIAction> {

    fun stateEmitted(state: S)

    fun actionMade(action: A)

    fun rewindFromLast(steps: Int)

}
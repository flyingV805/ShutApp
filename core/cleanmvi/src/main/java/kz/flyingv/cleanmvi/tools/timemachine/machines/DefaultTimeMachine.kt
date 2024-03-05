package kz.flyingv.cleanmvi.tools.timemachine.machines

import kz.flyingv.cleanmvi.UIAction
import kz.flyingv.cleanmvi.UIState
import kz.flyingv.cleanmvi.tools.timemachine.TimeMachine
import kz.flyingv.cleanmvi.tools.timemachine.model.ActionWrapper
import kz.flyingv.cleanmvi.tools.timemachine.model.Common.TIME_MACHINE_CAPACITY
import kz.flyingv.cleanmvi.tools.timemachine.model.StateWrapper


class DefaultTimeMachine<S : UIState, in A : UIAction>: TimeMachine<S, A> {

    private val stateQueue = ArrayDeque<StateWrapper<S>>(TIME_MACHINE_CAPACITY)
    private val actionQueue = ArrayDeque<ActionWrapper<A>>(TIME_MACHINE_CAPACITY)

    override fun stateEmitted(state: S) {
        stateQueue.addLast(
            StateWrapper(
                timestamp = System.currentTimeMillis(),
                state = state
            )
        )
    }

    override fun actionMade(action: A) {
        actionQueue.addLast(
            ActionWrapper(
                timestamp = System.currentTimeMillis(),
                action = action
            )
        )
    }

    override fun rewindFromLast(steps: Int) {
        TODO("Not yet implemented")
    }

}
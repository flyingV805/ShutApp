package kz.flyingv.shutapp.login.domain.usecase

import kz.flyingv.shutapp.common.matrix.HomeServerUtil

class GetServerUseCase (
    private val homeServerUtil: HomeServerUtil
) {

    operator fun invoke(homeServer: String): Boolean {
        return homeServerUtil.homeServerConnection(homeServer)
    }

}
package org.d3if3003.mobpro1.navigation

class Screen {
    sealed class Screen(val route: String) {
        data object Home: Screen ("mainScreen")
        data object About: Screen ("aboutScreen")
    }
}
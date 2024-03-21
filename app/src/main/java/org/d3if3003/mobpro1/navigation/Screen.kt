package org.d3if3003.mobpro1.navigation
// DAVIN WAHYU WARDANA
// 6706223003
// D3IF-4603

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object About: Screen("aboutScreen")
}
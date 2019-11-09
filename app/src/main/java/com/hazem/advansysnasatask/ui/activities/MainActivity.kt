package com.hazem.advansysnasatask.ui.activities

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.hazem.advansysnasatask.R
import com.hazem.advansysnasatask.databinding.ActivityMainBinding
import com.hazem.advansysnasatask.extension.*

class MainActivity : BindingActivity<ActivityMainBinding>() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override val layoutResId: Int
        get() = R.layout.activity_main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val theme = getSavedFromSharedPreference(
            USER_CUREENT_THEME,
            ThemeHelper.lightMode
        )
        ThemeHelper.applyTheme(theme)

        navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(navController.graph, null)


        // Set up ActionBar
        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)

        NavigationUI.setupWithNavController(binding.homeBottomNavigationController, navController)

    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}

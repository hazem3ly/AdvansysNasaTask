package com.hazem.advansysnasatask.ui.fragments.settings

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.hazem.advansysnasatask.R
import com.hazem.advansysnasatask.databinding.SettingsFragmentBinding
import com.hazem.advansysnasatask.extension.*
import kotlinx.android.synthetic.main.settings_fragment.*

class SettingsFragment : BindingFragment<SettingsFragmentBinding>() {
    override val layoutResId: Int
        get() = R.layout.settings_fragment

    private lateinit var viewModel: SettingsViewModel


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SettingsViewModel::class.java)

        binding.changeTheme.setOnClickListener {

            val theme = requireContext().getSavedFromSharedPreference(
                USER_CUREENT_THEME,
                ThemeHelper.lightMode
            )

            when (theme) {
                ThemeHelper.darkMode -> {
                    requireContext().saveToSharedPreference(
                        USER_CUREENT_THEME,
                        ThemeHelper.lightMode
                    )
                    ThemeHelper.applyTheme(ThemeHelper.lightMode)

                }
                ThemeHelper.lightMode -> {
                    requireContext().saveToSharedPreference(
                        USER_CUREENT_THEME,
                        ThemeHelper.darkMode
                    )
                    ThemeHelper.applyTheme(ThemeHelper.darkMode)

                }
            }

        }

    }

}

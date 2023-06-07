package com.studio.noteall.ui.test

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.studio.noteall.R
import com.studio.noteall.databinding.FragmentNotificationsBinding
import com.studio.noteall.databinding.FragmentTestBinding

class NotificationsTest : Fragment() {

    private var _binding: FragmentTestBinding? = null
    private val binding get() = _binding!!
    val viewModel by viewModels<NotificationsTestViewModel>()

    private val nestedNavHostFragment: NavHostFragment?
        get() = childFragmentManager.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTestBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val navView: BottomNavigationView = binding.navView

        nestedNavHostFragment?.navController?.let { navController ->
            with(binding.navView) {
                setupWithNavController(navController)
            }
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.text.observe(viewLifecycleOwner, Observer {
            Log.e("test:", "$it")
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
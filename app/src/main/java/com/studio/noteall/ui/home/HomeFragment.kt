package com.studio.noteall.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.studio.noteall.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel.text.observe(viewLifecycleOwner) {
            Log.e("antx : $it"," $it")
        }
        return root
    }

    override fun onPause() {
        Log.e("onPause: ","onPause $this")

        super.onPause()
    }

    override fun onResume() {
        Log.e("onResume: ","onResume $this")

        super.onResume()
    }

    override fun onDestroyView() {
        Log.e("onDestroyView: ","onDestroyView $this")

        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        Log.e("onDestroy: ","onDestroy $this")
        super.onDestroy()
    }
}
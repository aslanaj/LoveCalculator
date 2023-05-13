package com.example.lovecalculator.ui.loveCalculatorFragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.App
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentLoveCalculatorBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoveCalculatorFragment : Fragment() {

    private lateinit var binding: FragmentLoveCalculatorBinding

    private val viewModel: LoveViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoveCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnCalculate.setOnClickListener {
                viewModel.livelove(etFirstName.text.toString(), etSecondName.text.toString())
                    .observe(viewLifecycleOwner) { loveModel ->
                        lifecycleScope.launch(Dispatchers.IO) {
                            App.appDatabase.loveDao().insert(loveModel)
                        }
                        Log.e("ololo", "initClicker: ${loveModel}")
                        findNavController().navigate(R.id.resultFragment, bundleOf(KYE_FOR_RESULT to loveModel))
                    }
            }
        }
        binding.tvHistory.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }
    }

    companion object {
        const val KYE_FOR_RESULT = "key"
    }

}
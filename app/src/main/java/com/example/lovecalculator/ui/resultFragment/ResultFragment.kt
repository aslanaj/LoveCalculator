package com.example.lovecalculator.ui.resultFragment

import android.os.Bundle
import android.provider.Contacts.SettingsColumns.KEY
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentResultBinding
import com.example.lovecalculator.remote.LoveModel

class ResultFragment : Fragment() {

private lateinit var binding: FragmentResultBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val result = arguments?.getSerializable(KYE_FOR_RESULT) as? LoveModel

        if (result != null){
            binding.apply {
                tvFirstName.text = result.firstName
                tvSecondName.text = result.secondName
                tvPercentage.text = result.percentage
                tvYourScore.text = result.result
            }
        }
        initClicker()

    }

    private fun initClicker() {
        binding.apply {
            btnTryAgain.setOnClickListener {
                findNavController().navigateUp()
            }
            tvHome.setOnClickListener {
                findNavController().navigate(R.id.loveCalculatorFragment)
            }
            tvHistory.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }
        }

    }

    companion object {
        const val KYE_FOR_RESULT = "key"
    }
}
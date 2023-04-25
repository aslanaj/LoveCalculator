package com.example.lovecalculator

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
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

        val result = arguments?.getSerializable("key1") as LoveModel
        binding.apply {
            tvFirstName.text = result.firstName
            tvSecondName.text = result.secondName
            tvScore.text = result.percentage
            tvYourScore.text = result.result
        }
        binding.btnTryAgain.setOnClickListener {
            findNavController().navigateUp()
        }
    }


}
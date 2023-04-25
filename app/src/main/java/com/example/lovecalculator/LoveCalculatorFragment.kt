package com.example.lovecalculator

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.databinding.FragmentLoveCalculatorBinding
import com.example.lovecalculator.remote.LoveModel
import com.example.lovecalculator.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoveCalculatorFragment : Fragment() {

private lateinit var binding: FragmentLoveCalculatorBinding
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
                RetrofitService().api.percentageNames(
                    etFirstName.text.toString(),
                    etSecondName.text.toString()
                ).enqueue(object : Callback<LoveModel> {
                    override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                        Log.e("ololo", "onResponse: ${response.body()}")
                        findNavController().navigate(R.id.resultFragment, bundleOf("key1" to response.body()))
                    }

                    override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                        Log.e("ololo", "onFailure: ${t.message} ")
                    }
                })
            }
        }
    }



}
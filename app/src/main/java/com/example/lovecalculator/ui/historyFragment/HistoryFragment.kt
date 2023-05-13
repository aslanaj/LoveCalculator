package com.example.lovecalculator.ui.historyFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.App
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.FragmentHistoryBinding
import com.example.lovecalculator.remote.LoveModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoryFragment : Fragment() {

private lateinit var binding: FragmentHistoryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch(Dispatchers.IO) {
            // Perform the database query on the background thread
            val list = App.appDatabase.loveDao().getAll()
            withContext(Dispatchers.Main) {
                displayHistory(list)
            }

        }
        initClicker()
    }

    private fun initClicker() {
        binding.apply {
            tvHome.setOnClickListener {
                findNavController().navigate(R.id.loveCalculatorFragment)
            }
            tvHistory.setOnClickListener {
                findNavController().navigate(R.id.historyFragment)
            }
        }
    }

    private fun displayHistory(list: List<LoveModel>) {
        list.forEach {
            val result = "${it.firstName} \n ${it.secondName}\n${it.percentage}\n\n\n"
            binding.textViewHistory.append(result)
        }
    }

}
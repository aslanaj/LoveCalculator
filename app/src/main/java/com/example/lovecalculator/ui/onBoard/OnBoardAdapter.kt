package com.example.lovecalculator.ui.onBoard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecalculator.OnBoard
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ItemOnBoardingBinding
import com.example.lovecalculator.ui.onBoard.OnBoardAdapter.*

class OnBoardAdapter(
    private val onClick: () -> Unit
) : RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder>() {

    private val data = arrayListOf(
        OnBoard(
            R.drawable.on_board,
            "It's Funs and Many More"
        ),
        OnBoard(
            R.drawable.on_board_two,
            "It's Funs and Many More"
        ),
        OnBoard(
            R.drawable.on_board_three,
            "It's Funs and Many More"
        ),
        OnBoard(
            R.drawable.on_board_four,
            "It's Funs and Many More"
        )
    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardViewHolder {
        return OnBoardViewHolder(
            ItemOnBoardingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int = data.size

      override fun onBindViewHolder(holder: OnBoardViewHolder, position: Int) {
        holder.bind(data[position])
    }


    inner class OnBoardViewHolder(private val binding: ItemOnBoardingBinding) :
        ViewHolder(binding.root) {

        fun bind(onBoard: OnBoard) {

            binding.apply {
                onBoard.image?.let { imgBoard.setImageResource(it) }
                tvOnBoard.text = onBoard.title
                btnGetStarted.isVisible = adapterPosition == data.lastIndex
                btnGetStarted.setOnClickListener {
                    onClick()
                }
            }
        }
    }


}
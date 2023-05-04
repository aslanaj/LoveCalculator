package com.example.lovecalculator.ui.onBoard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecalculator.model.OnBoard
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ItemOnBoardingBinding

class OnBoardAdapter(
    private val onClick: () -> Unit
) : RecyclerView.Adapter<OnBoardAdapter.OnBoardViewHolder>() {

    private val data = arrayListOf(
        OnBoard(
            R.drawable.on_board_two,
            "Have a good time",
            "You should take the time to help those who need you"

        ),
        OnBoard(
            R.drawable.on_board_three,
            "Cherishing love",
            "It is now no longer possible for you to cherish love"

        ),
        OnBoard(
            R.drawable.on_board_four,
            "Have a break up?",
            "We have made the correction for you don't worry /n Maybe someone is waiting for you "
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
                imgBoard.setImageResource(onBoard.image!!)
                tvTitle.text = onBoard.title
                tvDesc.text = onBoard.desc
                btnGetStarted.isVisible = adapterPosition == 3
                btnGetStarted.setOnClickListener {
                    onClick()
                }
            }
        }
    }
}
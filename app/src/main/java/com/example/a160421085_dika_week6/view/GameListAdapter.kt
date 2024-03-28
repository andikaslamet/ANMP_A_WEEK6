package com.example.a160421085_dika_week6.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a160421085_dika_week6.databinding.GameListItemBinding
import com.example.a160421085_dika_week6.model.Game

class GameListAdapter(val gameList: ArrayList<Game>)
    :RecyclerView.Adapter<GameListAdapter.GameViewHolder>()
{
    class GameViewHolder( var binding: GameListItemBinding)
        :RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding = GameListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return GameViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return gameList.size
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.binding.textView6.text = gameList[position].id
        holder.binding.textView3.text = gameList[position].title
        holder.binding.textView4.text = gameList[position].genre
        holder.binding.textView5.text = gameList[position].platforms.toString()
        holder.binding.textView7.text = gameList[position].developer.toString()
    }
    fun updateGameList(newGameList: ArrayList<Game>) {
        gameList.clear()
        gameList.addAll(newGameList)
        notifyDataSetChanged()
    }
}
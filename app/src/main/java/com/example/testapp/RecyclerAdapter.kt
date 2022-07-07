package com.example.testapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.databinding.ListPetsItemsBinding

class RecyclerAdapter(private var context : Context, private var petsList: ArrayList<Pet>) : RecyclerView.Adapter<RecyclerAdapter.PetsViewHolder>() {
    private lateinit var mListner : View.OnClickListener




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetsViewHolder {
        val binding = ListPetsItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PetsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PetsViewHolder, position: Int) {
        with(holder){
            with(petsList[position]){
                binding.tvSpecies.text = this.species
                binding.tvRace.text = this.race
                binding.tvAge.text = this.age.toString()
            }
        }

        val pet = petsList[position]
        holder.binding.root.setOnClickListener{
            val intent = Intent(context,DetailsActivity::class.java)
            intent.putExtra(Constants.NAME, pet.name)
            intent.putExtra(Constants.AGE, pet.age)
            intent.putExtra(Constants.SPICES, pet.species)
            intent.putExtra(Constants.RACE, pet.race)
            intent.putExtra(Constants.PICTURE, pet.picture)
            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return petsList.size
    }

    inner class PetsViewHolder(val binding: ListPetsItemsBinding) : RecyclerView.ViewHolder(binding.root)


}
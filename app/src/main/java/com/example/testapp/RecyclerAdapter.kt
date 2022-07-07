package com.example.testapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapp.databinding.ListCommentsItemsBinding
import com.example.testapp.databinding.ListPetsItemsBinding
import com.example.testapp.model.Comments
import com.example.testapp.model.Pet

class RecyclerAdapter(private var context : Context, private var commentsList: List<Comments>) : RecyclerView.Adapter<RecyclerAdapter.CommentsViewHolder>() {
    private lateinit var mListner : View.OnClickListener




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val binding = ListCommentsItemsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CommentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        with(holder){
            with(commentsList[position]){
                binding.tvPostId.text = this.postId.toString()
                binding.tvEmail.text = this.email
                binding.tvName.text = this.name

            }
        }

//        val pet = commentsList[position]
//        holder.binding.root.setOnClickListener{
//            val intent = Intent(context,DetailsActivity::class.java)
//            intent.putExtra(Constants.NAME, pet.name)
//            intent.putExtra(Constants.AGE, pet.age)
//            intent.putExtra(Constants.SPICES, pet.species)
//            intent.putExtra(Constants.RACE, pet.race)
//            intent.putExtra(Constants.PICTURE, pet.picture)
//            context.startActivity(intent)
//        }


    }

    override fun getItemCount(): Int {
        return commentsList.size
    }

    inner class CommentsViewHolder(val binding: ListCommentsItemsBinding) : RecyclerView.ViewHolder(binding.root)


}
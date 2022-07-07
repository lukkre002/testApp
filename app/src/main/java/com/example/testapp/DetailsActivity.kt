package com.example.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testapp.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var detailsBinding = ActivityDetailsBinding.inflate(layoutInflater)
        val picture = intent.getIntExtra(Constants.PICTURE,0)
        val age = intent.getIntExtra(Constants.AGE,0)
        val name =  intent.getStringExtra(Constants.NAME)
        val race = intent.getStringExtra(Constants.RACE)
        val spices = intent.getStringExtra(Constants.SPICES)
        detailsBinding.ivPetphoto.setImageResource(picture)
        detailsBinding.tvDname.text = name
        detailsBinding.tvDage.text = age.toString()
        detailsBinding.tvDspice.text = spices
        detailsBinding.tvDrace.text = race
        setContentView(detailsBinding.root)

    }
}
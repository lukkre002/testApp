package com.example.testapp

import com.example.testapp.model.Pet

object Constants {
    const val SPICES : String= "species"
    const val RACE : String = "race"
    const val NAME : String = "name"
    const val AGE : String = "age"
    const val PICTURE : String = "picture"
    const val BASE_URL : String = "https://jsonplaceholder.typicode.com/"

    fun createPets() : ArrayList<Pet>{


        val petList = ArrayList<Pet>()
        val pet1 = Pet(1, "Pies","Labrador","Wabik",2, R.drawable.ic_labrador)
        val pet2 = Pet(2, "Kot", "Syberyjski", "Zima",1, R.drawable.ic_syberyjski)


        petList.add(pet1)
        petList.add(pet2)

        return petList

    }
}
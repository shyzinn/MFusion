package com.gds20052.mfusion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), CustomAdapter.OnItemClickListener {

//    Method to get the array of images

    private val img = arrayListOf(R.drawable.food2, R.drawable.food3,

        R.drawable.food4, R.drawable.food5)


    //    Text description of image
    private val texts = arrayOf("Sweet and Sour Pork","Kung Pao Chicken","Spring Roll","Fried Rice with Egg","Ma Po Tofu")

//    Description of food

    private val desc = arrayOf("Called “咕嚕肉” or “goo lou yok” in Cantonese dialect, this recipe" +
            " is very pleasing to the palate because of the flavorsome sweet and sour sauce",
        "The perfect time to prepare your sauce is while your chicken is marinating. Having " +
                "everything ready before you start a stir fry is essential — and the sauce is " +
                "the most important part! Well, besides the chicken.",
        "Spring Rolls are the vegetarian super light, crispy and tender vegetarian appetizer cousin of" +
                " the traditional egg roll.","Fried rice is a dish of cooked rice that has been " +
                "stir-fried in a wok or a frying pan and is usually mixed with other ingredients " +
                "such as eggs, vegetables, seafood","It consists of tofu set in a spicy sauce, " +
                "typically a thin, oily, and bright red suspension, based on douban (fermented " +
                "broad bean and chili paste) and douchi (fermented black beans), along with minced" +
                "meat, traditionally beef."
    )


    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item ${position+1} clicked", Toast.LENGTH_SHORT).show()
    }

    // Method to call
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CustomAdapter(img, texts, desc,this)
    }
}
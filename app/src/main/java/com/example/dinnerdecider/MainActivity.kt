package com.example.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_list.*

class MainActivity : AppCompatActivity() {

    val foodList = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        decideBtn.setOnClickListener {
            if (foodList.isEmpty()){
                println("empty")
            }else{
                val random = java.util.Random()
                val randomFood = random.nextInt(foodList.count())
                selectedFoodText.text = foodList[randomFood]
            }
        }

        addFoodBtn.setOnClickListener {
            val newFood = addFoodText.text.toString()
            if (newFood.isEmpty()){
                println("type something")

            }else{
                foodList.add(newFood)
                addFoodText.text.clear()


            }
        }
        fun showList() {
            ListDialog().show(supportFragmentManager, "dialog")
        }

        showListBtn.setOnClickListener {
            if(foodList.isEmpty()){
                println("empty list")
            }else{
                showList()
            }
        }



    }
}
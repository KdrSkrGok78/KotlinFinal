package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var diceImage : ImageView
    lateinit var description : TextView
    lateinit var result : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.text = getString(R.string.let_roll)


        rollButton.setOnClickListener {
            rollDice()
            showResult()

        }
        diceImage=findViewById(R.id.dice_image)
        description=findViewById(R.id.description)
        result = findViewById(R.id.result)
    }

    private fun rollDice(){
        val randomInt = Random().nextInt(6)+1
        val drawableResource = when (randomInt){
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)
    }
    private fun showResult(){
        val randomInt2 = Random().nextInt(10)+1
        val whichText = when(randomInt2){
            1-> ("Barış Özcan'ı izlemek için vaktin vardır belki ?")
            2->("Evrim ağacında makale okuyabilirsin.")
            3->("https://www.instructables.com/'da kendin yap işleri ile zaman geçir.")
            4-> ("https://tastedive.com/'da sevdiğin dizi ve filmlere göre yeni şeyler bul.")
            5-> ("http://hubski.com/'da bayağı tartışma var katılabilirsin belki.")
            6-> ("En yakın arkadaşın bu aralar nasıl acaba ?")
            7-> ("http://radio.garden/'da dünyanın her yerinden radyo dinleyebilirsin.")
            8-> ("Ders çalışsan iyi gibi.")
            else-> ("Bu çıktıysa en iyisi biraz koşuya çık.")
        }
        result.setText(whichText)
    }
}
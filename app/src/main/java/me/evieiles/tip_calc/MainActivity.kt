package me.evieiles.tip_calc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import me.evieiles.tip_calc.databinding.ActivityMainBinding
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding //Binds the UI to the Activity_Main.xml file
    private var tipPercent=.15

    override fun onCreate(savedInstanceState: Bundle?) { //Starts background processes
        super.onCreate(savedInstanceState) //Tells it to start UI
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) //Sets the content view to the binding

        //Declare program variables here




        //Event Listeners

        binding.increaseTip.setOnClickListener{ //tells the app what to do when the button is selected.
            tipPercent = tipPercent + .01
            displayPercent()

        }

        binding.decreaseTip.setOnClickListener{
            tipPercent=tipPercent - .01
            displayPercent()
        }

    }

    //Function Area

    private fun displayPercent() {
        val percentFormat = NumberFormat.getPercentInstance()
        val symbol = DecimalFormatSymbols()
        symbol.percent = ' ' //sets the symbol for percent to a blank space
        (percentFormat as DecimalFormat).decimalFormatSymbols = symbol // sets the percent format as a decimal format
        binding.tipPercentEditText.setText(percentFormat.format(tipPercent)) //Converts percent to a whole value
    }

    fun downBtn(btn: View){
        tipPercent = tipPercent - .01
        binding.tipPercentEditText.setText((tipPercent * 100).toString()) //Converts answer to string and displays it in the text field.

    }

}
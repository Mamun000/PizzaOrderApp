package com.example.myapplication2

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        // Get references to the UI elements
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val checkBoxCheese = findViewById<CheckBox>(R.id.checkBoxCheese)
        val checkBoxPepperoni = findViewById<CheckBox>(R.id.checkBoxPepperoni)
        val checkBoxMushrooms = findViewById<CheckBox>(R.id.checkBoxMushrooms)
        val checkBoxOlives = findViewById<CheckBox>(R.id.checkBoxOlives)
        val orderButton = findViewById<Button>(R.id.button2)
        val textViewTotal = findViewById<TextView>(R.id.textViewTotal)

        // Set the click listener for the Order button
        orderButton.setOnClickListener {
            // Get the selected pizza type
            val selectedPizzaId = radioGroup.checkedRadioButtonId
            val selectedPizza = findViewById<RadioButton>(selectedPizzaId)?.text.toString()

            // Pizza prices
            val pizzaPrices = mapOf(
                "Margherita                  ₹240" to 240,
                "New York Style          ₹250" to 250,
                "Chicago                       ₹260" to 260,
                "St Louis-Style            ₹290" to 290
            )

            // Get the base price of the selected pizza
            val basePrice = pizzaPrices[selectedPizza] ?: 0

            // Topping prices
            val toppingPrice = 40

            // Get the selected toppings
            val selectedToppings = mutableListOf<String>()
            var toppingTotal = 0

            if (checkBoxCheese.isChecked) {
                selectedToppings.add("Extra Cheese")
                toppingTotal += toppingPrice
            }
            if (checkBoxPepperoni.isChecked) {
                selectedToppings.add("Pepperoni")
                toppingTotal += toppingPrice
            }
            if (checkBoxMushrooms.isChecked) {
                selectedToppings.add("Mushrooms")
                toppingTotal += toppingPrice
            }
            if (checkBoxOlives.isChecked) {
                selectedToppings.add("Olives")
                toppingTotal += toppingPrice
            }

            // Calculate the total price
            val totalPrice = basePrice + toppingTotal

            // Create the message for the toast
            val message = if (selectedToppings.isNotEmpty()) {
                "Pizza: $selectedPizza\nToppings: ${selectedToppings.joinToString(", ")}\nTotal: ₹$totalPrice"
            } else {
                "Pizza: $selectedPizza\nNo toppings selected\nTotal: ₹$totalPrice"
            }

            // Show the toast message
            Toast.makeText(this@MainActivity3, message, Toast.LENGTH_SHORT).show()

            // Update the total price in the TextView
            textViewTotal.text = "Total: ₹$totalPrice"


        }
    }
}

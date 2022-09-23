package com.example.wishlist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        val itemsRv = findViewById<RecyclerView>(R.id.wishlistRv)

        // Create adapter
        val adapter = ItemAdapter()

        // Attach the adapter to the RecyclerView to populate items
        itemsRv.adapter = adapter

        // Set layout manager to position the items
        itemsRv.layoutManager = LinearLayoutManager(this)

        // Handle Submit Button
        val submitButton = findViewById<Button>(R.id.btn_submit)


        submitButton.setOnClickListener{
            // Retrieve value from EditText
            val itemEditText = findViewById<EditText>(R.id.et_item)
            val priceEditText = findViewById<EditText>(R.id.et_price)
            val urlEditText = findViewById<EditText>(R.id.et_url)

            val strName = itemEditText.text.toString()
            val strPrice = priceEditText.text.toString().toDouble()
            val strUrl = urlEditText.text.toString()

            ItemFetcher.setItems(Item(strName, strPrice, strUrl))
            adapter.notifyDataSetChanged()

            // Clear text
            itemEditText.text.clear()
            priceEditText.text.clear()
            urlEditText.text.clear()

            // https://stackoverflow.com/questions/1109022/how-to-close-hide-the-android-soft-keyboard-programmatically

            // Only runs if there is a view that is currently focused
            this.currentFocus?.let { view ->
                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
                imm?.hideSoftInputFromWindow(view.windowToken, 0)
            }
            itemEditText.requestFocus()


        }



    }
}
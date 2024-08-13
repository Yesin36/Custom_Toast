package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.emreesen.sntoast.SnToast
import com.emreesen.sntoast.Type
import com.shashank.sony.fancytoastlib.FancyToast


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val toastButton = findViewById<Button>(R.id.toast)
        val fancy1 = findViewById<Button>(R.id.fancy1)
        val fancy2 = findViewById<Button>(R.id.fancy2)
        val custom = findViewById<Button>(R.id.custom)
        val custom1 = findViewById<Button>(R.id.custom1)

        toastButton.setOnClickListener{
            Toast.makeText(this, "This is Toast 💕", Toast.LENGTH_SHORT).show()
        }

       // fency toast
        fancy1.setOnClickListener {
            FancyToast.makeText(this,"This is defalut ",FancyToast.LENGTH_LONG,FancyToast.DEFAULT,true).show()
        }
        fancy2.setOnClickListener {
            FancyToast.makeText(this,"Success !",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,false).show()
        }

        // custom toast

        custom.setOnClickListener{
            SnToast.Builder()
                .context(this@MainActivity)
                .type(Type.SUCCESS)
                .message("Success !") //.cancelable(false or true) Optional Default: False
                // .iconSize(int size) Optional Default: 34dp
                // .textSize(int size) Optional Default 18sp
                // .animation(false or true) Optional Default: True
                // .duration(int ms) Optional Default: 3000ms
                // .backgroundColor(R.color.example) Default: It is filled according to the toast type. If an assignment is made, the assigned value is used
                // .icon(R.drawable.example) Default: It is filled according to the toast type. If an assignment is made, the assigned value is used
                .build()
        }

        custom1.setOnClickListener{

            SnToast.Builder()
                .type(Type.SUCCESS)
                .context(this@MainActivity)
                .message("Yesin")
                .cancelable(false) // Optional Default: False
                .textSize(18) // Optional Default 18sp
                .animation(true) // Optional Default: True
                .duration(3000) // Optional Default: 3000ms
                .backgroundColor(R.color.blue) // Ensure R.color.blue is defined in colors.xml
                .build()


        }



        
    }
}
package com.example.meuprimeiroprojeto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)


        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResut = findViewById<TextView>(R.id.textview_Result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_Classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResut.text = String.format("%.1f", result)

        val classificacao = if (result < 18.5)
            (String.format ("ABAIXO DO PESO", result))
        else if (result in 18.5..24.9)
            (String.format("NORMAL", result))
        else if (result in 25.0..29.9)
            (String.format("SOBREPESO", result))
        else if (result >= 30.0 && result <= 39.9)
            (String.format("OBESIDADE", result))
        else
            (String.format("OBESIDADE GRAVE", result))


            tvClassificacao.text = classificacao

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }


}
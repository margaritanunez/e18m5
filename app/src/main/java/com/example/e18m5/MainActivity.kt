package com.example.e18m5

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e18m5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var mSharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mSharedPreferences = getSharedPreferences("dominar el mundo", Context.MODE_PRIVATE)

        binding.guardarbtn.setOnClickListener{
            var texto = binding.textotxt.text.toString()
            var entero = binding.enterotxt.text.toString().toInt()
            var decimal = binding.decimaltxt.text.toString().toFloat()
            var switch = binding.switch1.isChecked

            guardarDatos(texto, entero, decimal, switch)

        }

        binding.showbtn.setOnClickListener{
            mostrarDatos()
        }

        binding.borrarbtn.setOnClickListener{
            borrarDatos()
        }

    }

    private fun borrarDatos() {
        binding.textotv.text = ""
        binding.enterotv.text = ""
        binding.decimaltv.text = ""
        binding.switchtv.text = ""
        binding.textotxt.text.clear()
        binding.enterotxt.text.clear()
        binding.decimaltxt.text.clear()
        binding.switch1.isChecked = false
        mSharedPreferences.edit().clear().apply()
    }

    private fun mostrarDatos() {
        var texto = mSharedPreferences.getString("Soy un texto", "")
        var entero = mSharedPreferences.getInt("Soy un entero", 0)
        var decimal = mSharedPreferences.getFloat("Soy un decimal", 0.0F)
        var switch = mSharedPreferences.getBoolean("Soy un switch", false)

        binding.textotv.text = texto
        binding.enterotv.text= entero.toString()
        binding.decimaltv.text = decimal.toString()
        binding.switchtv.text =switch.toString()
        binding.switch1.isChecked = switch

    }

    private fun guardarDatos(texto: String, entero: Int, decimal: Float, switch: Boolean){
        mSharedPreferences.edit().putString("soy un texto", texto).apply()
        mSharedPreferences.edit().putInt("soy un entero", entero).apply()
        mSharedPreferences.edit().putFloat("soy un decimal", decimal).apply()
        mSharedPreferences.edit().putBoolean("soy un switch", switch).apply()


    }


}
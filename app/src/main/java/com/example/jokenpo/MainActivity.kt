package com.example.jokenpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageButton
import com.example.jokenpo.databinding.ActivityMainBinding
import java.lang.Math.random

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var pontuaJogador : Int = 0
    private var pontuaCPU : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        //setContentView(R.layout.activity_main)

        startUp()
    }

    //Starting up all Buttons
    private fun startUp() {
        binding.pedraImage.setOnClickListener(this)
        binding.tesouraImage.setOnClickListener(this)
        binding.papelImage.setOnClickListener(this)
        binding.novaPartida.setOnClickListener(this)
    }

    override fun onClick(botao: View) {
        when (botao.id) {
            binding.pedraImage.id -> jogo("Pedra")
            binding.tesouraImage.id -> jogo("Tesoura")
            binding.papelImage.id -> jogo("Papel")
            binding.novaPartida.id -> novaPartida()
        }
    }

    private fun atualiza(){
        binding.pontosJogador.text = pontuaJogador.toString()
        binding.pontosCpu.text = pontuaCPU.toString()
    }

    private fun jogo(selecao : String){

        var maquina = escolhaCpu()

        binding.escolha.text = selecao
        binding.cpuEscolha.text = maquina

        if (maquina == selecao){
            pontuaJogador++
            pontuaCPU++
            atualiza()
        }else if (maquina == "Pedra" && selecao == "Tesoura" || maquina == "Tesoura" && selecao == "Papel" || maquina == "Papel" && selecao == "Pedra"){
            pontuaCPU++
            atualiza()
        }else{
            pontuaJogador++
            atualiza()
        }

    }

    private fun escolhaCpu() : String{
        val numero = (0..1).random()
        if (numero == 0){
            return "Pedra"
        }else if (numero == 1){
            return "Tesoura"
        }
        return "Papel"
    }

    private fun novaPartida(){
        pontuaCPU = 0
        pontuaJogador = 0
        atualiza()
    }


}
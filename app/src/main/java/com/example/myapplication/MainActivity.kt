package com.example.myapplication

import android.R.attr.duration
import android.R.id.message
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())
        binding.bottomBar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home->replaceFragment(HomeFragment())
                R.id.profile->replaceFragment(ProfileFragment())
                R.id.settings->replaceFragment(SettingFragment())
                else->{
                    val toast = Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT)
                    toast.show()
                }
            }
             true

        }

    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager=supportFragmentManager
        val trans=fragmentManager.beginTransaction()
        trans.replace(R.id.mainLayout,fragment)
        trans.commit()
    }
}
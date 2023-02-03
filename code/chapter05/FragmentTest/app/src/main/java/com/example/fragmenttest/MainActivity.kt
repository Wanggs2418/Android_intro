package com.example.fragmenttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fragmenttest.databinding.ActivityMainBinding
import com.example.fragmenttest.databinding.LeftFragmentBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val button:Button = findViewById(R.id.button)
        button.setOnClickListener {
            replaceFragment(AnotherRightFragment())
        }
//        val bindingleft = LeftFragmentBinding.inflate(layoutInflater)
//        setContentView(bindingleft.root)
//        bindingleft.button.setOnClickListener{
//            replaceFragment(AnotherRightFragment())
//        }
        replaceFragment(RightFragment())
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.rightLayout, fragment)
//        返回栈
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
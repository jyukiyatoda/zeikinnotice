package com.example.zeikinnotice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val zeikin=intent.getStringExtra("Zeikin")
        val date=intent.getStringExtra("Date")
        val kingaku=intent.getStringExtra("Nouhugaku")
        val memo=intent.getStringExtra("Memo")

        val subZeikin=findViewById<TextView>(R.id.subzeikin)
        val subDate=findViewById<TextView>(R.id.subdate)
        val subNouhugaku=findViewById<TextView>(R.id.subnouhugaku)
        val subMemo=findViewById<TextView>(R.id.submemo)

        subZeikin.text=zeikin
        subDate.text=date
        subNouhugaku.text=kingaku
        subMemo.text=memo
    }
    fun onBackButtonClick(view: View?){
        finish()
    }
}

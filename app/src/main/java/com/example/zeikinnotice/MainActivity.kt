package com.example.zeikinnotice

import android.app.DatePickerDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import layout.DatePick
import java.util.Locale

class MainActivity : FragmentActivity(),DatePickerDialog.OnDateSetListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //登録ボタンを押してページ移動
        val btClick =findViewById<Button>(R.id.touroku)
        val listener=ClickListener()
        btClick.setOnClickListener(listener)

    }

    //日付の取得Calender
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        val  str=String.format(Locale.US,"%d%d%d",year,month+1,dayOfMonth)
        date.text=str
    }
    fun showDatePickerDialog(v:View){
        val newFragment=DatePick()
        newFragment.show(supportFragmentManager,"datePicker")
    }


    private inner class ClickListener:View.OnClickListener{
        override fun onClick(v: View?) {
            val editDate=findViewById<TextView>(R.id.date)
            val editMemoform=findViewById<EditText>(R.id.memoform)

            val rg_zeikin:RadioGroup
            val rb_zyuminzei:RadioButton
            val rb_koteizei:RadioButton
            val rb_keizei:RadioButton
            val rb_hokenzei:RadioButton
            val rb_zyuhokenzei:RadioButton
            var index=""

            rg_zeikin=findViewById(R.id.radioGroup)
            rb_zyuminzei=findViewById(R.id.zyuminzei)
            rb_koteizei=findViewById(R.id.koteizei)
            rb_keizei=findViewById(R.id.keizei)
            rb_hokenzei=findViewById(R.id.hokenzei)
            rb_zyuhokenzei=findViewById(R.id.zyuhokenzei)

            if(rg_zeikin.checkedRadioButtonId !=-1){
                if(rb_zyuminzei.isChecked)
                    index="住民税"
                else if(rb_koteizei.isChecked)
                    index="固定資産税"
                else if (rb_keizei.isChecked)
                    index="軽自動車税"
                else if (rb_hokenzei.isChecked)
                    index="国民健康保険税"
                else if (rb_zyuhokenzei.isChecked)
                    index="住民税・国民健康保険税"
            }
            //SubActivityに値を渡す
         val intent= Intent(applicationContext,SubActivity::class.java)
            intent.putExtra("Zeikin",index.toString())
            intent.putExtra("Date",editDate.text.toString())
            intent.putExtra("Memo",editMemoform.text.toString())
            startActivity(intent)
        }
    }
}

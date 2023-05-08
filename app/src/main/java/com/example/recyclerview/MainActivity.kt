package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv: RecyclerView = findViewById(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)

        val names = listOf("Seattle", "Atlanta", "Los Angeles", "Baltimore", "NYC",
                            "Dallas", "Houston","Denver")
        rv.adapter = MyAdapter(names)
    }

    class MyAdapter(val data: List<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
        class MyViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
            val textView = row.findViewById<TextView>(R.id.number)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_view,
                parent, false)
            return MyViewHolder(layout)
        }
        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            holder.textView.text = data.get(position).toString()
        }
        override fun getItemCount(): Int = data.size
}
}



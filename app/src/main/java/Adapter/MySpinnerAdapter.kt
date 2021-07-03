package Adapter

import Models.User
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.todolist.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_about_list_to_do.view.*
import kotlinx.android.synthetic.main.item_spinner.view.*

class MySpinnerAdapter(var list: List<User>) : BaseAdapter() {
    override fun getCount(): Int = list.size

    override fun getItem(position: Int): User {
        return list[position]
    }

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val itemView: View

        if (convertView == null) {
            itemView =
                LayoutInflater.from(parent?.context).inflate(R.layout.item_spinner, parent, false)
        } else {
            itemView = convertView
        }


        itemView.txt_name_spinner.text = list[position].name
        if (list[position].img != -1)
            itemView.img_item.setImageResource(list[position].img)

        return itemView
    }

}
package com.example.mycontact.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycontact.R
import kotlinx.android.synthetic.main.contact_item.view.*

data class Contact (val name:String,val phone:String,val email: String,val group:String)

object ContactModel{

    private val list = mutableListOf<Contact>()
    val contact:List<Contact>
    get() = list
    fun add(c:Contact) = list.add(c)
}

class ContactViewHolder(v:View): RecyclerView.ViewHolder(v)

class ContactAdapter(val ctx:Context): RecyclerView.Adapter<ContactViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
            LayoutInflater.from(ctx).inflate(R.layout.contact_item,parent,false).let {
                ContactViewHolder(it)
            }

    override fun getItemCount() = ContactModel.contact.size

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.itemView.outName.text = ContactModel.contact[position].name
        holder.itemView.outGroup.text = ContactModel.contact[position].group
        holder.itemView.outPhone.text = ContactModel.contact[position].phone
        holder.itemView.outEmail.text = ContactModel.contact[position].email
    }
}
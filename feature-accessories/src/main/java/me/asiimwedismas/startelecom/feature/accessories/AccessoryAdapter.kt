package me.asiimwedismas.startelecom.feature.accessories

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import me.asiimwedismas.startelecom.core.model.Accessory

class AccessoryAdapter(private val onClick: (Accessory) -> Unit) :
    ListAdapter<Accessory, AccessoryAdapter.ViewHolder>(DiffCallBack) {

    class ViewHolder(itemView: View, val onClick: (Accessory) -> Unit, val context: Context) :
        RecyclerView.ViewHolder(itemView) {
        private var accessory: Accessory? = null
        private val name: TextView = itemView.findViewById(R.id.txt_accessory_name)
        private val stockBalance: TextView = itemView.findViewById(R.id.txt_accessory_stock_balance)

        init {
            itemView.setOnClickListener {
                accessory?.let { onClick(it) }
            }
        }

        fun bind(accessory: Accessory) {
            this.accessory = accessory
            this.accessory?.let {
                name.text = it.name
                stockBalance.text = it.stock_balance.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.accessory_list_item, parent, false)
        return ViewHolder(view, onClick, parent.context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object DiffCallBack : DiffUtil.ItemCallback<Accessory>() {
        override fun areItemsTheSame(oldItem: Accessory, newItem: Accessory): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Accessory, newItem: Accessory): Boolean {
            return oldItem == newItem
        }
    }
}
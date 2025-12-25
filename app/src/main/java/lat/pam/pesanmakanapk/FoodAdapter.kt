package lat.pam.pesanmakanapk

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Food(val name: String, val desc: String, val imageRes: Int)

class FoodAdapter(private val foodList: List<Food>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivFood: ImageView = view.findViewById(R.id.ivFood)
        val tvName: TextView = view.findViewById(R.id.tvFoodName)
        val tvDesc: TextView = view.findViewById(R.id.tvFoodDesc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.tvName.text = food.name
        holder.tvDesc.text = food.desc
        holder.ivFood.setImageResource(food.imageRes)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java)

            intent.putExtra("FOOD_NAME", food.name)
            intent.putExtra("FOOD_DESC", food.desc)
            intent.putExtra("FOOD_IMAGE", food.imageRes)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = foodList.size
}

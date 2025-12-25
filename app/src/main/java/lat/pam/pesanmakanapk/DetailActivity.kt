package lat.pam.pesanmakanapk

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val foodName = intent.getStringExtra("FOOD_NAME")
        val foodDesc = intent.getStringExtra("FOOD_DESC")
        val foodImage = intent.getIntExtra("FOOD_IMAGE", 0)

        val tvName = findViewById<TextView>(R.id.tvDetailName)
        val tvDesc = findViewById<TextView>(R.id.tvDetailDesc)
        val ivImage = findViewById<ImageView>(R.id.ivDetailFood)
        val btnOrder = findViewById<Button>(R.id.btnOrderNow)

        tvName.text = foodName
        tvDesc.text = foodDesc
        ivImage.setImageResource(foodImage)

        btnOrder.setOnClickListener {
            val intent = Intent(this, AddressActivity::class.java)
            startActivity(intent)
        }
    }
}

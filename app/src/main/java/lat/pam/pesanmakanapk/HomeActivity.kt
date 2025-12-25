package lat.pam.pesanmakanapk

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvFood = findViewById<RecyclerView>(R.id.rvFood)


        // Memasukkan 10 data makanan beserta fotonya
        val dataFood = listOf(
            Food("Cireng Bandung", "Cireng goreng renyah.", R.drawable.makanan1),
            Food("Batagor Bandung", "Bakso tahu goreng saus kacang.", R.drawable.makanan2),
            Food("Mie Kocok", "Mie khas Bandung dengan kikil sapi.", R.drawable.makanan3),
            Food("Nasi Goreng", "Nasi goreng spesial telur mata sapi.", R.drawable.makanan4),
            Food("Sate Ayam", "Sate ayam bumbu kacang kental.", R.drawable.makanan5),
            Food("Soto Ayam", "Soto ayam hangat dengan koya.", R.drawable.makanan6),
            Food("Gado Gado", "Campuran sayur segar saus kacang.", R.drawable.makanan7),
            Food("Rendang Padang", "Daging sapi bumbu rempah asli Padang.", R.drawable.makanan8),
            Food("Ayam Penyet", "Ayam goreng dengan sambal penyet pedas.", R.drawable.makanan9),
            Food("Pecel Lele", "Lele goreng garing sambal tomat.", R.drawable.makanan10)
        )

        rvFood.layoutManager = LinearLayoutManager(this)
        rvFood.adapter = FoodAdapter(dataFood)
    }
}

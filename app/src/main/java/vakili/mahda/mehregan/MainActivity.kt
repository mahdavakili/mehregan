package vakili.mahda.mehregan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import vakili.mahda.mehregan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)


        binding.productCard.setOnClickListener {
            val intent = Intent(this, ProductActivity::class.java)
            startActivity(intent)
        }


        binding.orderCards.setOnClickListener {
            val intent = Intent(this, OrderActivity::class.java)
            startActivity(intent)
        }

        binding.orderTrackingCard.setOnClickListener {
            val intent = Intent(this, OrderTrackingActivity::class.java)
            startActivity(intent)
        }


        binding.reportingCards.setOnClickListener {
            val intent = Intent(this, ReportingActivity::class.java)
            startActivity(intent)
        }


    }

}
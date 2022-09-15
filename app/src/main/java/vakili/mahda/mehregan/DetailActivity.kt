package vakili.mahda.mehregan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import vakili.mahda.mehregan.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var textViewTitle1: TextView
    private lateinit var textViewDescription1: TextView
    private lateinit var binding: ActivityDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setIntentData()
        bindViews()
    }

    private fun setIntentData() {
        val intent = intent
        val title = intent.getStringExtra(AppConstant.NAME)
        val description = intent.getStringExtra(AppConstant.NUMBER_IN_THE_BOX)
        textViewTitle1.text = title
        textViewDescription1.text = description
    }

    private fun bindViews() {

        textViewTitle1 = binding.textViewName
        textViewDescription1 = binding.textViewNumberinthebox
    }}
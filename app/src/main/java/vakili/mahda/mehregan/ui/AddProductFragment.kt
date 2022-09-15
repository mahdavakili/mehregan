package vakili.mahda.mehregan.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import vakili.mahda.mehregan.*
import vakili.mahda.mehregan.databinding.FragmentAddProductBinding
import java.util.ArrayList

class AddProductFragment : Fragment() {
    private var _binding: FragmentAddProductBinding? = null
    private val binding get() = _binding!!

    lateinit var recyclerViewNotes: RecyclerView
    val productsList = ArrayList<Notes>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddProductBinding.inflate(layoutInflater, container, false)
        val view = binding.root
        val editTextName = binding.editTextName
        val editTexNumberInTheBox = binding.editTextNumberInTheBox
        val editTextPrice = binding.editTextPrice


        binding.buttonSubmit.setOnClickListener{


                val name = editTextName.text.toString()
                val numberInTheBox = editTexNumberInTheBox.text.toString()
                val price = editTextPrice.text.toString()
                if (name.isNotEmpty() && numberInTheBox.isNotEmpty() && price.isNotEmpty()) {
                    val notes = Notes(name, numberInTheBox.toInt(), price.toInt())
                    productsList.add(notes)
                    SetupRecyclerView()
                  // val action = AddProductFragmentD

                } else {
                    Toast.makeText(activity,
                        "نام محصول و تعداد در کارتن و قیمت نمیتواند خالی باشد",
                        Toast.LENGTH_LONG
                    ).show()
                }


        }


        return view
    }

    private fun SetupRecyclerView() {
        val itemClickListener = object : ItemClickListener {
            override fun onClick(notes: Notes) {
                val intent = Intent()
                intent.putExtra(AppConstant.NAME,notes.name)
                intent.putExtra(AppConstant.NUMBER_IN_THE_BOX,notes.numberInTheBox)
                intent.putExtra(AppConstant.PRICE,notes.price)
                targetFragment?.onActivityResult(targetRequestCode, Activity.RESULT_OK, intent)
            }

        }


        val notesAdapter = ProductsAdapter(productsList, itemClickListener)
        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation= RecyclerView.VERTICAL
        recyclerViewNotes.layoutManager = linearLayoutManager
        recyclerViewNotes.adapter = notesAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
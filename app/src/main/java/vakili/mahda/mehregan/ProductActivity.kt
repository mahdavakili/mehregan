package vakili.mahda.mehregan

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import vakili.mahda.mehregan.databinding.ActivityMainBinding
import vakili.mahda.mehregan.databinding.ActivityProductBinding

class ProductActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductBinding
    lateinit var fabAddNotes: FloatingActionButton
    lateinit var sharedPreferences: SharedPreferences
    lateinit var recyclerViewNotes: RecyclerView
    var notesList = ArrayList<Notes>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)

        setContentView(binding.root)

        fun setupDialogBox() {
            val view = LayoutInflater.from(this).inflate(R.layout.add_notes_dialog_layaut,null)
            val editTextTitle = view.findViewById<EditText>(R.id.editTextTitel)
            val editTextDescription = view.findViewById<EditText>(R.id.editTextdescription)
            val buttonSubmit = view.findViewById<Button>(R.id.buttonSubmit)
            val dialog = AlertDialog.Builder(this@ProductActivity)
                .setView(view)
                .setCancelable(false)
                .create()
            buttonSubmit.setOnClickListener(object : View.OnClickListener {
                override fun onClick(p0: View?) {
                    val title = editTextTitle.text.toString()
                    val description = editTextDescription.text.toString()
                    if (title.isNotEmpty() && description.isNotEmpty()) {
                        val notes = Notes(title,description)
                        notesList.add(notes)
                    } else {
                        Toast.makeText(
                            this@ProductActivity,
                            "Title or Description can't be empty",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                    SetupRecyclerView()
                    dialog.hide()
                }

            })
            dialog.show()
        }
        fabAddNotes.setOnClickListener { setupDialogBox() }


    }

    private fun SetupRecyclerView() {
        val itemClickListener = object : ItemClickListener {
            override fun onClick(notes: Notes) {
                val intent = Intent(this@ProductActivity , DetailActivity::class.java)
                intent.putExtra(AppConstant.TITLE,notes.title)
                intent.putExtra(AppConstant.DESCRIPTION,notes.description)
                startActivity(intent)
            }

        }
        val notesAdapter = NotesAdapter(notesList, itemClickListener)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation= RecyclerView.VERTICAL
        recyclerViewNotes.layoutManager = linearLayoutManager
        recyclerViewNotes.adapter = notesAdapter    }
}

data class Notes (val title:String,val description: String)

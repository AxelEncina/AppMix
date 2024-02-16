package com.example.androidmaster.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmaster.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TodoActivity : AppCompatActivity() {

    private val categories = listOf(
        TaskCategory.Personal,
        TaskCategory.Bussiness,
        TaskCategory.Others
    )

    private val tasks = mutableListOf(
        Task("PruebasPersonal", TaskCategory.Personal, false),
        Task("PruebaBusiness", TaskCategory.Bussiness, false),
        Task("PruebaOther", TaskCategory.Others, false),
    )
    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var rvTasks: RecyclerView
    private lateinit var tasksAdapter: TasksAdapter
    private lateinit var fabAddTask: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponent()
        initUI()
        initListeners()
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener {
            showDialog()
        }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnAddTask.setOnClickListener {

            val currentTask = etTask.text.toString()
            if (currentTask.isNotEmpty()) {
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton = rgCategories.findViewById<RadioButton>(selectedId)
                val currentCategory: TaskCategory = when (selectedRadioButton.text) {
                    "Personal" -> TaskCategory.Personal
                    "Negocios" -> TaskCategory.Bussiness
                    else -> TaskCategory.Others
                }

                tasks.add(Task(currentTask, currentCategory, false))
                updateTasks()
                dialog.hide()
                //hay que avisar al adapter vie que se actualizo la lista
            }
        }
        dialog.show()
    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUI() {
        /*
        para que un recyclerview funcione tiene que tener un adapter(clase que va a conectar la info con el recyclerview) y un viewholder (lo pinta)
         */
        categoriesAdapter = CategoriesAdapter(categories) {position -> updateCategories(position) }
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        tasksAdapter = TasksAdapter(tasks) {position -> onItemSelected(position)} //una funcion que va a ser llamada cuando se active la fun lambda
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter


    }

    private fun onItemSelected(position:Int) {
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
        //con la funcion lambda se lo puedo pasar al adapter porque es una recycler view
    }

    private fun updateCategories(position:Int) {
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()
    }
    private fun updateTasks() {
        val selectedCategories: List<TaskCategory> = categories.filter { it.isSelected }
        val newTasks = tasks.filter { selectedCategories.contains(it.category) }
        tasksAdapter.tasks = newTasks
        tasksAdapter.notifyDataSetChanged()
    }
}
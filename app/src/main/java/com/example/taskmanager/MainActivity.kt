package com.example.taskmanager

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnAddTask).setOnClickListener {
            showAddTaskFragment()
        }

        findViewById<Button>(R.id.btnViewTasks).setOnClickListener {
            startActivity(Intent(this, ViewTasksActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_add_task -> {
                showAddTaskFragment()
                true
            }
            R.id.menu_view_tasks -> {
                startActivity(Intent(this, ViewTasksActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showAddTaskFragment() {
        val addTaskFragment = AddTaskFragment()
        addTaskFragment.show(supportFragmentManager, "AddTaskFragment")
    }
}

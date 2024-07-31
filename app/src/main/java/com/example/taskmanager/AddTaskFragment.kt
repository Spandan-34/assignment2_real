package com.example.taskmanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class AddTaskFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add_task, container, false)

        val etTaskName = view.findViewById<EditText>(R.id.etTaskName)
        val spinnerPriority = view.findViewById<Spinner>(R.id.spinnerPriority)
        val btnSaveTask = view.findViewById<Button>(R.id.btnSaveTask)

        val priorities = arrayOf("High", "Medium", "Low")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, priorities)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerPriority.adapter = adapter

        btnSaveTask.setOnClickListener {
            val taskName = etTaskName.text.toString().trim()
            val taskPriority = spinnerPriority.selectedItem.toString()

            if (taskName.isNotEmpty()) {
                // Add task to TaskManager
                TaskManager.tasks.add(Task(taskName, taskPriority))
                Toast.makeText(requireContext(), "Task Added", Toast.LENGTH_SHORT).show()
                dismiss()
            } else {
                Toast.makeText(requireContext(), "Please enter a task name", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}

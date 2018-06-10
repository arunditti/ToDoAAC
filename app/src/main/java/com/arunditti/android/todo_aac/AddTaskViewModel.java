package com.arunditti.android.todo_aac;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.arunditti.android.todo_aac.database.AppDatabase;
import com.arunditti.android.todo_aac.database.TaskEntry;

/**
 * Created by arunditti on 6/10/18.
 */

class AddTaskViewModel extends ViewModel {

    // Add a task member variable for the TaskEntry object wrapped in a LiveData
    private LiveData<TaskEntry> task;

    // Create a constructor where you call loadTaskById of the taskDao to initialize the tasks variable
    // The constructor should receive the database and the taskId
    public AddTaskViewModel(AppDatabase database, int taskId) {
        task = database.taskDao().loadTaskById(taskId);
    }

    //Create a getter for the task variable
    public LiveData<TaskEntry> getTask() {
        return task;
    }
}
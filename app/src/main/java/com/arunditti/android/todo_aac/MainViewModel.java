package com.arunditti.android.todo_aac;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.arunditti.android.todo_aac.database.AppDatabase;
import com.arunditti.android.todo_aac.database.TaskEntry;

import java.util.List;

/**
 * Created by arunditti on 6/8/18.
 */

public class MainViewModel extends AndroidViewModel {

    // COMPLETED (1)Constant for logging
    private static final String LOG_TAG = MainViewModel.class.getSimpleName();

    // COMPLETED (2) Add a tasks member variable for a list of TaskEntry objects wrapped in a LiveData
    private LiveData<List<TaskEntry>> tasks;

    public MainViewModel(Application application) {
        super(application);
        // COMPLETED (4) In the constructor use the loadAllTasks of the taskDao to initialize the tasks variable
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(LOG_TAG, "Actively retrieving the tasks from the DataBase");
        tasks = database.taskDao().loadAllTasks();
    }

    // COMPLETED (3) Create a getter for the tasks variable
    public LiveData<List<TaskEntry>> getTasks() {
        return tasks;
    }
}
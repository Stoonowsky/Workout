package com.example.workout

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.workout.chooser.LevelEnum
import com.example.workout.chooser.TypeEnum
import com.example.workout.chooser.WorkoutItem
import kotlinx.android.synthetic.main.fragment_workout_list.*


class WorkoutFragment : Fragment() {

    private val workoutsMap: HashMap<String, WorkoutItem> = HashMap()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnStartWorkoutListener){
            onStartWorkoutListener = context
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_workout_list, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUpRecyclerView()
        setCommunication()
    }

    private fun setCommunication() {
        workoutsMap.apply {
            put("23", WorkoutItem(type = TypeEnum.Split))
            put("231", WorkoutItem(type = TypeEnum.FBW))
            put("232", WorkoutItem(level = LevelEnum.HARD))
            put("2331", WorkoutItem(level = LevelEnum.AVERAGE))
            put("121", WorkoutItem())
            put("113", WorkoutItem())
            put("114", WorkoutItem())
            put("115", WorkoutItem())
            put("116", WorkoutItem())
            put("117", WorkoutItem())
            put("118", WorkoutItem())
            put("119", WorkoutItem())
            put("110", WorkoutItem())
            put("111", WorkoutItem())
            put("112", WorkoutItem())
            put("141", WorkoutItem())
            put("151", WorkoutItem())
            put("161", WorkoutItem())
            put("171", WorkoutItem())
        }
    }

    private lateinit var onStartWorkoutListener: OnStartWorkoutListener

    private fun setUpRecyclerView() {
        workout_item_list.layoutManager = GridLayoutManager(context, COLUMN_COUNT)
        workout_item_list.adapter = WorkoutChooserRecyclerViewAdapter(workoutsMap, onStartWorkoutListener)
    }

    interface OnStartWorkoutListener{
        fun onStartWorkoutSelected(workout: WorkoutItem, string: String)
    }
    companion object{
        private const val COLUMN_COUNT = 3

    }
}





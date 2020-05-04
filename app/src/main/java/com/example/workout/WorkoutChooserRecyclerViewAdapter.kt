package com.example.workout

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.workout.chooser.WorkoutItem

class WorkoutChooserRecyclerViewAdapter(private val workoutsMap: HashMap<String, WorkoutItem>,
                                        private val onStartWorkoutListener:WorkoutFragment.OnStartWorkoutListener ): RecyclerView.Adapter<WorkoutChooserRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_workout, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = workoutsMap.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val sorted = workoutsMap.values.toList().sortedBy { workoutItem -> workoutItem.level.ordinal + workoutItem.type.ordinal * 10 }
        holder.mItem = sorted[position]

        holder.levelImageView.setImageResource(sorted[position].level.image)
        holder.workoutImageView.setImageResource(sorted[position].type.image)
        holder.workoutTitle.text = getDoubleLineWorkoutTitle(sorted, position)


        holder.mView.setOnClickListener{
            onStartWorkoutListener.onStartWorkoutSelected(holder.mItem, getSingleLineWorkoutTitle(sorted, position))
        }
    }
    private fun getSingleLineWorkoutTitle(sorted: List<WorkoutItem>, position: Int) = "${sorted[position].type.getString()} \n ${sorted[position].level.getString()}"
    private fun getDoubleLineWorkoutTitle(sorted: List<WorkoutItem>, position: Int) = "${sorted[position].type.getString()} \n ${sorted[position].level.getString()}"


    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView){
        val workoutImageView = mView.findViewById<View>(R.id.workoutImageView) as ImageView
        val levelImageView = mView.findViewById<View>(R.id.levelImageView) as ImageView
        val workoutTitle = mView.findViewById<View>(R.id.workoutTitle) as TextView

        lateinit var mItem: WorkoutItem
    }
}

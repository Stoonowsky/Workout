package com.example.workout.home

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.beardedhen.androidbootstrap.BootstrapCircleThumbnail
import com.bumptech.glide.Glide
import com.example.workout.HomeFragment
import com.example.workout.R

class HomeListRecyclerViewAdapter(private val mHomeMap: HashMap<String, HomeItem>, private val onHomeInteractionListener: HomeFragment.OnHomeInteractionListener): RecyclerView.Adapter<HomeListRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListRecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_homeitem, parent, false)
        return ViewHolder(view)

    }



    override fun onBindViewHolder(holder: HomeListRecyclerViewAdapter.ViewHolder, position: Int) {
        val sortedList = mHomeMap.toList().sortedWith(Comparator({o1, o2 -> if(o1.second.timeMilis<o2.second.timeMilis) 1 else -1 }))
        val second = sortedList[position].second

        holder.mItem = second

        holder.name.text = second.user
        holder.time.text = getElapsedTimeMinutesFromString(second.timeMilis)
        holder.workoutTitle.text = second.workout
        holder.comment.text = second.comment
        holder.comment.visibility = getCommentVisibility(second)
        holder.pointsText.text = second.points.toString()
        holder.respects.text = countRespects(second)
        holder.likesImage.isChecked = getLikeChecked(second)
        Glide.with(holder.mView.context).load(second.image).into(holder.profile)
//      todo interakcje
    }

    private fun getCommentVisibility(second: HomeItem): Int {

        return if(second.comment.isNotEmpty()){
            View.VISIBLE
        }
        else{
            View.GONE
        }

    }

    private fun getLikeChecked(second: HomeItem): Boolean {
        //todo get current user respect
        return false
    }

    private fun countRespects(second: HomeItem): String {
        return second.respects.values.count { it == 1 }.plus(1).toString()
    }

    private fun getElapsedTimeMinutesFromString(timeMilis: Long): String {

        val elapsedTimeSec = (System.currentTimeMillis() - timeMilis) / 1000
        val format = String.format("%%0%dd", 2)
        return when {
            (elapsedTimeSec / 3600 > 24) -> {
                val days = elapsedTimeSec / (60 * 60 * 24)
                String.format(format, days) + "d"

            }
            (elapsedTimeSec / 60 > 60) -> {
                val hours = elapsedTimeSec / (60 * 60)
                String.format(format, hours) + "h"

            }
            else -> {
                String.format(format, elapsedTimeSec / 60) + "m"
            }
        }
    }

    override fun getItemCount() = mHomeMap.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView){
        var mItem: HomeItem? = null

        var name = mView.findViewById<TextView>(R.id.name)!!
        var time = mView.findViewById<TextView>(R.id.time)!!
        var workoutTitle = mView.findViewById<TextView>(R.id.workoutTitle)!!
        var comment = mView.findViewById<TextView>(R.id.comment)!!
        var pointsText = mView.findViewById<TextView>(R.id.pointsText)!!
        var respects = mView.findViewById<TextView>(R.id.respects)!!
        var likesImage = mView.findViewById<CheckBox>(R.id.likesImage)!!
        var profile = mView.findViewById<BootstrapCircleThumbnail>(R.id.circleImageProfile)!!
    }




}
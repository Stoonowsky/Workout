package com.example.workout

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.ViewParent
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.workout.chooser.WorkoutItem
import com.example.workout.profile.UserItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity() : AppCompatActivity(),
    BottomNavigationView.OnNavigationItemSelectedListener,
    WorkoutFragment.OnStartWorkoutListener,
    HomeFragment.OnHomeInteractionListener, Parcelable {

    override fun onStartWorkoutSelected(workout: WorkoutItem, string: String) {
        Log.i("MAIN_ACTIVITY", "onStartWorkoutSelected")
    }

    private lateinit var viewPager: ViewPager
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var mainPagerAdapter: MainPagerAdapter

    constructor(parcel: Parcel) : this() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager = findViewById(R.id.viewpager);
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        mainPagerAdapter = MainPagerAdapter(supportFragmentManager)


        mainPagerAdapter.setItems(arrayListOf(MainScreen.HOME, MainScreen.WORKOUT, MainScreen.PROFILE))

        val defaultScreen = MainScreen.HOME
        scrollToScreen(defaultScreen)
        selectBottomNaivgationViewMenuItem(defaultScreen.menuItemId)
        supportActionBar?.setTitle(defaultScreen.titleStringId)

        bottomNavigationView.setOnNavigationItemSelectedListener(this)

        viewPager.adapter = mainPagerAdapter
        viewPager.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener(){
            override fun onPageSelected(position: Int){
                val selectedScreen = mainPagerAdapter.getItems()[position]
                selectBottomNaivgationViewMenuItem(selectedScreen.menuItemId)
                supportActionBar?.setTitle(selectedScreen.titleStringId)
            }
        })

    }

    private fun selectBottomNaivgationViewMenuItem(@IdRes menuItemId: Int) {
        bottomNavigationView.setOnNavigationItemSelectedListener(null)
        bottomNavigationView.selectedItemId = menuItemId
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    private fun scrollToScreen(mainScreen: MainScreen) {
        val screenPosition = mainPagerAdapter.getItems().indexOf(mainScreen)
        if(screenPosition != viewPager.currentItem){
            viewPager.currentItem = screenPosition
        }

    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        getMainScreenForMenuItem(menuItem.itemId)?.let {
            scrollToScreen(it)
            supportActionBar?.setTitle(it.titleStringId)
            return false
        }
        return false
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onUserSelected(user: UserItem, image: View) {
        //todo przejsc do other user activity
    }

    override fun onLikeSelecter(feedID: String, diff: Int) {
        //todo like feed
    }


}

package com.example.workout

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.workout.home.HomeItem
import com.example.workout.home.HomeListRecyclerViewAdapter
import com.example.workout.profile.UserItem
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_workout_list.*


class HomeFragment : Fragment() {

    private lateinit var onHomeInteractionListener: OnHomeInteractionListener

    private val mHomeMap: HashMap<String, HomeItem> = hashMapOf()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnHomeInteractionListener){
            onHomeInteractionListener = context
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loader_home.visibility = View.VISIBLE
//todo ładowanie danych
//        onUpdateAdapter()

        mHomeMap.apply {
            put("asda", HomeItem(
                comment = "Komentarz",
                points = 12,
                workout = "FBW łatwy",
                image = "https://img.hoit.pl/unsafe/fit-in/512x512/smart/filters:format(png)/expe.pl/wp-content/uploads/2017/02/003-people-1.png",
                user = "Jan Kowalski",
                timeMilis = System.currentTimeMillis()-1000,
                uid = "blabla",
                respects = hashMapOf(Pair("blabla", 1),Pair("fafa", 2))))

            put("asdad", HomeItem(
                comment = "POMPAAAAAAAA",
                points = 10,
                workout = "Split łatwy",
                image = "https://fortwola.romax.waw.pl/wp-content/uploads/2019/09/boy.png",
                user = "Jan Nowak",
                timeMilis = System.currentTimeMillis()-1000,
                uid = "blabla2",
                respects = hashMapOf(Pair("blabla2", 1),Pair("blabla", 1))))

            put("asdas", HomeItem(
                comment = "JEST MOC",
                points = 12,
                workout = "FBW trudny",
                image = "https://kosmatek.pl/wp-content/uploads/2017/02/boy.png",
                user = "Franek Dolas",
                timeMilis = System.currentTimeMillis()-1000,
                uid = "fafa",
                respects = hashMapOf(Pair("fafa", 1),Pair("blabla", 1))))

            put("asdag", HomeItem(
                comment = "Ty no nie wiem",
                points = 20,
                workout = "Split trudny",
                image = "https://fortwola.romax.waw.pl/wp-content/uploads/2019/09/girl.png",
                user = "Gosia Samosia",
                timeMilis = System.currentTimeMillis()-1000,
                uid = "fafa1",
                respects = hashMapOf(Pair("fafa1", 1),Pair("blabla", 1), Pair("fafa",1))))

            put("asdah", HomeItem(
                comment = "To niezły treningunio",
                points = 22,
                workout = "Split średni",
                image = "https://fortwola.romax.waw.pl/wp-content/uploads/2019/09/girl.png",
                user = "Ania Zaiwania",
                timeMilis = System.currentTimeMillis()-1000,
                uid = "fafa2",
                respects = hashMapOf(Pair("fafa2", 1),Pair("blabla", 1), Pair("fafa1",1))))

        }



        feed_item_list.scheduleLayoutAnimation()
        loader_home.visibility = View.GONE
        setUpRecycler()
    }

    private fun setUpRecycler() {
        feed_item_list.layoutManager = LinearLayoutManager(context)
        feed_item_list.adapter = HomeListRecyclerViewAdapter(mHomeMap, onHomeInteractionListener)
    }

    interface OnHomeInteractionListener {
        fun onUserSelected(user: UserItem, image: View)
        fun onLikeSelecter(feedID: String, diff: Int)
    }
}





package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.Gender
import com.example.lab_week_06.model.CatAdapter


class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter: CatAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object : OnClickListener {
            override fun onItemClick(cat: CatModel) {
                showSelectionDialog(cat)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Instantiate ItemTouchHelper for the swipe to delete callback and
        // attach it to the recycler view
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        val sampleCats = listOf(
            CatModel(
                Gender.Male,
                CatBreed.BalineseJavanese,
                "Karrell",
                "Silent and deadly",
                "https://cdn2.thecatapi.com/images/7dj.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.ExoticShorthair,
                "Sophie",
                "Cuddly assassin",
                "https://cdn2.thecatapi.com/images/egv.jpg"
            ),
            CatModel(
                Gender.Unknown,
                CatBreed.AmericanCurl,
                "Curious George",
                "Award winning investigator",
                "https://cdn2.thecatapi.com/images/bar.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.ExoticShorthair,
                "Fedora",
                "A sleepy purr machine",
                "https://cdn2.thecatapi.com/images/154.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.AmericanCurl,
                "Leo",
                "Loves to play fetch",
                "https://cdn2.thecatapi.com/images/564.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.BalineseJavanese,
                "Maul",
                "Graceful and elegant",
                "https://cdn2.thecatapi.com/images/876.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.ExoticShorthair,
                "Fahmy",
                "Enjoys sunbathing all day",
                "https://cdn2.thecatapi.com/images/992.jpg"
            ),
            CatModel(
                Gender.Unknown,
                CatBreed.AmericanCurl,
                "Waltz",
                "A gentle giant",
                "https://cdn2.thecatapi.com/images/323.jpg"
            ),
            CatModel(
                Gender.Male,
                CatBreed.BalineseJavanese,
                "Leo",
                "A fearless hunter",
                "https://cdn2.thecatapi.com/images/223.jpg"
            ),
            CatModel(
                Gender.Female,
                CatBreed.ExoticShorthair,
                "Chloe",
                "Very talkative and friendly",
                "https://cdn2.thecatapi.com/images/789.jpg"
            )
        )
        catAdapter.setData(sampleCats)
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}
package com.example.recipepuppy.ui.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.recipepuppy.App
import com.example.recipepuppy.R
import com.example.recipepuppy.model.RecipeResponse
import com.example.recipepuppy.ui.home.di.DaggerHomeComponent
import com.example.recipepuppy.ui.home.di.HomeModule
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HomeContract.View {

    private val RecipeAdapter = RecipeAdapter()

    @Inject
    lateinit var homePresenter: HomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerHomeComponent.builder()
            .appComponent((application as App).getAppComponent())
            .homeModule(HomeModule(this))
            .build()
            .inject(this)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RecipeAdapter

        btnResults.setOnClickListener {
            homePresenter.getRecipe(etDishName.text.toString())
        }
    }

    override fun showRecipe(results: List<RecipeResponse>) {
        RecipeAdapter.setData(results)
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

}

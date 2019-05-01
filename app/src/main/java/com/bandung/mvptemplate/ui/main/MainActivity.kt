package com.bandung.mvptemplate.ui.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bandung.mvptemplate.R
import com.bandung.mvptemplate.di.component.DaggerActivityComponent
import com.bandung.mvptemplate.di.module.ActivityModule
import com.bandung.mvptemplate.models.Movie
import com.bandung.mvptemplate.ui.latihan_pertama.PhotosActivity
import dagger.android.DaggerActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity() , MainContract.View{
    override fun onDomainSuccess(movie: List<Movie>) {
        txtHello.text = movie.toString()
    }

    override fun onDomainError(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
    }

    @Inject
    lateinit var presenter: MainContract.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()
        presenter.attach(this)

        initView()
    }

    private fun initView() {
        button2.setOnClickListener {
            presenter.getMovie()
        }

        btn_open_photos_activity.setOnClickListener{
            val intent = Intent(this, PhotosActivity::class.java)
            startActivity(intent)
        }
    }


    private fun injectDependency() {

        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
    }
}

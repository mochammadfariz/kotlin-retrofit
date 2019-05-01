package com.bandung.mvptemplate.ui.main

import com.bandung.mvptemplate.models.Movie
import com.bandung.mvptemplate.ui.base.BaseContract

class MainContract {

    interface View: BaseContract.View{

        fun onDomainSuccess(movie: List<Movie>)
        fun onDomainError(msg: String)

    }

    interface Presenter:BaseContract.Presenter<View>{
        fun getMovie()
    }
}
package com.bandung.mvptemplate.di.component

import com.bandung.mvptemplate.di.module.ActivityModule
import com.bandung.mvptemplate.ui.main.MainActivity
import dagger.Component

@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)

}
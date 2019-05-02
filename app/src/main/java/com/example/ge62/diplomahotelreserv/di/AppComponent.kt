package com.example.ge62.diplomahotelreserv.di


import com.example.ge62.diplomahotelreserv.storage.UserStorage
import com.example.ge62.diplomahotelreserv.ui.addhotel.AddHotelInfoPresenter
import com.example.ge62.diplomahotelreserv.ui.addhotelmain.AddHottelActivity
import com.example.ge62.diplomahotelreserv.ui.addhotelmain.addroom.AddHotelRoomPresenter
import com.example.ge62.diplomahotelreserv.ui.hotdeals.HotDealsActivity
import com.example.ge62.diplomahotelreserv.ui.hotdeals.HotDealsPresenter
import com.example.ge62.diplomahotelreserv.ui.hotrooms.HotRoomsActivity
import com.example.ge62.diplomahotelreserv.ui.signin.SignInPresenter
import com.example.ge62.diplomahotelreserv.ui.signup.SignUpPresenter
import dagger.Component
import javax.inject.Singleton

@Component(modules = arrayOf(AppModule::class, StorageModule::class,DataModule::class, NetworkModule::class))
@Singleton
interface AppComponent {

//    fun inject(presenter: SplashPresenter)
//
    fun inject(presenter: SignInPresenter)
    fun inject(presenter: SignUpPresenter)
    fun inject(presenter: HotDealsPresenter)
    fun inject(activity: HotDealsActivity)
    fun inject(presenter: AddHotelInfoPresenter)
    fun inject(presenter: AddHottelActivity)
    fun inject(activity: HotRoomsActivity)
    fun inject(userStorage: UserStorage)
    fun inject(addHotelRoomPresenter: AddHotelRoomPresenter)
//    fun inject(presenter: SignUpPresenter)

}
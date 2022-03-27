package com.fmauriciors.projectaromascafetales.ui.splashac

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val DEFAULT_DELAY = 2000L

class SplashAcViewModel : ViewModel() {
   // private lateinit var auth: FirebaseAuth
    private val timer = MutableLiveData<Boolean>()
    val onTimer: LiveData<Boolean> = timer

    init {


        viewModelScope.launch(Dispatchers.IO) {
            //auth = Firebase.auth
            delay(DEFAULT_DELAY)
           // if (auth.currentUser == null) goToLoginActivity()
            timer.postValue(true)
        }
    }
}

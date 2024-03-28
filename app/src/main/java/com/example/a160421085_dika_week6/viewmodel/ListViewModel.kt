package com.example.a160421085_dika_week6.viewmodel


import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a160421085_dika_week6.model.Game
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListViewModel(application: Application):AndroidViewModel(application) {
    val GameLD = MutableLiveData<ArrayList<Game>>()
    val GameLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh() {
        GameLoadErrorLD.value = false
        loadingLD.value = true

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/Game/Game.json"

        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Game>>() { }.type
                val result = Gson().fromJson<List<Game>>(it, sType)
                GameLD.value = result as ArrayList<Game>?
                loadingLD.value = false

                Log.d("show_volley", it)
            },
            {
                Log.e("show_volley", it.toString())
                GameLoadErrorLD.value = false
                loadingLD.value = false
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}
package com.example.a160421085_dika_week6

import android.media.Image

data class Game(
    val id:String?,
    val title:String?,
    val genre:String?,
    val platforms:List<String>?,
    val developer:DeveloperDetail?,
    val image:String?
)
data class DeveloperDetail(
    val name:String?,
    val country:String?
)

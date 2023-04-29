package com.example.photogrid.domain

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringSource: Int,
    val count: Int,
    @DrawableRes val imageSource: Int
)

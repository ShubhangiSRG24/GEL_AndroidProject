package com.example.gel_beta.model.google.nearbySearch

import com.google.gson.annotations.SerializedName

data class Geometry(@SerializedName("viewport")
                    val viewport: Viewport?,
                    @SerializedName("location")
                    val location: Location?)
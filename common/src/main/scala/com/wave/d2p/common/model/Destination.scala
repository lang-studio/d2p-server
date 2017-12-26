package com.wave.d2p.common.model

/**
  * Created by apple on 2017/9/16.
  */

/*case class Destinations(
  list: Destination*
)*/

case class Destination(
                        parentId: Int,
                        id: Int,
                        popularity: Double,
                        name: String,
                        description: String,
                        parentName: String,
                        longitude: Double,
                        latitude: Double,
                        isDefault: Boolean,
                        duration: Float
                      )
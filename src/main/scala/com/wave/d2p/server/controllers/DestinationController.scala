package com.wave.d2p.server.controllers

import com.github.xiaodongw.swagger.finatra.SwaggerSupport
import com.twitter.finagle.http.Request
import com.twitter.finatra.http.Controller
import com.wave.d2p.server.dao.MyRefDatabase
import com.wave.d2p.common.model.Destination
import com.wave.d2p.server.swagger.SwaggerDocument

/**
  * Created by apple on 2017/9/16.
  */
class DestinationController extends Controller with SwaggerSupport {

  implicit protected val swagger = SwaggerDocument

  getWithDoc("/destinations/:key") { o =>
    o.summary("Search for destinations based on key")
      .tag("Destination")
      .routeParam[String]("key", "the search key")
      .responseWith[Array[Destination]](200, "the destinations matching the search key")
  }
  { request: Request =>
    //"Searching for " + request.params("key") + "...\n"
    MyRefDatabase.DestinationModel.getByParentId(request.params("key").toInt)
  }

}

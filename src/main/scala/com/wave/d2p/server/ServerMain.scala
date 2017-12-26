package com.wave.d2p.server

import com.twitter.finagle.http.Request
import com.twitter.finatra.http.routing.HttpRouter
import com.twitter.finatra.http.{Controller, HttpServer}
import com.github.xiaodongw.swagger.finatra.{SwaggerController, WebjarsController}
import com.wave.d2p.server.dao.{MyRefDatabase, CassandraDatabase}
import com.wave.d2p.server.controllers.DestinationController
import com.wave.d2p.server.swagger.SwaggerDocument
import io.swagger.models.Info

object D2pServerMain extends D2pServer

class D2pServer extends HttpServer {

  override protected def defaultFinatraHttpPort: String = ":8080"
  override protected def defaultHttpServerName: String = "Dots2Trip"

  SwaggerDocument.info(new Info()
    .description("Dots2Trip Server REST Service")
    .version("0.0.1")
    .title("Dots2Trip Server")
  )

  override protected def configureHttp(router: HttpRouter): Unit = {
    router.add[WebjarsController]
    router.add(new SwaggerController(swagger = SwaggerDocument))
    router.add(new DestinationController)
  }
}

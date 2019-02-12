package com.example

import com.github.swagger.akka.SwaggerHttpService
import com.github.swagger.akka.model.Info

object SwaggerDocService extends SwaggerHttpService {
  override val apiClasses: Set[Class[_]] = Set(classOf[FooService])
  override val host = "localhost:8080" //the url of your api, not swagger's json endpoint
  override val info = Info() //provides license and other description details
}
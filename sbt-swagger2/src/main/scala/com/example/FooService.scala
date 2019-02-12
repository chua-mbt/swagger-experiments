package com.example

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

import io.swagger.annotations._
import javax.ws.rs.Path

@Path("/foo")
@Api(value = "FooService")
trait FooService extends SprayJsonSupport {

  lazy val routes = {
    pathPrefix("foo")(foo)
  }

  @ApiOperation(httpMethod = "POST", response = classOf[Foo], value = "Returns foo")
  @ApiImplicitParams(Array(
    new ApiImplicitParam(name = "fooRequest", required = true, dataType = "com.example.FooRequest", paramType = "body", value = "FooRequest body")))
  @ApiResponses(Array(
    new ApiResponse(code = 400, message = "Invalid request"),
    new ApiResponse(code = 404, message = "Not found")))
  def foo: Route =
    post {
      entity(as[FooRequest]) { request =>
        complete(Foo(request.foo, 1234))
      }
    }
}

object FooService extends FooService
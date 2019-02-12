package com.example

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.model.HttpMethods.POST
import akka.http.scaladsl.model.headers.RawHeader
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

import net.jtownson.swakka.coreroutegen._
import net.jtownson.swakka.openapimodel._
import net.jtownson.swakka.openapiroutegen._
import net.jtownson.swakka.openapijson._

trait FooService extends SprayJsonSupport {
  val fooPath = PathItem(
    path = "/foo",
    method = POST,
    operation = Operation(
      summary = Some("Returns foo"),
      parameters = Tuple1(BodyParameter[FooRequest](name = 'fooRequest, description = Some("FooRequest body"))),
      responses = Tuple1(ResponseValue[Foo]("200", "Happy path")),
      endpointImplementation = foo _))

  val fooServiceApi = OpenApi(
    info = Info(version = "", title = "FooService"),
    host = Some("localhost:8080"),
    paths = (fooPath))

  val corsHeaders = List(
    RawHeader("Access-Control-Allow-Origin", "*"),
    RawHeader("Access-Control-Allow-Methods", "GET, POST"))

  lazy val routes = openApiRoute(
    fooServiceApi,
    swaggerRouteSettings = Some(DocRouteSettings(corsUseCase = SpecificallyThese(corsHeaders))))

  def foo(request: FooRequest): Route =
    complete(Foo(request.foo, 1234))
}

object FooService extends FooService
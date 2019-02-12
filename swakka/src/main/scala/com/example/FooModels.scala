package com.example

import spray.json.DefaultJsonProtocol._

case class Foo(bar: String, baz: Int)

object Foo {
  implicit val format = jsonFormat2(Foo.apply)
}

case class FooRequest(foo: String)

object FooRequest {
  implicit val format = jsonFormat1(FooRequest.apply)
}
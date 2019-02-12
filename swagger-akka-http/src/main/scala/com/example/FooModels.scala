package com.example

import spray.json.DefaultJsonProtocol._
import scala.annotation.meta.field

import io.swagger.annotations.{ ApiModel, ApiModelProperty }

@ApiModel(description = "A foo object")
case class Foo(
  @(ApiModelProperty @field)(value = "field bar", dataType = "string") bar: String,
  @(ApiModelProperty @field)(value = "field baz", dataType = "integer") baz: Int)

object Foo {
  implicit val format = jsonFormat2(Foo.apply)
}

@ApiModel(description = "A foo request object")
case class FooRequest(
  @(ApiModelProperty @field)(value = "field foo", dataType = "string") foo: String)

object FooRequest {
  implicit val format = jsonFormat1(FooRequest.apply)
}
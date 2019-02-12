addSbtPlugin("org.scalariform" % "sbt-scalariform" % "1.8.2")

addSbtPlugin("io.spray" % "sbt-revolver" % "0.9.1")

resolvers ++= Seq(
  "Sonatype tools"                   at "https://oss.sonatype.org/content/groups/scala-tools/",
  "Sonatype releases"                at "https://oss.sonatype.org/content/repositories/releases",
  "Sonatype snapshots"               at "https://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype staging"                 at "http://oss.sonatype.org/content/repositories/staging",
)

addSbtPlugin("io.scalaland" % "sbt-swagger-2" % "0.1.8")
name := "svcprovider"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "org.mongodb" % "mongo-java-driver" % "3.0.0",
  "org.mongodb.morphia" % "morphia" % "1.0.1"
)     

play.Project.playJavaSettings



scalaVersion := "2.10.4"

scalacOptions +="-feature"

libraryDependencies ++=  Seq(
"org.elasticsearch" % "elasticsearch" % "1.4.2"  withSources(),
"org.scalastic" %% "scalastic" % "0.90.10.1"  withJavadoc() withSources(),
"com.fasterxml.jackson.core" % "jackson-core" % "2.4.2" ,
"com.fasterxml.jackson.core" % "jackson-databind" % "2.4.2" ,
"com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.4.2",
  "com.typesafe.akka" %% "akka-actor" % "2.3.7" withJavadoc() withSources(),
  "com.typesafe.akka" %% "akka-cluster" % "2.3.7")



resolvers += Resolver.sonatypeRepo("snapshots")


unmanagedBase <<= baseDirectory { base => base / "src/main/scala"}

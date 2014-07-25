name := "Organization"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
   "org.hibernate" % "hibernate-core" % "3.6.3.Final",
  "org.hibernate" % "hibernate-entitymanager" % "3.6.3.Final",
  "org.springframework.data" % "spring-data-jpa" % "1.5.3.RELEASE"
)     

play.Project.playJavaSettings

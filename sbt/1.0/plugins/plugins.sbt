// ~/.sbt/0.13/plugins/plugins.sbt

// Adds a `dependencyUpdates` task to check Maven repositories for dependency updates
// http://github.com/rtimush/sbt-updates
addSbtPlugin("com.timushev.sbt" % "sbt-updates" % "0.3.1")

// http://github.com/jrudolph/sbt-dependency-graph
addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.8.2")

// http://github.com/sbt/sbt-license-report
addSbtPlugin("com.typesafe.sbt" % "sbt-license-report" % "1.2.0")

// http://github.com/orrsella/sbt-stats
addSbtPlugin("com.orrsella" % "sbt-stats" % "1.0.7")

// http://github.com/coursier/coursier
addSbtPlugin("io.get-coursier" % "sbt-coursier" % "1.0.0-RC11")

// http://github.com/Duhemm/sbt-errors-summary
addSbtPlugin("org.duhemm" % "sbt-errors-summary" % "0.6.0")

// Creates Eclipse project definitions (.classpath, .project, .settings/)
// http://github.com/typesafehub/sbteclipse
//addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "5.2.2")
// ~/.sbt/0.13/global.sbt

// Statements executed when starting the Scala REPL (sbt's `console` task)
initialCommands := """
import
  scala.annotation.{switch, tailrec}
, scala.beans.{BeanProperty, BooleanBeanProperty}
, scala.collection.JavaConverters._
, scala.collection.{breakOut, mutable}
, scala.concurrent.{Await, ExecutionContext, Future}
, scala.concurrent.ExecutionContext.Implicits.global
, scala.concurrent.duration._
, scala.language.experimental.macros
, scala.math._
, scala.reflect.macros.blackbox
, scala.util.{Failure, Random, Success, Try}
, scala.util.control.NonFatal
, java.io._
, java.net._
, java.nio.file._
, java.time.{Duration => jDuration, _}
, System.{currentTimeMillis => now, nanoTime}

def time[T](f: => T): T = {
  val start = now
  try f finally {
    println("Elapsed: " + (now - start)/1000.0 + " s")
  }
}

def desugarImpl[T](c: blackbox.Context)(expr: c.Expr[T]): c.Expr[Unit] = {
  import c.universe._, scala.io.AnsiColor.{BOLD, GREEN, RESET}

  val exp = show(expr.tree)
  val typ = expr.actualType.toString takeWhile '('.!=

  println(s"$exp: $BOLD$GREEN$typ$RESET")
  reify { (): Unit }
}

def desugar[T](expr: T): Unit = macro desugarImpl[T]
"""

// Share history among all projects instead of using a different history for each project
historyPath := Option(target.in(LocalRootProject).value / ".history")

// Do not exit sbt when Ctrl-C is used to stop a running app
cancelable in Global := true

logLevel in Global := Level.Info
logBuffered in Test := false

showSuccess := true
showTiming := true

// ScalaTest configuration
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest
  // F: show full stack traces
  // S: show short stack traces
  // D: show duration for each test
  // I: print "reminders" of failed and canceled tests at the end of the summary,
  //    eliminating the need to scroll and search to find failed or canceled tests.
  //    replace with G (or T) to show reminders with full (or short) stack traces
  // K: exclude canceled tests from reminder
, "-oDI"
  // enforce chosen testing styles
, "-y", "org.scalatest.FreeSpec"
, "-y", "org.scalatest.AsyncFreeSpec"
  // Periodic notification of slowpokes (tests that have been running longer than 30s)
, "-W", "30", "30"
)

// Enable colors in Scala console (2.11.4+)
initialize ~= { _ =>
  val ansi = System.getProperty("sbt.log.noformat", "false") != "true"
  if (ansi) System.setProperty("scala.color", "true")
}

// Draw a separator between triggered runs (e.g, ~test)
triggeredMessage := { ws =>
  if (ws.count > 1) {
    val ls = System.lineSeparator * 2
    ls + "#" * 80 + ls
  } else ""
}

// Alternative: clear the console between triggered runs
//triggeredMessage := Watched.clearWhenTriggered

shellPrompt := { state =>
  import scala.Console.{BLUE, BOLD, RESET}
  s"$BLUE$BOLD${name.value}$RESET $BOLD\u25b6$RESET "
}

addCommandAlias("cd", "project")
addCommandAlias("ls", "projects")
addCommandAlias("cr", ";clean ;reload")
addCommandAlias("cru", ";clean ;reload ;test:update")
addCommandAlias("du", "dependencyUpdates")
addCommandAlias("rdu", ";reload ;dependencyUpdates")
addCommandAlias("ru", ";reload ;test:update")
addCommandAlias("tc", "test:compile")

// Download and create Eclipse source attachments for library dependencies
//EclipseKeys.withSource := true

// Uncomment to enable offline mode
//offline in ThisBuild := true

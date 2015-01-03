## Play 2.2.6 sbt-plugin standalone

Play 2.2.6 stripped out of its non sbt-plugin related projects,
and whose `play` namespace was renamed to `play22`.

Allows to have sbt projects with both this version of play and another one
for cross-building,
without namespaces colliding.

## Usage

Add to `project/plugins.sbt`:
```scala
resolvers += Resolver.sonatypeRepo("releases")

addSbtPlugin("com.github.alexarchambault.play22sbt" % "sbt-plugin" % "2.2.6")

// Can be used along other versions of play, e.g.
// addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.4.0-M2")
```

Then in your build source, `Build.scala` for example:
```scala
lazy val play22Proj = Project(id="play22-proj", base=file("some-location"))
  .settings(play22.Project.playScalaSettings: _*)

// Play 2.2 elements located in the play22 namespace (instead of simply "play")
```

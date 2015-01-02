package play22

import sbt._
import sbt.Keys._

trait Keys {

  def component(id: String) = "com.typesafe.play" %% id % play22.core.PlayVersion.current

  val playVersion = SettingKey[String]("play22-version")

  val playDefaultPort = SettingKey[Int]("play22-default-port")

  val requireJs = SettingKey[Seq[String]]("play22-require-js")

  val requireJsFolder = SettingKey[String]("play22-require-js-folder")

  val requireJsShim = SettingKey[String]("play22-require-js-shim")

  val requireNativePath = SettingKey[Option[String]]("play22-require-native-path")

  /** Our means of hooking the run task with additional behavior. */
  val playRunHooks = TaskKey[Seq[play22.PlayRunHook]]("play22-run-hooks")

  @deprecated("2.2", "Please use playRunHooks setting instead.")
  val playOnStarted = SettingKey[Seq[(java.net.InetSocketAddress) => Unit]]("play22-onStarted")

  @deprecated("2.2", "Please use playRunHooks setting instead.")
  val playOnStopped = SettingKey[Seq[() => Unit]]("play22-onStopped")

  /** A hook to configure how play blocks on user input while running. */
  val playInteractionMode = SettingKey[play22.PlayInteractionMode]("play22-interaction-mode")

  val playAssetsDirectories = SettingKey[Seq[File]]("play22-assets-directories")

  val playExternalAssets = SettingKey[Seq[(File, File => PathFinder, String)]]("play22-external-assets")

  val confDirectory = SettingKey[File]("play22-conf")

  val templatesImport = SettingKey[Seq[String]]("play22-templates-imports")

  val routesImport = SettingKey[Seq[String]]("play22-routes-imports")

  val generateReverseRouter = SettingKey[Boolean]("play22-generate-reverse-router",
    "Whether the reverse router should be generated. Setting to false may reduce compile times if it's not needed.")

  val namespaceReverseRouter = SettingKey[Boolean]("play22-namespace-reverse-router",
    "Whether the reverse router should be namespaced. Useful if you have many routers that use the same actions.")

  val ebeanEnabled = SettingKey[Boolean]("play22-ebean-enabled")

  val templatesTypes = SettingKey[Map[String, String]]("play22-templates-formats")

  val closureCompilerOptions = SettingKey[Seq[String]]("play22-closure-compiler-options")

  val lessOptions = SettingKey[Seq[String]]("play22-less-options")

  val coffeescriptOptions = SettingKey[Seq[String]]("play22-coffeescript-options")

  val lessEntryPoints = SettingKey[PathFinder]("play22-less-entry-points")

  val coffeescriptEntryPoints = SettingKey[PathFinder]("play22-coffeescript-entry-points")

  val javascriptEntryPoints = SettingKey[PathFinder]("play22-javascript-entry-points")

  val playPlugin = SettingKey[Boolean]("play22-plugin")

  val devSettings = SettingKey[Seq[(String, String)]]("play22-dev-settings")

  val scalaIdePlay2Prefs = TaskKey[Unit]("play22-scala-ide-play2-prefs")

  val defaultScalaTemplatesImport = Seq(
    "models._",
    "controllers._",

    "play.api.i18n._",

    "play.api.mvc._",
    "play.api.data._",

    "views.%format%._")

  val defaultTemplatesImport = Seq("play.api.templates._", "play.api.templates.PlayMagic._")

}
object Keys extends Keys

trait PlayInternalKeys {
  type ClassLoaderCreator = (String, Array[URL], ClassLoader) => ClassLoader

  val playDependencyClasspath = TaskKey[Classpath]("play22-dependency-classpath")
  val playReloaderClasspath = TaskKey[Classpath]("play22-reloader-classpath")
  val playCommonClassloader = TaskKey[ClassLoader]("play22-common-classloader")
  val playDependencyClassLoader = TaskKey[ClassLoaderCreator]("play22-dependency-classloader")
  val playReloaderClassLoader = TaskKey[ClassLoaderCreator]("play22-reloader-classloader")
  val playReload = TaskKey[sbt.inc.Analysis]("play22-reload")
  val buildRequire = TaskKey[Seq[(File, File)]]("play22-build-require-assets")
  val playCompileEverything = TaskKey[Seq[sbt.inc.Analysis]]("play22-compile-everything")
}

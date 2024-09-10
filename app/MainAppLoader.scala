import play.api.inject.guice.{GuiceApplicationBuilder, GuiceApplicationLoader}
import play.api.ApplicationLoader.Context
import play.api.{Configuration, Environment}
import com.qrsof.structureproject.scala.{AppBusinessModuleGuice, DatabaseModule}
class MainAppLoader extends GuiceApplicationLoader {
  override def builder(context: Context): GuiceApplicationBuilder = {
    val configuration: Configuration = context.initialConfiguration
    val environment: Environment = context.environment
    initialBuilder
      .in(environment)
      .loadConfig(configuration)
      .overrides(
        new Module,
        new ModuleGuice(),
        new AppBusinessModuleGuice(),
        new DatabaseModule(configuration)
      )
  }
}
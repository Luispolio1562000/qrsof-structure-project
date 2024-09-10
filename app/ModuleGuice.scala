import com.google.inject.AbstractModule
import controllers.api.skill.{SkillController, SkillControllerImpl}
import jakarta.inject.Singleton
import net.codingwell.scalaguice.ScalaModule
import org.apache.pekko.actor.typed.ActorSystem
import org.apache.pekko.actor.typed.scaladsl.Behaviors 

class ModuleGuice  extends AbstractModule with ScalaModule{
  private val actorSystem: ActorSystem[Nothing] = ActorSystem(Behaviors.empty, "demo-api")
  override def configure(): Unit = {
    bind[ActorSystem[Nothing]].toInstance(actorSystem)
    bind[SkillController].to[SkillControllerImpl].in(classOf[Singleton])
  }
}

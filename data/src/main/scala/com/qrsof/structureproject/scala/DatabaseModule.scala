import com.google.inject.AbstractModule
import controllers.skill.{SkillController, SkillControllerImpl}
import net.codingwell.scalaguice.ScalaModule
import org.apache.pekko.actor.typed.ActorSystem
import org.apache.pekko.actor.typed.scaladsl.Behaviors
import play.api.Configuration


class DatabaseModule (configurations: Configuration)  extends AbstractModule with ScalaModule{

  override def configure(): Unit = {

  }
}




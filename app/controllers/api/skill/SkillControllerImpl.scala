package controllers.api.skill

import com.qrsof.structureproject.scala.admin.skill.SkillService
import com.qrsof.structureproject.scala.admin.skill.models.{CreateSkill, Skill}
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{Action, AnyContent, BaseController, ControllerComponents}
import java.util.UUID
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class SkillControllerImpl @Inject()(val controllerComponents: ControllerComponents, skillService: SkillService)(implicit ec: ExecutionContext) extends BaseController with SkillController {

  override def getSkills(): Action[AnyContent] = Action.async { implicit request =>
    skillService.getSkills().map { skills =>
      Ok(Json.toJson(skills))
    }
  }


  override def getSkillById(id: UUID): Action[AnyContent] = Action.async { implicit request =>
    skillService.getSkillById(id).map {
      case Some(skill) => Ok(Json.toJson(skill))
      case None => NotFound
    }
  }

  override def createSkill: Action[JsValue] = Action(parse.json).async { implicit request =>
    request.body
      .validate[CreateSkill]
      .fold(
        errors => Future {
          BadRequest(errors.mkString)
        },
        newSkill => {
          skillService.createSkill(Skill(UUID.randomUUID(), newSkill.name)).map {
            case Left(_) => BadRequest("Error when creating skill")
            case Right(skill) => Ok(Json.toJson(skill))
          }
        }
      )
  }

}

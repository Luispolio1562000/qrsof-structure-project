package controllers.api.skill

import com.qrsof.structureproject.scala.admin.skill.SkillService
import com.qrsof.structureproject.scala.admin.skill.models.{CreateSkill, Skill}
import play.api.libs.json.{JsError, JsValue, Json}
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

  override def deleteSkillById(id: UUID): Action[AnyContent] = Action.async { implicit request =>
    skillService.deleteSkillById(id).map {
      case 1 => Ok("Ok")
      case 0 => BadRequest("Error when deleting skill")
    }
  }


  override def updateSkillById(id: UUID): Action[JsValue] = Action(parse.json).async { implicit request =>
    request.body
      .validate[Skill]
      .fold(
        errors => Future {
          BadRequest(errors.mkString)
        },
        updateSkill => {
          skillService.updateSkillById(id, updateSkill).map {
            case 1 => Ok("The skill has update successfully")
            case 0 => BadRequest("Error when updating skill")

          }
        }
      )

  }


}

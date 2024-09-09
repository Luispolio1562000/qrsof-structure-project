package controllers.api.skill

import play.api.libs.json.JsValue
import play.api.mvc.*

import java.util.UUID

trait SkillController {
  def getSkills(): Action[AnyContent]

  def getSkillById(id: UUID): Action[AnyContent]

  def createSkill: Action[JsValue]
}

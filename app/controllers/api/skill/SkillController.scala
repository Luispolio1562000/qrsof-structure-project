package controllers.api.skill

import play.api.libs.json.JsValue
import play.api.mvc._

import java.util.UUID

trait SkillController {
  def getSkills(): Action[AnyContent]

  def getSkillById(id: UUID): Action[AnyContent]

  def createSkill: Action[JsValue]
  def deleteSkillById(id: UUID): Action[AnyContent]
  def updateSkillById(id: UUID): Action[JsValue]
}

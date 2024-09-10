package com.qrsof.structureproject.scala.admin.skill.models

import play.api.libs.json.{Json, OFormat}

case class CreateSkill(name: String)

object CreateSkill {
  implicit val createSkillFormat: OFormat[CreateSkill] = Json.format[CreateSkill]
}
package com.qrsof.structureproject.scala.admin.skill.models

import play.api.libs.json.{Json, OFormat}

import java.util.UUID

case class Skill(skill_id: UUID, name: String)

object Skill {
  implicit val skillFormat: OFormat[Skill] = Json.format[Skill]
}
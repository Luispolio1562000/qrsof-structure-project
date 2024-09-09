package com.qrsof.structureproject.scala.skill

import controllers.api.apiError.models.APIError

import java.util.UUID
import scala.concurrent.Future
import com.qrsof.structureproject.scala.skill.models.Skill
import com.qrsof.structureproject.scala.skill.models.APIError


trait SkillService {
  def getSkills(): Future[List[Skill]]
  def getSkillById(id: UUID): Future[Option[Skill]]
  def createSkill(skill: Skill): Future[Either[APIError, Skill]]
}

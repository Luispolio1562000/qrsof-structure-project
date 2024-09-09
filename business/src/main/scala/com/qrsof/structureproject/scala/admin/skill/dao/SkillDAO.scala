package com.qrsof.structureproject.scala.skill.dao

import com.qrsof.structureproject.scala.skill.models.APIError
import com.qrsof.structureproject.scala.skill.models.Skill
import java.util.UUID
import scala.concurrent.Future

trait SkillDAO {
  def getSkills(): Future[List[Skill]]
  def getSkillById(id: UUID): Future[Option[Skill]]
  def createSkill(skill: Skill):Future[Either[APIError, Skill]]
}

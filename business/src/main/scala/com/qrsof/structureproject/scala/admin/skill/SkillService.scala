package com.qrsof.structureproject.scala.admin.skill

import com.qrsof.structureproject.scala.admin.skill.models.{APIError, Skill}

import java.util.UUID
import scala.concurrent.Future


trait SkillService {
  def getSkills(): Future[List[Skill]]
  def getSkillById(id: UUID): Future[Option[Skill]]
  def createSkill(skill: Skill): Future[Either[APIError, Skill]]
  def deleteSkillById(id: UUID): Future[Int]

  def updateSkillById(id: UUID, skill: Skill): Future[Int]
}

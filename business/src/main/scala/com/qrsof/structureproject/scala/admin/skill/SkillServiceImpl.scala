package com.qrsof.structureproject.scala.admin.skill

import com.qrsof.structureproject.scala.admin.skill.dao.SkillDAO
import com.qrsof.structureproject.scala.admin.skill.models.{APIError, Skill}
import java.util.UUID
import javax.inject.{Singleton, Inject}
import scala.concurrent.Future

@Singleton
class SkillServiceImpl @Inject()(skillRepository: SkillDAO) extends SkillService {
  override def getSkills(): Future[List[Skill]] = {
    skillRepository.getSkills()
  }

  override def getSkillById(id: UUID): Future[Option[Skill]] = {
    skillRepository.getSkillById(id)
  }

  override def createSkill(skill: Skill): Future[Either[APIError, Skill]] = {
    skillRepository.createSkill(skill)
  }
  
  
  override def deleteSkillById(id: UUID): Future[Int] = {
    skillRepository.deleteSkillById(id)
  }


  override def updateSkillById(id: UUID, skill: Skill): Future[Int] = {
    skillRepository.updateSkillById(id, skill)
  }


}

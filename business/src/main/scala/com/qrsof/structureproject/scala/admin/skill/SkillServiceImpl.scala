package com.qrsof.structureproject.scala.skill

import controllers.api.apiError.models.APIError
import play.api.db.slick.DatabaseConfigProvider
import java.util.UUID
import com.qrsof.structureproject.scala.skill.models.Skill
import com.qrsof.structureproject.scala.skill.models.APIError
import com.qrsof.structureproject.scala.skill.dao.SkillDAO
import javax.inject.{Singleton, Inject}
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class SkillServiceImpl @Inject()(dbConfigProvider: DatabaseConfigProvider,
                                 databaseExecutionContext: ExecutionContext,
                                 skillRepository: SkillDAO) {
  def getSkills(): Future[List[Skill]] = {
    skillRepository.getSkills()
  }

  def getSkillById(id: UUID): Future[Option[Skill]] = {
    skillRepository.getSkillById(id)
  }

  def createSkill(skill: Skill): Future[Either[APIError, Skill]] = {
    skillRepository.createSkill(skill)
  }


}

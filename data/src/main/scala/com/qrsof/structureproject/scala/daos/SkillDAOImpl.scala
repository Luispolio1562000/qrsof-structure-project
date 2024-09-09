package com.qrsof.structureproject.scala.skill


import com.qrsof.structureproject.scala.skill.models.Skill
import com.qrsof.structureproject.scala.skill.models.APIError
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import play.api.mvc.*
import slick.jdbc.JdbcProfile
import com.qrsof.structureproject.scala.skill.dao.SkillDAO
import java.util.UUID
import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class SkillDAOImpl @Inject()(protected val dbConfigProvider: DatabaseConfigProvider)(implicit executionContext: ExecutionContext) extends HasDatabaseConfigProvider[JdbcProfile] with SkillDAO {

  import profile.api._

  implicit val skillTable = TableQuery[SkillTable]

  //Implementamos las funciones
  override def getSkills(): Future[List[Skill]] = {

    db.run(skillTable.result).map(_.toList)
  }

  override def getSkillById(id: UUID): Future[Option[Skill]] =
  db.run(skillTable.filter(_.id === id).result.headOption)



 override def createSkill(skill: Skill): Future[Either[APIError, Skill]] = {
   try {
     val newSkill =  db.run(skillTable += skill)
     Future{Right(skill)}
   }
   catch {
     case e: Throwable => {
       Future{Left(APIError("Error"))}
     }
   }
 }






  //Definimos la tabla

  class SkillTable(tag: Tag) extends Table[Skill](tag, "skills") {
    def id = column[UUID]("skill_id", O.PrimaryKey, O.AutoInc)

    def name = column[String]("name")

    def * = (id, name).mapTo[Skill]
  }


}

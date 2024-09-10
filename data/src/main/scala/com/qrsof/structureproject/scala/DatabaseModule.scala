package com.qrsof.structureproject.scala

import com.google.inject.AbstractModule
import com.qrsof.structureproject.scala.admin.skill.dao.SkillDAO
import net.codingwell.scalaguice.ScalaModule

import play.api.Configuration
import com.qrsof.structureproject.scala.daos.SkillDAOImpl

import javax.inject.Singleton
class DatabaseModule (configurations: Configuration)  extends AbstractModule with ScalaModule{

  override def configure(): Unit = {
    bind[SkillDAO].to[SkillDAOImpl].in(classOf[Singleton])
  }
}




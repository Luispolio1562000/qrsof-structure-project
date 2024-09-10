package com.qrsof.structureproject.scala
import com.google.inject.AbstractModule
import com.qrsof.structureproject.scala.admin.skill.{SkillService, SkillServiceImpl}
import net.codingwell.scalaguice.ScalaModule
import javax.inject.Singleton
class AppBusinessModuleGuice extends AbstractModule with ScalaModule {

  override def configure(): Unit = {
    bind[SkillService].to[SkillServiceImpl]in(classOf[Singleton])
  }
}
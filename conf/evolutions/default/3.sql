--- !Ups
CREATE TABLE IF NOT EXISTS "skills" (
                                      "skill_id"  BIGINT GENERATED BY DEFAULT AS IDENTITY(START WITH 1) NOT NULL PRIMARY KEY,
                                      "name" VARCHAR (100) NOT NULL
);


--- !Downs
DROP TABLE "skills"
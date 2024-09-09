--- !Ups

INSERT INTO skills ( name)
SELECT 'Python'
WHERE NOT EXISTS (
    SELECT name FROM skills WHERE name = 'Python'
);


INSERT INTO skills (name)
SELECT 'JavaScript'
WHERE NOT EXISTS (
    SELECT name FROM skills WHERE name = 'JavaScript'
);

INSERT INTO skills (name)
SELECT  'Java'
WHERE NOT EXISTS (
    SELECT name FROM skills WHERE name = 'Java'
);

INSERT INTO skills ( name)
SELECT  'C++'
WHERE NOT EXISTS (
    SELECT name FROM skills WHERE name = 'C++'
);

INSERT INTO skills ( name)
SELECT  'SQL'
WHERE NOT EXISTS (
    SELECT name FROM skills WHERE name = 'SQL'
);

--- !Downs
DELETE FROM skills WHERE name IN ('Python', 'JavaScript', 'Java', 'C++', 'SQL');
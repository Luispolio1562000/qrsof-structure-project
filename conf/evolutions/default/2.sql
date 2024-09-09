--- !Ups
INSERT INTO profiles (name, email)
VALUES ('TuNombre', 'tuemail@example.com');
INSERT INTO profiles (name, email)
VALUES ('Nombre1', 'email1@example.com');
INSERT INTO profiles (name, email)
VALUES ('Nombre2', 'email2@example.com');
INSERT INTO profiles (name, email)
VALUES ('Nombre3', 'email3@example.com');
INSERT INTO profiles (name, email)
VALUES ('Nombre30', 'email30@example.com');

--- !Downs
DELETE
FROM profiles
WHERE profile_id = 'UUID generado';
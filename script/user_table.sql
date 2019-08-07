CREATE TABLE -`petro_apiary_db`.`user` (
  `usr_id` INT NOT NULL AUTO_INCREMENT,
  `usr_login` VARCHAR(45) NOT NULL,
  `usr_password` VARCHAR(45) NOT NULL,
  `usr_create_date` DATE NULL,
  `usr_remove_date` DATE NULL,
  `usr_role` VARCHAR(1) NOT NULL DEFAULT 'W',
  PRIMARY KEY (`usr_id`);

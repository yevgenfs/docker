
-- DROP SCHEMA IF EXISTS `mydb` ;

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;
DROP TABLE IF EXISTS `mydb`.`road_has_intermidiad_stop` ;
DROP TABLE IF EXISTS `mydb`.`city` ;
DROP TABLE IF EXISTS `mydb`.`tiket` ;
DROP TABLE IF EXISTS `mydb`.`user_bank` ;
DROP TABLE IF EXISTS `mydb`.`user` ;
DROP TABLE IF EXISTS `mydb`.`bus_has_road` ;
DROP TABLE IF EXISTS `mydb`.`road` ;
DROP TABLE IF EXISTS `mydb`.`drivers` ;
DROP TABLE IF EXISTS `mydb`.`bus` ;
DROP TABLE IF EXISTS `mydb`.`price_multiplier` ;










CREATE TABLE IF NOT EXISTS `mydb`.`price_multiplier` (
  `type_of_bus` CHAR(4) NOT NULL,
  `price_countercol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`type_of_bus`));




CREATE TABLE IF NOT EXISTS `mydb`.`bus` (
  `id_bus` INT NOT NULL AUTO_INCREMENT,
  `bus_number` CHAR(8) NOT NULL,
  `free_seats` INT NULL,
  `type_of_bus` CHAR(4) NOT NULL,
  `departue_date` VARCHAR(45) NOT NULL,
  `return_time` VARCHAR(45) NOT NULL,
  `age` INT NOT NULL,
  `manafacturer` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_bus`, `type_of_bus`),
  INDEX `type_of_bus_idx` (`type_of_bus` ) ,
  UNIQUE INDEX `bus_number_UNIQUE` (`bus_number` ) ,
  CONSTRAINT `type_of_bus`
    FOREIGN KEY (`type_of_bus`)
    REFERENCES `mydb`.`price_multiplier` (`type_of_bus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE IF NOT EXISTS `mydb`.`drivers` (
  `id_driver` INT NOT NULL AUTO_INCREMENT,
  `name` CHAR(50) NOT NULL,
  `bus_number` CHAR(8) NOT NULL,
  `phone_number` VARCHAR(45) NULL,
  `last_driven_bus` CHAR(8) NULL,
  `number_of_bus_changed` INT NULL,
  PRIMARY KEY (`id_driver`),
  INDEX `fk_drivers_bus_list_idx` (`bus_number` ) ,
  CONSTRAINT `fk_drivers_bus_list`
    FOREIGN KEY (`bus_number`)
    REFERENCES `mydb`.`bus` (`bus_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE IF NOT EXISTS `mydb`.`road` (
  `id_road` INT NOT NULL AUTO_INCREMENT,
  `mileage_of_road` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_road`));


CREATE TABLE IF NOT EXISTS `mydb`.`bus_has_road` (
  `bus_id_bus` INT NOT NULL,
  `road_id_road` INT NOT NULL,
  PRIMARY KEY (`bus_id_bus`, `road_id_road`),
  INDEX `fk_bus_has_road_road1_idx` (`road_id_road` ) ,
  INDEX `fk_bus_has_road_bus1_idx` (`bus_id_bus` ) ,
  CONSTRAINT `fk_bus_has_road_bus1`
    FOREIGN KEY (`bus_id_bus`)
    REFERENCES `mydb`.`bus` (`id_bus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bus_has_road_road1`
    FOREIGN KEY (`road_id_road`)
    REFERENCES `mydb`.`road` (`id_road`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



CREATE TABLE IF NOT EXISTS `mydb`.`user` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `phone_number` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE INDEX `phone_number_UNIQUE` (`phone_number` ) );



CREATE TABLE IF NOT EXISTS `mydb`.`user_bank` (
  `user_iduser` INT NOT NULL,
  `number_of_bank_account` INT NULL,
  PRIMARY KEY (`user_iduser`),
  INDEX `fk_user_bank_user1_idx` (`user_iduser` ) ,
  CONSTRAINT `fk_user_bank_user1`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `mydb`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE IF NOT EXISTS `mydb`.`tiket` (
  `idorder` INT NOT NULL AUTO_INCREMENT,
  `ticet_for_man` CHAR(3) NULL,
  `ticet_for_children` CHAR(3) NULL,
  `ticets_for_disable_people` CHAR(3) NULL,
  `extra_lugage` INT NULL,
  `user_iduser` INT NOT NULL,
  `price` DECIMAL(10) NOT NULL,
  `bus_id_bus` INT NOT NULL,
  `bus_type_of_bus` CHAR(4) NOT NULL,
  PRIMARY KEY (`idorder`, `user_iduser`, `bus_id_bus`, `bus_type_of_bus`),
  INDEX `fk_order_preparation_user1_idx` (`user_iduser` ) ,
  INDEX `fk_order_preparation_bus1_idx` (`bus_id_bus` , `bus_type_of_bus` ) ,
  CONSTRAINT `fk_order_preparation_user1`
    FOREIGN KEY (`user_iduser`)
    REFERENCES `mydb`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_preparation_bus1`
    FOREIGN KEY (`bus_id_bus` , `bus_type_of_bus`)
    REFERENCES `mydb`.`bus` (`id_bus` , `type_of_bus`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);




CREATE TABLE IF NOT EXISTS `mydb`.`city` (
  `idcity` INT NOT NULL AUTO_INCREMENT,
  `city_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcity`),
  UNIQUE INDEX `city_name_UNIQUE` (`city_name` ) );



CREATE TABLE IF NOT EXISTS `mydb`.`road_has_intermidiad_stop` (
  `road_id_road` INT NOT NULL,
  `stop_idcity` INT NOT NULL,
  `number_of_stop` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`road_id_road`, `stop_idcity`),
  INDEX `fk_road_has_intermidiad_stop_intermidiad_stop1_idx` (`stop_idcity` ) ,
  INDEX `fk_road_has_intermidiad_stop_road1_idx` (`road_id_road` ) ,
  CONSTRAINT `fk_road_has_intermidiad_stop_road1`
    FOREIGN KEY (`road_id_road`)
    REFERENCES `mydb`.`road` (`id_road`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_road_has_intermidiad_stop_intermidiad_stop1`
    FOREIGN KEY (`stop_idcity`)
    REFERENCES `mydb`.`city` (`idcity`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO user (iduser, phone_number,first_name,last_name) VALUES
(1,380633803211,'lviv','pav'),
(2,380633803219,'andriy','sat'),
(3,380633803218,'virus','lviv'),
(4,380633803217,'andriy','vlad'),
(5,380633803216,'yevhen','pav'),
(6,380633803215,'vlad','pav'),
(7,380633803214,'yevhen','Surkov'),
(8,380633803213,'zenoviy','virus'),
(9,380633803212,'zenoviy','pav'),
(10,380633803210,'andriy','virus');
INSERT INTO user_bank ( user_iduser, number_of_bank_account) VALUES
(1,380633),
(2, 380633),
(3, 380633),
(4, 380633),
(5, 38063),
(6, 380633),
(7, 380633),
(8, 38063),
(9, 380633),
(10, 3806);
INSERT INTO city ( idcity, city_name) VALUES
(1,'Lviv'),
(2, 'London'),
(3, 'Paris'),
(4, 'Dublin'),
(5, 'Alba'),
(6, 'califonia'),
(7, 'Kiyv'),
(8, 'Aldorf'),
(9, 'Danzig'),
(10, 'Kategat');



INSERT INTO road ( id_road, mileage_of_road) VALUES
(1,5),
(2, 546),
(3, 6),
(4, 5464),
(5, 453),
(6, 353),
(7, 53),
(8, 34),
(9, 4),
(10, 35);

INSERT INTO road_has_intermidiad_stop ( road_id_road, stop_idcity,number_of_stop) VALUES
(1,5,1),
(1, 1,2),
(3, 2,3),
(4, 3,4),
(5, 4,5),
(6, 6,6),
(7, 7,7),
(8, 9,8),
(9, 8,9),
(10, 10,10);

INSERT INTO price_multiplier ( type_of_bus, price_countercol) VALUES
('own',2),
('rent',3);



INSERT INTO bus ( id_bus, bus_number,free_seats,type_of_bus,departue_date,return_time,age,manafacturer) VALUES
(1,'bc4511aa',50,'own','2011-04-12T00:00:00.000'  ,'2012-04-12T00:00:00.000',2000,'BMW'),
(2, 'bc4510aa',50,'rent','2011-04-12T00:00:00.000','2012-04-12T00:00:00.000',2000,'BMW'),
(3, 'bc4519aa',50,'rent','2011-04-12T00:00:00.000','2012-04-12T00:00:00.000',2000,'BMW'),
(4, 'bc4518aa',50,'rent','2011-04-12T00:00:00.000','2012-04-12T00:00:00.000',2000,'BMW'),
(5, 'bc4517aa',50,'rent','2011-04-12T00:00:00.000','2012-04-12T00:00:00.000',2000,'BMW'),
(6, 'bc4516aa',50,'own','2011-04-12T00:00:00.000' ,'2012-04-12T00:00:00.000',2000,'BMW'),
(7, 'bc4515aa',50,'own','2011-04-12T00:00:00.000' ,'2012-04-12T00:00:00.000',2000,'BMW'),
(8, 'bc4514aa',50,'own','2011-04-12T00:00:00.000' ,'2012-04-12T00:00:00.000',2000,'BMW'),
(9, 'bc4513aa',50,'own','2011-04-12T00:00:00.000' ,'2012-04-12T00:00:00.000',2000,'BMW'),
(10, 'bc4512aa',50,'own','2011-04-12T00:00:00.000','2012-04-12T00:00:00.000',2000,'BMW');




INSERT INTO bus_has_road ( bus_id_bus, road_id_road) VALUES
(1,1),
(1, 2),
(3, 3),
(4, 4),
(5,5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10);






INSERT INTO tiket ( idorder, ticet_for_man,ticet_for_children,ticets_for_disable_people,extra_lugage,user_iduser,price,bus_id_bus,bus_type_of_bus) VALUES
(1,'yes','no','no',5,1,2000,2,'rent'),
(2,'yes','no','no',5, 2,2000,3,'rent'),
(3, 'yes','no','no',5,3,2000,4,'rent'),
(4, 'yes','no','no',5,4,2000,5,'rent'),
(5, 'yes','no','no',5,5,2000,2,'rent'),
(6, 'no','no','yes',5,6,2000,1,'own'),
(7, 'no','no','yes',5,7,000,7,'own'),
(8, 'no','no','yes',5,8,2000,8,'own'),
(9, 'no','no','yes',5,9,2000,9,'own'),
(10, 'no','no','yes',5,10,2000,10,'own');

INSERT INTO drivers ( id_driver, name,bus_number,phone_number,last_driven_bus,number_of_bus_changed) VALUES
(1,'igor','bc4511aa',3535657,'bc4511aa',2000),
(2,'igors', 'bc4510aa',3535656,'bc4511ab',2000),
(3, 'igorss','bc4519aa',3535655,'bc4511ac',2000),
(4, 'igorsss','bc4519aa',3535654,'bc4511ad',2000),
(5, 'igor3','bc4519aa',3535652,'bc4511af',2000),
(6, 'igor4','bc4519aa',3535653,'bc4511ae',2000),
(7, 'igor5','bc4519aa',3535651,'bc4511ag',000),
(8, 'igor6','bc4519aa',3535658,'bc4511ah',2000),
(9, 'igor7','bc4519aa',3535659,'bc4511aj',2000),
(10, 'igo8r','bc4519aa',3535650,'bc4511ak',2000);





CREATE SCHEMA IF NOT EXISTS `company` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;

CREATE TABLE IF NOT EXISTS `company`.`department` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
  `department_name` VARCHAR(255) NULL DEFAULT NULL,
  `status` BIT(1) NULL DEFAULT NULL,
 PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `company`.`workers` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `age` INT(11) NULL DEFAULT NULL,
 `availability` ENUM('FULL_TIME','PART_TIME') NULL DEFAULT NULL,
 `full_name` VARCHAR(255) NULL DEFAULT NULL,
  `departmentId_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKedchn47yy1beede8be2ianbhe` (`departmentId_id` ASC) VISIBLE,
  CONSTRAINT `FKedchn47yy1beede8be2ianbhe`
 FOREIGN KEY (`departmentId_id`)
 REFERENCES `company`.`department` (`id`))

ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO company.department(department_name, status) values('tecnical',true);

INSERT INTO company.department(department_name, status) values('biology',true);

INSERT INTO company.department(department_name, status) values('chemistry',true);

INSERT INTO company.department(department_name, status) values('physycs',true);

INSERT INTO company.department(department_name, status) values('math',true);


INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(22,'FULL_TIME',"Ivan_Lol", 2);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(32,'PART_TIME',"Ola_Senior", 1);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(54,'FULL_TIME',"Taras_Abc", 3);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(19,'PART_TIME',"Cros_Init", 4);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(45,'FULL_TIME',"Arnold_Shvar", 5);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(22,'FULL_TIME',"Mike_Haliley", 1);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(35,'PART_TIME',"Ira_Tkhir", 2);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(41,'FULL_TIME',"Nastya_Prava", 3);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(35,'FULL_TIME',"Olya_Pypka", 4);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(18,'PART_TIME',"Maryana_Hello", 4);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(44,'FULL_TIME',"Oleh_Entity", 5);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(27,'PART_TIME',"Hyan_Pablo", 3);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(30,'FULL_TIME',"Inna_Rasta", 2);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(54,'FULL_TIME',"Joe_Axe", 3);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(34,'FULL_TIME',"Ros_Geller", 1);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(17,'PART_TIME',"Dood_Dood", 3);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(27,'FULL_TIME',"Albert_Innera", 1);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(30,'PART_TIME',"Ivan_Portnow", 3);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(37,'FULL_TIME',"Ira_Isuzy", 4);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(22,'PART_TIME',"Oleh_Zinova", 5);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(37,'FULL_TIME',"Vasya_Zayac", 1);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(22,'PART_TIME',"Ivan_Brom", 2);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(40,'FULL_TIME',"Oleh_Gitler", 2);

INSERT INTO company.workers(age, availability, full_name, departmentId_id) values(23,'FULL_TIME',"Ivan_Stalin", 4);

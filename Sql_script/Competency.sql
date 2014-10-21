drop schema COMPETENCY;

CREATE SCHEMA COMPETENCY;

USE COMPETENCY;

CREATE TABLE EMPLOYEE (
EMPLOYEE_ID INT(7)  NOT NULL,
EMPLOYEE_FIRST_NAME VARCHAR(50),
EMPLOYEE_LAST_NAME VARCHAR(50),
EMPLOYEE_TYPE VARCHAR(50),
CONSTRAINT PK_EMPLOYEE PRIMARY KEY (EMPLOYEE_ID)
);

desc EMPLOYEE;

EMPLOYEE_FISRT_NAME

INSERT INTO `competency`.`employee` (`EMPLOYEE_ID`, `EMPLOYEE_TYPE`, `EMPLOYEE_LAST_NAME`, `EMPLOYEE_FIRST_NAME`) VALUES ('151988', 'mentee', 'palmal', 'souravl');
INSERT INTO `competency`.`employee` (`EMPLOYEE_ID`, `EMPLOYEE_TYPE`, `EMPLOYEE_LAST_NAME`, `EMPLOYEE_FIRST_NAME`) VALUES ('141563', 'mentee', 'mazumdar', 'sugata');
INSERT INTO `competency`.`employee` (`EMPLOYEE_ID`, `EMPLOYEE_TYPE`, `EMPLOYEE_LAST_NAME`, `EMPLOYEE_FIRST_NAME`) VALUES ('151138', 'mentee', 'muninarayana', 'vishwas');
INSERT INTO `competency`.`employee` (`EMPLOYEE_ID`, `EMPLOYEE_TYPE`, `EMPLOYEE_LAST_NAME`, `EMPLOYEE_FIRST_NAME`) VALUES ('151190', 'mentee', 'singh', 'barun');
INSERT INTO `competency`.`employee` (`EMPLOYEE_ID`, `EMPLOYEE_TYPE`, `EMPLOYEE_LAST_NAME`, `EMPLOYEE_FIRST_NAME`) VALUES ('151189', 'mentee', 'sadhu', 'arghya');
INSERT INTO `competency`.`employee` (`EMPLOYEE_ID`, `EMPLOYEE_TYPE`, `EMPLOYEE_LAST_NAME`, `EMPLOYEE_FIRST_NAME`) VALUES ('131145', 'mentee', 'shukla', 'gaurav');


SELECT * FROM EMPLOYEE;

CREATE TABLE SKILL (
SKILL_ID INT(5) NOT NULL,
SKILL_NAME VARCHAR(50),
CONSTRAINT PK_SKILL PRIMARY KEY (SKILL_ID)
);
INSERT INTO `competency`.`skill` (`SKILL_ID`, `SKILL_NAME`) VALUES ('1', 'Spring Web - MVC');
INSERT INTO `competency`.`skill` (`SKILL_ID`, `SKILL_NAME`) VALUES ('2', 'Spring Integration');
INSERT INTO `competency`.`skill` (`SKILL_ID`, `SKILL_NAME`) VALUES ('3', 'Spring AMQP - Rabbit MQ');
INSERT INTO `competency`.`skill` (`SKILL_ID`, `SKILL_NAME`) VALUES ('4', 'In Memory DB (*Fire)');
INSERT INTO `competency`.`skill` (`SKILL_ID`, `SKILL_NAME`) VALUES ('5', 'Tomcat server');
INSERT INTO `competency`.`skill` (`SKILL_ID`, `SKILL_NAME`) VALUES ('6', 'Spring Data - JPA');
INSERT INTO `competency`.`skill` (`SKILL_ID`, `SKILL_NAME`) VALUES ('7', 'Spring security');
INSERT INTO `competency`.`skill` (`SKILL_ID`, `SKILL_NAME`) VALUES ('8', 'Spring REST');
INSERT INTO `competency`.`skill` (`SKILL_ID`, `SKILL_NAME`) VALUES ('9', 'Spring Remoting');
INSERT INTO `competency`.`skill` (`SKILL_ID`, `SKILL_NAME`) VALUES ('10', 'Spring web services');
INSERT INTO `competency`.`skill` (`SKILL_ID`, `SKILL_NAME`) VALUES ('11', 'Spring Batch');
INSERT INTO `competency`.`skill` (`SKILL_ID`, `SKILL_NAME`) VALUES ('12', 'Spring JMS');
INSERT INTO `competency`.`skill` (`SKILL_ID`, `SKILL_NAME`) VALUES ('13', 'Spring Core');
INSERT INTO `competency`.`skill` (`SKILL_ID`, `SKILL_NAME`) VALUES ('14', 'Messaging');
INSERT INTO `competency`.`skill` (`SKILL_ID`, `SKILL_NAME`) VALUES ('15', 'CloudFoundry');
INSERT INTO `competency`.`skill` (`SKILL_ID`, `SKILL_NAME`) VALUES ('16', 'Architecure & Design');
INSERT INTO `competency`.`skill` (`SKILL_ID`, `SKILL_NAME`) VALUES ('17', 'Testing');
INSERT INTO `competency`.`skill` (`SKILL_ID`, `SKILL_NAME`) VALUES ('18', 'Performance Testing');
INSERT INTO `competency`.`skill` (`SKILL_ID`, `SKILL_NAME`) VALUES ('19', 'Build & Deployment Tools');


SELECT * FROM SKILL;

CREATE TABLE EMPLOYEE_SKILL (
EMPLOYEE_ID INTEGER NOT NULL,
SKILL_ID INTEGER NOT NULL,
EMPLOYEE_SKILL_RATING INTEGER(5),
START_DURATION DATE,
END_DURATION DATE,
CONSTRAINT PK_EMPLOYEE_SKILL PRIMARY KEY (EMPLOYEE_ID,SKILL_ID,EMPLOYEE_SKILL_RATING),
CONSTRAINT FK_EMPLOYEE FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE (EMPLOYEE_ID),
CONSTRAINT FK_SKILL FOREIGN KEY (SKILL_ID) REFERENCES SKILL (SKILL_ID)
);


INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('141563', '1', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('141563', '2', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('141563', '3', '1');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('141563', '4', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('141563', '5', '3');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('141563', '6', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('141563', '7', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('141563', '8', '3');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('141563', '9', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('141563', '10', '1');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('141563', '11', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('141563', '12', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('141563', '13', '3');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('141563', '14', '1');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('141563', '15', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('141563', '16', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('141563', '17', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('141563', '18', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('141563', '19', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151138', '1', '3');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151138', '2', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151138', '3', '3');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151138', '4', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151138', '5', '3');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151138', '6', '3');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151138', '7', '1');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151138', '8', '3');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151138', '9', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151138', '10', '1');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151138', '11', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151138', '12', '3');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151138', '13', '3');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151138', '14', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151138', '15', '1');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151138', '16', '1');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151138', '17', '3');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151138', '18', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151138', '19', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151988', '1', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151988', '2', '1');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151988', '3', '1');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151988', '4', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151988', '5', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151988', '6', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151988', '7', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151988', '8', '3');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151988', '9', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151988', '10', '1');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151988', '11', '1');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151988', '12', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151988', '13', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151988', '14', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151988', '15', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151988', '16', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151988', '17', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151988', '18', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151988', '19', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151190', '1', '3');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151190', '2', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151190', '3', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151190', '4', '1');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151190', '5', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151190', '6', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151190', '7', '1');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151190', '8', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151190', '9', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151190', '10', '1');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151190', '11', '1');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151190', '12', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151190', '13', '3');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151190', '14', '1');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151190', '15', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151190', '16', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151190', '17', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151190', '18', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151190', '19', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151189', '1', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151189', '2', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151189', '3', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151189', '4', '3');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151189', '5', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151189', '6', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151189', '7', '1');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151189', '8', '1');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151189', '9', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151189', '10', '1');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151189', '11', '1');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151189', '12', '1');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151189', '13', '3');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151189', '14', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151189', '15', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151189', '16', '1');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151189', '17', '2');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151189', '18', '0');
INSERT INTO `competency`.`employee_skill` (`EMPLOYEE_ID`, `SKILL_ID`, `EMPLOYEE_SKILL_RATING`) VALUES ('151189', '19', '1');

SELECT * FROM EMPLOYEE_SKILL;


CREATE TABLE MENTOR_MENTEE (
MENTOR_ID INT NOT NULL,
MENTEE_ID INT ,
CONSTRAINT FK_MENTOR FOREIGN KEY (MENTOR_ID) REFERENCES EMPLOYEE (EMPLOYEE_ID),
CONSTRAINT FK_MENTEE FOREIGN KEY (MENTEE_ID) REFERENCES EMPLOYEE (EMPLOYEE_ID)
);


insert into mentor_mentee values(131145,151988);
insert into mentor_mentee values(131145,151190);
insert into mentor_mentee values(131145,151189);
insert into mentor_mentee values(131145,151138);
insert into mentor_mentee values(131145,141563);


SELECT * FROM MENTOR_MENTEE
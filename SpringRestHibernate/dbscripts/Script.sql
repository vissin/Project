CREATE TABLE `chemist` (
 `ID` bigint(20) NOT NULL,
 `NAME` varchar(225) DEFAULT NULL,
 `MOBILE` bigint(20) DEFAULT NULL,
 `EMAIL` varchar(225) DEFAULT NULL,
 `USER_ID` varchar(20) NOT NULL,
 `PASSWORD` varchar(225) DEFAULT NULL,
 `ADDRESS` varchar(300) DEFAULT NULL,
 `userId` bigint(20) NOT NULL,
 PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `doctor` (
 `ID` bigint(20) NOT NULL,
 `NAME` varchar(225) DEFAULT NULL,
 `MOBILE` bigint(20) DEFAULT NULL,
 `EMAIL` varchar(225) DEFAULT NULL,
 `USER_ID` varchar(20) NOT NULL,
 `PASSWORD` varchar(225) DEFAULT NULL,
 `userId` bigint(20) NOT NULL,
 PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `patient` (
 `ID` bigint(20) NOT NULL AUTO_INCREMENT,
 `NAME` varchar(225) DEFAULT NULL,
 `BIRTH_DATE` datetime DEFAULT NULL,
 `MOBILE` bigint(20) DEFAULT NULL,
 `GENDER` int(1) DEFAULT NULL,
 `USER_ID` varchar(20) NOT NULL,
 `PASSWORD` varchar(225) DEFAULT NULL,
 `birthDate` date DEFAULT NULL,
 `userId` bigint(20) NOT NULL,
 PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


CREATE TABLE `prescription` (
 `ID` bigint(225) NOT NULL,
 `MEDICINE` varchar(225) DEFAULT NULL,
 `DOSAGE` varchar(225) DEFAULT NULL,
 `DAYS` bigint(20) DEFAULT NULL,
 `TIMES` bigint(20) DEFAULT NULL,
 `VISITID` bigint(20) unsigned NOT NULL,
 `PROVIDED` bit(1) DEFAULT NULL,
 PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `user` (
 `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
 `NAME` varchar(45) NOT NULL,
 `PASSWORD` varchar(45) NOT NULL,
 `ROLE` varchar(5) NOT NULL,
 PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


CREATE TABLE `visit` (
 `ID` bigint(20) NOT NULL AUTO_INCREMENT,
 `PATIENT_ID` bigint(20) NOT NULL,
 `DOCTOR_ID` bigint(20) NOT NULL,
 `WEIGHT` varchar(10) DEFAULT NULL,
 `HEIGHT` float DEFAULT NULL,
 `BP` varchar(20) DEFAULT NULL,
 `VISIT_DATE` datetime NOT NULL,
 `TEMPERATURE` bigint(225) DEFAULT NULL,
 `PRESCRIPTION_ID` varchar(225) NOT NULL,
 `bloodPressure` varchar(255) DEFAULT NULL,
 `doctorId` varchar(255) DEFAULT NULL,
 `patientId` varchar(255) DEFAULT NULL,
 `prescriptionId` varchar(255) DEFAULT NULL,
 `purchaseFlag` bit(1) NOT NULL,
 `visitDate` date DEFAULT NULL,
 PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 12, 2024 at 05:55 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cms`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `AdminID` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`AdminID`, `Username`, `Password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `admindetails`
--

CREATE TABLE `admindetails` (
  `AdminID` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `DOB` date NOT NULL,
  `PhoneNumber` bigint(10) NOT NULL,
  `EmailAddress` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admindetails`
--

INSERT INTO `admindetails` (`AdminID`, `Name`, `DOB`, `PhoneNumber`, `EmailAddress`) VALUES
(1, 'Prajal Tusi', '2001-06-16', 9861324258, 'uzumakiprajal@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `assigment`
--

CREATE TABLE `assigment` (
  `AssignmentID` int(11) NOT NULL,
  `Question` varchar(255) NOT NULL,
  `Module` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `assigment`
--

INSERT INTO `assigment` (`AssignmentID`, `Question`, `Module`) VALUES
(2, 'What is Data?', 'AI'),
(4, 'What is OOP?', 'OOP'),
(5, 'What is Inheritance?', 'OOP'),
(9, 'What is concurrency?', 'NMC');

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `Courseid` int(10) NOT NULL,
  `CourseName` varchar(255) NOT NULL,
  `CourseDescription` varchar(255) NOT NULL,
  `NoofModules` int(10) NOT NULL,
  `Status` varchar(255) NOT NULL,
  `Duration` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`Courseid`, `CourseName`, `CourseDescription`, `NoofModules`, `Status`, `Duration`) VALUES
(1, 'BIT', 'ComputerScience', 8, 'Enabled', 3),
(4, 'IMBA', 'mastersinbusiness', 10, 'Disabled', 3),
(11, 'Bibm', 'Business', 6, 'Enabled', 8),
(15, 'MIT', 'masters in technology', 8, 'Disabled', 2);

-- --------------------------------------------------------

--
-- Table structure for table `logindetails`
--

CREATE TABLE `logindetails` (
  `LoginId` int(11) NOT NULL,
  `UniID` int(11) DEFAULT NULL,
  `UserTypeId` int(11) NOT NULL,
  `UserName` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `logindetails`
--

INSERT INTO `logindetails` (`LoginId`, `UniID`, `UserTypeId`, `UserName`, `Password`) VALUES
(10, NULL, 1, 'admin', 'admin'),
(13, NULL, 2, 'teacher', 'teacher'),
(15, 1234567, 3, 'prajal', 'prajal'),
(16, 1234567, 3, 'rohan', 'rohan'),
(17, 9876547, 3, 'random', 'random'),
(21, 234, 3, 'uzupraz', 'uzupraz');

-- --------------------------------------------------------

--
-- Table structure for table `module`
--

CREATE TABLE `module` (
  `ModuleID` int(10) NOT NULL,
  `CourseID` int(10) NOT NULL,
  `ModuleName` varchar(255) NOT NULL,
  `Module Leader` varchar(255) NOT NULL,
  `Level` varchar(255) NOT NULL,
  `Semester` varchar(255) NOT NULL,
  `Credithour` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `module`
--

INSERT INTO `module` (`ModuleID`, `CourseID`, `ModuleName`, `Module Leader`, `Level`, `Semester`, `Credithour`) VALUES
(1, 1, 'OOP', 'Raj Shrestha', '5', '3', '60'),
(3, 4, 'Business Administration', 'Sakar Shrestha123', '5', '3', '30');

-- --------------------------------------------------------

--
-- Table structure for table `stdsubmission`
--

CREATE TABLE `stdsubmission` (
  `SubmissionID` int(11) NOT NULL,
  `AssignmentID` int(11) NOT NULL,
  `Module` varchar(255) NOT NULL,
  `StudentID` int(11) NOT NULL,
  `UniID` int(11) NOT NULL,
  `StudentName` varchar(255) NOT NULL,
  `Question` varchar(255) NOT NULL,
  `Answer` varchar(255) NOT NULL,
  `Marks` varchar(255) NOT NULL,
  `Published` varchar(255) NOT NULL,
  `Status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `stdsubmission`
--

INSERT INTO `stdsubmission` (`SubmissionID`, `AssignmentID`, `Module`, `StudentID`, `UniID`, `StudentName`, `Question`, `Answer`, `Marks`, `Published`, `Status`) VALUES
(10, 9, 'NMC', 14, 22234, 'ElonMusk', 'What is concurrency?', 'Concurrency is one of the method of doing task where the task seems to being handled parallely but not.', '', 'false', 'failed'),
(11, 2, 'AI', 15, 1234567, 'Prajal Tulsi', 'What is Data?', 'idk', '100', 'true', 'passed');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `StudentID` bigint(100) NOT NULL,
  `UniID` bigint(100) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`StudentID`, `UniID`, `Username`, `Password`) VALUES
(14, 22234, 'Elon123', '123');

-- --------------------------------------------------------

--
-- Table structure for table `studentdetails`
--

CREATE TABLE `studentdetails` (
  `StudentDetailsId` int(100) NOT NULL,
  `StudentID` bigint(100) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Phonenumber` bigint(100) NOT NULL,
  `Emailaddress` varchar(255) NOT NULL,
  `DOB` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Gender` varchar(255) NOT NULL,
  `Level` int(100) NOT NULL,
  `Semester` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `studentdetails`
--

INSERT INTO `studentdetails` (`StudentDetailsId`, `StudentID`, `Name`, `Phonenumber`, `Emailaddress`, `DOB`, `Address`, `Gender`, `Level`, `Semester`) VALUES
(6, 14, 'ElonMusk', 12312, 'elonmusk@gmail.com', 'Wed Feb 15 13:22:04 NPT 2023', 'Silicon Valley', 'Male', 5, 4),
(9, 7, 'query', 34534, 'query', 'Sun Feb 11 00:35:20 NPT 2024', 'query', 'Male', 4, 4),
(10, 8, 'studentdetails', 45654, 'studentdetails', 'Sun Feb 11 00:44:48 NPT 2024', 'studentdetails', 'Male', 4, 4),
(11, 15, 'Prajal Tulsi', 123456789, 'uzu@gmail.com', 'Sat Jun 16 00:00:00 NPT 2001', 'Bhaktapur', 'Male', 5, 5),
(12, 16, 'Rohan Pradhan', 1234567890, 'rohan@pradhan.com', 'Tue Feb 20 09:35:55 NPT 2024', 'thamel', 'Male', 5, 3),
(13, 17, 'Random', 1234567890, 'random@gmail.com', 'Thu Feb 01 00:00:00 NPT 2024', 'kdjflksjdf', 'Male', 4, 1);

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `TeacherID` int(11) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`TeacherID`, `Username`, `Password`) VALUES
(28, 'Raj123', '12345678'),
(29, 'anupam', 'anupam');

-- --------------------------------------------------------

--
-- Table structure for table `teacherdetails`
--

CREATE TABLE `teacherdetails` (
  `TeacherDetailsID` int(11) NOT NULL,
  `TeacherID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `DOB` varchar(255) NOT NULL,
  `Phonenumber` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `EmailAddress` varchar(255) NOT NULL,
  `Module` varchar(255) NOT NULL,
  `Qualification` varchar(255) NOT NULL,
  `Position` varchar(255) NOT NULL,
  `Gender` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `teacherdetails`
--

INSERT INTO `teacherdetails` (`TeacherDetailsID`, `TeacherID`, `Name`, `DOB`, `Phonenumber`, `Address`, `EmailAddress`, `Module`, `Qualification`, `Position`, `Gender`) VALUES
(23, 28, 'Raj Shrestha', 'Mon Feb 05 13:44:24 NPT 1996', '9823345678', 'Kathmandu', 'raj@gmail.com', 'OOP', 'Masters in IT', 'Tutor', 'Male'),
(24, 29, 'anupam', 'Sat Feb 10 21:16:51 NPT 2024', 'anupam', 'anupam', 'anupam', 'anupam', 'anupam', 'anupam', 'Male');

-- --------------------------------------------------------

--
-- Table structure for table `usertype`
--

CREATE TABLE `usertype` (
  `UserTypeId` int(11) NOT NULL,
  `UserTypeName` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `usertype`
--

INSERT INTO `usertype` (`UserTypeId`, `UserTypeName`) VALUES
(1, 'Admin'),
(2, 'Teacher'),
(3, 'Student');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`AdminID`);

--
-- Indexes for table `admindetails`
--
ALTER TABLE `admindetails`
  ADD KEY `AdminID` (`AdminID`);

--
-- Indexes for table `assigment`
--
ALTER TABLE `assigment`
  ADD PRIMARY KEY (`AssignmentID`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`Courseid`);

--
-- Indexes for table `logindetails`
--
ALTER TABLE `logindetails`
  ADD PRIMARY KEY (`LoginId`),
  ADD KEY `UserTypeId` (`UserTypeId`);

--
-- Indexes for table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`ModuleID`),
  ADD KEY `CourseID` (`CourseID`);

--
-- Indexes for table `stdsubmission`
--
ALTER TABLE `stdsubmission`
  ADD PRIMARY KEY (`SubmissionID`),
  ADD KEY `AssignmentID` (`AssignmentID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`StudentID`);

--
-- Indexes for table `studentdetails`
--
ALTER TABLE `studentdetails`
  ADD PRIMARY KEY (`StudentDetailsId`),
  ADD KEY `StudentID` (`StudentID`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`TeacherID`);

--
-- Indexes for table `teacherdetails`
--
ALTER TABLE `teacherdetails`
  ADD PRIMARY KEY (`TeacherDetailsID`),
  ADD KEY `TeacherID` (`TeacherID`);

--
-- Indexes for table `usertype`
--
ALTER TABLE `usertype`
  ADD PRIMARY KEY (`UserTypeId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `AdminID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `assigment`
--
ALTER TABLE `assigment`
  MODIFY `AssignmentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `Courseid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `logindetails`
--
ALTER TABLE `logindetails`
  MODIFY `LoginId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `module`
--
ALTER TABLE `module`
  MODIFY `ModuleID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `stdsubmission`
--
ALTER TABLE `stdsubmission`
  MODIFY `SubmissionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `StudentID` bigint(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `studentdetails`
--
ALTER TABLE `studentdetails`
  MODIFY `StudentDetailsId` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `teacher`
--
ALTER TABLE `teacher`
  MODIFY `TeacherID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `teacherdetails`
--
ALTER TABLE `teacherdetails`
  MODIFY `TeacherDetailsID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `usertype`
--
ALTER TABLE `usertype`
  MODIFY `UserTypeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `admin_ibfk_1` FOREIGN KEY (`AdminID`) REFERENCES `admindetails` (`AdminID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `logindetails`
--
ALTER TABLE `logindetails`
  ADD CONSTRAINT `logindetails_ibfk_1` FOREIGN KEY (`UserTypeId`) REFERENCES `usertype` (`UserTypeId`);

--
-- Constraints for table `module`
--
ALTER TABLE `module`
  ADD CONSTRAINT `CourseID` FOREIGN KEY (`CourseID`) REFERENCES `course` (`Courseid`);

--
-- Constraints for table `stdsubmission`
--
ALTER TABLE `stdsubmission`
  ADD CONSTRAINT `AssignmentID` FOREIGN KEY (`AssignmentID`) REFERENCES `assigment` (`AssignmentID`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `student_ibfk_1` FOREIGN KEY (`StudentID`) REFERENCES `studentdetails` (`StudentID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `teacher`
--
ALTER TABLE `teacher`
  ADD CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`TeacherID`) REFERENCES `teacherdetails` (`TeacherID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

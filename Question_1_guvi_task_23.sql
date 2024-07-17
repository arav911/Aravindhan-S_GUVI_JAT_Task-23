#Creating "employee_details" Database
create database employee_details;

#Using "employee_details" Database
use employee_details;

#Creating "Empl" table
create table Empl (
	empno int primary key,
    ename varchar(15),
    job varchar(20),
    mgr int,
    hiredate date,
    sal decimal(10,2),
    comm decimal(10,2),
    deptno int not null
);

#Inserting values into "Empl" table
insert into Empl values(8369, 'SMITH', 'CLERK', 8902, '1990-12-18', 800.00, NULL, 20);
insert into Empl values(8499, 'ANYA', 'SALESMAN', 8698, '1991-02-20', 1600.00, 300.00, 30);
insert into Empl values(8521, 'SETH', 'SALESMAN', 8698, '1991-02-22', 1250.00, 500.00, 30);
insert into Empl values(8566, 'MAHADEVAN', 'MANAGER', 8839, '1991-04-02', 2985.00, NULL, 20);
insert into Empl values(8654, 'MOMIN', 'SALESMAN', 8698, '1991-09-28', 1250.00, 1400.00, 30);
insert into Empl values(8698, 'BINA', 'MANAGER', 8839, '1991-05-01', 2850.00, NULL, 30);
insert into Empl values(8882, 'SHIVANSH', 'MANAGER', 8839, '1991-06-09', 2450.00, NULL, 10);
insert into Empl values(8888, 'SCOTT', 'ANALYST', 8566, '1992-12-09', 3000.00, NULL, 20);
insert into Empl values(8839, 'AMIR', 'PRESIDENT', NULL, '1991-11-18', 5000.00, NULL, 10);
insert into Empl values(8844, 'KULDEEP', 'SALESMAN', 8698, '1991-09-08', 1500.00, 0.00, 30);

#Query to display all the records from "Empl" table
select * from Empl;

#Query to display Ename and Sal of employees whose salary are greater than or equal to 2200
select ename, sal from Empl where sal>=2200;

#Query to display details of employees who are not getting commission
select * from Empl where comm=0.00 or comm is null;

#Query to display employee name and salary of those employees who don't have their salary in the range of 2500 to 4000
select ename, sal from Empl where not sal>=2500 and sal<=4000;

#Query to display the name, job title and salary of employees who don't have a manager
select ename, job, sal from Empl where mgr is null;

#Query to display name of an employee whose name contains "A" as third alphabet
select ename from Empl where ename like '__A%';

#Query to display name of an employee whose name contains "T" as last alphabet
select ename from Empl where ename like '%T';
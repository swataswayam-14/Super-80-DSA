/*
DDL : create , alter , drop
DML : insert, update, select , delete
DCL : grant, revoke
TCL : commit , rollback, savepoint
*/  

create table employees (
    employee_id int primary key auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    email varchar(100) unique,
    hire_date date,
    salary = decimal(10,5),
    department_id int, 
    manager_id int,
    is_active boolean default true,
    foreign key (department_id) references department(dept_id)
        on delete set null 
        on update cascade 
);


alter table employees 
add column phone varchar(15);

alter table employees 
modify column salary decimal(12,2)

alter table employees 
drop column phone; 

alter table employees 
add constraint fk_dept 
foreign key (department_id) references department(dept_id);

alter table employees
drop constraint fk_key;

alter table employees 
rename to staff; 


drop table employees; -- drops structure and data

truncate table employees; -- truncate table (data only , faster than delete)

drop database company_db;

insert into employees(first_name, last_name , phone) 
values
("swata", "swayam dash", 2348762348);


insert into employees(first_name, last_name , phone) 
values
("swata", "swayam dash", 2348762348)
("swata", "swayam dash", 2348762348)
("swata", "swayam dash", 2348762348)
("swata", "swayam dash", 2348762348)
("swata", "swayam dash", 2348762348)
("swata", "swayam dash", 2348762348)
("swata", "swayam dash", 2348762348);

insert into archived_employee (first_name , last_name , employee_id, archived_date) 
values 
select first_name , last_name, employee_id , current_date 
from employees
where hire_date < '2020-01-01';


update employees
set salary = 23396
where employee_id = 2;


update employees
set 
    salary = 82364,
    first_name = "kdf"
where employee_id = 3;

update employees e 
join department d 
on e.dept_id = d.dept_id
set e.salary = e.salary * 1.05
where d.dept_name = 'Engineering';


update employees
set salary = case 
    when salary < 50000 then salary*1.15 
    when salary < 75000 then salary*1.10
    else salary * 1.05
end;


delete from employees 
where employee_id = 1;

delete from employees 
where hire_date < '2020-01-01' AND is_active = false;

delete from employees 
where department_id in 
    (select dept_id from department where budget < 10000);

select first_name , salary , salary * 12 as annual_salary from employees;

select distinct department_id from employees;

select distinct department_id , employee_id from employees;



select  first_name,
        salary,
        case 
            when salary < 10000 then 'low'
            when salary < 20000 then 'medium'
            else 'other'
        end as salary_grade 
from employees;


-- find all the manager names along side there department's name

select 
    e.first_name 
    d.dept_name 
    m.first_name as manager_name 
from employees e 
inner join department d on d.dept_id = e.department_id 
inner join employees m on m.employee_id = e.manager_id;
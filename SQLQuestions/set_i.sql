-- employees

-- | emp\_id | name    | dept\_id | salary |
-- | ------- | ------- | -------- | ------ |
-- | 1       | Alice   | 10       | 50000  |
-- | 2       | Bob     | 20       | 60000  |
-- | 3       | Charlie | NULL     | 40000  |
-- | 4       | David   | 30       | 45000  |
-- | 5       | Eve     | 10       | 52000  |
-- | 6       | Frank   | 30       | 47000  |

-- departments

-- | dept\_id | dept\_name  |
-- | -------- | ----------- |
-- | 10       | HR          |
-- | 20       | Engineering |
-- | 30       | Marketing   |
-- | 40       | Sales       |


--  List all employee names with their department names (include employees with no department).

select e.name as employee_name, d.dept_name as department_name from employees e 
left join  departments d 
on e.dept_id = d.dept_id;

-- List all department names with the number of employees in each (even if count is 0).

select d.dept_name, count(e.emp_id) as total_employees
from departments d 
left join employees e on d.dept_id = e.dept_id
group by d.dept_name;

-- Find names of employees who work in the HR department.

select e.name as employee_name from employees e 
inner join departments d 
on e.dept_id = d.dept_id
where d.dept_name = "HR";

-- List the department(s) with the highest number of employees.

select d.dept_name from departments d 
inner join (
    select dept_id, count(*) as emp_count
    from employees 
    group by dept_id 
) t on d.dept_id = t.dept_id
where t.emp_count = (
    select max(emp_count)
    from (
        select count(*) as emp_count 
        from employees 
        group by dept_id 
    )
);
-- Show the average salary per department, but only for departments having more than 1 employee.

select d.dept_name as department_name ,m.average_salary as average_salary from departments d 
inner join employees e on d.dept_id = e.dept_id inner join (
    select dept_id, avg(salary) as average_salary from employees 
    group by dept_id
    having count(*) > 1
) m on d.dept_id = m.dept_id;

-- Find the names of employees who earn more than the average salary of all employees.
select e.name as employee_name from employees e 
inner join (select avg(salary) as avg_salary from employees) m 
on e.salary > m.avg_salary;

-- or
select e.name as employee_name 
from employees e 
where e.salary > (select avg(salary) from employees);

-- Find names of employees who earn more than the average salary of their department.

select e.name from employees e 
inner join departments d 
on e.dept_id = d.dept_id 
inner join (
    select dept_id, avg(salary) as department_average from employees 
    group by dept_id
) m on m.dept_id = d.dept_id and e.salary > m.department_average;

-- List employees whose salary is greater than all employees in the HR department.

select e.name as employee_name , e.salary as employee_salary from employees e 
inner join departments d on e.dept_id = d.dept_id 
where e.salary > (
    select max(salary) as maximum_salary  from employees where dept_id = (
        select dept_id from departments where dept_name = "HR"
    )
);


-- For each department, show the name of the highest-paid employee.


select d.dept_name as department_name , e.name as employee_name from employees 
inner join departments d on e.dept_id = d.dept_id 
inner join (
    select dept_id, max(salary) as max_salary from employees 
    group by dept_id
) m on d.dept_id = m.dept_id and e.salary = m.max_salary;

-- List the departments that do not have any employees.

select d.dept_name as department_name from departments d 
left join employees e on d.dept_id = e.dept_id 
where e.emp_id is NULL;
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


-- 1. List names of employees along with their department names, show "No Department" if none.

select e.name as employee_name , d.dept_name as department_name from employees e 
left join departments d 
on e.dept_id = d.dept_id;

-- 2. Find departments where the average salary of employees is greater than 50000.
select d.dept_name as department_name from departments d 
join (
    select dept_id, avg(salary) as avg_salary from employees e 
    group by dept_id 
) m on d.dept_id = m.dept_id and m.avg_salary > 50000;

-- 3. List the departments with more than 1 employee.

select d.dept_name from departments d 
join (
    select dept_id , count(*) as total_employee from employees 
    group by dept_id
    having total_employee > 1
) m on d.dept_id = m.dept_id;

-- 4. Find names of employees who do not belong to any department.

select e.name as employee_name from employees e 
left join departments d 
on e.dept_id = d.dept_id 
where e.dept_id is null;


-- or

select e.name as employee_name from employees e 
where dept_id is null;


-- 5. Find departments where no employee is working.

select d.dept_name as department_name from departments d 
left join employees e 
on e.dept_id = d.dept_id
where e.emp_id is null;

-- 6. Show the name of the employee(s) with the lowest salary in the entire company.

select name from employees where salary = (
    select salary from employees order by salary asc limit 1
);

-- 7. For each department, show:
-- Department name

-- Number of employees

-- Total salary paid

select d.dept_name as department_name, m.total_salary, m.total_employees from departments d 
join (
    select dept_id, sum(salary) as total_salary, count(emp_id) as total_employees from employees 
    group by dept_id
) m on d.dept_id = m.dept_id;


-- 8. Show employees whose salary is strictly higher than the average salary of their own department.

select e.name as employee_name from employees e 
join departments d on e.dept_id = d.dept_id 
join (
    select dept_id, avg(salary) as avg_salary from employees 
    group by dept_id
) m on d.dept_id = m.dept_id and e.salary > m.avg_salary;

-- 9. Find employee(s) who earn more than all employees in the Marketing department.

select name from employees where salary > (
    select max(salary) from employees where dept_id = (
        select dept_id from departments where dept_name = "Marketing"
    )
);
-- 10. List departments along with the name of the highest paid employee in each.

select d.dept_name as department_name , e.name as employee_name from departments d 
join employees e on e.dept_id = d.dept_id 
join (
    select dept_id, max(salary) as max_salary from employees 
    group by dept_id
) m on e.salary = m.max_salary and d.dept_id = m.dept_id;
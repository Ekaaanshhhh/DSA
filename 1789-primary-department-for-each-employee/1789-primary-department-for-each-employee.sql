# Write your MySQL query statement below

select e.employee_id,e.department_id
    from (
    select employee_id,max(primary_flag) as primary_dept_flag
    from Employee
    group by employee_id 
    ) as i
    inner join Employee as e
    on i.employee_id = e.employee_id and e.primary_flag = i.primary_dept_flag

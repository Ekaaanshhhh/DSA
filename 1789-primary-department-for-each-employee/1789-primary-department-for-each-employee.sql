# Write your MySQL query statement below


with info as(
    select employee_id,max(primary_flag) as primary_flag
    from Employee
    group by employee_id
)

select e.employee_id,e.department_id from Employee as e
inner join info as i
on i.employee_id=e.employee_id and i.primary_flag=e.primary_flag;


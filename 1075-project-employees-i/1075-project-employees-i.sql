# Write your MySQL query statement below



with info as(
select p.project_id,e.employee_id,e.experience_years
from Project as p
inner join Employee as e
on p.employee_id = e.employee_id
)

select project_id,round(avg(experience_years),2) as average_years
from info
group by project_id;

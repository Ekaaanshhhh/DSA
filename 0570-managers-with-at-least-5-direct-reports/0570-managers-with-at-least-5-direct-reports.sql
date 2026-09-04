# Write your MySQL query statement below



with info as (
    select e1.managerId, e2.name,e2.id
    from Employee as e1
    inner join
    Employee as e2
    on e1.managerId = e2.id
),

-- select * from info

newinfo as(
    select name, count(managerId) as direct_reports
    from info
    group by id
)

select name from newinfo where direct_reports>=5;

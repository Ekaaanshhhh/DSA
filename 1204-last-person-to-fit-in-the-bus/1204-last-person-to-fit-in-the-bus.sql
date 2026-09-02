# Write your MySQL query statement below


with info as (
    select *,SUM(weight) OVER(order by turn) as cumulative_weight
    from
    Queue
)


select person_name 
from info
where cumulative_weight=(
select MAX(cumulative_weight)
from info
where cumulative_weight<=1000
);

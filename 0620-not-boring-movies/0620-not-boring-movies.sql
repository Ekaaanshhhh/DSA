# Write your MySQL query statement below


select *
from cinema as c 
where 
c.id%2!=0 and c.description!='boring'
order by c.rating desc;
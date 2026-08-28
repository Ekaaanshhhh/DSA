# Write your MySQL query statement below

select w.id from weather as w
cross join
weather as ww
where DATEDIFF(w.recordDate,ww.recordDate)=1 
and w.temperature>ww.temperature;
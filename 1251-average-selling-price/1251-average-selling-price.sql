# Write your MySQL query statement below


with info as(select p.product_id,SUM(p.price*u.units)
as total_price,SUM(u.units) as total_units
from Prices as p
left join UnitsSold as u
on u.purchase_date between p.start_date and p.end_date
and p.product_id=u.product_id
group by p.product_id)

select i.product_id, 
IFNULL(ROUND(i.total_price/i.total_units,2),0) as average_price
from info as i;

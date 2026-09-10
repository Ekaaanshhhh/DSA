# Write your MySQL query statement below


select customer_id,count(transaction_id is null) as count_no_trans
from(
select v.visit_id,v.customer_id,t.transaction_id
from Visits as v
left join Transactions as t
on v.visit_id = t.visit_id
where t.transaction_id is null
) as info
group by customer_id

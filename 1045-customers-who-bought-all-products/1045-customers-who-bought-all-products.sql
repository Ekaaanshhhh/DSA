# Write your MySQL query statement below


with counts as (
    select count(product_key) as count
    from Product
),

data as(
    select customer_id,count(distinct product_key) as purchased
    from Customer
    group by customer_id
)

select customer_id
from counts as c
inner join data as d
where c.count = d.purchased
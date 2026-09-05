# Write your MySQL query statement below

with info as (
    select customer_id,min(order_date) as order_date
    from Delivery
    group by
    customer_id 
),

moreinfo as(
    select i.customer_id,i.order_date,d.customer_pref_delivery_date
    from info as i
    inner join Delivery as d
    on i.order_date=d.order_date and i.customer_id=d.customer_id
)

select 
    round(
        sum(case when order_date = customer_pref_delivery_date then 1 else 0 end) * 100.0 / count(*), 
        2
    ) as immediate_percentage
from moreinfo;

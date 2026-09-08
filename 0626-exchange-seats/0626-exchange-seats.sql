# Write your MySQL query statement below

-- select info.id,s.student
-- from Seat as s
-- inner join
-- (
--     select
--     case when id=(select max(id) from Seat) and mod(id,2)=1 then id
--     else 
--     case
--         when mod(id,2)=1 then id+1
--         else id-1 end
--     end as id
--     from 
--     Seat
-- ) as info
-- on info.id = s.id; 


with info as(
    select
    case when id=(select max(id) from Seat) and mod(id,2)=1 then id
    else 
    case
        when mod(id,2)=1 then id+1
        else id-1 end
    end as id
    from 
    Seat
),

newerinfo as(
    select i.id,(
    select student from Seat where id = i.id
    ) as student,
    case when id=(select max(id) from Seat) and mod(id,2)=1 then id else
    case when mod(id,2)=1 then id+1
    else id-1 end
    end as newid
    from Info as i
)

select newid as id, student
from newerinfo;



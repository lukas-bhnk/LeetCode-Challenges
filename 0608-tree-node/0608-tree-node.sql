# Write your MySQL query statement below
select 
a.id,
case when a.p_id is not null and b.p_id is null then "Leaf" else 
case when a.p_id is not null then "Inner" else
"Root" end
end as type
from Tree a
left join (select distinct p_id from Tree) b
on a.id = b.p_id;
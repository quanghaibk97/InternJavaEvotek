select name,
(case when monthlymaintenance <= 100 then 'cheap'
when monthlymaintenance > 100 then 'expensive'
end) as cost
from cd.facilities;
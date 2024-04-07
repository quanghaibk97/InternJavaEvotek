select surname
from cd.members
group by surname
order by surname asc
limit 10;
select joindate 
from cd.members 
group by joindate
order by joindate desc
limit 1;

select max(joindate)
from cd.members;
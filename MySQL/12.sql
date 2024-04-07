select firstname, surname, joindate
from cd.members
where joindate in (
select max(joindate)
from cd.members);

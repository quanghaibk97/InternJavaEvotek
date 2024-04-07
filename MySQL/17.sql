select distinct concat(m.firstname, " ", m.surname) as member, name
from cd.members as m, cd.bookings as b, cd.facilities as f
where m.memid = b.memid
and b.facid = f.facid
and name like 'Tennis Court%'
order by member, name;

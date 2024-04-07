select starttime
from cd.members m, cd.bookings b
where firstname = 'David'
and surname = 'Farrell'
and m.memid = b.memid;

select starttime
from cd.members m  inner join  cd.bookings b
on firstname = 'David'
and surname = 'Farrell'
and m.memid = b.memid;
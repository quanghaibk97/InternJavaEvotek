select starttime, name
from cd.bookings b, cd.facilities f
where b.facid = f.facid
and starttime >= '2012-09-21'
and starttime < '2012-09-22'
and f.name in ('Tennis Court 2','Tennis Court 1')
order by starttime asc;
select  concat(m.firstname, " ", m.surname) as member, name,
(case 
	when m.memid = 0 then b.slots*f.guestcost
    when m.memid != 0 then b.slots*f.membercost
    end ) as cost
from cd.members as m, cd.bookings as b, cd.facilities as f
where m.memid = b.memid
	and b.facid = f.facid
	and starttime >= '2012-09-14'
	and starttime < '2012-09-15'
	and ((m.memid = 0 and b.slots*f.guestcost > 30) 
		or (m.memid != 0 and b.slots*f.membercost > 30))
order by cost desc;	


select  m.firstname || ' ' || m.surname as member, name,
(case 
	when m.memid = 0 then b.slots*f.guestcost
    when m.memid != 0 then b.slots*f.membercost
    end ) as cost
from cd.members as m, cd.bookings as b, cd.facilities as f
where m.memid = b.memid
	and b.facid = f.facid
	and starttime >= '2012-09-14'
	and starttime < '2012-09-15'
	and ((m.memid = 0 and b.slots*f.guestcost > 30) 
		or (m.memid != 0 and b.slots*f.membercost > 30))
order by cost desc;	
select member, faciliti_name, cost 
from
	(select  concat(m.firstname, " ", m.surname) as member, name as faciliti_name,
		(case 
			when m.memid = 0 then b.slots*f.guestcost
			when m.memid != 0 then b.slots*f.membercost
			end ) as cost
		from cd.members as m, cd.bookings as b, cd.facilities as f
		where m.memid = b.memid
			and b.facid = f.facid
			and starttime >= '2012-09-14'
			and starttime < '2012-09-15'
	) as tmp 
where cost > 30
order by cost desc;

select member, faciliti_name, cost 
from
	(select  m.firstname || ' ' || m.surname as member, name as faciliti_name,
		(case 
			when m.memid = 0 then b.slots*f.guestcost
			when m.memid != 0 then b.slots*f.membercost
			end ) as cost
		from cd.members as m, cd.bookings as b, cd.facilities as f
		where m.memid = b.memid
			and b.facid = f.facid
			and starttime >= '2012-09-14'
			and starttime < '2012-09-15'
	) as tmp 
where cost > 30
order by cost desc;

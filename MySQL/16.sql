select m1.firstname as memfname, m1.surname as memsname , m2.firstname as firstname_gt, m2.surname as surname_gt
from cd.members m1 
left outer join cd.members m2
on m1.memid = m2.recommendedby
order by memsname, memfname;

select mems.firstname as memfname, mems.surname as memsname, recs.firstname as recfname, recs.surname as recsname
	from 
		cd.members mems
		left outer join cd.members recs
			on recs.memid = mems.recommendedby
order by memsname, memfname;


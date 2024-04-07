select distinct concat(m1.firstname, " ", m1.surname) as member, 
	(select concat(m2.firstname, " ", m2.surname) as member
    from cd.members m2
    where m2.memid = m1.recommendedby) as recomender
from cd.members m1
order by member;

select distinct  m1.firstname || ' ' || m1.surname as member, 
	(select m2.firstname || ' ' || m2.surname as member
    from cd.members m2
    where m2.memid = m1.recommendedby) as recomender
from cd.members m1
order by member;
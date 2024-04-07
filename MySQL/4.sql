select facid, name, membercost, monthlymaintenance
from cd.facilities
where membercost < monthlymaintenance/50
and membercost > 0;
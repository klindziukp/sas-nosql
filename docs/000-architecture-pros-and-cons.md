# Current architecture Pros and Cons for [Chegura project](https://github.com/Scorpibear/chegura)

* Status: __PROPOSED__
* Date: 21-03-2021

## PROBLEM
- Need to describe pros and cons for current architecture for Chegura project

## PROS OF EXISTING ARCHITECTURE
- Existent data can be provided in <1 sec.
## CONS OF EXISTING ARCHITECTURE
- Data cannot be saved and reused, external jobs doing backup daily/weekly/monthly
- There is no possibility to limit access to the whole database based on subscription id
- It is hard or even impossible scale

## PROS OF PROPOSED ARCHITECTURE
- Existent data can be provided in <1 sec.
- Data can be saved and reused since we will be using database now
- Possibility to limit access to the whole database based on subscription id can be easily implemented
- Vertical scale can be performed

## CONS OF EXISTING ARCHITECTURE
- Database maintenance and database tuning skills are required
- Horizontal scale is impossible, only vertical





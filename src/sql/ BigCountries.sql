# |595|[Big Countries](https://leetcode.com/problems/big-countries/)|Easy|[BigCountries](https://github.com/CODINGSAINT/leetcode/blob/master/src/sql/BigCountries.sql) |
# Write your MySQL query statement below
select name, population, area from world
where population >= 25000000 or  area>= 3000000
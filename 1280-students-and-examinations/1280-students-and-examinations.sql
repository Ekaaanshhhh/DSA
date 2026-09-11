# Write your MySQL query statement below


with info as(
    select *
    from Students s
    join
    Subjects sb
)


select student_id,student_name,subject_name,count(subjects) as attended_exams
from(
    select i.student_id,i.student_name,i.subject_name,e.subject_name as subjects
from info as i
left join Examinations as e
on e.student_id = i.student_id and e.subject_name = i.subject_name
) as moreinfo
group by student_id,subject_name
order by student_id,subject_name;

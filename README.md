# Homeschool Tracker
A java application written to demonstrate several Object Oriented Programming design patterns.

## Project Summary
Homeschooling multiple children with a provided curriculum can be straightforward, but there are a lot of tasks to keep track of. If a household has multiple children in different grades that move at different paces, keeping track of which lessons are planned for the day and which materials are need can quickly become overwhelming.

This application will manage a set of subjects and their lessons. Lessons will have their own materials and a flag for whether or not they have been completed.

Additionally, the application will manage students and which subjects each student has.

## User Stories 

```
As a parent
I want to know which lessons each student has today
So that I can keep track of which videos they should watch
```
```
As a parent
I want to know which lessons each student has today
So that I can prepare the appropriate materials
```
```
As a parent
I want to know which lessons each student has completed
So that I can review worksheets
```
```
As a student
I want to be able to check off my lessons
So that I can see what is remaining for me to complete
```

## Planning & Development
The java code will reside in this repository.

* [User Personas](https://github.com/amajor/HomeschoolTracker/projects/1)
* [Kanban Board](https://github.com/amajor/HomeschoolTracker/projects/2)

### Object Structure

Here are some ideas of what details I think would be helpful for "Subject" objects and "Lesson" objects. These may lend themselves well to the Factory Pattern.

This is a very rough early sketch of ideas.

**Subject** |
----------- |
Name |
getTotalLessons() |
getNextLesson() |

**Lesson** |
----------- |
Name |
Materials |
Completed |

**Student** |
----------- |
Name |
Subjects |

**Parent** |
----------- |
Name |
Students |

# Portal-for-managing-academic-course-videos

## TechStack
- SpringBoot (Java)
- Angular
- PostgreSQL
- Inkscape
- IDE (IntelliJ IDEA)

## Features
- Admin: 
  - Approve or Reject videos on verification
  - Add, edit, delete courses
- User:
  - Upload videos, which will first go for verification
  - Edit, delete his'/her own video
- Common for both:
  - Upload a video
  - Like a video
  - Comment a video

## Initialization
- Run the sql.txt file to create all the required tables

## Angular Installation and Running
`$ npm i`

`$ npm start`

## Backend Installation and Running
- `Open the project in IntelliJ IDEA as Spring Project`

- `Download the postgresql jar file from (https://jdbc.postgresql.org/download/) and import it in the the project: File > Project Structure > Libraries > +`

- `Change the database name and password in application.properties file, and localhost port number (if changed while installing postgres/pgAdmin4)`

- `Run the Project as Spring Application`

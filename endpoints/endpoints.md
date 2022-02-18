1. HTTP: `/signup` : method: `POST` parameters: `(username,password,email,display_name)` response: `{[created:true/false],[id:]}` description: returns created:true if username does not exist and user has been created, created:
 false

2. HTTP: `/auth` : method: `GET` parameters: `(username,password)` response: `{valid:true/false}` description: returns valid:true if username and password match to those in db

3. HTTP: `/create_task` : method: `POST` parameters: `(id,user_id,title,description,due_date,status)` response: `{[created:true/false],[id:]}` description: returns true if task has been created 

4. HTTP: `/tasks` : method: `GET` parameters: `(user_id)` response: `{for task in tasks:{id:,title:,description:,due_date:,status:}` description: returns all tasks for the user ID
 
5. HTTP: `/update_task` : method: `PUT` parameters: `(id,title,description,due_date)` response: `{[updated:true/false]}` description: updates task details

6. HTTP: `/delete_user` : method: `DELETE` parameters: `(id)` response: `{[deleed:true/false]}` description: deletes user

7. HTTP: `/login` : method: `GET` parameters: `(id)` response: `{username:,email:,display_name:,}` description: returns user details for an already authenticated user 

8. HTTP: `/update_user` : method: `PUT` parameters: `(id,username,password,email,display_name)` response: `{[updated:true/false]}` description: updates user details

9. HTTP: `/delete_task` : method: `DELETE` parameters: `(id)` response: `{[deleted:true/false]}` description: deletes task

10. 


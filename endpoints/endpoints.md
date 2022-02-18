1. HTTP: `/signup` : method: `POST` parameters: `(username,password,email,display_name)` response: `{"username_valid":true/false,"created":true/false,"id":}` description: returns username_valid:true,created:true and user_id if username does not exist and user has been created

mock_responses:
```json
{"username_valid":true,
"created":true,
 "id":1234}
```
```json
{"username_valid":false,
"created":false,
"id":}
```

2. HTTP: `/auth` : method: `GET` parameters: `(username,password)` response: `{valid:true/false}` description: returns valid:true if username and password match to those in db

mock_responses:
```json
{"valid":true,}
```
```json
{"valid":false,}
```

3. HTTP: `/create_task` : method: `POST` parameters: `(id,user_id,title,description,due_date,status)` response: `{[created:true/false],[id:]}` description: returns true if task has been created 

mock_response:
```json
{"created":true,}
```

4. HTTP: `/tasks` : method: `GET` parameters: `(user_id)` response: `{for task in tasks:{id:,title:,description:,due_date:,status:}` description: returns all tasks for the user ID

mock_response:
```json
[{"id":1,"title":"Pick Trash","description":"remember to pick trash in the backyard","due_date":"7/14/2021","status":"created"},
{"id":2,"title":"Go to hospital","description":"Been feeling funny, need to go to doctor's appointment","due_date":"3/20/2021","status":"done"},
{"id":3,"title":"Apply for new role","description":"Apply for all the bookmarked roles I did last week","due_date":"4/23/2021","status":"progress"}]
```
5. HTTP: `/update_task` : method: `PUT` parameters: `(id,title,description,due_date)` response: `{[updated:true/false]}` description: updates task details

mock_response:
```json
{"updated":true,}
```
6. HTTP: `/delete_user` : method: `DELETE` parameters: `(id)` response: `{[deleed:true/false]}` description: deletes user

mock_response:
```json
{"deleted":true,}
```

7. HTTP: `/login` : method: `GET` parameters: `(id)` response: `{username:,email:,display_name:,}` description: returns user details for an already authenticated user

mock_response:
```json
{"username":"ernnjf",
 "email":"x.y@gmail.com",
 "display_name":"Abc Def"}
 ```
 
8. HTTP: `/update_user` : method: `PUT` parameters: `(id,username,password,email,display_name)` response: `{[updated:true/false]}` description: updates user details

mock_response:
```json
{"updated":true,}
```

9. HTTP: `/delete_task` : method: `DELETE` parameters: `(id)` response: `{[deleted:true/false]}` description: deletes task

mock_response:
```json
{"deleted":true,}
```
10. 


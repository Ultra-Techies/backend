1.  HTTP: `/users` 

- `POST` method: parameters: `(username,password,email,display_name)` response: `{"username_valid":true/false,"created":true/false,"id":}` description: returns username_valid:true,created:true and user_id if username does not exist and user has been created

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

- `GET` method:  parameters: `(id)` response: `{id:,username:,email:,display_name:,profile_photo}` description: returns user details for a user for an id supplied

mock_response:
```json
{"username":"ernnjf",
 "email":"x.y@gmail.com",
 "display_name":"Abc Def",
 "profile_photo":"https://dummyimage.com/161x100.png"}
 ```

- `PUT` method: parameters: `(id,username,password,email,display_name,profile_photo)` response: `{[updated:true/false]}` description: updates user details

mock_response:
```json
{"updated":true,}
```

- `DELETE` method: parameters: `(id)` response: `{[deleed:true/false]}` description: deletes user

mock_response:
```json
{"deleted":true,}
```


2. HTTP: `/tasks`

- `GET` method: parameters: `(id)` response: `{for task in tasks:{id:,title:,description:,due_date:,status:}` description: returns all tasks for the user ID

mock_response:
```json
[{"id":1,"title":"Pick Trash","description":"remember to pick trash in the backyard","due_date":"7/14/2021","status":"created"},
{"id":2,"title":"Go to hospital","description":"Been feeling funny, need to go to doctor's appointment","due_date":"3/20/2021","status":"done"},
{"id":3,"title":"Apply for new role","description":"Apply for all the bookmarked roles I did last week","due_date":"4/23/2021","status":"progress"}]
```

- `POST`  : method: parameters: `(id,user_id,title,description,due_date,status)` response: `{[created:true/false],[id:]}` description: returns true if task has been created 

mock_response:
```json
{"created":true,}
```

- `PUT` method: parameters: `(id,title,description,due_date)` response: `{[updated:true/false]}` description: updates task details

mock_response:
```json
{"updated":true,}
```

- `DELETE` method: parameters: `(id)` response: `{[deleted:true/false]}` description: deletes task

mock_response:
```json
{"deleted":true,}
```



3. HTTP: `users/auth` : 
- `GET` method: parameters: `(username,password)` response: `{
   "valid":"true/false",
   "id":123
}` description: returns valid:true and user id if username and password match to those in db

mock_responses:
```json
{
   "valid":"true",
   "id":123
}
```
```json
{
   "valid":"false",
   "id":0
}
```

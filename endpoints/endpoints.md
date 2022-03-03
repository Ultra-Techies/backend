1.  HTTP: `/users` 

- `POST` method: parameters: `(username,password,email,display_name)` response: `{id,username,email,display_name,profile_photo}` description: returns user details after creation

mock_response:
```json
{"id":1234,
"username":"ernnjf",
 "email":"x.y@gmail.com",
 "display_name":"Abc Def",
 "profile_photo":"https://dummyimage.com/161x100.png"}
```


- `GET` method:  parameters: `(id)` response: `{id,username,email,display_name,profile_photo}` description: returns user details for a user for a `user_id` requested

mock_response:
```json
{"username":"ernnjf",
 "email":"x.y@gmail.com",
 "display_name":"Abc Def",
 "profile_photo":"https://dummyimage.com/161x100.png"}
 ```

- `PUT` method: parameters: `(id,username,password,email,display_name,profile_photo)` response: `{id,username,email,display_name,profile_photo}` description: updates user details

mock_response:
```json
{"username":"ernnjf",
 "email":"x.y@gmail.com",
 "display_name":"Abc Def",
 "profile_photo":"https://dummyimage.com/161x100.png"}
```

- `DELETE` method: parameters: `(id)` response: `{"deleted successfully"}` description: deletes user

mock_response:
```json
{"deleted successfully"}
```


2. HTTP: `/tasks`

- `GET` method: parameters: `(id)` response: `{for task in tasks:{id:,title:,description:,due_date:,status:}` description: returns all tasks for the user ID

mock_response:
```json
[{"id":1,"title":"Pick Trash","description":"remember to pick trash in the backyard","due_date":"7/14/2021","status":"created"},
{"id":2,"title":"Go to hospital","description":"Been feeling funny, need to go to doctor's appointment","due_date":"3/20/2021","status":"done"},
{"id":3,"title":"Apply for new role","description":"Apply for all the bookmarked roles I did last week","due_date":"4/23/2021","status":"progress"}]
```

- `POST`  : method: parameters: `(user_id,title,description,due_date,status)` response: `{id,titledescription,due_date,status}` description: returns task if task has been created 

mock_response:
```json
{"id":1,"title":"Pick Trash","description":"remember to pick trash in the backyard","due_date":"7/14/2021","status":"created"}
```

- `PUT` method: parameters: `(id,title,description,due_date,status)` response: `{id,titledescription,due_date,status}` description: updates task details

mock_response:
```json
{"id":1,"title":"Pick Trash","description":"remember to pick trash in the backyard","due_date":"7/14/2021","status":"created"}
```

- `DELETE` method: parameters: `(id)` response: `{deleted successfully}` description: deletes task

mock_response:
```json
{"deleted successfully"}
```



3. HTTP: `users/auth` : 
- `GET` method: parameters: `(username,password)` response: `{
   "valid":"true/false",
   "id":123
}` description: returns valid:true and user id if username and password match to those in db

mock_responses:
```json
{
   "valid":1
}
```
```json
{
   "valid":0
}
```

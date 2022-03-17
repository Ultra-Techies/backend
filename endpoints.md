# ToDoList API Endpoints

## Users

**URL:** `/api/user`

- `POST` method: parameters: `(username,name,password,email)` response: `{id,username,name,email,display_name,photo}` description: returns user details after creation, status code 500 if username or email exists

mock_payload:
```json
{
    "username":"agrfn",
    "name":"Maridfam",
    "email":"email@emadfily.com",
    "photo":"https://pixabay.com/photos/chafdin-security-metal-iron-3481377/",
    "password":"foildddkfmr"
}
```

mock_responses:
```json
{   "id":1
    "username":"agrfn",
    "name":"Maridfam",
    "email":"email@emadfily.com",
    "photo":"https://pixabay.com/photos/chafdin-security-metal-iron-3481377/",
    "password":"foildddkfmr"
}
```
```json
{
    "timestamp": "2022-03-17T13:32:57.494+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "message": "User with username agrfn already exists!",
    "path": "/api/user"
}
```

```json
{
    "timestamp": "2022-03-17T13:37:40.297+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "message": "User with email email@emadfily.com already exists",
    "path": "/api/user"
}
```

- `GET` method:  parameters: `(id)` response: `{id,username,name,email,photo}` description: returns user details for a user for a `user_id` requested or status code 500 if user with user_id does not exist

mock_response:
```json
{   "id":1
    "username":"agrfn",
    "name":"Maridfam",
    "email":"email@emadfily.com",
    "photo":"https://pixabay.com/photos/chafdin-security-metal-iron-3481377/",
    "password":"foildddkfmr"
}
```
```json
{
    "timestamp": "2022-03-17T13:40:16.575+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "message": "user with userId:3 does not exist!",
    "path": "/api/user/3"
}
```

- `PUT` method: parameters: `(id,username,name, password,email,photo)` response: `{id,username,email,display_name,profile_photo}` description: updates user details, returns updated user or status code 500 if email or username is already taken, or user with the id supplied does not exist

mock_payload_url:

`localhost:8080/api/user/20?password=dhjfsrkk`

mock_response:
```json
{
    "id": 20,
    "username": "agrfn",
    "name": "Maridfam",
    "email": "email@emadfily.com",
    "photo": "https://pixabay.com/photos/chafdin-security-metal-iron-3481377/"
}
```

- `DELETE` method: parameters: `(id)` response: `{"message":"deleted successfully"}` description: deletes user, returns successful deletion message or status code 500 if user with id does not exist

mock_payload_url:

`localhost:8080/api/user/3`


mock_responses:
```json
{"message":"deleted successfully"}
```
```json
{
    "timestamp": "2022-03-17T13:54:09.873+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "message": "user with userId: 10 does not exist!",
    "path": "/api/user/10"
}
```


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

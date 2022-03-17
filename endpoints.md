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
## Tasks

**URL:** `/api/task`

- `POST` method: parameters: `(id,title, description,dueDate,createdTime,reminder,status)` response: `{id,title, description,dueDate,createdTime,status}` description: creates task, returns created task or returns status code 500 if user with user Id supplied does not exist,

mock_payload_url:

`http://localhost:8080/api/task/add/25`

mock_payload:
```json
 {
         "title": "Go to Home now",
    "description": "Been feeling funny, need to go to doctor's appointment",
    "dueDate": "2022-08-18 00:44:21",
     "reminder": "2022-08-18 00:44:21",
     "createdTime": "2022-08-18 00:44:21"
    }
```
mock_responses:
```json
{
    "id": 4,
    "title": "Go to Home now",
    "description": "Been feeling funny, need to go to doctor's appointment",
    "dueDate": "2022-08-17T21:44:21Z",
    "status": "created",
    "createdTime": "2022-08-17T21:44:21Z"
}
```
```json
{
    "timestamp": "2022-03-17T14:23:55.319+00:00",
    "status": 500,
    "error": "Internal Server Error",
    "message": "User does not exist",
    "path": "/api/task/add/25"
}
```

- `

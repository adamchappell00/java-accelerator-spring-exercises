## RecordStore.com API Docs

### API Index

- 1.1 Create a record
- 1.2 Update a record
- 1.3 Delete a record
- 1.4 Retrieve all of the records
- 1.5 Retrieve a single record by id
***
#### 1.1: Create a Record
- URL: recordstore.com/create
- HTTP Method: POST
- HTTP Reponse: 201 - Created
- Request Body: JSON - {title, artist, release, duration, tracklist: [1,2,3...], label}
- Response Body: Created Record Data: JSON - {title, artist, release, duration, tracklist: [1,2,3...], label}

***
#### 1.2: Update a Record
- URL: recordstore.com/{id}/update
- HTTP Method: PUT
- HTTP Reponse: 200 - OK
- Request Body: JSON 
  - {title, artist, release, duration, tracklist: [1,2,3...], label}
- Response Body: Updated Record Data: JSON 
  - {title, artist, release, duration, tracklist: [1,2,3...], label}
***
#### 1.3: Delete a Record
- URL: recordstore.com/{id}/delete
- HTTP Method: DELETE
- HTTP Reponse: 300 - Redirect
- Request Body: None
- Response Body: None
***
#### 1.4: Retrieve All Records
- URL: recordstore.com/index
- HTTP Method: GET
- HTTP Reponse: 200 - OK
- Request Body: None
- Response Body: JSON, List of All Records: 
  - [{index, title, artist, release, duration, tracklist: [1,2,3...], label},
  {index, title, artist, release, duration, tracklist: [1,2,3...], label},
  ...]
  
***
#### 1.5: Retrieve A Single Record
- URL: recordstore.com/record/{id}
- HTTP Method: GET
- HTTP Reponse: 200 - OK
- Request Body: None
- Response Body: JSON, Single Record:
    - title, artist, release, duration, tracklist: [1,2,3...], label}
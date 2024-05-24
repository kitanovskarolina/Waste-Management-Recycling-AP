# Waste Collection and Recycling Services API

## Introduction

This API allows city residents to manage municipal waste collection and recycling services, including schedules, types of waste collected, and community participation programs. It facilitates communication between residents and city departments, enabling efficient waste management and recycling program tracking.

## Base URL

http://localhost:9090/api



## Endpoints

### 1. Create a New Waste Collection Route

**HTTP Method:** POST

**Endpoint:** `/waste`

**Description:** Schedule new waste collection routes.

**Request Headers:**


**Request Body:**

``json
{
  "routeName": "Downtown Route",
  "schedule": "Every Monday at 6:00 AM",
  "wasteType": "General Waste"
}
Responses:

201 Created:
json

{
  "id": 1,
  "routeName": "Downtown Route",
  "schedule": "Every Monday at 6:00 AM",
  "wasteType": "General Waste"
}
400 Bad Request: Invalid input
2. View Current Waste Collection Routes
HTTP Method: GET

Endpoint: /waste

Description: View the current waste collection routes.

Request Headers:

Accept: application/json
Responses:

200 OK:
json

[
  {
    "id": 1,
    "routeName": "Downtown Route",
    "schedule": "Every Monday at 6:00 AM",
    "wasteType": "General Waste"
  },
  {
    "id": 2,
    "routeName": "Uptown Route",
    "schedule": "Every Wednesday at 7:00 AM",
    "wasteType": "Recyclable Waste"
  }
]
204 No Content: No routes found
3. Retrieve a Single Waste Collection Route
HTTP Method: GET

Endpoint: /waste/{id}

Description: Retrieve details of a single waste collection route by its ID.

Request Headers:

Accept: application/json
Path Parameters:

id (integer): ID of the waste collection route
Responses:

200 OK:
json

{
  "id": 1,
  "routeName": "Downtown Route",
  "schedule": "Every Monday at 6:00 AM",
  "wasteType": "General Waste"
}
404 Not Found: Route not found
4. Update Waste Collection Route
HTTP Method: PUT

Endpoint: /waste/{id}

Description: Update the details of a waste collection route.

Request Headers:

Content-Type: application/json
Path Parameters:

id (integer): ID of the waste collection route
Request Body:

json

{
  "routeName": "Updated Route Name",
  "schedule": "Updated Schedule",
  "wasteType": "Updated Waste Type"
}
Responses:

200 OK:
json

{
  "id": 1,
  "routeName": "Updated Route Name",
  "schedule": "Updated Schedule",
  "wasteType": "Updated Waste Type"
}
400 Bad Request: Invalid input
404 Not Found: Route not found
5. Delete a Waste Collection Route
HTTP Method: DELETE

Endpoint: /waste/{id}

Description: Delete a waste collection route by its ID.

Request Headers:

Accept: application/json
Path Parameters:

id (integer): ID of the waste collection route
Responses:

204 No Content: Successfully deleted
404 Not Found: Route not found
6. Create a New Recycling Program
HTTP Method: POST

Endpoint: /recycling

Description: Create a new recycling program.

Request Headers:

Content-Type: application/json
Request Body:

json

{
  "programName": "Paper Recycling",
  "description": "Collect and recycle paper products."
}
Responses:

201 Created:
json
{
  "id": 1,
  "programName": "Paper Recycling",
  "description": "Collect and recycle paper products."
}
400 Bad Request: Invalid input
7. View Current Recycling Programs
HTTP Method: GET

Endpoint: /recycling

Description: View the current recycling programs.

Request Headers:

Accept: application/json
Responses:

200 OK:
json
[
  {
    "id": 1,
    "programName": "Paper Recycling",
    "description": "Collect and recycle paper products."
  },
  {
    "id": 2,
    "programName": "Plastic Recycling",
    "description": "Collect and recycle plastic products."
  }
]
204 No Content: No programs found
8. Retrieve a Single Recycling Program
HTTP Method: GET

Endpoint: /recycling/{id}

Description: Retrieve details of a single recycling program by its ID.

Request Headers:

Accept: application/json
Path Parameters:

id (integer): ID of the recycling program
Responses:

200 OK:
json
{
  "id": 1,
  "programName": "Paper Recycling",
  "description": "Collect and recycle paper products."
}
404 Not Found: Program not found
9. Update a Recycling Program
HTTP Method: PUT

Endpoint: /recycling/{id}

Description: Update the details of a recycling program.

Request Headers:

Content-Type: application/json
Path Parameters:

id (integer): ID of the recycling program
Request Body:

json
{
  "programName": "Updated Program Name",
  "description": "Updated Description"
}
Responses:

200 OK:
json
{
  "id": 1,
  "programName": "Updated Program Name",
  "description": "Updated Description"
}
400 Bad Request: Invalid input
404 Not Found: Program not found
10. Delete a Recycling Program
HTTP Method: DELETE

Endpoint: /recycling/{id}

Description: Delete a recycling program by its ID.

Request Headers:

Accept: application/json
Path Parameters:

id (integer): ID of the recycling program
Responses:

204 No Content: Successfully deleted
404 Not Found: Program not found

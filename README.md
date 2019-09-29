# employee-crud
REST API for employees management.

# REST API Url examples

 * Get list of employees
    * GET http://localhost:8080/api/employees
 * Get specific employee
    * GET http://localhost:8080/api/employees/{id}
 * Search for employees by list of parameters
    * POST http://localhost:8080/api/employees/search
      * Sample request body:
      
          {
              "searchPhrases": [
              	"10",
              	"Stanisław",
              	"Stonoga"
              	]
          }
  * Insert/update employee
    * POST http://localhost:8080/api/employees
      * Sample request body(insert):     
        {
            "firstName": "Stanisław",
            "lastName": "Kowalski",
            "grade": null,
            "salary": null
        }
      * Sample request body (update):
        {
            "id": 5,
            "firstName": "Stanisław",
            "lastName": "Kowalski",
            "grade": null,
            "salary": null
        }
  * Delete employee
    DELETE http://localhost:8080/api/employees/{id}
    
# Exception handling
  Use three simple, common response codes indicating (1) success, (2) failure due to client-side problem, (3) failure due to no data found (4) failure due to server-side problem:
  * 200 - OK
  * 400 - Bad Request
  * 404 - No data found
  * 500 - Internal Server Error


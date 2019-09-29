package com.example.crud.service

import com.example.crud.model.Employee
import com.example.crud.request.EmployeeSearchRequest
import spock.lang.Specification

abstract class AbstractEmployeeServiceImplTest extends Specification {


    def buildEmployeeList() {
        [
            [
                id: 1,
                firstName: "Test",
                lastName: "Test",
                grade: 3,
                salary: 5000
            ] as Employee,
            [
              id: 2,
              firstName: "Zbigniew",
              lastName: "Stonoga",
              grade: 3,
              salary: 5000
            ] as Employee
        ] as List<Employee>
    }

    def buildSingleEmployee() {
        [
                id: 1,
                firstName: "Test",
                lastName: "Test",
                grade: 3,
                salary: 5000
        ] as Employee
    }

    def searchPhrases() {
        [
          searchPhrases: [
            "Test",
            "Zbigniew"
          ] as List<String>
        ] as EmployeeSearchRequest
    }

    def buildOptionalEmployee() {
        Optional.of(buildSingleEmployee())
    }

}

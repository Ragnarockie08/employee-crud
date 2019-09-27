package com.example.crud.service

import com.example.crud.model.Employee
import spock.lang.Specification

class AbstractEmployeeServiceImplTest extends Specification {


    def buildEmployeeList() {
        [
                [
                        id: 1,
                        firstName: "Test",
                        lastName: "Test",
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

    def buildOptionalEmployee() {
        Optional.of(buildSingleEmployee())
    }

}

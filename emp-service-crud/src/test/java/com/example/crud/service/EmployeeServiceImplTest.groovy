package com.example.crud.service

import com.example.crud.exception.NotFoundException
import com.example.crud.repository.EmployeeRepository
import org.springframework.dao.EmptyResultDataAccessException

class EmployeeServiceImplTest extends AbstractEmployeeServiceImplTest {

    EmployeeServiceImpl employeeService;
    def employeeRepository = Mock(EmployeeRepository)
    void setup() {
        employeeService = new EmployeeServiceImpl(employeeRepository)
    }


    def "GetAllEmployees - happy path"() {

        given:
        1 * employeeRepository.findAll() >> buildEmployeeList()

        when:
        def result = employeeService.getAllEmployees()

        then:

        assert result != null
        assert result.size() == 1
        assert result.get(0).getFirstName() == "Test"
        assert result.get(0).getLastName() == "Test"
        assert result.get(0).getGrade() == 3
        assert result.get(0).getSalary() == 5000
    }

    def "GetEmployee - happy Path"() {

        given:
        1 * employeeRepository.findById(_) >> buildOptionalEmployee()

        when:
        def result = employeeService.getEmployee(1)

        then:

        assert result != null
        assert result.getFirstName() == "Test"
        assert result.getLastName() == "Test"
        assert result.getGrade() == 3
        assert result.getSalary() == 5000
    }

    def "GetEmployee - unhappy Path"() {

        given:
        def employeeId = 5
        1 * employeeRepository.findById(_) >> Optional.ofNullable(null)

        when:
        def result = employeeService.getEmployee(employeeId)

        then:

        NotFoundException ex = thrown()
        assert ex.message == "No record found for id: " + employeeId
    }

    def "InsertEmployee - happy Path"() {

        def employee = buildSingleEmployee()

        given:
        1 * employeeRepository.save(_) >> buildSingleEmployee()

        when:
        def result = employeeService.insertEmployee(employee)

        then:

        assert result != null
        assert result.getId() == 1
        assert result.getFirstName() == "Test"
        assert result.getLastName() == "Test"
        assert result.getGrade() == 3
        assert result.getSalary() == 5000
    }

    def "DeleteEmployee - unhappyPath"() {
        def employeeId = 5

        given:
        employeeRepository.deleteById(_ as Long) >> {
            Long id -> throw new EmptyResultDataAccessException(0)
        }

        when:
        employeeService.deleteEmployee(employeeId)
        then:
        NotFoundException ex = thrown()
        assert ex.message == "No record found for id=" + employeeId
    }
}
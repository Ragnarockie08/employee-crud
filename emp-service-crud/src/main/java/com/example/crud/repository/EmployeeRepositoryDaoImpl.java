package com.example.crud.repository;

import com.example.crud.model.Employee;
import com.example.crud.service.EmployeeRepositoryDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class EmployeeRepositoryDaoImpl implements EmployeeRepositoryDao {

    private EntityManager em;

    public List<Employee> findByParams(List<String> parameters) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> emp = cq.from(Employee.class);
        List<Predicate> predicates = new ArrayList<>();
        for (String parameter: parameters) {
            predicates.add(cb.like(cb.lower(emp.get("firstName")), parseStringParam(parameter)));
            predicates.add(cb.like(cb.lower(emp.get("lastName")), parseStringParam(parameter)));
            predicates.add(cb.equal(emp.get("grade"), parseIntParam(parameter)));
            predicates.add(cb.equal(emp.get("salary"), parseIntParam(parameter)));
        }
        cq.where(cb.or(predicates.toArray(new Predicate[predicates.size()])));
        TypedQuery<Employee> query = em.createQuery(cq);
        return query.getResultList();
    }

    private String parseStringParam(String parameter) {
        return "%" + parameter.toLowerCase() + "%";
    }

    private Integer parseIntParam(String parameter) {
        Integer value;
        try {
            value = Integer.parseInt(parameter);
        } catch (NumberFormatException e) {
            value = null;
        }
        return value;
    }
}

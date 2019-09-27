package com.example.crud.request;


import com.example.crud.model.Employee;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ModifyEmployeeRequest {

    private Employee employee;
}

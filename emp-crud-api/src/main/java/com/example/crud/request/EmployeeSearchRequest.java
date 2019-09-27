package com.example.crud.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSearchRequest {

    private List<String> searchPhrases;
}

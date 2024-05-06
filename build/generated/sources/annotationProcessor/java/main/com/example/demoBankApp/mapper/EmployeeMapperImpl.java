package com.example.demoBankApp.mapper;

import com.example.demoBankApp.dto.request.EmployeeRequest;
import com.example.demoBankApp.dto.response.EmployeeResponse;
import com.example.demoBankApp.entity.Employee;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T11:27:19+0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
public class EmployeeMapperImpl extends EmployeeMapper {

    @Override
    public Employee dtoToEntity(EmployeeRequest request) {
        if ( request == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        if ( request.getName() != null ) {
            employee.name( request.getName() );
        }
        if ( request.getSurname() != null ) {
            employee.surname( request.getSurname() );
        }
        if ( request.getEmail() != null ) {
            employee.email( request.getEmail() );
        }
        if ( request.getUsername() != null ) {
            employee.username( request.getUsername() );
        }
        if ( request.getBirthDate() != null ) {
            employee.birthDate( request.getBirthDate() );
        }

        return employee.build();
    }

    @Override
    public void dtoToEntity(Employee employee, EmployeeRequest request) {
        if ( request == null ) {
            return;
        }

        if ( request.getName() != null ) {
            employee.setName( request.getName() );
        }
        if ( request.getSurname() != null ) {
            employee.setSurname( request.getSurname() );
        }
        if ( request.getEmail() != null ) {
            employee.setEmail( request.getEmail() );
        }
        if ( request.getUsername() != null ) {
            employee.setUsername( request.getUsername() );
        }
        if ( request.getBirthDate() != null ) {
            employee.setBirthDate( request.getBirthDate() );
        }
    }

    @Override
    public EmployeeResponse entityToDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeResponse.EmployeeResponseBuilder employeeResponse = EmployeeResponse.builder();

        if ( employee.getId() != null ) {
            employeeResponse.id( employee.getId() );
        }
        if ( employee.getName() != null ) {
            employeeResponse.name( employee.getName() );
        }
        if ( employee.getSurname() != null ) {
            employeeResponse.surname( employee.getSurname() );
        }
        if ( employee.getEmail() != null ) {
            employeeResponse.email( employee.getEmail() );
        }
        if ( employee.getUsername() != null ) {
            employeeResponse.username( employee.getUsername() );
        }
        if ( employee.getBirthDate() != null ) {
            employeeResponse.birthDate( employee.getBirthDate() );
        }

        return employeeResponse.build();
    }

    @Override
    public List<EmployeeResponse> entityListToDtoList(List<Employee> employees) {
        if ( employees == null ) {
            return null;
        }

        List<EmployeeResponse> list = new ArrayList<EmployeeResponse>( employees.size() );
        for ( Employee employee : employees ) {
            list.add( entityToDto( employee ) );
        }

        return list;
    }
}

package com.example.demoBankApp.mapper;

import com.example.demoBankApp.dto.request.PropertyRequest;
import com.example.demoBankApp.dto.response.PropertyResponse;
import com.example.demoBankApp.entity.Employee;
import com.example.demoBankApp.entity.Properties;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T11:27:20+0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
public class PropertyMapperImpl extends PropertyMapper {

    @Override
    public Properties dtoToEntity(PropertyRequest request) {
        if ( request == null ) {
            return null;
        }

        Properties.PropertiesBuilder properties = Properties.builder();

        if ( request != null ) {
            properties.employee( propertyRequestToEmployee( request ) );
        }
        if ( request.getKey() != null ) {
            properties.key( request.getKey() );
        }
        if ( request.getValue() != null ) {
            properties.value( request.getValue() );
        }

        return properties.build();
    }

    @Override
    public void dtoToEntity(Properties properties, PropertyRequest request) {
        if ( request == null ) {
            return;
        }

        if ( properties.getEmployee() == null ) {
            properties.setEmployee( Employee.builder().build() );
        }
        propertyRequestToEmployee1( request, properties.getEmployee() );
        if ( request.getKey() != null ) {
            properties.setKey( request.getKey() );
        }
        if ( request.getValue() != null ) {
            properties.setValue( request.getValue() );
        }
    }

    @Override
    public PropertyResponse entityToDto(Properties properties) {
        if ( properties == null ) {
            return null;
        }

        PropertyResponse.PropertyResponseBuilder propertyResponse = PropertyResponse.builder();

        Integer id = propertiesEmployeeId( properties );
        if ( id != null ) {
            propertyResponse.employeeId( id );
        }
        if ( properties.getKey() != null ) {
            propertyResponse.key( properties.getKey() );
        }
        if ( properties.getValue() != null ) {
            propertyResponse.value( properties.getValue() );
        }

        return propertyResponse.build();
    }

    @Override
    public List<PropertyResponse> entityListToDtoList(List<Properties> properties) {
        if ( properties == null ) {
            return null;
        }

        List<PropertyResponse> list = new ArrayList<PropertyResponse>( properties.size() );
        for ( Properties properties1 : properties ) {
            list.add( entityToDto( properties1 ) );
        }

        return list;
    }

    protected Employee propertyRequestToEmployee(PropertyRequest propertyRequest) {
        if ( propertyRequest == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        if ( propertyRequest.getEmployeeId() != null ) {
            employee.id( propertyRequest.getEmployeeId() );
        }

        return employee.build();
    }

    protected void propertyRequestToEmployee1(PropertyRequest propertyRequest, Employee mappingTarget) {
        if ( propertyRequest == null ) {
            return;
        }

        if ( propertyRequest.getEmployeeId() != null ) {
            mappingTarget.setId( propertyRequest.getEmployeeId() );
        }
    }

    private Integer propertiesEmployeeId(Properties properties) {
        if ( properties == null ) {
            return null;
        }
        Employee employee = properties.getEmployee();
        if ( employee == null ) {
            return null;
        }
        Integer id = employee.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}

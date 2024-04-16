package com.example.demoBankApp.mapper;

import com.example.demoBankApp.dto.request.PropertyRequest;
import com.example.demoBankApp.dto.response.PropertyResponse;
import com.example.demoBankApp.entity.Client;
import com.example.demoBankApp.entity.Properties;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-16T10:48:22+0400",
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
            properties.client( propertyRequestToClient( request ) );
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

        if ( properties.getClient() == null ) {
            properties.setClient( Client.builder().build() );
        }
        propertyRequestToClient1( request, properties.getClient() );
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

        Integer id = propertiesClientId( properties );
        if ( id != null ) {
            propertyResponse.clientId( id );
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

    protected Client propertyRequestToClient(PropertyRequest propertyRequest) {
        if ( propertyRequest == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        if ( propertyRequest.getClientId() != null ) {
            client.id( propertyRequest.getClientId() );
        }

        return client.build();
    }

    protected void propertyRequestToClient1(PropertyRequest propertyRequest, Client mappingTarget) {
        if ( propertyRequest == null ) {
            return;
        }

        if ( propertyRequest.getClientId() != null ) {
            mappingTarget.setId( propertyRequest.getClientId() );
        }
    }

    private Integer propertiesClientId(Properties properties) {
        if ( properties == null ) {
            return null;
        }
        Client client = properties.getClient();
        if ( client == null ) {
            return null;
        }
        Integer id = client.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}

package com.example.demoBankApp.mapper;

import com.example.demoBankApp.dto.request.ClientRequest;
import com.example.demoBankApp.dto.response.ClientResponse;
import com.example.demoBankApp.entity.Client;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-06T09:55:15+0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.5.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
public class ClientMapperImpl extends ClientMapper {

    @Override
    public Client dtoToEntity(ClientRequest request) {
        if ( request == null ) {
            return null;
        }

        Client.ClientBuilder client = Client.builder();

        if ( request.getName() != null ) {
            client.name( request.getName() );
        }
        if ( request.getSurname() != null ) {
            client.surname( request.getSurname() );
        }
        if ( request.getEmail() != null ) {
            client.email( request.getEmail() );
        }
        if ( request.getUsername() != null ) {
            client.username( request.getUsername() );
        }
        if ( request.getPassword() != null ) {
            client.password( request.getPassword() );
        }
        if ( request.getBirthDate() != null ) {
            client.birthDate( request.getBirthDate() );
        }
        if ( request.getPhone() != null ) {
            client.phone( request.getPhone() );
        }

        return client.build();
    }

    @Override
    public void dtoToEntity(Client client, ClientRequest request) {
        if ( request == null ) {
            return;
        }

        if ( request.getName() != null ) {
            client.setName( request.getName() );
        }
        if ( request.getSurname() != null ) {
            client.setSurname( request.getSurname() );
        }
        if ( request.getEmail() != null ) {
            client.setEmail( request.getEmail() );
        }
        if ( request.getUsername() != null ) {
            client.setUsername( request.getUsername() );
        }
        if ( request.getPassword() != null ) {
            client.setPassword( request.getPassword() );
        }
        if ( request.getBirthDate() != null ) {
            client.setBirthDate( request.getBirthDate() );
        }
        if ( request.getPhone() != null ) {
            client.setPhone( request.getPhone() );
        }
    }

    @Override
    public ClientResponse entityToDto(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientResponse.ClientResponseBuilder clientResponse = ClientResponse.builder();

        if ( client.getId() != null ) {
            clientResponse.id( client.getId() );
        }
        if ( client.getName() != null ) {
            clientResponse.name( client.getName() );
        }
        if ( client.getSurname() != null ) {
            clientResponse.surname( client.getSurname() );
        }
        if ( client.getEmail() != null ) {
            clientResponse.email( client.getEmail() );
        }
        if ( client.getUsername() != null ) {
            clientResponse.username( client.getUsername() );
        }
        if ( client.getBirthDate() != null ) {
            clientResponse.birthDate( client.getBirthDate() );
        }
        if ( client.getPhone() != null ) {
            clientResponse.phone( client.getPhone() );
        }

        return clientResponse.build();
    }

    @Override
    public List<ClientResponse> entityListToDtoList(List<Client> clients) {
        if ( clients == null ) {
            return null;
        }

        List<ClientResponse> list = new ArrayList<ClientResponse>( clients.size() );
        for ( Client client : clients ) {
            list.add( entityToDto( client ) );
        }

        return list;
    }
}

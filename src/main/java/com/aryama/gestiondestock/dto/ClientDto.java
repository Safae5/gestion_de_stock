package com.aryama.gestiondestock.dto;


import com.aryama.gestiondestock.model.Client;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder

public class ClientDto {

    private Integer id;


    private String nom;


    private String prenom;


    private AddressDto address;


    private String photo;


    private String mail;


    private String numTel;

    private Integer idEntreprise;


    @JsonIgnore
    private List<CommandeClientDto> commandeClients;

    public static ClientDto fromEntity(Client client) {
        if (client == null) {
            return null;
        }
        return ClientDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .address(AddressDto.fromEntity(client.getAddress()))
                .photo(client.getPhoto())
                .mail(client.getMail())
                .numTel(client.getNumTel())
                .idEntreprise(client.getIdEntreprise())
                .build();
       }

    public static Client toEntity(ClientDto dto) {
        if (dto == null) {
            return null;
        }
        Client client = new Client();
        client.setId(dto.getId());
        client.setNom(dto.getNom());
        client.setPrenom(dto.getPrenom());
        client.setAddress(AddressDto.toEntity(dto.getAddress()));
        client.setPhoto(dto.getPhoto());
        client.setMail(dto.getMail());
        client.setNumTel(dto.getNumTel());
        client.setIdEntreprise(dto.getIdEntreprise());
        return client;
    }



}

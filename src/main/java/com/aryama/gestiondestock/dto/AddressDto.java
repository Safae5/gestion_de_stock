package com.aryama.gestiondestock.dto;

import com.aryama.gestiondestock.model.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class AddressDto {

    private String adresse1;

    private String adresse2;

    private String ville;

    private String codePostale;

    private String pays;

    public static AddressDto fromEntity(Address adresse){
       if (adresse == null) {
           return null;
       }
        return AddressDto.builder()
                .adresse1(adresse.getAddress1())
                .adresse2(adresse.getAddress2())
                .codePostale(adresse.getCodePostal())
                .ville(adresse.getVille())
                .pays(adresse.getPays())
                .build();
       }

    public static Address toEntity(AddressDto adresseDto) {
        if (adresseDto == null) {
            return null;
        }
        Address adresse = new Address();
        adresse.setAddress1(adresseDto.getAdresse1());
        adresse.setAddress2(adresseDto.getAdresse2());
        adresse.setCodePostal(adresseDto.getCodePostale());
        adresse.setVille(adresseDto.getVille());
        adresse.setPays(adresseDto.getPays());
        return adresse;
    }
}

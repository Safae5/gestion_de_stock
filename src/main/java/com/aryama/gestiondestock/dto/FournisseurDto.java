package com.aryama.gestiondestock.dto;


import com.aryama.gestiondestock.model.Fournisseur;
import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class FournisseurDto {

    private Integer id;


    private String nom;


    private String prenom;


    private AddressDto address;


    private String photo;


    private String mail;


    private String numTel;

    private Integer idEntreprise;


    private List<CommandeClientDto> commandefournisseur;

    public static FournisseurDto fromEntity(Fournisseur fournisseur) {
        if (fournisseur == null) {
            return null;
        }
        return FournisseurDto.builder()
                .id(fournisseur.getId())
                .nom(fournisseur.getNom())
                .prenom(fournisseur.getPrenom())
                .address(AddressDto.fromEntity(fournisseur.getAddress()))
                .photo(fournisseur.getPhoto())
                .mail(fournisseur.getMail())
                .numTel(fournisseur.getNumTel())
                .idEntreprise(fournisseur.getIdEntreprise())
                .build();
    }

    public static Fournisseur toEntity(FournisseurDto dto) {
        if (dto == null) {
            return null;
        }
        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setId(dto.getId());
        fournisseur.setNom(dto.getNom());
        fournisseur.setPrenom(dto.getPrenom());
        fournisseur.setAddress(AddressDto.toEntity(dto.getAddress()));
        fournisseur.setPhoto(dto.getPhoto());
        fournisseur.setMail(dto.getMail());
        fournisseur.setNumTel(dto.getNumTel());
        fournisseur.setIdEntreprise(dto.getIdEntreprise());

        return fournisseur;
    }


}

package com.aryama.gestiondestock.dto;




import com.aryama.gestiondestock.model.Utilisateur;
import lombok.Builder;
import lombok.Data;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder

public class UtilisateurDto {

    private Integer id;


    private String nom;


    private String prenom;


    private String email;


    private Instant dateDeNaissance;


    private String moteDePasse;


    private AddressDto address;


    private String photo;


    private EntrepriseDto entreprise;


    private List<RolesDto> roles;

    public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
        if (utilisateur == null) {
            return null;
        }

        return UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .moteDePasse(utilisateur.getMoteDePasse())
                .dateDeNaissance(utilisateur.getDateDeNaissance())
                .address(AddressDto.fromEntity(utilisateur.getAddress()))
                .photo(utilisateur.getPhoto())
                .entreprise(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
                .roles(
                        utilisateur.getRoles() != null ?
                                utilisateur.getRoles().stream()
                                        .map(RolesDto::fromEntity)
                                        .collect(Collectors.toList()) : null
                )
                .build();
    }

    public static Utilisateur toEntity(UtilisateurDto dto) {
        if (dto == null) {
            return null;
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(dto.getId());
        utilisateur.setNom(dto.getNom());
        utilisateur.setPrenom(dto.getPrenom());
        utilisateur.setEmail(dto.getEmail());
        utilisateur.setMoteDePasse(dto.getMoteDePasse());
        utilisateur.setDateDeNaissance(dto.getDateDeNaissance());
        utilisateur.setAddress(AddressDto.toEntity(dto.getAddress()));
        utilisateur.setPhoto(dto.getPhoto());
        utilisateur.setEntreprise(EntrepriseDto.toEntity(dto.getEntreprise()));

        return utilisateur;
    }


}

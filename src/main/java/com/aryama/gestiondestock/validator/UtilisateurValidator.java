package com.aryama.gestiondestock.validator;

import com.aryama.gestiondestock.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public static List<String> validate(UtilisateurDto utilisateurDto) {
        List<String> errors = new ArrayList<>();

        if (utilisateurDto == null) {
            errors.add("Veuillez renseigner le nom d'utilisateur");
            errors.add("Veuillez renseigner le prenom d'utilisateur");
            errors.add("Veuillez renseigner le mot de passe d'utilisateur");
            errors.add("Veuillez renseigner l'adresse d'utilisateur");
            //errors.addAll(AdresseValidator.validate(null));
            return errors;
        }

        if (!StringUtils.hasLength(utilisateurDto.getNom())) {
            errors.add("Veuillez renseigner le nom d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getPrenom())) {
            errors.add("Veuillez renseigner le prenom d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getMoteDePasse())) {
            errors.add("Veuillez renseigner le mot de passe d'utilisateur");
        }
        if (!StringUtils.hasLength(utilisateurDto.getEmail())) {
            errors.add("Veuillez renseigner l'email d'utilisateur");
        }
        if (utilisateurDto.getDateDeNaissance() == null) {
            errors.add("Veuillez renseigner la date de naissance d'utilisateur");
        }
        if (utilisateurDto.getAddress() == null){
            errors.add("Veuillez renseigner l'adresse d'utilisateur");
        }else {
            if (!StringUtils.hasLength(utilisateurDto.getAddress().getAdresse1())){
                errors.add("Le champ 'Adresse 1' est obligatoir");
            }
            if (!StringUtils.hasLength(utilisateurDto.getAddress().getVille())){
                errors.add("Le champ 'Ville' est obligatoir");
            }
            if (!StringUtils.hasLength(utilisateurDto.getAddress().getCodePostale())){
                errors.add("Le champ 'Code Postal' est obligatoir");
            }
            if (!StringUtils.hasLength(utilisateurDto.getAddress().getPays())){
                errors.add("Le champ 'Pays' est obligatoir");
            }
        }

        return errors;

    }
}

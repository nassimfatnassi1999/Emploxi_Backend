package tn.capgemini.Emploxi.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployerDTO {
    Long id;
    Long local_id;
    Long prener_id;
    Long cg_id;
    String nom;
    String prenom;
    String r_hierarchique;
    LocalDate startDate;
    LocalDate date_atc;
    double salaireNet_entree;
    double slaireBrute;
    String exp_ANT;
    String anncientite_ATC;
    String exp_total_as_is;
    Long cin;
    LocalDate date_naissance;
    Integer age;
    Integer nbr_enfant;
    String diplome;
    String promotion;
    String ecole;
    String mail_personnel;
    String titre_admin;
    String mail_capgemini;
    LocalDate dateSortie;
    Long telephone;
    String cnss;
    String adresse_cnss;
    String rib;
    String designation;
    String professional_community;
    String genre;
    String nationality;
    String typeContrat;
    String activity;
    String classement;
    String grade;
    String jobNameCGcg;
    String l12;
    String niche;
    String profil;
    String roleFamily;
    String roleName;
    String situationFamiliale;
    String cssDssDsp;
}
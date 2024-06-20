package tn.capgemini.Emploxi.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "employees")
public class Employer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long local_id;
    Long prener_id;
    Long cg_id;
    String nom;
    String prenom;
    String r_hierarchique;
    @DateTimeFormat(pattern = "[d/M/yyyy][dd/MM/yyyy][dd/M/yyyy][d/MM/yyyy][yyyy/MM/dd][yyyy/M/d][yyyy/M/dd][yyyy/MM/d]")
    LocalDate startDate;
    @DateTimeFormat(pattern = "[d/M/yyyy][dd/MM/yyyy][dd/M/yyyy][d/MM/yyyy][yyyy/MM/dd][yyyy/M/d][yyyy/M/dd][yyyy/MM/d]")
    LocalDate date_atc;
    double salaireNet_entree;
    double slaireBrute;
    String exp_ANT;
    String anncientite_ATC;
    String exp_total_as_is;
    Long cin;
    @DateTimeFormat(pattern = "[d/M/yyyy][dd/MM/yyyy][dd/M/yyyy][d/MM/yyyy][yyyy/MM/dd][yyyy/M/d][yyyy/M/dd][yyyy/MM/d]")
    LocalDate date_naissance;
    Integer age;
    Integer nbr_enfant;
    String diplome;
    String promotion;
    String ecole;
    String mail_personnel;
    String titre_admin;
    String mail_capgemini;
    @DateTimeFormat(pattern = "[d/M/yyyy][dd/MM/yyyy][dd/M/yyyy][d/MM/yyyy][yyyy/MM/dd][yyyy/M/d][yyyy/M/dd][yyyy/MM/d]")
    LocalDate dateSortie;
    Long telephone;
    String cnss;
    String adresse_cnss;
    String rib;
    String designation;
    String professional_community;
    @Enumerated(EnumType.STRING)
    Genre genre;

    @ManyToOne
    @JoinColumn(name = "nationality_id")
    private Nationality nationality;

    @ManyToOne
    @JoinColumn(name = "contrat_id")
    private TypeContrat typeContrat;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "classement_id")
    private Classement classement;

    @ManyToOne
    @JoinColumn(name = "garde_id")
    private Grade grade;

    @ManyToOne
    @JoinColumn(name = "jobnamecg_id")
    private JobNameCG jobNameCGcg;

    @ManyToOne
    @JoinColumn(name = "l12id")
    private L12 l12;

    @ManyToOne
    @JoinColumn(name = "niche_id")
    private Niche niche;

    @ManyToOne
    @JoinColumn(name = "profil_id")
    private Profil profil;

    @ManyToOne
    @JoinColumn(name = "rolefamily_id")
    private RoleFamily roleFamily;

    @ManyToOne
    @JoinColumn(name = "rolename_id")
    private RoleName roleName;

    @ManyToOne
    @JoinColumn(name = "situationfamilale_id")
    private SituationFamiliale situationFamiliale;

    @ManyToOne
    @JoinColumn(name = "cssDssDsp_id")
    private CSS_DSS_DSP cssDssDsp;





}

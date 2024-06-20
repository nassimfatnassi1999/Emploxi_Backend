package tn.capgemini.Emploxi.services;

import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.capgemini.Emploxi.entities.*;
import tn.capgemini.Emploxi.repositories.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ExcelImportService {

    private final ActivityRepository activityRepository;
    private final TypeContratRepository typeContratRepository;
    private final ProfilRepository profilRepository;
    private final CSS_DSS_DSPRepository cssDssDspRepository;
    private final ClassementRepository classementRepository;
    private final GradeRepository gradeRepository;
    private final L12Repository l12Repository;
    private final NicheRepository nicheRepository;
    private final SituationFamilialeRepository situationFamilialeRepository;
    private final RoleFamilyRepository roleFamilyRepository;
    private final RoleNameRepository roleNameRepository;
    private final NationalityRepository nationalityRepository;
    private final EmployerRepository employerRepository;

    public List<Employer> importExcelFile(MultipartFile file) {
        List<Employer> employees = new ArrayList<>();

        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                Employer employee = new Employer();
                employee.setLocal_id(getCellValueAsLong(row.getCell(0)));
                employee.setPrener_id(getCellValueAsLong(row.getCell(1)));
                employee.setCg_id(getCellValueAsLong(row.getCell(2)));
                employee.setNom(getCellValueAsString(row.getCell(3)));
                employee.setPrenom(getCellValueAsString(row.getCell(4)));
                employee.setR_hierarchique(getCellValueAsString(row.getCell(5)));

                String activityName = getCellValueAsString(row.getCell(6));
                Activity activity = activityRepository.findByName(activityName);
                employee.setActivity(activity);

                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("[d/M/yyyy][dd/M/yyyy][d/MM/yyyy][dd/MM/yyyy]");

                try {
                    LocalDate startDate = LocalDate.parse(getCellValueAsString(row.getCell(7)), dateFormat);
                    employee.setStartDate(startDate);

                    LocalDate dateAtc = LocalDate.parse(getCellValueAsString(row.getCell(8)), dateFormat);
                    employee.setDate_atc(dateAtc);
                } catch (DateTimeParseException e) {
                    e.printStackTrace();
                }

                String typeContratName = getCellValueAsString(row.getCell(9));
                TypeContrat typeContrat = typeContratRepository.findByName(typeContratName);
                employee.setTypeContrat(typeContrat);

                String profilName = getCellValueAsString(row.getCell(10));
                Profil profil = profilRepository.findByName(profilName);
                employee.setProfil(profil);

                employee.setSalaireNet_entree(getCellValueAsDouble(row.getCell(11)));
                employee.setSlaireBrute(getCellValueAsDouble(row.getCell(12)));

                String cssDssDspName = getCellValueAsString(row.getCell(13));
                CSS_DSS_DSP cssDssDsp = cssDssDspRepository.findByName(cssDssDspName);
                employee.setCssDssDsp(cssDssDsp);

                String classementName = getCellValueAsString(row.getCell(14));
                Classement classement = classementRepository.findByName(classementName);
                employee.setClassement(classement);

                String gradeName = getCellValueAsString(row.getCell(15));
                Grade grade = gradeRepository.findByName(gradeName);
                employee.setGrade(grade);

                String l12Name = getCellValueAsString(row.getCell(16));
                L12 l12 = l12Repository.findByName(l12Name);
                employee.setL12(l12);

                String nicheName = getCellValueAsString(row.getCell(17));
                Niche niche = nicheRepository.findByName(nicheName);
                employee.setNiche(niche);

                employee.setExp_ANT(getCellValueAsString(row.getCell(18)));
                employee.setAnncientite_ATC(getCellValueAsString(row.getCell(19)));
                employee.setExp_total_as_is(getCellValueAsString(row.getCell(20)));
                employee.setCin(getCellValueAsLong(row.getCell(21)));

                try {
                    LocalDate dateNaissance = LocalDate.parse(getCellValueAsString(row.getCell(22)), dateFormat);
                    employee.setDate_naissance(dateNaissance);
                } catch (DateTimeParseException e) {
                    e.printStackTrace();
                }
                employee.setAge((int) getCellValueAsDouble(row.getCell(23)));

                // Handle Enum
                employee.setGenre(Genre.valueOf(getCellValueAsString(row.getCell(24)).toUpperCase()));

                String situationFamiliale = getCellValueAsString(row.getCell(25));
                SituationFamiliale situation = situationFamilialeRepository.findByName(situationFamiliale);
                employee.setSituationFamiliale(situation);

                employee.setNbr_enfant((int) getCellValueAsDouble(row.getCell(26)));
                employee.setDiplome(getCellValueAsString(row.getCell(27)));
                employee.setPromotion(getCellValueAsString(row.getCell(28)));
                employee.setEcole(getCellValueAsString(row.getCell(29)));
                employee.setMail_personnel(getCellValueAsString(row.getCell(30)));
                employee.setTitre_admin(getCellValueAsString(row.getCell(31)));

                try {
                    LocalDate dateSortie = LocalDate.parse(getCellValueAsString(row.getCell(32)), dateFormat);
                    employee.setDateSortie(dateSortie);
                } catch (DateTimeParseException e) {
                    e.printStackTrace();
                }
                employee.setMail_capgemini(getCellValueAsString(row.getCell(33)));
                employee.setTelephone(getCellValueAsLong(row.getCell(34)));
                employee.setDesignation(getCellValueAsString(row.getCell(35)));
                employee.setProfessional_community(getCellValueAsString(row.getCell(36)));

                String roleFamilyName = getCellValueAsString(row.getCell(37));
                RoleFamily roleFamily = roleFamilyRepository.findByName(roleFamilyName);
                employee.setRoleFamily(roleFamily);

                String roleName = getCellValueAsString(row.getCell(38));
                RoleName roleName1 = roleNameRepository.findByName(roleName);
                employee.setRoleName(roleName1);

                employee.setCnss(getCellValueAsString(row.getCell(40)));
                employee.setAdresse_cnss(getCellValueAsString(row.getCell(41)));
                employee.setRib(getCellValueAsString(row.getCell(42)));

                String nationalityName = getCellValueAsString(row.getCell(43));
                Nationality nationality = nationalityRepository.findByName(nationalityName);
                employee.setNationality(nationality);

                employees.add(employee);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        employerRepository.saveAll(employees);
        return employees;
    }

    private long getCellValueAsLong(Cell cell) {
        if (cell == null) return 0L;
        switch (cell.getCellType()) {
            case STRING:
                try {
                    return Long.parseLong(cell.getStringCellValue());
                } catch (NumberFormatException e) {
                    return 0L; // or handle the error as needed
                }
            case NUMERIC:
                return (long) cell.getNumericCellValue();
            default:
                return 0L;
        }
    }

    private String getCellValueAsString(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }

    private double getCellValueAsDouble(Cell cell) {
        if (cell == null) return 0.0;
        switch (cell.getCellType()) {
            case STRING:
                try {
                    return Double.parseDouble(cell.getStringCellValue());
                } catch (NumberFormatException e) {
                    return 0.0; // or handle the error as needed
                }
            case NUMERIC:
                return cell.getNumericCellValue();
            default:
                return 0.0;
        }
    }


}

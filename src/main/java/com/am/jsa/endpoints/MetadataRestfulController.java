package com.am.jsa.endpoints;

import com.am.jsa.common.constants.UrlConstant;
import com.am.jsa.logger.AmLogger;
import com.am.jsa.metadata.entity.*;
import com.am.jsa.metadata.service.MetadataService;
import com.am.jsa.servicehandler.AmResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UrlConstant.BASE_SERVICE_URL + UrlConstant.METADATA)
public class MetadataRestfulController {
	
	@Autowired
    private MetadataService metadataService;

	@GetMapping("user-type/{id}")
	public ResponseEntity getUserType(@PathVariable Long id) {
		AmLogger.info(this.getClass(), "getUserType");
		return AmResponse.successResponse(metadataService.getUserType(id));
	}

	@GetMapping("user-types")
	public ResponseEntity getAllUserTypes() {
		AmLogger.info(this.getClass(), "getAllUserTypes");
		return AmResponse.successResponse(metadataService.getUserTypes());
	}

    @PostMapping("user-types")
    public ResponseEntity addUserType(@RequestBody UserType userType) {
        AmLogger.info(this.getClass(), "addUserType");
        return AmResponse.successResponse(metadataService.saveUserType(userType));
    }

    @PutMapping("user-types")
    public ResponseEntity updateUserType(@RequestBody UserType userType) {
        AmLogger.info(this.getClass(), "updateUserType");
        return AmResponse.successResponse(metadataService.updateUserType(userType));
    }

    @GetMapping("countries")
    public ResponseEntity getAllCountries() {
        AmLogger.info(this.getClass(), "getAllCountries");
        return AmResponse.successResponse(metadataService.getCountries());
    }

    @GetMapping("cities")
    public ResponseEntity getAllCities() {
        AmLogger.info(this.getClass(), "getAllCountries");
        return AmResponse.successResponse(metadataService.getCities());
    }


    @GetMapping("age-range/{id}")
    public ResponseEntity getAgeRange(@PathVariable Integer id) {
        AmLogger.info(this.getClass(), "getAgeRange");
        return AmResponse.successResponse(metadataService.getAgeRange(id));
    }

    @GetMapping("age-range")
    public ResponseEntity getAllAgeRange() {
        AmLogger.info(this.getClass(), "getAllAgeRange");
        return AmResponse.successResponse(metadataService.getAgeRange());
    }

    @PostMapping("age-range")
    public ResponseEntity addAgeRange(@RequestBody AgeRange ageRange) {
        AmLogger.info(this.getClass(), "addAgeRange");
        return AmResponse.successResponse(metadataService.saveAgeRange(ageRange));
    }

    @PutMapping("age-range")
    public ResponseEntity updateAgeRange(@RequestBody AgeRange ageRange) {
        AmLogger.info(this.getClass(), "updateAgeRange");
        return AmResponse.successResponse(metadataService.updateAgeRange(ageRange));
    }

    @GetMapping("career-level/{id}")
    public ResponseEntity getCareerLevel(@PathVariable("id") Integer id) {
        AmLogger.info(this.getClass(), "getCareerLevel");
        return AmResponse.successResponse(metadataService.getCareerLevel(id));
    }

    @GetMapping("career-level")
    public ResponseEntity getAllCareerLevel() {
        AmLogger.info(this.getClass(), "getAllCareerLevel");
        return AmResponse.successResponse(metadataService.getCareerLevel());
    }

    @PostMapping("career-level")
    public ResponseEntity addCareerLevel(@RequestBody CareerLevel careerLevel) {
        AmLogger.info(this.getClass(), "addCareerLevel");
        return AmResponse.successResponse(metadataService.saveCareerLevel(careerLevel));
    }

    @PutMapping("career-level")
    public ResponseEntity updateCareerLevel(@RequestBody CareerLevel careerLevel) {
        AmLogger.info(this.getClass(), "updateCareerLevel");
        return AmResponse.successResponse(metadataService.updateCareerLevel(careerLevel));
    }

    @GetMapping("category/{id}")
    public ResponseEntity getCategory(@PathVariable("id") Integer id) {
        AmLogger.info(this.getClass(), "getCategory");
        return AmResponse.successResponse(metadataService.getCategory(id));
    }

    @GetMapping("category")
    public ResponseEntity getAllCategory() {
        AmLogger.info(this.getClass(), "getAllCategory");
        return AmResponse.successResponse(metadataService.getCategory());
    }

    @PostMapping("category")
    public ResponseEntity addCategory(@RequestBody Category category) {
        AmLogger.info(this.getClass(), "addCategory");
        return AmResponse.successResponse(metadataService.saveCategory(category));
    }

    @PutMapping("category")
    public ResponseEntity updateCategory(@RequestBody Category category) {
        AmLogger.info(this.getClass(), "updateCategory");
        return AmResponse.successResponse(metadataService.updateCategory(category));
    }

    @GetMapping("currency/{id}")
    public ResponseEntity getCurrency(@PathVariable("id") Integer id) {
        AmLogger.info(this.getClass(), "getCurrency");
        return AmResponse.successResponse(metadataService.getCurrency(id));
    }

    @GetMapping("currency")
    public ResponseEntity getAllCurrency() {
        AmLogger.info(this.getClass(), "getAllCurrency");
        return AmResponse.successResponse(metadataService.getCurrency());
    }

    @PostMapping("currency")
    public ResponseEntity addCurrency(@RequestBody Currency currency) {
        AmLogger.info(this.getClass(), "addCurrency");
        return AmResponse.successResponse(metadataService.saveCurrency(currency));
    }

    @PutMapping("currency")
    public ResponseEntity updateCurrency(@RequestBody Currency currency) {
        AmLogger.info(this.getClass(), "updateCurrency");
        return AmResponse.successResponse(metadataService.updateCurrency(currency));
    }

    @GetMapping("education-type/{id}")
    
    public ResponseEntity getEducationType(@PathVariable("id") Integer id) {
        AmLogger.info(this.getClass(), "getEducationType");
        return AmResponse.successResponse(metadataService.getEducationType(id));
    }

    @GetMapping("education-type")    
    public ResponseEntity getAllEducationType() {
        AmLogger.info(this.getClass(), "getAllEducationType");
        return AmResponse.successResponse(metadataService.getEducationType());
    }

    @PostMapping("education-type")    
    public ResponseEntity addEducationType(@RequestBody EducationType educationType) {
        AmLogger.info(this.getClass(), "addEducationType");
        return AmResponse.successResponse(metadataService.saveEducationType(educationType));
    }

    @PutMapping("education-type")    
    public ResponseEntity updateEducationType(@RequestBody EducationType educationType) {
        AmLogger.info(this.getClass(), "updateEducationType");
        return AmResponse.successResponse(metadataService.updateEducationType(educationType));
    }

    @GetMapping("experience-range/{id}")    
    public ResponseEntity getExperienceRange(@PathVariable("id") Integer id) {
        AmLogger.info(this.getClass(), "getExperienceRange");
        return AmResponse.successResponse(metadataService.getExperienceRange(id));
    }

    @GetMapping("experience-range")    
    public ResponseEntity getAllExperienceRange() {
        AmLogger.info(this.getClass(), "getAllExperienceRange");
        return AmResponse.successResponse(metadataService.getExperienceRange());
    }

    @PostMapping("experience-range")    
    public ResponseEntity addExperienceRange(@RequestBody ExperienceRange experienceRange) {
        AmLogger.info(this.getClass(), "addExperienceRange");
        return AmResponse.successResponse(metadataService.saveExperienceRange(experienceRange));
    }
    
    @PutMapping("experience-range")    
    public ResponseEntity updateExperienceRange(@RequestBody ExperienceRange experienceRange) {
        AmLogger.info(this.getClass(), "updateExperienceRange");
        return AmResponse.successResponse(metadataService.updateExperienceRange(experienceRange));
    }

    @GetMapping("gender/{id}")    
    public ResponseEntity getGender(@PathVariable("id") Integer id) {
        AmLogger.info(this.getClass(), "getGender");
        return AmResponse.successResponse(metadataService.getGender(id));
    }

    @GetMapping("gender")    
    public ResponseEntity getAllGender() {
        AmLogger.info(this.getClass(), "getAllGender");
        return AmResponse.successResponse(metadataService.getGender());
    }

    @PostMapping("gender")    
    public ResponseEntity addGender(@RequestBody Gender gender) {
        AmLogger.info(this.getClass(), "addGender");
        return AmResponse.successResponse(metadataService.saveGender(gender));
    }

    @PutMapping("gender")    
    public ResponseEntity updateGender(@RequestBody Gender gender) {
        AmLogger.info(this.getClass(), "updateGender");
        return AmResponse.successResponse(metadataService.updateGender(gender));
    }

    @GetMapping("industry/{id}")    
    public ResponseEntity getIndustry(@PathVariable("id") Integer id) {
        AmLogger.info(this.getClass(), "getIndustry");
        return AmResponse.successResponse(metadataService.getIndustry(id));
    }

    @GetMapping("industry")    
    public ResponseEntity getAllIndustry() {
        AmLogger.info(this.getClass(), "getAllIndustry");
        return AmResponse.successResponse(metadataService.getIndustry());
    }

    @PostMapping("industry")    
    public ResponseEntity addIndustry(@RequestBody Industry industry) {
        AmLogger.info(this.getClass(), "addIndustry");
        return AmResponse.successResponse(metadataService.saveIndustry(industry));
    }

    @PutMapping("industry")
    public ResponseEntity updateIndustry(@RequestBody Industry industry) {
        AmLogger.info(this.getClass(), "updateIndustry");
        return AmResponse.successResponse(metadataService.updateIndustry(industry));
    }

    @GetMapping("job-title/{id}")
    public ResponseEntity getJobTitle(@PathVariable("id") Integer id) {
        AmLogger.info(this.getClass(), "getJobTitle");
        return AmResponse.successResponse(metadataService.getJobTitle(id));
    }

    @GetMapping("job-title")
    public ResponseEntity getAllJobTitle() {
        AmLogger.info(this.getClass(), "getAllJobTitle");
        return AmResponse.successResponse(metadataService.getJobTitle());
    }

    @PostMapping("job-title")
    public ResponseEntity addJobTitle(@RequestBody JobTitle jobTitle) {
        AmLogger.info(this.getClass(), "addJobTitle");
        return AmResponse.successResponse(metadataService.saveJobTitle(jobTitle));
    }

    @PutMapping("job-title")
    public ResponseEntity updateJobTitle(@RequestBody JobTitle jobTitle) {
        AmLogger.info(this.getClass(), "updateJobTitle");
        return AmResponse.successResponse(metadataService.updateJobTitle(jobTitle));
    }

    @GetMapping("job-type/{id}")
    public ResponseEntity getJobType(@PathVariable("id") Integer id) {
        AmLogger.info(this.getClass(), "getJobType");
        return AmResponse.successResponse(metadataService.getJobType(id));
    }

    @GetMapping("job-type")
    public ResponseEntity getAllJobType() {
        AmLogger.info(this.getClass(), "getAllJobType");
        return AmResponse.successResponse(metadataService.getJobType());
    }

    @PostMapping("job-type")
    public ResponseEntity addJobType(@RequestBody JobType jobType) {
        AmLogger.info(this.getClass(), "addJobType");
        return AmResponse.successResponse(metadataService.saveJobType(jobType));
    }

    @PutMapping("job-type")
    public ResponseEntity updateJobType(@RequestBody JobType jobType) {
        AmLogger.info(this.getClass(), "updateJobType");
        return AmResponse.successResponse(metadataService.updateJobType(jobType));
    }

    @GetMapping("language/{id}")
    public ResponseEntity getLanguage(@PathVariable("id") Integer id) {
        AmLogger.info(this.getClass(), "getLanguage");
        return AmResponse.successResponse(metadataService.getLanguage(id));
    }

    @GetMapping("language")
    public ResponseEntity getAllLanguage() {
        AmLogger.info(this.getClass(), "getAllLanguage");
        return AmResponse.successResponse(metadataService.getLanguage());
    }

    @PostMapping("language")
    public ResponseEntity addLanguage(@RequestBody Language language) {
        AmLogger.info(this.getClass(), "addLanguage");
        return AmResponse.successResponse(metadataService.saveLanguage(language));
    }

    @PutMapping("language")
    public ResponseEntity updateLanguage(@RequestBody Language language) {
        AmLogger.info(this.getClass(), "updateLanguage");
        return AmResponse.successResponse(metadataService.updateLanguage(language));
    }

    @GetMapping("membership-type/{id}")
    public ResponseEntity getMembershipType(@PathVariable("id") Integer id) {
        AmLogger.info(this.getClass(), "getMembershipType");
        return AmResponse.successResponse(metadataService.getMembershipType(id));
    }

    @GetMapping("membership-type")
    public ResponseEntity getAllMembershipType() {
        AmLogger.info(this.getClass(), "getAllMembershipType");
        return AmResponse.successResponse(metadataService.getMembershipType());
    }

    @PostMapping("membership-type")
    public ResponseEntity addMembershipType(@RequestBody MembershipType membershipType) {
        AmLogger.info(this.getClass(), "addMembershipType");
        return AmResponse.successResponse(metadataService.saveMembershipType(membershipType));
    }

    @PutMapping("membership-type")
    public ResponseEntity updateMembershipType(@RequestBody MembershipType membershipType) {
        AmLogger.info(this.getClass(), "updateMembershipType");
        return AmResponse.successResponse(metadataService.updateMembershipType(membershipType));
    }

    @GetMapping("merchant-type/{id}")
    public ResponseEntity getMerchantType(@PathVariable("id") Integer id) {
        AmLogger.info(this.getClass(), "getMerchantType");
        return AmResponse.successResponse(metadataService.getMerchantType(id));
    }

    @GetMapping("merchant-type")
    public ResponseEntity getAllMerchantType() {
        AmLogger.info(this.getClass(), "getAllMerchantType");
        return AmResponse.successResponse(metadataService.getMerchantType());
    }

    @PostMapping("merchant-type")
    public ResponseEntity addMerchantType(@RequestBody MerchantType merchantType) {
        AmLogger.info(this.getClass(), "addMerchantType");
        return AmResponse.successResponse(metadataService.saveMerchantType(merchantType));
    }

    @PutMapping("merchant-type")
    public ResponseEntity updateMerchantType(@RequestBody MerchantType merchantType) {
        AmLogger.info(this.getClass(), "updateMerchantType");
        return AmResponse.successResponse(metadataService.updateMerchantType(merchantType));
    }

    @GetMapping("offered-salary-range/{id}")
    public ResponseEntity getOfferedSalaryRange(@PathVariable("id") Integer id) {
        AmLogger.info(this.getClass(), "getOfferedSalaryRange");
        return AmResponse.successResponse(metadataService.getOfferedSalaryRange(id));
    }

    @GetMapping("offered-salary-range")
    public ResponseEntity getAllOfferedSalaryRange() {
        AmLogger.info(this.getClass(), "getAllOfferedSalaryRange");
        return AmResponse.successResponse(metadataService.getOfferedSalaryRange());
    }

    @PostMapping("offered-salary-range")
    public ResponseEntity addOfferedSalaryRange(@RequestBody OfferedSalaryRange offeredSalaryRange) {
        AmLogger.info(this.getClass(), "addOfferedSalaryRange");
        return AmResponse.successResponse(metadataService.saveOfferedSalaryRange(offeredSalaryRange));
    }

    @PutMapping("offered-salary-range")
    public ResponseEntity updateOfferedSalaryRange(@RequestBody OfferedSalaryRange offeredSalaryRange) {
        AmLogger.info(this.getClass(), "updateOfferedSalaryRange");
        return AmResponse.successResponse(metadataService.updateOfferedSalaryRange(offeredSalaryRange));
    }

    @GetMapping("qualification/{id}")
    public ResponseEntity getQualification(@PathVariable("id") Integer id) {
        AmLogger.info(this.getClass(), "getQualification");
        return AmResponse.successResponse(metadataService.getQualification(id));
    }

    @GetMapping("qualification")
    public ResponseEntity getAllQualification() {
        AmLogger.info(this.getClass(), "getAllQualification");
        return AmResponse.successResponse(metadataService.getQualification());
    }

    @PostMapping("qualification")
    public ResponseEntity addQualification(@RequestBody Qualification qualification) {
        AmLogger.info(this.getClass(), "addQualification");
        return AmResponse.successResponse(metadataService.saveQualification(qualification));
    }

    @PutMapping("qualification")
    public ResponseEntity updateQualification(@RequestBody Qualification qualification) {
        AmLogger.info(this.getClass(), "updateQualification");
        return AmResponse.successResponse(metadataService.updateQualification(qualification));
    }

    @GetMapping("skill/{id}")
    public ResponseEntity getSkill(@PathVariable("id") Integer id) {
        AmLogger.info(this.getClass(), "getSkill");
        return AmResponse.successResponse(metadataService.getSkill(id));
    }

    @GetMapping("skill")
    public ResponseEntity getAllSkill() {
        AmLogger.info(this.getClass(), "getAllSkill");
        return AmResponse.successResponse(metadataService.getSkill());
    }

    @PostMapping("skill")
    public ResponseEntity addSkill(@RequestBody Skill skill) {
        AmLogger.info(this.getClass(), "addSkill");
        return AmResponse.successResponse(metadataService.saveSkill(skill));
    }

    @PutMapping("skill")
    public ResponseEntity updateSkill(@RequestBody Skill skill) {
        AmLogger.info(this.getClass(), "updateSkill");
        return AmResponse.successResponse(metadataService.updateSkill(skill));
    }

    @GetMapping("team-size/{id}")
    public ResponseEntity getTeamSize(@PathVariable("id") Integer id) {
        AmLogger.info(this.getClass(), "getTeamSize");
        return AmResponse.successResponse(metadataService.getTeamSize(id));
    }

    @GetMapping("team-size")
    public ResponseEntity getAllTeamSize() {
        AmLogger.info(this.getClass(), "getAllTeamSize");
        return AmResponse.successResponse(metadataService.getTeamSize());
    }

    @PostMapping("team-size")
    public ResponseEntity addTeamSize(@RequestBody TeamSize teamSize) {
        AmLogger.info(this.getClass(), "addTeamSize");
        return AmResponse.successResponse(metadataService.saveTeamSize(teamSize));
    }

    @PutMapping("team-size")
    public ResponseEntity updateTeamSize(@RequestBody TeamSize teamSize) {
        AmLogger.info(this.getClass(), "updateTeamSize");
        return AmResponse.successResponse(metadataService.updateTeamSize(teamSize));
    }
}

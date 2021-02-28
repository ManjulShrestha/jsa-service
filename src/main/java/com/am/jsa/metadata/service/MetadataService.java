package com.am.jsa.metadata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.am.jsa.metadata.repository.*;
import com.am.jsa.metadata.entity.*;

import java.util.List;

@Component
public class MetadataService {

    @Autowired
    private UserTypeRepository userTypeRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private AgeRangeRepository ageRangeRepository;

    @Autowired
    private CareerLevelRepository careerLevelRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private EducationTypeRepository educationTypeRepository;

    @Autowired
    private ExperienceRangeRepository experienceRangeRepository;

    @Autowired
    private GenderRepository genderRepository;

    @Autowired
    private IndustryRepository industryRepository;

    @Autowired
    private JobTitleRepository jobTitleRepository;

    @Autowired
    private JobTypeRepository jobTypeRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private MembershipTypeRepository membershipTypeRepository;

    @Autowired
    private MerchantTypeRepository merchantTypeRepository;

    @Autowired
    private OfferedSalaryRangeRepository offeredSalaryRangeRepository;

    @Autowired
    private QualificationRepository qualificationRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private TeamSizeRepository teamSizeRepository;

    public UserType getUserType(Long id){
        return userTypeRepository.read(id);
    }

    public List<UserType> getUserTypes(){
        return userTypeRepository.findAll();
    }

    public UserType saveUserType(UserType userType){
        userTypeRepository.save(userType);
        return userType;
    }

    public UserType updateUserType(UserType userType){
        userTypeRepository.save(userType);
        return userType;
    }

    public List<Country> getCountries(){
        return countryRepository.findAll();
    }

    public List<City> getCities(){
        return cityRepository.findAll();
    }

    public AgeRange getAgeRange(int id){
        return ageRangeRepository.read(id);
    }

    public List<AgeRange> getAgeRange(){
        return ageRangeRepository.findAll();
    }

    public AgeRange saveAgeRange(AgeRange ageRange){
        ageRangeRepository.save(ageRange);
        return ageRange;
    }

    public AgeRange updateAgeRange(AgeRange ageRange){
        ageRangeRepository.save(ageRange);
        return ageRange;
    }

    public CareerLevel getCareerLevel(int id){
        return careerLevelRepository.read(id);
    }

    public List<CareerLevel> getCareerLevel(){
        return careerLevelRepository.findAll();
    }

    public CareerLevel saveCareerLevel(CareerLevel careerLevel){
        careerLevelRepository.save(careerLevel);
        return careerLevel;
    }

    public CareerLevel updateCareerLevel(CareerLevel careerLevel){
        careerLevelRepository.save(careerLevel);
        return careerLevel;
    }

    public Category getCategory(int id){
        return categoryRepository.read(id);
    }

    public List<Category> getCategory(){
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category){
        categoryRepository.save(category);
        return category;
    }

    public Category updateCategory(Category category){
        categoryRepository.save(category);
        return category;
    }

    public Currency getCurrency(int id){
        return currencyRepository.read(id);
    }

    public List<Currency> getCurrency(){
        return currencyRepository.findAll();
    }

    public Currency saveCurrency(Currency currency){
        currencyRepository.save(currency);
        return currency;
    }

    public Currency updateCurrency(Currency currency){
        currencyRepository.save(currency);
        return currency;
    }

    public EducationType getEducationType(int id){
        return educationTypeRepository.read(id);
    }

    public List<EducationType> getEducationType(){
        return educationTypeRepository.findAll();
    }

    public EducationType saveEducationType(EducationType educationType){
        educationTypeRepository.save(educationType);
        return educationType;
    }

    public EducationType updateEducationType(EducationType educationType){
        educationTypeRepository.save(educationType);
        return educationType;
    }

    public ExperienceRange getExperienceRange(int id){
        return experienceRangeRepository.read(id);
    }

    public List<ExperienceRange> getExperienceRange(){
        return experienceRangeRepository.findAll();
    }

    public ExperienceRange saveExperienceRange(ExperienceRange experienceRange){
        experienceRangeRepository.save(experienceRange);
        return experienceRange;
    }

    public ExperienceRange updateExperienceRange(ExperienceRange experienceRange){
        experienceRangeRepository.save(experienceRange);
        return experienceRange;
    }

    public Gender getGender(int id){
        return genderRepository.read(id);
    }

    public List<Gender> getGender(){
        return genderRepository.findAll();
    }

    public Gender saveGender(Gender gender){
        genderRepository.save(gender);
        return gender;
    }

    public Gender updateGender(Gender gender){
        genderRepository.save(gender);
        return gender;
    }

    public Industry getIndustry(int id){
        return industryRepository.read(id);
    }

    public List<Industry> getIndustry(){
        return industryRepository.findAll();
    }

    public Industry saveIndustry(Industry industry){
        industryRepository.save(industry);
        return industry;
    }

    public Industry updateIndustry(Industry industry){
        industryRepository.save(industry);
        return industry;
    }

    public JobTitle getJobTitle(int id){
        return jobTitleRepository.read(id);
    }

    public List<JobTitle> getJobTitle(){
        return jobTitleRepository.findAll();
    }

    public JobTitle saveJobTitle(JobTitle jobTitle){
        jobTitleRepository.save(jobTitle);
        return jobTitle;
    }

    public JobTitle updateJobTitle(JobTitle jobTitle){
        jobTitleRepository.save(jobTitle);
        return jobTitle;
    }

    public JobType getJobType(int id){
        return jobTypeRepository.read(id);
    }

    public List<JobType> getJobType(){
        return jobTypeRepository.findAll();
    }

    public JobType saveJobType(JobType jobType){
        jobTypeRepository.save(jobType);
        return jobType;
    }

    public JobType updateJobType(JobType jobType){
        jobTypeRepository.save(jobType);
        return jobType;
    }

    public Language getLanguage(int id){
        return languageRepository.read(id);
    }

    public List<Language> getLanguage(){
        return languageRepository.findAll();
    }

    public Language saveLanguage(Language language){
        languageRepository.save(language);
        return language;
    }

    public Language updateLanguage(Language language){
        languageRepository.save(language);
        return language;
    }

    public MembershipType getMembershipType(int id){
        return membershipTypeRepository.read(id);
    }

    public List<MembershipType> getMembershipType(){
        return membershipTypeRepository.findAll();
    }

    public MembershipType saveMembershipType(MembershipType membershipType){
        membershipTypeRepository.save(membershipType);
        return membershipType;
    }

    public MembershipType updateMembershipType(MembershipType membershipType){
        membershipTypeRepository.save(membershipType);
        return membershipType;
    }

    public MerchantType getMerchantType(int id){
        return merchantTypeRepository.read(id);
    }

    public List<MerchantType> getMerchantType(){
        return merchantTypeRepository.findAll();
    }

    public MerchantType saveMerchantType(MerchantType merchantType){
        merchantTypeRepository.save(merchantType);
        return merchantType;
    }

    public MerchantType updateMerchantType(MerchantType merchantType){
        merchantTypeRepository.save(merchantType);
        return merchantType;
    }

    public OfferedSalaryRange getOfferedSalaryRange(int id){
        return offeredSalaryRangeRepository.read(id);
    }

    public List<OfferedSalaryRange> getOfferedSalaryRange(){
        return offeredSalaryRangeRepository.findAll();
    }

    public OfferedSalaryRange saveOfferedSalaryRange(OfferedSalaryRange offeredSalaryRange){
        offeredSalaryRangeRepository.save(offeredSalaryRange);
        return offeredSalaryRange;
    }

    public OfferedSalaryRange updateOfferedSalaryRange(OfferedSalaryRange offeredSalaryRange){
        offeredSalaryRangeRepository.save(offeredSalaryRange);
        return offeredSalaryRange;
    }

    public Qualification getQualification(int id){
        return qualificationRepository.read(id);
    }

    public List<Qualification> getQualification(){
        return qualificationRepository.findAll();
    }

    public Qualification saveQualification(Qualification qualification){
        qualificationRepository.save(qualification);
        return qualification;
    }

    public Qualification updateQualification(Qualification qualification){
        qualificationRepository.save(qualification);
        return qualification;
    }

    public Skill getSkill(int id){
        return skillRepository.read(id);
    }

    public List<Skill> getSkill(){
        return skillRepository.findAll();
    }

    public Skill saveSkill(Skill skill){
        skillRepository.save(skill);
        return skill;
    }

    public Skill updateSkill(Skill skill){
        skillRepository.save(skill);
        return skill;
    }

    public TeamSize getTeamSize(int id){
        return teamSizeRepository.read(id);
    }

    public List<TeamSize> getTeamSize(){
        return teamSizeRepository.findAll();
    }

    public TeamSize saveTeamSize(TeamSize teamSize){
        teamSizeRepository.save(teamSize);
        return teamSize;
    }

    public TeamSize updateTeamSize(TeamSize teamSize){
        teamSizeRepository.save(teamSize);
        return teamSize;
    }
}

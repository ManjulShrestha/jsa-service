package com.am.jsa.candidate.service;


import com.am.jsa.candidate.entity.*;
import com.am.jsa.candidate.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CandidateResumeService {

    @Autowired
    CandidateRepository candidateRepository;
    
    @Autowired
    CandidateResumeRepository candidateResumeRepository;

    @Autowired
    CandidateEducationRepository candidateEducationRepository;

    @Autowired
    CandidateAwardsRepository candidateAwardsRepository;

    @Autowired
    CandidatePortfolioRepository candidatePortfolioRepository;

    @Autowired
    CandidateProfessionalSikllsRepository candidateProfessionalSikllsRepository;

    @Autowired
    CandidateWorkExperienceRepository candidateWorkExperienceRepository;
  

    public List<CandidateResume> getCandidateResume(){
        return candidateResumeRepository.findAll();
    }

    public CandidateResume getCandidateResumeByCandidateId(Long candidateId){
        return candidateResumeRepository.getCandidateResumeByCandidateId(candidateId);
    }

    public CandidateResume getResumeById(Long id){
        return candidateResumeRepository.read(id);
    }

    public CandidateResume saveCandidateResume(CandidateResume candidateResume, Long candidateId){
        Candidate candidate=new Candidate();
        candidate.setId(candidateId);
        candidateResume.setCandidate(candidate);
        candidateResumeRepository.save(candidateResume);
        return candidateResumeRepository.read(candidateResume.getId());
    }

    public CandidateResume updateCandidateResume(CandidateResume candidateResume, Long candidateId){
        Candidate candidate=new Candidate();
        candidate.setId(candidateId);
        candidateResume.setCandidate(candidate);
        candidateResumeRepository.save(candidateResume);
        return candidateResumeRepository.read(candidateResume.getId());
    }

    public CandidateEducation saveCandidateEducation(CandidateEducation candidateEducation){
        candidateEducationRepository.save(candidateEducation);
        return candidateEducationRepository.read(candidateEducation.getId());
    }

    public CandidateEducation updateCandidateEducation(CandidateEducation candidateEducation){
        candidateEducationRepository.save(candidateEducation);
        return candidateEducationRepository.read(candidateEducation.getId());
    }

    public CandidateAwards saveCandidateAwards(CandidateAwards candidateAwards){
        candidateAwardsRepository.save(candidateAwards);
        return candidateAwardsRepository.read(candidateAwards.getId());
    }

    public CandidateAwards updateCandidateAwards(CandidateAwards candidateAwards){
        candidateAwardsRepository.save(candidateAwards);
        return candidateAwardsRepository.read(candidateAwards.getId());
    }

    public CandidatePortFolio saveCandidatePortFolio(CandidatePortFolio candidatePortFolio){
        candidatePortfolioRepository.save(candidatePortFolio);
        return candidatePortfolioRepository.read(candidatePortFolio.getId());
    }

    public CandidatePortFolio updateCandidatePortFolio(CandidatePortFolio candidatePortFolio){
        candidatePortfolioRepository.save(candidatePortFolio);
        return candidatePortfolioRepository.read(candidatePortFolio.getId());
    }

    public CandidateProfessionalSkills saveCandidateProfessionalSkills(CandidateProfessionalSkills candidateProfessionalSkills){
        candidateProfessionalSikllsRepository.save(candidateProfessionalSkills);
        return candidateProfessionalSikllsRepository.read(candidateProfessionalSkills.getId());
    }

    public CandidateProfessionalSkills updateCandidateProfessionalSkills(CandidateProfessionalSkills candidateProfessionalSkills){
        candidateProfessionalSikllsRepository.save(candidateProfessionalSkills);
        return candidateProfessionalSikllsRepository.read(candidateProfessionalSkills.getId());
    }

    public CandidateWorkExperience saveCandidateWorkExperience(CandidateWorkExperience candidateWorkExperience, Long resumeId){
        candidateWorkExperienceRepository.save(candidateWorkExperience);
        if(candidateWorkExperience.getPresent()){
            setPresentFalse(candidateWorkExperience.getId(),resumeId);
        }
        return candidateWorkExperienceRepository.read(candidateWorkExperience.getId());
    }

    public CandidateWorkExperience updateCandidateWorkExperience(CandidateWorkExperience candidateWorkExperience, Long resumeId){
        candidateWorkExperienceRepository.save(candidateWorkExperience);
        if(candidateWorkExperience.getPresent()){
            setPresentFalse(candidateWorkExperience.getId(),resumeId);
        }
        return candidateWorkExperienceRepository.read(candidateWorkExperience.getId());
    }

    public void setPresentFalse(Long candidateWorkExpId, Long resumeId){
        List<CandidateWorkExperience> candidateWorkExperiences=candidateWorkExperienceRepository.getSearchedCandidateWorkExperience(resumeId);
        for(CandidateWorkExperience workExperience:candidateWorkExperiences){
            if(!workExperience.getId().equals(candidateWorkExpId)){
                workExperience.setPresent(false);
                candidateWorkExperienceRepository.save(workExperience);
            }
        }
    }
}

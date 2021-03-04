package com.am.jsa.candidate.service;


import com.am.jsa.candidate.entity.Candidate;
import com.am.jsa.candidate.entity.CandidateResume;
import com.am.jsa.candidate.repository.CandidateRepository;
import com.am.jsa.company.entity.Company;
import com.am.jsa.company.repository.CompanyRepository;
import com.am.jsa.identity.entity.User;
import com.am.jsa.identity.repository.UserRepository;
import com.am.jsa.job.entity.Job;
import com.am.jsa.job.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CandidateService {

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JobRepository jobRepository;

    public List<Candidate> getCandidate(int page, int size){
        Pageable pageable= PageRequest.of(page,size);
        return candidateRepository.findAll(pageable).getContent();
    }

    @Transactional
    public Candidate saveCandidate(Candidate candidate){
        CandidateResume resume=new CandidateResume();
        candidate.setCandidateResume(resume);
        candidate.setReferenceInChildren();
        candidateRepository.save(candidate);
        User user=userRepository.read(candidate.getUser().getId());
        user.setFirstTimeLogin(false);
        userRepository.save(user);
        return candidateRepository.read(candidate.getId());
        //return candidateRepository.read(candidate.getId(),"with-resume");
    }

    public Candidate updateCandidate(Candidate candidate){
        candidate.setReferenceInChildren();
        candidateRepository.save(candidate);
        return candidateRepository.read(candidate.getId());
    }

    public Candidate getCandidateByUserId(Long userId){
        return candidateRepository.getCandidateByUserId(userId);
    }

    public Candidate getCandidateById(Long candidateId){
        return candidateRepository.read(candidateId);
    }

    public Long getCandidateCount(){
        return  candidateRepository.getCandidateCount();
    }

    public List<Job> getAppliedJobs(Long candidateId) {

        return  jobRepository.getAppliedJobs(candidateId);
    }

    public Long getAppliedJobsCount(Long candidateId) {
        return jobRepository.getAppliedJobsCount(candidateId);
    }

    public List<Company> getFollowedCompany(Long candidateId) {
        return companyRepository.getFollowedCompany(candidateId);
    }

    public Long getFollowedCompanyCount(Long candidateId) {
        return companyRepository.getFollowedCompanyCount(candidateId);
    }

    public Set<Long> favouriteJob(Long candiateId, Job job){
        Candidate candidate=candidateRepository.read(candiateId);
        //Candidate candidate=candidateRepository.read(candiateId,"with-resume");
        if (candidate.getJobFavouriteSetId() != null ) {
            for (Long jobId: candidate.getJobFavouriteSetId() ) {
                if(jobId.equals(job.getId())){
                    return null;
                }
            }
            candidate.getJobFavouriteSetId().add(job.getId());
        }else{
            Set<Long> jobs=new HashSet<>();
            jobs.add(job.getId());
            candidate.setJobFavouriteSetId(jobs);
        }
        candidate.setReferenceInChildren();
        candidateRepository.save(candidate);
        return candidate.getJobFavouriteSetId();
    }

    public Set<Long> unfavouriteJob(Long candiateId, Job job){
        //Candidate candidate=candidateRepository.read(candiateId,"with-resume");
        Candidate candidate=candidateRepository.read(candiateId);
        if (candidate.getJobFavouriteSetId() != null ) {
            for (Long jobId: candidate.getJobFavouriteSetId() ) {
                if(jobId.equals(job.getId())){
                    candidate.getJobFavouriteSetId().remove(job.getId());
                    break;
                }
            }
            candidate.setReferenceInChildren();
            candidateRepository.save(candidate);
        }
        return candidate.getJobFavouriteSetId();
    }
}

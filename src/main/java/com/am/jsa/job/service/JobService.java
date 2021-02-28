package com.am.jsa.job.service;

import com.am.jsa.candidate.entity.Candidate;
import com.am.jsa.candidate.repository.CandidateRepository;
import com.am.jsa.company.entity.CompanyPayments;
import com.am.jsa.company.repository.CompanyPaymentRepository;
import com.am.jsa.job.entity.Job;
import com.am.jsa.job.entity.JobCandidateApplication;
import com.am.jsa.job.repository.JobApplicationRepository;
import com.am.jsa.job.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class JobService {

    @Autowired
    JobRepository jobRepository;

    @Autowired
    JobApplicationRepository jobApplicationRepository;

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    CompanyPaymentRepository companyPaymentRepository;

    public List<Job> getJobs(){
        return jobRepository.findAll();
    }

    public Long getJobCount(){
        return jobRepository.getTotalJobCount();
    }

    public Job getJobById(int id){
        return jobRepository.read(id);
    }

    public Job saveJob(Job job){
        jobRepository.save(job);
        CompanyPayments companyPayments=job.getCompany().getLatestPayment();
        companyPayments.setNoOfJobPosted(companyPayments.getNoOfJobPosted()+1);
        companyPayments.setCompany(job.getCompany());
        companyPaymentRepository.save(companyPayments);
        return jobRepository.read(job.getId());
    }

    public Job updateJob(Job job){
        jobRepository.save(job);
        return jobRepository.read(job.getId());
    }

    public boolean applyForJob(int jobId, Candidate candidate){
        Job job=jobRepository.read(jobId);
        if (job.getCandidateApplicationSetId() != null ) {
            for (Long jobCandidateId: job.getCandidateApplicationSetId()) {
                if(jobCandidateId.equals(candidate.getId())){
                    return false;
                }
            }
            job.getCandidateApplicationSetId().add(candidate.getId());
        }else{
            Set<Long> candidates=new HashSet<>();
            candidates.add(candidate.getId());
            job.setCandidateApplicationSetId(candidates);
        }
        job.setApplied(job.getApplied()+1);
        jobRepository.save(job);
        return true;
    }

    public boolean viewJob(int jobId, Candidate candidate){
        Job job=jobRepository.read(jobId);
        if (job.getCandidateViewSetId() != null ) {
            for (Long jobCandidateId: job.getCandidateViewSetId()) {
                if(jobCandidateId.equals(candidate.getId())){
                    return false;
                }
            }
            job.getCandidateViewSetId().add(candidate.getId());
        }else{
            Set<Long> candidates=new HashSet<>();
            candidates.add(candidate.getId());
            job.setCandidateViewSetId(candidates);
        }
        job.setViewed(job.getViewed()+1);
        jobRepository.save(job);
        return true;
    }

    public List<JobCandidateApplication> getAppliedCandidates(int companyId){
        List<Integer> jobIds=jobRepository.getJobsOfCompany(companyId);
        List<JobCandidateApplication> jobCandidateApplicationList=jobApplicationRepository.getSearchedApplicaton(jobIds);
        for(JobCandidateApplication jobCandidateApplication:jobCandidateApplicationList){
            jobCandidateApplication.setCandidate(candidateRepository.read(jobCandidateApplication.getCandidateId()));
            jobCandidateApplication.setJob(jobRepository.read(jobCandidateApplication.getJobId()));
        }
        return jobCandidateApplicationList;
    }

    public JobCandidateApplication shortlistCandidate(JobCandidateApplication jobCandidateApplication){
        jobApplicationRepository.shortList(jobCandidateApplication.getShortlisted(),jobCandidateApplication.getJobId(),jobCandidateApplication.getCandidateId());
        return jobCandidateApplication;

    }

    public List<Job> getJobByCategory(List<Integer> categoryIds){
        return jobRepository.getJobByCategory(categoryIds);
    }

    public Long getJobCountByCategory(List<Integer> categoryIds){
        return jobRepository.getJobCountByCategory(categoryIds);
    }

}

package com.am.jsa.company.service;


import com.am.jsa.candidate.entity.Candidate;
import com.am.jsa.company.entity.Company;
import com.am.jsa.company.entity.CompanyPayments;
import com.am.jsa.company.repository.*;
import com.am.jsa.identity.entity.Role;
import com.am.jsa.identity.entity.User;
import com.am.jsa.identity.repository.RoleRepository;
import com.am.jsa.identity.repository.UserRepository;
import com.am.jsa.job.repository.JobRepository;
import com.am.jsa.metadata.service.MetadataService;
import com.am.jsa.payment.PaymentServiceImpl;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    JobRepository jobRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PaymentServiceImpl paymentService;

    @Autowired
    CompanyPaymentRepository companyPaymentRepository;

    @Autowired
    MetadataService metadataService;

    @Autowired
    RoleRepository roleRepository;

    public List<Company> getCompanies(){
       List<Company> companies=companyRepository.findAll();
        for(Company company:companies){
            company.setJobCount(jobRepository.getJobCount(company.getId()));
        }
        return companies;
    }

    public Company saveCompany(Company company){
        companyRepository.save(company);
        User user=userRepository.read(company.getUser().getId());
        user.setFirstTimeLogin(false);
        userRepository.save(user);
        return companyRepository.read(company.getId());
    }

    public Company updateCompany(Company company){
        companyRepository.save(company);
        return companyRepository.read(company.getId());
    }

    public Company getCompanyByUserId(Long userId){
        return companyRepository.getCompanyByUserId(userId);
    }

    public Company getCompanyById(Long id){
        return companyRepository.read(id);
      //  return companyRepository.read(id,"withJob");
    }

    public Company getCompanyByJobId(Long jobId){
        long companyId= jobRepository.getCompanyIdByJobId(jobId);
        return companyRepository.read(companyId);
    }

    public Long getCompanyCount(){
        return companyRepository.getCompanyCount();
    }

    public List<CompanyPayments> getCompanyPaymentByCompanyId(Long companyId){
        return companyPaymentRepository.getCompanyPaymentsByCompanyId(companyId);
    }

    public CompanyPayments getLatestCompanyPaymentByCompanyId(Long companyId){
        return companyPaymentRepository.getLatestCompanyPaymentsByCompanyId(companyId);
    }

    public boolean followCompany(Long companyId, Candidate candidate){
        Company company=companyRepository.read(companyId);
        if (company.getCandidateFollowSetId() != null ) {
            for (Long candidateId: company.getCandidateFollowSetId() ) {
                if(candidateId.equals(candidate.getId())){
                    return false;
                }
            }
            company.getCandidateFollowSetId() .add(candidate.getId());
        }else{
            Set<Long> candidateId=new HashSet<>();
            candidateId.add(candidate.getId());
            company.setCandidateFollowSetId(candidateId);
        }
        company.setFollowers(company.getFollowers()+1);
        companyRepository.save(company);
        return true;
    }

    public boolean viewCompany(Long companyId, Candidate candidate){
        Company company=companyRepository.read(companyId);
        if (company.getCandidateViewSetId() != null ) {
            for (Long candidateId: company.getCandidateViewSetId() ) {
                if(candidateId.equals(candidate.getId())){
                    return false;
                }
            }
            company.getCandidateViewSetId().add(candidate.getId());
        }else{
            Set<Long> candidates=new HashSet<>();
            candidates.add(candidate.getId());
            company.setCandidateViewSetId(candidates);
        }
        company.setViewers(company.getViewers()+1);
        companyRepository.save(company);
        return true;
    }

    public CompanyPayments makePayment(CompanyPayments companyPayments){
        if(companyPayments.getPaymentAmount()==99){
            companyPayments.setMembershipType(metadataService.getMembershipType(2));
            companyPayments.setNoOfJobSlots(2);
        }else if(companyPayments.getPaymentAmount()==250){
            companyPayments.setMembershipType(metadataService.getMembershipType(3));
            companyPayments.setNoOfJobSlots(10);
        }else if(companyPayments.getPaymentAmount()==500){
            companyPayments.setMembershipType(metadataService.getMembershipType(4));
        }else if(companyPayments.getPaymentAmount()==1000){
            companyPayments.setMembershipType(metadataService.getMembershipType(5));
        }
        companyPayments.setStartDate(new Date());
        companyPayments.setEndDate(DateUtils.addMonths(new Date(), 1));
        companyPayments.setPaymentDetail(paymentService.chargeCreditCard(companyPayments.getPaymentDetail()));
        setJobSlots(companyPayments);
        companyPayments.setNoOfJobPosted(0);
        companyPaymentRepository.save(companyPayments);
        addRoleToUser(companyPayments);
        return companyPaymentRepository.read(companyPayments.getId());
    }

    public void addRoleToUser(CompanyPayments companyPayments){
        User user=userRepository.read(companyPayments.getCompany().getUser().getId());
        String roleName="";

       switch (Integer.parseInt(companyPayments.getMembershipType().getId()+"")){
           case 2:
               roleName="access-level-company-99";
               break;
           case 3:
               roleName="access-level-company-250";
               break;
           case 4:
               roleName="access-level-company-500";
               break;
           case 5:
               roleName="access-level-company-1000";
               break;
            default:
                roleName="access-level-company";
                break;
       }
       Set<Role> roleSet = new HashSet<>(roleRepository.getRolesByName(roleName));
       user.setRoleList(roleSet);
       userRepository.save(user);
    }

    public void setJobSlots(CompanyPayments companyPayments){
        switch (Integer.parseInt(companyPayments.getMembershipType().getId()+"")){
            case 2:
                companyPayments.setNoOfJobSlots(2);
                break;
            case 3:
                companyPayments.setNoOfJobSlots(10);
                break;
            case 4:
            case 5:
                companyPayments.setNoOfJobSlots(-1);
                break;
            default:
                companyPayments.setNoOfJobSlots(0);
                break;
        }
    }
}

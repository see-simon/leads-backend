package com.example.Leads.Services;


import com.example.Leads.Entities.Leads;
import com.example.Leads.Repository.LeadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadService {
    private  final LeadRepository leadRepository;

    public LeadService(LeadRepository leadRepository) {
        this.leadRepository = leadRepository;
    }

    public Leads save(Leads lead) {
        return leadRepository.save(lead);
    }

    public List<Leads> getAll() {
        return leadRepository.findAll(); // No casting needed
    }

}

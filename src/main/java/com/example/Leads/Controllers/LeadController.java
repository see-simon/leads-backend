package com.example.Leads.Controllers;
import com.example.Leads.Entities.Leads;
import com.example.Leads.Repository.LeadRepository;
import com.example.Leads.Services.EmailService;
import com.example.Leads.Services.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class LeadController {
    @Autowired
    private LeadRepository leadRepository;

    private final LeadService leadService;
    private final EmailService emailService;

    public LeadController(LeadService leadService, EmailService emailService) {
        this.leadService = leadService;
        this.emailService = emailService;
    }

    @PostMapping("/leads")
    public Leads submitLead(@RequestBody Leads lead) {
        // 1. Save to PostgreSQL database
        Leads savedLead = leadService.save(lead);

        // 2. Trigger the email notification
        emailService.sendLeadEmail(
                savedLead.getName(),
                savedLead.getSurname(),
                savedLead.getEmail(),
                savedLead.getPhoneNumber(),
                savedLead.getDescription()  // Fixed: must match the Entity field name
        );

        return savedLead;
    }

    @GetMapping("/leads")
    public Iterable<Leads> getAllLeads() {
            return leadRepository.findAll();
    }


}

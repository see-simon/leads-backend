package com.example.Leads.Repository;

import com.example.Leads.Entities.Leads;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LeadRepository extends JpaRepository <Leads, Long> {

}

package com.applicances.profile;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppliancesProfileRepository extends JpaRepository<AppliancesList, Long>{

	
}

package ua.kpi.its.lab.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import ua.kpi.its.lab.data.entity.Enterprise

interface EnterpriseRepository : JpaRepository<Enterprise, Long>

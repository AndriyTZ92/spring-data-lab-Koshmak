package ua.kpi.its.lab.data.svc.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.kpi.its.lab.data.entity.Enterprise
import ua.kpi.its.lab.data.repo.EnterpriseRepository
import ua.kpi.its.lab.data.svc.EnterpriseService
import java.util.*

@Service
class EnterpriseServiceImpl @Autowired constructor(
    private val enterpriseRepository: EnterpriseRepository
) : EnterpriseService {

    override fun createEnterprise(enterprise: Enterprise): Enterprise {
        return enterpriseRepository.save(enterprise)
    }

    override fun getEnterpriseById(id: Long): Optional<Enterprise> {
        return enterpriseRepository.findById(id)
    }

    override fun getAllEnterprises(): List<Enterprise> {
        return enterpriseRepository.findAll()
    }

    override fun updateEnterprise(enterprise: Enterprise): Enterprise {
        return enterpriseRepository.save(enterprise)
    }

    override fun deleteEnterprise(id: Long) {
        enterpriseRepository.deleteById(id)
    }
}

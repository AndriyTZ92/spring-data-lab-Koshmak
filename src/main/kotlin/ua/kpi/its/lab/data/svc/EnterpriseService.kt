package ua.kpi.its.lab.data.svc

import ua.kpi.its.lab.data.entity.Enterprise
import java.util.*

interface EnterpriseService {
    fun createEnterprise(enterprise: Enterprise): Enterprise
    fun getEnterpriseById(id: Long): Optional<Enterprise>
    fun getAllEnterprises(): List<Enterprise>
    fun updateEnterprise(enterprise: Enterprise): Enterprise
    fun deleteEnterprise(id: Long)
}

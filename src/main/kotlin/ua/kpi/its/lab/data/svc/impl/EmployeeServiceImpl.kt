package ua.kpi.its.lab.data.svc.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ua.kpi.its.lab.data.entity.Employee
import ua.kpi.its.lab.data.repo.EmployeeRepository
import ua.kpi.its.lab.data.svc.EmployeeService
import java.util.*

@Service
class EmployeeServiceImpl @Autowired constructor(
    private val employeeRepository: EmployeeRepository
) : EmployeeService {

    override fun createEmployee(employee: Employee): Employee {
        return employeeRepository.save(employee)
    }

    override fun getEmployeeById(id: Long): Optional<Employee> {
        return employeeRepository.findById(id)
    }

    override fun getAllEmployees(): List<Employee> {
        return employeeRepository.findAll()
    }

    override fun updateEmployee(employee: Employee): Employee {
        return employeeRepository.save(employee)
    }

    override fun deleteEmployee(id: Long) {
        employeeRepository.deleteById(id)
    }
}

package ua.kpi.its.lab.data.svc

import ua.kpi.its.lab.data.entity.Employee
import java.util.*

interface EmployeeService {
    fun createEmployee(employee: Employee): Employee
    fun getEmployeeById(id: Long): Optional<Employee>
    fun getAllEmployees(): List<Employee>
    fun updateEmployee(employee: Employee): Employee
    fun deleteEmployee(id: Long)
}

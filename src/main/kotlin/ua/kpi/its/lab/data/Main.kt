package ua.kpi.its.lab.data

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import ua.kpi.its.lab.data.entity.Enterprise
import ua.kpi.its.lab.data.svc.EnterpriseService
import ua.kpi.its.lab.data.svc.EmployeeService
import java.time.LocalDate

fun main(args: Array<String>) {
    val context = AnnotationConfigApplicationContext("ua.kpi.its.lab")

    val enterpriseService = context.getBean(EnterpriseService::class.java)
    val employeeService = context.getBean(EmployeeService::class.java)

    // Створення 5 різноманітних основних сутностей
    val enterprise1 = Enterprise(
        name = "Enterprise 1", industry = "IT", address = "Address 1",
        numberOfDepartments = 3, foundationDate = LocalDate.of(2000, 1, 1),
        numberOfEmployees = 100, vatPayer = true
    )
    val enterprise2 = Enterprise(
        name = "Enterprise 2", industry = "Manufacturing", address = "Address 2",
        numberOfDepartments = 5, foundationDate = LocalDate.of(1995, 5, 15),
        numberOfEmployees = 200, vatPayer = true
    )
    val enterprise3 = Enterprise(
        name = "Enterprise 3", industry = "Finance", address = "Address 3",
        numberOfDepartments = 2, foundationDate = LocalDate.of(2010, 3, 10),
        numberOfEmployees = 50, vatPayer = false
    )
    val enterprise4 = Enterprise(
        name = "Enterprise 4", industry = "Healthcare", address = "Address 4",
        numberOfDepartments = 4, foundationDate = LocalDate.of(2005, 7, 20),
        numberOfEmployees = 150, vatPayer = true
    )
    val enterprise5 = Enterprise(
        name = "Enterprise 5", industry = "Education", address = "Address 5",
        numberOfDepartments = 6, foundationDate = LocalDate.of(2015, 9, 30),
        numberOfEmployees = 300, vatPayer = false
    )

    // Додавання створених сутностей в БД
    enterpriseService.createEnterprise(enterprise1)
    enterpriseService.createEnterprise(enterprise2)
    enterpriseService.createEnterprise(enterprise3)
    enterpriseService.createEnterprise(enterprise4)
    enterpriseService.createEnterprise(enterprise5)

    // Отримання сутності з індексом 3
    println(enterpriseService.getEnterpriseById(3L).orElse(null))

    // Видалення сутності з індексом 4
    enterpriseService.deleteEnterprise(4L)

    context.close()
}

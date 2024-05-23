package ua.kpi.its.lab.data.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class Employee(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val fullName: String,
    val hireDate: LocalDate,
    val department: String,
    val position: String,
    val category: String,
    val salary: Double,
    val partTime: Boolean,
    @ManyToOne @JoinColumn(name = "enterprise_id")
    val enterprise: Enterprise? = null
) : Comparable<Employee> {
    override fun compareTo(other: Employee): Int {
        return compareValuesBy(this, other, Employee::fullName, Employee::id)
    }

    override fun toString(): String {
        return "Employee(id=$id, fullName='$fullName', hireDate=$hireDate, department='$department', position='$position', category='$category', salary=$salary, partTime=$partTime)"
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}

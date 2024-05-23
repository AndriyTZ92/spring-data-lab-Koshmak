package ua.kpi.its.lab.data.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class Enterprise(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val name: String,
    val industry: String,
    val address: String,
    val numberOfDepartments: Int,
    val foundationDate: LocalDate,
    val numberOfEmployees: Int,
    val vatPayer: Boolean,
    @OneToMany(mappedBy = "enterprise", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    val employees: List<Employee> = emptyList()
) : Comparable<Enterprise> {
    override fun compareTo(other: Enterprise): Int {
        return compareValuesBy(this, other, Enterprise::name, Enterprise::id)
    }

    override fun toString(): String {
        return "Enterprise(id=$id, name='$name', industry='$industry', address='$address', numberOfDepartments=$numberOfDepartments, foundationDate=$foundationDate, numberOfEmployees=$numberOfEmployees, vatPayer=$vatPayer)"
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}

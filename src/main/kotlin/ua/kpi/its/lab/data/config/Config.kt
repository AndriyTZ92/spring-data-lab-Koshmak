package ua.kpi.its.lab.data.config

import jakarta.persistence.EntityManagerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager

@Configuration
class Config {
    @Bean
    fun entityManagerFactory(): LocalContainerEntityManagerFactoryBean {
        val emf = LocalContainerEntityManagerFactoryBean()
        emf.setPersistenceUnitName("example-unit")
        return emf
    }

    @Bean
    fun transactionManager(emf: EntityManagerFactory): PlatformTransactionManager {
        return JpaTransactionManager(emf)
    }
}

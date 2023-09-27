package live.fin.configserver.repository

import live.fin.configserver.domain.persistence.Property
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PropertyRepository: CrudRepository<Property, Long> {
}

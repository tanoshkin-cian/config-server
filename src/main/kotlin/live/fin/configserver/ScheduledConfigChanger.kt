package live.fin.configserver

import live.fin.configserver.domain.persistence.Property
import live.fin.configserver.repository.PropertyRepository
import org.springframework.cloud.bus.endpoint.EnvironmentBusEndpoint
import org.springframework.cloud.bus.endpoint.RefreshBusEndpoint
import org.springframework.cloud.bus.event.PathDestinationFactory
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent
import org.springframework.context.ApplicationEventPublisher
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import java.util.*

@Configuration
@EnableScheduling
class ScheduledPropertyReporter(
    private val propertyRepository: PropertyRepository,
    private val refreshBusEndpoint: RefreshBusEndpoint
) {

    @Scheduled(fixedDelay = 10_000)
    fun report() {
        propertyRepository.deleteAll()
        val property = Property(
            application = "config-client",
            profile = "default",
            key = "foo",
            label = "main",
            value = UUID.randomUUID().toString(),
        )
        propertyRepository.save(property)
        refreshBusEndpoint.busRefresh()
    }

}

package live.fin.configserver

import live.fin.configserver.domain.persistence.Property
import live.fin.configserver.repository.PropertyRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
class ConfigServerApplication

fun main(args: Array<String>) {
	runApplication<ConfigServerApplication>(*args)
}

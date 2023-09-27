package live.fin.configserver.domain.persistence

import jakarta.persistence.*

@Entity
@Table(name = "properties")
class Property(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "application")
    var application: String,

    @Column(name = "profile")
    var profile: String,

    @Column(name = "label")
    var label: String,

    @Column(name = "KEY")
    var key: String,

    @Column(name = "VALUE")
    var value: String,

    ) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Property

        return id == other.id
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}

package linklike



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Link)
class LinkTests {

    void testLink() {
       def link = new Link(title:'wtf',url:'ftw')
       assert link != null
       assert link.title == 'wtf'
       assert link.url == 'ftw'
       assert link.votenumber == 0
    }
}

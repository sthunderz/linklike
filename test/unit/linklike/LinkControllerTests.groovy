package linklike



import grails.test.mixin.*
import org.junit.*

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(LinkController)
@Mock([Link])
class LinkControllerTests {

    void testNoVote() {

       params.title = 'wat'
       params.url = 'wat'
       controller.create() 

        assert Link.get(1).votenumber == 0
    } 

    void testLink(){

     	//params.title = 'wat'
        //params.url = 'wat'
        //controller.create() 

        //assert Link.count == 1

        //controller.index()

        params.title = 'wat1'
        params.url = 'wat2'
       controller.create()
       assert Link.get(1).title == 'wat1'
       assert Link.count == 1 
    }
    void testVote()
    {
    	mockDomain(Link,
    		[ [title:'a1',url:'b1'],
    		  [title:'a2',url:'b2'],
    		  [title:'a3',url:'b3'] ])
    	
    	controller.vote('a1','b1')
    	assert Link.get(1).votenumber == 1
      assert Link.get(2).votenumber == 0
      assert Link.get(3).votenumber == 0

      controller.vote('a1','b1')
      controller.vote('a2','b2')
      assert Link.get(1).votenumber == 2
      assert Link.get(2).votenumber == 1
      assert Link.get(3).votenumber == 0

      controller.vote('a1','b1')
      controller.vote('a2','b2')
      controller.vote('a3','b3')
      assert Link.get(1).votenumber == 3
      assert Link.get(2).votenumber == 2
      assert Link.get(3).votenumber == 1

    }

}

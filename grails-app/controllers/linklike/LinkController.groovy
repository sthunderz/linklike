package linklike

class LinkController {

    def index() { 
        def links = Link.findAll()
        [ links: links ]
    }

    def create() {
        def link = new Link(title: params.title, url: params.url)
        link.save()
        redirect(action: "index")
    }

    def vote(String title,String url){
    	def links = Link.findAll()
    	for (x in links){
    		if(x.title == title & x.url == url){
    			x.votenumber++
    			break
       		}
    	}
        redirect(action: "index")
    }

}

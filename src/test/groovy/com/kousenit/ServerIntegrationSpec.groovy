package com.kousenit

import ratpack.groovy.test.LocalScriptApplicationUnderTest
import ratpack.groovy.test.TestHttpClient
import spock.lang.Specification

class ServerIntegrationSpec extends Specification {

    def aut = new LocalScriptApplicationUnderTest()
    @Delegate TestHttpClient client = aut.httpClient()

    def setup() {
        resetRequest()
    }

    def "regular get request returns Chuck Norris string"() {
        when:
        String result = get('/').asString()

        then:
		println result
		result.contains('Chuck Norris')
    }

	def "firstName and lastName parameters work"() {
		when:
		def response = get('?firstName=Carlos&lastName=Ray')?.asString()
		then:
		println response
		response.contains('Carlos Ray')
	}
}
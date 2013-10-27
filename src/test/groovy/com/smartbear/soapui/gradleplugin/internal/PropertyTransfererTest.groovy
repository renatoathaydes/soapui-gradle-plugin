package com.smartbear.soapui.gradleplugin.internal

import groovy.transform.Immutable
import spock.lang.Specification

/**
 * @author Renato Athaydes
 */
class PropertyTransfererTest extends Specification {

	final pt = new PropertyTransferer()

	def "Knows when Getter and Setter refer to same property"( ) {
		expect:
		expected == pt.referToSameProperty( m1, m2 )

		where:
		m1              | m2               | expected
		'getX'          | 'getX'           | true
		'setX'          | 'getX'           | true
		'abcde'         | 'xyzde'          | true
		'getProperties' | 'setProperties'  | true
		'getX'          | 'getY'           | false
		'getX'          | 'setY'           | false
		'abcde'         | 'xyzwv'          | false
		'getProperties' | 'setProperties2' | false
		'getTestCase'   | 'setTestSuite'   | false
	}

	def "Can transfer properties from provider to destination"( ) {
		given:
		def provider = new Provider(
				globalProperties: [ 'a', 'z' ],
				saveAfterRun: true,
				projectFile: 'file.xml',
				notInDestination: 'B'
		)
		def destination = new Destination()

		when:
		pt.transferPropertiesFrom( provider ).to( destination )

		then:
		provider.globalProperties == destination.globalProperties
		provider.saveAfterRun == destination.saveAfterRun
		provider.projectFile == destination.projectFile
		destination.notInProvider == 'A'
	}

}

@Immutable
class Provider {
	String[] globalProperties
	boolean saveAfterRun
	String projectFile
	String notInDestination
}

class Destination {
	String[] globalProperties
	boolean saveAfterRun
	String projectFile
	String notInProvider = 'A'
}

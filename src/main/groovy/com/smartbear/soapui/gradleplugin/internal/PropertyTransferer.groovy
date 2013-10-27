package com.smartbear.soapui.gradleplugin.internal

/**
 * @author Renato Athaydes
 */
class PropertyTransferer {

	private static methodNamesMatching = { cls, regex -> cls.methods*.name.grep { it =~ regex } }

	private relevantMethods( cls, regex ) {
		methodNamesMatching( cls, regex ) -
				methodNamesMatching( GroovyObjectSupport, regex )
	}

	private findMethods( Class cls, String firstChar ) {
		relevantMethods cls, /^${firstChar}et[A-Z]/
	}

	protected referToSameProperty( method1, method2 ) {
		method1[ 3..-1 ] == method2[ 3..-1 ]
	}

	PropertiesTo transferPropertiesFrom( provider ) {
		new PropertiesTo( provider: provider )
	}

	class PropertiesTo {
		def provider

		void to( destination ) {
			def providerGetters = findMethods( provider.class, 'g' )
			def destinationSetters = findMethods( destination.class, 's' )
			providerGetters.each { getter ->
				def matchingSetter = destinationSetters.find { setter ->
					referToSameProperty( getter, setter ) }
				if ( matchingSetter && provider."${getter}"() != null ) {
					try {
						destination."${matchingSetter}"( provider."${getter}"() )
					} catch ( e ) {
						println "Unable to use ${matchingSetter} due to ${e}"
					}
				}
			}
		}
	}

}

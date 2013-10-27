package com.smartbear.soapui.gradleplugin

import org.gradle.api.GradleException
import org.gradle.testfixtures.ProjectBuilder
import spock.lang.Specification

/**
 * @author Renato Athaydes
 */
class TestPluginTest extends Specification {

	def "Project with soapui plugin applied gain the 'soapuiTest' task"( ) {
		given:
		def project = ProjectBuilder.builder().withName( 'my-proj' ).build()
		when:
		project.apply plugin: 'soapui'
		then:
		project.tasks.soapuiTest
	}

	def "A GradleException is thrown if no 'soapui' configuration is given"( ) {
		given:
		def project = new Expando()
		when:
		new TestPlugin().ensureCanRun( project )
		then:
		thrown GradleException
	}

	def "A GradleException is thrown if the 'soapuiTest' task is run with no projectFile set"( ) {
		given:
		def project = new Expando()
		project.soapui = new SoapUIConfig()
		when:
		new TestPlugin().ensureCanRun( project )
		then:
		thrown GradleException
	}

}

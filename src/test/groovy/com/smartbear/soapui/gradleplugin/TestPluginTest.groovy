package com.smartbear.soapui.gradleplugin

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

/**
 * @author Renato Athaydes
 */
class TestPluginTest {

	@Test
	void firstTest( ) {
		Project project = ProjectBuilder.builder().withName( 'my-proj' ).build()
		project.apply plugin: 'soapui'
		assert project.tasks.soapuiTest
	}

}

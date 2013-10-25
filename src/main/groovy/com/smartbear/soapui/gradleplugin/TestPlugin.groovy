package com.smartbear.soapui.gradleplugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @author Renato Athaydes
 */
class TestPlugin implements Plugin<Project> {

	@Override
	void apply( Project project ) {
		project.extensions.create( 'soapui', SoapUIConfig )
		project.task( 'soapuiTest' ) << {
			println "Hello World!"
		}
	}

}

class SoapUIConfig {

	/**
	 * The soapUI project file to test with
	 *
	 * @parameter expression="${soapui.projectfile}"
	 * default-value="${project.artifactId}-soapui-project.xml"
	 */

	String projectFile

	/**
	 * The TestSuite to run project file to test with
	 *
	 * @parameter expression="${soapui.testsuite}"
	 */

	String testSuite

	/**
	 * The TestCase to run project file to test with
	 *
	 * @parameter expression="${soapui.testcase}"
	 */

	String testCase

	/**
	 * The username to use for authentication challenges
	 *
	 * @parameter expression="${soapui.username}"
	 */

	String username

	/**
	 * The password to use for authentication challenges
	 *
	 * @parameter expression="${soapui.password}"
	 */

	String password

	/**
	 * The WSS password-type to use for any authentications. Setting this will
	 * result in the addition of WS-Security UsernamePassword tokens to any
	 * outgoing request containing the specified username and password. Set to
	 * either 'Text' or 'Digest'
	 *
	 * @parameter expression="${soapui.wssPasswordType}"
	 */

	String wssPasswordType

	/**
	 * The domain to use for authentication challenges
	 *
	 * @parameter expression="${soapui.domain}"
	 */

	String domain

	/**
	 * The host to use for requests
	 *
	 * @parameter expression="${soapui.host}"
	 */

	String host

	/**
	 * Overrides the endpoint to use for requests
	 *
	 * @parameter expression="${soapui.endpoint}"
	 */

	String endpoint

	/**
	 * Sets the output folder for reports
	 *
	 * @parameter expression="${soapui.outputFolder}"
	 */

	String outputFolder

	/**
	 * Turns on printing of reports
	 *
	 * @parameter expression="${soapui.printReport}"
	 */

	boolean printReport

	/**
	 * Enabled interactive groovy scripts
	 *
	 * @parameter expression="${soapui.interactive}"
	 */

	boolean interactive

	/**
	 * Turns on exporting of all results
	 *
	 * @parameter expression="${soapui.exportAll}"
	 */

	boolean exportAll

	/**
	 * Turns on creation of reports in junit style
	 *
	 * @parameter expression="${soapui.junitReport}"
	 */

	boolean junitReport

	/**
	 * Specifies soapUI settings file to use
	 *
	 * @parameter expression="${soapui.settingsFile}"
	 */

	String settingsFile

	/**
	 * Tells Test Runner to skip tests.
	 *
	 * @parameter expression="${soapui.skip}"
	 */

	boolean skip

	/**
	 * Specifies password for encrypted soapUI project file
	 *
	 * @parameter expression="${soapui.project.password}"
	 */
	String projectPassword

	/**
	 * Specifies password for encrypted soapui-settings file
	 *
	 * @parameter expression="${soapui.settingsFile.password}"
	 */
	String settingsPassword

	/**
	 * If set ignore failed tests
	 *
	 * @parameter expression="${soapui.testFailIgnore}"
	 */

	boolean testFailIgnore

	/**
	 * Specified global property values soapui.saveAfterRun
	 *
	 * @parameter expression="${soapui.globalProperties}"
	 */

	String[] globalProperties

	/**
	 * Specified project property values
	 *
	 * @parameter expression="${soapui.projectProperties}"
	 */

	String[] projectProperties

	/**
	 * Saves project file after running tests
	 *
	 * @parameter expression="${}"
	 */

	boolean saveAfterRun

	/**
	 * SoapUI Properties.
	 *
	 * @parameter expression="${soapuiProperties}"
	 */
	Properties soapuiProperties

}

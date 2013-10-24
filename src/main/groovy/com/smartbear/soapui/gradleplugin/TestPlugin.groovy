package com.smartbear.soapui.gradleplugin

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @author Renato Athaydes
 */
class TestPlugin implements Plugin<Project> {

	/**
	 * The soapUI project file to test with
	 *
	 * @parameter expression="${soapui.projectfile}"
	 * default-value="${project.artifactId}-soapui-project.xml"
	 */

	private String projectFile;

	/**
	 * The TestSuite to run project file to test with
	 *
	 * @parameter expression="${soapui.testsuite}"
	 */

	private String testSuite;

	/**
	 * The TestCase to run project file to test with
	 *
	 * @parameter expression="${soapui.testcase}"
	 */

	private String testCase;

	/**
	 * The username to use for authentication challenges
	 *
	 * @parameter expression="${soapui.username}"
	 */

	private String username;

	/**
	 * The password to use for authentication challenges
	 *
	 * @parameter expression="${soapui.password}"
	 */

	private String password;

	/**
	 * The WSS password-type to use for any authentications. Setting this will
	 * result in the addition of WS-Security UsernamePassword tokens to any
	 * outgoing request containing the specified username and password. Set to
	 * either 'Text' or 'Digest'
	 *
	 * @parameter expression="${soapui.wssPasswordType}"
	 */

	private String wssPasswordType;

	/**
	 * The domain to use for authentication challenges
	 *
	 * @parameter expression="${soapui.domain}"
	 */

	private String domain;

	/**
	 * The host to use for requests
	 *
	 * @parameter expression="${soapui.host}"
	 */

	private String host;

	/**
	 * Overrides the endpoint to use for requests
	 *
	 * @parameter expression="${soapui.endpoint}"
	 */

	private String endpoint;

	/**
	 * Sets the output folder for reports
	 *
	 * @parameter expression="${soapui.outputFolder}"
	 */

	private String outputFolder;

	/**
	 * Turns on printing of reports
	 *
	 * @parameter expression="${soapui.printReport}"
	 */

	private boolean printReport;

	/**
	 * Enabled interactive groovy scripts
	 *
	 * @parameter expression="${soapui.interactive}"
	 */

	private boolean interactive;

	/**
	 * Turns on exporting of all results
	 *
	 * @parameter expression="${soapui.exportAll}"
	 */

	private boolean exportAll;

	/**
	 * Turns on creation of reports in junit style
	 *
	 * @parameter expression="${soapui.junitReport}"
	 */

	private boolean junitReport;

	/**
	 * Specifies soapUI settings file to use
	 *
	 * @parameter expression="${soapui.settingsFile}"
	 */

	private String settingsFile;

	/**
	 * Tells Test Runner to skip tests.
	 *
	 * @parameter expression="${soapui.skip}"
	 */

	private boolean skip;

	/**
	 * Specifies password for encrypted soapUI project file
	 *
	 * @parameter expression="${soapui.project.password}"
	 */
	private String projectPassword;

	/**
	 * Specifies password for encrypted soapui-settings file
	 *
	 * @parameter expression="${soapui.settingsFile.password}"
	 */
	private String settingsPassword;

	/**
	 * If set ignore failed tests
	 *
	 * @parameter expression="${soapui.testFailIgnore}"
	 */

	private boolean testFailIgnore;

	/**
	 * Specified global property values soapui.saveAfterRun
	 *
	 * @parameter expression="${soapui.globalProperties}"
	 */

	private String[] globalProperties;

	/**
	 * Specified project property values
	 *
	 * @parameter expression="${soapui.projectProperties}"
	 */

	private String[] projectProperties;

	/**
	 * Saves project file after running tests
	 *
	 * @parameter expression="${}"
	 */

	private boolean saveAfterRun;

	/**
	 * SoapUI Properties.
	 *
	 * @parameter expression="${soapuiProperties}"
	 */
	private Properties soapuiProperties;


	@Override
	void apply( Project t ) {

	}
}

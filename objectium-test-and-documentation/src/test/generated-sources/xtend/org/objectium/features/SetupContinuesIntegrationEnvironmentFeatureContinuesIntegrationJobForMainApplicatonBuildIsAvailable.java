package org.objectium.features;

import org.eclipse.xtext.xbase.lib.Exceptions;
import org.jnario.lib.Assert;
import org.jnario.lib.JnarioIterableExtensions;
import org.jnario.lib.Should;
import org.jnario.lib.StepArguments;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.objectium.features.SetupContinuesIntegrationEnvironmentFeatureWeWillConsiderTeFollowingScenariosToEnsureContinuesIntegrationEnvironmentIsSetupCorrectly;

@RunWith(FeatureRunner.class)
@Named("Scenario: Continues Integration Job for Main Applicaton Build is available")
@SuppressWarnings("all")
public class SetupContinuesIntegrationEnvironmentFeatureContinuesIntegrationJobForMainApplicatonBuildIsAvailable extends SetupContinuesIntegrationEnvironmentFeatureWeWillConsiderTeFollowingScenariosToEnsureContinuesIntegrationEnvironmentIsSetupCorrectly {
  @Test
  @Order(0)
  @Named("When CI enviornment is up and running on \\\"http://localhost:8080\\\"")
  public void _whenCIEnviornmentIsUpAndRunningOnHttpLocalhost8080() {
    try {
      StepArguments _stepArguments = new StepArguments("http://localhost:8080");
      final StepArguments args = _stepArguments;
      String _first = JnarioIterableExtensions.<String>first(args);
      String _string = _first.toString();
      this.jenkins.setUrl(_string);
      boolean _isAvailable = this.jenkins.isAvailable();
      boolean _should_be = Should.<Boolean>should_be(Boolean.valueOf(_isAvailable), true);
      Assert.assertTrue("\nExpected jenkins.isAvailable() should be true but"
       + "\n     jenkins.isAvailable() is " + new org.hamcrest.StringDescription().appendValue(Boolean.valueOf(_isAvailable)).toString()
       + "\n     jenkins is " + new org.hamcrest.StringDescription().appendValue(this.jenkins).toString() + "\n", _should_be);
      
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Order(1)
  @Named("Then There should be a job named \\\"Main_Application_Build\\\"")
  public void _thenThereShouldBeAJobNamedMainApplicationBuild() {
    StepArguments _stepArguments = new StepArguments("Main_Application_Build");
    final StepArguments args = _stepArguments;
    String _first = JnarioIterableExtensions.<String>first(args);
    String _string = _first.toString();
    boolean _isJobConfigured = this.jenkins.isJobConfigured(_string);
    boolean _should_be = Should.<Boolean>should_be(Boolean.valueOf(_isJobConfigured), true);
    Assert.assertTrue("\nExpected jenkins.isJobConfigured(args.first.toString) should be true but"
     + "\n     jenkins.isJobConfigured(args.first.toString) is " + new org.hamcrest.StringDescription().appendValue(Boolean.valueOf(_isJobConfigured)).toString()
     + "\n     jenkins is " + new org.hamcrest.StringDescription().appendValue(this.jenkins).toString()
     + "\n     args.first.toString is " + new org.hamcrest.StringDescription().appendValue(_string).toString()
     + "\n     args.first is " + new org.hamcrest.StringDescription().appendValue(_first).toString()
     + "\n     args is " + new org.hamcrest.StringDescription().appendValue(args).toString() + "\n", _should_be);
    
  }
}

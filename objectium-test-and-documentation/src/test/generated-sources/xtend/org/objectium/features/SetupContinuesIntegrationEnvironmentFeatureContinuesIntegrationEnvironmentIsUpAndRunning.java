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
@Named("Scenario: Continues integration environment is up and running")
@SuppressWarnings("all")
public class SetupContinuesIntegrationEnvironmentFeatureContinuesIntegrationEnvironmentIsUpAndRunning extends SetupContinuesIntegrationEnvironmentFeatureWeWillConsiderTeFollowingScenariosToEnsureContinuesIntegrationEnvironmentIsSetupCorrectly {
  @Test
  @Order(0)
  @Named("Given the Jenkins CI enviornment URL is \\\"http://localhost:8080\\\"")
  public void _givenTheJenkinsCIEnviornmentURLIsHttpLocalhost8080() {
    try {
      StepArguments _stepArguments = new StepArguments("http://localhost:8080");
      final StepArguments args = _stepArguments;
      String _first = JnarioIterableExtensions.<String>first(args);
      String _string = _first.toString();
      this.jenkins.setUrl(_string);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Order(1)
  @Named("Then we should be able to access it via the URL")
  public void _thenWeShouldBeAbleToAccessItViaTheURL() {
    boolean _isAvailable = this.jenkins.isAvailable();
    boolean _should_be = Should.<Boolean>should_be(Boolean.valueOf(_isAvailable), true);
    Assert.assertTrue("\nExpected jenkins.isAvailable() should be true but"
     + "\n     jenkins.isAvailable() is " + new org.hamcrest.StringDescription().appendValue(Boolean.valueOf(_isAvailable)).toString()
     + "\n     jenkins is " + new org.hamcrest.StringDescription().appendValue(this.jenkins).toString() + "\n", _should_be);
    
  }
}

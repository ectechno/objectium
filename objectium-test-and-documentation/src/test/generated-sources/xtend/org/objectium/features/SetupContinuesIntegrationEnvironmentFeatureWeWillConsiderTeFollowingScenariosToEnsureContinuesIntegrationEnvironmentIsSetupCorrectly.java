package org.objectium.features;

import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;
import org.objectium.features.SetupContinuesIntegrationEnvironmentFeature;
import org.objectium.test.jenkins.JenkinsWrapper;

@RunWith(FeatureRunner.class)
@Named("Background: We will consider te following scenarios to ensure Continues Integration environment is setup correctly.")
@SuppressWarnings("all")
public class SetupContinuesIntegrationEnvironmentFeatureWeWillConsiderTeFollowingScenariosToEnsureContinuesIntegrationEnvironmentIsSetupCorrectly extends SetupContinuesIntegrationEnvironmentFeature {
  JenkinsWrapper jenkins = new Function0<JenkinsWrapper>() {
    public JenkinsWrapper apply() {
      JenkinsWrapper _jenkinsWrapper = new JenkinsWrapper();
      return _jenkinsWrapper;
    }
  }.apply();
}

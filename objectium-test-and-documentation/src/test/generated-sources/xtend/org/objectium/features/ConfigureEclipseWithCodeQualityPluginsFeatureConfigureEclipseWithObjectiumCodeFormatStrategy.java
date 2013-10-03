package org.objectium.features;

import java.io.File;
import org.jnario.lib.Assert;
import org.jnario.lib.JnarioIterableExtensions;
import org.jnario.lib.Should;
import org.jnario.lib.StepArguments;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.jnario.runner.Order;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.objectium.features.ConfigureEclipseWithCodeQualityPluginsFeatureBackground;

@RunWith(FeatureRunner.class)
@Named("Scenario: Configure Eclipse with Objectium Code Format strategy")
@SuppressWarnings("all")
public class ConfigureEclipseWithCodeQualityPluginsFeatureConfigureEclipseWithObjectiumCodeFormatStrategy extends ConfigureEclipseWithCodeQualityPluginsFeatureBackground {
  @Test
  @Order(0)
  @Named("When \\\"code_formatter.xml\\\" is available in \\\"build-tools\\\" project \\\"src/main/resources/configurations\\\" path")
  public void _whenCodeFormatterXmlIsAvailableInBuildToolsProjectSrcMainResourcesConfigurationsPath() {
    StepArguments _stepArguments = new StepArguments("code_formatter.xml", "build-tools", "src/main/resources/configurations");
    final StepArguments args = _stepArguments;
    String _plus = (this.rootFolderPath + "/");
    String _second = JnarioIterableExtensions.<String>second(args);
    String _string = _second.toString();
    String _plus_1 = (_plus + _string);
    this.projectFolder = _plus_1;
    String _plus_2 = (this.projectFolder + "/");
    String _third = JnarioIterableExtensions.<String>third(args);
    String _string_1 = _third.toString();
    String _plus_3 = (_plus_2 + _string_1);
    this.resourcesFolder = _plus_3;
    String _plus_4 = (this.resourcesFolder + "/");
    String _first = JnarioIterableExtensions.<String>first(args);
    String _string_2 = _first.toString();
    String _plus_5 = (_plus_4 + _string_2);
    File _file = new File(_plus_5);
    boolean _exists = _file.exists();
    boolean _should_be = Should.<Boolean>should_be(Boolean.valueOf(_exists), true);
    Assert.assertTrue("\nExpected new File(resourcesFolder+\"/\"+args.first.toString).exists should be true but"
     + "\n     new File(resourcesFolder+\"/\"+args.first.toString).exists is " + new org.hamcrest.StringDescription().appendValue(Boolean.valueOf(_exists)).toString()
     + "\n     new File(resourcesFolder+\"/\"+args.first.toString) is " + new org.hamcrest.StringDescription().appendValue(_file).toString()
     + "\n     resourcesFolder+\"/\"+args.first.toString is " + new org.hamcrest.StringDescription().appendValue(_plus_5).toString()
     + "\n     resourcesFolder+\"/\" is " + new org.hamcrest.StringDescription().appendValue(_plus_4).toString()
     + "\n     resourcesFolder is " + new org.hamcrest.StringDescription().appendValue(this.resourcesFolder).toString()
     + "\n     args.first.toString is " + new org.hamcrest.StringDescription().appendValue(_string_2).toString()
     + "\n     args.first is " + new org.hamcrest.StringDescription().appendValue(_first).toString()
     + "\n     args is " + new org.hamcrest.StringDescription().appendValue(args).toString() + "\n", _should_be);
    
  }
  
  @Test
  @Order(1)
  @Ignore
  @Named("Then we  can configure the eclipse java code formatting by following the steps given below")
  public void _thenWeCanConfigureTheEclipseJavaCodeFormattingByFollowingTheStepsGivenBelow() {
    
  }
}

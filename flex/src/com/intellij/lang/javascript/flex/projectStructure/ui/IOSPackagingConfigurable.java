package com.intellij.lang.javascript.flex.projectStructure.ui;

import com.intellij.lang.javascript.flex.actions.FilesToPackageForm;
import com.intellij.lang.javascript.flex.actions.SigningOptionsForm;
import com.intellij.lang.javascript.flex.projectStructure.model.IosPackagingOptions;
import com.intellij.lang.javascript.flex.projectStructure.model.ModifiableIosPackagingOptions;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.ui.LabeledComponent;
import com.intellij.openapi.ui.NamedConfigurable;
import com.intellij.openapi.util.NullableComputable;
import org.jetbrains.annotations.Nls;

import javax.swing.*;

public class IOSPackagingConfigurable extends NamedConfigurable<IosPackagingOptions> {
  private JPanel myMainPanel;
  private JCheckBox myCreatePackageOnMakeCheckBox;
  private LabeledComponent myInstallerFileNameComponent;
  private LabeledComponent myInstallerLocationComponent;
  private JLabel myPackageTypeLabel;
  private JComboBox myIOSPackageTypeCombo;
  private JCheckBox myFastPackagingCheckBox;
  private FilesToPackageForm myFilesToPackageForm;
  private SigningOptionsForm mySigningOptionsForm;

  private final Project myProject;
  private final ModifiableIosPackagingOptions myModel;

  public IOSPackagingConfigurable(final Project project, final ModifiableIosPackagingOptions model) {
    myProject = project;
    myModel = model;
  }

  @Nls
  public String getDisplayName() {
    return "iOS";
  }

  public void setDisplayName(final String name) {
  }

  public String getBannerSlogan() {
    return "iOS";
  }

  public Icon getIcon() {
    return null;
  }

  public IosPackagingOptions getEditableObject() {
    return myModel;
  }

  public String getHelpTopic() {
    return null;
  }

  public JComponent createOptionsPanel() {
    return myMainPanel;
  }

  public boolean isModified() {
    return false;
  }

  public void apply() throws ConfigurationException {
    applyTo(myModel);
  }

  public void applyTo(final ModifiableIosPackagingOptions iosPackagingOptions) {
  }

  public void reset() {
  }

  public void disposeUIResources() {
  }

  private void createUIComponents() {
    myFilesToPackageForm = new FilesToPackageForm(myProject);

    mySigningOptionsForm = new SigningOptionsForm(myProject, new NullableComputable<Module>() {
      public Module compute() {
        return null;
      }
    }, new NullableComputable<Sdk>() {
      public Sdk compute() {
        return null;
      }
    }, new Runnable() {
      public void run() {
      }
    }
    );
  }
}

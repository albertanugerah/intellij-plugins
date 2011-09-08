package com.intellij.lang.javascript.flex.projectStructure.model;

import com.intellij.util.xmlb.annotations.Attribute;
import com.intellij.util.xmlb.annotations.Tag;
import org.jetbrains.annotations.NotNull;

public class AirDesktopPackagingOptionsImpl implements ModifiableAirDesktopPackagingOptions {

  private boolean myUseGeneratedDescriptor = true;
  @NotNull
  private String myCustomDescriptorPath = "";
  @NotNull
  private String myInstallerFileName = "";

  @Override
  public boolean isUseGeneratedDescriptor() {
    return myUseGeneratedDescriptor;
  }

  @Override
  @NotNull
  public String getCustomDescriptorPath() {
    return myCustomDescriptorPath;
  }

  @Override
  @NotNull
  public String getInstallerFileName() {
    return myInstallerFileName;
  }

  @Override
  public void setUseGeneratedDescriptor(boolean useGeneratedDescriptor) {
    myUseGeneratedDescriptor = useGeneratedDescriptor;
  }

  @Override
  public void setCustomDescriptorPath(@NotNull String customDescriptorPath) {
    myCustomDescriptorPath = customDescriptorPath;
  }

  @Override
  public void setInstallerFileName(@NotNull String installerFileName) {
    myInstallerFileName = installerFileName;
  }

  public AirDesktopPackagingOptionsImpl getCopy() {
    AirDesktopPackagingOptionsImpl copy = new AirDesktopPackagingOptionsImpl();
    applyTo(copy);
    return copy;
  }

  private void applyTo(AirDesktopPackagingOptionsImpl copy) {
    copy.myUseGeneratedDescriptor = myUseGeneratedDescriptor;
    copy.myCustomDescriptorPath = myCustomDescriptorPath;
    copy.myInstallerFileName = myInstallerFileName;
  }

  public State getState() {
    State state = new State();
    state.USE_GENERATED_DESCRIPTOR = myUseGeneratedDescriptor;
    state.CUSTOM_DESCRIPTOR_PATH = myCustomDescriptorPath;
    state.INSTALLER_FILE_NAME = myInstallerFileName;
    return state;
  }

  public void loadState(@NotNull State state) {
    myUseGeneratedDescriptor = state.USE_GENERATED_DESCRIPTOR;
    myCustomDescriptorPath = state.CUSTOM_DESCRIPTOR_PATH;
    myInstallerFileName = state.INSTALLER_FILE_NAME;
  }

  @Tag("packaging-air-desktop")
  public static class State {
    @Attribute("use-generated-descriptor")
    public boolean USE_GENERATED_DESCRIPTOR = true;
    @Attribute("custom-descriptor-path")
    public String CUSTOM_DESCRIPTOR_PATH = "";
    @Attribute("installer")
    public String INSTALLER_FILE_NAME = "";
  }
}

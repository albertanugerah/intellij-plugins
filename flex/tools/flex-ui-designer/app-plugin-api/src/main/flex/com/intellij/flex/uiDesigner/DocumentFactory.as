package com.intellij.flex.uiDesigner {
import flash.utils.ByteArray;

public class DocumentFactory implements SerializedDocumentDataProvider, DocumentReaderContext {
  private var _data:ByteArray;
  public var module:Module;
  
  public function DocumentFactory(data:ByteArray, file:VirtualFile, module:Module) {
    _data = data;
    _file = file;
    this.module = module;
  }

  public function get data():ByteArray {
    return _data;
  }

  private var _file:VirtualFile;
  public function get file():VirtualFile {
    return _file;
  }

  public function get moduleContext():ModuleContext {
    return module.context;
  }
}
}

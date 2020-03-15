package filesystems;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DocDirectory extends DocFile {

  private Set<DocFile> files;

  public DocDirectory(String name) {
    super(name);
    this.files = new HashSet<>();
  }

  public DocDirectory(String name, Set<DocFile> files) {
    super(name);
    this.files = files;
  }

  @Override
  public int getSize() {
    return getName().length();
  }

  @Override
  public boolean isDirectory() {
    return true;
  }

  @Override
  public boolean isDataFile() {
    return false;
  }

  @Override
  public DocDirectory asDirectory() {
    return this;
  }

  @Override
  public DocDataFile asDataFile() {
    throw new UnsupportedOperationException();
  }

  @Override
  public DocFile duplicate() {
    Set<DocFile> duplicatedFiles = new HashSet<>();
    files.forEach(x -> duplicatedFiles.add(x.duplicate()));
    return new DocDirectory(getName(), duplicatedFiles);
  }

  public boolean containsFile(String name) {
    for (DocFile file : files) {
      if (file.getName().equals(name)) {
        return true;
      }
    }
    return false;
  }

  public Set<DocFile> getAllFiles() {
    return files;
  }

  public Set<DocDirectory> getDirectories() {
    Set<DocDirectory> directories = new HashSet<>();
    for (DocFile file : files) {
      if (file.isDirectory()) {
        directories.add((DocDirectory) file);
      }
    }
    return directories;
  }

  public Set<DocDataFile> getDataFiles() {
    Set<DocDataFile> dataFiles = new HashSet<>();
    for (DocFile file : files) {
      if (file.isDataFile()) {
        dataFiles.add((DocDataFile) file);
      }
    }
    return dataFiles;
  }

  public void addFile(DocFile file) {
    for (DocFile f : files) {
      if (f.getName().equals(file.getName())){
        throw new IllegalArgumentException("File is already contained in directory.");
      }
    }
    files.add(file);
  }

  public boolean removeFile(String filename) {
    for (DocFile file : files) {
      if (file.getName().equals(filename)) {
        files.remove(file);
        return true;
      }
    }
    return false;
  }

  public DocFile getFile(String filename) {
    for (DocFile file : files) {
      if (file.getName().equals(filename)) {
        return file;
      }
    }
    return null;
  }

}

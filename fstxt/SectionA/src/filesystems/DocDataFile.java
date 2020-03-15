package filesystems;

import java.util.Arrays;

public final class DocDataFile extends DocFile {

  private final byte[] contents;

  public DocDataFile(String name, byte[] contents) {
    super(name);
    this.contents = contents;
  }

  public byte[] getContents() {
    return contents;
  }

  @Override
  public int getSize() {
    return getName().length() + contents.length;
  }

  @Override
  public boolean isDirectory() {
    return false;
  }

  @Override
  public boolean isDataFile() {
    return true;
  }

  @Override
  public DocDirectory asDirectory() {
    throw new UnsupportedOperationException();
  }

  @Override
  public DocDataFile asDataFile() {
    return this;
  }

  @Override
  public DocFile duplicate() {
    return new DocDataFile(getName(), contents);
  }

  public boolean containsByte(byte testByte) {
    for (byte content : contents) {
      if (content == testByte) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof DocDataFile) {
      DocDataFile otherFile = (DocDataFile) other;
      return this.getName().equals(otherFile.getName()) && Arrays
          .equals(this.getContents(), otherFile.getContents());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(contents);
  }
}


Java API for [OMX](https://github.com/osPlanning/omx)

# Examples
There are two examples:

```
java.exe -classpath omx.jar -Djava.library.path=./lib/win64/ omx.OMXTest

java.exe -classpath omx.jar -Djava.library.path=./lib/win64/ omx.OMXFile
```

# Required binaries

The binary libraries in /lib/ are required to run the model, and must be present on the java
 library path. For example, on a 64-bit window platform:

    java -classpath omx.jar -Djava.library.path=./lib/win64/ omx.OmxFile

# HDF5

Built with [HD5 2.8](http://www.hdfgroup.org/ftp/HDF5/releases/HDF-JAVA/HDF-JAVA-2.8/bin/)


